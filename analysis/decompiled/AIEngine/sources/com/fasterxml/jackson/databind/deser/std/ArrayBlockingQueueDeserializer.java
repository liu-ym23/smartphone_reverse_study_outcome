package com.fasterxml.jackson.databind.deser.std;

import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import e3.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ArrayBlockingQueueDeserializer extends CollectionDeserializer {
    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        return bVar.c(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    public final Collection<Object> l0(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws JsonMappingException {
        if (collection == null) {
            collection = new ArrayList<>();
        }
        Collection<Object> collectionL0 = super.l0(jsonParser, deserializationContext, collection);
        return collectionL0.isEmpty() ? new ArrayBlockingQueue(1, false) : new ArrayBlockingQueue(collectionL0.size(), false, collectionL0);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    public final Collection<Object> m0(DeserializationContext deserializationContext) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    public final CollectionDeserializer o0(c cVar, c cVar2, b bVar, i iVar, Boolean bool) {
        return new ArrayBlockingQueueDeserializer(this.f3964d, cVar2, bVar, this.f3957m, cVar, iVar, bool);
    }
}
