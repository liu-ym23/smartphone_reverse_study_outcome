package com.squareup.moshi;

import a1.a;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class ClassJsonAdapter<T> extends JsonAdapter<T> {
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() { // from class: com.squareup.moshi.ClassJsonAdapter.1
        private void createFieldBindings(Moshi moshi, Type type, Map<String, FieldBinding<?>> map) throws SecurityException {
            Json json;
            Class<?> rawType = Types.getRawType(type);
            boolean zIsPlatformType = Util.isPlatformType(rawType);
            for (Field field : rawType.getDeclaredFields()) {
                if (includeField(zIsPlatformType, field.getModifiers()) && ((json = (Json) field.getAnnotation(Json.class)) == null || !json.ignore())) {
                    Type typeResolve = Util.resolve(type, rawType, field.getGenericType());
                    Set<? extends Annotation> setJsonAnnotations = Util.jsonAnnotations(field);
                    String name = field.getName();
                    JsonAdapter<T> jsonAdapterAdapter = moshi.adapter(typeResolve, setJsonAnnotations, name);
                    field.setAccessible(true);
                    String strJsonName = Util.jsonName(name, json);
                    FieldBinding<?> fieldBinding = new FieldBinding<>(strJsonName, field, jsonAdapterAdapter);
                    FieldBinding<?> fieldBindingPut = map.put(strJsonName, fieldBinding);
                    if (fieldBindingPut != null) {
                        throw new IllegalArgumentException("Conflicting fields:\n    " + fieldBindingPut.field + "\n    " + fieldBinding.field);
                    }
                }
            }
        }

        private boolean includeField(boolean z4, int i2) {
            if (Modifier.isStatic(i2) || Modifier.isTransient(i2)) {
                return false;
            }
            return Modifier.isPublic(i2) || Modifier.isProtected(i2) || !z4;
        }

        private void throwIfIsCollectionClass(Type type, Class<?> cls) {
            Class<?> rawType = Types.getRawType(type);
            if (cls.isAssignableFrom(rawType)) {
                throw new IllegalArgumentException("No JsonAdapter for " + type + ", you should probably use " + cls.getSimpleName() + " instead of " + rawType.getSimpleName() + " (Moshi only supports the collection interfaces by default) or else register a custom JsonAdapter.");
            }
        }

        @Override // com.squareup.moshi.JsonAdapter.Factory
        @Nullable
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException {
            if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
                return null;
            }
            Class<?> rawType = Types.getRawType(type);
            if (rawType.isInterface() || rawType.isEnum() || !set.isEmpty()) {
                return null;
            }
            if (Util.isPlatformType(rawType)) {
                throwIfIsCollectionClass(type, List.class);
                throwIfIsCollectionClass(type, Set.class);
                throwIfIsCollectionClass(type, Map.class);
                throwIfIsCollectionClass(type, Collection.class);
                String strG = a.g(rawType, "Platform ");
                if (type instanceof ParameterizedType) {
                    strG = strG + " in " + type;
                }
                throw new IllegalArgumentException(a.i(strG, " requires explicit JsonAdapter to be registered"));
            }
            if (rawType.isAnonymousClass()) {
                throw new IllegalArgumentException("Cannot serialize anonymous class ".concat(rawType.getName()));
            }
            if (rawType.isLocalClass()) {
                throw new IllegalArgumentException("Cannot serialize local class ".concat(rawType.getName()));
            }
            if (rawType.getEnclosingClass() != null && !Modifier.isStatic(rawType.getModifiers())) {
                throw new IllegalArgumentException("Cannot serialize non-static nested class ".concat(rawType.getName()));
            }
            if (Modifier.isAbstract(rawType.getModifiers())) {
                throw new IllegalArgumentException("Cannot serialize abstract class ".concat(rawType.getName()));
            }
            if (Util.isKotlin(rawType)) {
                throw new IllegalArgumentException("Cannot serialize Kotlin type " + rawType.getName() + ". Reflective serialization of Kotlin classes without using kotlin-reflect has undefined and unexpected behavior. Please use KotlinJsonAdapterFactory from the moshi-kotlin artifact or use code gen from the moshi-kotlin-codegen artifact.");
            }
            ClassFactory classFactory = ClassFactory.get(rawType);
            TreeMap treeMap = new TreeMap();
            while (type != Object.class) {
                createFieldBindings(moshi, type, treeMap);
                type = Types.getGenericSuperclass(type);
            }
            return new ClassJsonAdapter(classFactory, treeMap).nullSafe();
        }
    };
    private final ClassFactory<T> classFactory;
    private final FieldBinding<?>[] fieldsArray;
    private final JsonReader.Options options;

    public static class FieldBinding<T> {
        final JsonAdapter<T> adapter;
        final Field field;
        final String name;

        public FieldBinding(String str, Field field, JsonAdapter<T> jsonAdapter) {
            this.name = str;
            this.field = field;
            this.adapter = jsonAdapter;
        }

        public void read(JsonReader jsonReader, Object obj) throws IllegalAccessException, IllegalArgumentException {
            this.field.set(obj, this.adapter.fromJson(jsonReader));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IllegalArgumentException {
            this.adapter.toJson(jsonWriter, (JsonWriter) this.field.get(obj));
        }
    }

    public ClassJsonAdapter(ClassFactory<T> classFactory, Map<String, FieldBinding<?>> map) {
        this.classFactory = classFactory;
        this.fieldsArray = (FieldBinding[]) map.values().toArray(new FieldBinding[map.size()]);
        this.options = JsonReader.Options.of((String[]) map.keySet().toArray(new String[map.size()]));
    }

    @Override // com.squareup.moshi.JsonAdapter
    public T fromJson(JsonReader jsonReader) throws IllegalArgumentException {
        try {
            T tNewInstance = this.classFactory.newInstance();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    int iSelectName = jsonReader.selectName(this.options);
                    if (iSelectName == -1) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        this.fieldsArray[iSelectName].read(jsonReader, tNewInstance);
                    }
                }
                jsonReader.endObject();
                return tNewInstance;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        } catch (InstantiationException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw Util.rethrowCause(e11);
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter jsonWriter, T t2) throws IllegalArgumentException {
        try {
            jsonWriter.beginObject();
            for (FieldBinding<?> fieldBinding : this.fieldsArray) {
                jsonWriter.name(fieldBinding.name);
                fieldBinding.write(jsonWriter, t2);
            }
            jsonWriter.endObject();
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonAdapter(" + this.classFactory + ")";
    }
}
