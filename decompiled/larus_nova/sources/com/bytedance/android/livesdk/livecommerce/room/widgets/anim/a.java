package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f151987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f151988b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f151989c = null;

    public a() {
    }

    static {
        f151989c = new a();
        f151988b = new Handler(Looper.getMainLooper());
    }

    public final Handler a() {
        if (f151987a != null) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f151987a != null) goto L8;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("AnimWorkThread");     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L11
        f151987a = new Handler(r100.getLooper());     // Catch: Throwable -> L11
    L8:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
    L14:
        Handler r102 = f151987a;
        Intrinsics.checkNotNull(r102);
        return r102;
    }
}
