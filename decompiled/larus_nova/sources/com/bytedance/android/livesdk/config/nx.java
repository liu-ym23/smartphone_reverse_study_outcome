package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.paas.HostInfoPresenter;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
public final class nx extends SSettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nx f120866a = null;

    static {
        f120866a = new nx();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlin.Unit] */
    public nx() {
        int r100 = HostInfoPresenter.f154199a;
        kjc.c r101 = new kjc.c();
        if (r101.f503731b == true) goto L5;
        kjc.b<T> r102 = r101.f503730a;
        r102.f503729a = Unit.INSTANCE;
    L5:
        T r103 = r101.f503730a.f503729a;
        super("live_full_screen_recharge_url", "", "火山全屏充值地址");
    }
}
