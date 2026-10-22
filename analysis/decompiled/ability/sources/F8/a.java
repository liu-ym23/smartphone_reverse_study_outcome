package F8;

import com.stepos.taskrobot.settingsprovider.SettingsConfig;

/* loaded from: classes4.dex */
public abstract class a {
    static {
        String property;
        try {
            property = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            property = null;
        }
        "true".equals(property);
    }

    public static byte[] a(String[] strArr) {
        if (strArr == null) {
            Object[] objArr = new Object[3];
            objArr[0] = SettingsConfig.KEY_DATA;
            objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
            switch (7) {
                case 1:
                case 3:
                case 6:
                case 8:
                case 10:
                case 12:
                case 14:
                    break;
                case 2:
                    objArr[2] = "encode8to7";
                    break;
                case 4:
                    objArr[2] = "addModuloByte";
                    break;
                case 5:
                    objArr[2] = "splitBytesToStringArray";
                    break;
                case 7:
                    objArr[2] = "decodeBytes";
                    break;
                case 9:
                    objArr[2] = "dropMarker";
                    break;
                case 11:
                    objArr[2] = "combineStringArrayIntoBytes";
                    break;
                case 13:
                    objArr[2] = "decode7to8";
                    break;
                default:
                    objArr[2] = "encodeBytes";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char cCharAt = strArr[0].charAt(0);
            if (cCharAt == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                strArr2[0] = strArr2[0].substring(1);
                int length = 0;
                for (String str : strArr2) {
                    length += str.length();
                }
                byte[] bArr = new byte[length];
                int i = 0;
                for (String str2 : strArr2) {
                    int length2 = str2.length();
                    int i6 = 0;
                    while (i6 < length2) {
                        bArr[i] = (byte) str2.charAt(i6);
                        i6++;
                        i++;
                    }
                }
                return bArr;
            }
            if (cCharAt == 65535) {
                strArr = (String[]) strArr.clone();
                strArr[0] = strArr[0].substring(1);
            }
        }
        int length3 = 0;
        for (String str3 : strArr) {
            length3 += str3.length();
        }
        byte[] bArr2 = new byte[length3];
        int i10 = 0;
        for (String str4 : strArr) {
            int length4 = str4.length();
            int i11 = 0;
            while (i11 < length4) {
                bArr2[i10] = (byte) str4.charAt(i11);
                i11++;
                i10++;
            }
        }
        for (int i12 = 0; i12 < length3; i12++) {
            bArr2[i12] = (byte) ((bArr2[i12] + 127) & 127);
        }
        int i13 = (length3 * 7) / 8;
        byte[] bArr3 = new byte[i13];
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < i13; i16++) {
            int i17 = i14 + 1;
            int i18 = i15 + 1;
            bArr3[i16] = (byte) (((bArr2[i14] & 255) >>> i15) + ((bArr2[i17] & ((1 << i18) - 1)) << (7 - i15)));
            if (i15 == 6) {
                i14 += 2;
                i15 = 0;
            } else {
                i14 = i17;
                i15 = i18;
            }
        }
        return bArr3;
    }
}
