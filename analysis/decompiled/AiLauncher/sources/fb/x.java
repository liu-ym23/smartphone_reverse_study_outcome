package fb;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.io.EOFException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a-\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u0010\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0013\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0011\u001a-\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\u000e2\b\b\u0002\u0010\b\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u0019\u001a\u00020\u0018*\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0011\u0010\u001c\u001a\u00020\u001b*\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lfb/v;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lfb/v;)S", "", "byte", "", "startIndex", "endIndex", Const.INTENT_KEY_APIKEY, "(Lfb/v;BJJ)J", "", "c", "(Lfb/v;)[B", "", "byteCount", Const.INTENT_KEY_UMID, "(Lfb/v;I)[B", ContentDisposition.Parameters.Size, "e", "sink", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lfb/v;[BII)V", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lfb/v;)F", "", "f", "(Lfb/v;)D", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class x {
    public static final long a(v vVar, byte b10, long j10, long j11) {
        String str;
        kotlin.jvm.internal.p.i(vVar, "<this>");
        if (0 <= j10 && j10 <= j11) {
            if (j10 == j11) {
                return -1L;
            }
            long jN = j10;
            while (jN < j11 && vVar.request(1 + jN)) {
                byte b11 = b10;
                long jA = C4076c.a(vVar.a(), b11, jN, Math.min(j11, vVar.a().n()));
                if (jA != -1) {
                    return jA;
                }
                jN = vVar.a().n();
                b10 = b11;
            }
            return -1L;
        }
        if (j11 < 0) {
            str = "startIndex (" + j10 + ") and endIndex (" + j11 + ") should be non negative";
        } else {
            str = "startIndex (" + j10 + ") is not within the range [0..endIndex(" + j11 + "))";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public static /* synthetic */ long b(v vVar, byte b10, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        long j12 = j10;
        if ((i10 & 4) != 0) {
            j11 = Long.MAX_VALUE;
        }
        return a(vVar, b10, j12, j11);
    }

    public static final byte[] c(v vVar) {
        kotlin.jvm.internal.p.i(vVar, "<this>");
        return e(vVar, -1);
    }

    public static final byte[] d(v vVar, int i10) {
        kotlin.jvm.internal.p.i(vVar, "<this>");
        long j10 = i10;
        if (j10 >= 0) {
            return e(vVar, i10);
        }
        throw new IllegalArgumentException(("byteCount (" + j10 + ") < 0").toString());
    }

    public static final byte[] e(v vVar, int i10) {
        if (i10 == -1) {
            for (long j10 = 2147483647L; vVar.a().n() < 2147483647L && vVar.request(j10); j10 *= 2) {
            }
            if (vVar.a().n() >= 2147483647L) {
                throw new IllegalStateException(("Can't create an array of size " + vVar.a().n()).toString());
            }
            i10 = (int) vVar.a().n();
        } else {
            vVar.j(i10);
        }
        byte[] bArr = new byte[i10];
        j(vVar.a(), bArr, 0, 0, 6, null);
        return bArr;
    }

    public static final double f(v vVar) {
        kotlin.jvm.internal.p.i(vVar, "<this>");
        kotlin.jvm.internal.j jVar = kotlin.jvm.internal.j.f34830a;
        return Double.longBitsToDouble(vVar.readLong());
    }

    public static final float g(v vVar) {
        kotlin.jvm.internal.p.i(vVar, "<this>");
        kotlin.jvm.internal.k kVar = kotlin.jvm.internal.k.f34831a;
        return Float.intBitsToFloat(vVar.readInt());
    }

    public static final short h(v vVar) {
        kotlin.jvm.internal.p.i(vVar, "<this>");
        return C4073A.a(vVar.readShort());
    }

    public static final void i(v vVar, byte[] sink, int i10, int i11) {
        kotlin.jvm.internal.p.i(vVar, "<this>");
        kotlin.jvm.internal.p.i(sink, "sink");
        z.a(sink.length, i10, i11);
        int i12 = i10;
        while (i12 < i11) {
            int iG0 = vVar.G0(sink, i12, i11);
            if (iG0 == -1) {
                throw new EOFException("Source exhausted before reading " + (i11 - i10) + " bytes. Only " + iG0 + " bytes were read.");
            }
            i12 += iG0;
        }
    }

    public static /* synthetic */ void j(v vVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        i(vVar, bArr, i10, i11);
    }
}
