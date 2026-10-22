package a5;

import androidx.compose.material3.MenuKt;
import androidx.compose.material3.internal.CalendarModelKt;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* renamed from: a5.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0303c {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1639a = {0, 31, 59, 90, MenuKt.InTransitionDuration, 151, 181, 212, 243, 273, 304, 334, 365};
    public static final TimeZone b = TimeZone.getTimeZone("UTC");
    public static final int[] c = {701770, 8697535, 306771, 677704, 5580477, 861776, 890180, 4631225, 354893, 634178, 2404022, 306762, 6966718, 675154, 861510, 6116026, 742478, 879171, 2714935, 613195, 7642049, 300884, 674632, 5973436, 435536, 447557, 4905656, 177741, 612162, 2398135, 300874, 6703934, 870993, 959814, 5690554, 372046, 177732, 3749688, 601675, 8165055, 824659, 870984, 7185723, 742735, 354885, 4894137, 154957, 601410, 2921910, 693578, 8080061, 445009, 742726, 5593787, 318030, 678723, 3484600, 338764, 9082175, 955730, 436808, 7001404, 701775, 308805, 4871993, 677709, 337474, 4100917, 890185, 7711422, 354897, 617798, 5549755, 306511, 675139, 5056183, 861515, 9261759, 742482, 748103, 6909244, 613200, 301893, 4869049, 674637, 11216322, 435540, 447561, 7002685, 702033, 612166, 5543867, 300879, 412484, 3581239, 959818, 8827583, 371795, 702023, 5846716, 601680, 824901, 5065400, 870988, 894273, 2468534, 354889, 8039869, 154962, 601415, 6067642, 693582, 739907, 4937015, 709962, 9788095, 309843, 678728, 6630332, 338768, 693061, 4672185, 436812, 709953, 2415286, 308810, 6969149, 675409, 861766, 6198074, 873293, 371267, 3585335, 617803, 11841215, 306515, 675144, 7153084, 861519, 873028, 6138424, 744012, 355649, 2403766, 301898, 8014782, 674641, 697670, 5984954, 447054, 711234, 3496759, 603979, 8689601, 300883, 412488, 6726972, 959823, 436804, 4896312, 699980, 601666, 3970869, 824905, 8211133, 870993, 894277, 5614266, 354894, 683331, 4533943, 339275, 9082303, 693587, 739911, 7034171, 709967, 350789, 4873528, 678732, 338754, 3838902, 430921, 7809469, 436817, 709958, 5561018, 308814, 677699, 4532024, 861770, 9343806, 873042, 895559, 6731067, 355663, 306757, 4869817, 675148, 857409, 2986677};

    static {
        Pattern.compile("(19|20)[0-9]{2}-((0)?[1-9]|1[012])-((0)?[1-9]|(1|2)[0-9]|30)$");
    }

    public static int a(int i, int i6) {
        if (i < 1899) {
            i = 1899;
        }
        return (c[i - 1899] & (1048576 >> i6)) == 0 ? 29 : 30;
    }

    public static final int b(int i, int i6, boolean z10) {
        int iC = c(i);
        int i10 = (iC == 0 || i6 <= iC) ? 0 : 1;
        if (!z10) {
            return a(i, i6 + i10);
        }
        if (iC == 0 || iC != i6) {
            return 0;
        }
        return a(i, i6 + 1);
    }

    public static int c(int i) {
        if (i < 1899) {
            i = 1899;
        }
        return (c[Math.min(r1.length - 1, i - 1899)] & 15728640) >> 20;
    }

    public static final int[] d(int i, int i6, int i10, boolean z10) {
        if (i < 1899) {
            i = 1899;
        } else if (i > 2099) {
            i = 2099;
        }
        if (i6 < 1) {
            i6 = 1;
        } else if (i6 > 12) {
            i6 = 12;
        }
        if (i10 < 1) {
            i10 = 1;
        } else if (i10 > 30) {
            i10 = 30;
        }
        if (i < 1899 || i > 2099 || i6 < 1 || i6 > 12 || i10 < 1 || i10 > 30) {
            StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "Illegal lunar date, must be like that:\n\tyear : 1900~2099\n\tmonth : 1~12\n\tday : 1~30\n\terror date:", i6, " ", " ");
            sbS.append(i10);
            throw new IllegalArgumentException(sbS.toString());
        }
        int i11 = i - 1899;
        int[] iArr = c;
        int i12 = iArr[i11];
        int i13 = i12 & 31;
        int i14 = i13 - 1;
        if (i11 != 1) {
            i13 = i14;
        }
        if (((i12 & 96) >> 5) == 2) {
            i13 += 31;
        }
        for (int i15 = 1; i15 < i6; i15++) {
            i13 = ((524288 >> (i15 + (-1))) & iArr[i11]) == 0 ? i13 + 29 : i13 + 30;
        }
        int i16 = i13 + i10;
        int i17 = iArr[i11];
        int i18 = (15728640 & i17) >> 20;
        if (i18 != 0 && (i6 > i18 || (i6 == i18 && z10))) {
            i16 = ((524288 >> (i6 - 1)) & i17) == 0 ? i16 + 29 : i16 + 30;
        }
        if (i16 > 366 || (i % 4 != 0 && i16 > 365)) {
            i++;
            i16 = i % 4 == 1 ? i16 - 366 : i16 - 365;
        }
        int[] iArr2 = new int[3];
        int i19 = 1;
        while (true) {
            if (i19 >= 13) {
                break;
            }
            int[] iArr3 = f1639a;
            int i20 = iArr3[i19];
            int i21 = i % 4;
            if (i21 == 0 && i19 > 2) {
                i20++;
            }
            if (i21 == 0 && i19 == 2 && i20 + 1 == i16) {
                iArr2[1] = i19;
                iArr2[2] = i16 - 31;
                break;
            }
            if (i20 >= i16) {
                iArr2[1] = i19;
                int i22 = iArr3[i19 - 1];
                int i23 = (i21 != 0 || i19 <= 2) ? i22 : i22 + 1;
                if (i16 > i23) {
                    iArr2[2] = i16 - i23;
                } else if (i16 != i23) {
                    iArr2[2] = i16;
                } else if (i21 == 0 && i19 == 2) {
                    iArr2[2] = (iArr3[i19] - i22) + 1;
                } else {
                    iArr2[2] = iArr3[i19] - i22;
                }
            } else {
                i19++;
            }
        }
        iArr2[0] = i;
        return iArr2;
    }

    public static final int[] e(int i, int i6, int i10) {
        int i11 = 1899;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(1899, 1, 10);
        TimeZone timeZone = b;
        gregorianCalendar.setTimeZone(timeZone);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(i, i6 - 1, i10);
        gregorianCalendar2.setTimeZone(timeZone);
        int time = (int) ((gregorianCalendar2.getTime().getTime() - gregorianCalendar.getTime().getTime()) / CalendarModelKt.MillisecondsIn24Hours);
        int i12 = 0;
        int i13 = 0;
        while (i11 <= 2099 && time > 0) {
            i13 = c(i11) != 0 ? 377 : 348;
            int i14 = c[i11 - 1899] & 1048448;
            for (int i15 = 524288; i15 > 7; i15 >>= 1) {
                if ((i14 & i15) != 0) {
                    i13++;
                }
            }
            time -= i13;
            i11++;
        }
        if (time < 0) {
            time += i13;
            i11--;
        }
        int iC = c(i11);
        int iA = 0;
        int i16 = 1;
        while (i16 <= 13 && time > 0) {
            iA = a(i11, i16);
            time -= iA;
            i16++;
        }
        if (time < 0) {
            time += iA;
            i16--;
        }
        if (iC != 0 && i16 > iC && i16 - 1 == iC) {
            i12 = 1;
        }
        return new int[]{i11, i16, time + 1, i12};
    }
}
