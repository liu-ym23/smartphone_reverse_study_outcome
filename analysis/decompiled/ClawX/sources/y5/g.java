package y5;

import k4.v;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f6351a = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f6352b = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f6353c = {3, 6};
    public static final int[] d = {1, 2, 4, 5, 7, 8};

    public static final long a(long j4, long j8) {
        if (j4 != 4611686018427387903L && j4 != -4611686018427387903L) {
            return (j8 == 4611686018427387903L || j8 == -4611686018427387903L) ? j8 : v.o(j4 + j8, -4611686018427387903L, 4611686018427387903L);
        }
        if ((-4611686018427387903L >= j8 || j8 >= 4611686018427387903L) && (j8 ^ j4) < 0) {
            return 9223372036854759646L;
        }
        return j4;
    }

    public static final long b(long j4, d sourceUnit, d targetUnit) {
        p.e(sourceUnit, "sourceUnit");
        p.e(targetUnit, "targetUnit");
        return targetUnit.f6346a.convert(j4, sourceUnit.f6346a);
    }

    public static final long c(long j4, d unit) {
        long j8;
        p.e(unit, "unit");
        int iOrdinal = unit.ordinal();
        if (iOrdinal == 2) {
            j8 = 1;
        } else if (iOrdinal == 3) {
            j8 = 1000;
        } else if (iOrdinal == 4) {
            j8 = 60000;
        } else if (iOrdinal == 5) {
            j8 = 3600000;
        } else {
            if (iOrdinal != 6) {
                throw new IllegalStateException(("Wrong unit for millisMultiplier: " + unit).toString());
            }
            j8 = 86400000;
        }
        if (j4 == 0) {
            return 0L;
        }
        if (j4 == 1) {
            if (j8 <= 4611686018427387903L) {
                return j8;
            }
        } else if (j8 != 1) {
            int iNumberOfLeadingZeros = (128 - Long.numberOfLeadingZeros(j4)) - Long.numberOfLeadingZeros(j8);
            if (iNumberOfLeadingZeros < 63) {
                return j4 * j8;
            }
            if (iNumberOfLeadingZeros <= 63) {
                long j9 = j4 * j8;
                if (j9 <= 4611686018427387903L) {
                    return j9;
                }
            }
        } else if (j4 <= 4611686018427387903L) {
            return j4;
        }
        return 4611686018427387903L;
    }

    public static final long d(long j4) {
        long j8 = (j4 << 1) + 1;
        b.f6335b.getClass();
        int i8 = c.f6339a;
        return j8;
    }

    public static final void e(StringBuilder sb, StringBuilder sb2, int i8) {
        if (i8 < 10) {
            sb.append('0');
        }
        sb2.append(i8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:180:0x02c8, code lost:
    
        throw new java.lang.IllegalArgumentException(com.stepos.stepclaw.SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0107, code lost:
    
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x010c, code lost:
    
        if (r8 == r23.length()) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0112, code lost:
    
        if (r3 == '+') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0114, code lost:
    
        if (r3 == '-') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0116, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0118, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x011c, code lost:
    
        if (r8 == (r20 + r3)) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x011e, code lost:
    
        r6 = r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0194 A[LOOP:7: B:108:0x0192->B:109:0x0194, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x018d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0157 A[LOOP:5: B:97:0x0155->B:98:0x0157, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long f(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.g.f(java.lang.String):long");
    }

    public static final androidx.emoji2.text.p g(String str, String str2, int i8, l lVar) {
        char cCharAt = str.charAt(i8);
        if (((Boolean) lVar.invoke(Character.valueOf(cCharAt))).booleanValue()) {
            return null;
        }
        return h(str, "Expected " + str2 + ", but got '" + cCharAt + "' at position " + i8);
    }

    public static final androidx.emoji2.text.p h(String str, String str2) {
        return new androidx.emoji2.text.p(str2 + " when parsing an Instant from \"" + k(64, str) + AbstractJsonLexerKt.STRING, str);
    }

    public static final int i(int i8, String str) {
        return (str.charAt(i8 + 1) - '0') + ((str.charAt(i8) - '0') * 10);
    }

    public static final long j(long j4, d unit) {
        p.e(unit, "unit");
        d dVar = d.f6340b;
        long jB = b(4611686018426999999L, dVar, unit);
        if ((-jB) <= j4 && j4 <= jB) {
            long jB2 = b(j4, unit, dVar);
            a aVar = b.f6335b;
            long j8 = jB2 << 1;
            int i8 = c.f6339a;
            return j8;
        }
        d targetUnit = d.f6341c;
        if (unit.compareTo(targetUnit) < 0) {
            p.e(targetUnit, "targetUnit");
            return d(v.o(targetUnit.f6346a.convert(j4, unit.f6346a), -4611686018427387903L, 4611686018427387903L));
        }
        long jSignum = Long.signum(j4);
        if (j4 < -9223372036854775807L) {
            j4 = -9223372036854775807L;
        }
        return d(c(Math.abs(j4), unit) * jSignum);
    }

    public static final String k(int i8, String str) {
        if (str.length() <= i8) {
            return str.toString();
        }
        return str.subSequence(0, i8).toString() + "...";
    }
}
