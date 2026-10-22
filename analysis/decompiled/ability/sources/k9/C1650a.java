package k9;

import g1.AbstractC1451a;
import kotlin.jvm.internal.k;
import kotlin.time.DurationUnit;
import z2.l;

/* renamed from: k9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1650a implements Comparable {
    public static final long b;
    public static final long c;
    public static final /* synthetic */ int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f4876a;

    static {
        int i = AbstractC1651b.f4877a;
        b = l.t(4611686018427387903L);
        c = l.t(-4611686018427387903L);
    }

    public static final long a(long j5, long j6) {
        long j10 = 1000000;
        long j11 = j6 / j10;
        long j12 = j5 + j11;
        if (-4611686018426L > j12 || j12 >= 4611686018427L) {
            return l.t(AbstractC1451a.v(j12, -4611686018427387903L, 4611686018427387903L));
        }
        return l.v((j12 * j10) + (j6 - (j11 * j10)));
    }

    public static final void b(StringBuilder sb, int i, int i6, int i10, String str, boolean z10) {
        CharSequence charSequenceSubSequence;
        sb.append(i);
        if (i6 != 0) {
            sb.append('.');
            String strValueOf = String.valueOf(i6);
            k.f(strValueOf, "<this>");
            if (i10 < 0) {
                throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i10, "Desired length ", " is less than zero."));
            }
            if (i10 <= strValueOf.length()) {
                charSequenceSubSequence = strValueOf.subSequence(0, strValueOf.length());
            } else {
                StringBuilder sb2 = new StringBuilder(i10);
                int length = i10 - strValueOf.length();
                int i11 = 1;
                if (1 <= length) {
                    while (true) {
                        sb2.append('0');
                        if (i11 == length) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                sb2.append((CharSequence) strValueOf);
                charSequenceSubSequence = sb2;
            }
            String string = charSequenceSubSequence.toString();
            int i12 = -1;
            int length2 = string.length() - 1;
            if (length2 >= 0) {
                while (true) {
                    int i13 = length2 - 1;
                    if (string.charAt(length2) != '0') {
                        i12 = length2;
                        break;
                    } else if (i13 < 0) {
                        break;
                    } else {
                        length2 = i13;
                    }
                }
            }
            int i14 = i12 + 1;
            if (z10 || i14 >= 3) {
                sb.append((CharSequence) string, 0, ((i12 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) string, 0, i14);
            }
        }
        sb.append(str);
    }

    public static final int c(long j5) {
        if (d(j5)) {
            return 0;
        }
        return (int) ((((int) j5) & 1) == 1 ? ((j5 >> 1) % 1000) * 1000000 : (j5 >> 1) % 1000000000);
    }

    public static final boolean d(long j5) {
        return j5 == b || j5 == c;
    }

    public static final long e(long j5, long j6) {
        if (d(j5)) {
            if (!d(j6) || (j6 ^ j5) >= 0) {
                return j5;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (d(j6)) {
            return j6;
        }
        int i = ((int) j5) & 1;
        if (i != (((int) j6) & 1)) {
            return i == 1 ? a(j5 >> 1, j6 >> 1) : a(j6 >> 1, j5 >> 1);
        }
        long j10 = (j5 >> 1) + (j6 >> 1);
        return i == 0 ? (-4611686018426999999L > j10 || j10 >= 4611686018427000000L) ? l.t(j10 / 1000000) : l.v(j10) : l.u(j10);
    }

    public static final long f(long j5, DurationUnit unit) {
        k.f(unit, "unit");
        if (j5 == b) {
            return Long.MAX_VALUE;
        }
        if (j5 == c) {
            return Long.MIN_VALUE;
        }
        long j6 = j5 >> 1;
        DurationUnit sourceUnit = (((int) j5) & 1) == 0 ? DurationUnit.b : DurationUnit.c;
        k.f(sourceUnit, "sourceUnit");
        return unit.f5171a.convert(j6, sourceUnit.f5171a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j5 = ((C1650a) obj).f4876a;
        long j6 = this.f4876a;
        long j10 = j6 ^ j5;
        if (j10 < 0 || (((int) j10) & 1) == 0) {
            return k.h(j6, j5);
        }
        int i = (((int) j6) & 1) - (((int) j5) & 1);
        return j6 < 0 ? -i : i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1650a) {
            return this.f4876a == ((C1650a) obj).f4876a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f4876a);
    }

    public final String toString() {
        long j5;
        int iF;
        long j6 = this.f4876a;
        if (j6 == 0) {
            return "0s";
        }
        if (j6 == b) {
            return "Infinity";
        }
        if (j6 == c) {
            return "-Infinity";
        }
        int i = 0;
        boolean z10 = j6 < 0;
        StringBuilder sb = new StringBuilder();
        if (z10) {
            sb.append('-');
        }
        if (j6 < 0) {
            j6 = (((int) j6) & 1) + ((-(j6 >> 1)) << 1);
            int i6 = AbstractC1651b.f4877a;
        }
        long jF = f(j6, DurationUnit.g);
        int iF2 = d(j6) ? 0 : (int) (f(j6, DurationUnit.f) % 24);
        if (d(j6)) {
            j5 = 0;
            iF = 0;
        } else {
            j5 = 0;
            iF = (int) (f(j6, DurationUnit.e) % 60);
        }
        int iF3 = d(j6) ? 0 : (int) (f(j6, DurationUnit.d) % 60);
        int iC = c(j6);
        boolean z11 = jF != j5;
        boolean z12 = iF2 != 0;
        boolean z13 = iF != 0;
        boolean z14 = (iF3 == 0 && iC == 0) ? false : true;
        if (z11) {
            sb.append(jF);
            sb.append('d');
            i = 1;
        }
        if (z12 || (z11 && (z13 || z14))) {
            int i10 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iF2);
            sb.append('h');
            i = i10;
        }
        if (z13 || (z14 && (z12 || z11))) {
            int i11 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iF);
            sb.append('m');
            i = i11;
        }
        if (z14) {
            int i12 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iF3 != 0 || z11 || z12 || z13) {
                b(sb, iF3, iC, 9, "s", false);
            } else if (iC >= 1000000) {
                b(sb, iC / 1000000, iC % 1000000, 6, "ms", false);
            } else if (iC >= 1000) {
                b(sb, iC / 1000, iC % 1000, 3, "us", false);
            } else {
                sb.append(iC);
                sb.append("ns");
            }
            i = i12;
        }
        if (z10 && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }
}
