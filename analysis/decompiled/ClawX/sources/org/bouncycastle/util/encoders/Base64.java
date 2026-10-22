package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.bouncycastle.util.Strings;

/* loaded from: classes.dex */
public class Base64 {
    private static final Encoder encoder = new Base64Encoder();

    public static int decode(String str, OutputStream outputStream) {
        return encoder.decode(str, outputStream);
    }

    public static int encode(byte[] bArr, int i8, int i9, OutputStream outputStream) {
        return encoder.encode(bArr, i8, i9, outputStream);
    }

    public static String toBase64String(byte[] bArr) {
        return toBase64String(bArr, 0, bArr.length);
    }

    public static int decode(byte[] bArr, int i8, int i9, OutputStream outputStream) {
        try {
            return encoder.decode(bArr, i8, i9, outputStream);
        } catch (Exception e9) {
            throw new DecoderException("unable to decode base64 data: " + e9.getMessage(), e9);
        }
    }

    public static int encode(byte[] bArr, OutputStream outputStream) {
        return encoder.encode(bArr, 0, bArr.length, outputStream);
    }

    public static String toBase64String(byte[] bArr, int i8, int i9) {
        return Strings.fromByteArray(encode(bArr, i8, i9));
    }

    public static byte[] decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((str.length() / 4) * 3);
        try {
            encoder.decode(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e9) {
            throw new DecoderException("unable to decode base64 string: " + e9.getMessage(), e9);
        }
    }

    public static byte[] encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, 0, bArr.length);
    }

    public static byte[] encode(byte[] bArr, int i8, int i9) {
        Encoder encoder2 = encoder;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(encoder2.getEncodedLength(i9));
        try {
            encoder2.encode(bArr, i8, i9, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e9) {
            throw new EncoderException("exception encoding base64 string: " + e9.getMessage(), e9);
        }
    }

    public static byte[] decode(byte[] bArr, int i8, int i9) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((i9 / 4) * 3);
        try {
            encoder.decode(bArr, i8, i9, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e9) {
            throw new DecoderException("unable to decode base64 data: " + e9.getMessage(), e9);
        }
    }
}
