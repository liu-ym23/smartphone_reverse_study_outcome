package com.bytedance.apm.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f6655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f6656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f6657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f6658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f6659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f6660f;

    public static class a implements IActivityLifeObserver {
        public a() {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityCreated(Activity r10, Bundle r11) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityPause(Activity r10) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityResume(Activity r10) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityStarted(Activity r10) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onBackground(Activity r10) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onChange(Activity r10, Fragment r11) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onFront(Activity r10) {
            g.a(r10);
        }
    }

    static {
        g();
    }

    public static /* synthetic */ void a(Activity r10) {
        i(r10);
    }

    public static int b() {
        return f6657c;
    }

    public static float c() {
        return f6655a;
    }

    public static int d() {
        return f6660f;
    }

    public static int e() {
        return f6656b;
    }

    public static int f(float r10) {
        if (Math.abs(r10 - 60.0f) >= 5.1f) goto L7;
        return 60;
    L7:
        if (Math.abs(r10 - 90.0f) >= 5.1f) goto L11;
        return 90;
    L11:
        if (Math.abs(r10 - 120.0f) >= 5.1f) goto L15;
        return 120;
    L15:
        return (int) r10;
    }

    public static void g() {
        Context r10 = w0.c.g();
        ActivityLifeObserver.getInstance().register(new a());
        float r11 = 0.0f;
        int r12 = 0;
        boolean r13 = false;
        if (w0.c.j0() == false) goto L17;
        if (r10 == null) goto L17;
        Display r14 = ((WindowManager) r10.getSystemService("window")).getDefaultDisplay();
        float r15 = r14.getRefreshRate();
        Display.Mode[] r16 = r14.getSupportedModes();
        int r17 = r16.length;
        int r18 = 0;
    L7:
        if (r18 >= r17) goto L12;
        float r19 = r16[r18].getRefreshRate();
        if (r19 <= r11) goto L11;
        r11 = r19;
    L11:
        r18 = r18 + 1;
        goto L7
    L12:
        int r20 = f(r15);
        f6656b = r20;
        f6659e = r20;
        int r21 = f(r11);
        f6657c = r21;
        int r22 = f6656b;
        if (r22 != r21) goto L15;
        r13 = true;
    L15:
        f6658d = r13;
        f6655a = 1000.0f / r22;
        return;
    L17:
        f6657c = 60;
        f6656b = 60;
        f6658d = true;
        f6655a = 1000.0f / 60;
        f6660f = 60;
        f6659e = 60;
        if (r10 == null) goto L33;
        Display r23 = ((WindowManager) r10.getSystemService("window")).getDefaultDisplay();
        f6659e = f(r23.getRefreshRate());
        Display.Mode[] r24 = r23.getSupportedModes();
        int r25 = r24.length;
    L20:
        if (r12 >= r25) goto L25;
        float r26 = r24[r12].getRefreshRate();
        if (r26 <= r11) goto L24;
        r11 = r26;
    L24:
        r12 = r12 + 1;
        goto L20
    L25:
        f6660f = f(r11);
        return;
    }

    public static boolean h() {
        return f6658d;
    }

    public static void i(Activity r10) {
        float r11 = r10.getWindowManager().getDefaultDisplay().getRefreshRate();
        f6659e = f(r11);
        if (w0.c.j0() == true) goto L5;
        return;
    L5:
        int r12 = f(r11);
        f6656b = r12;
        if (r12 != f6657c) goto L8;
        boolean r13 = true;
    L9:
        f6658d = r13;
        f6655a = 1000.0f / r12;
        return;
    L8:
        r13 = false;
        goto L9
    }
}
