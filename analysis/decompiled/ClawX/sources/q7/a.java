package q7;

import org.bouncycastle.asn1.BERTags;
import p7.d0;
import p7.h;
import p7.q;
import p7.r;
import s7.a0;
import s7.b0;
import s7.c0;
import s7.e;
import s7.e0;
import s7.f;
import s7.f0;
import s7.g;
import s7.g0;
import s7.h0;
import s7.i;
import s7.i0;
import s7.j;
import s7.j0;
import s7.k;
import s7.k0;
import s7.l;
import s7.l0;
import s7.m;
import s7.m0;
import s7.n;
import s7.n0;
import s7.o;
import s7.o0;
import s7.p;
import s7.p0;
import s7.q0;
import s7.r0;
import s7.s;
import s7.s0;
import s7.t;
import s7.t0;
import s7.u;
import s7.u0;
import s7.v;
import s7.v0;
import s7.w;
import s7.x;
import s7.y;
import s7.z;

/* loaded from: classes.dex */
public final class a extends d0 {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4889e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4890f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4891g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ h f4892h;

    public /* synthetic */ a(h hVar, int i8, Object obj, int i9) {
        this.f4889e = i9;
        this.f4890f = i8;
        this.f4891g = obj;
        this.f4892h = hVar;
    }

    @Override // p7.d0
    public final int f() {
        switch (this.f4889e) {
        }
        return this.f4890f;
    }

