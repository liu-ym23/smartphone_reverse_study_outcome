package com.baidu.location.e;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    public static String f5798e = null;

    /* renamed from: f, reason: collision with root package name */
    public static String f5799f = null;

    /* renamed from: g, reason: collision with root package name */
    public static String f5800g = null;

    /* renamed from: h, reason: collision with root package name */
    public static String f5801h = null;

    /* renamed from: i, reason: collision with root package name */
    public static String f5802i = null;

    /* renamed from: j, reason: collision with root package name */
    public static int f5803j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static int f5804k = -2;

    /* renamed from: l, reason: collision with root package name */
    public static long f5805l = -1;

    /* renamed from: a, reason: collision with root package name */
    public String f5806a;

    /* renamed from: b, reason: collision with root package name */
    public String f5807b;

    /* renamed from: c, reason: collision with root package name */
    public String f5808c;

    /* renamed from: d, reason: collision with root package name */
    public String f5809d;

    /* renamed from: m, reason: collision with root package name */
    private boolean f5810m;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5811a = new b();
    }

    private b() {
        this.f5806a = null;
        this.f5807b = null;
        this.f5808c = null;
        this.f5809d = null;
        this.f5810m = false;
        if (com.baidu.location.f.getServiceContext() != null) {
            a(com.baidu.location.f.getServiceContext());
        }
    }

    public static b a() {
        return a.f5811a;
    }

    private boolean d() {
        return false;
    }

    public String b() {
        return this.f5808c;
    }

    public String c() {
        String str;
        StringBuffer stringBuffer = new StringBuffer(200);
        if (this.f5808c != null) {
            stringBuffer.append("&cu=");
            str = this.f5808c;
        } else {
            stringBuffer.append("&im=");
            str = this.f5806a;
        }
        stringBuffer.append(str);
        try {
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
        } catch (Exception unused) {
        }
        stringBuffer.append("&pack=");
        try {
            stringBuffer.append(f5798e);
        } catch (Exception unused2) {
        }
        stringBuffer.append("&sdk=9.643");
        return stringBuffer.toString();
    }

    public String a(boolean z4) {
        return a(z4, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(boolean r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.b.a(boolean, java.lang.String):java.lang.String");
    }

    public void a(Context context) {
        if (context == null || this.f5810m) {
            return;
        }
        try {
            f5798e = context.getPackageName();
        } catch (Exception unused) {
            f5798e = null;
        }
        try {
            f5802i = h.f(context);
        } catch (Exception unused2) {
            f5802i = null;
        }
        h.f5928n = "" + this.f5808c;
        this.f5810m = true;
    }

    public void a(String str) {
        this.f5808c = str;
        h.f5928n = "" + this.f5808c;
    }

    public void a(String str, String str2) {
        f5799f = str;
        f5798e = str2;
    }
}
