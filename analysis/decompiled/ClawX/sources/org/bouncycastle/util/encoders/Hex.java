package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.bouncycastle.util.Strings;

/* loaded from: classes.dex */
public class Hex {
    private static final HexEncoder encoder = new HexEncoder();

    public static int decode(String str, OutputStream outputStream) {
        return encoder.decode(str, outputStream);
    }

    public static byte[] decodeStrict(String str) {
        try {
            return encoder.decodeStrict(str, 0, str.length());
        } catch (Exception e9) {
            throw new DecoderException("exception decoding Hex string: " + e9.getMessage(), e9);
        }
    }

    public static int encode(byte[] bArr, int i8, int i9, OutputStream outputStream) {
        return encoder.encode(bArr, i8, i9, outputStream);
    }

    public static String toHexString(byte[] bArr) {
        return toHexString(bArr, 0, bArr.length);
    }

    public static byte[] decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encoder.decode(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e9) {
            throw new DecoderException("exception decoding Hex string: " + e9.getMessage(), e9);
        }
    }

    public static byte[] decodeStrict(String str, int i8, int i9) {
        try {
            return encoder.decodeStrict(str, i8, i9);
        } catch (Exception e9) {
            throw new DecoderException("exception decoding Hex string: " + e9.getMessage(), e9);
        }
    }

    public static int encode(byte[] bArr, OutputStream outputStream) {
        return encoder.encode(bArr, 0, bArr.length, outputStream);
    }

    public static String toHexString(byte[] bArr, int i8, int i9) {
        return Strings.fromByteArray(encode(bArr, i8, i9));
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, 0, bArr.length);
    }

    public static byte[] encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static byte[] decode(byte[] bArr, int i8, int i9) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i9 / 2);
        try {
            encoder.decode(bArr, i8, i9, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e9) {
            throw new DecoderException("exception decoding Hex data: " + e9.getMessage(), e9);
        }
    }

    public static byte[] encode(byte[] bArr, int i8, int i9) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encoder.encode(bArr, i8, i9, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e9) {
            throw new EncoderException("exception encoding Hex string: " + e9.getMessage(), e9);
        }
    }
}
