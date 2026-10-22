package com.bytedance.android.live.browser;

import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes45.dex */
public final class f0 extends AbstractList<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f62636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONArray f62637b;

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.f62636a;
    }

    public f0(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f62637b = r100;
        this.f62636a = r100.length();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int r100) {
        Object r101 = this.f62637b.opt(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return UtilsKt.a(r101);
    }
}
