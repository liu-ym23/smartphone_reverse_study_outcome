package com.bytedance.apm.f;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: LaunchAnalysisContext.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "LaunchAnalysis";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f4600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm.trace.b.a f4601b;

    /* JADX INFO: renamed from: com.bytedance.apm.f.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: LaunchAnalysisContext.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.apm.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LaunchAnalysisContext.java */
    private static final class C0115a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f4602a = null;

        static /* synthetic */ a a() {
            return f4602a;
        }

        static {
            f4602a = new a(null);
        }
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    private a() {
    }

    public static a a() {
        return C0115a.a();
    }

    public synchronized void a(c r1) {
        monitor-enter(this);
        this.f4600a = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized c b() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f4600a != null) goto L6;
        this.f4600a = new c.a().f();     // Catch: Throwable -> L9
    L6:
        c r0 = this.f4600a;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized com.bytedance.apm.trace.b.a c() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f4601b != null) goto L6;
        this.f4601b = new com.bytedance.apm.trace.b.a.C0119a().a();     // Catch: Throwable -> L9
    L6:
        com.bytedance.apm.trace.b.a r0 = this.f4601b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public void a(String r2) {
        a(TAG, "notice!!!+ " + r2);
    }

    public void b(String r1) {
        if (com.bytedance.apm.c.i() == false) goto L6;
        b(TAG, r1);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
