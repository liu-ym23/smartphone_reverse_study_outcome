package n0;

/* renamed from: n0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0872b {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f18839a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f18840b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f18841c;

    /* renamed from: d, reason: collision with root package name */
    private final int f18842d;

    /* renamed from: e, reason: collision with root package name */
    public final int f18843e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f18844f;

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0872b(java.io.InputStream r9, boolean r10) throws java.io.IOException {
        /*
            r8 = this;
            r8.<init>()
            r8.f18844f = r10
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream
            r10.<init>()
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
        Le:
            int r1 = r9.read(r0)
            r2 = -1
            r3 = 0
            if (r1 != r2) goto L71
            r9.close()
            byte[] r9 = r10.toByteArray()
            r8.f18839a = r9
            r9 = 8
            int r9 = r8.g(r9)
            int[] r9 = new int[r9]
            r8.f18840b = r9
            int r9 = r9.length
            java.lang.String[] r10 = new java.lang.String[r9]
            r8.f18841c = r10
            r10 = 1
            r0 = 10
            r1 = r10
        L32:
            if (r1 >= r9) goto L6c
            int[] r2 = r8.f18840b
            int r4 = r0 + 1
            r2[r1] = r4
            byte[] r2 = r8.f18839a
            r2 = r2[r0]
            r5 = 3
            if (r2 == r10) goto L61
            r4 = 15
            r6 = 4
            if (r2 == r4) goto L5f
            r4 = 18
            r7 = 5
            if (r2 == r4) goto L5d
            if (r2 == r5) goto L5d
            if (r2 == r6) goto L5d
            if (r2 == r7) goto L58
            r4 = 6
            if (r2 == r4) goto L58
            switch(r2) {
                case 9: goto L5d;
                case 10: goto L5d;
                case 11: goto L5d;
                case 12: goto L5d;
                default: goto L57;
            }
        L57:
            goto L69
        L58:
            int r1 = r1 + 1
            r5 = 9
            goto L69
        L5d:
            r5 = r7
            goto L69
        L5f:
            r5 = r6
            goto L69
        L61:
            int r2 = r8.g(r4)
            int r5 = r5 + r2
            if (r5 <= r3) goto L69
            r3 = r5
        L69:
            int r0 = r0 + r5
            int r1 = r1 + r10
            goto L32
        L6c:
            r8.f18842d = r3
            r8.f18843e = r0
            return
        L71:
            if (r1 <= 0) goto Le
            r10.write(r0, r3, r1)
            goto Le
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.C0872b.<init>(java.io.InputStream, boolean):void");
    }

    private int b() {
        int i5 = this.f18843e;
        int iG = i5 + 8 + (g(i5 + 6) * 2);
        for (int iG2 = g(iG); iG2 > 0; iG2--) {
            for (int iG3 = g(iG + 8); iG3 > 0; iG3--) {
                iG += c(iG + 12) + 6;
            }
            iG += 8;
        }
        int iC = iG + 2;
        for (int iG4 = g(iC); iG4 > 0; iG4--) {
            for (int iG5 = g(iC + 8); iG5 > 0; iG5--) {
                iC += c(iC + 12) + 6;
            }
            iC += 8;
        }
        return iC + 2;
    }

    private int c(int i5) {
        byte[] bArr = this.f18839a;
        return (bArr[i5 + 3] & 255) | ((bArr[i5] & 255) << 24) | ((bArr[i5 + 1] & 255) << 16) | ((bArr[i5 + 2] & 255) << 8);
    }

    private int d(k kVar, char[] cArr, int i5) {
        int iG = g(i5);
        String strF = f(i5 + 2, cArr);
        String strF2 = f(i5 + 4, cArr);
        int i6 = i5 + 8;
        int i7 = 0;
        int i8 = 0;
        for (int iG2 = g(i5 + 6); iG2 > 0; iG2--) {
            String strF3 = f(i6, cArr);
            int iC = c(i6 + 2);
            int i9 = i6 + 6;
            if (strF3.equals("Code")) {
                i8 = i9;
            }
            i6 = i9 + iC;
        }
        g gVarE = kVar.e(iG, strF, strF2);
        if (gVarE != null && i8 != 0) {
            int iC2 = i8 + 8 + c(i8 + 4);
            int i10 = iC2 + 2;
            for (int iG3 = g(iC2); iG3 > 0; iG3--) {
                i10 += 8;
            }
            int iC3 = i10 + 2;
            int i11 = 0;
            for (int iG4 = g(i10); iG4 > 0; iG4--) {
                String strF4 = f(iC3, cArr);
                if (strF4.equals("LocalVariableTable")) {
                    i7 = iC3 + 6;
                } else if (strF4.equals("LocalVariableTypeTable")) {
                    i11 = iC3 + 6;
                }
                iC3 += c(iC3 + 2) + 6;
            }
            if (i7 != 0) {
                if (i11 != 0) {
                    int iG5 = g(i11) * 3;
                    int i12 = i11 + 2;
                    int[] iArr = new int[iG5];
                    while (iG5 > 0) {
                        iArr[iG5 - 1] = i12 + 6;
                        iArr[iG5 - 2] = g(i12 + 8);
                        iG5 -= 3;
                        iArr[iG5] = g(i12);
                        i12 += 10;
                    }
                }
                int i13 = i7 + 2;
                for (int iG6 = g(i7); iG6 > 0; iG6--) {
                    gVarE.b(f(i13 + 4, cArr), g(i13 + 8));
                    i13 += 10;
                }
            }
        }
        return i6;
    }

    private String e(int i5, int i6, char[] cArr) {
        int i7;
        int i8 = i6 + i5;
        byte[] bArr = this.f18839a;
        int i9 = 0;
        char c6 = 0;
        char c7 = 0;
        while (i5 < i8) {
            int i10 = i5 + 1;
            byte b6 = bArr[i5];
            if (c6 == 0) {
                int i11 = b6 & 255;
                if (i11 < 128) {
                    cArr[i9] = (char) i11;
                    i9++;
                } else if (i11 >= 224 || i11 <= 191) {
                    c7 = (char) (b6 & 15);
                    c6 = 2;
                } else {
                    i7 = b6 & 31;
                    c7 = (char) i7;
                    c6 = 1;
                }
            } else if (c6 == 1) {
                cArr[i9] = (char) ((b6 & 63) | (c7 << 6));
                i9++;
                c6 = 0;
            } else if (c6 == 2) {
                i7 = (b6 & 63) | (c7 << 6);
                c7 = (char) i7;
                c6 = 1;
            }
            i5 = i10;
        }
        return new String(cArr, 0, i9);
    }

    private String f(int i5, char[] cArr) {
        int iG = g(i5);
        String[] strArr = this.f18841c;
        String str = strArr[iG];
        if (str != null) {
            return str;
        }
        int i6 = this.f18840b[iG];
        String strE = e(i6 + 2, g(i6), cArr);
        strArr[iG] = strE;
        return strE;
    }

    private int g(int i5) {
        byte[] bArr = this.f18839a;
        return (bArr[i5 + 1] & 255) | ((bArr[i5] & 255) << 8);
    }

    public void a(k kVar) {
        int i5;
        char[] cArr = new char[this.f18842d];
        if (this.f18844f) {
            int iB = b();
            for (int iG = g(iB); iG > 0; iG--) {
                if ("RuntimeVisibleAnnotations".equals(f(iB + 2, cArr))) {
                    i5 = iB + 8;
                    break;
                }
                iB += c(iB + 4) + 6;
            }
            i5 = 0;
        } else {
            i5 = 0;
        }
        int i6 = this.f18843e;
        int iG2 = g(i6 + 6);
        int i7 = i6 + 8;
        for (int i8 = 0; i8 < iG2; i8++) {
            i7 += 2;
        }
        int iC = i7 + 2;
        int iC2 = iC;
        for (int iG3 = g(i7); iG3 > 0; iG3--) {
            iC2 += 8;
            for (int iG4 = g(iC2 + 6); iG4 > 0; iG4--) {
                iC2 += c(iC2 + 2) + 6;
            }
        }
        int iC3 = iC2 + 2;
        for (int iG5 = g(iC2); iG5 > 0; iG5--) {
            iC3 += 8;
            for (int iG6 = g(iC3 + 6); iG6 > 0; iG6--) {
                iC3 += c(iC3 + 2) + 6;
            }
        }
        int iC4 = iC3 + 2;
        for (int iG7 = g(iC3); iG7 > 0; iG7--) {
            iC4 += c(iC4 + 2) + 6;
        }
        if (i5 != 0) {
            int i9 = i5 + 2;
            for (int iG8 = g(i5); iG8 > 0; iG8--) {
                kVar.d(f(i9, cArr));
            }
        }
        for (int iG9 = g(i7); iG9 > 0; iG9--) {
            iC += 8;
            for (int iG10 = g(iC + 6); iG10 > 0; iG10--) {
                iC += c(iC + 2) + 6;
            }
        }
        int iD = iC + 2;
        for (int iG11 = g(iC); iG11 > 0; iG11--) {
            iD = d(kVar, cArr, iD);
        }
    }
}
