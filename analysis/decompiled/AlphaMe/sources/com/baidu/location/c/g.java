package com.baidu.location.c;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public class g {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f5717d = false;

    /* renamed from: e, reason: collision with root package name */
    private static e f5718e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f5719a = true;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5720b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5721c = false;

    /* renamed from: com.baidu.location.c.g$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5722a;

        static {
            int[] iArr = new int[a.values().length];
            f5722a = iArr;
            try {
                iArr[a.ONLY_CELL_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5722a[a.ONLY_WIFI_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5722a[a.GET_ALL_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum a {
        ONLY_CELL_MODE,
        ONLY_WIFI_MODE,
        GET_ALL_DATA
    }

    public static e h() {
        return f5718e;
    }

    public com.baidu.location.c.a a(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        return com.baidu.location.c.a.a.a().b(aVar, telephonyManager);
    }

    public HashSet<String> b(com.baidu.location.c.a aVar) {
        return com.baidu.location.c.a.a.a().c(aVar);
    }

    public long c() {
        return com.baidu.location.c.a.b.a().c();
    }

    public com.baidu.location.c.a d(int i4) {
        if (this.f5721c && this.f5719a) {
            return com.baidu.location.c.a.a.a().c(i4);
        }
        return null;
    }

    public k e(int i4) {
        if (this.f5721c && this.f5720b) {
            return com.baidu.location.c.a.b.a().a(i4);
        }
        return null;
    }

    public WifiInfo f() {
        return com.baidu.location.c.a.b.a().f();
    }

    public k g() {
        return com.baidu.location.c.a.b.a().d();
    }

    public String a(int i4, boolean z4, k kVar, int i5) {
        return com.baidu.location.c.a.b.a().a(i4, z4, kVar, i5);
    }

    public void b() {
        if (this.f5719a) {
            com.baidu.location.c.a.a.a().b();
        }
        if (this.f5720b) {
            com.baidu.location.c.a.b.a().b();
        }
        this.f5721c = false;
    }

    public String c(com.baidu.location.c.a aVar) {
        return com.baidu.location.c.a.a.a().b(aVar);
    }

    public boolean d() {
        return com.baidu.location.c.a.a.a().c();
    }

    public String e() {
        return com.baidu.location.c.a.b.a().e();
    }

    public String a(WifiInfo wifiInfo, String str) {
        return com.baidu.location.c.a.b.a().a(wifiInfo, str);
    }

    public void b(int i4) {
        if (i4 >= 0) {
            com.baidu.location.c.a.b.a().a(i4);
        }
    }

    public void c(int i4) {
        com.baidu.location.c.a.a.a().b(Math.max(i4, 29));
    }

    public String a(com.baidu.location.c.a aVar) {
        return com.baidu.location.c.a.a.a().a(aVar);
    }

    public void b(boolean z4) {
        com.baidu.location.c.a.a.a().b(z4);
    }

    public String a(k kVar, int i4, String str, boolean z4, int i5) {
        return com.baidu.location.c.a.b.a().a(kVar, i4, str, z4, i5);
    }

    public void a(int i4) {
        if (i4 >= 0) {
            com.baidu.location.c.a.a.a().a(i4);
        }
    }

    public void a(Context context, List<String> list) {
        if (this.f5719a) {
            com.baidu.location.c.a.a.a().a(context);
        }
        if (this.f5720b) {
            com.baidu.location.c.a.b.a().a(context, list);
        }
        this.f5721c = true;
    }

    public void a(e eVar) {
        f5718e = eVar;
    }

    public void a(a aVar) {
        int i4 = AnonymousClass1.f5722a[aVar.ordinal()];
        if (i4 == 1) {
            this.f5719a = true;
            this.f5720b = false;
            return;
        }
        if (i4 == 2) {
            this.f5719a = false;
        } else {
            if (i4 != 3) {
                throw new IllegalArgumentException("Illegal this mode : " + aVar);
            }
            this.f5719a = true;
        }
        this.f5720b = true;
    }

    public void a(boolean z4) {
        com.baidu.location.c.a.a.a().a(z4);
    }

    public static boolean a() {
        return f5717d;
    }

    public boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        return com.baidu.location.c.a.a.a().a(aVar, aVar2);
    }
}
