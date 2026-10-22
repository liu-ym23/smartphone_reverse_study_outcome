package com.bytedance.crash.c;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.g;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i;
import com.bytedance.crash.monitor.f;
import com.bytedance.crash.monitor.h;
import com.bytedance.crash.o.l;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: NpthMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f7264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f7265b;

    /* JADX INFO: compiled from: NpthMonitor.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JSONObject f7268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f7269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f7270c;

        public a(String r2) {
            this.f7269b = new JSONObject();
            this.f7270c = r2;
            this.f7268a = new JSONObject();
        }

        public a(String r2, JSONObject r3) {
            this.f7269b = new JSONObject();
            this.f7270c = r2;
            if (r3 == null) goto L5;
            this.f7268a = r3;
            return;
        L5:
            this.f7268a = new JSONObject();
        }

        public a a(Object... r2) {
            l.a(this.f7268a, r2);
            return this;
        }

        public a b(Object... r2) {
            l.a(this.f7269b, r2);
            return this;
        }

        public a a(JSONObject r1) {
            this.f7269b = r1;
            return this;
        }

        public void a() {
            b r0 = b.c();
            if (r0 == null) goto L6;
            b();
            b.a(r0).a(this.f7270c, 1, this.f7268a, this.f7269b);
            return;
        }

        private void b() {
            com.bytedance.crash.monitor.a r0 = h.a();
            if (r0 == null) goto L6;
            HashMap r1 = new HashMap();
            r1.put(WsConstants.KEY_APP_ID, r0.e());
            r1.put("device_id", r0.a("0"));
            r1.put("update_version_code", String.valueOf(r0.j()));
            r1.put("version_code", String.valueOf(r0.i()));
            r1.put(WsConstants.KEY_APP_VERSION, String.valueOf(r0.l()));
            r1.put("channel", r0.f());
            r1.put("npth_version", g.f7298a);
            l.a(this.f7268a, r1);
            return;
        }
    }

    static /* synthetic */ f a(b r0) {
        return r0.d();
    }

    static /* synthetic */ b c() {
        return e();
    }

    private b(Context r8) {
        f r9 = h.a((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin"), "2010", 4020254, 4020254, g.f7298a);
        this.f7265b = r9;
        r9.b("release");
        com.bytedance.crash.monitor.a r7 = h.a();
        if (r7 == null) goto L6;
        r9.c(r7.a("0"));
        return;
    }

    private f d() {
        return this.f7265b;
    }

    public static void a() {
        if (f7264a == null) goto L5;
        return;
    L5:
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7264a != null) goto L9;
        f7264a = new b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    }

    private static b e() {
        return f7264a;
    }

    public static void a(String r4, Throwable r5) {
        if (b() >= 25165824) goto L5;
        boolean r0 = true;
    L6:
        b r1 = e();
        if (r1 == null) goto L10;
        r1.d().a(r4 + "_" + r0, r5);
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void b(String r1, Throwable r2) {
        b r0 = e();
        if (r0 == null) goto L6;
        r0.d().a(r1, r2);
        return;
    }

    public static void c(String r13, Throwable r14) {
        b r0 = e();
        if (r0 != null) goto L5;
        return;
    L5:
        f r1 = r0.d();
        com.bytedance.crash.d.f r12 = new com.bytedance.crash.d.f(r14, null, 0, r13, true, null, Thread.currentThread().getName(), "EnsureNotReachHere", "core_exception_monitor", "exception");     // Catch: Throwable -> L10
        final JSONObject r15 = new JSONObject();     // Catch: Throwable -> L10
        JSONArray r16 = new JSONArray();     // Catch: Throwable -> L10
        r16.put(r12.a(r1));     // Catch: Throwable -> L10
        r15.put("data", r16);     // Catch: Throwable -> L10
        int r17 = Process.myPid();     // Catch: Throwable -> L10
        JSONObject r18 = Header.a(r1, System.currentTimeMillis(), CrashType.ENSURE, r17).b();     // Catch: Throwable -> L10
        r15.put("header", r18);     // Catch: Throwable -> L10
        final String r19 = o.a(com.bytedance.crash.config.f.f(), r18);     // Catch: Throwable -> L10
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L13;
        DefaultWorkThread.post(new AnonymousClass1(r19, r15));     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }

    public static void a(Throwable r1) {
        b("NPTH_CATCH_NEW", r1);
    }

    public static long b() {
        return a(Environment.getDataDirectory());
    L4:
        return 0;
    }

    private static long a(File r5) {
        StatFs r0 = new StatFs(r5.getPath());     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 18) goto L8;
        return r0.getFreeBytes();
    L8:
        return ((long) r0.getAvailableBlocks()) * r0.getBlockSize();
    L9:
        return 0;
    }
}
