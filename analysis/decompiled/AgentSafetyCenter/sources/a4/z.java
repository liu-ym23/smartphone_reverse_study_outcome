package a4;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f216d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public int f217a;

    /* renamed from: b, reason: collision with root package name */
    public p5.i f218b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f219c;

    public final int a(int i) {
        b4.a aVarB = b();
        int iA = aVarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) aVarB.f1900h;
        int i3 = iA + aVarB.f1897c;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i3) + i3 + 4);
    }

    public final b4.a b() {
        ThreadLocal threadLocal = f216d;
        b4.a aVar = (b4.a) threadLocal.get();
        if (aVar == null) {
            aVar = new b4.a();
            threadLocal.set(aVar);
        }
        b4.b bVar = (b4.b) this.f218b.f9730c;
        int i = this.f217a;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i3 = iA + bVar.f1897c;
            int i10 = (i * 4) + ((ByteBuffer) bVar.f1900h).getInt(i3) + i3 + 4;
            int i11 = ((ByteBuffer) bVar.f1900h).getInt(i10) + i10;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.f1900h;
            aVar.f1900h = byteBuffer;
            if (byteBuffer != null) {
                aVar.f1897c = i11;
                int i12 = i11 - byteBuffer.getInt(i11);
                aVar.f1898f = i12;
                aVar.f1899g = ((ByteBuffer) aVar.f1900h).getShort(i12);
                return aVar;
            }
            aVar.f1897c = 0;
            aVar.f1898f = 0;
            aVar.f1899g = 0;
        }
        return aVar;
    }

    public final String toString() {
        int i;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        b4.a aVarB = b();
        int iA = aVarB.a(4);
        sb2.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) aVarB.f1900h).getInt(iA + aVarB.f1897c) : 0));
        sb2.append(", codepoints:");
        b4.a aVarB2 = b();
        int iA2 = aVarB2.a(16);
        if (iA2 != 0) {
            int i3 = iA2 + aVarB2.f1897c;
            i = ((ByteBuffer) aVarB2.f1900h).getInt(((ByteBuffer) aVarB2.f1900h).getInt(i3) + i3);
        } else {
            i = 0;
        }
        for (int i10 = 0; i10 < i; i10++) {
            sb2.append(Integer.toHexString(a(i10)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