    @Override // p7.d0
    public final r k(int i8) {
        switch (this.f4889e) {
            case 0:
                int[] iArr = new int[8];
                int[] iArr2 = new int[8];
                int i9 = 0;
                for (int i10 = 0; i10 < this.f4890f; i10++) {
                    int i11 = ((i10 ^ i8) - 1) >> 31;
                    for (int i12 = 0; i12 < 8; i12++) {
                        int i13 = iArr[i12];
                        int[] iArr3 = (int[]) this.f4891g;
                        iArr[i12] = i13 ^ (iArr3[i9 + i12] & i11);
                        iArr2[i12] = iArr2[i12] ^ (iArr3[(i9 + 8) + i12] & i11);
                    }
                    i9 += 16;
                }
                return new q((b) this.f4892h, new d(iArr), new d(iArr2), b.f4896m, 1);
            case 1:
                int[] iArr4 = new int[8];
                int[] iArr5 = new int[8];
                int i14 = 0;
                for (int i15 = 0; i15 < this.f4890f; i15++) {
                    int i16 = ((i15 ^ i8) - 1) >> 31;
                    for (int i17 = 0; i17 < 8; i17++) {
                        int i18 = iArr4[i17];
                        int[] iArr6 = (int[]) this.f4891g;
                        iArr4[i17] = i18 ^ (iArr6[i14 + i17] & i16);
                        iArr5[i17] = iArr5[i17] ^ (iArr6[(i14 + 8) + i17] & i16);
                    }
                    i14 += 16;
                }
                return new q((r7.a) this.f4892h, new r7.c(iArr4), new r7.c(iArr5), r7.a.f5222k, 2);
            case 2:
                int[] iArr7 = new int[4];
                int[] iArr8 = new int[4];
                int i19 = 0;
                for (int i20 = 0; i20 < this.f4890f; i20++) {
                    int i21 = ((i20 ^ i8) - 1) >> 31;
                    for (int i22 = 0; i22 < 4; i22++) {
                        int i23 = iArr7[i22];
                        int[] iArr9 = (int[]) this.f4891g;
                        iArr7[i22] = i23 ^ (iArr9[i19 + i22] & i21);
                        iArr8[i22] = iArr8[i22] ^ (iArr9[(i19 + 4) + i22] & i21);
                    }
                    i19 += 8;
                }
                return new q((s7.a) this.f4892h, new s7.c(iArr7), new s7.c(iArr8), s7.a.f5256k, 3);
            case 3:
                int[] iArr10 = new int[5];
                int[] iArr11 = new int[5];
                int i24 = 0;
                for (int i25 = 0; i25 < this.f4890f; i25++) {
                    int i26 = ((i25 ^ i8) - 1) >> 31;
                    for (int i27 = 0; i27 < 5; i27++) {
                        int i28 = iArr10[i27];
                        int[] iArr12 = (int[]) this.f4891g;
                        iArr10[i27] = i28 ^ (iArr12[i24 + i27] & i26);
                        iArr11[i27] = iArr11[i27] ^ (iArr12[(i24 + 5) + i27] & i26);
                    }
                    i24 += 10;
                }
                return new q((s7.d) this.f4892h, new s7.h(iArr10), new s7.h(iArr11), s7.d.f5289k, 4);
            case 4:
                int[] iArr13 = new int[5];
                int[] iArr14 = new int[5];
                int i29 = 0;
                for (int i30 = 0; i30 < this.f4890f; i30++) {
                    int i31 = ((i30 ^ i8) - 1) >> 31;
                    for (int i32 = 0; i32 < 5; i32++) {
                        int i33 = iArr13[i32];
                        int[] iArr15 = (int[]) this.f4891g;
                        iArr13[i32] = i33 ^ (iArr15[i29 + i32] & i31);
                        iArr14[i32] = iArr14[i32] ^ (iArr15[(i29 + 5) + i32] & i31);
                    }
                    i29 += 10;
                }
                return new q((e) this.f4892h, new f(iArr13), new f(iArr14), e.f5294k, 5);
            case 5:
                int[] iArr16 = new int[5];
                int[] iArr17 = new int[5];
                int i34 = 0;
                for (int i35 = 0; i35 < this.f4890f; i35++) {
                    int i36 = ((i35 ^ i8) - 1) >> 31;
                    for (int i37 = 0; i37 < 5; i37++) {
                        int i38 = iArr16[i37];
                        int[] iArr18 = (int[]) this.f4891g;
                        iArr16[i37] = i38 ^ (iArr18[i34 + i37] & i36);
                        iArr17[i37] = iArr17[i37] ^ (iArr18[(i34 + 5) + i37] & i36);
                    }
                    i34 += 10;
                }
                return new q((g) this.f4892h, new s7.h(iArr16), new s7.h(iArr17), g.f5302k, 6);
            case 6:
                int[] iArr19 = new int[6];
                int[] iArr20 = new int[6];
                int i39 = 0;
                for (int i40 = 0; i40 < this.f4890f; i40++) {
                    int i41 = ((i40 ^ i8) - 1) >> 31;
                    for (int i42 = 0; i42 < 6; i42++) {
                        int i43 = iArr19[i42];
                        int[] iArr21 = (int[]) this.f4891g;
                        iArr19[i42] = i43 ^ (iArr21[i39 + i42] & i41);
                        iArr20[i42] = iArr20[i42] ^ (iArr21[(i39 + 6) + i42] & i41);
                    }
                    i39 += 12;
                }
                return new q((i) this.f4892h, new j(iArr19), new j(iArr20), i.f5311k, 7);
            case 7:
                int[] iArr22 = new int[6];
                int[] iArr23 = new int[6];
                int i44 = 0;
                for (int i45 = 0; i45 < this.f4890f; i45++) {
                    int i46 = ((i45 ^ i8) - 1) >> 31;
                    for (int i47 = 0; i47 < 6; i47++) {
                        int i48 = iArr22[i47];
                        int[] iArr24 = (int[]) this.f4891g;
                        iArr22[i47] = i48 ^ (iArr24[i44 + i47] & i46);
                        iArr23[i47] = iArr23[i47] ^ (iArr24[(i44 + 6) + i47] & i46);
                    }
                    i44 += 12;
                }
                return new q((k) this.f4892h, new l(iArr22), new l(iArr23), k.f5319k, 8);
            case 8:
                int[] iArr25 = new int[7];
                int[] iArr26 = new int[7];
                int i49 = 0;
                for (int i50 = 0; i50 < this.f4890f; i50++) {
                    int i51 = ((i50 ^ i8) - 1) >> 31;
                    for (int i52 = 0; i52 < 7; i52++) {
                        int i53 = iArr25[i52];
                        int[] iArr27 = (int[]) this.f4891g;
                        iArr25[i52] = i53 ^ (iArr27[i49 + i52] & i51);
                        iArr26[i52] = iArr26[i52] ^ (iArr27[(i49 + 7) + i52] & i51);
                    }
                    i49 += 14;
                }
                return new q((m) this.f4892h, new n(iArr25), new n(iArr26), m.f5327k, 9);
            case 9:
                int[] iArr28 = new int[7];
                int[] iArr29 = new int[7];
                int i54 = 0;
                for (int i55 = 0; i55 < this.f4890f; i55++) {
                    int i56 = ((i55 ^ i8) - 1) >> 31;
                    for (int i57 = 0; i57 < 7; i57++) {
                        int i58 = iArr28[i57];
                        int[] iArr30 = (int[]) this.f4891g;
                        iArr28[i57] = i58 ^ (iArr30[i54 + i57] & i56);
                        iArr29[i57] = iArr29[i57] ^ (iArr30[(i54 + 7) + i57] & i56);
                    }
                    i54 += 14;
                }
                return new q((o) this.f4892h, new p(iArr28), new p(iArr29), o.f5337k, 10);
            case 10:
                int[] iArr31 = new int[8];
                int[] iArr32 = new int[8];
                int i59 = 0;
                for (int i60 = 0; i60 < this.f4890f; i60++) {
                    int i61 = ((i60 ^ i8) - 1) >> 31;
                    for (int i62 = 0; i62 < 8; i62++) {
                        int i63 = iArr31[i62];
                        int[] iArr33 = (int[]) this.f4891g;
                        iArr31[i62] = i63 ^ (iArr33[i59 + i62] & i61);
                        iArr32[i62] = iArr32[i62] ^ (iArr33[(i59 + 8) + i62] & i61);
                    }
                    i59 += 16;
                }
                return new q((s7.q) this.f4892h, new s7.r(iArr31), new s7.r(iArr32), s7.q.f5345k, 11);
            case BERTags.EMBEDDED_PDV /* 11 */:
                int[] iArr34 = new int[8];
                int[] iArr35 = new int[8];
                int i64 = 0;
                for (int i65 = 0; i65 < this.f4890f; i65++) {
                    int i66 = ((i65 ^ i8) - 1) >> 31;
                    for (int i67 = 0; i67 < 8; i67++) {
                        int i68 = iArr34[i67];
                        int[] iArr36 = (int[]) this.f4891g;
                        iArr34[i67] = i68 ^ (iArr36[i64 + i67] & i66);
                        iArr35[i67] = iArr35[i67] ^ (iArr36[(i64 + 8) + i67] & i66);
                    }
                    i64 += 16;
                }
                return new q((s) this.f4892h, new t(iArr34), new t(iArr35), s.f5353k, 12);
            case 12:
                int[] iArr37 = new int[12];
                int[] iArr38 = new int[12];
                int i69 = 0;
                for (int i70 = 0; i70 < this.f4890f; i70++) {
                    int i71 = ((i70 ^ i8) - 1) >> 31;
                    for (int i72 = 0; i72 < 12; i72++) {
                        int i73 = iArr37[i72];
                        int[] iArr39 = (int[]) this.f4891g;
                        iArr37[i72] = i73 ^ (iArr39[i69 + i72] & i71);
                        iArr38[i72] = iArr38[i72] ^ (iArr39[(i69 + 12) + i72] & i71);
                    }
                    i69 += 24;
                }
                return new q((u) this.f4892h, new v(iArr37), new v(iArr38), u.f5361k, 13);
            case BERTags.RELATIVE_OID /* 13 */:
                int[] iArr40 = new int[17];
                int[] iArr41 = new int[17];
                int i74 = 0;
                for (int i75 = 0; i75 < this.f4890f; i75++) {
                    int i76 = ((i75 ^ i8) - 1) >> 31;
                    for (int i77 = 0; i77 < 17; i77++) {
                        int i78 = iArr40[i77];
                        int[] iArr42 = (int[]) this.f4891g;
                        iArr40[i77] = i78 ^ (iArr42[i74 + i77] & i76);
                        iArr41[i77] = iArr41[i77] ^ (iArr42[(i74 + 17) + i77] & i76);
                    }
                    i74 += 34;
                }
                return new q((w) this.f4892h, new x(iArr40), new x(iArr41), w.f5370k, 14);
            case BERTags.TIME /* 14 */:
                long[] jArr = new long[2];
                long[] jArr2 = new long[2];
                int i79 = 0;
                for (int i80 = 0; i80 < this.f4890f; i80++) {
                    long j4 = ((i80 ^ i8) - 1) >> 31;
                    for (int i81 = 0; i81 < 2; i81++) {
                        long j8 = jArr[i81];
                        long[] jArr3 = (long[]) this.f4891g;
                        jArr[i81] = j8 ^ (jArr3[i79 + i81] & j4);
                        jArr2[i81] = jArr2[i81] ^ (jArr3[(i79 + 2) + i81] & j4);
                    }
                    i79 += 4;
                }
                return new p7.p((z) this.f4892h, new y(jArr), new y(jArr2), z.f5382k, 1);
            case 15:
                long[] jArr4 = new long[2];
                long[] jArr5 = new long[2];
                int i82 = 0;
                for (int i83 = 0; i83 < this.f4890f; i83++) {
                    long j9 = ((i83 ^ i8) - 1) >> 31;
                    for (int i84 = 0; i84 < 2; i84++) {
                        long j10 = jArr4[i84];
                        long[] jArr6 = (long[]) this.f4891g;
                        jArr4[i84] = j10 ^ (jArr6[i82 + i84] & j9);
                        jArr5[i84] = jArr5[i84] ^ (jArr6[(i82 + 2) + i84] & j9);
                    }
                    i82 += 4;
                }
                return new p7.p((a0) this.f4892h, new y(jArr4), new y(jArr5), a0.f5258k, 2);
            case 16:
                long[] jArr7 = new long[3];
                long[] jArr8 = new long[3];
                int i85 = 0;
                for (int i86 = 0; i86 < this.f4890f; i86++) {
                    long j11 = ((i86 ^ i8) - 1) >> 31;
                    for (int i87 = 0; i87 < 3; i87++) {
                        long j12 = jArr7[i87];
                        long[] jArr9 = (long[]) this.f4891g;
                        jArr7[i87] = j12 ^ (jArr9[i85 + i87] & j11);
                        jArr8[i87] = jArr8[i87] ^ (jArr9[(i85 + 3) + i87] & j11);
                    }
                    i85 += 6;
                }
                return new p7.p((c0) this.f4892h, new b0(jArr7), new b0(jArr8), c0.f5286k, 3);
            case 17:
                long[] jArr10 = new long[3];
                long[] jArr11 = new long[3];
                int i88 = 0;
                for (int i89 = 0; i89 < this.f4890f; i89++) {
                    long j13 = ((i89 ^ i8) - 1) >> 31;
                    for (int i90 = 0; i90 < 3; i90++) {
                        long j14 = jArr10[i90];
                        long[] jArr12 = (long[]) this.f4891g;
                        jArr10[i90] = j14 ^ (jArr12[i88 + i90] & j13);
                        jArr11[i90] = jArr11[i90] ^ (jArr12[(i88 + 3) + i90] & j13);
                    }
                    i88 += 6;
                }
                return new p7.p((s7.d0) this.f4892h, new b0(jArr10), new b0(jArr11), s7.d0.f5291k, 4);
            case BERTags.NUMERIC_STRING /* 18 */:
                long[] jArr13 = new long[3];
                long[] jArr14 = new long[3];
                int i91 = 0;
                for (int i92 = 0; i92 < this.f4890f; i92++) {
                    long j15 = ((i92 ^ i8) - 1) >> 31;
                    for (int i93 = 0; i93 < 3; i93++) {
                        long j16 = jArr13[i93];
                        long[] jArr15 = (long[]) this.f4891g;
                        jArr13[i93] = j16 ^ (jArr15[i91 + i93] & j15);
                        jArr14[i93] = jArr14[i93] ^ (jArr15[(i91 + 3) + i93] & j15);
                    }
                    i91 += 6;
                }
                return new p7.p((f0) this.f4892h, new e0(jArr13), new e0(jArr14), f0.f5299k, 5);
            case 19:
                long[] jArr16 = new long[3];
                long[] jArr17 = new long[3];
                int i94 = 0;
                for (int i95 = 0; i95 < this.f4890f; i95++) {
                    long j17 = ((i95 ^ i8) - 1) >> 31;
                    for (int i96 = 0; i96 < 3; i96++) {
                        long j18 = jArr16[i96];
                        long[] jArr18 = (long[]) this.f4891g;
                        jArr16[i96] = j18 ^ (jArr18[i94 + i96] & j17);
                        jArr17[i96] = jArr17[i96] ^ (jArr18[(i94 + 3) + i96] & j17);
                    }
                    i94 += 6;
                }
                return new p7.p((g0) this.f4892h, new e0(jArr16), new e0(jArr17), g0.f5304k, 6);
            case 20:
                long[] jArr19 = new long[3];
                long[] jArr20 = new long[3];
                int i97 = 0;
                for (int i98 = 0; i98 < this.f4890f; i98++) {
                    long j19 = ((i98 ^ i8) - 1) >> 31;
                    for (int i99 = 0; i99 < 3; i99++) {
                        long j20 = jArr19[i99];
                        long[] jArr21 = (long[]) this.f4891g;
                        jArr19[i99] = j20 ^ (jArr21[i97 + i99] & j19);
                        jArr20[i99] = jArr20[i99] ^ (jArr21[(i97 + 3) + i99] & j19);
                    }
                    i97 += 6;
                }
                return new p7.p((h0) this.f4892h, new e0(jArr19), new e0(jArr20), h0.f5308k, 7);
            case BERTags.VIDEOTEX_STRING /* 21 */:
                long[] jArr22 = new long[4];
                long[] jArr23 = new long[4];
                int i100 = 0;
                for (int i101 = 0; i101 < this.f4890f; i101++) {
                    long j21 = ((i101 ^ i8) - 1) >> 31;
                    for (int i102 = 0; i102 < 4; i102++) {
                        long j22 = jArr22[i102];
                        long[] jArr24 = (long[]) this.f4891g;
                        jArr22[i102] = j22 ^ (jArr24[i100 + i102] & j21);
                        jArr23[i102] = jArr23[i102] ^ (jArr24[(i100 + 4) + i102] & j21);
                    }
                    i100 += 8;
                }
                return new p7.p((j0) this.f4892h, new i0(jArr22), new i0(jArr23), j0.f5316k, 8);
            case BERTags.IA5_STRING /* 22 */:
                long[] jArr25 = new long[4];
                long[] jArr26 = new long[4];
                int i103 = 0;
                for (int i104 = 0; i104 < this.f4890f; i104++) {
                    long j23 = ((i104 ^ i8) - 1) >> 31;
                    for (int i105 = 0; i105 < 4; i105++) {
                        long j24 = jArr25[i105];
                        long[] jArr27 = (long[]) this.f4891g;
                        jArr25[i105] = j24 ^ (jArr27[i103 + i105] & j23);
                        jArr26[i105] = jArr26[i105] ^ (jArr27[(i103 + 4) + i105] & j23);
                    }
                    i103 += 8;
                }
                return new p7.p((k0) this.f4892h, new i0(jArr25), new i0(jArr26), k0.f5321k, 9);
            case BERTags.UTC_TIME /* 23 */:
                long[] jArr28 = new long[4];
                long[] jArr29 = new long[4];
                int i106 = 0;
                for (int i107 = 0; i107 < this.f4890f; i107++) {
                    long j25 = ((i107 ^ i8) - 1) >> 31;
                    for (int i108 = 0; i108 < 4; i108++) {
                        long j26 = jArr28[i108];
                        long[] jArr30 = (long[]) this.f4891g;
                        jArr28[i108] = j26 ^ (jArr30[i106 + i108] & j25);
                        jArr29[i108] = jArr29[i108] ^ (jArr30[(i106 + 4) + i108] & j25);
                    }
                    i106 += 8;
                }
                return new p7.p((m0) this.f4892h, new l0(jArr28), new l0(jArr29), m0.f5329k, 10);
            case 24:
                long[] jArr31 = new long[4];
                long[] jArr32 = new long[4];
                int i109 = 0;
                for (int i110 = 0; i110 < this.f4890f; i110++) {
                    long j27 = ((i110 ^ i8) - 1) >> 31;
                    for (int i111 = 0; i111 < 4; i111++) {
                        long j28 = jArr31[i111];
                        long[] jArr33 = (long[]) this.f4891g;
                        jArr31[i111] = j28 ^ (jArr33[i109 + i111] & j27);
                        jArr32[i111] = jArr32[i111] ^ (jArr33[(i109 + 4) + i111] & j27);
                    }
                    i109 += 8;
                }
                return new p7.p((n0) this.f4892h, new l0(jArr31), new l0(jArr32), n0.f5334k, 11);
            case BERTags.GRAPHIC_STRING /* 25 */:
                long[] jArr34 = new long[4];
                long[] jArr35 = new long[4];
                int i112 = 0;
                for (int i113 = 0; i113 < this.f4890f; i113++) {
                    long j29 = ((i113 ^ i8) - 1) >> 31;
                    for (int i114 = 0; i114 < 4; i114++) {
                        long j30 = jArr34[i114];
                        long[] jArr36 = (long[]) this.f4891g;
                        jArr34[i114] = j30 ^ (jArr36[i112 + i114] & j29);
                        jArr35[i114] = jArr35[i114] ^ (jArr36[(i112 + 4) + i114] & j29);
                    }
                    i112 += 8;
                }
                return new p7.p((p0) this.f4892h, new o0(jArr34), new o0(jArr35), p0.f5342k, 12);
            case BERTags.VISIBLE_STRING /* 26 */:
                long[] jArr37 = new long[5];
                long[] jArr38 = new long[5];
                int i115 = 0;
                for (int i116 = 0; i116 < this.f4890f; i116++) {
                    long j31 = ((i116 ^ i8) - 1) >> 31;
                    for (int i117 = 0; i117 < 5; i117++) {
                        long j32 = jArr37[i117];
                        long[] jArr39 = (long[]) this.f4891g;
                        jArr37[i117] = j32 ^ (jArr39[i115 + i117] & j31);
                        jArr38[i117] = jArr38[i117] ^ (jArr39[(i115 + 5) + i117] & j31);
                    }
                    i115 += 10;
                }
                return new p7.p((r0) this.f4892h, new q0(jArr37), new q0(jArr38), r0.f5350k, 13);
            case BERTags.GENERAL_STRING /* 27 */:
                long[] jArr40 = new long[5];
                long[] jArr41 = new long[5];
                int i118 = 0;
                for (int i119 = 0; i119 < this.f4890f; i119++) {
                    long j33 = ((i119 ^ i8) - 1) >> 31;
                    for (int i120 = 0; i120 < 5; i120++) {
                        long j34 = jArr40[i120];
                        long[] jArr42 = (long[]) this.f4891g;
                        jArr40[i120] = j34 ^ (jArr42[i118 + i120] & j33);
                        jArr41[i120] = jArr41[i120] ^ (jArr42[(i118 + 5) + i120] & j33);
                    }
                    i118 += 10;
                }
                return new p7.p((s0) this.f4892h, new q0(jArr40), new q0(jArr41), s0.f5355k, 14);
            case BERTags.UNIVERSAL_STRING /* 28 */:
                long[] jArr43 = new long[7];
                long[] jArr44 = new long[7];
                int i121 = 0;
                for (int i122 = 0; i122 < this.f4890f; i122++) {
                    long j35 = ((i122 ^ i8) - 1) >> 31;
                    for (int i123 = 0; i123 < 7; i123++) {
                        long j36 = jArr43[i123];
                        long[] jArr45 = (long[]) this.f4891g;
                        jArr43[i123] = j36 ^ (jArr45[i121 + i123] & j35);
                        jArr44[i123] = jArr44[i123] ^ (jArr45[(i121 + 7) + i123] & j35);
                    }
                    i121 += 14;
                }
                return new p7.p((u0) this.f4892h, new t0(jArr43), new t0(jArr44), u0.f5363k, 15);
            default:
                long[] jArr46 = new long[7];
                long[] jArr47 = new long[7];
                int i124 = 0;
                for (int i125 = 0; i125 < this.f4890f; i125++) {
                    long j37 = ((i125 ^ i8) - 1) >> 31;
                    for (int i126 = 0; i126 < 7; i126++) {
                        long j38 = jArr46[i126];
                        long[] jArr48 = (long[]) this.f4891g;
                        jArr46[i126] = j38 ^ (jArr48[i124 + i126] & j37);
                        jArr47[i126] = jArr47[i126] ^ (jArr48[(i124 + 7) + i126] & j37);
                    }
                    i124 += 14;
                }
                return new p7.p((v0) this.f4892h, new t0(jArr46), new t0(jArr47), v0.f5367k, 16);
        }
    }

