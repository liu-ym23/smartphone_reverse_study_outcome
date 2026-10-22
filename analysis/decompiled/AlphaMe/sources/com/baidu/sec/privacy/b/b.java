package com.baidu.sec.privacy.b;

import android.content.Context;
import com.baidu.sec.privacy.c;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Context f9403a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f9404b;

    /* renamed from: c, reason: collision with root package name */
    public static com.baidu.sec.privacy.a f9405c;

    /* renamed from: d, reason: collision with root package name */
    public static c f9406d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f9407e;

    public static void a(Context context, String str, com.baidu.sec.privacy.a aVar) {
        f9405c = aVar;
        a(context, str);
    }

    public static com.baidu.sec.privacy.a b() {
        return f9405c;
    }

    public static c c() {
        return f9406d;
    }

    public static boolean d() {
        return f9407e;
    }

    public static void a(Context context, String str) {
        if (f9404b) {
            return;
        }
        try {
            f9407e = false;
            a(context, str, false, null);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
        }
    }

    public static void a(Context context, String str, boolean z4, c cVar) {
        if (f9404b) {
            return;
        }
        try {
            f9404b = true;
            f9403a = context.getApplicationContext();
            f9406d = cVar;
            f9407e = z4;
            com.baidu.sec.privacy.d.b.a(str, z4, cVar);
            com.baidu.sec.privacy.d.a.b(str);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
        }
    }

    public static a a(Context context) {
        return com.baidu.sec.privacy.e.a.a(context);
    }

    public static Context a() {
        return f9403a;
    }

    public static void a(boolean z4) {
        try {
            com.baidu.sec.privacy.f.c.a(z4);
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
        }
    }
}
