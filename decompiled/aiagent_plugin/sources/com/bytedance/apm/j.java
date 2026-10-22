package com.bytedance.apm;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MonitorCoreExceptionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    private static final String TAG = "apm_";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f4704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashSet<String> f4705b;

    /* JADX INFO: compiled from: MonitorCoreExceptionManager.java */
    public interface a {
        void a(String r1);

        void a(Throwable r1, String r2);

        void b(Throwable r1, String r2);
    }

    /* JADX INFO: compiled from: MonitorCoreExceptionManager.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final j f4707a = null;

        static /* synthetic */ j a() {
            return f4707a;
        }

        static {
            f4707a = new j(null);
        }
    }

    /* synthetic */ j(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ a a(j r0) {
        return r0.f4704a;
    }

    private j() {
        this.f4705b = new HashSet();
    }

    public static j a() {
        return b.a();
    }

    public void a(a r3) {
        this.f4704a = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        b();
    }

    private void b() {
        com.bytedance.monitor.a.b.c.a().a(new AnonymousClass1(this));
    }

    public void a(Throwable r3, String r4) {
        if (this.f4704a == null) goto L8;
        if (this.f4705b.contains(r4) == true) goto L8;
        this.f4705b.add(r4);
        this.f4704a.a(r3, TAG + r4);
    L8:
        if (c.i() == false) goto L11;
        r3.printStackTrace();
        return;
    }

    public void b(Throwable r1, String r2) {
        a r0 = this.f4704a;     // Catch: Throwable -> L12
        if (r0 == null) goto L6;
        r0.b(r1, r2);     // Catch: Throwable -> L12
    L6:
        if (c.i() == true) goto L11;
        if (c.l() == true) goto L11;
        return;
    L11:
        throw new RuntimeException(r1);
    }

    public void a(String r3) {
        if (this.f4704a == null) goto L8;
        if (this.f4705b.contains(r3) == true) goto L8;
        this.f4705b.add(r3);
        this.f4704a.a(TAG + r3);
    L8:
        if (c.i() == false) goto L11;
        a(TAG, "ensureNotReachHere", new RuntimeException(r3));
        System.exit(1);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
