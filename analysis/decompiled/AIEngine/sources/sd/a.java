package sd;

import mb.c;
import okio.ByteString;
import sd.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final e.a f11899a = new e.a();

    /* renamed from: b, reason: collision with root package name */
    public static final int f11900b = -1234567890;

    public static final boolean a(int i10, int i11, int i12, byte[] a10, byte[] b10) {
        kotlin.jvm.internal.g.f(a10, "a");
        kotlin.jvm.internal.g.f(b10, "b");
        for (int i13 = 0; i13 < i12; i13++) {
            if (a10[i13 + i10] != b10[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "size=", " offset=");
            sbQ.append(j11);
            sbQ.append(" byteCount=");
            sbQ.append(j12);
            throw new ArrayIndexOutOfBoundsException(sbQ.toString());
        }
    }

    public static final int c(int i10, ByteString byteString) {
        return i10 == f11900b ? byteString.d() : i10;
    }

    public static final int d(int i10) {
        return ((i10 & 255) << 24) | (((-16777216) & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    public static final String e(int i10) {
        if (i10 == 0) {
            return "0";
        }
        char[] cArr = td.b.f13074a;
        int i11 = 0;
        char[] cArr2 = {cArr[(i10 >> 28) & 15], cArr[(i10 >> 24) & 15], cArr[(i10 >> 20) & 15], cArr[(i10 >> 16) & 15], cArr[(i10 >> 12) & 15], cArr[(i10 >> 8) & 15], cArr[(i10 >> 4) & 15], cArr[i10 & 15]};
        while (i11 < 8 && cArr2[i11] == '0') {
            i11++;
        }
        c.a.a(i11, 8, 8);
        return new String(cArr2, i11, 8 - i11);
    }
}
