package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
interface ListFieldSchema {
    void makeImmutableListAt(Object r1, long r2);

    <L> void mergeListsAt(Object r1, Object r2, long r3);

    <L> List<L> mutableListAt(Object r1, long r2);
}
