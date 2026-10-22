package com.fasterxml.jackson.annotation;

/* JADX INFO: loaded from: classes2.dex */
public interface ObjectIdResolver {
    void bindItem(ObjectIdGenerator.IdKey r1, Object r2);

    boolean canUseFor(ObjectIdResolver r1);

    ObjectIdResolver newForDeserialization(Object r1);

    Object resolveId(ObjectIdGenerator.IdKey r1);
}
