package com.bytedance.android.ec.hybrid.list.entity;

import java.util.HashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f47100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f47101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f47102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap<String, String> f47103d;

    public f() {
    }

    public final f a() {
        Object r100 = super.clone();
        if (r100 == null) goto L7;
        return (f) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.hybrid.list.entity.ECHybridListLynxItemConfigVO");
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }
}
