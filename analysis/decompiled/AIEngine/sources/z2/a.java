package z2;

import com.fasterxml.jackson.core.util.InternCache;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final a f14218a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference<C0179a> f14219b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14220c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14221d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14222e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f14223f;

    /* renamed from: g, reason: collision with root package name */
    public int f14224g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f14225i;

    /* renamed from: j, reason: collision with root package name */
    public int f14226j;

    /* renamed from: k, reason: collision with root package name */
    public int f14227k;

    /* renamed from: l, reason: collision with root package name */
    public String[] f14228l;

    /* renamed from: m, reason: collision with root package name */
    public int f14229m;

    /* renamed from: n, reason: collision with root package name */
    public int f14230n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f14231o;

    public a(int i10) {
        this.f14218a = null;
        this.f14220c = i10;
        this.f14221d = true;
        this.f14222e = true;
        this.f14219b = new AtomicReference<>(new C0179a(64, 4, new int[VadSessionManager.FRAME_BYTES], new String[TraceIdKeys.MAX_LENGTH], 448, VadSessionManager.FRAME_BYTES));
    }

    public final int a(int i10) {
        return ((this.f14224g - 1) & i10) << 2;
    }

    public final int b(int i10) {
        int iA = a(i10);
        int[] iArr = this.f14223f;
        if (iArr[iA + 3] == 0) {
            return iA;
        }
        if (this.f14227k > (this.f14224g >> 1)) {
            int iD = (this.f14229m - d()) >> 2;
            int i11 = this.f14227k;
            if (iD > ((i11 + 1) >> 7) || i11 > this.f14224g * 0.8d) {
                return c(i10);
            }
        }
        int i12 = this.h + ((iA >> 3) << 2);
        if (iArr[i12 + 3] == 0) {
            return i12;
        }
        int i13 = this.f14225i;
        int i14 = this.f14226j;
        int i15 = i13 + ((iA >> (i14 + 2)) << i14);
        int i16 = (1 << i14) + i15;
        while (i15 < i16) {
            if (iArr[i15 + 3] == 0) {
                return i15;
            }
            i15 += 4;
        }
        int i17 = this.f14229m;
        int i18 = i17 + 4;
        this.f14229m = i18;
        int i19 = this.f14224g;
        if (i18 < (i19 << 3)) {
            return i17;
        }
        if (!this.f14222e || i19 <= 1024) {
            return c(i10);
        }
        StringBuilder sb2 = new StringBuilder("Spill-over slots in symbol table with ");
        sb2.append(this.f14227k);
        sb2.append(" entries, hash area of ");
        sb2.append(this.f14224g);
        sb2.append(" slots is now full (all ");
        throw new IllegalStateException(ai.onnxruntime.a.j(" slots -- suspect a DoS attack based on hash collisions. You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`", this.f14224g >> 3, sb2));
    }

    public final int c(int i10) {
        this.f14231o = false;
        int[] iArr = this.f14223f;
        String[] strArr = this.f14228l;
        int i11 = this.f14224g;
        int i12 = this.f14227k;
        int i13 = i11 + i11;
        int i14 = this.f14229m;
        if (i13 > 65536) {
            n(true);
        } else {
            this.f14223f = new int[iArr.length + (i11 << 3)];
            this.f14224g = i13;
            int i15 = i13 << 2;
            this.h = i15;
            this.f14225i = i15 + (i15 >> 1);
            int i16 = i13 >> 2;
            this.f14226j = i16 < 64 ? 4 : i16 <= 256 ? 5 : i16 <= 1024 ? 6 : 7;
            this.f14228l = new String[strArr.length << 1];
            n(false);
            int[] iArr2 = new int[16];
            int i17 = 0;
            for (int i18 = 0; i18 < i14; i18 += 4) {
                int i19 = iArr[i18 + 3];
                if (i19 != 0) {
                    i17++;
                    String str = strArr[i18 >> 2];
                    if (i19 == 1) {
                        iArr2[0] = iArr[i18];
                        f(str, iArr2, 1);
                    } else if (i19 == 2) {
                        iArr2[0] = iArr[i18];
                        iArr2[1] = iArr[i18 + 1];
                        f(str, iArr2, 2);
                    } else if (i19 != 3) {
                        if (i19 > iArr2.length) {
                            iArr2 = new int[i19];
                        }
                        System.arraycopy(iArr, iArr[i18 + 1], iArr2, 0, i19);
                        f(str, iArr2, i19);
                    } else {
                        iArr2[0] = iArr[i18];
                        iArr2[1] = iArr[i18 + 1];
                        iArr2[2] = iArr[i18 + 2];
                        f(str, iArr2, 3);
                    }
                }
            }
            if (i17 != i12) {
                throw new IllegalStateException(a0.a.f("Failed rehash(): old count=", i12, i17, ", copyCount="));
            }
        }
        int iA = a(i10);
        int[] iArr3 = this.f14223f;
        if (iArr3[iA + 3] == 0) {
            return iA;
        }
        int i20 = this.h + ((iA >> 3) << 2);
        if (iArr3[i20 + 3] == 0) {
            return i20;
        }
        int i21 = this.f14225i;
        int i22 = this.f14226j;
        int i23 = i21 + ((iA >> (i22 + 2)) << i22);
        int i24 = (1 << i22) + i23;
        while (i23 < i24) {
            if (iArr3[i23 + 3] == 0) {
                return i23;
            }
            i23 += 4;
        }
        int i25 = this.f14229m;
        this.f14229m = i25 + 4;
        return i25;
    }

    public final int d() {
        int i10 = this.f14224g;
        return (i10 << 3) - i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(int r7, int r8, int[] r9) {
        /*
            r6 = this;
            int[] r0 = r6.f14223f
            r1 = 1
            r2 = 0
            switch(r7) {
                case 4: goto L51;
                case 5: goto L43;
                case 6: goto L35;
                case 7: goto L27;
                case 8: goto L1b;
                default: goto L7;
            }
        L7:
            r0 = r2
        L8:
            int r3 = r0 + 1
            r0 = r9[r0]
            int[] r4 = r6.f14223f
            int r5 = r8 + 1
            r8 = r4[r8]
            if (r0 == r8) goto L15
            return r2
        L15:
            if (r3 < r7) goto L18
            return r1
        L18:
            r0 = r3
            r8 = r5
            goto L8
        L1b:
            r6 = r9[r2]
            int r7 = r8 + 1
            r8 = r0[r8]
            if (r6 == r8) goto L24
            return r2
        L24:
            r8 = r7
            r6 = r1
            goto L28
        L27:
            r6 = r2
        L28:
            int r7 = r6 + 1
            r6 = r9[r6]
            int r3 = r8 + 1
            r8 = r0[r8]
            if (r6 == r8) goto L33
            return r2
        L33:
            r8 = r3
            goto L36
        L35:
            r7 = r2
        L36:
            int r6 = r7 + 1
            r7 = r9[r7]
            int r3 = r8 + 1
            r8 = r0[r8]
            if (r7 == r8) goto L41
            return r2
        L41:
            r8 = r3
            goto L44
        L43:
            r6 = r2
        L44:
            int r7 = r6 + 1
            r6 = r9[r6]
            int r3 = r8 + 1
            r8 = r0[r8]
            if (r6 == r8) goto L4f
            return r2
        L4f:
            r8 = r3
            goto L52
        L51:
            r7 = r2
        L52:
            int r6 = r7 + 1
            r3 = r9[r7]
            int r4 = r8 + 1
            r5 = r0[r8]
            if (r3 == r5) goto L5d
            return r2
        L5d:
            int r3 = r7 + 2
            r6 = r9[r6]
            int r5 = r8 + 2
            r4 = r0[r4]
            if (r6 == r4) goto L68
            return r2
        L68:
            int r7 = r7 + 3
            r6 = r9[r3]
            int r8 = r8 + 3
            r3 = r0[r5]
            if (r6 == r3) goto L73
            return r2
        L73:
            r6 = r9[r7]
            r7 = r0[r8]
            if (r6 == r7) goto L7a
            return r2
        L7a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.a.e(int, int, int[]):boolean");
    }

    public final String f(String str, int[] iArr, int i10) {
        int iB;
        if (this.f14231o) {
            int[] iArr2 = this.f14223f;
            this.f14223f = Arrays.copyOf(iArr2, iArr2.length);
            String[] strArr = this.f14228l;
            this.f14228l = (String[]) Arrays.copyOf(strArr, strArr.length);
            this.f14231o = false;
        }
        if (this.f14221d) {
            str = InternCache.f3643b.a(str);
        }
        if (i10 == 1) {
            int i11 = iArr[0] ^ this.f14220c;
            int i12 = i11 + (i11 >>> 16);
            int i13 = i12 ^ (i12 << 3);
            iB = b(i13 + (i13 >>> 12));
            int[] iArr3 = this.f14223f;
            iArr3[iB] = iArr[0];
            iArr3[iB + 3] = 1;
        } else if (i10 == 2) {
            iB = b(g(iArr[0], iArr[1]));
            int[] iArr4 = this.f14223f;
            iArr4[iB] = iArr[0];
            iArr4[iB + 1] = iArr[1];
            iArr4[iB + 3] = 2;
        } else if (i10 != 3) {
            int i14 = i(iArr, i10);
            iB = b(i14);
            int[] iArr5 = this.f14223f;
            iArr5[iB] = i14;
            int i15 = this.f14230n;
            int i16 = i15 + i10;
            if (i16 > iArr5.length) {
                this.f14223f = Arrays.copyOf(this.f14223f, Math.max(i16 - iArr5.length, Math.min(4096, this.f14224g)) + this.f14223f.length);
            }
            System.arraycopy(iArr, 0, this.f14223f, i15, i10);
            this.f14230n += i10;
            int[] iArr6 = this.f14223f;
            iArr6[iB + 1] = i15;
            iArr6[iB + 3] = i10;
        } else {
            iB = b(h(iArr[0], iArr[1], iArr[2]));
            int[] iArr7 = this.f14223f;
            iArr7[iB] = iArr[0];
            iArr7[iB + 1] = iArr[1];
            iArr7[iB + 2] = iArr[2];
            iArr7[iB + 3] = 3;
        }
        this.f14228l[iB >> 2] = str;
        this.f14227k++;
        return str;
    }

    public final int g(int i10, int i11) {
        int i12 = i10 + (i10 >>> 15);
        int i13 = this.f14220c;
        int i14 = i13 ^ ((i11 * 33) + (i12 ^ (i12 >>> 9)));
        int i15 = i14 + (i14 >>> 16);
        int i16 = i15 ^ (i15 >>> 4);
        return i16 + (i16 << 3);
    }

    public final int h(int i10, int i11, int i12) {
        int i13 = this.f14220c ^ i10;
        int i14 = (((i13 + (i13 >>> 9)) * 31) + i11) * 33;
        int i15 = (i14 + (i14 >>> 15)) ^ i12;
        int i16 = i15 + (i15 >>> 4);
        int i17 = i16 + (i16 >>> 15);
        return i17 ^ (i17 << 9);
    }

    public final int i(int[] iArr, int i10) {
        if (i10 < 4) {
            throw new IllegalArgumentException();
        }
        int i11 = this.f14220c ^ iArr[0];
        int i12 = i11 + (i11 >>> 9) + iArr[1];
        int i13 = ((i12 + (i12 >>> 15)) * 33) ^ iArr[2];
        int i14 = i13 + (i13 >>> 4);
        for (int i15 = 3; i15 < i10; i15++) {
            int i16 = iArr[i15];
            i14 += i16 ^ (i16 >> 21);
        }
        int i17 = i14 * 65599;
        int i18 = i17 + (i17 >>> 19);
        return i18 ^ (i18 << 5);
    }

    public final String j(int i10) {
        int i11 = this.f14220c ^ i10;
        int i12 = i11 + (i11 >>> 16);
        int i13 = i12 ^ (i12 << 3);
        int iA = a(i13 + (i13 >>> 12));
        int[] iArr = this.f14223f;
        int i14 = iArr[iA + 3];
        if (i14 == 1) {
            if (iArr[iA] == i10) {
                return this.f14228l[iA >> 2];
            }
        } else if (i14 == 0) {
            return null;
        }
        int i15 = this.h + ((iA >> 3) << 2);
        int i16 = iArr[i15 + 3];
        if (i16 == 1) {
            if (iArr[i15] == i10) {
                return this.f14228l[i15 >> 2];
            }
        } else if (i16 == 0) {
            return null;
        }
        int i17 = this.f14225i;
        int i18 = this.f14226j;
        int i19 = i17 + ((iA >> (i18 + 2)) << i18);
        int i20 = (1 << i18) + i19;
        while (i19 < i20) {
            int i21 = iArr[i19 + 3];
            if (i10 == iArr[i19] && 1 == i21) {
                return this.f14228l[i19 >> 2];
            }
            if (i21 == 0) {
                return null;
            }
            i19 += 4;
        }
        for (int iD = d(); iD < this.f14229m; iD += 4) {
            if (i10 == iArr[iD] && 1 == iArr[iD + 3]) {
                return this.f14228l[iD >> 2];
            }
        }
        return null;
    }

    public final String k(int i10, int i11) {
        int iA = a(g(i10, i11));
        int[] iArr = this.f14223f;
        int i12 = iArr[iA + 3];
        if (i12 == 2) {
            if (i10 == iArr[iA] && i11 == iArr[iA + 1]) {
                return this.f14228l[iA >> 2];
            }
        } else if (i12 == 0) {
            return null;
        }
        int i13 = this.h + ((iA >> 3) << 2);
        int i14 = iArr[i13 + 3];
        if (i14 == 2) {
            if (i10 == iArr[i13] && i11 == iArr[i13 + 1]) {
                return this.f14228l[i13 >> 2];
            }
        } else if (i14 == 0) {
            return null;
        }
        int i15 = this.f14225i;
        int i16 = this.f14226j;
        int i17 = i15 + ((iA >> (i16 + 2)) << i16);
        int i18 = (1 << i16) + i17;
        while (true) {
            if (i17 < i18) {
                int i19 = iArr[i17 + 3];
                if (i10 == iArr[i17] && i11 == iArr[i17 + 1] && 2 == i19) {
                    return this.f14228l[i17 >> 2];
                }
                if (i19 == 0) {
                    break;
                }
                i17 += 4;
            } else {
                for (int iD = d(); iD < this.f14229m; iD += 4) {
                    if (i10 == iArr[iD] && i11 == iArr[iD + 1] && 2 == iArr[iD + 3]) {
                        return this.f14228l[iD >> 2];
                    }
                }
            }
        }
        return null;
    }

    public final String l(int i10, int i11, int i12) {
        int iA = a(h(i10, i11, i12));
        int[] iArr = this.f14223f;
        int i13 = iArr[iA + 3];
        if (i13 == 3) {
            if (i10 == iArr[iA] && iArr[iA + 1] == i11 && iArr[iA + 2] == i12) {
                return this.f14228l[iA >> 2];
            }
        } else if (i13 == 0) {
            return null;
        }
        int i14 = this.h + ((iA >> 3) << 2);
        int i15 = iArr[i14 + 3];
        if (i15 == 3) {
            if (i10 == iArr[i14] && iArr[i14 + 1] == i11 && iArr[i14 + 2] == i12) {
                return this.f14228l[i14 >> 2];
            }
        } else if (i15 == 0) {
            return null;
        }
        int i16 = this.f14225i;
        int i17 = this.f14226j;
        int i18 = i16 + ((iA >> (i17 + 2)) << i17);
        int i19 = (1 << i17) + i18;
        while (true) {
            if (i18 < i19) {
                int i20 = iArr[i18 + 3];
                if (i10 == iArr[i18] && i11 == iArr[i18 + 1] && i12 == iArr[i18 + 2] && 3 == i20) {
                    return this.f14228l[i18 >> 2];
                }
                if (i20 == 0) {
                    break;
                }
                i18 += 4;
            } else {
                for (int iD = d(); iD < this.f14229m; iD += 4) {
                    if (i10 == iArr[iD] && i11 == iArr[iD + 1] && i12 == iArr[iD + 2] && 3 == iArr[iD + 3]) {
                        return this.f14228l[iD >> 2];
                    }
                }
            }
        }
        return null;
    }

    public final String m(int[] iArr, int i10) {
        if (i10 < 4) {
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? "" : l(iArr[0], iArr[1], iArr[2]) : k(iArr[0], iArr[1]) : j(iArr[0]);
        }
        int i11 = i(iArr, i10);
        int iA = a(i11);
        int[] iArr2 = this.f14223f;
        int i12 = iArr2[iA + 3];
        if (i11 == iArr2[iA] && i12 == i10 && e(i10, iArr2[iA + 1], iArr)) {
            return this.f14228l[iA >> 2];
        }
        if (i12 == 0) {
            return null;
        }
        int i13 = this.h + ((iA >> 3) << 2);
        int i14 = iArr2[i13 + 3];
        if (i11 == iArr2[i13] && i14 == i10 && e(i10, iArr2[i13 + 1], iArr)) {
            return this.f14228l[i13 >> 2];
        }
        int i15 = this.f14225i;
        int i16 = this.f14226j;
        int i17 = i15 + ((iA >> (i16 + 2)) << i16);
        int[] iArr3 = this.f14223f;
        int i18 = (1 << i16) + i17;
        while (i17 < i18) {
            int i19 = iArr3[i17 + 3];
            if (i11 == iArr3[i17] && i10 == i19 && e(i10, iArr3[i17 + 1], iArr)) {
                return this.f14228l[i17 >> 2];
            }
            if (i19 == 0) {
                return null;
            }
            i17 += 4;
        }
        for (int iD = d(); iD < this.f14229m; iD += 4) {
            if (i11 == iArr3[iD] && i10 == iArr3[iD + 3] && e(i10, iArr3[iD + 1], iArr)) {
                return this.f14228l[iD >> 2];
            }
        }
        return null;
    }

    public final void n(boolean z) {
        this.f14227k = 0;
        this.f14229m = d();
        this.f14230n = this.f14224g << 3;
        if (z) {
            Arrays.fill(this.f14223f, 0);
            Arrays.fill(this.f14228l, (Object) null);
        }
    }

    public final String toString() {
        int i10 = this.h;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 3; i13 < i10; i13 += 4) {
            if (this.f14223f[i13] != 0) {
                i12++;
            }
        }
        int i14 = this.f14225i;
        int i15 = 0;
        for (int i16 = this.h + 3; i16 < i14; i16 += 4) {
            if (this.f14223f[i16] != 0) {
                i15++;
            }
        }
        int i17 = this.f14225i + 3;
        int i18 = this.f14224g + i17;
        int i19 = 0;
        while (i17 < i18) {
            if (this.f14223f[i17] != 0) {
                i19++;
            }
            i17 += 4;
        }
        int iD = (this.f14229m - d()) >> 2;
        int i20 = this.f14224g << 3;
        for (int i21 = 3; i21 < i20; i21 += 4) {
            if (this.f14223f[i21] != 0) {
                i11++;
            }
        }
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", a.class.getName(), Integer.valueOf(this.f14227k), Integer.valueOf(this.f14224g), Integer.valueOf(i12), Integer.valueOf(i15), Integer.valueOf(i19), Integer.valueOf(iD), Integer.valueOf(i12 + i15 + i19 + iD), Integer.valueOf(i11));
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: z2.a$a, reason: collision with other inner class name */
    public static final class C0179a {

        /* renamed from: a, reason: collision with root package name */
        public final int f14232a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14233b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14234c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f14235d;

        /* renamed from: e, reason: collision with root package name */
        public final String[] f14236e;

        /* renamed from: f, reason: collision with root package name */
        public final int f14237f;

        /* renamed from: g, reason: collision with root package name */
        public final int f14238g;

        public C0179a(int i10, int i11, int[] iArr, String[] strArr, int i12, int i13) {
            this.f14232a = i10;
            this.f14233b = 0;
            this.f14234c = i11;
            this.f14235d = iArr;
            this.f14236e = strArr;
            this.f14237f = i12;
            this.f14238g = i13;
        }

        public C0179a(a aVar) {
            this.f14232a = aVar.f14224g;
            this.f14233b = aVar.f14227k;
            this.f14234c = aVar.f14226j;
            this.f14235d = aVar.f14223f;
            this.f14236e = aVar.f14228l;
            this.f14237f = aVar.f14229m;
            this.f14238g = aVar.f14230n;
        }
    }

    public a(a aVar, boolean z, int i10, boolean z3, C0179a c0179a) {
        this.f14218a = aVar;
        this.f14220c = i10;
        this.f14221d = z;
        this.f14222e = z3;
        this.f14219b = null;
        this.f14227k = c0179a.f14233b;
        int i11 = c0179a.f14232a;
        this.f14224g = i11;
        int i12 = i11 << 2;
        this.h = i12;
        this.f14225i = i12 + (i12 >> 1);
        this.f14226j = c0179a.f14234c;
        this.f14223f = c0179a.f14235d;
        this.f14228l = c0179a.f14236e;
        this.f14229m = c0179a.f14237f;
        this.f14230n = c0179a.f14238g;
        this.f14231o = true;
    }
}
