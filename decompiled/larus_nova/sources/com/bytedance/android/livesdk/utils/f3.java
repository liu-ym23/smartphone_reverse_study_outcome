package com.bytedance.android.livesdk.utils;

import io.reactivex.subjects.SingleSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f3 extends com.bytedance.android.livesdk.gift.platform.business.effect.assets.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleSubject f158948a;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o
    public final String d() {
        return "LiveAssetUtils.downloadAssets";
    }

    public f3(SingleSubject r100) {
        this.f158948a = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r100) {
        this.f158948a.onError(new Exception("operation canceled, id=" + r100));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        this.f158948a.onError(r100);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "path");
        super.c(r100, r101);
        this.f158948a.onSuccess(r101);
    }
}
