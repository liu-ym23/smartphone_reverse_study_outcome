package com.bytedance.android.shopping.hybrid.bridges;

import cg3.j;
import cg3.k;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECOpenVideoPreviewPanelMethod f176220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cg3.g f176221b;

    public b(ECOpenVideoPreviewPanelMethod r100, cg3.g r101) {
        this.f176220a = r100;
        this.f176221b = r101;
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r110) {
        j r101 = (j) r100;
        final cg3.c r111 = (cg3.c) r110;
        Intrinsics.checkNotNullParameter(r101, "videoResponse");
        Intrinsics.checkNotNullParameter(r111, "commentPublishModel");
        cg3.e r102 = r111.f23657a;
        List<cg3.f> r103 = this.f176221b.f23662d;
        if (r103 == null) goto L5;
        cg3.f r104 = (cg3.f) CollectionsKt.firstOrNull(r103);
    L7:
        return new k(r102, r104, r101.f23664a, r101.f23665b, null, new ECOpenVideoPreviewPanelMethod$publishVideo$disposable$1$1(this, r111));
    L5:
        r104 = null;
        goto L7
    }
}
