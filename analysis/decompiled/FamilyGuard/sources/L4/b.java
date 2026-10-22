package L4;

import r4.C1020c;

/* loaded from: classes.dex */
public final class b {
    public static final void a(byte[] bArr, int i5, byte[] bArr2, int i6, int i7) {
        j4.k.h(bArr, "src");
        j4.k.h(bArr2, "dest");
        System.arraycopy(bArr, i5, bArr2, i6, i7);
    }

    public static final byte[] b(String str) {
        j4.k.h(str, "$receiver");
        byte[] bytes = str.getBytes(C1020c.f20083b);
        j4.k.c(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String c(byte[] bArr) {
        j4.k.h(bArr, "$receiver");
        return new String(bArr, C1020c.f20083b);
    }
}
