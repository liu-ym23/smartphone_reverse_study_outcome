package sb;

import n7.m;

/* loaded from: classes.dex */
public final class d extends m {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f9640a;

    /* renamed from: b, reason: collision with root package name */
    public e f9641b;

    public d(byte[] bArr) {
        super(true);
        byte[] bArr2 = new byte[32];
        this.f9640a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, 32);
    }

    public final void J(byte[] bArr, int i2, byte[] bArr2) {
        e eVar;
        synchronized (this.f9640a) {
            try {
                if (this.f9641b == null) {
                    this.f9641b = new e(vb.b.g(this.f9640a));
                }
                eVar = this.f9641b;
            } catch (Throwable th) {
                throw th;
            }
        }
        byte[] bArr3 = new byte[32];
        int[] iArr = (int[]) eVar.f9642a.f7326g;
        ub.a.h(iArr, 10, bArr3, 0);
        ub.a.h(iArr, 15, bArr3, 16);
        bArr3[31] = (byte) (((iArr[0] & 1) << 7) | bArr3[31]);
        vb.b.h(this.f9640a, bArr3, (byte) 0, bArr, i2, bArr2);
    }
}
