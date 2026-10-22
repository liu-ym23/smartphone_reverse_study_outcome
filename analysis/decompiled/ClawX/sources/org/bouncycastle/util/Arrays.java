package org.bouncycastle.util;

import a8.b;
import java.math.BigInteger;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class Arrays {

    public static class Iterator<T> implements java.util.Iterator<T> {
        private final T[] dataArray;
        private int position = 0;

        public Iterator(T[] tArr) {
            this.dataArray = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.dataArray.length;
        }

        @Override // java.util.Iterator
        public T next() {
            int i8 = this.position;
            T[] tArr = this.dataArray;
            if (i8 != tArr.length) {
                this.position = i8 + 1;
                return tArr[i8];
            }
            throw new NoSuchElementException("Out of elements: " + this.position);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

    private Arrays() {
    }

    public static byte[] append(byte[] bArr, byte b9) {
        if (bArr == null) {
            return new byte[]{b9};
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 1];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b9;
        return bArr2;
    }

    public static boolean areAllZeroes(byte[] bArr, int i8, int i9) {
        int i10 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            i10 |= bArr[i8 + i11];
        }
        return i10 == 0;
    }

    public static boolean areEqual(byte[] bArr, int i8, int i9, byte[] bArr2, int i10, int i11) {
        int i12 = i9 - i8;
        if (i12 != i11 - i10) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (bArr[i8 + i13] != bArr2[i10 + i13]) {
                return false;
            }
        }
        return true;
    }

    public static void clear(byte[] bArr) {
        if (bArr != null) {
            java.util.Arrays.fill(bArr, (byte) 0);
        }
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static int compareUnsigned(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return 0;
        }
        if (bArr == null) {
            return -1;
        }
        if (bArr2 == null) {
            return 1;
        }
        int iMin = Math.min(bArr.length, bArr2.length);
        for (int i8 = 0; i8 < iMin; i8++) {
            int i9 = bArr[i8] & 255;
            int i10 = bArr2[i8] & 255;
            if (i9 < i10) {
                return -1;
            }
            if (i9 > i10) {
                return 1;
            }
        }
        if (bArr.length < bArr2.length) {
            return -1;
        }
        return bArr.length > bArr2.length ? 1 : 0;
    }

    public static byte[] concatenate(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return clone(bArr2);
        }
        if (bArr2 == null) {
            return clone(bArr);
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static boolean constantTimeAreEqual(int i8, byte[] bArr, int i9, byte[] bArr2, int i10) {
        if (bArr == null) {
            throw new NullPointerException("'a' cannot be null");
        }
        if (bArr2 == null) {
            throw new NullPointerException("'b' cannot be null");
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("'len' cannot be negative");
        }
        if (i9 > bArr.length - i8) {
            throw new IndexOutOfBoundsException("'aOff' value invalid for specified length");
        }
        if (i10 > bArr2.length - i8) {
            throw new IndexOutOfBoundsException("'bOff' value invalid for specified length");
        }
        int i11 = 0;
        for (int i12 = 0; i12 < i8; i12++) {
            i11 |= bArr[i9 + i12] ^ bArr2[i10 + i12];
        }
        return i11 == 0;
    }

    public static boolean contains(byte[] bArr, byte b9) {
        for (byte b10 : bArr) {
            if (b10 == b9) {
                return true;
            }
        }
        return false;
    }

    public static byte[] copyOf(byte[] bArr, int i8) {
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i8));
        return bArr2;
    }

    public static byte[] copyOfRange(byte[] bArr, int i8, int i9) {
        int length = getLength(i8, i9);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i8, bArr2, 0, Math.min(bArr.length - i8, length));
        return bArr2;
    }

    public static void fill(byte[] bArr, byte b9) {
        java.util.Arrays.fill(bArr, b9);
    }

    private static int getLength(int i8, int i9) {
        int i10 = i9 - i8;
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException(i8 + " > " + i9);
    }

    public static int hashCode(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int i8 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i8;
            }
            i8 = (i8 * 257) ^ bArr[length];
        }
    }

    public static boolean isNullOrContainsNull(Object[] objArr) {
        if (objArr == null) {
            return true;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNullOrEmpty(byte[] bArr) {
        return bArr == null || bArr.length < 1;
    }

    public static byte[] prepend(byte[] bArr, byte b9) {
        if (bArr == null) {
            return new byte[]{b9};
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 1];
        System.arraycopy(bArr, 0, bArr2, 1, length);
        bArr2[0] = b9;
        return bArr2;
    }

    public static void reverse(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - 1;
        for (int i8 = 0; i8 <= length; i8++) {
            bArr2[i8] = bArr[length - i8];
        }
    }

    public static void reverseInPlace(byte[] bArr, int i8, int i9) {
        int i10 = (i9 + i8) - 1;
        while (i8 < i10) {
            byte b9 = bArr[i8];
            bArr[i8] = bArr[i10];
            bArr[i10] = b9;
            i10--;
            i8++;
        }
    }

    public static boolean segmentsOverlap(int i8, int i9, int i10, int i11) {
        return i9 > 0 && i11 > 0 && i8 - i10 < i11 && i10 - i8 < i9;
    }

    public static void validateRange(byte[] bArr, int i8, int i9) {
        if (bArr == null) {
            throw new NullPointerException("'buf' cannot be null");
        }
        if (((bArr.length - i8) | i8 | (i9 - i8) | (bArr.length - i9)) >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder("buf.length: ");
        b.z(sb, bArr.length, ", from: ", i8, ", to: ");
        sb.append(i9);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static void validateSegment(byte[] bArr, int i8, int i9) {
        if (bArr == null) {
            throw new NullPointerException("'buf' cannot be null");
        }
        int length = bArr.length - i8;
        if ((length | i8 | i9 | (length - i9)) >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder("buf.length: ");
        b.z(sb, bArr.length, ", off: ", i8, ", len: ");
        sb.append(i9);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static int[] append(int[] iArr, int i8) {
        if (iArr == null) {
            return new int[]{i8};
        }
        int length = iArr.length;
        int[] iArr2 = new int[length + 1];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        iArr2[length] = i8;
        return iArr2;
    }

    public static boolean areEqual(byte[] bArr, byte[] bArr2) {
        return java.util.Arrays.equals(bArr, bArr2);
    }

    public static void clear(char[] cArr) {
        if (cArr != null) {
            java.util.Arrays.fill(cArr, (char) 0);
        }
    }

    public static byte[] clone(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return null;
        }
        if (bArr2 == null || bArr2.length != bArr.length) {
            return clone(bArr);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public static byte[] concatenate(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            return concatenate(bArr2, bArr3);
        }
        if (bArr2 == null) {
            return concatenate(bArr, bArr3);
        }
        if (bArr3 == null) {
            return concatenate(bArr, bArr2);
        }
        byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        int length = bArr.length;
        System.arraycopy(bArr2, 0, bArr4, length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, length + bArr2.length, bArr3.length);
        return bArr4;
    }

    public static boolean constantTimeAreEqual(int i8, long[] jArr, int i9, long[] jArr2, int i10) {
        if (jArr == null) {
            throw new NullPointerException("'a' cannot be null");
        }
        if (jArr2 == null) {
            throw new NullPointerException("'b' cannot be null");
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("'len' cannot be negative");
        }
        if (i9 > jArr.length - i8) {
            throw new IndexOutOfBoundsException("'aOff' value invalid for specified length");
        }
        if (i10 > jArr2.length - i8) {
            throw new IndexOutOfBoundsException("'bOff' value invalid for specified length");
        }
        long j4 = 0;
        for (int i11 = 0; i11 < i8; i11++) {
            j4 |= jArr[i9 + i11] ^ jArr2[i10 + i11];
        }
        return 0 == j4;
    }

    public static boolean contains(char[] cArr, char c3) {
        for (char c8 : cArr) {
            if (c8 == c3) {
                return true;
            }
        }
        return false;
    }

    public static char[] copyOf(char[] cArr, int i8) {
        char[] cArr2 = new char[i8];
        System.arraycopy(cArr, 0, cArr2, 0, Math.min(cArr.length, i8));
        return cArr2;
    }

    public static char[] copyOfRange(char[] cArr, int i8, int i9) {
        int length = getLength(i8, i9);
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, i8, cArr2, 0, Math.min(cArr.length - i8, length));
        return cArr2;
    }

    public static void fill(byte[] bArr, int i8, int i9, byte b9) {
        java.util.Arrays.fill(bArr, i8, i9, b9);
    }

    public static int hashCode(byte[] bArr, int i8, int i9) {
        if (bArr == null) {
            return 0;
        }
        int i10 = i9 + 1;
        while (true) {
            i9--;
            if (i9 < 0) {
                return i10;
            }
            i10 = (i10 * 257) ^ bArr[i8 + i9];
        }
    }

    public static boolean isNullOrEmpty(int[] iArr) {
        return iArr == null || iArr.length < 1;
    }

    public static int[] prepend(int[] iArr, int i8) {
        if (iArr == null) {
            return new int[]{i8};
        }
        int length = iArr.length;
        int[] iArr2 = new int[length + 1];
        System.arraycopy(iArr, 0, iArr2, 1, length);
        iArr2[0] = i8;
        return iArr2;
    }

    public static byte[] reverse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        int i8 = 0;
        while (true) {
            length--;
            if (length < 0) {
                return bArr2;
            }
            bArr2[length] = bArr[i8];
            i8++;
        }
    }

    public static byte[] reverseInPlace(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length - 1;
        for (int i8 = 0; i8 < length; i8++) {
            byte b9 = bArr[i8];
            bArr[i8] = bArr[length];
            bArr[length] = b9;
            length--;
        }
        return bArr;
    }

    public static String[] append(String[] strArr, String str) {
        if (strArr == null) {
            return new String[]{str};
        }
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        strArr2[length] = str;
        return strArr2;
    }

    public static boolean areEqual(char[] cArr, char[] cArr2) {
        return java.util.Arrays.equals(cArr, cArr2);
    }

    public static void clear(int[] iArr) {
        if (iArr != null) {
            java.util.Arrays.fill(iArr, 0);
        }
    }

    public static char[] clone(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return (char[]) cArr.clone();
    }

    public static byte[] concatenate(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (bArr == null) {
            return concatenate(bArr2, bArr3, bArr4);
        }
        if (bArr2 == null) {
            return concatenate(bArr, bArr3, bArr4);
        }
        if (bArr3 == null) {
            return concatenate(bArr, bArr2, bArr4);
        }
        if (bArr4 == null) {
            return concatenate(bArr, bArr2, bArr3);
        }
        byte[] bArr5 = new byte[bArr.length + bArr2.length + bArr3.length + bArr4.length];
        System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
        int length = bArr.length;
        System.arraycopy(bArr2, 0, bArr5, length, bArr2.length);
        int length2 = length + bArr2.length;
        System.arraycopy(bArr3, 0, bArr5, length2, bArr3.length);
        System.arraycopy(bArr4, 0, bArr5, length2 + bArr3.length, bArr4.length);
        return bArr5;
    }

    public static boolean constantTimeAreEqual(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            if (bArr == bArr2) {
                return true;
            }
            int length = bArr.length < bArr2.length ? bArr.length : bArr2.length;
            int length2 = bArr.length ^ bArr2.length;
            for (int i8 = 0; i8 != length; i8++) {
                length2 |= bArr[i8] ^ bArr2[i8];
            }
            while (length < bArr2.length) {
                byte b9 = bArr2[length];
                length2 |= b9 ^ (~b9);
                length++;
            }
            if (length2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(int[] iArr, int i8) {
        for (int i9 : iArr) {
            if (i9 == i8) {
                return true;
            }
        }
        return false;
    }

    public static int[] copyOf(int[] iArr, int i8) {
        int[] iArr2 = new int[i8];
        System.arraycopy(iArr, 0, iArr2, 0, Math.min(iArr.length, i8));
        return iArr2;
    }

    public static int[] copyOfRange(int[] iArr, int i8, int i9) {
        int length = getLength(i8, i9);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, i8, iArr2, 0, Math.min(iArr.length - i8, length));
        return iArr2;
    }

    public static void fill(char[] cArr, char c3) {
        java.util.Arrays.fill(cArr, c3);
    }

    public static int hashCode(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i8 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i8;
            }
            i8 = (i8 * 257) ^ cArr[length];
        }
    }

    public static boolean isNullOrEmpty(Object[] objArr) {
        return objArr == null || objArr.length < 1;
    }

    public static short[] prepend(short[] sArr, short s8) {
        if (sArr == null) {
            return new short[]{s8};
        }
        int length = sArr.length;
        short[] sArr2 = new short[length + 1];
        System.arraycopy(sArr, 0, sArr2, 1, length);
        sArr2[0] = s8;
        return sArr2;
    }

    public static int[] reverse(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i8 = 0;
        while (true) {
            length--;
            if (length < 0) {
                return iArr2;
            }
            iArr2[length] = iArr[i8];
            i8++;
        }
    }

    public static int[] reverseInPlace(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length - 1;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = iArr[i8];
            iArr[i8] = iArr[length];
            iArr[length] = i9;
            length--;
        }
        return iArr;
    }

    public static short[] append(short[] sArr, short s8) {
        if (sArr == null) {
            return new short[]{s8};
        }
        int length = sArr.length;
        short[] sArr2 = new short[length + 1];
        System.arraycopy(sArr, 0, sArr2, 0, length);
        sArr2[length] = s8;
        return sArr2;
    }

    public static boolean areEqual(int[] iArr, int[] iArr2) {
        return java.util.Arrays.equals(iArr, iArr2);
    }

    public static void clear(long[] jArr) {
        if (jArr != null) {
            java.util.Arrays.fill(jArr, 0L);
        }
    }

    public static int[] clone(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public static byte[] concatenate(byte[][] bArr) {
        int length = 0;
        for (int i8 = 0; i8 != bArr.length; i8++) {
            length += bArr[i8].length;
        }
        byte[] bArr2 = new byte[length];
        int length2 = 0;
        for (int i9 = 0; i9 != bArr.length; i9++) {
            byte[] bArr3 = bArr[i9];
            System.arraycopy(bArr3, 0, bArr2, length2, bArr3.length);
            length2 += bArr[i9].length;
        }
        return bArr2;
    }

    public static boolean constantTimeAreEqual(char[] cArr, char[] cArr2) {
        if (cArr != null && cArr2 != null) {
            if (cArr == cArr2) {
                return true;
            }
            int iMin = Math.min(cArr.length, cArr2.length);
            int length = cArr.length ^ cArr2.length;
            for (int i8 = 0; i8 != iMin; i8++) {
                length |= cArr[i8] ^ cArr2[i8];
            }
            while (iMin < cArr2.length) {
                char c3 = cArr2[iMin];
                length |= ((byte) (~c3)) ^ ((byte) c3);
                iMin++;
            }
            if (length == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(long[] jArr, long j4) {
        for (long j8 : jArr) {
            if (j8 == j4) {
                return true;
            }
        }
        return false;
    }

    public static long[] copyOf(long[] jArr, int i8) {
        long[] jArr2 = new long[i8];
        System.arraycopy(jArr, 0, jArr2, 0, Math.min(jArr.length, i8));
        return jArr2;
    }

    public static long[] copyOfRange(long[] jArr, int i8, int i9) {
        int length = getLength(i8, i9);
        long[] jArr2 = new long[length];
        System.arraycopy(jArr, i8, jArr2, 0, Math.min(jArr.length - i8, length));
        return jArr2;
    }

    public static void fill(char[] cArr, int i8, int i9, char c3) {
        java.util.Arrays.fill(cArr, i8, i9, c3);
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length;
        int i8 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i8;
            }
            i8 = (i8 * 257) ^ iArr[length];
        }
    }

    public static short[] reverseInPlace(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        int length = sArr.length - 1;
        for (int i8 = 0; i8 < length; i8++) {
            short s8 = sArr[i8];
            sArr[i8] = sArr[length];
            sArr[length] = s8;
            length--;
        }
        return sArr;
    }

    public static boolean areEqual(long[] jArr, long[] jArr2) {
        return java.util.Arrays.equals(jArr, jArr2);
    }

    public static long[] clone(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public static int[] concatenate(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return clone(iArr2);
        }
        if (iArr2 == null) {
            return clone(iArr);
        }
        int[] iArr3 = new int[iArr.length + iArr2.length];
        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
        return iArr3;
    }

    public static boolean constantTimeAreEqual(long[] jArr, long[] jArr2) {
        if (jArr != null && jArr2 != null) {
            if (jArr == jArr2) {
                return true;
            }
            int length = jArr.length < jArr2.length ? jArr.length : jArr2.length;
            long length2 = jArr.length ^ jArr2.length;
            for (int i8 = 0; i8 != length; i8++) {
                length2 |= jArr[i8] ^ jArr2[i8];
            }
            while (length < jArr2.length) {
                long j4 = jArr2[length];
                length2 |= j4 ^ (~j4);
                length++;
            }
            if (length2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(short[] sArr, short s8) {
        for (short s9 : sArr) {
            if (s9 == s8) {
                return true;
            }
        }
        return false;
    }

    public static BigInteger[] copyOf(BigInteger[] bigIntegerArr, int i8) {
        BigInteger[] bigIntegerArr2 = new BigInteger[i8];
        System.arraycopy(bigIntegerArr, 0, bigIntegerArr2, 0, Math.min(bigIntegerArr.length, i8));
        return bigIntegerArr2;
    }

    public static BigInteger[] copyOfRange(BigInteger[] bigIntegerArr, int i8, int i9) {
        int length = getLength(i8, i9);
        BigInteger[] bigIntegerArr2 = new BigInteger[length];
        System.arraycopy(bigIntegerArr, i8, bigIntegerArr2, 0, Math.min(bigIntegerArr.length - i8, length));
        return bigIntegerArr2;
    }

    public static void fill(int[] iArr, int i8) {
        java.util.Arrays.fill(iArr, i8);
    }

    public static int hashCode(int[] iArr, int i8, int i9) {
        if (iArr == null) {
            return 0;
        }
        int i10 = i9 + 1;
        while (true) {
            i9--;
            if (i9 < 0) {
                return i10;
            }
            i10 = (i10 * 257) ^ iArr[i8 + i9];
        }
    }

    public static boolean areEqual(Object[] objArr, Object[] objArr2) {
        return java.util.Arrays.equals(objArr, objArr2);
    }

    public static long[] clone(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            return null;
        }
        if (jArr2 == null || jArr2.length != jArr.length) {
            return clone(jArr);
        }
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        return jArr2;
    }

    public static short[] concatenate(short[] sArr, short[] sArr2) {
        if (sArr == null) {
            return clone(sArr2);
        }
        if (sArr2 == null) {
            return clone(sArr);
        }
        short[] sArr3 = new short[sArr.length + sArr2.length];
        System.arraycopy(sArr, 0, sArr3, 0, sArr.length);
        System.arraycopy(sArr2, 0, sArr3, sArr.length, sArr2.length);
        return sArr3;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        for (boolean z2 : zArr) {
            if (z2 == z) {
                return true;
            }
        }
        return false;
    }

    public static short[] copyOf(short[] sArr, int i8) {
        short[] sArr2 = new short[i8];
        System.arraycopy(sArr, 0, sArr2, 0, Math.min(sArr.length, i8));
        return sArr2;
    }

    public static short[] copyOfRange(short[] sArr, int i8, int i9) {
        int length = getLength(i8, i9);
        short[] sArr2 = new short[length];
        System.arraycopy(sArr, i8, sArr2, 0, Math.min(sArr.length - i8, length));
        return sArr2;
    }

    public static void fill(int[] iArr, int i8, int i9, int i10) {
        java.util.Arrays.fill(iArr, i8, i9, i10);
    }

    public static int hashCode(long[] jArr) {
        if (jArr == null) {
            return 0;
        }
        int length = jArr.length;
        int i8 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i8;
            }
            long j4 = jArr[length];
            i8 = (((i8 * 257) ^ ((int) j4)) * 257) ^ ((int) (j4 >>> 32));
        }
    }

    public static boolean areEqual(short[] sArr, short[] sArr2) {
        return java.util.Arrays.equals(sArr, sArr2);
    }

    public static BigInteger[] clone(BigInteger[] bigIntegerArr) {
        if (bigIntegerArr == null) {
            return null;
        }
        return (BigInteger[]) bigIntegerArr.clone();
    }

    public static boolean[] copyOf(boolean[] zArr, int i8) {
        boolean[] zArr2 = new boolean[i8];
        System.arraycopy(zArr, 0, zArr2, 0, Math.min(zArr.length, i8));
        return zArr2;
    }

    public static boolean[] copyOfRange(boolean[] zArr, int i8, int i9) {
        int length = getLength(i8, i9);
        boolean[] zArr2 = new boolean[length];
        System.arraycopy(zArr, i8, zArr2, 0, Math.min(zArr.length - i8, length));
        return zArr2;
    }

    public static void fill(long[] jArr, int i8, int i9, long j4) {
        java.util.Arrays.fill(jArr, i8, i9, j4);
    }

    public static int hashCode(long[] jArr, int i8, int i9) {
        if (jArr == null) {
            return 0;
        }
        int i10 = i9 + 1;
        while (true) {
            i9--;
            if (i9 < 0) {
                return i10;
            }
            long j4 = jArr[i8 + i9];
            i10 = (((i10 * 257) ^ ((int) j4)) * 257) ^ ((int) (j4 >>> 32));
        }
    }

    public static boolean areEqual(boolean[] zArr, boolean[] zArr2) {
        return java.util.Arrays.equals(zArr, zArr2);
    }

    public static short[] clone(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    public static void fill(long[] jArr, long j4) {
        java.util.Arrays.fill(jArr, j4);
    }

    public static int hashCode(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        int length = objArr.length;
        int iHashCode = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return iHashCode;
            }
            iHashCode = (iHashCode * 257) ^ Objects.hashCode(objArr[length]);
        }
    }

    public static boolean[] clone(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return (boolean[]) zArr.clone();
    }

    public static void fill(Object[] objArr, int i8, int i9, Object obj) {
        java.util.Arrays.fill(objArr, i8, i9, obj);
    }

    public static int hashCode(short[] sArr) {
        if (sArr == null) {
            return 0;
        }
        int length = sArr.length;
        int i8 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i8;
            }
            i8 = (i8 * 257) ^ (sArr[length] & 255);
        }
    }

    public static byte[][] clone(byte[][] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[][] bArr2 = new byte[length][];
        for (int i8 = 0; i8 != length; i8++) {
            bArr2[i8] = clone(bArr[i8]);
        }
        return bArr2;
    }

    public static void fill(Object[] objArr, Object obj) {
        java.util.Arrays.fill(objArr, obj);
    }

    public static int hashCode(int[][] iArr) {
        int iHashCode = 0;
        for (int i8 = 0; i8 != iArr.length; i8++) {
            iHashCode = (iHashCode * 257) + hashCode(iArr[i8]);
        }
        return iHashCode;
    }

    public static byte[][][] clone(byte[][][] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[][][] bArr2 = new byte[length][][];
        for (int i8 = 0; i8 != length; i8++) {
            bArr2[i8] = clone(bArr[i8]);
        }
        return bArr2;
    }

    public static void fill(short[] sArr, int i8, int i9, short s8) {
        java.util.Arrays.fill(sArr, i8, i9, s8);
    }

    public static int hashCode(short[][] sArr) {
        int iHashCode = 0;
        for (int i8 = 0; i8 != sArr.length; i8++) {
            iHashCode = (iHashCode * 257) + hashCode(sArr[i8]);
        }
        return iHashCode;
    }

    public static void fill(short[] sArr, short s8) {
        java.util.Arrays.fill(sArr, s8);
    }

    public static int hashCode(short[][][] sArr) {
        int iHashCode = 0;
        for (int i8 = 0; i8 != sArr.length; i8++) {
            iHashCode = (iHashCode * 257) + hashCode(sArr[i8]);
        }
        return iHashCode;
    }

    public static void fill(boolean[] zArr, int i8, int i9, boolean z) {
        java.util.Arrays.fill(zArr, i8, i9, z);
    }

    public static void fill(boolean[] zArr, boolean z) {
        java.util.Arrays.fill(zArr, z);
    }
}
