package com.google.crypto.tink.subtle;

import ad.o;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.google.crypto.tink.annotations.Alpha;
import java.security.InvalidKeyException;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Alpha
/* loaded from: classes.dex */
final class Curve25519 {
    static final byte[][] BANNED_PUBLIC_KEYS = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-32, -21, 122, 124, 59, 65, -72, -82, 22, 86, -29, -6, -15, -97, -60, 106, -38, 9, -115, -21, -100, 50, -79, -3, -122, 98, 5, 22, 95, 73, -72, 0}, new byte[]{95, -100, -107, -68, -93, 80, -116, 36, -79, -48, -79, 85, -100, -125, ByteSourceJsonBootstrapper.UTF8_BOM_1, 91, 4, 68, 92, -60, 88, 28, -114, -122, -40, 34, 78, -35, -48, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 127}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 127}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 127}};

    private Curve25519() {
    }

    public static void copyConditional(long[] jArr, long[] jArr2, int i) {
        int i3 = -i;
        for (int i10 = 0; i10 < 10; i10++) {
            long j10 = jArr[i10];
            jArr[i10] = ((int) j10) ^ ((((int) j10) ^ ((int) jArr2[i10])) & i3);
        }
    }

    public static void curveMult(long[] jArr, byte[] bArr, byte[] bArr2) {
        long[] jArrExpand = Field25519.expand(validatePubKeyAndClearMsb(bArr2));
        long[] jArr2 = new long[19];
        long[] jArr3 = new long[19];
        jArr3[0] = 1;
        long[] jArr4 = new long[19];
        jArr4[0] = 1;
        long[] jArr5 = new long[19];
        long[] jArr6 = new long[19];
        long[] jArr7 = new long[19];
        jArr7[0] = 1;
        long[] jArr8 = new long[19];
        long[] jArr9 = new long[19];
        jArr9[0] = 1;
        System.arraycopy(jArrExpand, 0, jArr2, 0, 10);
        int i = 0;
        while (i < 32) {
            int i3 = bArr[31 - i] & 255;
            long[] jArr10 = jArr6;
            long[] jArr11 = jArr7;
            long[] jArr12 = jArr2;
            long[] jArr13 = jArr3;
            long[] jArr14 = jArr8;
            long[] jArr15 = jArr9;
            int i10 = 0;
            while (i10 < 8) {
                int i11 = (i3 >> (7 - i10)) & 1;
                swapConditional(jArr4, jArr12, i11);
                swapConditional(jArr5, jArr13, i11);
                monty(jArr14, jArr15, jArr10, jArr11, jArr4, jArr5, jArr12, jArr13, jArrExpand);
                swapConditional(jArr14, jArr10, i11);
                swapConditional(jArr15, jArr11, i11);
                i10++;
                long[] jArr16 = jArr4;
                jArr4 = jArr14;
                jArr14 = jArr16;
                long[] jArr17 = jArr5;
                jArr5 = jArr15;
                jArr15 = jArr17;
                long[] jArr18 = jArr12;
                jArr12 = jArr10;
                jArr10 = jArr18;
                long[] jArr19 = jArr13;
                jArr13 = jArr11;
                jArr11 = jArr19;
            }
            i++;
            jArr8 = jArr14;
            jArr9 = jArr15;
            jArr2 = jArr12;
            jArr3 = jArr13;
            jArr6 = jArr10;
            jArr7 = jArr11;
        }
        long[] jArr20 = new long[10];
        Field25519.inverse(jArr20, jArr5);
        Field25519.mult(jArr, jArr4, jArr20);
        if (isCollinear(jArrExpand, jArr, jArr2, jArr3)) {
            return;
        }
        o.n(Hex.encode(bArr2), "Arithmetic error in curve multiplication with the public key: ");
    }

    private static boolean isCollinear(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[11];
        long[] jArr8 = new long[11];
        long[] jArr9 = new long[11];
        Field25519.mult(jArr5, jArr, jArr2);
        Field25519.sum(jArr6, jArr, jArr2);
        long[] jArr10 = new long[10];
        jArr10[0] = 486662;
        Field25519.sum(jArr8, jArr6, jArr10);
        Field25519.mult(jArr8, jArr8, jArr4);
        Field25519.sum(jArr8, jArr3);
        Field25519.mult(jArr8, jArr8, jArr5);
        Field25519.mult(jArr8, jArr8, jArr3);
        Field25519.scalarProduct(jArr7, jArr8, 4L);
        Field25519.reduceCoefficients(jArr7);
        Field25519.mult(jArr8, jArr5, jArr4);
        Field25519.sub(jArr8, jArr8, jArr4);
        Field25519.mult(jArr9, jArr6, jArr3);
        Field25519.sum(jArr8, jArr8, jArr9);
        Field25519.square(jArr8, jArr8);
        return Bytes.equal(Field25519.contract(jArr7), Field25519.contract(jArr8));
    }

    private static void monty(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5, long[] jArr6, long[] jArr7, long[] jArr8, long[] jArr9) {
        long[] jArrCopyOf = Arrays.copyOf(jArr5, 10);
        long[] jArr10 = new long[19];
        long[] jArr11 = new long[19];
        long[] jArr12 = new long[19];
        long[] jArr13 = new long[19];
        long[] jArr14 = new long[19];
        long[] jArr15 = new long[19];
        long[] jArr16 = new long[19];
        Field25519.sum(jArr5, jArr6);
        Field25519.sub(jArr6, jArrCopyOf);
        long[] jArrCopyOf2 = Arrays.copyOf(jArr7, 10);
        Field25519.sum(jArr7, jArr8);
        Field25519.sub(jArr8, jArrCopyOf2);
        Field25519.product(jArr13, jArr7, jArr6);
        Field25519.product(jArr14, jArr5, jArr8);
        Field25519.reduceSizeByModularReduction(jArr13);
        Field25519.reduceCoefficients(jArr13);
        Field25519.reduceSizeByModularReduction(jArr14);
        Field25519.reduceCoefficients(jArr14);
        System.arraycopy(jArr13, 0, jArrCopyOf2, 0, 10);
        Field25519.sum(jArr13, jArr14);
        Field25519.sub(jArr14, jArrCopyOf2);
        Field25519.square(jArr16, jArr13);
        Field25519.square(jArr15, jArr14);
        Field25519.product(jArr14, jArr15, jArr9);
        Field25519.reduceSizeByModularReduction(jArr14);
        Field25519.reduceCoefficients(jArr14);
        System.arraycopy(jArr16, 0, jArr3, 0, 10);
        System.arraycopy(jArr14, 0, jArr4, 0, 10);
        Field25519.square(jArr11, jArr5);
        Field25519.square(jArr12, jArr6);
        Field25519.product(jArr, jArr11, jArr12);
        Field25519.reduceSizeByModularReduction(jArr);
        Field25519.reduceCoefficients(jArr);
        Field25519.sub(jArr12, jArr11);
        Arrays.fill(jArr10, 10, 18, 0L);
        Field25519.scalarProduct(jArr10, jArr12, 121665L);
        Field25519.reduceCoefficients(jArr10);
        Field25519.sum(jArr10, jArr11);
        Field25519.product(jArr2, jArr12, jArr10);
        Field25519.reduceSizeByModularReduction(jArr2);
        Field25519.reduceCoefficients(jArr2);
    }

    public static void swapConditional(long[] jArr, long[] jArr2, int i) {
        int i3 = -i;
        for (int i10 = 0; i10 < 10; i10++) {
            int i11 = (((int) jArr[i10]) ^ ((int) jArr2[i10])) & i3;
            jArr[i10] = ((int) r1) ^ i11;
            jArr2[i10] = ((int) jArr2[i10]) ^ i11;
        }
    }

    private static byte[] validatePubKeyAndClearMsb(byte[] bArr) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        bArrCopyOf[31] = (byte) (bArrCopyOf[31] & 127);
        int i = 0;
        while (true) {
            byte[][] bArr2 = BANNED_PUBLIC_KEYS;
            if (i >= bArr2.length) {
                return bArrCopyOf;
            }
            if (Bytes.equal(bArr2[i], bArrCopyOf)) {
                throw new InvalidKeyException("Banned public key: " + Hex.encode(bArr2[i]));
            }
            i++;
        }
    }
}
