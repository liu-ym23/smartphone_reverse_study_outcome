package w2;

import android.content.ContentResolver;
import android.content.Context;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import f2.C0702g;

/* renamed from: w2.p0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1245p0 extends C2.e {

    /* renamed from: d, reason: collision with root package name */
    private static volatile C1245p0 f23640d;

    private C1245p0(Context context) {
        super(context);
    }

    public static C1245p0 f() {
        if (f23640d == null) {
            synchronized (C1245p0.class) {
                try {
                    if (f23640d == null) {
                        f23640d = new C1245p0(P1.a.a());
                    }
                } finally {
                }
            }
        }
        return f23640d;
    }

    public synchronized void g(long j5) {
        try {
            C0702g.b("LimitSalveClient", "LimitSalveClient setAdmin adminId = " + j5);
            com.stepos.familyguard.admin.a aVarB = com.stepos.familyguard.admin.a.b();
            ContentResolver contentResolver = P1.a.a().getContentResolver();
            if (DigitalWellbeingService.y(j5)) {
                T1.b.l(contentResolver, 0);
                aVarB.i(false);
                T1.b.m(contentResolver, true);
                T1.b.n(contentResolver, 0);
            } else {
                T1.b.l(contentResolver, 1);
                aVarB.i(true);
                T1.b.m(contentResolver, false);
                T1.b.n(contentResolver, 1);
            }
            try {
                try {
                    d().setCurrentAdmin(j5);
                    d().setEnable(true);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            } finally {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
