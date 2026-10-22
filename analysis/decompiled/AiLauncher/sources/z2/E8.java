package z2;

import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public final class E8 implements InterfaceC6244q8 {

    /* renamed from: a, reason: collision with root package name */
    public final U5 f44651a;

    /* renamed from: b, reason: collision with root package name */
    public N7 f44652b = new N7();

    /* renamed from: c, reason: collision with root package name */
    public final int f44653c;

    public E8(U5 u52, int i10) {
        this.f44651a = u52;
        O8.a();
        this.f44653c = i10;
    }

    public static InterfaceC6244q8 d(U5 u52) {
        return new E8(u52, 0);
    }

    public static InterfaceC6244q8 e(U5 u52, int i10) {
        return new E8(u52, 1);
    }

    @Override // z2.InterfaceC6244q8
    public final byte[] a(int i10, boolean z10) {
        this.f44652b.f(Boolean.valueOf(1 == (i10 ^ 1)));
        this.f44652b.e(Boolean.FALSE);
        this.f44651a.i(this.f44652b.m());
        try {
            O8.a();
            if (i10 == 0) {
                return new l3.d().g(S4.f44910a).h(true).f().b(this.f44651a.j()).getBytes("utf-8");
            }
            W5 w5J = this.f44651a.j();
            C6096c0 c6096c0 = new C6096c0();
            S4.f44910a.a(c6096c0);
            return c6096c0.b().a(w5J);
        } catch (UnsupportedEncodingException e10) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e10);
        }
    }

    @Override // z2.InterfaceC6244q8
    public final InterfaceC6244q8 b(zzrc zzrcVar) {
        this.f44651a.f(zzrcVar);
        return this;
    }

    @Override // z2.InterfaceC6244q8
    public final InterfaceC6244q8 c(N7 n72) {
        this.f44652b = n72;
        return this;
    }

    @Override // z2.InterfaceC6244q8
    public final int zza() {
        return this.f44653c;
    }

    @Override // z2.InterfaceC6244q8
    public final String zzd() {
        P7 p7G = this.f44651a.j().g();
        return (p7G == null || C6205n.b(p7G.k())) ? "NA" : (String) C1669j.k(p7G.k());
    }
}
