package L0;

import C0.v;
import X0.j;

/* loaded from: classes.dex */
public class b implements v<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f3805a;

    public b(byte[] bArr) {
        this.f3805a = (byte[]) j.d(bArr);
    }

    @Override // C0.v
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f3805a;
    }

    @Override // C0.v
    public void b() {
    }

    @Override // C0.v
    public int c() {
        return this.f3805a.length;
    }

    @Override // C0.v
    public Class<byte[]> d() {
        return byte[].class;
    }
}
