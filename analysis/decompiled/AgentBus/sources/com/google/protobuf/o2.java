package com.google.protobuf;

import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public interface o2 extends List, RandomAccess {
    boolean isModifiable();

    void makeImmutable();

    o2 mutableCopyWithCapacity(int i2);
}
