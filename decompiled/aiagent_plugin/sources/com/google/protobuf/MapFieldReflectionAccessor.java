package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MapFieldReflectionAccessor {
    abstract List<Message> getList();

    abstract Message getMapEntryMessageDefaultInstance();

    abstract List<Message> getMutableList();

    public MapFieldReflectionAccessor() {
    }
}
