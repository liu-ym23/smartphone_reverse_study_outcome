package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;

/* JADX INFO: loaded from: classes45.dex */
public final class k0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0 f68340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Effect f68341b;

    public k0(l0 r100, Effect r101) {
        this.f68340a = r100;
        this.f68341b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o.c r100 = this.f68340a.f68342a;     // Catch: Throwable -> L10
        if (r100 != null) goto L5;
        return;
    L5:
        if (LiveEffectSettings.LIVE_EFFECT_FIX_STICKER_CONVERT_WITH_PANEL.getValue().booleanValue() == false) goto L7;
        Sticker r101 = com.bytedance.android.live.effect.sticker.d.d(this.f68341b, this.f68340a.f68343b);     // Catch: Throwable -> L10
    L8:
        r100.a(r101);     // Catch: Throwable -> L10
        return;
    L7:
        r101 = com.bytedance.android.live.effect.sticker.d.b(this.f68341b);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }
}
