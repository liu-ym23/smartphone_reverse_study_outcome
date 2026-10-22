package A2;

import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.internal.mlkit_vision_common.zziv;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public final class t5 implements k5 {

    /* renamed from: a, reason: collision with root package name */
    public final C3 f1002a;

    /* renamed from: b, reason: collision with root package name */
    public G4 f1003b = new G4();

    public t5(C3 c32, int i10) {
        this.f1002a = c32;
        F5.a();
    }

    public static k5 d(C3 c32) {
        return new t5(c32, 0);
    }

    @Override // A2.k5
    public final k5 a(zziv zzivVar) {
        this.f1002a.c(zzivVar);
        return this;
    }

    @Override // A2.k5
    public final k5 b(G4 g42) {
        this.f1003b = g42;
        return this;
    }

    @Override // A2.k5
    public final byte[] c(int i10, boolean z10) {
        this.f1003b.f(Boolean.valueOf(1 == (i10 ^ 1)));
        this.f1003b.e(Boolean.FALSE);
        this.f1002a.e(this.f1003b.m());
        try {
            F5.a();
            if (i10 == 0) {
                return new l3.d().g(M2.f449a).h(true).f().b(this.f1002a.f()).getBytes("utf-8");
            }
            E3 e3F = this.f1002a.f();
            C0650m c0650m = new C0650m();
            M2.f449a.a(c0650m);
            return c0650m.b().a(e3F);
        } catch (UnsupportedEncodingException e10) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e10);
        }
    }

    @Override // A2.k5
    public final String zzc() {
        I4 i4C = this.f1002a.f().c();
        return (i4C == null || C0614g2.b(i4C.k())) ? "NA" : (String) C1669j.k(i4C.k());
    }
}
