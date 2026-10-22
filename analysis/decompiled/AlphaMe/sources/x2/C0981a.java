package x2;

import com.stepos.alphame.utils.Property;
import v2.C0954a;
import y2.C0991a;
import y2.g;

/* renamed from: x2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0981a {

    /* renamed from: h, reason: collision with root package name */
    public float f15908h;

    /* renamed from: j, reason: collision with root package name */
    public final float f15910j;

    /* renamed from: k, reason: collision with root package name */
    public final float f15911k;

    /* renamed from: n, reason: collision with root package name */
    public final float f15914n;

    /* renamed from: o, reason: collision with root package name */
    public final g f15915o;

    /* renamed from: a, reason: collision with root package name */
    public final g f15901a = new g();

    /* renamed from: b, reason: collision with root package name */
    public final g f15902b = new g(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, -1.0f);

    /* renamed from: c, reason: collision with root package name */
    public final g f15903c = new g(Property.DEFAULT_FLOAT_VALUE, 1.0f, Property.DEFAULT_FLOAT_VALUE);

    /* renamed from: d, reason: collision with root package name */
    public final y2.c f15904d = new y2.c();

    /* renamed from: e, reason: collision with root package name */
    public final y2.c f15905e = new y2.c();

    /* renamed from: f, reason: collision with root package name */
    public final y2.c f15906f = new y2.c();

    /* renamed from: g, reason: collision with root package name */
    public final y2.c f15907g = new y2.c();

    /* renamed from: i, reason: collision with root package name */
    public float f15909i = 100.0f;

    /* renamed from: l, reason: collision with root package name */
    public final C0991a f15912l = new C0991a();

    /* renamed from: m, reason: collision with root package name */
    public final g f15913m = new g();

    public C0981a(float f4, float f5) {
        this.f15908h = 1.0f;
        this.f15910j = Property.DEFAULT_FLOAT_VALUE;
        this.f15911k = Property.DEFAULT_FLOAT_VALUE;
        new C0954a(new g(), new g());
        this.f15914n = 1.0f;
        this.f15915o = new g();
        this.f15910j = f4;
        this.f15911k = f5;
        this.f15908h = Property.DEFAULT_FLOAT_VALUE;
        b();
    }

    public final void a(g gVar) {
        float f4 = gVar.f16346a;
        float f5 = gVar.f16347b;
        float f6 = gVar.f16348c;
        g gVar2 = this.f15913m;
        gVar2.c(f4, f5, f6);
        gVar2.e(this.f15901a);
        gVar2.b();
        float f7 = gVar2.f16346a;
        if (f7 == Property.DEFAULT_FLOAT_VALUE && gVar2.f16347b == Property.DEFAULT_FLOAT_VALUE && gVar2.f16348c == Property.DEFAULT_FLOAT_VALUE) {
            return;
        }
        g gVar3 = this.f15903c;
        float f8 = (gVar2.f16348c * gVar3.f16348c) + (gVar2.f16347b * gVar3.f16347b) + (f7 * gVar3.f16346a);
        float fAbs = Math.abs(f8 - 1.0f);
        g gVar4 = this.f15902b;
        if (fAbs < 1.0E-9f) {
            gVar3.d(gVar4);
            gVar3.c(gVar3.f16346a * (-1.0f), gVar3.f16347b * (-1.0f), gVar3.f16348c * (-1.0f));
        } else if (Math.abs(f8 + 1.0f) < 1.0E-9f) {
            gVar3.d(gVar4);
        }
        gVar4.d(gVar2);
        gVar2.d(gVar4);
        gVar2.a(gVar3);
        gVar3.d(gVar2);
        gVar3.a(gVar4);
        gVar3.b();
    }

    public final void b() {
        float f4 = this.f15910j;
        float f5 = this.f15914n;
        float f6 = ((-f4) * f5) / 2.0f;
        float f7 = (f4 / 2.0f) * f5;
        float f8 = this.f15911k;
        float f9 = (-(f8 / 2.0f)) * f5;
        float f10 = (f5 * f8) / 2.0f;
        float f11 = this.f15908h;
        float f12 = this.f15909i;
        float f13 = f7 - f6;
        float f14 = f10 - f9;
        float f15 = f12 - f11;
        float f16 = (-(f7 + f6)) / f13;
        float f17 = (-(f10 + f9)) / f14;
        float f18 = (-(f12 + f11)) / f15;
        y2.c cVar = this.f15904d;
        float[] fArr = cVar.f16337a;
        fArr[0] = 2.0f / f13;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 2.0f / f14;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = (-2.0f) / f15;
        fArr[11] = 0.0f;
        fArr[12] = f16;
        fArr[13] = f17;
        fArr[14] = f18;
        fArr[15] = 1.0f;
        g gVar = this.f15915o;
        g gVar2 = this.f15901a;
        gVar.d(gVar2);
        g gVar3 = this.f15902b;
        gVar.c(gVar.f16346a + gVar3.f16346a, gVar.f16347b + gVar3.f16347b, gVar.f16348c + gVar3.f16348c);
        y2.c cVar2 = this.f15905e;
        cVar2.getClass();
        g gVar4 = y2.c.f16335e;
        gVar4.d(gVar);
        gVar4.e(gVar2);
        g gVar5 = y2.c.f16332b;
        gVar5.d(gVar4);
        gVar5.b();
        g gVar6 = y2.c.f16333c;
        gVar6.getClass();
        gVar6.c(gVar4.f16346a, gVar4.f16347b, gVar4.f16348c);
        gVar6.a(this.f15903c);
        gVar6.b();
        g gVar7 = y2.c.f16334d;
        gVar7.d(gVar6);
        gVar7.a(gVar5);
        gVar7.b();
        cVar2.a();
        float f19 = gVar6.f16346a;
        float[] fArr2 = cVar2.f16337a;
        fArr2[0] = f19;
        fArr2[4] = gVar6.f16347b;
        fArr2[8] = gVar6.f16348c;
        fArr2[1] = gVar7.f16346a;
        fArr2[5] = gVar7.f16347b;
        fArr2[9] = gVar7.f16348c;
        fArr2[2] = -gVar5.f16346a;
        fArr2[6] = -gVar5.f16347b;
        fArr2[10] = -gVar5.f16348c;
        float f20 = -gVar2.f16346a;
        float f21 = -gVar2.f16347b;
        float f22 = -gVar2.f16348c;
        y2.c cVar3 = y2.c.f16336f;
        cVar3.a();
        float[] fArr3 = cVar3.f16337a;
        fArr3[12] = f20;
        fArr3[13] = f21;
        fArr3[14] = f22;
        y2.c.b(fArr2, fArr3);
        y2.c cVar4 = this.f15906f;
        cVar4.getClass();
        float[] fArr4 = cVar4.f16337a;
        System.arraycopy(cVar.f16337a, 0, fArr4, 0, fArr4.length);
        y2.c.b(fArr4, fArr2);
        y2.c cVar5 = this.f15907g;
        cVar5.getClass();
        float[] fArr5 = cVar5.f16337a;
        System.arraycopy(fArr4, 0, fArr5, 0, fArr5.length);
        float f23 = fArr5[3];
        float f24 = fArr5[6];
        float f25 = f23 * f24;
        float f26 = fArr5[9];
        float f27 = fArr5[12];
        float f28 = fArr5[2];
        float f29 = fArr5[7];
        float f30 = f28 * f29;
        float f31 = fArr5[5];
        float f32 = f23 * f31;
        float f33 = fArr5[10];
        float f34 = fArr5[1];
        float f35 = f34 * f29;
        float f36 = f28 * f31;
        float f37 = fArr5[11];
        float f38 = f36 * f37;
        float f39 = (f38 * f27) + (f35 * f33 * f27) + ((((f25 * f26) * f27) - ((f30 * f26) * f27)) - ((f32 * f33) * f27));
        float f40 = f34 * f24;
        float f41 = f40 * f37;
        float f42 = fArr5[8];
        float f43 = fArr5[13];
        float f44 = (f30 * f42 * f43) + ((f39 - (f41 * f27)) - ((f25 * f42) * f43));
        float f45 = fArr5[4];
        float f46 = f23 * f45;
        float f47 = (f46 * f33 * f43) + f44;
        float f48 = fArr5[0];
        float f49 = f48 * f29;
        float f50 = f28 * f45;
        float f51 = f50 * f37;
        float f52 = f48 * f24;
        float f53 = f52 * f37;
        float f54 = (f53 * f43) + ((f47 - ((f49 * f33) * f43)) - (f51 * f43));
        float f55 = fArr5[14];
        float f56 = (f49 * f26 * f55) + (((((f32 * f42) * f55) + f54) - ((f35 * f42) * f55)) - ((f46 * f26) * f55));
        float f57 = f34 * f45;
        float f58 = f57 * f37;
        float f59 = (f58 * f55) + f56;
        float f60 = f48 * f31;
        float f61 = f60 * f37;
        float f62 = fArr5[15];
        float f63 = f57 * f33;
        float f64 = f60 * f33;
        float f65 = (f64 * f62) + (((((f50 * f26) * f62) + (((f40 * f42) * f62) + ((f59 - (f61 * f55)) - ((f36 * f42) * f62)))) - ((f52 * f26) * f62)) - (f63 * f62));
        if (f65 != Property.DEFAULT_FLOAT_VALUE) {
            float f66 = f26 * f55;
            float f67 = f43 * f33;
            float f68 = f43 * f24;
            float f69 = f31 * f55;
            float f70 = f26 * f24;
            float f71 = f31 * f33;
            float f72 = (f71 * f62) + ((((f68 * f37) + ((f66 * f29) - (f67 * f29))) - (f69 * f37)) - (f70 * f62));
            float f73 = f27 * f33;
            float f74 = f42 * f55;
            float f75 = f27 * f24;
            float f76 = f45 * f55;
            float f77 = f42 * f24;
            float f78 = (f77 * f62) + (f76 * f37) + (((f73 * f29) - (f74 * f29)) - (f75 * f37));
            float f79 = f45 * f33;
            float f80 = f78 - (f79 * f62);
            float f81 = f42 * f43;
            float f82 = f27 * f26;
            float f83 = f27 * f31;
            float f84 = f45 * f43;
            float f85 = f31 * f42;
            float f86 = f45 * f26;
            float f87 = (f86 * f62) + ((((f83 * f37) + ((f81 * f29) - (f82 * f29))) - (f84 * f37)) - (f85 * f62));
            float f88 = ((f85 * f55) + ((f84 * f33) + (((f82 * f24) - (f81 * f24)) - (f83 * f33)))) - (f86 * f55);
            float f89 = (f67 * f23) - (f66 * f23);
            float f90 = f43 * f28;
            float f91 = f34 * f55;
            float f92 = (f91 * f37) + (f89 - (f90 * f37));
            float f93 = f26 * f28;
            float f94 = (f93 * f62) + f92;
            float f95 = f34 * f33;
            float f96 = f94 - (f95 * f62);
            float f97 = (f74 * f23) - (f73 * f23);
            float f98 = f27 * f28;
            float f99 = (f98 * f37) + f97;
            float f100 = f48 * f55;
            float f101 = f42 * f28;
            float f102 = f48 * f33;
            float f103 = (f102 * f62) + ((f99 - (f100 * f37)) - (f101 * f62));
            float f104 = f27 * f34;
            float f105 = f43 * f48;
            float f106 = f42 * f34;
            float f107 = f48 * f26;
            float f108 = ((f106 * f62) + ((f37 * f105) + (((f82 * f23) - (f81 * f23)) - (f104 * f37)))) - (f107 * f62);
            float f109 = (f107 * f55) + ((((f104 * f33) + ((f81 * f28) - (f82 * f28))) - (f33 * f105)) - (f106 * f55));
            float f110 = (f40 * f62) + ((((f90 * f29) + ((f69 * f23) - (f68 * f23))) - (f91 * f29)) - (f36 * f62));
            float f111 = ((f50 * f62) + ((f100 * f29) + (((f75 * f23) - (f76 * f23)) - (f98 * f29)))) - (f52 * f62);
            float f112 = (f62 * f60) + ((((f104 * f29) + ((f84 * f23) - (f83 * f23))) - (f105 * f29)) - (f57 * f62));
            float f113 = ((f57 * f55) + ((f105 * f24) + (((f83 * f28) - (f84 * f28)) - (f104 * f24)))) - (f60 * f55);
            float f114 = (((f95 * f29) + (((f70 * f23) - (f71 * f23)) - (f93 * f29))) + f38) - f41;
            float f115 = ((((f101 * f29) + ((f79 * f23) - (f77 * f23))) - (f102 * f29)) - f51) + f53;
            float f116 = (((f29 * f107) + (((f85 * f23) - (f23 * f86)) - (f106 * f29))) + f58) - f61;
            float f117 = ((((f106 * f24) + ((f86 * f28) - (f85 * f28))) - (f107 * f24)) - f63) + f64;
            float f118 = 1.0f / f65;
            fArr5[0] = f72 * f118;
            fArr5[1] = f96 * f118;
            fArr5[2] = f110 * f118;
            fArr5[3] = f114 * f118;
            fArr5[4] = f80 * f118;
            fArr5[5] = f103 * f118;
            fArr5[6] = f111 * f118;
            fArr5[7] = f115 * f118;
            fArr5[8] = f87 * f118;
            fArr5[9] = f108 * f118;
            fArr5[10] = f112 * f118;
            fArr5[11] = f116 * f118;
            fArr5[12] = f88 * f118;
            fArr5[13] = f109 * f118;
            fArr5[14] = f113 * f118;
            fArr5[15] = f117 * f118;
        }
        C0991a c0991a = this.f15912l;
        c0991a.getClass();
        float[] fArr6 = C0991a.f16327d;
        int length = fArr6.length;
        float[] fArr7 = c0991a.f16330c;
        System.arraycopy(fArr6, 0, fArr7, 0, length);
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = i4 + 1;
            int i7 = i4 + 2;
            float f119 = fArr7[i4];
            float f120 = fArr5[3] * f119;
            float f121 = fArr7[i6];
            float f122 = (fArr5[7] * f121) + f120;
            float f123 = fArr7[i7];
            float f124 = 1.0f / (((fArr5[11] * f123) + f122) + fArr5[15]);
            float f125 = ((fArr5[8] * f123) + (fArr5[4] * f121) + (fArr5[0] * f119) + fArr5[12]) * f124;
            float f126 = ((fArr5[9] * f123) + (fArr5[5] * f121) + (fArr5[1] * f119) + fArr5[13]) * f124;
            float f127 = ((f123 * fArr5[10]) + (f121 * fArr5[6]) + (f119 * fArr5[2]) + fArr5[14]) * f124;
            fArr7[i4] = f125;
            fArr7[i6] = f126;
            fArr7[i7] = f127;
            i4 += 3;
        }
        int i8 = 0;
        int i9 = 0;
        while (true) {
            g[] gVarArr = c0991a.f16329b;
            if (i8 >= 8) {
                y2.d[] dVarArr = c0991a.f16328a;
                dVarArr[0].a(gVarArr[1], gVarArr[0], gVarArr[2]);
                dVarArr[1].a(gVarArr[4], gVarArr[5], gVarArr[7]);
                dVarArr[2].a(gVarArr[0], gVarArr[4], gVarArr[3]);
                dVarArr[3].a(gVarArr[5], gVarArr[1], gVarArr[6]);
                dVarArr[4].a(gVarArr[2], gVarArr[3], gVarArr[6]);
                dVarArr[5].a(gVarArr[4], gVarArr[0], gVarArr[1]);
                return;
            }
            g gVar8 = gVarArr[i8];
            gVar8.f16346a = fArr7[i9];
            int i10 = i9 + 2;
            gVar8.f16347b = fArr7[i9 + 1];
            i9 += 3;
            gVar8.f16348c = fArr7[i10];
            i8++;
        }
    }
}
