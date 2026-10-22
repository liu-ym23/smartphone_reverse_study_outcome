package com.bytedance.android.livesdk.service;

import com.bytedance.android.live.room.u;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes11.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile l f158004a;

    public l() {
    }

    public static l d() {
        if (f158004a != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f158004a != null) goto L9;
        f158004a = new l();     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f158004a;
    }

    public final ILiveActionHandler a() {
        return (ILiveActionHandler) k.b(ILiveActionHandler.class);
    }

    public final g b() {
        return (g) k.b(g.class);
    }

    public final Gson c() {
        return (Gson) k.b(Gson.class);
    }

    public final ILiveRecordService e() {
        return (ILiveRecordService) k.b(ILiveRecordService.class);
    }

    public final u f() {
        return (u) k.b(u.class);
    }
}
