package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftListCacheRepo f128358a;

    public j(GiftListCacheRepo r100) {
        this.f128358a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        GiftListCacheRepo r101 = this.f128358a;
        GiftListCacheRepo.a(r101, (Map) r100);
    }
}
