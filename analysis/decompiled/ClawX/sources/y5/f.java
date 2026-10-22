package y5;

import java.io.Serializable;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final e f6347c = new e();
    public static final f d = new f(0, -31557014167219200L);

    /* renamed from: e, reason: collision with root package name */
    public static final f f6348e = new f(999999999, 31556889864403199L);

    /* renamed from: a, reason: collision with root package name */
    public final long f6349a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6350b;

    public f(int i8, long j4) {
        this.f6349a = j4;
        this.f6350b = i8;
        if (-31557014167219200L > j4 || j4 >= 31556889864403200L) {
            throw new IllegalArgumentException("Instant exceeds minimum or maximum instant");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        f other = (f) obj;
        p.e(other, "other");
        int iH = p.h(this.f6349a, other.f6349a);
        return iH != 0 ? iH : p.g(this.f6350b, other.f6350b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f6349a == fVar.f6349a && this.f6350b == fVar.f6350b;
    }

    public final int hashCode() {
        return (this.f6350b * 51) + Long.hashCode(this.f6349a);
    }

    public final String toString() {
        long j4;
        int[] iArr;
        StringBuilder sb = new StringBuilder();
        long j8 = this.f6349a;
        long j9 = j8 / 86400;
        long j10 = 0;
        if ((j8 ^ 86400) < 0 && j9 * 86400 != j8) {
            j9--;
        }
        long j11 = j8 % 86400;
        int i8 = (int) (j11 + (86400 & (((j11 ^ 86400) & ((-j11) | j11)) >> 63)));
        long j12 = (j9 + 719528) - 60;
        if (j12 < 0) {
            long j13 = 146097;
            long j14 = ((j12 + 1) / j13) - 1;
            j4 = 0;
            j10 = 400 * j14;
            j12 += (-j14) * j13;
        } else {
            j4 = 0;
        }
        long j15 = 400;
        long j16 = ((j15 * j12) + 591) / 146097;
        long j17 = 365;
        long j18 = 4;
        long j19 = 100;
        long j20 = j12 - ((j16 / j15) + (((j16 / j18) + (j17 * j16)) - (j16 / j19)));
        if (j20 < j4) {
            j16--;
            j20 = j12 - ((j16 / j15) + (((j16 / j18) + (j17 * j16)) - (j16 / j19)));
        }
        int i9 = (int) j20;
        int i10 = ((i9 * 5) + 2) / 153;
        int i11 = ((i10 + 2) % 12) + 1;
        int i12 = (i9 - (((i10 * 306) + 5) / 10)) + 1;
        int i13 = (int) (j16 + j10 + (i10 / 10));
        int i14 = i8 / 3600;
        int i15 = i8 - (i14 * 3600);
        int i16 = i15 / 60;
        int i17 = i15 - (i16 * 60);
        int i18 = 0;
        if (Math.abs(i13) < 1000) {
            StringBuilder sb2 = new StringBuilder();
            if (i13 >= 0) {
                sb2.append(i13 + 10000);
                p.d(sb2.deleteCharAt(0), "deleteCharAt(...)");
            } else {
                sb2.append(i13 - 10000);
                p.d(sb2.deleteCharAt(1), "deleteCharAt(...)");
            }
            sb.append((CharSequence) sb2);
        } else {
            if (i13 >= 10000) {
                sb.append('+');
            }
            sb.append(i13);
        }
        sb.append('-');
        g.e(sb, sb, i11);
        sb.append('-');
        g.e(sb, sb, i12);
        sb.append('T');
        g.e(sb, sb, i14);
        sb.append(AbstractJsonLexerKt.COLON);
        g.e(sb, sb, i16);
        sb.append(AbstractJsonLexerKt.COLON);
        g.e(sb, sb, i17);
        int i19 = this.f6350b;
        if (i19 != 0) {
            sb.append('.');
            while (true) {
                int i20 = i18 + 1;
                iArr = g.f6351a;
                if (i19 % iArr[i20] != 0) {
                    break;
                }
                i18 = i20;
            }
            int i21 = i18 - (i18 % 3);
            String strValueOf = String.valueOf((i19 / iArr[i21]) + iArr[9 - i21]);
            p.c(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strValueOf.substring(1);
            p.d(strSubstring, "substring(...)");
            sb.append(strSubstring);
        }
        sb.append('Z');
        return sb.toString();
    }
}
