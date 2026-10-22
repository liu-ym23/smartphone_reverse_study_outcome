package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private static final TypeAdapterFactory TREE_TYPE_CLASS_DUMMY_FACTORY = null;
    private static final TypeAdapterFactory TREE_TYPE_FIELD_DUMMY_FACTORY = null;
    private final ConcurrentMap<Class<?>, TypeAdapterFactory> adapterFactoryMap;
    private final ConstructorConstructor constructorConstructor;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class DummyTypeAdapterFactory implements TypeAdapterFactory {
        private DummyTypeAdapterFactory() {
        }

        /* synthetic */ DummyTypeAdapterFactory(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson r1, TypeToken<T> r2) {
            throw new AssertionError("Factory should not be used");
        }
    }

    static {
        AnonymousClass1 r1 = null;
        TREE_TYPE_CLASS_DUMMY_FACTORY = new DummyTypeAdapterFactory(r1);
        TREE_TYPE_FIELD_DUMMY_FACTORY = new DummyTypeAdapterFactory(r1);
    }

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor r1) {
        this.constructorConstructor = r1;
        this.adapterFactoryMap = new ConcurrentHashMap();
    }

    private static JsonAdapter getAnnotation(Class<?> r1) {
        return (JsonAdapter) r1.getAnnotation(JsonAdapter.class);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r8, TypeToken<T> r9) {
        JsonAdapter r5 = getAnnotation(r9.getRawType());
        if (r5 != null) goto L7;
        return null;
    L7:
        return (TypeAdapter<T>) getTypeAdapter(this.constructorConstructor, r8, r9, r5, true);
    }

    private static Object createAdapter(ConstructorConstructor r0, Class<?> r1) {
        return r0.get(TypeToken.get(r1)).construct();
    }

    private TypeAdapterFactory putFactoryAndGetCurrent(Class<?> r1, TypeAdapterFactory r2) {
        TypeAdapterFactory r0 = this.adapterFactoryMap.putIfAbsent(r1, r2);
        if (r0 != null) goto L5;
        return r2;
    L5:
        return r0;
    }

    TypeAdapter<?> getTypeAdapter(ConstructorConstructor r8, Gson r9, TypeToken<?> r10, JsonAdapter r11, boolean r12) {
        Object r13 = createAdapter(r8, r11.value());
        boolean r6 = r11.nullSafe();
        if ((r13 instanceof TypeAdapter) == false) goto L6;
        TypeAdapter<?> r14 = (TypeAdapter) r13;
    L30:
        if (r14 == null) goto L34;
        if (r6 == true) goto L33;
        return r14;
    L33:
        return r14.nullSafe();
    L34:
        return r14;
    L6:
        if ((r13 instanceof TypeAdapterFactory) == false) goto L11;
        TypeAdapterFactory r15 = (TypeAdapterFactory) r13;
        if (r12 == false) goto L10;
        r15 = putFactoryAndGetCurrent(r10.getRawType(), r15);
    L10:
        r14 = r15.create(r9, r10);
        goto L30
    L11:
        boolean r7 = r13 instanceof JsonSerializer;
        if (r7 == true) goto L19;
        if ((r13 instanceof JsonDeserializer) == true) goto L19;
        throw new IllegalArgumentException("Invalid attempt to bind an instance of " + r13.getClass().getName() + " as a @JsonAdapter for " + r10.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
    L19:
        if (r7 == false) goto L21;
        JsonSerializer r1 = (JsonSerializer) r13;
    L23:
        if ((r13 instanceof JsonDeserializer) == false) goto L25;
        JsonDeserializer r2 = (JsonDeserializer) r13;
    L26:
        if (r12 == false) goto L28;
        TypeAdapterFactory r16 = TREE_TYPE_CLASS_DUMMY_FACTORY;
    L29:
        r14 = new TreeTypeAdapter(r1, r2, r9, r10, r16, r6);
        r6 = false;
        goto L30
    L28:
        r16 = TREE_TYPE_FIELD_DUMMY_FACTORY;
        goto L29
    L25:
        r2 = null;
        goto L26
    L21:
        r1 = null;
        goto L23
    }

    public boolean isClassJsonAdapterFactory(TypeToken<?> r5, TypeAdapterFactory r6) {
        Objects.requireNonNull(r5);
        Objects.requireNonNull(r6);
        if (r6 != TREE_TYPE_CLASS_DUMMY_FACTORY) goto L5;
        return true;
    L5:
        Class<? super Object> r7 = r5.getRawType();
        TypeAdapterFactory r0 = this.adapterFactoryMap.get(r7);
        if (r0 == null) goto L11;
        if (r0 != r6) goto L10;
        return true;
    L10:
        return false;
    L11:
        JsonAdapter r1 = getAnnotation(r7);
        if (r1 != null) goto L14;
        return false;
    L14:
        Class<?> r2 = r1.value();
        if (TypeAdapterFactory.class.isAssignableFrom(r2) == true) goto L18;
        return false;
    L18:
        if (putFactoryAndGetCurrent(r7, (TypeAdapterFactory) createAdapter(this.constructorConstructor, r2)) != r6) goto L21;
        return true;
    L21:
        return false;
    }
}
