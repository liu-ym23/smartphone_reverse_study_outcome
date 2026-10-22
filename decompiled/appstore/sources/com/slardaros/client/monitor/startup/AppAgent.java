package com.slardaros.client.monitor.startup;

import android.text.TextUtils;
import androidx.annotation.Keep;
import ee.a;

/* JADX INFO: loaded from: classes4.dex */
public class AppAgent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f17861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f17862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f17863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f17864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f17865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f17866f;

    @Keep
    public static void onTrace(String r12, boolean r13) {
        if (TextUtils.equals(r12, "<init>") == false) goto L8;
        if (r13 == false) goto L6;
        f17861a = System.currentTimeMillis();
        return;
    L6:
        f17862b = System.currentTimeMillis();
        return;
    L8:
        if (TextUtils.equals(r12, "attachBaseContext") == false) goto L13;
        if (r13 == false) goto L11;
        f17863c = System.currentTimeMillis();
        return;
    L11:
        f17864d = System.currentTimeMillis();
        return;
    L13:
        if (TextUtils.equals(r12, "onCreate") == false) goto L22;
        if (r13 == false) goto L16;
        f17865e = System.currentTimeMillis();
        return;
    L16:
        long r10 = System.currentTimeMillis();
        f17866f = r10;
        a.a(f17861a, f17862b, f17863c, f17864d, f17865e, r10);
        return;
    }
}
