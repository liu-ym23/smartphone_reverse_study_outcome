package Nb;

import Mb.C0963a;
import Mb.C0966d;
import Mb.E;
import Mb.M;
import Mb.x;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import java.io.EOFException;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0016\n\u0002\b\u0003\u001a7\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u0014\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001aA\u0010\u001d\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"\u001a\u0010#\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010%¨\u0006'"}, d2 = {"LMb/E;", "segment", "", "segmentPos", "", SingleFileBundle.KEY_BYTES, "bytesOffset", "bytesLimit", "", "f", "(LMb/E;I[BII)Z", "LMb/d;", "", "newline", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/d;J)Ljava/lang/String;", "LMb/x;", "options", "selectTruncated", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LMb/d;LMb/x;Z)I", "v", Const.INTENT_KEY_UMID, "(J)I", "Lokio/ByteString;", "fromIndex", "toIndex", "byteCount", Const.INTENT_KEY_PKGNAME, "(LMb/d;Lokio/ByteString;JJII)J", Const.INTENT_KEY_APIKEY, "[B", "e", "()[B", "HEX_DIGIT_BYTES", "", "[J", "DigitCountToLargestValue", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f5036a = M.a("0123456789abcdef");

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f5037b = {-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L, 9999999999999999L, 99999999999999999L, 999999999999999999L, Long.MAX_VALUE};

    public static final long b(C0966d c0966d, ByteString bytes, long j10, long j11, int i10, int i11) {
        E e10;
        int i12;
        long j12 = j10;
        long size = j11;
        kotlin.jvm.internal.p.i(c0966d, "<this>");
        kotlin.jvm.internal.p.i(bytes, "bytes");
        long j13 = i11;
        C0963a.b(bytes.K(), i10, j13);
        if (i11 <= 0) {
            throw new IllegalArgumentException("byteCount == 0");
        }
        long size2 = 0;
        if (j12 < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j12).toString());
        }
        if (j12 > size) {
            throw new IllegalArgumentException(("fromIndex > toIndex: " + j12 + " > " + size).toString());
        }
        if (size > c0966d.getSize()) {
            size = c0966d.getSize();
        }
        long j14 = -1;
        if (j12 == size || (e10 = c0966d.head) == null) {
            return -1L;
        }
        if (c0966d.getSize() - j12 >= j12) {
            while (true) {
                long j15 = (e10.limit - e10.pos) + size2;
                if (j15 > j12) {
                    break;
                }
                e10 = e10.next;
                kotlin.jvm.internal.p.f(e10);
                size2 = j15;
            }
            byte[] bArrX = bytes.x();
            byte b10 = bArrX[i10];
            long jMin = Math.min(size, (c0966d.getSize() - j13) + 1);
            while (size2 < jMin) {
                byte[] bArr = e10.data;
                int iMin = (int) Math.min(e10.limit, (e10.pos + jMin) - size2);
                i12 = (int) ((e10.pos + j12) - size2);
                while (i12 < iMin) {
                    if (bArr[i12] != b10 || !f(e10, i12 + 1, bArrX, i10 + 1, i11)) {
                        i12++;
                    }
                }
                size2 += e10.limit - e10.pos;
                e10 = e10.next;
                kotlin.jvm.internal.p.f(e10);
                j12 = size2;
            }
            return -1L;
        }
        size2 = c0966d.getSize();
        while (size2 > j12) {
            e10 = e10.prev;
            kotlin.jvm.internal.p.f(e10);
            size2 -= e10.limit - e10.pos;
            j14 = j14;
        }
        long j16 = j14;
        byte[] bArrX2 = bytes.x();
        byte b11 = bArrX2[i10];
        long jMin2 = Math.min(size, (c0966d.getSize() - j13) + 1);
        while (size2 < jMin2) {
            byte[] bArr2 = e10.data;
            int iMin2 = (int) Math.min(e10.limit, (e10.pos + jMin2) - size2);
            i12 = (int) ((e10.pos + j12) - size2);
            while (i12 < iMin2) {
                if (bArr2[i12] != b11 || !f(e10, i12 + 1, bArrX2, i10 + 1, i11)) {
                    i12++;
                }
            }
            size2 += e10.limit - e10.pos;
            e10 = e10.next;
            kotlin.jvm.internal.p.f(e10);
            j12 = size2;
        }
        return j16;
        return (i12 - e10.pos) + size2;
    }

    public static /* synthetic */ long c(C0966d c0966d, ByteString byteString, long j10, long j11, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            j11 = Long.MAX_VALUE;
        }
        return b(c0966d, byteString, j10, j11, (i12 & 8) != 0 ? 0 : i10, (i12 & 16) != 0 ? byteString.K() : i11);
    }

    public static final int d(long j10) {
        int iNumberOfLeadingZeros = ((64 - Long.numberOfLeadingZeros(j10)) * 10) >>> 5;
        return iNumberOfLeadingZeros + (j10 > f5037b[iNumberOfLeadingZeros] ? 1 : 0);
    }

    public static final byte[] e() {
        return f5036a;
    }

    public static final boolean f(E segment, int i10, byte[] bytes, int i11, int i12) {
        kotlin.jvm.internal.p.i(segment, "segment");
        kotlin.jvm.internal.p.i(bytes, "bytes");
        int i13 = segment.limit;
        byte[] bArr = segment.data;
        while (i11 < i12) {
            if (i10 == i13) {
                segment = segment.next;
                kotlin.jvm.internal.p.f(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i10 = segment.pos;
                i13 = segment.limit;
            }
            if (bArr[i10] != bytes[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public static final String g(C0966d c0966d, long j10) throws EOFException {
        kotlin.jvm.internal.p.i(c0966d, "<this>");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (c0966d.Y(j11) == 13) {
                String strX0 = c0966d.x0(j11);
                c0966d.skip(2L);
                return strX0;
            }
        }
        String strX02 = c0966d.x0(j10);
        c0966d.skip(1L);
        return strX02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
    
        if (r19 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0087, code lost:
    
        return r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a5 A[LOOP:0: B:8:0x0026->B:46:0x00a5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int h(Mb.C0966d r17, Mb.x r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 172
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Nb.a.h(Mb.d, Mb.x, boolean):int");
    }

    public static /* synthetic */ int i(C0966d c0966d, x xVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return h(c0966d, xVar, z10);
    }
}
