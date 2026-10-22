package com.obric.matrix.platform.sdk.ones.commonmonitor.applaunch;

import android.app.Application;
import android.os.SystemClock;
import com.obric.matrix.platform.sdk.ones.dataanalysis.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: AppLaunchMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "AppLaunchMonitor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0908a f33633a = null;
    private static final a j = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f33634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f33635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f33636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f33637e;
    private final LinkedHashMap<String, Long> f;
    private final LinkedHashMap<String, Long> g;
    private String h;
    private final Application.ActivityLifecycleCallbacks i;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.commonmonitor.applaunch.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppLaunchMonitor.kt */
    public static final class C0908a {
        public /* synthetic */ C0908a(h r1) {
            this();
        }

        private C0908a() {
        }
    }

    private a() {
        this.f33634b = -1;
        this.f33635c = -1;
        this.f33637e = 1;
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.h = "";
        this.i = (Application.ActivityLifecycleCallbacks) ZeusTransformUtils.preCheckCast(new AppLaunchMonitor$sActivityLifecycleCallbacks$1(this), Application.ActivityLifecycleCallbacks.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ String a(a r0) {
        return r0.h;
    }

    public static final /* synthetic */ void a(a r0, long r1) {
        r0.f33634b = r1;
    }

    public static final /* synthetic */ long b(a r2) {
        return r2.f33634b;
    }

    public static final /* synthetic */ void c(a r0) {
        r0.a();
    }

    static {
        f33633a = new C0908a(null);
        j = new a();
    }

    private final void a() {
        if (this.f33636d == false) goto L6;
        return;
    L6:
        if (b.f33638a.d() == false) goto L11;
        this.f33636d = true;
        long r0 = SystemClock.elapsedRealtime() - this.f33634b;
        if (r0 >= 10000) goto L12;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c(TAG, "reportDuration: " + r0, null, 4, null);
        c.f33671a.a().a(r0);
        return;
    L12:
        return;
    }
}
