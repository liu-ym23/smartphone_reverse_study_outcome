package ch.qos.logback.core.encoder;

import java.io.ByteArrayOutputStream;
import kotlin.UByte;

/* loaded from: classes.dex */
public class ByteArrayUtil {
    public static byte[] hexStringToByteArray(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 * 2;
            bArr[i4] = (byte) (Integer.parseInt(str.substring(i5, i5 + 2), 16) & 255);
        }
        return bArr;
    }

    public static int readInt(byte[] bArr, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            i5 += (bArr[i4 + i6] & 255) << (24 - (i6 * 8));
        }
        return i5;
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void writeInt(byte[] bArr, int i4, int i5) {
        for (int i6 = 0; i6 < 4; i6++) {
            bArr[i4 + i6] = (byte) (i5 >>> (24 - (i6 * 8)));
        }
    }

    public static void writeInt(ByteArrayOutputStream byteArrayOutputStream, int i4) {
        for (int i5 = 0; i5 < 4; i5++) {
            byteArrayOutputStream.write((byte) (i4 >>> (24 - (i5 * 8))));
        }
    }
}
