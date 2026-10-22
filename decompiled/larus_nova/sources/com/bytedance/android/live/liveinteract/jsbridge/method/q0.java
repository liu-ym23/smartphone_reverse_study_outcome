package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class q0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f74244a;

    public q0(s0 r100) {
        this.f74244a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        s0.k(this.f74244a);
        ALogger.d("OneKeyOpenSceneAndPlayModeMethod", "openFloat1V6Window.success");
    }
}
