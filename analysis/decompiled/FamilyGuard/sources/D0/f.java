package D0;

/* loaded from: classes.dex */
public final class f implements a<byte[]> {
    @Override // D0.a
    public String a() {
        return "ByteArrayPool";
    }

    @Override // D0.a
    public int b() {
        return 1;
    }

    @Override // D0.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int c(byte[] bArr) {
        return bArr.length;
    }

    @Override // D0.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i5) {
        return new byte[i5];
    }
}
