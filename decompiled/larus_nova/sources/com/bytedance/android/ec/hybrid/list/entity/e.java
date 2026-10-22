package com.bytedance.android.ec.hybrid.list.entity;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Double f47097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Float> f47098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f47099c;

    public e() {
    }

    public final e a() {
        Object r100 = super.clone();
        if (r100 == null) goto L11;
        e r101 = (e) r100;
        List<Float> r102 = this.f47098b;
        if (r102 == null) goto L7;
        List<Float> r103 = CollectionsKt.toList(r102);
    L8:
        r101.f47098b = r103;
        return r101;
    L7:
        r103 = null;
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemStyleVO");
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }
}
