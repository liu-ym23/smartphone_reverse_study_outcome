package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import kotlin.UByte;

/* loaded from: classes.dex */
public class f5 {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str) throws NoSuchAlgorithmException {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return b(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(byte[] bArr) throws NoSuchAlgorithmException {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr);
                    return b(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            LoggerImpl.global().warn(Collections.singletonList("DigestUtils"), "bytes is null", new Object[0]);
            return null;
        }
        int length = bArr.length;
        if (length > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i = length * 2;
        char[] cArr = new char[i];
        int i2 = 0;
        for (byte b : bArr) {
            int i3 = b & UByte.MAX_VALUE;
            int i4 = i2 + 1;
            char[] cArr2 = a;
            cArr[i2] = cArr2[i3 >> 4];
            i2 += 2;
            cArr[i4] = cArr2[b & 15];
        }
        return new String(cArr, 0, i);
    }
}
