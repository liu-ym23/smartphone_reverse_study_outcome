package fb;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import java.io.EOFException;
import jb.C4790a;
import kb.C4845d;
import kb.InterfaceC4843b;
import kb.InterfaceC4844c;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u001a-\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\n\u001a\u00020\u0001*\u00020\t¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\r\u001a\u00020\u0001*\u00020\f¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\u0011\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lfb/s;", "", "string", "", "startIndex", "endIndex", "LY8/t;", "e", "(Lfb/s;Ljava/lang/String;II)V", "Lfb/v;", "c", "(Lfb/v;)Ljava/lang/String;", "Lfb/a;", Const.INTENT_KEY_PKGNAME, "(Lfb/a;)Ljava/lang/String;", "", "byteCount", Const.INTENT_KEY_UMID, "(Lfb/v;J)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "(Lfb/a;J)Ljava/lang/String;", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class y {
    public static final String a(C4074a c4074a, long j10) throws EOFException {
        if (j10 == 0) {
            return "";
        }
        C4845d c4845d = C4845d.f34666a;
        o head = c4074a.getHead();
        if (head == null) {
            throw new IllegalStateException("Unreacheable");
        }
        InterfaceC4843b unused = kb.e.f34667a;
        if (head.j() < j10) {
            return C4790a.b(x.d(c4074a, (int) j10), 0, 0, 3, null);
        }
        byte[] bArrB = head.b(true);
        int pos = head.getPos();
        String strA = C4790a.a(bArrB, pos, Math.min(head.getLimit(), ((int) j10) + pos));
        c4074a.skip(j10);
        return strA;
    }

    public static final String b(C4074a c4074a) {
        kotlin.jvm.internal.p.i(c4074a, "<this>");
        return a(c4074a, c4074a.n());
    }

    public static final String c(v vVar) {
        kotlin.jvm.internal.p.i(vVar, "<this>");
        vVar.request(Long.MAX_VALUE);
        return a(vVar.getBufferField(), vVar.getBufferField().n());
    }

    public static final String d(v vVar, long j10) {
        kotlin.jvm.internal.p.i(vVar, "<this>");
        vVar.j(j10);
        return a(vVar.getBufferField(), j10);
    }

    public static final void e(s sVar, String string, int i10, int i11) {
        int i12;
        kotlin.jvm.internal.p.i(sVar, "<this>");
        kotlin.jvm.internal.p.i(string, "string");
        int i13 = i10;
        z.a(string.length(), i13, i11);
        C4074a bufferField = sVar.getBufferField();
        while (i13 < i11) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            char cCharAt = string.charAt(i13);
            ref$IntRef.f34818a = cCharAt;
            if (cCharAt < 128) {
                C4845d c4845d = C4845d.f34666a;
                o oVarK0 = bufferField.k0(1);
                InterfaceC4844c interfaceC4844c = kb.e.f34668b;
                int i14 = -i13;
                int iMin = Math.min(i11, oVarK0.h() + i13);
                interfaceC4844c.d(oVarK0, i13 + i14, (byte) ref$IntRef.f34818a);
                i13++;
                while (i13 < iMin) {
                    char cCharAt2 = string.charAt(i13);
                    ref$IntRef.f34818a = cCharAt2;
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    interfaceC4844c.d(oVarK0, i13 + i14, (byte) cCharAt2);
                    i13++;
                }
                int i15 = i14 + i13;
                if (i15 == 1) {
                    oVarK0.s(oVarK0.getLimit() + i15);
                    bufferField.Y(bufferField.getSizeMut() + i15);
                } else {
                    if (i15 < 0 || i15 > oVarK0.h()) {
                        throw new IllegalStateException(("Invalid number of bytes written: " + i15 + ". Should be in 0.." + oVarK0.h()).toString());
                    }
                    if (i15 != 0) {
                        oVarK0.s(oVarK0.getLimit() + i15);
                        bufferField.Y(bufferField.getSizeMut() + i15);
                    } else if (q.b(oVarK0)) {
                        bufferField.U();
                    }
                }
            } else {
                if (cCharAt < 2048) {
                    C4845d c4845d2 = C4845d.f34666a;
                    i12 = 2;
                    o oVarK02 = bufferField.k0(2);
                    InterfaceC4844c interfaceC4844c2 = kb.e.f34668b;
                    int i16 = ref$IntRef.f34818a;
                    interfaceC4844c2.a(oVarK02, 0, (byte) ((i16 >> 6) | 192), (byte) ((i16 & 63) | 128));
                    oVarK02.s(oVarK02.getLimit() + 2);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    C4845d c4845d3 = C4845d.f34666a;
                    i12 = 3;
                    o oVarK03 = bufferField.k0(3);
                    InterfaceC4844c interfaceC4844c3 = kb.e.f34668b;
                    int i17 = ref$IntRef.f34818a;
                    interfaceC4844c3.b(oVarK03, 0, (byte) ((i17 >> 12) | 224), (byte) (((i17 >> 6) & 63) | 128), (byte) ((i17 & 63) | 128));
                    oVarK03.s(oVarK03.getLimit() + 3);
                } else {
                    int i18 = i13 + 1;
                    char cCharAt3 = i18 < i11 ? string.charAt(i18) : (char) 0;
                    int i19 = ref$IntRef.f34818a;
                    if (i19 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        bufferField.H0((byte) 63);
                        i13 = i18;
                    } else {
                        int i20 = (((i19 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) << 10) | (cCharAt3 & 1023)) + 65536;
                        C4845d c4845d4 = C4845d.f34666a;
                        o oVarK04 = bufferField.k0(4);
                        kb.e.f34668b.c(oVarK04, 0, (byte) ((i20 >> 18) | 240), (byte) (((i20 >> 12) & 63) | 128), (byte) (((i20 >> 6) & 63) | 128), (byte) ((i20 & 63) | 128));
                        oVarK04.s(oVarK04.getLimit() + 4);
                        bufferField.Y(bufferField.getSizeMut() + 4);
                        i13 += 2;
                    }
                }
                bufferField.Y(bufferField.getSizeMut() + i12);
                i13++;
            }
        }
        sVar.X();
    }

    public static /* synthetic */ void f(s sVar, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        e(sVar, str, i10, i11);
    }
}
