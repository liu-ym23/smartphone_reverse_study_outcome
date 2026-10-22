package N1;

import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f4190a = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

    /* renamed from: b, reason: collision with root package name */
    private static final TimeZone f4191b = TimeZone.getTimeZone("UTC");

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f4192c = {701770, 8697535, 306771, 677704, 5580477, 861776, 890180, 4631225, 354893, 634178, 2404022, 306762, 6966718, 675154, 861510, 6116026, 742478, 879171, 2714935, 613195, 7642049, 300884, 674632, 5973436, 435536, 447557, 4905656, 177741, 612162, 2398135, 300874, 6703934, 870993, 959814, 5690554, 372046, 177732, 3749688, 601675, 8165055, 824659, 870984, 7185723, 742735, 354885, 4894137, 154957, 601410, 2921910, 693578, 8080061, 445009, 742726, 5593787, 318030, 678723, 3484600, 338764, 9082175, 955730, 436808, 7001404, 701775, 308805, 4871993, 677709, 337474, 4100917, 890185, 7711422, 354897, 617798, 5549755, 306511, 675139, 5056183, 861515, 9261759, 742482, 748103, 6909244, 613200, 301893, 4869049, 674637, 11216322, 435540, 447561, 7002685, 702033, 612166, 5543867, 300879, 412484, 3581239, 959818, 8827583, 371795, 702023, 5846716, 601680, 824901, 5065400, 870988, 894273, 2468534, 354889, 8039869, 154962, 601415, 6067642, 693582, 739907, 4937015, 709962, 9788095, 309843, 678728, 6630332, 338768, 693061, 4672185, 436812, 709953, 2415286, 308810, 6969149, 675409, 861766, 6198074, 873293, 371267, 3585335, 617803, 11841215, 306515, 675144, 7153084, 861519, 873028, 6138424, 744012, 355649, 2403766, 301898, 8014782, 674641, 697670, 5984954, 447054, 711234, 3496759, 603979, 8689601, 300883, 412488, 6726972, 959823, 436804, 4896312, 699980, 601666, 3970869, 824905, 8211133, 870993, 894277, 5614266, 354894, 683331, 4533943, 339275, 9082303, 693587, 739911, 7034171, 709967, 350789, 4873528, 678732, 338754, 3838902, 430921, 7809469, 436817, 709958, 5561018, 308814, 677699, 4532024, 861770, 9343806, 873042, 895559, 6731067, 355663, 306757, 4869817, 675148, 857409, 2986677};

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f4193d = Pattern.compile("(19|20)[0-9]{2}-((0)?[1-9]|1[012])-((0)?[1-9]|(1|2)[0-9]|30)$");

    private static int a(int i5, int i6) {
        if (i5 < 1899) {
            i5 = 1899;
        }
        return (f4192c[i5 - 1899] & (1048576 >> i6)) == 0 ? 29 : 30;
    }

    private static int b(int i5) {
        int i6 = d(i5) != 0 ? 377 : 348;
        int i7 = f4192c[i5 - 1899] & 1048448;
        for (int i8 = 524288; i8 > 7; i8 >>= 1) {
            if ((i7 & i8) != 0) {
                i6++;
            }
        }
        return i6;
    }

    public static final int c(int i5, int i6, boolean z5) {
        int iD = d(i5);
        int i7 = (iD == 0 || i6 <= iD) ? 0 : 1;
        if (!z5) {
            return a(i5, i6 + i7);
        }
        if (iD == 0 || iD != i6) {
            return 0;
        }
        return a(i5, i6 + 1);
    }

    public static int d(int i5) {
        if (i5 < 1899) {
            i5 = 1899;
        }
        return (f4192c[Math.min(r1.length - 1, i5 - 1899)] & 15728640) >> 20;
    }

    public static final int[] e(int i5, int i6, int i7, boolean z5) {
        if (i5 < 1899) {
            i5 = 1899;
        } else if (i5 > 2099) {
            i5 = 2099;
        }
        if (i6 < 1) {
            i6 = 1;
        } else if (i6 > 12) {
            i6 = 12;
        }
        if (i7 < 1) {
            i7 = 1;
        } else if (i7 > 30) {
            i7 = 30;
        }
        if (i5 < 1899 || i5 > 2099 || i6 < 1 || i6 > 12 || i7 < 1 || i7 > 30) {
            throw new IllegalArgumentException("Illegal lunar date, must be like that:\n\tyear : 1900~2099\n\tmonth : 1~12\n\tday : 1~30\n\terror date:" + i5 + " " + i6 + " " + i7);
        }
        int i8 = i5 - 1899;
        int i9 = f4192c[i8];
        int i10 = i9 & 31;
        int i11 = i10 - 1;
        if (i8 != 1) {
            i10 = i11;
        }
        if (((i9 & 96) >> 5) == 2) {
            i10 += 31;
        }
        for (int i12 = 1; i12 < i6; i12++) {
            i10 = ((524288 >> (i12 + (-1))) & f4192c[i8]) == 0 ? i10 + 29 : i10 + 30;
        }
        int i13 = i10 + i7;
        int i14 = f4192c[i8];
        int i15 = (15728640 & i14) >> 20;
        if (i15 != 0 && (i6 > i15 || (i6 == i15 && z5))) {
            i13 = ((524288 >> (i6 - 1)) & i14) == 0 ? i13 + 29 : i13 + 30;
        }
        if (i13 > 366 || (i5 % 4 != 0 && i13 > 365)) {
            i5++;
            i13 = i5 % 4 == 1 ? i13 - 366 : i13 - 365;
        }
        int[] iArr = new int[3];
        int i16 = 1;
        while (true) {
            if (i16 >= 13) {
                break;
            }
            int[] iArr2 = f4190a;
            int i17 = iArr2[i16];
            int i18 = i5 % 4;
            if (i18 == 0 && i16 > 2) {
                i17++;
            }
            if (i18 == 0 && i16 == 2 && i17 + 1 == i13) {
                iArr[1] = i16;
                iArr[2] = i13 - 31;
                break;
            }
            if (i17 >= i13) {
                iArr[1] = i16;
                int i19 = iArr2[i16 - 1];
                int i20 = (i18 != 0 || i16 <= 2) ? i19 : i19 + 1;
                if (i13 > i20) {
                    iArr[2] = i13 - i20;
                } else if (i13 != i20) {
                    iArr[2] = i13;
                } else if (i18 == 0 && i16 == 2) {
                    iArr[2] = (iArr2[i16] - i19) + 1;
                } else {
                    iArr[2] = iArr2[i16] - i19;
                }
            } else {
                i16++;
            }
        }
        iArr[0] = i5;
        return iArr;
    }

    public static final int[] f(int i5, int i6, int i7) {
        int i8 = 1899;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(1899, 1, 10);
        TimeZone timeZone = f4191b;
        gregorianCalendar.setTimeZone(timeZone);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(i5, i6 - 1, i7);
        gregorianCalendar2.setTimeZone(timeZone);
        int time = (int) ((gregorianCalendar2.getTime().getTime() - gregorianCalendar.getTime().getTime()) / 86400000);
        int i9 = 0;
        int iB = 0;
        while (i8 <= 2099 && time > 0) {
            iB = b(i8);
            time -= iB;
            i8++;
        }
        if (time < 0) {
            time += iB;
            i8--;
        }
        int iD = d(i8);
        int iA = 0;
        int i10 = 1;
        while (i10 <= 13 && time > 0) {
            iA = a(i8, i10);
            time -= iA;
            i10++;
        }
        if (time < 0) {
            time += iA;
            i10--;
        }
        if (iD != 0 && i10 > iD && i10 - 1 == iD) {
            i9 = 1;
        }
        return new int[]{i8, i10, time + 1, i9};
    }
}
