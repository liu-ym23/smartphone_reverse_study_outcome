package com.bytedance.android.live.broadcastgame.opengame;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f60117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile vlc.d f60118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f60119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f60120d;

    public final synchronized void b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f60117a <= 0) goto L10;
        this.f60117a--;     // Catch: Throwable -> L12
        if (this.f60117a != 0) goto L10;
        int r100 = q.f60744a;     // Catch: Throwable -> L12
        q.g("停止接收游戏IM", "");     // Catch: Throwable -> L12
        vlc.d r101 = this.f60118b;     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        r101.r(true);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    public final Context getContext() {
        return this.f60119c;
    }

    public final synchronized vlc.d a(boolean r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f60118b != null) goto L6;
        int r101 = r10.a.f535602a;     // Catch: Throwable -> L9
        vlc.d r102 = r10.a.a(this.f60119c, this.f60120d, r100);     // Catch: Throwable -> L9
        int r103 = q.f60744a;     // Catch: Throwable -> L9
        q.g("游戏IM通道创建", "");     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
        this.f60118b = r102;     // Catch: Throwable -> L9
    L6:
        vlc.d r105 = this.f60118b;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r105;
    }

    public f(Context r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f60119c = r100;
        this.f60120d = r101;
    }
}
