package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftClientAIIntegratedService implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f131256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f131257b;

    public static final class a {
    }

    public static final class b implements wp2.l {
        public b() {
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (((com.bytedance.android.livesdk.gift.configmodel.d2) this.f131257b.getValue()).a() == false) goto L5;
    L6:
        this.f131256a = true;
        ((rq2.a) vh6.c.b(rq2.a.class)).r2(new b());
        return;
    L5:
        if (((com.bytedance.android.livesdk.gift.configmodel.d2) this.f131257b.getValue()).c() == true) goto L6;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        if (this.f131256a == true) goto L5;
        return;
    L5:
        ((rq2.a) vh6.c.b(rq2.a.class)).removeGiftAssetDownloadCallback();
    }

    public GiftClientAIIntegratedService(e1 r100) {
        Intrinsics.checkNotNullParameter(r100, "giftListService");
        this.f131257b = LazyKt.lazy(GiftClientAIIntegratedService$liveGiftListPreloadConfig$2.INSTANCE);
    }
}
