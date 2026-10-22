package com.bytedance.android.live.liveinteract.plantform.utils;

import android.view.KeyEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class l0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f77494a;

    public l0(m0 r100) {
        this.f77494a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.event.a r101 = (com.bytedance.android.livesdk.event.a) r100;
        if (r101 == null) goto L32;
        m0 r102 = this.f77494a;
        if (r102.a() == true) goto L40;
        float r103 = r102.f77498a.getStreamVolume(0) / r102.f77498a.getStreamMaxVolume(0);
        KeyEvent r104 = r101.f123316c;
        if (r104 == null) goto L10;
        Integer r105 = Integer.valueOf(r104.getKeyCode());
    L11:
        if (r105 != null) goto L14;
    L22:
        if (r105 != null) goto L25;
        return;
    L25:
        if (r105.intValue() != 25) goto L37;
        int r106 = r102.f77499b;
        if (r106 <= 100) goto L38;
        int r107 = r106 - r102.f77500c;
        r102.f77499b = r107;
        hg6.g r108 = r102.f77505h;
        if (r108 == null) goto L39;
        r108.d(r107);
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L14:
        if (r105.intValue() != 24) goto L22;
        if (r103 < 0.5f) goto L33;
        int r109 = r102.f77499b;
        if (r109 >= 180) goto L34;
        int r110 = r109 + r102.f77500c;
        r102.f77499b = r110;
        hg6.g r111 = r102.f77505h;
        if (r111 == null) goto L35;
        r111.d(r110);
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L10:
        r105 = null;
        goto L11
    L40:
        return;
    }
}
