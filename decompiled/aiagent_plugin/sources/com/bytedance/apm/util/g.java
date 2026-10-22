package com.bytedance.apm.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FpsUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f4979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f4980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f4981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f4982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f4983e;
    private static int f;

    static /* synthetic */ void a(Activity r2) {
        b((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"));
    }

    static {
        f();
    }

    private static void f() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        ActivityLifeObserver.getInstance().register(new AnonymousClass1());
        float r3 = 0.0f;
        int r7 = 0;
        boolean r8 = false;
        if (com.bytedance.apm.c.v() == true) goto L5;
    L19:
        f4981c = 60;
        f4980b = 60;
        f4982d = true;
        f4979a = 1000.0f / 60;
        f = 60;
        f4983e = 60;
        if (Build.VERSION.SDK_INT < 23) goto L36;
        if (r0 == null) goto L37;
        Display r1 = ((WindowManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin")).getDefaultDisplay();
        f4983e = a(r1.getRefreshRate());
        Display.Mode[] r2 = r1.getSupportedModes();
        int r4 = r2.length;
    L23:
        if (r7 >= r4) goto L28;
        float r5 = r2[r7].getRefreshRate();
        if (r5 <= r3) goto L27;
        r3 = r5;
    L27:
        r7 = r7 + 1;
        goto L23
    L28:
        f = a(r3);
        return;
    L37:
        return;
    L36:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L19;
        if (r0 == null) goto L19;
        Display r6 = ((WindowManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin")).getDefaultDisplay();
        float r9 = r6.getRefreshRate();
        Display.Mode[] r10 = r6.getSupportedModes();
        int r11 = r10.length;
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L14;
        float r13 = r10[r12].getRefreshRate();
        if (r13 <= r3) goto L13;
        r3 = r13;
    L13:
        r12 = r12 + 1;
        goto L9
    L14:
        int r14 = a(r9);
        f4980b = r14;
        f4983e = r14;
        int r15 = a(r3);
        f4981c = r15;
        int r16 = f4980b;
        if (r16 != r15) goto L17;
        r8 = true;
    L17:
        f4982d = r8;
        f4979a = 1000.0f / r16;
    }

    private static int a(float r2) {
        if (Math.abs(r2 - 60.0f) >= 5.1f) goto L7;
        return 60;
    L7:
        if (Math.abs(r2 - 90.0f) >= 5.1f) goto L11;
        return 90;
    L11:
        if (Math.abs(r2 - 120.0f) >= 5.1f) goto L15;
        return 120;
    L15:
        return (int) r2;
    }

    private static void b(Activity r2) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        float r4 = r3.getWindowManager().getDefaultDisplay().getRefreshRate();
        f4983e = a(r4);
        if (com.bytedance.apm.c.v() == true) goto L8;
        return;
    L8:
        int r5 = a(r4);
        f4980b = r5;
        if (r5 != f4981c) goto L11;
        boolean r0 = true;
    L12:
        f4982d = r0;
        f4979a = 1000.0f / r5;
        return;
    L11:
        r0 = false;
        goto L12
    }

    public static float a() {
        return f4979a;
    }

    public static int b() {
        return f4980b;
    }

    public static int c() {
        return f4981c;
    }

    public static boolean d() {
        return f4982d;
    }

    public static int e() {
        return f;
    }
}
