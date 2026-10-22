package t7;

import androidx.emoji2.text.m;
import java.math.BigInteger;
import k4.z;
import p7.h;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final c f5602a;

    /* renamed from: b, reason: collision with root package name */
    public final m f5603b;

    public b(h hVar, c cVar) {
        this.f5602a = cVar;
        this.f5603b = new m(hVar.j(cVar.f5604a));
    }

    public final BigInteger[] a(BigInteger bigInteger) {
        d dVar = this.f5602a.f5605b;
        int i8 = dVar.f5611g;
        BigInteger bigIntegerG = z.g(bigInteger, dVar.f5609e, i8);
        BigInteger bigIntegerG2 = z.g(bigInteger, dVar.f5610f, i8);
        return new BigInteger[]{bigInteger.subtract(bigIntegerG.multiply(dVar.f5606a).add(bigIntegerG2.multiply(dVar.f5608c))), bigIntegerG.multiply(dVar.f5607b).add(bigIntegerG2.multiply(dVar.d)).negate()};
    }
}
