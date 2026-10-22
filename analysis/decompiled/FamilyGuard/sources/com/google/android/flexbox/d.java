package com.google.android.flexbox;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.C0467l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.flexbox.a f12092a;

    /* renamed from: b, reason: collision with root package name */
    private boolean[] f12093b;

    /* renamed from: c, reason: collision with root package name */
    int[] f12094c;

    /* renamed from: d, reason: collision with root package name */
    long[] f12095d;

    /* renamed from: e, reason: collision with root package name */
    private long[] f12096e;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        List<c> f12097a;

        /* renamed from: b, reason: collision with root package name */
        int f12098b;

        a() {
        }

        void a() {
            this.f12097a = null;
            this.f12098b = 0;
        }
    }

    d(com.google.android.flexbox.a aVar) {
        this.f12092a = aVar;
    }

    private int A(boolean z5) {
        return z5 ? this.f12092a.getPaddingEnd() : this.f12092a.getPaddingBottom();
    }

    private int B(boolean z5) {
        return z5 ? this.f12092a.getPaddingTop() : this.f12092a.getPaddingStart();
    }

    private int C(boolean z5) {
        return z5 ? this.f12092a.getPaddingStart() : this.f12092a.getPaddingTop();
    }

    private int D(View view, boolean z5) {
        return z5 ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int E(View view, boolean z5) {
        return z5 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private boolean F(int i5, int i6, c cVar) {
        return i5 == i6 - 1 && cVar.c() != 0;
    }

    private boolean G(View view, int i5, int i6, int i7, int i8, b bVar, int i9, int i10, int i11) {
        if (this.f12092a.h() == 0) {
            return false;
        }
        if (bVar.y()) {
            return true;
        }
        if (i5 == 0) {
            return false;
        }
        int iF = this.f12092a.f();
        if (iF != -1 && iF <= i11 + 1) {
            return false;
        }
        int iN = this.f12092a.n(view, i9, i10);
        if (iN > 0) {
            i8 += iN;
        }
        return i6 < i7 + i8;
    }

    private void K(int i5, int i6, c cVar, int i7, int i8, boolean z5) {
        float f5;
        float f6;
        int iMax;
        int i9 = cVar.f12080e;
        float f7 = cVar.f12086k;
        float f8 = 0.0f;
        if (f7 <= 0.0f || i7 > i9) {
            return;
        }
        float f9 = (i9 - i7) / f7;
        cVar.f12080e = i8 + cVar.f12081f;
        if (!z5) {
            cVar.f12082g = Integer.MIN_VALUE;
        }
        int i10 = 0;
        boolean z6 = false;
        int i11 = 0;
        float f10 = 0.0f;
        while (i10 < cVar.f12083h) {
            int i12 = cVar.f12090o + i10;
            View viewJ = this.f12092a.j(i12);
            if (viewJ == null || viewJ.getVisibility() == 8) {
                f5 = f8;
                f6 = f9;
                z6 = z6;
            } else {
                b bVar = (b) viewJ.getLayoutParams();
                int iE = this.f12092a.e();
                f5 = f8;
                if (iE == 0 || iE == 1) {
                    int measuredWidth = viewJ.getMeasuredWidth();
                    long[] jArr = this.f12096e;
                    if (jArr != null) {
                        measuredWidth = q(jArr[i12]);
                    }
                    int measuredHeight = viewJ.getMeasuredHeight();
                    long[] jArr2 = this.f12096e;
                    f6 = f9;
                    boolean z7 = z6;
                    if (jArr2 != null) {
                        measuredHeight = p(jArr2[i12]);
                    }
                    if (this.f12093b[i12] || bVar.h() <= f5) {
                        z6 = z7;
                    } else {
                        float fH = measuredWidth - (f6 * bVar.h());
                        if (i10 == cVar.f12083h - 1) {
                            fH += f10;
                            f10 = f5;
                        }
                        int iRound = Math.round(fH);
                        if (iRound < bVar.i()) {
                            iRound = bVar.i();
                            this.f12093b[i12] = true;
                            cVar.f12086k -= bVar.h();
                            z6 = true;
                        } else {
                            f10 += fH - iRound;
                            double d6 = f10;
                            if (d6 > 1.0d) {
                                iRound++;
                                f10 -= 1.0f;
                            } else if (d6 < -1.0d) {
                                iRound--;
                                f10 += 1.0f;
                            }
                            z6 = z7;
                        }
                        int iR = r(i6, bVar, cVar.f12088m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewJ.measure(iMakeMeasureSpec, iR);
                        int measuredWidth2 = viewJ.getMeasuredWidth();
                        int measuredHeight2 = viewJ.getMeasuredHeight();
                        P(i12, iMakeMeasureSpec, iR, viewJ);
                        this.f12092a.m(i12, viewJ);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i11, measuredHeight + bVar.n() + bVar.k() + this.f12092a.t(viewJ));
                    cVar.f12080e += measuredWidth + bVar.l() + bVar.v();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewJ.getMeasuredHeight();
                    long[] jArr3 = this.f12096e;
                    if (jArr3 != null) {
                        measuredHeight3 = p(jArr3[i12]);
                    }
                    int measuredWidth3 = viewJ.getMeasuredWidth();
                    long[] jArr4 = this.f12096e;
                    if (jArr4 != null) {
                        measuredWidth3 = q(jArr4[i12]);
                    }
                    if (!this.f12093b[i12] && bVar.h() > f5) {
                        float fH2 = measuredHeight3 - (bVar.h() * f9);
                        if (i10 == cVar.f12083h - 1) {
                            fH2 += f10;
                            f10 = f5;
                        }
                        int iRound2 = Math.round(fH2);
                        if (iRound2 < bVar.x()) {
                            iRound2 = bVar.x();
                            this.f12093b[i12] = true;
                            cVar.f12086k -= bVar.h();
                            z6 = true;
                        } else {
                            f10 += fH2 - iRound2;
                            double d7 = f10;
                            if (d7 > 1.0d) {
                                iRound2++;
                                f10 -= 1.0f;
                            } else if (d7 < -1.0d) {
                                iRound2--;
                                f10 += 1.0f;
                            }
                        }
                        int iS = s(i5, bVar, cVar.f12088m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewJ.measure(iS, iMakeMeasureSpec2);
                        int measuredWidth4 = viewJ.getMeasuredWidth();
                        int measuredHeight4 = viewJ.getMeasuredHeight();
                        P(i12, iS, iMakeMeasureSpec2, viewJ);
                        this.f12092a.m(i12, viewJ);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i11, measuredWidth3 + bVar.l() + bVar.v() + this.f12092a.t(viewJ));
                    cVar.f12080e += measuredHeight3 + bVar.n() + bVar.k();
                    f6 = f9;
                }
                cVar.f12082g = Math.max(cVar.f12082g, iMax);
                i11 = iMax;
            }
            i10++;
            f9 = f6;
            f8 = f5;
        }
        if (!z6 || i9 == cVar.f12080e) {
            return;
        }
        K(i5, i6, cVar, i7, i8, true);
    }

    private void L(View view, int i5, int i6) {
        b bVar = (b) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i5 - bVar.l()) - bVar.v()) - this.f12092a.t(view), bVar.i()), bVar.E());
        long[] jArr = this.f12096e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? p(jArr[i6]) : view.getMeasuredHeight(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        P(i6, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f12092a.m(i6, view);
    }

    private void M(View view, int i5, int i6) {
        b bVar = (b) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i5 - bVar.n()) - bVar.k()) - this.f12092a.t(view), bVar.x()), bVar.z());
        long[] jArr = this.f12096e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? q(jArr[i6]) : view.getMeasuredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        P(i6, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f12092a.m(i6, view);
    }

    private void P(int i5, int i6, int i7, View view) {
        long[] jArr = this.f12095d;
        if (jArr != null) {
            jArr[i5] = J(i6, i7);
        }
        long[] jArr2 = this.f12096e;
        if (jArr2 != null) {
            jArr2[i5] = J(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void a(List<c> list, c cVar, int i5, int i6) {
        cVar.f12088m = i6;
        this.f12092a.i(cVar);
        cVar.f12091p = i5;
        list.add(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.b r0 = (com.google.android.flexbox.b) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.i()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.i()
        L19:
            r3 = r4
            goto L27
        L1b:
            int r3 = r0.E()
            if (r1 <= r3) goto L26
            int r1 = r0.E()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.x()
            if (r2 >= r5) goto L32
            int r2 = r0.x()
            goto L3e
        L32:
            int r5 = r0.z()
            if (r2 <= r5) goto L3d
            int r2 = r0.z()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.P(r8, r1, r0, r7)
            com.google.android.flexbox.a r6 = r6.f12092a
            r6.m(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.d.g(android.view.View, int):void");
    }

    private void k(int i5) {
        boolean[] zArr = this.f12093b;
        if (zArr == null) {
            if (i5 < 10) {
                i5 = 10;
            }
            this.f12093b = new boolean[i5];
        } else {
            if (zArr.length >= i5) {
                Arrays.fill(zArr, false);
                return;
            }
            int length = zArr.length * 2;
            if (length >= i5) {
                i5 = length;
            }
            this.f12093b = new boolean[i5];
        }
    }

    private void o(int i5, int i6, c cVar, int i7, int i8, boolean z5) {
        int i9;
        float f5;
        float f6;
        boolean z6;
        int i10;
        int iMax;
        double d6;
        double d7;
        float f7 = cVar.f12085j;
        float f8 = 0.0f;
        if (f7 <= 0.0f || i7 < (i9 = cVar.f12080e)) {
            return;
        }
        float f9 = (i7 - i9) / f7;
        cVar.f12080e = i8 + cVar.f12081f;
        if (!z5) {
            cVar.f12082g = Integer.MIN_VALUE;
        }
        int i11 = 0;
        boolean z7 = false;
        int i12 = 0;
        float f10 = 0.0f;
        while (i11 < cVar.f12083h) {
            int i13 = cVar.f12090o + i11;
            View viewJ = this.f12092a.j(i13);
            if (viewJ == null || viewJ.getVisibility() == 8) {
                f5 = f8;
                f6 = f9;
                z6 = z7;
                i10 = i11;
            } else {
                b bVar = (b) viewJ.getLayoutParams();
                int iE = this.f12092a.e();
                f5 = f8;
                if (iE == 0 || iE == 1) {
                    int measuredWidth = viewJ.getMeasuredWidth();
                    long[] jArr = this.f12096e;
                    f6 = f9;
                    z6 = z7;
                    if (jArr != null) {
                        measuredWidth = q(jArr[i13]);
                    }
                    int measuredHeight = viewJ.getMeasuredHeight();
                    long[] jArr2 = this.f12096e;
                    if (jArr2 != null) {
                        measuredHeight = p(jArr2[i13]);
                    }
                    if (this.f12093b[i13] || bVar.p() <= f5) {
                        i10 = i11;
                    } else {
                        float fP = measuredWidth + (bVar.p() * f6);
                        if (i11 == cVar.f12083h - 1) {
                            fP += f10;
                            f10 = f5;
                        }
                        int iRound = Math.round(fP);
                        if (iRound > bVar.E()) {
                            iRound = bVar.E();
                            this.f12093b[i13] = true;
                            cVar.f12085j -= bVar.p();
                            z6 = true;
                            i10 = i11;
                        } else {
                            f10 += fP - iRound;
                            i10 = i11;
                            double d8 = f10;
                            if (d8 > 1.0d) {
                                iRound++;
                                d6 = d8 - 1.0d;
                            } else if (d8 < -1.0d) {
                                iRound--;
                                d6 = d8 + 1.0d;
                            }
                            f10 = (float) d6;
                        }
                        int iR = r(i6, bVar, cVar.f12088m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewJ.measure(iMakeMeasureSpec, iR);
                        int measuredWidth2 = viewJ.getMeasuredWidth();
                        int measuredHeight2 = viewJ.getMeasuredHeight();
                        P(i13, iMakeMeasureSpec, iR, viewJ);
                        this.f12092a.m(i13, viewJ);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i12, measuredHeight + bVar.n() + bVar.k() + this.f12092a.t(viewJ));
                    cVar.f12080e += measuredWidth + bVar.l() + bVar.v();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewJ.getMeasuredHeight();
                    long[] jArr3 = this.f12096e;
                    if (jArr3 != null) {
                        measuredHeight3 = p(jArr3[i13]);
                    }
                    int measuredWidth3 = viewJ.getMeasuredWidth();
                    long[] jArr4 = this.f12096e;
                    if (jArr4 != null) {
                        measuredWidth3 = q(jArr4[i13]);
                    }
                    if (!this.f12093b[i13] && bVar.p() > f5) {
                        float fP2 = measuredHeight3 + (bVar.p() * f9);
                        if (i11 == cVar.f12083h - 1) {
                            fP2 += f10;
                            f10 = f5;
                        }
                        int iRound2 = Math.round(fP2);
                        if (iRound2 > bVar.z()) {
                            iRound2 = bVar.z();
                            this.f12093b[i13] = true;
                            cVar.f12085j -= bVar.p();
                            z7 = true;
                        } else {
                            f10 += fP2 - iRound2;
                            double d9 = f10;
                            if (d9 > 1.0d) {
                                iRound2++;
                                d7 = d9 - 1.0d;
                            } else if (d9 < -1.0d) {
                                iRound2--;
                                d7 = d9 + 1.0d;
                            }
                            f10 = (float) d7;
                        }
                        int iS = s(i5, bVar, cVar.f12088m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewJ.measure(iS, iMakeMeasureSpec2);
                        int measuredWidth4 = viewJ.getMeasuredWidth();
                        int measuredHeight4 = viewJ.getMeasuredHeight();
                        P(i13, iS, iMakeMeasureSpec2, viewJ);
                        this.f12092a.m(i13, viewJ);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i12, measuredWidth3 + bVar.l() + bVar.v() + this.f12092a.t(viewJ));
                    cVar.f12080e += measuredHeight3 + bVar.n() + bVar.k();
                    f6 = f9;
                    z6 = z7;
                    i10 = i11;
                }
                cVar.f12082g = Math.max(cVar.f12082g, iMax);
                i12 = iMax;
            }
            i11 = i10 + 1;
            f9 = f6;
            z7 = z6;
            f8 = f5;
        }
        if (!z7 || i9 == cVar.f12080e) {
            return;
        }
        o(i5, i6, cVar, i7, i8, true);
    }

    private int r(int i5, b bVar, int i6) {
        com.google.android.flexbox.a aVar = this.f12092a;
        int iQ = aVar.q(i5, aVar.getPaddingTop() + this.f12092a.getPaddingBottom() + bVar.n() + bVar.k() + i6, bVar.d());
        int size = View.MeasureSpec.getSize(iQ);
        return size > bVar.z() ? View.MeasureSpec.makeMeasureSpec(bVar.z(), View.MeasureSpec.getMode(iQ)) : size < bVar.x() ? View.MeasureSpec.makeMeasureSpec(bVar.x(), View.MeasureSpec.getMode(iQ)) : iQ;
    }

    private int s(int i5, b bVar, int i6) {
        com.google.android.flexbox.a aVar = this.f12092a;
        int iK = aVar.k(i5, aVar.getPaddingLeft() + this.f12092a.getPaddingRight() + bVar.l() + bVar.v() + i6, bVar.j());
        int size = View.MeasureSpec.getSize(iK);
        return size > bVar.E() ? View.MeasureSpec.makeMeasureSpec(bVar.E(), View.MeasureSpec.getMode(iK)) : size < bVar.i() ? View.MeasureSpec.makeMeasureSpec(bVar.i(), View.MeasureSpec.getMode(iK)) : iK;
    }

    private int t(b bVar, boolean z5) {
        return z5 ? bVar.k() : bVar.v();
    }

    private int u(b bVar, boolean z5) {
        return z5 ? bVar.v() : bVar.k();
    }

    private int v(b bVar, boolean z5) {
        return z5 ? bVar.n() : bVar.l();
    }

    private int w(b bVar, boolean z5) {
        return z5 ? bVar.l() : bVar.n();
    }

    private int x(b bVar, boolean z5) {
        return z5 ? bVar.d() : bVar.j();
    }

    private int y(b bVar, boolean z5) {
        return z5 ? bVar.j() : bVar.d();
    }

    private int z(boolean z5) {
        return z5 ? this.f12092a.getPaddingBottom() : this.f12092a.getPaddingEnd();
    }

    void H(View view, c cVar, int i5, int i6, int i7, int i8) {
        b bVar = (b) view.getLayoutParams();
        int iL = this.f12092a.l();
        if (bVar.g() != -1) {
            iL = bVar.g();
        }
        int i9 = cVar.f12082g;
        if (iL != 0) {
            if (iL == 1) {
                if (this.f12092a.h() == 2) {
                    view.layout(i5, (i6 - i9) + view.getMeasuredHeight() + bVar.n(), i7, (i8 - i9) + view.getMeasuredHeight() + bVar.n());
                    return;
                } else {
                    int i10 = i6 + i9;
                    view.layout(i5, (i10 - view.getMeasuredHeight()) - bVar.k(), i7, i10 - bVar.k());
                    return;
                }
            }
            if (iL == 2) {
                int measuredHeight = (((i9 - view.getMeasuredHeight()) + bVar.n()) - bVar.k()) / 2;
                if (this.f12092a.h() != 2) {
                    int i11 = i6 + measuredHeight;
                    view.layout(i5, i11, i7, view.getMeasuredHeight() + i11);
                    return;
                } else {
                    int i12 = i6 - measuredHeight;
                    view.layout(i5, i12, i7, view.getMeasuredHeight() + i12);
                    return;
                }
            }
            if (iL == 3) {
                if (this.f12092a.h() != 2) {
                    int iMax = Math.max(cVar.f12087l - view.getBaseline(), bVar.n());
                    view.layout(i5, i6 + iMax, i7, i8 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((cVar.f12087l - view.getMeasuredHeight()) + view.getBaseline(), bVar.k());
                    view.layout(i5, i6 - iMax2, i7, i8 - iMax2);
                    return;
                }
            }
            if (iL != 4) {
                return;
            }
        }
        if (this.f12092a.h() != 2) {
            view.layout(i5, i6 + bVar.n(), i7, i8 + bVar.n());
        } else {
            view.layout(i5, i6 - bVar.k(), i7, i8 - bVar.k());
        }
    }

    void I(View view, c cVar, boolean z5, int i5, int i6, int i7, int i8) {
        b bVar = (b) view.getLayoutParams();
        int iL = this.f12092a.l();
        if (bVar.g() != -1) {
            iL = bVar.g();
        }
        int i9 = cVar.f12082g;
        if (iL != 0) {
            if (iL == 1) {
                if (z5) {
                    view.layout((i5 - i9) + view.getMeasuredWidth() + bVar.l(), i6, (i7 - i9) + view.getMeasuredWidth() + bVar.l(), i8);
                    return;
                } else {
                    view.layout(((i5 + i9) - view.getMeasuredWidth()) - bVar.v(), i6, ((i7 + i9) - view.getMeasuredWidth()) - bVar.v(), i8);
                    return;
                }
            }
            if (iL == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i9 - view.getMeasuredWidth()) + C0467l.b(marginLayoutParams)) - C0467l.a(marginLayoutParams)) / 2;
                if (z5) {
                    view.layout(i5 - measuredWidth, i6, i7 - measuredWidth, i8);
                    return;
                } else {
                    view.layout(i5 + measuredWidth, i6, i7 + measuredWidth, i8);
                    return;
                }
            }
            if (iL != 3 && iL != 4) {
                return;
            }
        }
        if (z5) {
            view.layout(i5 - bVar.v(), i6, i7 - bVar.v(), i8);
        } else {
            view.layout(i5 + bVar.l(), i6, i7 + bVar.l(), i8);
        }
    }

    long J(int i5, int i6) {
        return (i5 & 4294967295L) | (i6 << 32);
    }

    void N() {
        O(0);
    }

    void O(int i5) {
        View viewJ;
        if (i5 >= this.f12092a.c()) {
            return;
        }
        int iE = this.f12092a.e();
        if (this.f12092a.l() != 4) {
            for (c cVar : this.f12092a.p()) {
                for (Integer num : cVar.f12089n) {
                    View viewJ2 = this.f12092a.j(num.intValue());
                    if (iE == 0 || iE == 1) {
                        M(viewJ2, cVar.f12082g, num.intValue());
                    } else {
                        if (iE != 2 && iE != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + iE);
                        }
                        L(viewJ2, cVar.f12082g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f12094c;
        List<c> listP = this.f12092a.p();
        int size = listP.size();
        for (int i6 = iArr != null ? iArr[i5] : 0; i6 < size; i6++) {
            c cVar2 = listP.get(i6);
            int i7 = cVar2.f12083h;
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = cVar2.f12090o + i8;
                if (i8 < this.f12092a.c() && (viewJ = this.f12092a.j(i9)) != null && viewJ.getVisibility() != 8) {
                    b bVar = (b) viewJ.getLayoutParams();
                    if (bVar.g() == -1 || bVar.g() == 4) {
                        if (iE == 0 || iE == 1) {
                            M(viewJ, cVar2.f12082g, i9);
                        } else {
                            if (iE != 2 && iE != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + iE);
                            }
                            L(viewJ, cVar2.f12082g, i9);
                        }
                    }
                }
            }
        }
    }

    void b(a aVar, int i5, int i6, int i7, int i8, int i9, List<c> list) {
        int i10;
        a aVar2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int iK;
        int i16;
        int i17;
        int i18;
        c cVar;
        int i19;
        int i20;
        boolean z5;
        int i21;
        boolean z6;
        int i22;
        int i23 = i5;
        boolean zS = this.f12092a.s();
        int mode = View.MeasureSpec.getMode(i23);
        int size = View.MeasureSpec.getSize(i23);
        List<c> arrayList = list == null ? new ArrayList() : list;
        aVar.f12097a = arrayList;
        boolean z7 = i9 == -1;
        int iC = C(zS);
        int iA = A(zS);
        int iB = B(zS);
        int iZ = z(zS);
        c cVar2 = new c();
        int i24 = i8;
        cVar2.f12090o = i24;
        int i25 = iC + iA;
        cVar2.f12080e = i25;
        int iC2 = this.f12092a.c();
        boolean z8 = z7;
        c cVar3 = cVar2;
        int i26 = Integer.MIN_VALUE;
        int i27 = 0;
        int iCombineMeasuredStates = 0;
        int i28 = 0;
        while (true) {
            if (i24 >= iC2) {
                i10 = iCombineMeasuredStates;
                aVar2 = aVar;
                break;
            }
            View viewJ = this.f12092a.j(i24);
            if (viewJ == null) {
                if (F(i24, iC2, cVar3)) {
                    a(arrayList, cVar3, i24, i27);
                }
                i11 = i25;
            } else {
                i11 = i25;
                if (viewJ.getVisibility() == 8) {
                    cVar3.f12084i++;
                    cVar3.f12083h++;
                    if (F(i24, iC2, cVar3)) {
                        a(arrayList, cVar3, i24, i27);
                    }
                } else {
                    b bVar = (b) viewJ.getLayoutParams();
                    int i29 = iC2;
                    if (bVar.g() == 4) {
                        cVar3.f12089n.add(Integer.valueOf(i24));
                    }
                    int iY = y(bVar, zS);
                    if (bVar.s() != -1.0f && mode == 1073741824) {
                        iY = Math.round(size * bVar.s());
                    }
                    if (zS) {
                        i13 = mode;
                        iK = this.f12092a.k(i23, i11 + w(bVar, true) + u(bVar, true), iY);
                        i12 = size;
                        i14 = i27;
                        int iQ = this.f12092a.q(i6, iB + iZ + v(bVar, true) + t(bVar, true) + i27, x(bVar, true));
                        viewJ.measure(iK, iQ);
                        P(i24, iK, iQ, viewJ);
                        i15 = 0;
                    } else {
                        i12 = size;
                        i13 = mode;
                        i14 = i27;
                        i15 = 0;
                        int iK2 = this.f12092a.k(i6, iB + iZ + v(bVar, false) + t(bVar, false) + i14, x(bVar, false));
                        int iQ2 = this.f12092a.q(i23, i11 + w(bVar, false) + u(bVar, false), iY);
                        viewJ.measure(iK2, iQ2);
                        P(i24, iK2, iQ2, viewJ);
                        iK = iQ2;
                    }
                    this.f12092a.m(i24, viewJ);
                    g(viewJ, i24);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewJ.getMeasuredState());
                    int i30 = i15;
                    i16 = i24;
                    int i31 = iK;
                    c cVar4 = cVar3;
                    int i32 = i28;
                    i17 = i11;
                    i18 = i14;
                    boolean z9 = zS;
                    size = i12;
                    if (G(viewJ, i13, size, cVar3.f12080e, E(viewJ, zS) + w(bVar, zS) + u(bVar, zS), bVar, i16, i32, arrayList.size())) {
                        if (cVar4.c() > 0) {
                            a(arrayList, cVar4, i16 > 0 ? i16 - 1 : i30, i18);
                            i22 = i18 + cVar4.f12082g;
                        } else {
                            i22 = i18;
                        }
                        if (z9) {
                            if (bVar.d() == -1) {
                                com.google.android.flexbox.a aVar3 = this.f12092a;
                                viewJ.measure(i31, aVar3.q(i6, aVar3.getPaddingTop() + this.f12092a.getPaddingBottom() + bVar.n() + bVar.k() + i22, bVar.d()));
                                g(viewJ, i16);
                            }
                        } else if (bVar.j() == -1) {
                            com.google.android.flexbox.a aVar4 = this.f12092a;
                            viewJ.measure(aVar4.k(i6, aVar4.getPaddingLeft() + this.f12092a.getPaddingRight() + bVar.l() + bVar.v() + i22, bVar.j()), i31);
                            g(viewJ, i16);
                        }
                        c cVar5 = new c();
                        cVar5.f12083h = 1;
                        cVar5.f12080e = i17;
                        cVar5.f12090o = i16;
                        i18 = i22;
                        i19 = i30;
                        cVar = cVar5;
                        i20 = Integer.MIN_VALUE;
                    } else {
                        cVar = cVar4;
                        cVar.f12083h++;
                        i19 = i32 + 1;
                        i20 = i26;
                    }
                    int[] iArr = this.f12094c;
                    if (iArr != null) {
                        iArr[i16] = arrayList.size();
                    }
                    z5 = z9;
                    cVar.f12080e += E(viewJ, z5) + w(bVar, z5) + u(bVar, z5);
                    cVar.f12085j += bVar.p();
                    cVar.f12086k += bVar.h();
                    this.f12092a.d(viewJ, i16, i19, cVar);
                    int iMax = Math.max(i20, D(viewJ, z5) + v(bVar, z5) + t(bVar, z5) + this.f12092a.t(viewJ));
                    cVar.f12082g = Math.max(cVar.f12082g, iMax);
                    if (z5) {
                        if (this.f12092a.h() != 2) {
                            cVar.f12087l = Math.max(cVar.f12087l, viewJ.getBaseline() + bVar.n());
                        } else {
                            cVar.f12087l = Math.max(cVar.f12087l, (viewJ.getMeasuredHeight() - viewJ.getBaseline()) + bVar.k());
                        }
                    }
                    i21 = i29;
                    if (F(i16, i21, cVar)) {
                        a(arrayList, cVar, i16, i18);
                        i18 += cVar.f12082g;
                    }
                    if (i9 != -1 && arrayList.size() > 0) {
                        if (arrayList.get(arrayList.size() - 1).f12091p >= i9 && i16 >= i9 && !z8) {
                            i18 = -cVar.a();
                            z6 = true;
                        }
                        if (i18 <= i7 && z6) {
                            aVar2 = aVar;
                            i10 = iCombineMeasuredStates;
                            break;
                        }
                        i26 = iMax;
                        z8 = z6;
                        i28 = i19;
                        int i33 = i16 + 1;
                        zS = z5;
                        cVar3 = cVar;
                        i25 = i17;
                        i27 = i18;
                        i23 = i5;
                        iC2 = i21;
                        i24 = i33;
                        mode = i13;
                    }
                    z6 = z8;
                    if (i18 <= i7) {
                    }
                    i26 = iMax;
                    z8 = z6;
                    i28 = i19;
                    int i332 = i16 + 1;
                    zS = z5;
                    cVar3 = cVar;
                    i25 = i17;
                    i27 = i18;
                    i23 = i5;
                    iC2 = i21;
                    i24 = i332;
                    mode = i13;
                }
            }
            i16 = i24;
            i13 = mode;
            i21 = iC2;
            i18 = i27;
            z5 = zS;
            i17 = i11;
            cVar = cVar3;
            int i3322 = i16 + 1;
            zS = z5;
            cVar3 = cVar;
            i25 = i17;
            i27 = i18;
            i23 = i5;
            iC2 = i21;
            i24 = i3322;
            mode = i13;
        }
        aVar2.f12098b = i10;
    }

    void c(a aVar, int i5, int i6, int i7, int i8, List<c> list) {
        b(aVar, i5, i6, i7, i8, -1, list);
    }

    void d(a aVar, int i5, int i6, int i7, int i8, List<c> list) {
        b(aVar, i5, i6, i7, 0, i8, list);
    }

    void e(a aVar, int i5, int i6, int i7, int i8, List<c> list) {
        b(aVar, i6, i5, i7, i8, -1, list);
    }

    void f(a aVar, int i5, int i6, int i7, int i8, List<c> list) {
        b(aVar, i6, i5, i7, 0, i8, list);
    }

    void h(List<c> list, int i5) {
        int i6 = this.f12094c[i5];
        if (i6 == -1) {
            i6 = 0;
        }
        for (int size = list.size() - 1; size >= i6; size--) {
            list.remove(size);
        }
        int[] iArr = this.f12094c;
        int length = iArr.length - 1;
        if (i5 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i5, length, -1);
        }
        long[] jArr = this.f12095d;
        int length2 = jArr.length - 1;
        if (i5 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i5, length2, 0L);
        }
    }

    void i(int i5, int i6) {
        j(i5, i6, 0);
    }

    void j(int i5, int i6, int i7) {
        int size;
        int paddingLeft;
        int paddingRight;
        d dVar;
        int i8;
        int i9;
        k(this.f12092a.c());
        if (i7 >= this.f12092a.c()) {
            return;
        }
        int iE = this.f12092a.e();
        int iE2 = this.f12092a.e();
        if (iE2 == 0 || iE2 == 1) {
            int mode = View.MeasureSpec.getMode(i5);
            size = View.MeasureSpec.getSize(i5);
            if (mode != 1073741824) {
                size = this.f12092a.g();
            }
            paddingLeft = this.f12092a.getPaddingLeft();
            paddingRight = this.f12092a.getPaddingRight();
        } else {
            if (iE2 != 2 && iE2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + iE);
            }
            int mode2 = View.MeasureSpec.getMode(i6);
            size = View.MeasureSpec.getSize(i6);
            if (mode2 != 1073741824) {
                size = this.f12092a.g();
            }
            paddingLeft = this.f12092a.getPaddingTop();
            paddingRight = this.f12092a.getPaddingBottom();
        }
        int i10 = paddingLeft + paddingRight;
        int i11 = size;
        int[] iArr = this.f12094c;
        int i12 = iArr != null ? iArr[i7] : 0;
        List<c> listP = this.f12092a.p();
        int size2 = listP.size();
        while (i12 < size2) {
            c cVar = listP.get(i12);
            if (cVar.f12080e < i11) {
                dVar = this;
                i8 = i5;
                i9 = i6;
                dVar.o(i8, i9, cVar, i11, i10, false);
            } else {
                dVar = this;
                i8 = i5;
                i9 = i6;
                dVar.K(i8, i9, cVar, i11, i10, false);
            }
            i12++;
            this = dVar;
            i5 = i8;
            i6 = i9;
        }
    }

    void l(int i5) {
        int[] iArr = this.f12094c;
        if (iArr == null) {
            if (i5 < 10) {
                i5 = 10;
            }
            this.f12094c = new int[i5];
        } else if (iArr.length < i5) {
            int length = iArr.length * 2;
            if (length >= i5) {
                i5 = length;
            }
            this.f12094c = Arrays.copyOf(iArr, i5);
        }
    }

    void m(int i5) {
        long[] jArr = this.f12095d;
        if (jArr == null) {
            if (i5 < 10) {
                i5 = 10;
            }
            this.f12095d = new long[i5];
        } else if (jArr.length < i5) {
            int length = jArr.length * 2;
            if (length >= i5) {
                i5 = length;
            }
            this.f12095d = Arrays.copyOf(jArr, i5);
        }
    }

    void n(int i5) {
        long[] jArr = this.f12096e;
        if (jArr == null) {
            if (i5 < 10) {
                i5 = 10;
            }
            this.f12096e = new long[i5];
        } else if (jArr.length < i5) {
            int length = jArr.length * 2;
            if (length >= i5) {
                i5 = length;
            }
            this.f12096e = Arrays.copyOf(jArr, i5);
        }
    }

    int p(long j5) {
        return (int) (j5 >> 32);
    }

    int q(long j5) {
        return (int) j5;
    }
}
