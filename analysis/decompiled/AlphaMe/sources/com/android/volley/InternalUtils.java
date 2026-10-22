package com.android.volley;

import com.stepos.activeview.utils.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* loaded from: classes.dex */
class InternalUtils {
    private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();

    private static String convertToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            byte b4 = bArr[i4];
            int i5 = b4 & UByte.MAX_VALUE;
            int i6 = i4 * 2;
            char[] cArr2 = HEX_CHARS;
            cArr[i6] = cArr2[i5 >>> 4];
            cArr[i6 + 1] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }

    public static String sha1Hash(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes(Constants.UTF_8_CODE);
            messageDigest.update(bytes, 0, bytes.length);
            return convertToHex(messageDigest.digest());
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
