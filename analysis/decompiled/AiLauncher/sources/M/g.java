package M;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: e, reason: collision with root package name */
    public static final Charset f4475e = StandardCharsets.US_ASCII;

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f4476f = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f4477g = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f4478h = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: a, reason: collision with root package name */
    public final int f4479a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4480b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4481c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f4482d;

    public g(int i10, int i11, byte[] bArr) {
        this(i10, i11, -1L, bArr);
    }

    public static g a(String str) {
        if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
            return new g(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }
        byte[] bytes = str.getBytes(f4475e);
        return new g(1, bytes.length, bytes);
    }

    public static g b(double[] dArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[f4477g[12] * dArr.length]);
        byteBufferWrap.order(byteOrder);
        for (double d10 : dArr) {
            byteBufferWrap.putDouble(d10);
        }
        return new g(12, dArr.length, byteBufferWrap.array());
    }

    public static g c(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[f4477g[9] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i10 : iArr) {
            byteBufferWrap.putInt(i10);
        }
        return new g(9, iArr.length, byteBufferWrap.array());
    }

    public static g d(i[] iVarArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[f4477g[10] * iVarArr.length]);
        byteBufferWrap.order(byteOrder);
        for (i iVar : iVarArr) {
            byteBufferWrap.putInt((int) iVar.b());
            byteBufferWrap.putInt((int) iVar.a());
        }
        return new g(10, iVarArr.length, byteBufferWrap.array());
    }

    public static g e(String str) {
        byte[] bytes = (str + (char) 0).getBytes(f4475e);
        return new g(2, bytes.length, bytes);
    }

    public static g f(long j10, ByteOrder byteOrder) {
        return g(new long[]{j10}, byteOrder);
    }

    public static g g(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[f4477g[4] * jArr.length]);
        byteBufferWrap.order(byteOrder);
        for (long j10 : jArr) {
            byteBufferWrap.putInt((int) j10);
        }
        return new g(4, jArr.length, byteBufferWrap.array());
    }

    public static g h(i[] iVarArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[f4477g[5] * iVarArr.length]);
        byteBufferWrap.order(byteOrder);
        for (i iVar : iVarArr) {
            byteBufferWrap.putInt((int) iVar.b());
            byteBufferWrap.putInt((int) iVar.a());
        }
        return new g(5, iVarArr.length, byteBufferWrap.array());
    }

    public static g i(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[f4477g[3] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i10 : iArr) {
            byteBufferWrap.putShort((short) i10);
        }
        return new g(3, iArr.length, byteBufferWrap.array());
    }

    public int j() {
        return f4477g[this.f4479a] * this.f4480b;
    }

    public String toString() {
        return "(" + f4476f[this.f4479a] + ", data length:" + this.f4482d.length + ")";
    }

    public g(int i10, int i11, long j10, byte[] bArr) {
        this.f4479a = i10;
        this.f4480b = i11;
        this.f4481c = j10;
        this.f4482d = bArr;
    }
}
