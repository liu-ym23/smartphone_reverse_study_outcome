package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class z {
    public static final ThreadLocal d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final int f650a;

    /* renamed from: b, reason: collision with root package name */
    public final a1.w f651b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f652c = 0;

    public z(a1.w wVar, int i8) {
        this.f651b = wVar;
        this.f650a = i8;
    }

    public final int a(int i8) {
        o0.a aVarB = b();
        int iA = aVarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) aVarB.d;
        int i9 = iA + aVarB.f1830a;
        return byteBuffer.getInt((i8 * 4) + byteBuffer.getInt(i9) + i9 + 4);
    }

    public final o0.a b() {
        ThreadLocal threadLocal = d;
        o0.a aVar = (o0.a) threadLocal.get();
        if (aVar == null) {
            aVar = new o0.a();
            threadLocal.set(aVar);
        }
        o0.b bVar = (o0.b) this.f651b.f75b;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i8 = iA + bVar.f1830a;
            int i9 = (this.f650a * 4) + ((ByteBuffer) bVar.d).getInt(i8) + i8 + 4;
            int i10 = ((ByteBuffer) bVar.d).getInt(i9) + i9;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.d;
            aVar.d = byteBuffer;
            if (byteBuffer != null) {
                aVar.f1830a = i10;
                int i11 = i10 - byteBuffer.getInt(i10);
                aVar.f1831b = i11;
                aVar.f1832c = ((ByteBuffer) aVar.d).getShort(i11);
                return aVar;
            }
            aVar.f1830a = 0;
            aVar.f1831b = 0;
            aVar.f1832c = 0;
        }
        return aVar;
    }

    public final String toString() {
        int i8;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        o0.a aVarB = b();
        int iA = aVarB.a(4);
        sb.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) aVarB.d).getInt(iA + aVarB.f1830a) : 0));
        sb.append(", codepoints:");
        o0.a aVarB2 = b();
        int iA2 = aVarB2.a(16);
        if (iA2 != 0) {
            int i9 = iA2 + aVarB2.f1830a;
            i8 = ((ByteBuffer) aVarB2.d).getInt(((ByteBuffer) aVarB2.d).getInt(i9) + i9);
        } else {
            i8 = 0;
        }
        for (int i10 = 0; i10 < i8; i10++) {
            sb.append(Integer.toHexString(a(i10)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
