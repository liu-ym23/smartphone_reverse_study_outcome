package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final ObjectConstructor<? extends Collection<E>> constructor;
        private final TypeAdapter<E> elementTypeAdapter;

        public Adapter(Gson r10, Type r11, TypeAdapter<E> r12, ObjectConstructor<? extends Collection<E>> r13) {
            this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper(r10, r12, r11);
            this.constructor = r13;
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object read(JsonReader r10) throws IOException {
            return read(r10);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter r10, Object r11) throws IOException {
            write(r10, (Collection) r11);
        }

        @Override // com.google.gson.TypeAdapter
        public Collection<E> read(JsonReader r10) throws IOException {
            if (r10.peek() != JsonToken.NULL) goto L6;
            r10.nextNull();
            return null;
        L6:
            Collection<E> r11 = this.constructor.construct();
            r10.beginArray();
        L8:
            if (r10.hasNext() == false) goto L10;
            r11.add(this.elementTypeAdapter.read(r10));
            goto L8
        L10:
            r10.endArray();
            return r11;
        }

        public void write(JsonWriter r10, Collection<E> r11) throws IOException {
            if (r11 != null) goto L5;
            r10.nullValue();
            return;
        L5:
            r10.beginArray();
            Iterator<E> r12 = r11.iterator();
        L7:
            if (r12.hasNext() == false) goto L9;
            E r13 = r12.next();
            this.elementTypeAdapter.write(r10, r13);
            goto L7
        L9:
            r10.endArray();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor r10) {
        this.constructorConstructor = r10;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r10, TypeToken<T> r11) {
        Type r12 = r11.getType();
        Class<? super T> r13 = r11.getRawType();
        if (Collection.class.isAssignableFrom(r13) == true) goto L6;
        return null;
    L6:
        Type r14 = C$Gson$Types.getCollectionElementType(r12, r13);
        return new Adapter(r10, r14, r10.getAdapter(TypeToken.get(r14)), this.constructorConstructor.get(r11));
    }
}
