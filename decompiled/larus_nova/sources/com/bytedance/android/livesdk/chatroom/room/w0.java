package com.bytedance.android.livesdk.chatroom.room;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class w0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f111167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f111168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f111169c;

    public final void a() {
        ALogger.i("RoomPreloadTaskManager", "real run task , task name: " + this.f111168b + ", id: " + this.f111169c);
        this.f111167a.run();
        com.bytedance.android.live.core.utils.i0.k(this.f111169c, this);
        com.bytedance.android.live.core.utils.i0.c().removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public w0(Runnable r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, DownloadHelper.IDENTITY);
        this.f111167a = r100;
        this.f111168b = r101;
        this.f111169c = r102;
    }
}
