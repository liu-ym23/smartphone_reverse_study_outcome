package x2;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f11145d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final int f11146a;

    /* renamed from: b, reason: collision with root package name */
    public final i5.f f11147b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f11148c = 0;

    public q(i5.f fVar, int i2) {
        this.f11147b = fVar;
        this.f11146a = i2;
    }

    public final int a(int i2) {
        y2.a aVarB = b();
        int iA = aVarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) aVarB.f3097i;
        int i10 = iA + aVarB.f3094f;
        return byteBuffer.getInt((i2 * 4) + byteBuffer.getInt(i10) + i10 + 4);
    }

    public final y2.a b() {
        ThreadLocal threadLocal = f11145d;
        y2.a aVar = (y2.a) threadLocal.get();
        if (aVar == null) {
            aVar = new y2.a();
            threadLocal.set(aVar);
        }
        y2.b bVar = (y2.b) this.f11147b.f4653g;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i2 = iA + bVar.f3094f;
            int i10 = (this.f11146a * 4) + ((ByteBuffer) bVar.f3097i).getInt(i2) + i2 + 4;
            int i11 = ((ByteBuffer) bVar.f3097i).getInt(i10) + i10;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.f3097i;
            aVar.f3097i = byteBuffer;
            if (byteBuffer != null) {
                aVar.f3094f = i11;
                int i12 = i11 - byteBuffer.getInt(i11);
                aVar.f3095g = i12;
                aVar.f3096h = ((ByteBuffer) aVar.f3097i).getShort(i12);
                return aVar;
            }
            aVar.f3094f = 0;
            aVar.f3095g = 0;
            aVar.f3096h = 0;
        }
        return aVar;
    }

    public final String toString() {
        int i2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        y2.a aVarB = b();
        int iA = aVarB.a(4);
        sb2.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) aVarB.f3097i).getInt(iA + aVarB.f3094f) : 0));
        sb2.append(", codepoints:");
        y2.a aVarB2 = b();
        int iA2 = aVarB2.a(16);
        if (iA2 != 0) {
            int i10 = iA2 + aVarB2.f3094f;
            i2 = ((ByteBuffer) aVarB2.f3097i).getInt(((ByteBuffer) aVarB2.f3097i).getInt(i10) + i10);
        } else {
            i2 = 0;
        }
        for (int i11 = 0; i11 < i2; i11++) {
            sb2.append(Integer.toHexString(a(i11)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
