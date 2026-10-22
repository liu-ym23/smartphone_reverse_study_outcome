package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;
import oc6.m0;

/* JADX INFO: loaded from: classes9.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f127321a;

    public s(u r100) {
        this.f127321a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        BehaviorSubject<m0> r102 = this.f127321a.f127326g;
        m0 r103 = new m0();
        r103.b(this.f127321a.k());
        Unit r104 = Unit.INSTANCE;
        r102.onNext(r103);
        this.f127321a.g("observeWalletInfo", new GiftRechargeDataStore$observeWalletInfo$1$2(this));
    }
}
