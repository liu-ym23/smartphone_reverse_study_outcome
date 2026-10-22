package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftListCacheRepo f128343a;

    public h(GiftListCacheRepo r100) {
        this.f128343a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "error");
        Logger.e("GIFT_MANAGER", r101.getMessage());
        this.f128343a.f128282b = false;
    }
}
