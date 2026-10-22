package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.n0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1743n0 implements Z1 {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1739m0 f20115a;

    public C1743n0(AbstractC1739m0 abstractC1739m0) {
        Charset charset = N0.f20038a;
        this.f20115a = abstractC1739m0;
        abstractC1739m0.f20114a = this;
    }

    public static C1743n0 L(AbstractC1739m0 abstractC1739m0) {
        C1743n0 c1743n0 = abstractC1739m0.f20114a;
        return c1743n0 != null ? c1743n0 : new C1743n0(abstractC1739m0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void A(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof G0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f20115a.n(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int iB = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iB += AbstractC1739m0.b(((Integer) list.get(i12)).intValue());
            }
            this.f20115a.w(iB);
            while (i11 < list.size()) {
                this.f20115a.o(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        G0 g02 = (G0) list;
        if (!z10) {
            while (i11 < g02.size()) {
                this.f20115a.n(i10, g02.c(i11));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int iB2 = 0;
        for (int i13 = 0; i13 < g02.size(); i13++) {
            iB2 += AbstractC1739m0.b(g02.c(i13));
        }
        this.f20115a.w(iB2);
        while (i11 < g02.size()) {
            this.f20115a.o(g02.c(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void B(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof G0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    AbstractC1739m0 abstractC1739m0 = this.f20115a;
                    int iIntValue = ((Integer) list.get(i11)).intValue();
                    abstractC1739m0.v(i10, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int iA = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                int iIntValue2 = ((Integer) list.get(i12)).intValue();
                iA += AbstractC1739m0.a((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.f20115a.w(iA);
            while (i11 < list.size()) {
                AbstractC1739m0 abstractC1739m02 = this.f20115a;
                int iIntValue3 = ((Integer) list.get(i11)).intValue();
                abstractC1739m02.w((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i11++;
            }
            return;
        }
        G0 g02 = (G0) list;
        if (!z10) {
            while (i11 < g02.size()) {
                AbstractC1739m0 abstractC1739m03 = this.f20115a;
                int iC = g02.c(i11);
                abstractC1739m03.v(i10, (iC >> 31) ^ (iC + iC));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int iA2 = 0;
        for (int i13 = 0; i13 < g02.size(); i13++) {
            int iC2 = g02.c(i13);
            iA2 += AbstractC1739m0.a((iC2 >> 31) ^ (iC2 + iC2));
        }
        this.f20115a.w(iA2);
        while (i11 < g02.size()) {
            AbstractC1739m0 abstractC1739m04 = this.f20115a;
            int iC3 = g02.c(i11);
            abstractC1739m04.w((iC3 >> 31) ^ (iC3 + iC3));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void C(int i10, Object obj, InterfaceC1791z1 interfaceC1791z1) throws IOException {
        AbstractC1739m0 abstractC1739m0 = this.f20115a;
        abstractC1739m0.u(i10, 3);
        interfaceC1791z1.b((InterfaceC1720h1) obj, abstractC1739m0.f20114a);
        abstractC1739m0.u(i10, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void D(int i10, float f10) throws IOException {
        this.f20115a.j(i10, Float.floatToRawIntBits(f10));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void E(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof X0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f20115a.x(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int iB = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iB += AbstractC1739m0.b(((Long) list.get(i12)).longValue());
            }
            this.f20115a.w(iB);
            while (i11 < list.size()) {
                this.f20115a.y(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        X0 x02 = (X0) list;
        if (!z10) {
            while (i11 < x02.size()) {
                this.f20115a.x(i10, x02.c(i11));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int iB2 = 0;
        for (int i13 = 0; i13 < x02.size(); i13++) {
            iB2 += AbstractC1739m0.b(x02.c(i13));
        }
        this.f20115a.w(iB2);
        while (i11 < x02.size()) {
            this.f20115a.y(x02.c(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void F(int i10, Object obj) throws IOException {
        boolean z10 = obj instanceof zzdf;
        AbstractC1739m0 abstractC1739m0 = this.f20115a;
        if (z10) {
            abstractC1739m0.s(i10, (zzdf) obj);
        } else {
            abstractC1739m0.r(i10, (InterfaceC1720h1) obj);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void G(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof X0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    AbstractC1739m0 abstractC1739m0 = this.f20115a;
                    long jLongValue = ((Long) list.get(i11)).longValue();
                    abstractC1739m0.x(i10, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int iB = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                long jLongValue2 = ((Long) list.get(i12)).longValue();
                iB += AbstractC1739m0.b((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.f20115a.w(iB);
            while (i11 < list.size()) {
                AbstractC1739m0 abstractC1739m02 = this.f20115a;
                long jLongValue3 = ((Long) list.get(i11)).longValue();
                abstractC1739m02.y((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i11++;
            }
            return;
        }
        X0 x02 = (X0) list;
        if (!z10) {
            while (i11 < x02.size()) {
                AbstractC1739m0 abstractC1739m03 = this.f20115a;
                long jC = x02.c(i11);
                abstractC1739m03.x(i10, (jC >> 63) ^ (jC + jC));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int iB2 = 0;
        for (int i13 = 0; i13 < x02.size(); i13++) {
            long jC2 = x02.c(i13);
            iB2 += AbstractC1739m0.b((jC2 >> 63) ^ (jC2 + jC2));
        }
        this.f20115a.w(iB2);
        while (i11 < x02.size()) {
            AbstractC1739m0 abstractC1739m04 = this.f20115a;
            long jC3 = x02.c(i11);
            abstractC1739m04.y((jC3 >> 63) ^ (jC3 + jC3));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void H(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof C1747o0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f20115a.l(i10, Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Double) list.get(i13)).getClass();
                i12 += 8;
            }
            this.f20115a.w(i12);
            while (i11 < list.size()) {
                this.f20115a.m(Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                i11++;
            }
            return;
        }
        C1747o0 c1747o0 = (C1747o0) list;
        if (!z10) {
            while (i11 < c1747o0.size()) {
                this.f20115a.l(i10, Double.doubleToRawLongBits(c1747o0.c(i11)));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < c1747o0.size(); i15++) {
            c1747o0.c(i15);
            i14 += 8;
        }
        this.f20115a.w(i14);
        while (i11 < c1747o0.size()) {
            this.f20115a.m(Double.doubleToRawLongBits(c1747o0.c(i11)));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void I(int i10, long j10) throws IOException {
        this.f20115a.l(i10, j10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void J(int i10, List list) throws IOException {
        int i11 = 0;
        if (!(list instanceof T0)) {
            while (i11 < list.size()) {
                this.f20115a.t(i10, (String) list.get(i11));
                i11++;
            }
            return;
        }
        T0 t02 = (T0) list;
        while (i11 < list.size()) {
            Object objZza = t02.zza();
            if (objZza instanceof String) {
                this.f20115a.t(i10, (String) objZza);
            } else {
                this.f20115a.i(i10, (zzdf) objZza);
            }
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void K(int i10, long j10) throws IOException {
        this.f20115a.x(i10, j10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void a(int i10, List list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f20115a.i(i10, (zzdf) list.get(i11));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void b(int i10, String str) throws IOException {
        this.f20115a.t(i10, str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void c(int i10, boolean z10) throws IOException {
        this.f20115a.h(i10, z10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void d(int i10, Object obj, InterfaceC1791z1 interfaceC1791z1) throws IOException {
        this.f20115a.q(i10, (InterfaceC1720h1) obj, interfaceC1791z1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void e(int i10, long j10) throws IOException {
        this.f20115a.x(i10, j10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void f(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof Z)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f20115a.h(i10, ((Boolean) list.get(i11)).booleanValue());
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Boolean) list.get(i13)).getClass();
                i12++;
            }
            this.f20115a.w(i12);
            while (i11 < list.size()) {
                this.f20115a.g(((Boolean) list.get(i11)).booleanValue() ? (byte) 1 : (byte) 0);
                i11++;
            }
            return;
        }
        Z z11 = (Z) list;
        if (!z10) {
            while (i11 < z11.size()) {
                this.f20115a.h(i10, z11.e(i11));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < z11.size(); i15++) {
            z11.e(i15);
            i14++;
        }
        this.f20115a.w(i14);
        while (i11 < z11.size()) {
            this.f20115a.g(z11.e(i11) ? (byte) 1 : (byte) 0);
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void g(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof X0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f20115a.l(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).getClass();
                i12 += 8;
            }
            this.f20115a.w(i12);
            while (i11 < list.size()) {
                this.f20115a.m(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        X0 x02 = (X0) list;
        if (!z10) {
            while (i11 < x02.size()) {
                this.f20115a.l(i10, x02.c(i11));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < x02.size(); i15++) {
            x02.c(i15);
            i14 += 8;
        }
        this.f20115a.w(i14);
        while (i11 < x02.size()) {
            this.f20115a.m(x02.c(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void h(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof G0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f20115a.n(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int iB = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iB += AbstractC1739m0.b(((Integer) list.get(i12)).intValue());
            }
            this.f20115a.w(iB);
            while (i11 < list.size()) {
                this.f20115a.o(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        G0 g02 = (G0) list;
        if (!z10) {
            while (i11 < g02.size()) {
                this.f20115a.n(i10, g02.c(i11));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int iB2 = 0;
        for (int i13 = 0; i13 < g02.size(); i13++) {
            iB2 += AbstractC1739m0.b(g02.c(i13));
        }
        this.f20115a.w(iB2);
        while (i11 < g02.size()) {
            this.f20115a.o(g02.c(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void i(int i10, int i11) throws IOException {
        this.f20115a.n(i10, i11);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void j(int i10, zzdf zzdfVar) throws IOException {
        this.f20115a.i(i10, zzdfVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void k(int i10, double d10) throws IOException {
        this.f20115a.l(i10, Double.doubleToRawLongBits(d10));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void l(int i10, long j10) throws IOException {
        AbstractC1739m0 abstractC1739m0 = this.f20115a;
        abstractC1739m0.x(i10, (j10 >> 63) ^ (j10 + j10));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void m(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof X0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f20115a.x(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int iB = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iB += AbstractC1739m0.b(((Long) list.get(i12)).longValue());
            }
            this.f20115a.w(iB);
            while (i11 < list.size()) {
                this.f20115a.y(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        X0 x02 = (X0) list;
        if (!z10) {
            while (i11 < x02.size()) {
                this.f20115a.x(i10, x02.c(i11));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int iB2 = 0;
        for (int i13 = 0; i13 < x02.size(); i13++) {
            iB2 += AbstractC1739m0.b(x02.c(i13));
        }
        this.f20115a.w(iB2);
        while (i11 < x02.size()) {
            this.f20115a.y(x02.c(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void n(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof X0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f20115a.l(i10, ((Long) list.get(i11)).longValue());
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Long) list.get(i13)).getClass();
                i12 += 8;
            }
            this.f20115a.w(i12);
            while (i11 < list.size()) {
                this.f20115a.m(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        X0 x02 = (X0) list;
        if (!z10) {
            while (i11 < x02.size()) {
                this.f20115a.l(i10, x02.c(i11));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < x02.size(); i15++) {
            x02.c(i15);
            i14 += 8;
        }
        this.f20115a.w(i14);
        while (i11 < x02.size()) {
            this.f20115a.m(x02.c(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void o(int i10, int i11) throws IOException {
        this.f20115a.j(i10, i11);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void p(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof C1782x0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f20115a.j(i10, Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Float) list.get(i13)).getClass();
                i12 += 4;
            }
            this.f20115a.w(i12);
            while (i11 < list.size()) {
                this.f20115a.k(Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                i11++;
            }
            return;
        }
        C1782x0 c1782x0 = (C1782x0) list;
        if (!z10) {
            while (i11 < c1782x0.size()) {
                this.f20115a.j(i10, Float.floatToRawIntBits(c1782x0.c(i11)));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < c1782x0.size(); i15++) {
            c1782x0.c(i15);
            i14 += 4;
        }
        this.f20115a.w(i14);
        while (i11 < c1782x0.size()) {
            this.f20115a.k(Float.floatToRawIntBits(c1782x0.c(i11)));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void q(int i10, int i11) throws IOException {
        AbstractC1739m0 abstractC1739m0 = this.f20115a;
        abstractC1739m0.v(i10, (i11 >> 31) ^ (i11 + i11));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    @Deprecated
    public final void r(int i10) throws IOException {
        this.f20115a.u(i10, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    @Deprecated
    public final void s(int i10) throws IOException {
        this.f20115a.u(i10, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void t(int i10, int i11) throws IOException {
        this.f20115a.v(i10, i11);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void u(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof G0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f20115a.j(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).getClass();
                i12 += 4;
            }
            this.f20115a.w(i12);
            while (i11 < list.size()) {
                this.f20115a.k(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        G0 g02 = (G0) list;
        if (!z10) {
            while (i11 < g02.size()) {
                this.f20115a.j(i10, g02.c(i11));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < g02.size(); i15++) {
            g02.c(i15);
            i14 += 4;
        }
        this.f20115a.w(i14);
        while (i11 < g02.size()) {
            this.f20115a.k(g02.c(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void v(int i10, int i11) throws IOException {
        this.f20115a.j(i10, i11);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void w(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof G0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f20115a.v(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int iA = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iA += AbstractC1739m0.a(((Integer) list.get(i12)).intValue());
            }
            this.f20115a.w(iA);
            while (i11 < list.size()) {
                this.f20115a.w(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        G0 g02 = (G0) list;
        if (!z10) {
            while (i11 < g02.size()) {
                this.f20115a.v(i10, g02.c(i11));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int iA2 = 0;
        for (int i13 = 0; i13 < g02.size(); i13++) {
            iA2 += AbstractC1739m0.a(g02.c(i13));
        }
        this.f20115a.w(iA2);
        while (i11 < g02.size()) {
            this.f20115a.w(g02.c(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void x(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (!(list instanceof G0)) {
            if (!z10) {
                while (i11 < list.size()) {
                    this.f20115a.j(i10, ((Integer) list.get(i11)).intValue());
                    i11++;
                }
                return;
            }
            this.f20115a.u(i10, 2);
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                ((Integer) list.get(i13)).getClass();
                i12 += 4;
            }
            this.f20115a.w(i12);
            while (i11 < list.size()) {
                this.f20115a.k(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        G0 g02 = (G0) list;
        if (!z10) {
            while (i11 < g02.size()) {
                this.f20115a.j(i10, g02.c(i11));
                i11++;
            }
            return;
        }
        this.f20115a.u(i10, 2);
        int i14 = 0;
        for (int i15 = 0; i15 < g02.size(); i15++) {
            g02.c(i15);
            i14 += 4;
        }
        this.f20115a.w(i14);
        while (i11 < g02.size()) {
            this.f20115a.k(g02.c(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void y(int i10, long j10) throws IOException {
        this.f20115a.l(i10, j10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1
    public final void z(int i10, int i11) throws IOException {
        this.f20115a.n(i10, i11);
    }
}
