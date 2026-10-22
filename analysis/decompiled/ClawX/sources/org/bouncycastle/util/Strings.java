package org.bouncycastle.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Vector;
import org.bouncycastle.util.encoders.UTF8;

/* loaded from: classes.dex */
public final class Strings {
    private static String LINE_SEPARATOR;

    public static class StringListImpl extends ArrayList<String> implements StringList {
        private StringListImpl() {
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List, org.bouncycastle.util.StringList
        public /* bridge */ /* synthetic */ String get(int i8) {
            return (String) super.get(i8);
        }

        @Override // org.bouncycastle.util.StringList
        public String[] toStringArray() {
            int size = size();
            String[] strArr = new String[size];
            for (int i8 = 0; i8 != size; i8++) {
                strArr[i8] = get(i8);
            }
            return strArr;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public void add(int i8, String str) {
            super.add(i8, (int) str);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public String set(int i8, String str) {
            return (String) super.set(i8, (int) str);
        }

        @Override // org.bouncycastle.util.StringList
        public String[] toStringArray(int i8, int i9) {
            String[] strArr = new String[i9 - i8];
            for (int i10 = i8; i10 != size() && i10 != i9; i10++) {
                strArr[i10 - i8] = get(i10);
            }
            return strArr;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(String str) {
            return super.add((StringListImpl) str);
        }
    }

    static {
        try {
            try {
                LINE_SEPARATOR = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: org.bouncycastle.util.Strings.1
                    @Override // java.security.PrivilegedAction
                    public String run() {
                        return System.getProperty("line.separator");
                    }
                });
            } catch (Exception unused) {
                LINE_SEPARATOR = String.format("%n", new Object[0]);
            }
        } catch (Exception unused2) {
            LINE_SEPARATOR = "\n";
        }
    }

    public static char[] asCharArray(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i8 = 0; i8 != length; i8++) {
            cArr[i8] = (char) (bArr[i8] & 255);
        }
        return cArr;
    }

    public static boolean constantTimeAreEqual(String str, String str2) {
        boolean z = str.length() == str2.length();
        int length = str.length();
        if (z) {
            for (int i8 = 0; i8 != length; i8++) {
                z &= str.charAt(i8) == str2.charAt(i8);
            }
            return z;
        }
        for (int i9 = 0; i9 != length; i9++) {
            z &= str.charAt(i9) == ' ';
        }
        return z;
    }

    public static String fromByteArray(byte[] bArr) {
        return new String(asCharArray(bArr));
    }

    public static String fromUTF8ByteArray(byte[] bArr) {
        return fromUTF8ByteArray(bArr, 0, bArr.length);
    }

    public static String lineSeparator() {
        return LINE_SEPARATOR;
    }

    public static StringList newList() {
        return new StringListImpl();
    }

    public static String[] split(String str, char c3) {
        int i8;
        Vector vector = new Vector();
        boolean z = true;
        while (true) {
            if (!z) {
                break;
            }
            int iIndexOf = str.indexOf(c3);
            if (iIndexOf > 0) {
                vector.addElement(str.substring(0, iIndexOf));
                str = str.substring(iIndexOf + 1);
            } else {
                vector.addElement(str);
                z = false;
            }
        }
        int size = vector.size();
        String[] strArr = new String[size];
        for (i8 = 0; i8 != size; i8++) {
            strArr[i8] = (String) vector.elementAt(i8);
        }
        return strArr;
    }

    public static int toByteArray(String str, byte[] bArr, int i8) {
        int length = str.length();
        for (int i9 = 0; i9 < length; i9++) {
            bArr[i8 + i9] = (byte) str.charAt(i9);
        }
        return length;
    }

    public static String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i8 = 0; i8 != charArray.length; i8++) {
            char c3 = charArray[i8];
            if ('A' <= c3 && 'Z' >= c3) {
                charArray[i8] = (char) (c3 + ' ');
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008a, code lost:
    
        throw new java.lang.IllegalStateException("invalid UTF-16 low surrogate");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void toUTF8ByteArray(char[] r10, int r11, int r12, java.io.OutputStream r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.util.Strings.toUTF8ByteArray(char[], int, int, java.io.OutputStream):void");
    }

    public static String toUpperCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i8 = 0; i8 != charArray.length; i8++) {
            char c3 = charArray[i8];
            if ('a' <= c3 && 'z' >= c3) {
                charArray[i8] = (char) (c3 - ' ');
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    public static String fromUTF8ByteArray(byte[] bArr, int i8, int i9) {
        char[] cArr = new char[i9];
        int iTranscodeToUTF16 = UTF8.transcodeToUTF16(bArr, i8, i9, cArr);
        if (iTranscodeToUTF16 >= 0) {
            return new String(cArr, 0, iTranscodeToUTF16);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    public static byte[] toByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i8 = 0; i8 != length; i8++) {
            bArr[i8] = (byte) str.charAt(i8);
        }
        return bArr;
    }

    public static void toUTF8ByteArray(char[] cArr, OutputStream outputStream) throws IOException {
        toUTF8ByteArray(cArr, 0, cArr.length, outputStream);
    }

    public static byte[] toByteArray(char[] cArr) {
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i8 = 0; i8 != length; i8++) {
            bArr[i8] = (byte) cArr[i8];
        }
        return bArr;
    }

    public static byte[] toUTF8ByteArray(String str) {
        return toUTF8ByteArray(str.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char[] cArr) {
        return toUTF8ByteArray(cArr, 0, cArr.length);
    }

    public static byte[] toUTF8ByteArray(char[] cArr, int i8, int i9) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            toUTF8ByteArray(cArr, i8, i9, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
    }
}
