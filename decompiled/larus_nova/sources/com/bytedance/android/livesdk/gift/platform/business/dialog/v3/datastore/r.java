package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;
import oc6.m0;

/* JADX INFO: loaded from: classes9.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f127320a;

    public r(u r100) {
        this.f127320a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ds2.d r101 = (ds2.d) r100;
        BehaviorSubject<m0> r102 = this.f127320a.f127326g;
        m0 r103 = new m0();
        r103.b(this.f127320a.k());
        Unit r104 = Unit.INSTANCE;
        r102.onNext(r103);
        this.f127320a.g("observeLoginEvent", new GiftRechargeDataStore$observeLoginEvent$2$2(this));
    }
}
