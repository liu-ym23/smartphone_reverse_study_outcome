package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes28.dex */
public final class bo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile b f26305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ci f26306b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static bo f26307a;

        static {
            f26307a = new bo();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected boolean f26308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f26309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f26310c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f26311d;

        public final boolean a() {
            if (this.f26311d == false) goto L5;
        L27:
            return true;
        L5:
            if (Build.VERSION.SDK_INT < 28) goto L7;
            boolean r100 = true;
        L9:
            if (this.f26308a == false) goto L19;
            int r101 = this.f26309b;
            if (r101 > 0) goto L13;
            r101 = 28;
        L13:
            if (r101 < 28) goto L15;
            boolean r102 = true;
        L16:
            if (r102 == true) goto L19;
            boolean r103 = false;
        L20:
            if (r100 == false) goto L23;
            if (r103 == false) goto L23;
            boolean r104 = true;
        L24:
            if (r104 == true) goto L27;
            return false;
        L23:
            r104 = false;
            goto L24
        L15:
            r102 = false;
        L19:
            r103 = true;
            goto L20
        L7:
            r100 = false;
            goto L9
        }

        private b() {
            this.f26309b = 0;
            this.f26308a = true;
            this.f26310c = true;
            this.f26311d = false;
        }

        public /* synthetic */ b(byte r100) {
            this();
        }

        public final void a(Context r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (this.f26309b > 0) goto L8;
            this.f26309b = r100.getApplicationContext().getApplicationInfo().targetSdkVersion;
            return;
        }

        public final void b(boolean r100) {
            this.f26311d = r100;
        }

        public final void a(boolean r100) {
            this.f26308a = r100;
        }
    }

    public static boolean b() {
        return false;
    }

    public bo() {
        this.f26305a = new b(0);
        this.f26306b = new ci("HttpsDecisionUtil");
    }

    public static bo a() {
        return a.f26307a;
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (r100.startsWith("https") == true) goto L13;
        Uri.Builder r101 = UriProtector.parse(r100).buildUpon();     // Catch: Throwable -> L9
        r101.scheme("https");     // Catch: Throwable -> L9
        return r101.build().toString();
    L14:
        return r100;
    L13:
        return r100;
    }

    public final boolean b(boolean r100) {
        byte r101 = 0;
        if (b() == false) goto L5;
        return false;
    L5:
        if (r100 == false) goto L7;
        return true;
    L7:
        if (this.f26305a != null) goto L10;
        this.f26305a = new b(r101);
    L10:
        if (this.f26305a.a() == true) goto L15;
        return false;
    L15:
        return true;
    }

    public static void b(Context r100) {
        b(r100, true);
    }

    public final void a(Context r100) {
        if (this.f26305a != null) goto L5;
        this.f26305a = new b(0);
    L5:
        this.f26305a.a(ci.a(r100, "open_common", "a3", true));
        this.f26305a.a(r100);
    }

    public final void a(boolean r100) {
        if (this.f26305a != null) goto L5;
        this.f26305a = new b(0);
    L5:
        this.f26305a.b(r100);
    }

    private static void b(Context r100, boolean r101) {
        SharedPreferences.Editor r102 = ci.b(r100, "open_common");
        ci.a(r102, "a3", r101);
        ci.a(r102);
    }

    public final void a(Context r100, boolean r101) {
        if (this.f26305a != null) goto L5;
        this.f26305a = new b(0);
    L5:
        b(r100, r101);
        this.f26305a.a(r101);
    }
}
