package l8;

import com.stepos.core.ota.crypto.CryptoHeaderParser;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10350a = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

    /* renamed from: b, reason: collision with root package name */
    public static final TimeZone f10351b = TimeZone.getTimeZone("UTC");

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f10352c = {701770, 8697535, 306771, 677704, 5580477, 861776, 890180, 4631225, 354893, 634178, 2404022, 306762, 6966718, 675154, 861510, 6116026, 742478, 879171, 2714935, 613195, 7642049, 300884, 674632, 5973436, 435536, 447557, 4905656, 177741, 612162, 2398135, 300874, 6703934, 870993, 959814, 5690554, 372046, 177732, 3749688, 601675, 8165055, 824659, 870984, 7185723, 742735, 354885, 4894137, 154957, 601410, 2921910, 693578, 8080061, 445009, 742726, 5593787, 318030, 678723, 3484600, 338764, 9082175, 955730, 436808, 7001404, 701775, 308805, 4871993, 677709, 337474, 4100917, 890185, 7711422, 354897, 617798, 5549755, 306511, 675139, 5056183, 861515, 9261759, 742482, 748103, 6909244, 613200, 301893, 4869049, 674637, 11216322, 435540, 447561, 7002685, 702033, 612166, 5543867, 300879, 412484, 3581239, 959818, 8827583, 371795, 702023, 5846716, 601680, 824901, 5065400, 870988, 894273, 2468534, 354889, 8039869, 154962, 601415, 6067642, 693582, 739907, 4937015, 709962, 9788095, 309843, 678728, 6630332, 338768, 693061, 4672185, 436812, 709953, 2415286, 308810, 6969149, 675409, 861766, 6198074, 873293, 371267, 3585335, 617803, 11841215, 306515, 675144, 7153084, 861519, 873028, 6138424, 744012, 355649, 2403766, 301898, 8014782, 674641, 697670, 5984954, 447054, 711234, 3496759, 603979, 8689601, 300883, 412488, 6726972, 959823, 436804, 4896312, 699980, 601666, 3970869, 824905, 8211133, 870993, 894277, 5614266, 354894, 683331, 4533943, 339275, 9082303, 693587, 739911, 7034171, 709967, 350789, 4873528, 678732, 338754, 3838902, 430921, 7809469, 436817, 709958, 5561018, 308814, 677699, 4532024, 861770, 9343806, 873042, 895559, 6731067, 355663, 306757, 4869817, 675148, 857409, 2986677};

    static {
        Pattern.compile("(19|20)[0-9]{2}-((0)?[1-9]|1[012])-((0)?[1-9]|(1|2)[0-9]|30)$");
    }

    public static int a(int i10, int i11) {
        if (i10 < 1899) {
            i10 = 1899;
        }
        return (f10352c[i10 - 1899] & (CryptoHeaderParser.MAX_BLOCK_SIZE >> i11)) == 0 ? 29 : 30;
    }

    public static final int b(int i10, int i11, boolean z) {
        int iC = c(i10);
        int i12 = (iC == 0 || i11 <= iC) ? 0 : 1;
        if (!z) {
            return a(i10, i11 + i12);
        }
        if (iC == 0 || iC != i11) {
            return 0;
        }
        return a(i10, i11 + 1);
    }

    public static int c(int i10) {
        if (i10 < 1899) {
            i10 = 1899;
        }
        return (f10352c[Math.min(r1.length - 1, i10 - 1899)] & 15728640) >> 20;
    }

    public static final int[] d(int i10, int i11, int i12, boolean z) {
        if (i10 < 1899) {
            i10 = 1899;
        } else if (i10 > 2099) {
            i10 = 2099;
        }
        if (i11 < 1) {
            i11 = 1;
        } else if (i11 > 12) {
            i11 = 12;
        }
        if (i12 < 1) {
            i12 = 1;
        } else if (i12 > 30) {
            i12 = 30;
        }
        if (i10 < 1899 || i10 > 2099 || i11 < 1 || i11 > 12 || i12 < 1 || i12 > 30) {
            StringBuilder sbD = h0.e.d(i10, "Illegal lunar date, must be like that:\n\tyear : 1900~2099\n\tmonth : 1~12\n\tday : 1~30\n\terror date:", i11, " ", " ");
            sbD.append(i12);
            throw new IllegalArgumentException(sbD.toString());
        }
        int i13 = i10 - 1899;
        int[] iArr = f10352c;
        int i14 = iArr[i13];
        int i15 = i14 & 31;
        int i16 = i15 - 1;
        if (i13 != 1) {
            i15 = i16;
        }
        if (((i14 & 96) >> 5) == 2) {
            i15 += 31;
        }
        for (int i17 = 1; i17 < i11; i17++) {
            i15 = ((524288 >> (i17 + (-1))) & iArr[i13]) == 0 ? i15 + 29 : i15 + 30;
        }
        int i18 = i15 + i12;
        int i19 = iArr[i13];
        int i20 = (15728640 & i19) >> 20;
        if (i20 != 0 && (i11 > i20 || (i11 == i20 && z))) {
            i18 = ((524288 >> (i11 - 1)) & i19) == 0 ? i18 + 29 : i18 + 30;
        }
        if (i18 > 366 || (i10 % 4 != 0 && i18 > 365)) {
            i10++;
            i18 = i10 % 4 == 1 ? i18 - 366 : i18 - 365;
        }
        int[] iArr2 = new int[3];
        int i21 = 1;
        while (true) {
            if (i21 >= 13) {
                break;
            }
            int[] iArr3 = f10350a;
            int i22 = iArr3[i21];
            int i23 = i10 % 4;
            if (i23 == 0 && i21 > 2) {
                i22++;
            }
            if (i23 == 0 && i21 == 2 && i22 + 1 == i18) {
                iArr2[1] = i21;
                iArr2[2] = i18 - 31;
                break;
            }
            if (i22 >= i18) {
                iArr2[1] = i21;
                int i24 = iArr3[i21 - 1];
                int i25 = (i23 != 0 || i21 <= 2) ? i24 : i24 + 1;
                if (i18 > i25) {
                    iArr2[2] = i18 - i25;
                } else if (i18 != i25) {
                    iArr2[2] = i18;
                } else if (i23 == 0 && i21 == 2) {
                    iArr2[2] = (iArr3[i21] - i24) + 1;
                } else {
                    iArr2[2] = iArr3[i21] - i24;
                }
            } else {
                i21++;
            }
        }
        iArr2[0] = i10;
        return iArr2;
    }

    public static final int[] e(int i10, int i11, int i12) {
        int i13 = 1899;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(1899, 1, 10);
        TimeZone timeZone = f10351b;
        gregorianCalendar.setTimeZone(timeZone);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(i10, i11 - 1, i12);
        gregorianCalendar2.setTimeZone(timeZone);
        int time = (int) ((gregorianCalendar2.getTime().getTime() - gregorianCalendar.getTime().getTime()) / 86400000);
        int i14 = 0;
        int i15 = 0;
        while (i13 <= 2099 && time > 0) {
            i15 = c(i13) != 0 ? 377 : 348;
            int i16 = f10352c[i13 - 1899] & 1048448;
            for (int i17 = 524288; i17 > 7; i17 >>= 1) {
                if ((i16 & i17) != 0) {
                    i15++;
                }
            }
            time -= i15;
            i13++;
        }
        if (time < 0) {
            time += i15;
            i13--;
        }
        int iC = c(i13);
        int iA = 0;
        int i18 = 1;
        while (i18 <= 13 && time > 0) {
            iA = a(i13, i18);
            time -= iA;
            i18++;
        }
        if (time < 0) {
            time += iA;
            i18--;
        }
        if (iC != 0 && i18 > iC && i18 - 1 == iC) {
            i14 = 1;
        }
        return new int[]{i13, i18, time + 1, i14};
    }
}
