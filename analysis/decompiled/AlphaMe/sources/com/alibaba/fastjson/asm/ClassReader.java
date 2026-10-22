package com.alibaba.fastjson.asm;

import kotlin.UByte;

/* loaded from: classes.dex */
public class ClassReader {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f4609b;
    public final int header;
    private final int[] items;
    private final int maxStringLength;
    private final String[] strings;

    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ClassReader(java.io.InputStream r10) throws java.io.IOException {
        /*
            r9 = this;
            r9.<init>()
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]
        Lc:
            int r2 = r10.read(r1)
            r3 = -1
            r4 = 0
            if (r2 != r3) goto L6f
            r10.close()
            byte[] r10 = r0.toByteArray()
            r9.f4609b = r10
            r10 = 8
            int r10 = r9.readUnsignedShort(r10)
            int[] r10 = new int[r10]
            r9.items = r10
            int r10 = r10.length
            java.lang.String[] r0 = new java.lang.String[r10]
            r9.strings = r0
            r0 = 1
            r1 = 10
            r2 = r0
        L30:
            if (r2 >= r10) goto L6a
            int[] r3 = r9.items
            int r5 = r1 + 1
            r3[r2] = r5
            byte[] r3 = r9.f4609b
            r3 = r3[r1]
            r6 = 3
            if (r3 == r0) goto L5f
            r5 = 15
            r7 = 4
            if (r3 == r5) goto L5d
            r5 = 18
            r8 = 5
            if (r3 == r5) goto L5b
            if (r3 == r6) goto L5b
            if (r3 == r7) goto L5b
            if (r3 == r8) goto L56
            r5 = 6
            if (r3 == r5) goto L56
            switch(r3) {
                case 9: goto L5b;
                case 10: goto L5b;
                case 11: goto L5b;
                case 12: goto L5b;
                default: goto L55;
            }
        L55:
            goto L67
        L56:
            int r2 = r2 + 1
            r6 = 9
            goto L67
        L5b:
            r6 = r8
            goto L67
        L5d:
            r6 = r7
            goto L67
        L5f:
            int r3 = r9.readUnsignedShort(r5)
            int r6 = r6 + r3
            if (r6 <= r4) goto L67
            r4 = r6
        L67:
            int r1 = r1 + r6
            int r2 = r2 + r0
            goto L30
        L6a:
            r9.maxStringLength = r4
            r9.header = r1
            return
        L6f:
            if (r2 <= 0) goto Lc
            r0.write(r1, r4, r2)
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.asm.ClassReader.<init>(java.io.InputStream):void");
    }

    private int readInt(int i4) {
        byte[] bArr = this.f4609b;
        return (bArr[i4 + 3] & UByte.MAX_VALUE) | ((bArr[i4] & UByte.MAX_VALUE) << 24) | ((bArr[i4 + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i4 + 2] & UByte.MAX_VALUE) << 8);
    }

    private int readMethod(TypeCollector typeCollector, char[] cArr, int i4) {
        int unsignedShort = readUnsignedShort(i4);
        String utf8 = readUTF8(i4 + 2, cArr);
        String utf82 = readUTF8(i4 + 4, cArr);
        int i5 = i4 + 8;
        int i6 = 0;
        int i7 = 0;
        for (int unsignedShort2 = readUnsignedShort(i4 + 6); unsignedShort2 > 0; unsignedShort2--) {
            String utf83 = readUTF8(i5, cArr);
            int i8 = readInt(i5 + 2);
            int i9 = i5 + 6;
            if (utf83.equals("Code")) {
                i7 = i9;
            }
            i5 = i9 + i8;
        }
        MethodCollector methodCollectorVisitMethod = typeCollector.visitMethod(unsignedShort, utf8, utf82);
        if (methodCollectorVisitMethod != null && i7 != 0) {
            int i10 = i7 + 8 + readInt(i7 + 4);
            int i11 = i10 + 2;
            for (int unsignedShort3 = readUnsignedShort(i10); unsignedShort3 > 0; unsignedShort3--) {
                i11 += 8;
            }
            int i12 = i11 + 2;
            int i13 = 0;
            for (int unsignedShort4 = readUnsignedShort(i11); unsignedShort4 > 0; unsignedShort4--) {
                String utf84 = readUTF8(i12, cArr);
                if (utf84.equals("LocalVariableTable")) {
                    i6 = i12 + 6;
                } else if (utf84.equals("LocalVariableTypeTable")) {
                    i13 = i12 + 6;
                }
                i12 += readInt(i12 + 2) + 6;
            }
            if (i6 != 0) {
                if (i13 != 0) {
                    int unsignedShort5 = readUnsignedShort(i13) * 3;
                    int i14 = i13 + 2;
                    int[] iArr = new int[unsignedShort5];
                    while (unsignedShort5 > 0) {
                        iArr[unsignedShort5 - 1] = i14 + 6;
                        iArr[unsignedShort5 - 2] = readUnsignedShort(i14 + 8);
                        unsignedShort5 -= 3;
                        iArr[unsignedShort5] = readUnsignedShort(i14);
                        i14 += 10;
                    }
                }
                int i15 = i6 + 2;
                for (int unsignedShort6 = readUnsignedShort(i6); unsignedShort6 > 0; unsignedShort6--) {
                    methodCollectorVisitMethod.visitLocalVariable(readUTF8(i15 + 4, cArr), readUnsignedShort(i15 + 8));
                    i15 += 10;
                }
            }
        }
        return i5;
    }

    private String readUTF(int i4, int i5, char[] cArr) {
        int i6;
        int i7 = i5 + i4;
        byte[] bArr = this.f4609b;
        int i8 = 0;
        char c4 = 0;
        char c5 = 0;
        while (i4 < i7) {
            int i9 = i4 + 1;
            byte b4 = bArr[i4];
            if (c4 == 0) {
                int i10 = b4 & UByte.MAX_VALUE;
                if (i10 < 128) {
                    cArr[i8] = (char) i10;
                    i8++;
                } else if (i10 >= 224 || i10 <= 191) {
                    c5 = (char) (b4 & 15);
                    c4 = 2;
                } else {
                    i6 = b4 & 31;
                    c5 = (char) i6;
                    c4 = 1;
                }
            } else if (c4 == 1) {
                cArr[i8] = (char) ((b4 & 63) | (c5 << 6));
                i8++;
                c4 = 0;
            } else if (c4 == 2) {
                i6 = (b4 & 63) | (c5 << 6);
                c5 = (char) i6;
                c4 = 1;
            }
            i4 = i9;
        }
        return new String(cArr, 0, i8);
    }

    private String readUTF8(int i4, char[] cArr) {
        int unsignedShort = readUnsignedShort(i4);
        String[] strArr = this.strings;
        String str = strArr[unsignedShort];
        if (str != null) {
            return str;
        }
        int i5 = this.items[unsignedShort];
        String utf = readUTF(i5 + 2, readUnsignedShort(i5), cArr);
        strArr[unsignedShort] = utf;
        return utf;
    }

    private int readUnsignedShort(int i4) {
        byte[] bArr = this.f4609b;
        return (bArr[i4 + 1] & UByte.MAX_VALUE) | ((bArr[i4] & UByte.MAX_VALUE) << 8);
    }

    public void accept(TypeCollector typeCollector) {
        char[] cArr = new char[this.maxStringLength];
        int i4 = this.header;
        int i5 = this.items[readUnsignedShort(i4 + 4)];
        int unsignedShort = readUnsignedShort(i4 + 6);
        int i6 = i4 + 8;
        for (int i7 = 0; i7 < unsignedShort; i7++) {
            i6 += 2;
        }
        int i8 = i6 + 2;
        int i9 = i8;
        for (int unsignedShort2 = readUnsignedShort(i6); unsignedShort2 > 0; unsignedShort2--) {
            i9 += 8;
            for (int unsignedShort3 = readUnsignedShort(i9 + 6); unsignedShort3 > 0; unsignedShort3--) {
                i9 += readInt(i9 + 2) + 6;
            }
        }
        int i10 = i9 + 2;
        for (int unsignedShort4 = readUnsignedShort(i9); unsignedShort4 > 0; unsignedShort4--) {
            i10 += 8;
            for (int unsignedShort5 = readUnsignedShort(i10 + 6); unsignedShort5 > 0; unsignedShort5--) {
                i10 += readInt(i10 + 2) + 6;
            }
        }
        int i11 = i10 + 2;
        for (int unsignedShort6 = readUnsignedShort(i10); unsignedShort6 > 0; unsignedShort6--) {
            i11 += readInt(i11 + 2) + 6;
        }
        for (int unsignedShort7 = readUnsignedShort(i6); unsignedShort7 > 0; unsignedShort7--) {
            i8 += 8;
            for (int unsignedShort8 = readUnsignedShort(i8 + 6); unsignedShort8 > 0; unsignedShort8--) {
                i8 += readInt(i8 + 2) + 6;
            }
        }
        int method = i8 + 2;
        for (int unsignedShort9 = readUnsignedShort(i8); unsignedShort9 > 0; unsignedShort9--) {
            method = readMethod(typeCollector, cArr, method);
        }
    }
}
