package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftListCacheRepo f128341a;

    public g(GiftListCacheRepo r100) {
        this.f128341a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        GiftListCacheRepo r101 = this.f128341a;
        GiftListCacheRepo.a(r101, (Map) r100);
    }
}
