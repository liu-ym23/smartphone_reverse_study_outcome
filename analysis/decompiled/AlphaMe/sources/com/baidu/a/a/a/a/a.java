package com.baidu.a.a.a.a;

import android.content.Context;
import com.baidu.b.c;
import com.baidu.b.f;
import com.baidu.b.g;
import com.baidu.b.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f4626a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f4627b;

    /* renamed from: c, reason: collision with root package name */
    private h f4628c;

    /* renamed from: d, reason: collision with root package name */
    private g f4629d;

    /* renamed from: e, reason: collision with root package name */
    private c f4630e;

    /* renamed from: f, reason: collision with root package name */
    private h.a f4631f;

    /* renamed from: g, reason: collision with root package name */
    private h.a f4632g;

    /* renamed from: h, reason: collision with root package name */
    private long f4633h;

    private a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f4627b = applicationContext;
        this.f4630e = new c();
        this.f4628c = new h(applicationContext, new com.baidu.b.e.a(applicationContext), this.f4630e);
        this.f4629d = new g(applicationContext, this.f4630e);
    }

    private h.a a() {
        h.a aVar = this.f4632g;
        if (aVar != null) {
            return aVar;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - this.f4633h) > 3600000) {
            this.f4632g = b();
            this.f4633h = jCurrentTimeMillis;
        }
        h.a aVar2 = this.f4632g;
        if (aVar2 != null) {
            return aVar2;
        }
        if (this.f4631f == null) {
            this.f4632g = d(null);
        }
        return this.f4632g;
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f.class) {
            try {
                if (f4626a == null) {
                    f4626a = new a(context);
                }
                aVar = f4626a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private h.a c(String str) {
        f fVarA = this.f4629d.a(str);
        if (fVarA != null) {
            return this.f4628c.a(fVarA);
        }
        return null;
    }

    private h.a d(String str) {
        return this.f4628c.c(str);
    }

    public static String a(Context context) {
        String strB;
        synchronized (a.class) {
            strB = b(context).a().b();
        }
        return strB;
    }

    private h.a b() {
        return b((String) null);
    }

    public static void a(String str) {
        h.b(str);
    }

    private h.a b(String str) {
        h.a aVarA = this.f4628c.a();
        return aVarA == null ? c(str) : aVarA;
    }
}
