package com.bytedance.agentrobots.c;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AgentOperationNotifier.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String TAG = "AgentOperationNotifier";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f4012a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f4013b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f4014c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final C0101a f4015d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f4016e = null;
    private static long f;

    /* JADX INFO: renamed from: com.bytedance.agentrobots.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AgentOperationNotifier.java */
    static final class C0101a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f4018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f4019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f4020d;

        C0101a() {
            this.f4020d = Long.MIN_VALUE;
        }

        synchronized boolean a(String r8, String r9, String r10, long r11, long r13) {
            monitor-enter(this);
        L27:
            th = move-exception;
            throw th;
        L4:
            if (a(this.f4017a, r8) == true) goto L6;
        L10:
            boolean r0 = false;
        L11:
            long r3 = this.f4020d;     // Catch: Throwable -> L27
            if (r3 != Long.MIN_VALUE) goto L15;
        L19:
            boolean r14 = false;
        L20:
            if (r0 == false) goto L24;
            if (r14 == false) goto L24;
            monitor-exit(this);
            return true;
        L24:
            this.f4017a = r8;     // Catch: Throwable -> L27
            this.f4018b = r9;     // Catch: Throwable -> L27
            this.f4019c = r10;     // Catch: Throwable -> L27
            this.f4020d = r11;     // Catch: Throwable -> L27
            monitor-exit(this);
            return false;
        L15:
            if (r11 < r3) goto L19;
            if ((r11 - r3) >= r13) goto L19;
            r14 = true;
            goto L20
        L6:
            if (a(this.f4018b, r9) == false) goto L10;
            if (a(this.f4019c, r10) == false) goto L10;
            r0 = true;
            goto L11
        }

        synchronized void a() {
            monitor-enter(this);
            this.f4017a = null;     // Catch: Throwable -> L7
            this.f4018b = null;     // Catch: Throwable -> L7
            this.f4019c = null;     // Catch: Throwable -> L7
            this.f4020d = Long.MIN_VALUE;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static boolean a(String r0, String r1) {
            if (r0 != null) goto L7;
            if (r1 != null) goto L5;
            return true;
        L5:
            return false;
        L7:
            return r0.equals(r1);
        }
    }

    static {
        f4012a = Pattern.compile("^[0-9a-fA-F]{64}$");
        f4013b = new Object();
        f4014c = new b();
        f4015d = new C0101a();
        f4016e = new Object();
        f = Long.MIN_VALUE;
    }

    public static void a(Context r10, String r11, String r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L5;
    L40:
        a("notifyOperationState ignored invalid input", null);
        return;
    L5:
        if (a(r11, r12, r13) == false) goto L40;
        Object r1 = f4013b;
        monitor-enter(r1);
    L37:
        th = move-exception;
        throw th;
    L10:
        if (com.bytedance.agentrobots.d.a.c(r14) == true) goto L14;
        f4014c.a();     // Catch: Throwable -> L37
        f4015d.a();     // Catch: Throwable -> L37
        monitor-exit(r1);     // Catch: Throwable -> L37
        return;
    L14:
        com.bytedance.agentrobots.a.a.b r15 = com.bytedance.agentrobots.a.a.c();     // Catch: Throwable -> L37
        if (r15 != null) goto L19;
        a("AgentOperation capability is unavailable", null);     // Catch: Throwable -> L37
        monitor-exit(r1);     // Catch: Throwable -> L37
        return;
    L19:
        List<b.a> r0 = f4014c.a(r11, r12, r13);     // Catch: Throwable -> L37
        if (r0.isEmpty() == false) goto L24;
        a(TAG, "suppressed duplicate operation state, uuid=" + d(r11) + ", package=" + r12 + ", status=" + r13);     // Catch: Throwable -> L37
        monitor-exit(r1);     // Catch: Throwable -> L37
        return;
    L24:
        Iterator<b.a> r16 = r0.iterator();     // Catch: Throwable -> L37
    L26:
        if (r16.hasNext() == false) goto L35;
        b.a r17 = (b.a) ZeusTransformUtils.preCheckCast(r16.next(), b.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (f4015d.a(r17.f4023a, r17.f4024b, r17.f4025c, SystemClock.elapsedRealtime(), 100) == true) goto L29;
        r15.a(r17.f4023a, r17.f4024b, r17.f4025c);     // Catch: Throwable -> L33 Throwable -> L37
    L33:
        e = move-exception;
        a("notifyOperationState failed", e);     // Catch: Throwable -> L37
        goto L26
    L29:
        a(TAG, "suppressed duplicate operation event within 100ms, uuid=" + d(r17.f4023a) + ", package=" + r17.f4024b + ", status=" + r17.f4025c);     // Catch: Throwable -> L37
        goto L26
    L35:
        monitor-exit(r1);     // Catch: Throwable -> L37
    }

    static boolean a(String r0, String r1, String r2) {
        if (a(r0) == true) goto L5;
    L9:
        return false;
    L5:
        if (b(r1) == false) goto L9;
        if (c(r2) == false) goto L9;
        return true;
    }

    private static boolean a(String r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (r2.length() != 64) goto L8;
        if (f4012a.matcher(r2).matches() == false) goto L8;
        return true;
    }

    private static boolean b(String r4) {
        if (r4 != null) goto L5;
    L19:
        return false;
    L5:
        if (r4.isEmpty() == true) goto L19;
        int r1 = 0;
    L9:
        if (r1 >= r4.length()) goto L17;
        char r2 = r4.charAt(r1);
        if (Character.isWhitespace(r2) == true) goto L16;
        if (Character.isISOControl(r2) == true) goto L16;
        r1 = r1 + 1;
    L16:
        return false;
    L17:
        return true;
    }

    private static boolean c(String r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.isEmpty() == true) goto L8;
        if (r1.length() > 32) goto L8;
        return true;
    }

    private static String d(String r3) {
        return r3.substring(0, Math.min(8, r3.length())) + "...";
    }

    private static void a(String r7, Throwable r8) {
        long r0 = SystemClock.elapsedRealtime();
        Object r2 = f4016e;
        monitor-enter(r2);
        long r3 = f;     // Catch: Throwable -> L16
        if (r3 != Long.MIN_VALUE) goto L7;
    L10:
        f = r0;     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        if (r8 != null) goto L14;
        b(TAG, r7);
        return;
    L14:
        a(TAG, r7, r8);
        return;
    L7:
        if ((r0 - r3) >= OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS) goto L10;
        monitor-exit(r2);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
