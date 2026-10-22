package m2;

import ch.qos.logback.core.net.SyslogConstants;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f13566a = {0, 31, 59, 90, SyslogConstants.LOG_CLOCK, Opcodes.DCMPL, Opcodes.PUTFIELD, 212, 243, 273, 304, 334, 365};

    /* renamed from: b, reason: collision with root package name */
    public static final TimeZone f13567b = TimeZone.getTimeZone("UTC");

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f13568c = {701770, 8697535, 306771, 677704, 5580477, 861776, 890180, 4631225, 354893, 634178, 2404022, 306762, 6966718, 675154, 861510, 6116026, 742478, 879171, 2714935, 613195, 7642049, 300884, 674632, 5973436, 435536, 447557, 4905656, 177741, 612162, 2398135, 300874, 6703934, 870993, 959814, 5690554, 372046, 177732, 3749688, 601675, 8165055, 824659, 870984, 7185723, 742735, 354885, 4894137, 154957, 601410, 2921910, 693578, 8080061, 445009, 742726, 5593787, 318030, 678723, 3484600, 338764, 9082175, 955730, 436808, 7001404, 701775, 308805, 4871993, 677709, 337474, 4100917, 890185, 7711422, 354897, 617798, 5549755, 306511, 675139, 5056183, 861515, 9261759, 742482, 748103, 6909244, 613200, 301893, 4869049, 674637, 11216322, 435540, 447561, 7002685, 702033, 612166, 5543867, 300879, 412484, 3581239, 959818, 8827583, 371795, 702023, 5846716, 601680, 824901, 5065400, 870988, 894273, 2468534, 354889, 8039869, 154962, 601415, 6067642, 693582, 739907, 4937015, 709962, 9788095, 309843, 678728, 6630332, 338768, 693061, 4672185, 436812, 709953, 2415286, 308810, 6969149, 675409, 861766, 6198074, 873293, 371267, 3585335, 617803, 11841215, 306515, 675144, 7153084, 861519, 873028, 6138424, 744012, 355649, 2403766, 301898, 8014782, 674641, 697670, 5984954, 447054, 711234, 3496759, 603979, 8689601, 300883, 412488, 6726972, 959823, 436804, 4896312, 699980, 601666, 3970869, 824905, 8211133, 870993, 894277, 5614266, 354894, 683331, 4533943, 339275, 9082303, 693587, 739911, 7034171, 709967, 350789, 4873528, 678732, 338754, 3838902, 430921, 7809469, 436817, 709958, 5561018, 308814, 677699, 4532024, 861770, 9343806, 873042, 895559, 6731067, 355663, 306757, 4869817, 675148, 857409, 2986677};

    static {
        Pattern.compile("(19|20)[0-9]{2}-((0)?[1-9]|1[012])-((0)?[1-9]|(1|2)[0-9]|30)$");
    }

    public static int a(int i4, int i5) {
        if (i4 < 1899) {
            i4 = 1899;
        }
        return (f13568c[i4 - 1899] & (BmLocated.ALIGN_TOP >> i5)) == 0 ? 29 : 30;
    }

    public static final int b(int i4, int i5, boolean z4) {
        int iC = c(i4);
        int i6 = (iC == 0 || i5 <= iC) ? 0 : 1;
        if (!z4) {
            return a(i4, i5 + i6);
        }
        if (iC == 0 || iC != i5) {
            return 0;
        }
        return a(i4, i5 + 1);
    }

    public static int c(int i4) {
        if (i4 < 1899) {
            i4 = 1899;
        }
        return (f13568c[Math.min(r1.length - 1, i4 - 1899)] & 15728640) >> 20;
    }

    public static final int[] d(int i4, int i5, int i6, boolean z4) {
        if (i4 < 1899) {
            i4 = 1899;
        } else if (i4 > 2099) {
            i4 = 2099;
        }
        if (i5 < 1) {
            i5 = 1;
        } else if (i5 > 12) {
            i5 = 12;
        }
        if (i6 < 1) {
            i6 = 1;
        } else if (i6 > 30) {
            i6 = 30;
        }
        if (i4 < 1899 || i4 > 2099 || i5 < 1 || i5 > 12 || i6 < 1 || i6 > 30) {
            StringBuilder sbU = B0.g.u("Illegal lunar date, must be like that:\n\tyear : 1900~2099\n\tmonth : 1~12\n\tday : 1~30\n\terror date:", i4, AwarenessDataItem.PERMISSION_SPLITTER, i5, AwarenessDataItem.PERMISSION_SPLITTER);
            sbU.append(i6);
            throw new IllegalArgumentException(sbU.toString());
        }
        int i7 = i4 - 1899;
        int[] iArr = f13568c;
        int i8 = iArr[i7];
        int i9 = i8 & 31;
        int i10 = i9 - 1;
        if (i7 != 1) {
            i9 = i10;
        }
        if (((i8 & 96) >> 5) == 2) {
            i9 += 31;
        }
        for (int i11 = 1; i11 < i5; i11++) {
            i9 = ((524288 >> (i11 + (-1))) & iArr[i7]) == 0 ? i9 + 29 : i9 + 30;
        }
        int i12 = i9 + i6;
        int i13 = iArr[i7];
        int i14 = (15728640 & i13) >> 20;
        if (i14 != 0 && (i5 > i14 || (i5 == i14 && z4))) {
            i12 = ((524288 >> (i5 - 1)) & i13) == 0 ? i12 + 29 : i12 + 30;
        }
        if (i12 > 366 || (i4 % 4 != 0 && i12 > 365)) {
            i4++;
            i12 = i4 % 4 == 1 ? i12 - 366 : i12 - 365;
        }
        int[] iArr2 = new int[3];
        int i15 = 1;
        while (true) {
            if (i15 >= 13) {
                break;
            }
            int[] iArr3 = f13566a;
            int i16 = iArr3[i15];
            int i17 = i4 % 4;
            if (i17 == 0 && i15 > 2) {
                i16++;
            }
            if (i17 == 0 && i15 == 2 && i16 + 1 == i12) {
                iArr2[1] = i15;
                iArr2[2] = i12 - 31;
                break;
            }
            if (i16 >= i12) {
                iArr2[1] = i15;
                int i18 = iArr3[i15 - 1];
                int i19 = (i17 != 0 || i15 <= 2) ? i18 : i18 + 1;
                if (i12 > i19) {
                    iArr2[2] = i12 - i19;
                } else if (i12 != i19) {
                    iArr2[2] = i12;
                } else if (i17 == 0 && i15 == 2) {
                    iArr2[2] = (iArr3[i15] - i18) + 1;
                } else {
                    iArr2[2] = iArr3[i15] - i18;
                }
            } else {
                i15++;
            }
        }
        iArr2[0] = i4;
        return iArr2;
    }

    public static final int[] e(int i4, int i5, int i6) {
        int[] iArr = new int[4];
        int i7 = 1899;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(1899, 1, 10);
        TimeZone timeZone = f13567b;
        gregorianCalendar.setTimeZone(timeZone);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(i4, i5 - 1, i6);
        gregorianCalendar2.setTimeZone(timeZone);
        int time = (int) ((gregorianCalendar2.getTime().getTime() - gregorianCalendar.getTime().getTime()) / 86400000);
        int i8 = 0;
        int i9 = 0;
        while (i7 <= 2099 && time > 0) {
            i9 = c(i7) != 0 ? 377 : 348;
            int i10 = f13568c[i7 - 1899] & 1048448;
            for (int i11 = 524288; i11 > 7; i11 >>= 1) {
                if ((i10 & i11) != 0) {
                    i9++;
                }
            }
            time -= i9;
            i7++;
        }
        if (time < 0) {
            time += i9;
            i7--;
        }
        iArr[0] = i7;
        int iC = c(i7);
        int iA = 0;
        int i12 = 1;
        while (i12 <= 13 && time > 0) {
            iA = a(i7, i12);
            time -= iA;
            i12++;
        }
        if (time < 0) {
            time += iA;
            i12--;
        }
        if (iC != 0 && i12 > iC && i12 - 1 == iC) {
            i8 = 1;
        }
        iArr[1] = i12;
        iArr[2] = time + 1;
        iArr[3] = i8;
        return iArr;
    }
}
