package com.bytedance.android.shopping.deepfeed.weights;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.larus.apm.impl.protector.RunnableProtector;
import he3.v;
import kotlin.Pair;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductInfoExtraView f174236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InFeedProductV2 f174237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.deepfeed.action.h f174238c;

    public m(DeepFeedProductInfoExtraView r100, InFeedProductV2 r101, com.bytedance.android.shopping.deepfeed.action.h r102) {
        this.f174236a = r100;
        this.f174237b = r101;
        this.f174238c = r102;
    }

    public final void a() {
        if (this.f174236a.getBottom() > 0) goto L5;
        return;
    L5:
        if (this.f174236a.getRight() <= 0) goto L15;
        InFeedProductV2 r100 = this.f174237b;
        if (r100 == null) goto L16;
        v r101 = r100.getDynamicData();
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.f484843e != true) goto L18;
        int r102 = com.bytedance.android.shopping.deepfeed.utlis.k.f173989a;
        Pair r103 = com.bytedance.android.shopping.deepfeed.utlis.k.b(this.f174236a);
        com.bytedance.android.shopping.deepfeed.action.h r104 = this.f174238c;
        ((Number) r103.getFirst()).intValue();
        this.f174236a.getWidth();
        ((Number) r103.getSecond()).intValue();
        com.bytedance.android.shopping.extensions.b.b(8);
        r104.o();
        return;
    L18:
        return;
    L16:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
