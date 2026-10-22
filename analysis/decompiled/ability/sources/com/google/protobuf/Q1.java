package com.google.protobuf;

import java.util.Map;

/* loaded from: classes3.dex */
public interface Q1 {
    Map forMapData(Object obj);

    u1.d forMapMetadata(Object obj);

    Map forMutableMapData(Object obj);

    int getSerializedSize(int i, Object obj, Object obj2);

    boolean isImmutable(Object obj);

    Object mergeFrom(Object obj, Object obj2);

    Object newMapField(Object obj);

    Object toImmutable(Object obj);
}
