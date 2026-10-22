package com.bytedance.android.ec.hybrid.list;

import com.bytedance.android.ec.hybrid.data.entity.ECPreloadConfigItemV3;
import com.bytedance.android.ec.hybrid.list.util.i;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Stack;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridListAdapter$preLoadOneCard$2 extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ECHybridListAdapter f46863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f46864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ECPreloadConfigItemV3 f46865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Stack f46866f;

    @Override // java.lang.Runnable
    public final void run() {
        ECHybridListAdapter r100 = this.f46863c;     // Catch: Throwable -> L4
        String r101 = this.f46864d;     // Catch: Throwable -> L4
        ECPreloadConfigItemV3 r102 = this.f46865e;     // Catch: Throwable -> L4
        int r103 = ECHybridListAdapter.f46839w;     // Catch: Throwable -> L4
        r100.G2(r101, r100.E2(r102), new ECHybridListAdapter$preLoadOneCard$2$run$1(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ECHybridListAdapter$preLoadOneCard$2(ECHybridListAdapter r100, String r101, ECPreloadConfigItemV3 r102, Stack r103) {
        this.f46863c = r100;
        this.f46864d = r101;
        this.f46865e = r102;
        this.f46866f = r103;
        super("preload lynx_card");
    }
}
