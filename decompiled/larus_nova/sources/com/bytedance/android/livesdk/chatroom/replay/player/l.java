package com.bytedance.android.livesdk.chatroom.replay.player;

import android.content.Context;
import android.os.Bundle;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.model.VideoModel;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f109594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoModel f109595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f109596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f109597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f109598e;

    public l(k r100, VideoModel r101, Context r102, Bundle r103, long r104) {
        this.f109594a = r100;
        this.f109595b = r101;
        this.f109596c = r102;
        this.f109597d = r103;
        this.f109598e = r104;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r100 = this.f109594a;     // Catch: Throwable -> L4
        VideoModel r101 = this.f109595b;     // Catch: Throwable -> L4
        Context r102 = this.f109596c;     // Catch: Throwable -> L4
        Bundle r103 = this.f109597d;     // Catch: Throwable -> L4
        long r104 = this.f109598e;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        k.h(r101, r102, r103, r104);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
