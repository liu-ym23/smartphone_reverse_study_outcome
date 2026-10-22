package com.bytedance.anniex.bd.foundation.impl;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class s<K, V> implements lr3.a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<K, V> f190154a;

    public s() {
        this.f190154a = new ConcurrentHashMap();
    }

    @Override // lr3.a
    public boolean delete(K r100) {
        ConcurrentHashMap<K, V> r101 = this.f190154a;
        if (r101 == null) goto L10;
        if (TypeIntrinsics.asMutableMap(r101).remove(r100) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }
}
