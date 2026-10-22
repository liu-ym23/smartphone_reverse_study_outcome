package com.bytedance.android.annie.param;

import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes43.dex */
public final class o extends AbstractList<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONArray f39713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f39714b;

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.f39714b;
    }

    public o(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f39713a = r100;
        this.f39714b = r100.length();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int r100) {
        Object r101 = this.f39713a.opt(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return UtilsKt.b(r101);
    }
}
