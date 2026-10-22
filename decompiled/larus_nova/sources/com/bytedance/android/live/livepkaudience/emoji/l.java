package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f81961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f81962b;

    public l(d r100, String r101) {
        this.f81961a = r100;
        this.f81962b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f81961a.f81936c = false;
        com.bytedance.android.live.liveinteract.plantform.utils.x.E0(this.f81962b.toString(), r101, LiveCommonConstants.REASON_SELF_PANEL);
        d.a r102 = (d.a) this.f81961a.f531633a;
        if (r102 == null) goto L6;
        r102.r(this.f81962b, r101);
        return;
    }
}
