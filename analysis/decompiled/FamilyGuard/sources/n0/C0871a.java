package n0;

/* renamed from: n0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0871a {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f18837a;

    /* renamed from: b, reason: collision with root package name */
    public int f18838b;

    public C0871a() {
        this.f18837a = new byte[64];
    }

    private void a(int i5) {
        byte[] bArr = this.f18837a;
        int length = bArr.length * 2;
        int i6 = this.f18838b;
        int i7 = i5 + i6;
        if (length <= i7) {
            length = i7;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i6);
        this.f18837a = bArr2;
    }

    C0871a b(int i5, int i6) {
        int i7 = this.f18838b;
        if (i7 + 2 > this.f18837a.length) {
            a(2);
        }
        byte[] bArr = this.f18837a;
        bArr[i7] = (byte) i5;
        bArr[i7 + 1] = (byte) i6;
        this.f18838b = i7 + 2;
        return this;
    }

    public C0871a c(int i5, int i6) {
        int i7 = this.f18838b;
        if (i7 + 3 > this.f18837a.length) {
            a(3);
        }
        byte[] bArr = this.f18837a;
        bArr[i7] = (byte) i5;
        bArr[i7 + 1] = (byte) (i6 >>> 8);
        bArr[i7 + 2] = (byte) i6;
        this.f18838b = i7 + 3;
        return this;
    }

    public C0871a d(int i5) {
        int i6 = this.f18838b;
        int i7 = i6 + 1;
        if (i7 > this.f18837a.length) {
            a(1);
        }
        this.f18837a[i6] = (byte) i5;
        this.f18838b = i7;
        return this;
    }

    public C0871a e(byte[] bArr, int i5, int i6) {
        if (this.f18838b + i6 > this.f18837a.length) {
            a(i6);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i5, this.f18837a, this.f18838b, i6);
        }
        this.f18838b += i6;
        return this;
    }

    public C0871a f(int i5) {
        int i6 = this.f18838b;
        if (i6 + 4 > this.f18837a.length) {
            a(4);
        }
        byte[] bArr = this.f18837a;
        bArr[i6] = (byte) (i5 >>> 24);
        bArr[i6 + 1] = (byte) (i5 >>> 16);
        bArr[i6 + 2] = (byte) (i5 >>> 8);
        bArr[i6 + 3] = (byte) i5;
        this.f18838b = i6 + 4;
        return this;
    }

    public C0871a g(int i5) {
        int i6 = this.f18838b;
        if (i6 + 2 > this.f18837a.length) {
            a(2);
        }
        byte[] bArr = this.f18837a;
        bArr[i6] = (byte) (i5 >>> 8);
        bArr[i6 + 1] = (byte) i5;
        this.f18838b = i6 + 2;
        return this;
    }

    public C0871a h(String str) {
        int length = str.length();
        int i5 = this.f18838b;
        if (i5 + 2 + length > this.f18837a.length) {
            a(length + 2);
        }
        byte[] bArr = this.f18837a;
        int i6 = i5 + 1;
        bArr[i5] = (byte) (length >>> 8);
        int i7 = i5 + 2;
        bArr[i6] = (byte) length;
        int i8 = 0;
        while (i8 < length) {
            char cCharAt = str.charAt(i8);
            if ((cCharAt < 1 || cCharAt > 127) && (cCharAt < 19968 || cCharAt > 40959)) {
                throw new UnsupportedOperationException();
            }
            bArr[i7] = (byte) cCharAt;
            i8++;
            i7++;
        }
        this.f18838b = i7;
        return this;
    }

    public C0871a(int i5) {
        this.f18837a = new byte[i5];
    }
}
