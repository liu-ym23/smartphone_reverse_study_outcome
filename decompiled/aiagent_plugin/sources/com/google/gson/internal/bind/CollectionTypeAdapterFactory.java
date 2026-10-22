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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final ObjectConstructor<? extends Collection<E>> constructor;
        private final TypeAdapter<E> elementTypeAdapter;

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object read(JsonReader r1) {
            return read(r1);
        }

        @Override // com.google.gson.TypeAdapter
        public /* synthetic */ void write(JsonWriter r3, Object r4) {
            write(r3, (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin"));
        }

        public Adapter(Gson r3, Type r4, TypeAdapter<E> r5, ObjectConstructor<? extends Collection<E>> r6) {
            Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
            ObjectConstructor<? extends Collection<E>> r8 = (ObjectConstructor) ZeusTransformUtils.wrapperContextForParams(r6, ObjectConstructor.class, "com.obric.aiagent.plugin");
            this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper(r3, r5, r7);
            this.constructor = r8;
        }

        @Override // com.google.gson.TypeAdapter
        public Collection<E> read(JsonReader r4) {
            if (r4.peek() != JsonToken.NULL) goto L6;
            r4.nextNull();
            return null;
        L6:
            Collection<E> r0 = (Collection) ZeusTransformUtils.preCheckCast(this.constructor.construct(), Collection.class, "com.obric.aiagent.plugin");
            r4.beginArray();
        L8:
            if (r4.hasNext() == false) goto L10;
            r0.add(this.elementTypeAdapter.read(r4));
            goto L8
        L10:
            r4.endArray();
            return r0;
        }

        public void write(JsonWriter r3, Collection<E> r4) {
            Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L6;
            r3.nullValue();
            return;
        L6:
            r3.beginArray();
            Iterator<E> r6 = r5.iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            E r0 = r6.next();
            this.elementTypeAdapter.write(r3, r0);
            goto L8
        L10:
            r3.endArray();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor r1) {
        this.constructorConstructor = r1;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r4, TypeToken<T> r5) {
        Type r0 = r5.getType();
        Class<? super T> r1 = r5.getRawType();
        if (Collection.class.isAssignableFrom(r1) == true) goto L6;
        return null;
    L6:
        Type r2 = C$Gson$Types.getCollectionElementType(r0, r1);
        return new Adapter(r4, r2, r4.getAdapter(TypeToken.get(r2)), this.constructorConstructor.get(r5));
    }
}
