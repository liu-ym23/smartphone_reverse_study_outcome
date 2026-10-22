package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import ec2.r0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f136788a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f136789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f136790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f136791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f136792e;

    static {
        f136788a = r0.f472052a.getValue();
    }

    @JvmStatic
    public static final void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (f136788a.booleanValue() == true) goto L6;
        r100.run();
        return;
    L6:
        long r101 = System.nanoTime();
        r100.run();
        f136789b += System.nanoTime() - r101;
        f136790c++;
    }
}
