package b0;

import java.util.Comparator;

/* loaded from: classes.dex */
public final /* synthetic */ class q implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1317a;

    public /* synthetic */ q(int i2) {
        this.f1317a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f1317a) {
            case 0:
                return q7.k.f(((s0) obj).f1338b, ((s0) obj2).f1338b);
            case 1:
                i1.f0 f0Var = (i1.f0) obj;
                i1.f0 f0Var2 = (i1.f0) obj2;
                float f10 = f0Var.I.f4507o.H;
                float f11 = f0Var2.I.f4507o.H;
                return f10 == f11 ? q7.k.f(f0Var.o(), f0Var2.o()) : Float.compare(f10, f11);
            case 2:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    byte b10 = bArr[i2];
                    byte b11 = bArr2[i2];
                    if (b10 != b11) {
                        return b10 - b11;
                    }
                }
                return 0;
            default:
                c7.j jVar = (c7.j) obj;
                c7.j jVar2 = (c7.j) obj2;
                return (((Number) jVar.f1974g).intValue() - ((Number) jVar.f1973f).intValue()) - (((Number) jVar2.f1974g).intValue() - ((Number) jVar2.f1973f).intValue());
        }
    }
}
