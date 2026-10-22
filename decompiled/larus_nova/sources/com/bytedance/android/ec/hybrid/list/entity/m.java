package com.bytedance.android.ec.hybrid.list.entity;

/* JADX INFO: loaded from: classes44.dex */
public final class m implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f47137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f47138b;

    public m() {
    }

    public final m a() {
        Object r100 = super.clone();
        if (r100 == null) goto L7;
        return (m) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.hybrid.list.entity.ECParamsFromClientVO");
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }
}
