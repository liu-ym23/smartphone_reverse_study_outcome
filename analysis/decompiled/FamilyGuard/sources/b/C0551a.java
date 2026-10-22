package b;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* renamed from: b.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0551a {

    /* renamed from: b, reason: collision with root package name */
    private static C0551a f11759b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f11760c;

    /* renamed from: a, reason: collision with root package name */
    private final TelephonyManager f11761a;

    private C0551a(TelephonyManager telephonyManager) {
        this.f11761a = telephonyManager;
    }

    public static synchronized C0551a a(Context context) {
        try {
            if (f11759b == null) {
                f11759b = new C0551a((TelephonyManager) context.getApplicationContext().getSystemService("phone"));
            }
        } catch (Throwable th) {
            throw th;
        }
        return f11759b;
    }

    public String b(int i5) {
        try {
            if (f11760c == null) {
                synchronized (C0551a.class) {
                    try {
                        if (f11760c == null) {
                            f11760c = TelephonyManager.class.getMethod("getImei", Integer.TYPE);
                        }
                    } finally {
                    }
                }
            }
            return (String) f11760c.invoke(this.f11761a, Integer.valueOf(i5));
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
