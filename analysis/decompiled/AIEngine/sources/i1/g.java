package i1;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<j1.a> f9442d = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    public final int f9443a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.emoji2.text.h f9444b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f9445c = 0;

    public g(androidx.emoji2.text.h hVar, int i10) {
        this.f9444b = hVar;
        this.f9443a = i10;
    }

    public final int a(int i10) {
        j1.a aVarB = b();
        int iA = aVarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = aVarB.f9653b;
        int i11 = iA + aVarB.f9652a;
        return byteBuffer.getInt((i10 * 4) + byteBuffer.getInt(i11) + i11 + 4);
    }

    public final j1.a b() {
        ThreadLocal<j1.a> threadLocal = f9442d;
        j1.a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new j1.a();
            threadLocal.set(aVar);
        }
        j1.b bVar = this.f9444b.f1966a;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i10 = iA + bVar.f9652a;
            int i11 = (this.f9443a * 4) + bVar.f9653b.getInt(i10) + i10 + 4;
            int i12 = bVar.f9653b.getInt(i11) + i11;
            ByteBuffer byteBuffer = bVar.f9653b;
            aVar.f9653b = byteBuffer;
            if (byteBuffer != null) {
                aVar.f9652a = i12;
                int i13 = i12 - byteBuffer.getInt(i12);
                aVar.f9654c = i13;
                aVar.f9655d = aVar.f9653b.getShort(i13);
                return aVar;
            }
            aVar.f9652a = 0;
            aVar.f9654c = 0;
            aVar.f9655d = 0;
        }
        return aVar;
    }

    public final String toString() {
        int i10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        j1.a aVarB = b();
        int iA = aVarB.a(4);
        sb2.append(Integer.toHexString(iA != 0 ? aVarB.f9653b.getInt(iA + aVarB.f9652a) : 0));
        sb2.append(", codepoints:");
        j1.a aVarB2 = b();
        int iA2 = aVarB2.a(16);
        if (iA2 != 0) {
            int i11 = iA2 + aVarB2.f9652a;
            i10 = aVarB2.f9653b.getInt(aVarB2.f9653b.getInt(i11) + i11);
        } else {
            i10 = 0;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            sb2.append(Integer.toHexString(a(i12)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
