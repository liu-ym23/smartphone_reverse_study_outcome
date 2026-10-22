package d7;

import c7.q;
import java.io.EOFException;
import kotlin.jvm.internal.p;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f1924a;

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f1925b;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(x5.a.f6276a);
        p.d(bytes, "getBytes(...)");
        f1924a = bytes;
        f1925b = new long[]{-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L, 9999999999999999L, 99999999999999999L, 999999999999999999L, Util.VLI_MAX};
    }

    public static final boolean a(q qVar, int i8, byte[] bArr, int i9, int i10) {
        int i11 = qVar.f1189c;
        byte[] bArr2 = qVar.f1187a;
        while (i9 < i10) {
            if (i8 == i11) {
                qVar = qVar.f1191f;
                p.b(qVar);
                byte[] bArr3 = qVar.f1187a;
                bArr2 = bArr3;
                i8 = qVar.f1188b;
                i11 = qVar.f1189c;
            }
            if (bArr2[i8] != bArr[i9]) {
                return false;
            }
            i8++;
            i9++;
        }
        return true;
    }

    public static final String b(long j4, c7.f fVar) throws EOFException {
        if (j4 > 0) {
            long j8 = j4 - 1;
            if (fVar.b(j8) == 13) {
                String strN = fVar.n(j8, x5.a.f6276a);
                fVar.skip(2L);
                return strN;
            }
        }
        String strN2 = fVar.n(j4, x5.a.f6276a);
        fVar.skip(1L);
        return strN2;
    }
}
