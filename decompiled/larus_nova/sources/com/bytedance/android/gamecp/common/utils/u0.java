package com.bytedance.android.gamecp.common.utils;

import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes44.dex */
public final class u0 extends AbstractList<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f57307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONArray f57308b;

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.f57307a;
    }

    public u0(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f57308b = r100;
        this.f57307a = r100.length();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int r100) {
        Object r101 = this.f57308b.opt(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return UtilsKt.a(r101);
    }
}
