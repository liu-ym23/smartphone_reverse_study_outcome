package com.bytedance.apm6.cpu.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: CpuExceptionJudgeHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5259a;

    public static void a(String r0) {
        f5259a = r0;
    }

    public static boolean a() {
        return c();
    }

    private static boolean c() {
        f5259a = com.bytedance.apm6.cpu.a.a().b();
        return false;
    }

    public static String b() {
        return f5259a;
    }

    public static boolean a(com.bytedance.apm6.cpu.b.c r10, double r11, boolean r13) {
        if (r13 == false) goto L30;
        if (r10.b().isEmpty() == true) goto L19;
        Iterator<String> r14 = com.bytedance.apm6.cpu.a.a().c().iterator();
        double r5 = 0.0d;
    L8:
        if (r14.hasNext() == false) goto L21;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin");
        if (r10.b().containsKey(r7) == false) goto L8;
        double r8 = ((Double) ZeusTransformUtils.preCheckCast(r10.b().get(r7), Double.class, "com.obric.aiagent.plugin")).doubleValue();
        if (r8 < 0.0d) goto L8;
        if (r5 > r8) goto L8;
        r5 = r8;
    L21:
        if (r5 > 0.0d) goto L25;
        r5 = r10.e();
    L25:
        if (r11 <= r5) goto L28;
        return true;
    L28:
        return false;
    L19:
        r5 = 0.0d;
        goto L21
    L30:
        if (r10.c().isEmpty() == true) goto L44;
        Iterator<String> r15 = com.bytedance.apm6.cpu.a.a().c().iterator();
        double r6 = 0.0d;
    L33:
        if (r15.hasNext() == false) goto L46;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        if (r10.c().containsKey(r9) == false) goto L33;
        double r12 = ((Double) ZeusTransformUtils.preCheckCast(r10.c().get(r9), Double.class, "com.obric.aiagent.plugin")).doubleValue();
        if (r12 < 0.0d) goto L33;
        if (r6 > r12) goto L33;
        r6 = r12;
    L46:
        if (r6 > 0.0d) goto L50;
        r6 = r10.i();
    L50:
        if (r11 <= r6) goto L53;
        return true;
    L53:
        return false;
    L44:
        r6 = 0.0d;
        goto L46
    }
}
