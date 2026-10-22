package com.obric.autogui.net.ttnet;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.n;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SkillNetworkDebugLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "SkillNetworkDebug";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f29242a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicLong f29243b = null;

    private d() {
    }

    static {
        f29242a = new d();
        f29243b = new AtomicLong();
    }

    public final void a(String r5, Integer r6, Object r7, Object r8, String r9) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (a() == false) goto L22;
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = new StringBuilder().append("httpCode=");
        if (r6 == null) goto L9;
        int r10 = r6.intValue();
    L10:
        StringBuilder r11 = r0.append(r1.append(r10).toString());
        o.c(r11, "append(...)");
        o.c(r11.append('\n'), "append(...)");
        StringBuilder r12 = new StringBuilder().append("ttLogId=");
        if (r9 != null) goto L13;
        r9 = "<empty>";
    L13:
        StringBuilder r13 = r0.append(r12.append(r9).toString());
        o.c(r13, "append(...)");
        o.c(r13.append('\n'), "append(...)");
        StringBuilder r14 = new StringBuilder().append("headers=");
        if (r7 != null) goto L16;
        r7 = "<empty>";
    L16:
        StringBuilder r15 = r0.append(r14.append(r7).toString());
        o.c(r15, "append(...)");
        o.c(r15.append('\n'), "append(...)");
        StringBuilder r16 = new StringBuilder().append("body=");
        if (r8 != null) goto L19;
        r8 = "<empty>";
    L19:
        r0.append(r16.append(r8).toString());
        x r17 = x.f38692a;
        String r18 = r0.toString();
        o.c(r18, "toString(...)");
        a(r5, "RESPONSE", r18);
        return;
    L9:
        r10 = -1;
        goto L10
    }

    public final void a(String r5, Integer r6, Object r7, String r8, Throwable r9) {
        o.e(r9, "throwable");
        if (r5 != null) goto L5;
        return;
    L5:
        if (a() == false) goto L23;
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = new StringBuilder().append("httpCode=");
        if (r6 == null) goto L10;
        int r10 = r6.intValue();
    L11:
        StringBuilder r11 = r0.append(r1.append(r10).toString());
        o.c(r11, "append(...)");
        o.c(r11.append('\n'), "append(...)");
        StringBuilder r12 = new StringBuilder().append("ttLogId=");
        if (r8 != null) goto L14;
        r8 = "<empty>";
    L14:
        StringBuilder r13 = r0.append(r12.append(r8).toString());
        o.c(r13, "append(...)");
        o.c(r13.append('\n'), "append(...)");
        StringBuilder r14 = new StringBuilder().append("headers=");
        if (r7 != null) goto L17;
        r7 = "<empty>";
    L17:
        StringBuilder r15 = r0.append(r14.append(r7).toString());
        o.c(r15, "append(...)");
        o.c(r15.append('\n'), "append(...)");
        StringBuilder r16 = new StringBuilder().append("error=").append(r9.getClass().getName()).append(": ");
        String r17 = r9.getMessage();
        if (r17 != null) goto L20;
        r17 = "";
    L20:
        r0.append(r16.append(r17).toString());
        x r18 = x.f38692a;
        String r19 = r0.toString();
        o.c(r19, "toString(...)");
        a(r5, "FAILURE", r19);
        a(TAG, '[' + r5 + "] FAILURE stack", r9);
        return;
    L10:
        r10 = -1;
        goto L11
    }

    private final boolean a() {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = n.f(false);     // Catch: Throwable -> L5
    L8:
        if (n.b(r4) == false) goto L11;
        r4 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        n.a r5 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L8
    }

    private final void a(String r6, String r7, String r8) {
        int r1 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        List<String> r9 = p.a("");
    L9:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r10.hasNext() == false) goto L16;
        Object r2 = r10.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L15;
        p.c();
    L15:
        a(TAG, '[' + r6 + "] " + r7 + " [" + r3 + '/' + r9.size() + "]\n" + ((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin")));
        r1 = r3;
        goto L11
    L16:
        return;
    L8:
        r9 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), 3000);
        goto L9
    L5:
        r5 = false;
        goto L6
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
