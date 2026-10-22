package com.android.server.backup.utils;

import android.util.Slog;
import com.android.server.backup.BackupManagerService;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import libcore.util.HexEncoding;

/* JADX INFO: loaded from: classes.dex */
public class PasswordUtils {
    public static final String ENCRYPTION_ALGORITHM_NAME = "AES-256";
    public static final int PBKDF2_HASH_ROUNDS = 10000;
    private static final int PBKDF2_KEY_SIZE = 256;
    public static final int PBKDF2_SALT_SIZE = 512;

    public PasswordUtils() {
    }

    public static SecretKey buildPasswordKey(String algorithm, String pw, byte[] salt, int rounds) {
        return buildCharArrayKey(algorithm, pw.toCharArray(), salt, rounds);
    }

    public static String buildPasswordHash(String algorithm, String pw, byte[] salt, int rounds) {
        SecretKey key = buildPasswordKey(algorithm, pw, salt, rounds);
        if (key != null) goto L5;
        return null;
    L5:
        return byteArrayToHex(key.getEncoded());
    }

    public static String byteArrayToHex(byte[] data) {
        return HexEncoding.encodeToString(data, true);
    }

    public static byte[] hexToByteArray(String digits) {
        int bytes = digits.length() / 2;
        if ((bytes * 2) != digits.length()) goto L11;
        byte[] result = new byte[bytes];
        int i = 0;
    L6:
        if (i >= digits.length()) goto L9;
        result[i / 2] = (byte) Integer.parseInt(digits.substring(i, i + 2), 16);
        i = i + 2;
        goto L6
    L9:
        return result;
    L11:
        throw new IllegalArgumentException("Hex string must have an even number of digits");
    }

    public static byte[] makeKeyChecksum(String algorithm, byte[] pwBytes, byte[] salt, int rounds) {
        char[] mkAsChar = new char[pwBytes.length];
        int i = 0;
    L4:
        if (i >= pwBytes.length) goto L6;
        mkAsChar[i] = (char) pwBytes[i];
        i = i + 1;
        goto L4
    L6:
        Key checksum = buildCharArrayKey(algorithm, mkAsChar, salt, rounds);
        return checksum.getEncoded();
    }

    private static SecretKey buildCharArrayKey(String algorithm, char[] pwArray, byte[] salt, int rounds) {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);     // Catch: NoSuchAlgorithmException -> L5 InvalidKeySpecException -> L7
        KeySpec ks = new PBEKeySpec(pwArray, salt, rounds, 256);     // Catch: NoSuchAlgorithmException -> L5 InvalidKeySpecException -> L7
        return keyFactory.generateSecret(ks);
    L9:
        Slog.e(BackupManagerService.TAG, "PBKDF2 unavailable!");
        return null;
    L10:
        Slog.e(BackupManagerService.TAG, "Invalid key spec for PBKDF2!");
        return null;
    }
}
