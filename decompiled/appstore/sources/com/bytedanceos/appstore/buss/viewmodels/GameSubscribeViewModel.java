package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import h7.d;
import kotlin.Lazy;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class GameSubscribeViewModel extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f8951e;

    public GameSubscribeViewModel(int r10) {
        this.f8950d = r10;
        this.f8951e = kotlin.b.b(GameSubscribeViewModel$gameSubscribeLiveData$2.INSTANCE);
        g();
    }

    public static final /* synthetic */ int f(GameSubscribeViewModel r10) {
        return r10.f8950d;
    }

    public final void g() {
        h.d(l0.a(this), null, null, new GameSubscribeViewModel$getGameSubscribe$1(this, null), 3, null);
    }

    public final MutableLiveData h() {
        return (MutableLiveData) this.f8951e.getValue();
    }
}
