package com.bytedance.crash.dumper;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: compiled from: ProcessState.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static n f7431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a[] f7432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a[] f7433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Class f7435e;
    private Object f;
    private Object g;
    private Field h;
    private volatile boolean i;
    private Runnable j;

    /* JADX INFO: compiled from: ProcessState.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f7438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7439b;

        a() {
        }

        public void a() {
            this.f7438a = 0;
            this.f7439b = 0;
        }
    }

    public n() {
        this.f7432b = new a[10];
        this.f7433c = new a[10];
        this.f7434d = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = new AnonymousClass1(this);
    }

    static /* synthetic */ void a(n r0) {
        r0.b();
    }

    static {
        f7431a = new n();
    }

    public static n a() {
        return f7431a;
    }

    private synchronized void b() {
        monitor-enter(this);
        this.f7432b[this.f7434d].a();     // Catch: Throwable -> L6
        a r0 = this.f7432b[this.f7434d];     // Catch: Throwable -> L6
        r0.f7438a = System.currentTimeMillis();     // Catch: Throwable -> L6
        a r1 = this.f7432b[this.f7434d];     // Catch: Throwable -> L6
        r1.f7439b = d();     // Catch: Throwable -> L6
        this.f7434d = (this.f7434d + 1) % 10;     // Catch: Throwable -> L6
        DefaultWorkThread.postDelayed(this.j, WsConstants.EXIT_DELAY_TIME);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void c() {
        monitor-enter(this);
        a[] r0 = this.f7432b;     // Catch: Throwable -> L15
        monitor-enter(r0);     // Catch: Throwable -> L15
        int r1 = 0;
    L7:
        if (r1 >= 10) goto L9;
        this.f7433c[r1] = this.f7432b[r1];     // Catch: Throwable -> L12
        r1 = r1 + 1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private int d() {
        if (this.f != null) goto L9;
        Class r1 = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        this.f7435e = r1;     // Catch: Throwable -> L21
        Method r2 = com.bytedance.crash.o.f.a(r1, "currentActivityThread", null);     // Catch: Throwable -> L21
        r2.setAccessible(true);     // Catch: Throwable -> L21
        this.f = r2.invoke(this.f7435e, new Object[0]);     // Catch: Throwable -> L21
    L9:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        if (this.h != null) goto L13;
        this.h = com.bytedance.crash.o.f.b(this.f7435e, "mLastProcessState");     // Catch: Throwable -> L21
    L13:
        this.h.setAccessible(true);     // Catch: Throwable -> L21
        return ((Integer) ZeusTransformUtils.preCheckCast(this.h.get(this.f), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L15:
        if (this.g != null) goto L17;
        Method r3 = com.bytedance.crash.o.f.a(this.f7435e, "getApplicationThread", null);     // Catch: Throwable -> L21
        r3.setAccessible(true);     // Catch: Throwable -> L21
        Object r4 = r3.invoke(this.f, new Object[0]);     // Catch: Throwable -> L21
        this.g = r4;     // Catch: Throwable -> L21
        this.h = com.bytedance.crash.o.f.b(r4.getClass(), "mLastProcessState");     // Catch: Throwable -> L21
    L17:
        Field r5 = this.h;     // Catch: Throwable -> L21
        if (r5 == null) goto L24;
        r5.setAccessible(true);     // Catch: Throwable -> L21
        return ((Integer) ZeusTransformUtils.preCheckCast(this.h.get(this.g), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L24:
        return -1;
    L25:
        return -1;
    }

    public void a(File r6) {
        if (this.i == true) goto L12;
        return;
    L12:
        DefaultWorkThread.removeCallbacks(this.j);     // Catch: Throwable -> L11
        b();     // Catch: Throwable -> L11
        c();     // Catch: Throwable -> L11
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L11
        Arrays.sort(this.f7433c, new AnonymousClass2(this));     // Catch: Throwable -> L11
        int r2 = 0;
    L6:
        a[] r3 = this.f7433c;     // Catch: Throwable -> L11
        if (r2 >= r3.length) goto L9;
        r0.append(r3[r2].f7438a);     // Catch: Throwable -> L11
        r0.append(",");     // Catch: Throwable -> L11
        r0.append(this.f7433c[r2].f7439b);     // Catch: Throwable -> L11
        r0.append("\n");     // Catch: Throwable -> L11
        r2 = r2 + 1;     // Catch: Throwable -> L11
        goto L6
    L9:
        com.bytedance.crash.o.j.a(new File(r6, "process_state.txt"), r0.toString(), false);     // Catch: Throwable -> L11
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(File r21, JSONObject r22, JSONObject r23) {
        long r3 = r22.optLong("crash_time");     // Catch: Throwable -> L65
        File r5 = new File(r21, "process_state.txt");     // Catch: Throwable -> L65
        if (r5.exists() == true) goto L6;
        return;
    L6:
        SimpleDateFormat r6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // Catch: Throwable -> L65
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L65
        long r8 = 2147483647L;
        BufferedReader r10 = null;
        String r0 = null;
        BufferedReader r11 = null;
        char r12 = 1;
        char r13 = 0;
        BufferedReader r14 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L36 Exception -> L39
    L74:
        String r9 = r14.readLine();     // Catch: Throwable -> L30 Exception -> L33
        if (r9 == null) goto L22;
        String[] r15 = r9.split(",");     // Catch: Exception -> L21 Throwable -> L30
        BufferedReader r16 = r14;
        long r17 = Long.parseLong(r15[r13]);     // Catch: Exception -> L20 Throwable -> L27
        long r18 = r17 - r3;     // Catch: Exception -> L20 Throwable -> L27
        if (r18 > 0) goto L16;
    L18:
        r7.append(r6.format(new Date(r17)));     // Catch: Exception -> L20 Throwable -> L27
        r7.append(":");     // Catch: Exception -> L20 Throwable -> L27
        r7.append(r15[1]);     // Catch: Exception -> L20 Throwable -> L27
        r7.append("\n");     // Catch: Exception -> L20 Throwable -> L27
        r14 = r16;
        r13 = 0;
        goto L74
    L16:
        if (r18 >= r8) goto L18;
        r0 = r9;
        r8 = r18;
    L27:
        th = th;
    L32:
        r10 = r16;
    L37:
        com.bytedance.crash.o.i.a(r10);     // Catch: Throwable -> L65
        throw th;     // Catch: Throwable -> L65
    L20:
        r0 = r0;
        r11 = r16;
        char r4 = 0;
    L40:
        com.bytedance.crash.o.i.a(r11);     // Catch: Throwable -> L65
        r0 = r0;
    L42:
        if (TextUtils.isEmpty(r0) == false) goto L44;
        return;
    L44:
        int r1 = Integer.parseInt(r0.split(",")[1]);     // Catch: Throwable -> L65
        if (Build.VERSION.SDK_INT != 29) goto L52;
        if (r1 > 7) goto L50;
    L49:
        r12 = r4;
    L50:
        boolean r19 = r12;
    L62:
        r23.put("is_background_v2", String.valueOf(r19));     // Catch: Throwable -> L65
        r23.put("process_state", String.valueOf(r1));     // Catch: Throwable -> L65
        return;
    L52:
        if (Build.VERSION.SDK_INT != 28) goto L57;
        if (r1 <= 5) goto L49;
    L57:
        if (Build.VERSION.SDK_INT >= 23) goto L59;
        r19 = r4;
        goto L62
    L59:
        if (r1 <= 6) goto L49;
    L21:
        r16 = r14;
        r4 = r13;
    L35:
        r11 = r16;
        goto L40
    L22:
        r16 = r14;
        r4 = 0;
        com.bytedance.crash.o.j.a(new File(r21, "process_state_format.txt"), r7.toString(), false);     // Catch: Throwable -> L27 Exception -> L64
        com.bytedance.crash.o.i.a(r16);     // Catch: Throwable -> L65
        goto L42
    L29:
        r4 = 0;
    L30:
        th = th;
        r16 = r14;
    L33:
        r4 = r13;
        r16 = r14;
        goto L35
    L39:
        r4 = 0;
        r0 = null;
    L36:
        th = th;
        goto L37
    }
}
