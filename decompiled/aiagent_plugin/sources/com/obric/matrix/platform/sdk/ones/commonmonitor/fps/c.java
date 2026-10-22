package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.SystemClock;
import com.bytedance.apm.trace.fps.FpsTracer;
import d.h.b.h;

/* JADX INFO: compiled from: FPSSceneMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final String TAG = "FPSSceneMonitor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33653a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FpsTracer f33654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f33655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f33656d;

    /* JADX INFO: compiled from: FPSSceneMonitor.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f33653a = new a(null);
    }

    public final void a() {
        if (this.f33656d <= 0) goto L6;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d(TAG, "start: already start", null, 4, null);
        return;
    L6:
        this.f33656d = SystemClock.elapsedRealtime();
        this.f33654b.a();
    }

    public final void b() {
        if (this.f33656d > 0) goto L6;
        com.obric.matrix.platform.sdk.ones.internal.b.b.d(TAG, "stop: not start", null, 4, null);
        return;
    L6:
        d r0 = d.f33657a.a();
        r0.a(SystemClock.elapsedRealtime() - this.f33656d);
        this.f33655c = r0;
        this.f33654b.b();
        this.f33656d = 0;
    }
}
