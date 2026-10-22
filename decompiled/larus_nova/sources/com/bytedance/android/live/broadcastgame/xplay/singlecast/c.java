package com.bytedance.android.live.broadcastgame.xplay.singlecast;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements qz.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.xplay.littlewindow.b f62455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.xplay.servermergecast.a f62456b;

    public static final class a {
    }

    static {
    }

    public c(com.bytedance.android.live.broadcastgame.xplay.littlewindow.b r100, com.bytedance.android.live.broadcastgame.xplay.servermergecast.a r101) {
        Intrinsics.checkNotNullParameter(r100, "littleWindowService");
        Intrinsics.checkNotNullParameter(r101, "xplayLittleWindowCastManager");
        this.f62455a = r100;
        this.f62456b = r101;
        new CompositeDisposable();
    }
}
