package com.bytedance.apm;

import android.util.Log;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import java.util.HashSet;
import java.util.Map;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class MonitorCoreExceptionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExceptionCallBack f6346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashSet f6347b;

    public interface ExceptionCallBack {
        void directReportError(Throwable r10, String r11);

        void ensureNotReachHere(String r10);

        void ensureNotReachHere(Throwable r10, String r11);

        void ensureNotReachHere(Throwable r10, String r11, Map<String, String> r12);
    }

    public class a implements IAsyncTaskManager.ExceptionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MonitorCoreExceptionManager f6348a;

        public a(MonitorCoreExceptionManager r10) {
            this.f6348a = r10;
        }

        @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager.ExceptionListener
        public void directReportError(Throwable r10, String r11) {
            if (MonitorCoreExceptionManager.a(this.f6348a) == null) goto L6;
            MonitorCoreExceptionManager.a(this.f6348a).directReportError(r10, r11);
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MonitorCoreExceptionManager f6349a = null;

        static {
            f6349a = new MonitorCoreExceptionManager(null);
        }

        public static /* synthetic */ MonitorCoreExceptionManager a() {
            return f6349a;
        }
    }

    public /* synthetic */ MonitorCoreExceptionManager(a r10) {
        this();
    }

    public static /* synthetic */ ExceptionCallBack a(MonitorCoreExceptionManager r10) {
        return r10.f6346a;
    }

    public static MonitorCoreExceptionManager e() {
        return b.a();
    }

    public void b(Throwable r10, String r11) {
        ExceptionCallBack r12 = this.f6346a;     // Catch: Throwable -> L12
        if (r12 == null) goto L6;
        r12.directReportError(r10, r11);     // Catch: Throwable -> L12
    L6:
        if (c.B() == true) goto L11;
        if (c.E() == true) goto L11;
        return;
    L11:
        throw new RuntimeException(r10);
    }

    public void c(String r10) {
        if (this.f6346a == null) goto L8;
        if (this.f6347b.contains(r10) == true) goto L8;
        this.f6347b.add(r10);
        this.f6346a.ensureNotReachHere("apm_" + r10);
    L8:
        if (c.B() == false) goto L11;
        Log.e("apm_", "ensureNotReachHere", new RuntimeException(r10));
        System.exit(1);
        return;
    }

    public void d(Throwable r10, String r11) {
        if (this.f6346a == null) goto L8;
        if (this.f6347b.contains(r11) == true) goto L8;
        this.f6347b.add(r11);
        this.f6346a.ensureNotReachHere(r10, "apm_" + r11);
    L8:
        if (c.B() == false) goto L11;
        r10.printStackTrace();
        return;
    }

    public void f(ExceptionCallBack r10) {
        this.f6346a = r10;
        g();
    }

    public final void g() {
        k5.a.a().setExceptionListener(new a(this));
    }

    public MonitorCoreExceptionManager() {
        this.f6347b = new HashSet();
    }
}
