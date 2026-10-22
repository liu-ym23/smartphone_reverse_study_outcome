package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
abstract class CollectionJsonAdapter<C extends Collection<T>, T> extends JsonAdapter<C> {
    public static final JsonAdapter.Factory FACTORY = new JsonAdapter.Factory() { // from class: com.squareup.moshi.CollectionJsonAdapter.1
        @Override // com.squareup.moshi.JsonAdapter.Factory
        @Nullable
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Class<?> rawType = Types.getRawType(type);
            if (!set.isEmpty()) {
                return null;
            }
            if (rawType == List.class || rawType == Collection.class) {
                return CollectionJsonAdapter.newArrayListAdapter(type, moshi).nullSafe();
            }
            if (rawType == Set.class) {
                return CollectionJsonAdapter.newLinkedHashSetAdapter(type, moshi).nullSafe();
            }
            return null;
        }
    };
    private final JsonAdapter<T> elementAdapter;

    public static <T> JsonAdapter<Collection<T>> newArrayListAdapter(Type type, Moshi moshi) {
        return new CollectionJsonAdapter<Collection<T>, T>(moshi.adapter(Types.collectionElementType(type, Collection.class))) { // from class: com.squareup.moshi.CollectionJsonAdapter.2
            @Override // com.squareup.moshi.CollectionJsonAdapter, com.squareup.moshi.JsonAdapter
            public /* bridge */ /* synthetic */ Object fromJson(JsonReader jsonReader) {
                return super.fromJson(jsonReader);
            }

            @Override // com.squareup.moshi.CollectionJsonAdapter
            public Collection<T> newCollection() {
                return new ArrayList();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.squareup.moshi.CollectionJsonAdapter, com.squareup.moshi.JsonAdapter
            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) {
                super.toJson(jsonWriter, (JsonWriter) obj);
            }
        };
    }

    public static <T> JsonAdapter<Set<T>> newLinkedHashSetAdapter(Type type, Moshi moshi) {
        return new CollectionJsonAdapter<Set<T>, T>(moshi.adapter(Types.collectionElementType(type, Collection.class))) { // from class: com.squareup.moshi.CollectionJsonAdapter.3
            @Override // com.squareup.moshi.CollectionJsonAdapter, com.squareup.moshi.JsonAdapter
            public /* bridge */ /* synthetic */ Object fromJson(JsonReader jsonReader) {
                return super.fromJson(jsonReader);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.squareup.moshi.CollectionJsonAdapter, com.squareup.moshi.JsonAdapter
            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, Object obj) {
                super.toJson(jsonWriter, (JsonWriter) obj);
            }

            @Override // com.squareup.moshi.CollectionJsonAdapter
            public Set<T> newCollection() {
                return new LinkedHashSet();
            }
        };
    }

    public abstract C newCollection();

    public String toString() {
        return this.elementAdapter + ".collection()";
    }

    private CollectionJsonAdapter(JsonAdapter<T> jsonAdapter) {
        this.elementAdapter = jsonAdapter;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public C fromJson(JsonReader jsonReader) {
        C c10 = (C) newCollection();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            c10.add(this.elementAdapter.fromJson(jsonReader));
        }
        jsonReader.endArray();
        return c10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter jsonWriter, C c10) {
        jsonWriter.beginArray();
        Iterator it = c10.iterator();
        while (it.hasNext()) {
            this.elementAdapter.toJson(jsonWriter, (JsonWriter) it.next());
        }
        jsonWriter.endArray();
    }
}
