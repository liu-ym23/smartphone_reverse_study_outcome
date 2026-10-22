package com.bytedance.apm.agent.v2.instrumentation;

import android.text.TextUtils;
import com.bytedance.apm.agent.tracing.a;

/* JADX INFO: loaded from: classes.dex */
public class AppAgent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f4142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f4143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f4144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f4145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f4146e;
    private static long f;

    public AppAgent() {
    }

    public static void onTrace(String r12, boolean r13) {
        if (TextUtils.equals(r12, "<init>") == false) goto L8;
        if (r13 == false) goto L6;
        f4142a = System.currentTimeMillis();
        return;
    L6:
        f4143b = System.currentTimeMillis();
        return;
    L8:
        if (TextUtils.equals(r12, "attachBaseContext") == false) goto L13;
        if (r13 == false) goto L11;
        f4144c = System.currentTimeMillis();
        return;
    L11:
        f4145d = System.currentTimeMillis();
        return;
    L13:
        if (TextUtils.equals(r12, "onCreate") == false) goto L22;
        if (r13 == false) goto L16;
        f4146e = System.currentTimeMillis();
        return;
    L16:
        long r10 = System.currentTimeMillis();
        f = r10;
        a.a(f4142a, f4143b, f4144c, f4145d, f4146e, r10);
        return;
    }
}