    @Override // p7.d0
    public final r l(int i8) {
        switch (this.f4889e) {
            case 0:
                int[] iArr = new int[8];
                int[] iArr2 = new int[8];
                int i9 = i8 * 16;
                for (int i10 = 0; i10 < 8; i10++) {
                    int[] iArr3 = (int[]) this.f4891g;
                    iArr[i10] = iArr3[i9 + i10];
                    iArr2[i10] = iArr3[i9 + 8 + i10];
                }
                return new q((b) this.f4892h, new d(iArr), new d(iArr2), b.f4896m, 1);
            case 1:
                int[] iArr4 = new int[8];
                int[] iArr5 = new int[8];
                int i11 = i8 * 16;
                for (int i12 = 0; i12 < 8; i12++) {
                    int[] iArr6 = (int[]) this.f4891g;
                    iArr4[i12] = iArr6[i11 + i12];
                    iArr5[i12] = iArr6[i11 + 8 + i12];
                }
                return new q((r7.a) this.f4892h, new r7.c(iArr4), new r7.c(iArr5), r7.a.f5222k, 2);
            case 2:
                int[] iArr7 = new int[4];
                int[] iArr8 = new int[4];
                int i13 = i8 * 8;
                for (int i14 = 0; i14 < 4; i14++) {
                    int[] iArr9 = (int[]) this.f4891g;
                    iArr7[i14] = iArr9[i13 + i14];
                    iArr8[i14] = iArr9[i13 + 4 + i14];
                }
                return new q((s7.a) this.f4892h, new s7.c(iArr7), new s7.c(iArr8), s7.a.f5256k, 3);
            case 3:
                int[] iArr10 = new int[5];
                int[] iArr11 = new int[5];
                int i15 = i8 * 10;
                for (int i16 = 0; i16 < 5; i16++) {
                    int[] iArr12 = (int[]) this.f4891g;
                    iArr10[i16] = iArr12[i15 + i16];
                    iArr11[i16] = iArr12[i15 + 5 + i16];
                }
                return new q((s7.d) this.f4892h, new s7.h(iArr10), new s7.h(iArr11), s7.d.f5289k, 4);
            case 4:
                int[] iArr13 = new int[5];
                int[] iArr14 = new int[5];
                int i17 = i8 * 10;
                for (int i18 = 0; i18 < 5; i18++) {
                    int[] iArr15 = (int[]) this.f4891g;
                    iArr13[i18] = iArr15[i17 + i18];
                    iArr14[i18] = iArr15[i17 + 5 + i18];
                }
                return new q((e) this.f4892h, new f(iArr13), new f(iArr14), e.f5294k, 5);
            case 5:
                int[] iArr16 = new int[5];
                int[] iArr17 = new int[5];
                int i19 = i8 * 10;
                for (int i20 = 0; i20 < 5; i20++) {
                    int[] iArr18 = (int[]) this.f4891g;
                    iArr16[i20] = iArr18[i19 + i20];
                    iArr17[i20] = iArr18[i19 + 5 + i20];
                }
                return new q((g) this.f4892h, new s7.h(iArr16), new s7.h(iArr17), g.f5302k, 6);
            case 6:
                int[] iArr19 = new int[6];
                int[] iArr20 = new int[6];
                int i21 = i8 * 12;
                for (int i22 = 0; i22 < 6; i22++) {
                    int[] iArr21 = (int[]) this.f4891g;
                    iArr19[i22] = iArr21[i21 + i22];
                    iArr20[i22] = iArr21[i21 + 6 + i22];
                }
                return new q((i) this.f4892h, new j(iArr19), new j(iArr20), i.f5311k, 7);
            case 7:
                int[] iArr22 = new int[6];
                int[] iArr23 = new int[6];
                int i23 = i8 * 12;
                for (int i24 = 0; i24 < 6; i24++) {
                    int[] iArr24 = (int[]) this.f4891g;
                    iArr22[i24] = iArr24[i23 + i24];
                    iArr23[i24] = iArr24[i23 + 6 + i24];
                }
                return new q((k) this.f4892h, new l(iArr22), new l(iArr23), k.f5319k, 8);
            case 8:
                int[] iArr25 = new int[7];
                int[] iArr26 = new int[7];
                int i25 = 0;
                for (int i26 = 0; i26 < this.f4890f; i26++) {
                    int i27 = ((i26 ^ i8) - 1) >> 31;
                    for (int i28 = 0; i28 < 7; i28++) {
                        int i29 = iArr25[i28];
                        int[] iArr27 = (int[]) this.f4891g;
                        iArr25[i28] = i29 ^ (iArr27[i25 + i28] & i27);
                        iArr26[i28] = iArr26[i28] ^ (iArr27[(i25 + 7) + i28] & i27);
                    }
                    i25 += 14;
                }
                return new q((m) this.f4892h, new n(iArr25), new n(iArr26), m.f5327k, 9);
            case 9:
                int[] iArr28 = new int[7];
                int[] iArr29 = new int[7];
                int i30 = i8 * 14;
                for (int i31 = 0; i31 < 7; i31++) {
                    int[] iArr30 = (int[]) this.f4891g;
                    iArr28[i31] = iArr30[i30 + i31];
                    iArr29[i31] = iArr30[i30 + 7 + i31];
                }
                return new q((o) this.f4892h, new p(iArr28), new p(iArr29), o.f5337k, 10);
            case 10:
                int[] iArr31 = new int[8];
                int[] iArr32 = new int[8];
                int i32 = i8 * 16;
                for (int i33 = 0; i33 < 8; i33++) {
                    int[] iArr33 = (int[]) this.f4891g;
                    iArr31[i33] = iArr33[i32 + i33];
                    iArr32[i33] = iArr33[i32 + 8 + i33];
                }
                return new q((s7.q) this.f4892h, new s7.r(iArr31), new s7.r(iArr32), s7.q.f5345k, 11);
            case BERTags.EMBEDDED_PDV /* 11 */:
                int[] iArr34 = new int[8];
                int[] iArr35 = new int[8];
                int i34 = i8 * 16;
                for (int i35 = 0; i35 < 8; i35++) {
                    int[] iArr36 = (int[]) this.f4891g;
                    iArr34[i35] = iArr36[i34 + i35];
                    iArr35[i35] = iArr36[i34 + 8 + i35];
                }
                return new q((s) this.f4892h, new t(iArr34), new t(iArr35), s.f5353k, 12);
            case 12:
                int[] iArr37 = new int[12];
                int[] iArr38 = new int[12];
                int i36 = i8 * 24;
                for (int i37 = 0; i37 < 12; i37++) {
                    int[] iArr39 = (int[]) this.f4891g;
                    iArr37[i37] = iArr39[i36 + i37];
                    iArr38[i37] = iArr39[i36 + 12 + i37];
                }
                return new q((u) this.f4892h, new v(iArr37), new v(iArr38), u.f5361k, 13);
            case BERTags.RELATIVE_OID /* 13 */:
                int[] iArr40 = new int[17];
                int[] iArr41 = new int[17];
                int i38 = i8 * 34;
                for (int i39 = 0; i39 < 17; i39++) {
                    int i40 = iArr40[i39];
                    int[] iArr42 = (int[]) this.f4891g;
                    iArr40[i39] = i40 ^ iArr42[i38 + i39];
                    iArr41[i39] = iArr41[i39] ^ iArr42[(i38 + 17) + i39];
                }
                return new q((w) this.f4892h, new x(iArr40), new x(iArr41), w.f5370k, 14);
            case BERTags.TIME /* 14 */:
                long[] jArr = new long[2];
                long[] jArr2 = new long[2];
                int i41 = i8 * 4;
                for (int i42 = 0; i42 < 2; i42++) {
                    long[] jArr3 = (long[]) this.f4891g;
                    jArr[i42] = jArr3[i41 + i42];
                    jArr2[i42] = jArr3[i41 + 2 + i42];
                }
                return new p7.p((z) this.f4892h, new y(jArr), new y(jArr2), z.f5382k, 1);
            case 15:
                long[] jArr4 = new long[2];
                long[] jArr5 = new long[2];
                int i43 = i8 * 4;
                for (int i44 = 0; i44 < 2; i44++) {
                    long[] jArr6 = (long[]) this.f4891g;
                    jArr4[i44] = jArr6[i43 + i44];
                    jArr5[i44] = jArr6[i43 + 2 + i44];
                }
                return new p7.p((a0) this.f4892h, new y(jArr4), new y(jArr5), a0.f5258k, 2);
            case 16:
                long[] jArr7 = new long[3];
                long[] jArr8 = new long[3];
                int i45 = i8 * 6;
                for (int i46 = 0; i46 < 3; i46++) {
                    long[] jArr9 = (long[]) this.f4891g;
                    jArr7[i46] = jArr9[i45 + i46];
                    jArr8[i46] = jArr9[i45 + 3 + i46];
                }
                return new p7.p((c0) this.f4892h, new b0(jArr7), new b0(jArr8), c0.f5286k, 3);
            case 17:
                long[] jArr10 = new long[3];
                long[] jArr11 = new long[3];
                int i47 = i8 * 6;
                for (int i48 = 0; i48 < 3; i48++) {
                    long[] jArr12 = (long[]) this.f4891g;
                    jArr10[i48] = jArr12[i47 + i48];
                    jArr11[i48] = jArr12[i47 + 3 + i48];
                }
                return new p7.p((s7.d0) this.f4892h, new b0(jArr10), new b0(jArr11), s7.d0.f5291k, 4);
            case BERTags.NUMERIC_STRING /* 18 */:
                long[] jArr13 = new long[3];
                long[] jArr14 = new long[3];
                int i49 = i8 * 6;
                for (int i50 = 0; i50 < 3; i50++) {
                    long[] jArr15 = (long[]) this.f4891g;
                    jArr13[i50] = jArr15[i49 + i50];
                    jArr14[i50] = jArr15[i49 + 3 + i50];
                }
                return new p7.p((f0) this.f4892h, new e0(jArr13), new e0(jArr14), f0.f5299k, 5);
            case 19:
                long[] jArr16 = new long[3];
                long[] jArr17 = new long[3];
                int i51 = i8 * 6;
                for (int i52 = 0; i52 < 3; i52++) {
                    long[] jArr18 = (long[]) this.f4891g;
                    jArr16[i52] = jArr18[i51 + i52];
                    jArr17[i52] = jArr18[i51 + 3 + i52];
                }
                return new p7.p((g0) this.f4892h, new e0(jArr16), new e0(jArr17), g0.f5304k, 6);
            case 20:
                long[] jArr19 = new long[3];
                long[] jArr20 = new long[3];
                int i53 = i8 * 6;
                for (int i54 = 0; i54 < 3; i54++) {
                    long[] jArr21 = (long[]) this.f4891g;
                    jArr19[i54] = jArr21[i53 + i54];
                    jArr20[i54] = jArr21[i53 + 3 + i54];
                }
                return new p7.p((h0) this.f4892h, new e0(jArr19), new e0(jArr20), h0.f5308k, 7);
            case BERTags.VIDEOTEX_STRING /* 21 */:
                long[] jArr22 = new long[4];
                long[] jArr23 = new long[4];
                int i55 = i8 * 8;
                for (int i56 = 0; i56 < 4; i56++) {
                    long[] jArr24 = (long[]) this.f4891g;
                    jArr22[i56] = jArr24[i55 + i56];
                    jArr23[i56] = jArr24[i55 + 4 + i56];
                }
                return new p7.p((j0) this.f4892h, new i0(jArr22), new i0(jArr23), j0.f5316k, 8);
            case BERTags.IA5_STRING /* 22 */:
                long[] jArr25 = new long[4];
                long[] jArr26 = new long[4];
                int i57 = i8 * 8;
                for (int i58 = 0; i58 < 4; i58++) {
                    long j4 = jArr25[i58];
                    long[] jArr27 = (long[]) this.f4891g;
                    jArr25[i58] = j4 ^ jArr27[i57 + i58];
                    jArr26[i58] = jArr26[i58] ^ jArr27[(i57 + 4) + i58];
                }
                return new p7.p((k0) this.f4892h, new i0(jArr25), new i0(jArr26), k0.f5321k, 9);
            case BERTags.UTC_TIME /* 23 */:
                long[] jArr28 = new long[4];
                long[] jArr29 = new long[4];
                int i59 = i8 * 8;
                for (int i60 = 0; i60 < 4; i60++) {
                    long[] jArr30 = (long[]) this.f4891g;
                    jArr28[i60] = jArr30[i59 + i60];
                    jArr29[i60] = jArr30[i59 + 4 + i60];
                }
                return new p7.p((m0) this.f4892h, new l0(jArr28), new l0(jArr29), m0.f5329k, 10);
            case 24:
                long[] jArr31 = new long[4];
                long[] jArr32 = new long[4];
                int i61 = i8 * 8;
                for (int i62 = 0; i62 < 4; i62++) {
                    long[] jArr33 = (long[]) this.f4891g;
                    jArr31[i62] = jArr33[i61 + i62];
                    jArr32[i62] = jArr33[i61 + 4 + i62];
                }
                return new p7.p((n0) this.f4892h, new l0(jArr31), new l0(jArr32), n0.f5334k, 11);
            case BERTags.GRAPHIC_STRING /* 25 */:
                long[] jArr34 = new long[4];
                long[] jArr35 = new long[4];
                int i63 = i8 * 8;
                for (int i64 = 0; i64 < 4; i64++) {
                    long[] jArr36 = (long[]) this.f4891g;
                    jArr34[i64] = jArr36[i63 + i64];
                    jArr35[i64] = jArr36[i63 + 4 + i64];
                }
                return new p7.p((p0) this.f4892h, new o0(jArr34), new o0(jArr35), p0.f5342k, 12);
            case BERTags.VISIBLE_STRING /* 26 */:
                long[] jArr37 = new long[5];
                long[] jArr38 = new long[5];
                int i65 = i8 * 10;
                for (int i66 = 0; i66 < 5; i66++) {
                    long[] jArr39 = (long[]) this.f4891g;
                    jArr37[i66] = jArr39[i65 + i66];
                    jArr38[i66] = jArr39[i65 + 5 + i66];
                }
                return new p7.p((r0) this.f4892h, new q0(jArr37), new q0(jArr38), r0.f5350k, 13);
            case BERTags.GENERAL_STRING /* 27 */:
                long[] jArr40 = new long[5];
                long[] jArr41 = new long[5];
                int i67 = i8 * 10;
                for (int i68 = 0; i68 < 5; i68++) {
                    long[] jArr42 = (long[]) this.f4891g;
                    jArr40[i68] = jArr42[i67 + i68];
                    jArr41[i68] = jArr42[i67 + 5 + i68];
                }
                return new p7.p((s0) this.f4892h, new q0(jArr40), new q0(jArr41), s0.f5355k, 14);
            case BERTags.UNIVERSAL_STRING /* 28 */:
                long[] jArr43 = new long[7];
                long[] jArr44 = new long[7];
                int i69 = i8 * 14;
                for (int i70 = 0; i70 < 7; i70++) {
                    long[] jArr45 = (long[]) this.f4891g;
                    jArr43[i70] = jArr45[i69 + i70];
                    jArr44[i70] = jArr45[i69 + 7 + i70];
                }
                return new p7.p((u0) this.f4892h, new t0(jArr43), new t0(jArr44), u0.f5363k, 15);
            default:
                long[] jArr46 = new long[7];
                long[] jArr47 = new long[7];
                int i71 = i8 * 14;
                for (int i72 = 0; i72 < 7; i72++) {
                    long[] jArr48 = (long[]) this.f4891g;
                    jArr46[i72] = jArr48[i71 + i72];
                    jArr47[i72] = jArr48[i71 + 7 + i72];
                }
                return new p7.p((v0) this.f4892h, new t0(jArr46), new t0(jArr47), v0.f5367k, 16);
        }
    }
}
