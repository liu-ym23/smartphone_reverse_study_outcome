package l5;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10341a = new int[0];

    public static int a(int i10, int i11) {
        int i12 = i10 < 0 ? 5 : 0;
        if (i10 == 10) {
            i12 |= 1;
        }
        if (i11 < 0) {
            i12 |= 10;
        }
        if (i11 == 10) {
            i12 |= 2;
        }
        return c(i10) != c(i11) ? i12 | 16 : i12 | 32;
    }

    public static void b(StringBuilder sb2, int i10) {
        if (i10 > 255 ? jd.b.x(i.I, i10) || jd.b.x(i.J, i10) || jd.b.x(i.K, i10) || jd.b.x(i.E, i10) || jd.b.x(i.F, i10) : (i10 >= 32 && i10 < 127) || (i10 >= 161 && i10 != 173)) {
            if ("\\.+*?()|[]{}^$".indexOf((char) i10) >= 0) {
                sb2.append('\\');
            }
            sb2.appendCodePoint(i10);
            return;
        }
        if (i10 == 12) {
            sb2.append("\\f");
            return;
        }
        if (i10 == 13) {
            sb2.append("\\r");
            return;
        }
        if (i10 == 34) {
            sb2.append("\\\"");
            return;
        }
        if (i10 == 92) {
            sb2.append("\\\\");
            return;
        }
        switch (i10) {
            case 8:
                sb2.append("\\b");
                break;
            case 9:
                sb2.append("\\t");
                break;
            case 10:
                sb2.append("\\n");
                break;
            default:
                String hexString = Integer.toHexString(i10);
                if (i10 >= 256) {
                    sb2.append("\\x{");
                    sb2.append(hexString);
                    sb2.append('}');
                    break;
                } else {
                    sb2.append("\\x");
                    if (hexString.length() == 1) {
                        sb2.append('0');
                    }
                    sb2.append(hexString);
                    break;
                }
        }
    }

    public static boolean c(int i10) {
        if (65 <= i10 && i10 <= 90) {
            return true;
        }
        if (97 > i10 || i10 > 122) {
            return (48 <= i10 && i10 <= 57) || i10 == 95;
        }
        return true;
    }

    public static boolean d(int i10) {
        if (48 <= i10 && i10 <= 57) {
            return true;
        }
        if (65 > i10 || i10 > 90) {
            return 97 <= i10 && i10 <= 122;
        }
        return true;
    }

    public static int e(int i10) {
        if (48 <= i10 && i10 <= 57) {
            return i10 - 48;
        }
        if (97 <= i10 && i10 <= 102) {
            return i10 - 87;
        }
        if (65 > i10 || i10 > 70) {
            return -1;
        }
        return i10 - 55;
    }
}
