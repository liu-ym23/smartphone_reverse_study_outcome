package com.bytedance.apm.f;

import android.content.Intent;
import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: compiled from: LaunchModeTrigger.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4629a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4630b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4631c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f4632d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f4633e = "";
    private static Intent f;
    private static long g;
    private static long h;

    static {
    }

    static /* synthetic */ long a(long r0) {
        g = r0;
        return r0;
    }

    static /* synthetic */ String a(String r0) {
        f4632d = r0;
        return r0;
    }

    static /* synthetic */ boolean a(boolean r0) {
        f4629a = r0;
        return r0;
    }

    static /* synthetic */ long b(long r0) {
        h = r0;
        return r0;
    }

    static /* synthetic */ String b(String r0) {
        f4633e = r0;
        return r0;
    }

    static /* synthetic */ boolean b(boolean r0) {
        f4631c = r0;
        return r0;
    }

    static /* synthetic */ boolean c(boolean r0) {
        f4630b = r0;
        return r0;
    }

    public static void a() {
        f = f.a();
        ActivityLifeObserver.getInstance().register(new AnonymousClass1());
    }
}
