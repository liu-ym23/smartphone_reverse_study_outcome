package com.bytedance.android.live.core.privacy.av.impl;

import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioAndVideoCallbackSystemImpl f65150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f65151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f65152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f65153d;

    public a(AudioAndVideoCallbackSystemImpl r100, String r101, Map r102, String r103) {
        this.f65150a = r100;
        this.f65151b = r101;
        this.f65152c = r102;
        this.f65153d = r103;
    }

    public final void a() {
        long r100 = System.currentTimeMillis() / ((long) 1000);     // Catch: Exception -> L7
        long r101 = r100 - ((long) 600);     // Catch: Exception -> L7
        IHostMonitor r102 = (IHostMonitor) k.f(IHostMonitor.class);     // Catch: Exception -> L7
        if (r102 == null) goto L12;
        r102.uploadALog(r101, r100, "audio_and_video_" + this.f65151b + '-' + this.f65153d);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        this.f65150a.f65148e.b("upload alog failed:" + e.getMessage(), null);
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
}
