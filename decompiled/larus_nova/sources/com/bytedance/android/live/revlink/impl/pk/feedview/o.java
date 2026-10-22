package com.bytedance.android.live.revlink.impl.pk.feedview;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes47.dex */
public final class o<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f96613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c f96614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b f96615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CompositeDisposable f96616d;

    public o(MediatorLiveData r100, com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c r101, com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r102, CompositeDisposable r103) {
        this.f96613a = r100;
        this.f96614b = r101;
        this.f96615c = r102;
        this.f96616d = r103;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        com.bytedance.android.live.revlink.impl.pk.feedview.machine.l r101 = (com.bytedance.android.live.revlink.impl.pk.feedview.machine.l) r100;
        com.bytedance.android.live.revlink.impl.pk.feedview.machine.l r102 = this.f96614b.f96458e.getValue();
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.f96579b);
    L7:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97568m.d() == false) goto L10;
        if (r103 == null) goto L12;
        RxUtilKt.c(Observable.just(r103).map(new m(this)).subscribe(new n(this), p.f96617a), this.f96616d);
        return;
    L12:
        return;
    L10:
        this.f96613a.setValue(q.a(r103, this.f96614b, this.f96615c));
        return;
    L5:
        r103 = null;
        goto L7
    }
}
