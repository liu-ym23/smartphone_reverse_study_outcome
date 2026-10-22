package com.bytedance.android.gamecp.common.monitor_v1;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f56616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f56617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f56618c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f56619a;

        public a(j r100) {
            this.f56619a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            FMPMonitorTracker.f56555g.p((String) this.f56619a.f56616a.element, "time_out");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public j(Ref.ObjectRef r100, String r101, long r102) {
        this.f56616a = r100;
        this.f56617b = r101;
        this.f56618c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        com.bytedance.android.gamecp.base.cache.c<String, FMPMonitorTracker.b> r100 = FMPMonitorTracker.f56549a;
        com.bytedance.android.gamecp.base.cache.c<String, FMPMonitorTracker.b> r101 = FMPMonitorTracker.f56549a;
        String r102 = (String) this.f56616a.element;
        r101.b(r102, new FMPMonitorTracker.b(r102, this.f56617b, this.f56618c));
        a r103 = new a(this);
        FMPMonitorTracker.f56552d.put((String) this.f56616a.element, r103);
        FMPMonitorTracker.e().postDelayed(r103, 20000 - (SystemClock.elapsedRealtime() - this.f56618c));
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
