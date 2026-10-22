package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes28.dex */
public class r5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile b f27930a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static r5 f27931a;

        static {
            f27931a = new r5();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f27932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected boolean f27933b;

        public final boolean a() {
            if (Build.VERSION.SDK_INT < 28) goto L5;
            boolean r100 = true;
        L7:
            if (this.f27933b == false) goto L17;
            int r101 = this.f27932a;
            if (r101 > 0) goto L11;
            r101 = 28;
        L11:
            if (r101 < 28) goto L13;
            boolean r102 = true;
        L14:
            if (r102 == true) goto L17;
            boolean r103 = false;
        L18:
            if (r100 == false) goto L21;
            if (r103 == false) goto L21;
            boolean r104 = true;
        L22:
            if (r104 == false) goto L24;
            return true;
        L24:
            return false;
        L21:
            r104 = false;
            goto L22
        L13:
            r102 = false;
        L17:
            r103 = true;
            goto L18
        L5:
            r100 = false;
            goto L7
        }

        private b() {
            this.f27932a = 0;
            this.f27933b = true;
        }

        public /* synthetic */ b(byte r100) {
            this();
        }

        public final void a(Context r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (this.f27932a > 0) goto L8;
            this.f27932a = r100.getApplicationContext().getApplicationInfo().targetSdkVersion;
            return;
        }
    }

    public boolean b() {
        if (this.f27930a != null) goto L6;
        this.f27930a = new b(0);
    L6:
        return this.f27930a.a();
    }

    public r5() {
        this.f27930a = new b(0);
        String r100 = "HttpsDecisionUtil";
        if (TextUtils.isDigitsOnly("HttpsDecisionUtil") == false) goto L5;
        r100 = "SPUtil";
    L5:
        t5.c(r100);
    }

    public static r5 a() {
        return a.f27931a;
    }

    public void a(Context r100) {
        if (this.f27930a != null) goto L5;
        this.f27930a = new b(0);
    L5:
        b r101 = this.f27930a;
        r101.f27933b = m7.a(r100, "open_common", "a3", true);
        this.f27930a.a(r100);
        f6.a(r100).a();
    }

    public boolean a(boolean r100) {
        if (r100 == true) goto L10;
        byte r101 = 0;
        if (this.f27930a != null) goto L7;
        this.f27930a = new b(r101);
    L7:
        if (this.f27930a.a() == true) goto L12;
        return false;
    L12:
        return true;
    L10:
        return true;
    }

    public final void a(Context r100, boolean r101) {
        if (this.f27930a != null) goto L5;
        this.f27930a = new b(0);
    L5:
        SharedPreferences.Editor r102 = m7.a(r100, "open_common");
        m7.a(r102, "a3", r101);
        m7.a(r102);
        this.f27930a.f27933b = r101;
    }
}
