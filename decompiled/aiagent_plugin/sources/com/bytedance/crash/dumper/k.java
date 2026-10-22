package com.bytedance.crash.dumper;

import android.os.Looper;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: JavaStack.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: compiled from: JavaStack.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StackTraceElement[] f7418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f7419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f7420c;

        public a(StackTraceElement[] r3) {
            this.f7420c = System.currentTimeMillis();
            this.f7418a = r3;
            this.f7419b = a(r3);
        }

        private String a(StackTraceElement[] r6) {
            StringBuilder r5 = new StringBuilder();
            int r0 = r6.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L6;
            StackTraceElement r2 = r6[r1];
            r5.append("  at ").append(r2.getClassName()).append(".").append(r2.getMethodName()).append("(").append(r2.getFileName()).append(":").append(r2.getLineNumber()).append(")\n");
            r1 = r1 + 1;
            goto L3
        L6:
            return r5.toString();
        }

        public StackTraceElement[] a() {
            return this.f7418a;
        }

        public String b() {
            return this.f7419b;
        }
    }

    public static a a(File r3) {
        a r1 = new a(Looper.getMainLooper().getThread().getStackTrace());
        com.bytedance.crash.o.i.a(r3, "main_stack.txt", r1.b());
        return r1;
    }

    public static String b(File r2) {
        return com.bytedance.crash.o.i.d(new File(r2, "main_stack.txt"));
    }

    public static boolean a(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.startsWith("{\"mainStackFromTrace\":\"\\\"main\\\"") == false) goto L7;
        return true;
    }

    public static void a(JSONObject r4, File r5) {
        File r0 = new File(r5, "jstack.txt");
        File r1 = new File(r5, "abort.txt");
        if (r0.exists() == false) goto L5;
        String r6 = com.bytedance.crash.o.i.d(r0);
    L7:
        if (r1.exists() == false) goto L16;
        String r2 = com.bytedance.crash.o.i.d(r1);
        if (r2 == null) goto L16;
        if (r2.startsWith("[FATAL:") == false) goto L16;
        if (r2.contains("Please include Java exception stack in crash report ttwebview:") == false) goto L16;
        StringBuilder r3 = new StringBuilder();
        r3.append(r6);
        int r7 = r2.indexOf(" ttwebview:");
        r3.append("Caused by: ").append("Please include Java exception stack in crash report").append("\n");
        r3.append(r2.substring(r7 + 11));
        r6 = r3.toString();
    L16:
        if (TextUtils.isEmpty(r6) == true) goto L19;
        com.bytedance.crash.o.l.a(r4, "java_data", r6);
        return;
    L19:
        return;
    L5:
        r6 = null;
        goto L7
    }

    public static void c(File r11) {
        Map<Thread, StackTraceElement[]> r0 = Thread.getAllStackTraces();
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        com.bytedance.crash.dumper.a.f r1 = new com.bytedance.crash.dumper.a.f(r11.getAbsolutePath() + "/all_thread_stacks.json");
        r1.a();
        r1.a("all_thread_stacks");
        r1.a();
        r1.a("thread_all_count").a(r0.size()).e();
        r1.a("thread_stacks");
        r1.c();
        Iterator<Map.Entry<Thread, StackTraceElement[]>> r12 = r0.entrySet().iterator();
        boolean r2 = true;
    L7:
        if (r12.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        StackTraceElement[] r4 = (StackTraceElement[]) ZeusTransformUtils.preCheckCast(r3.getValue(), StackTraceElement[].class, "com.obric.aiagent.plugin");
        int r6 = 0;
        if (r2 == false) goto L11;
        r2 = false;
    L12:
        r1.a();
        Thread r5 = (Thread) ZeusTransformUtils.preCheckCast(r3.getKey(), Thread.class, "com.obric.aiagent.plugin");
        r1.a("thread_name").a('\"').c(r5.getName()).a('(').b(r5.getId()).a(')').a('\"');
        r1.e();
        r1.a("thread_stack");
        r1.c();
        if (r4.length > 0) goto L15;
        r1.c("\"(Native Method)\"");
    L21:
        r1.d();
        r1.b();
    L15:
        if (r6 >= r4.length) goto L21;
        StackTraceElement r7 = r4[r6];
        r1.a('\"').c(r7.getClassName()).a('.').c(r7.getMethodName()).a('(').c(r7.getFileName()).a(':').b(r7.getLineNumber()).a(')').a('\"');
        if (r6 == (r4.length - 1)) goto L19;
        r1.e();
    L19:
        r6 = r6 + 1;
        goto L15
    L11:
        r1.e();
        goto L12
    L22:
        r1.d();
        r1.b();
        r1.b();
        r1.f();
    }

    public static void b(JSONObject r2, File r3) {
        String r4 = com.bytedance.crash.o.i.d(new File(r3, "all_thread_stacks.json"));
        if (r4 == null) goto L9;
        com.bytedance.crash.o.l.b(r2, new JSONObject(r4));     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }
}
