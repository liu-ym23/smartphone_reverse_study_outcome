package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.C1324l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.flexbox.a f19462a;

    /* renamed from: b, reason: collision with root package name */
    public boolean[] f19463b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f19464c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f19465d;

    /* renamed from: e, reason: collision with root package name */
    public long[] f19466e;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public List<b> f19467a;

        /* renamed from: b, reason: collision with root package name */
        public int f19468b;

        public void a() {
            this.f19467a = null;
            this.f19468b = 0;
        }
    }

    public c(com.google.android.flexbox.a aVar) {
        this.f19462a = aVar;
    }

    public final int A(boolean z10) {
        return z10 ? this.f19462a.getPaddingBottom() : this.f19462a.getPaddingEnd();
    }

    public final int B(boolean z10) {
        return z10 ? this.f19462a.getPaddingEnd() : this.f19462a.getPaddingBottom();
    }

    public final int C(boolean z10) {
        return z10 ? this.f19462a.getPaddingTop() : this.f19462a.getPaddingStart();
    }

    public final int D(boolean z10) {
        return z10 ? this.f19462a.getPaddingStart() : this.f19462a.getPaddingTop();
    }

    public final int E(View view, boolean z10) {
        return z10 ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    public final int F(View view, boolean z10) {
        return z10 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public final boolean G(int i10, int i11, b bVar) {
        return i10 == i11 - 1 && bVar.c() != 0;
    }

    public final boolean H(View view, int i10, int i11, int i12, int i13, FlexItem flexItem, int i14, int i15, int i16) {
        if (this.f19462a.n() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (i10 == 0) {
            return false;
        }
        int iF = this.f19462a.f();
        if (iF != -1 && iF <= i16 + 1) {
            return false;
        }
        int iS = this.f19462a.s(view, i14, i15);
        if (iS > 0) {
            i13 += iS;
        }
        return i11 < i12 + i13;
    }

    public void I(View view, b bVar, int i10, int i11, int i12, int i13) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iQ = this.f19462a.q();
        if (flexItem.getAlignSelf() != -1) {
            iQ = flexItem.getAlignSelf();
        }
        int i14 = bVar.f19450g;
        if (iQ != 0) {
            if (iQ == 1) {
                if (this.f19462a.n() == 2) {
                    view.layout(i10, (i11 - i14) + view.getMeasuredHeight() + flexItem.getMarginTop(), i12, (i13 - i14) + view.getMeasuredHeight() + flexItem.getMarginTop());
                    return;
                } else {
                    int i15 = i11 + i14;
                    view.layout(i10, (i15 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i12, i15 - flexItem.getMarginBottom());
                    return;
                }
            }
            if (iQ == 2) {
                int measuredHeight = (((i14 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.f19462a.n() != 2) {
                    int i16 = i11 + measuredHeight;
                    view.layout(i10, i16, i12, view.getMeasuredHeight() + i16);
                    return;
                } else {
                    int i17 = i11 - measuredHeight;
                    view.layout(i10, i17, i12, view.getMeasuredHeight() + i17);
                    return;
                }
            }
            if (iQ == 3) {
                if (this.f19462a.n() != 2) {
                    int iMax = Math.max(bVar.f19455l - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(i10, i11 + iMax, i12, i13 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((bVar.f19455l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                    view.layout(i10, i11 - iMax2, i12, i13 - iMax2);
                    return;
                }
            }
            if (iQ != 4) {
                return;
            }
        }
        if (this.f19462a.n() != 2) {
            view.layout(i10, i11 + flexItem.getMarginTop(), i12, i13 + flexItem.getMarginTop());
        } else {
            view.layout(i10, i11 - flexItem.getMarginBottom(), i12, i13 - flexItem.getMarginBottom());
        }
    }

    public void J(View view, b bVar, boolean z10, int i10, int i11, int i12, int i13) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iQ = this.f19462a.q();
        if (flexItem.getAlignSelf() != -1) {
            iQ = flexItem.getAlignSelf();
        }
        int i14 = bVar.f19450g;
        if (iQ != 0) {
            if (iQ == 1) {
                if (z10) {
                    view.layout((i10 - i14) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i11, (i12 - i14) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i13);
                    return;
                } else {
                    view.layout(((i10 + i14) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i11, ((i12 + i14) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i13);
                    return;
                }
            }
            if (iQ == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i14 - view.getMeasuredWidth()) + C1324l.b(marginLayoutParams)) - C1324l.a(marginLayoutParams)) / 2;
                if (z10) {
                    view.layout(i10 - measuredWidth, i11, i12 - measuredWidth, i13);
                    return;
                } else {
                    view.layout(i10 + measuredWidth, i11, i12 + measuredWidth, i13);
                    return;
                }
            }
            if (iQ != 3 && iQ != 4) {
                return;
            }
        }
        if (z10) {
            view.layout(i10 - flexItem.getMarginRight(), i11, i12 - flexItem.getMarginRight(), i13);
        } else {
            view.layout(i10 + flexItem.getMarginLeft(), i11, i12 + flexItem.getMarginLeft(), i13);
        }
    }

    public long K(int i10, int i11) {
        return (i10 & 4294967295L) | (i11 << 32);
    }

    public final void L(int i10, int i11, b bVar, int i12, int i13, boolean z10) {
        float f10;
        float f11;
        int iMax;
        int i14 = bVar.f19448e;
        float f12 = bVar.f19454k;
        float f13 = 0.0f;
        if (f12 <= 0.0f || i12 > i14) {
            return;
        }
        float f14 = (i14 - i12) / f12;
        bVar.f19448e = i13 + bVar.f19449f;
        if (!z10) {
            bVar.f19450g = Integer.MIN_VALUE;
        }
        int i15 = 0;
        boolean z11 = false;
        int i16 = 0;
        float f15 = 0.0f;
        while (i15 < bVar.f19451h) {
            int i17 = bVar.f19458o + i15;
            View viewP = this.f19462a.p(i17);
            if (viewP == null || viewP.getVisibility() == 8) {
                f10 = f13;
                f11 = f14;
                z11 = z11;
            } else {
                FlexItem flexItem = (FlexItem) viewP.getLayoutParams();
                int iE = this.f19462a.e();
                f10 = f13;
                if (iE == 0 || iE == 1) {
                    int measuredWidth = viewP.getMeasuredWidth();
                    long[] jArr = this.f19466e;
                    if (jArr != null) {
                        measuredWidth = r(jArr[i17]);
                    }
                    int measuredHeight = viewP.getMeasuredHeight();
                    long[] jArr2 = this.f19466e;
                    f11 = f14;
                    boolean z12 = z11;
                    if (jArr2 != null) {
                        measuredHeight = q(jArr2[i17]);
                    }
                    if (this.f19463b[i17] || flexItem.getFlexShrink() <= f10) {
                        z11 = z12;
                    } else {
                        float flexShrink = measuredWidth - (f11 * flexItem.getFlexShrink());
                        if (i15 == bVar.f19451h - 1) {
                            flexShrink += f15;
                            f15 = f10;
                        }
                        int iRound = Math.round(flexShrink);
                        if (iRound < flexItem.getMinWidth()) {
                            iRound = flexItem.getMinWidth();
                            this.f19463b[i17] = true;
                            bVar.f19454k -= flexItem.getFlexShrink();
                            z11 = true;
                        } else {
                            f15 += flexShrink - iRound;
                            double d10 = f15;
                            if (d10 > 1.0d) {
                                iRound++;
                                f15 -= 1.0f;
                            } else if (d10 < -1.0d) {
                                iRound--;
                                f15 += 1.0f;
                            }
                            z11 = z12;
                        }
                        int iS = s(i11, flexItem, bVar.f19456m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewP.measure(iMakeMeasureSpec, iS);
                        int measuredWidth2 = viewP.getMeasuredWidth();
                        int measuredHeight2 = viewP.getMeasuredHeight();
                        Q(i17, iMakeMeasureSpec, iS, viewP);
                        this.f19462a.r(i17, viewP);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i16, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f19462a.m(viewP));
                    bVar.f19448e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewP.getMeasuredHeight();
                    long[] jArr3 = this.f19466e;
                    if (jArr3 != null) {
                        measuredHeight3 = q(jArr3[i17]);
                    }
                    int measuredWidth3 = viewP.getMeasuredWidth();
                    long[] jArr4 = this.f19466e;
                    if (jArr4 != null) {
                        measuredWidth3 = r(jArr4[i17]);
                    }
                    if (!this.f19463b[i17] && flexItem.getFlexShrink() > f10) {
                        float flexShrink2 = measuredHeight3 - (flexItem.getFlexShrink() * f14);
                        if (i15 == bVar.f19451h - 1) {
                            flexShrink2 += f15;
                            f15 = f10;
                        }
                        int iRound2 = Math.round(flexShrink2);
                        if (iRound2 < flexItem.getMinHeight()) {
                            iRound2 = flexItem.getMinHeight();
                            this.f19463b[i17] = true;
                            bVar.f19454k -= flexItem.getFlexShrink();
                            z11 = true;
                        } else {
                            f15 += flexShrink2 - iRound2;
                            double d11 = f15;
                            if (d11 > 1.0d) {
                                iRound2++;
                                f15 -= 1.0f;
                            } else if (d11 < -1.0d) {
                                iRound2--;
                                f15 += 1.0f;
                            }
                        }
                        int iT = t(i10, flexItem, bVar.f19456m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewP.measure(iT, iMakeMeasureSpec2);
                        int measuredWidth4 = viewP.getMeasuredWidth();
                        int measuredHeight4 = viewP.getMeasuredHeight();
                        Q(i17, iT, iMakeMeasureSpec2, viewP);
                        this.f19462a.r(i17, viewP);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i16, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f19462a.m(viewP));
                    bVar.f19448e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    f11 = f14;
                }
                bVar.f19450g = Math.max(bVar.f19450g, iMax);
                i16 = iMax;
            }
            i15++;
            f14 = f11;
            f13 = f10;
        }
        if (!z11 || i14 == bVar.f19448e) {
            return;
        }
        L(i10, i11, bVar, i12, i13, true);
    }

    public final void M(View view, int i10, int i11) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i10 - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.f19462a.m(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.f19466e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? q(jArr[i11]) : view.getMeasuredHeight(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        Q(i11, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f19462a.r(i11, view);
    }

    public final void N(View view, int i10, int i11) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i10 - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.f19462a.m(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.f19466e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? r(jArr[i11]) : view.getMeasuredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        Q(i11, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f19462a.r(i11, view);
    }

    public void O() {
        P(0);
    }

    public void P(int i10) {
        View viewP;
        if (i10 >= this.f19462a.c()) {
            return;
        }
        int iE = this.f19462a.e();
        if (this.f19462a.q() != 4) {
            for (b bVar : this.f19462a.j()) {
                for (Integer num : bVar.f19457n) {
                    View viewP2 = this.f19462a.p(num.intValue());
                    if (iE == 0 || iE == 1) {
                        N(viewP2, bVar.f19450g, num.intValue());
                    } else {
                        if (iE != 2 && iE != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + iE);
                        }
                        M(viewP2, bVar.f19450g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f19464c;
        List<b> listJ = this.f19462a.j();
        int size = listJ.size();
        for (int i11 = iArr != null ? iArr[i10] : 0; i11 < size; i11++) {
            b bVar2 = listJ.get(i11);
            int i12 = bVar2.f19451h;
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = bVar2.f19458o + i13;
                if (i13 < this.f19462a.c() && (viewP = this.f19462a.p(i14)) != null && viewP.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) viewP.getLayoutParams();
                    if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                        if (iE == 0 || iE == 1) {
                            N(viewP, bVar2.f19450g, i14);
                        } else {
                            if (iE != 2 && iE != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + iE);
                            }
                            M(viewP, bVar2.f19450g, i14);
                        }
                    }
                }
            }
        }
    }

    public final void Q(int i10, int i11, int i12, View view) {
        long[] jArr = this.f19465d;
        if (jArr != null) {
            jArr[i10] = K(i11, i12);
        }
        long[] jArr2 = this.f19466e;
        if (jArr2 != null) {
            jArr2[i10] = K(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public final void a(List<b> list, b bVar, int i10, int i11) {
        bVar.f19456m = i11;
        this.f19462a.o(bVar);
        bVar.f19459p = i10;
        list.add(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(a aVar, int i10, int i11, int i12, int i13, int i14, List<b> list) {
        int i15;
        a aVar2;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int iH;
        int i21;
        int i22;
        int i23;
        b bVar;
        int i24;
        int i25;
        boolean z10;
        int i26;
        boolean z11;
        int i27;
        int i28 = i10;
        boolean zT = this.f19462a.t();
        int mode = View.MeasureSpec.getMode(i28);
        int size = View.MeasureSpec.getSize(i28);
        List<b> arrayList = list == null ? new ArrayList() : list;
        aVar.f19467a = arrayList;
        boolean z12 = i14 == -1;
        int iD = D(zT);
        int iB = B(zT);
        int iC = C(zT);
        int iA = A(zT);
        b bVar2 = new b();
        int i29 = i13;
        bVar2.f19458o = i29;
        int i30 = iD + iB;
        bVar2.f19448e = i30;
        int iC2 = this.f19462a.c();
        boolean z13 = z12;
        b bVar3 = bVar2;
        int i31 = Integer.MIN_VALUE;
        int i32 = 0;
        int iCombineMeasuredStates = 0;
        int i33 = 0;
        while (true) {
            if (i29 >= iC2) {
                i15 = iCombineMeasuredStates;
                aVar2 = aVar;
                break;
            }
            View viewP = this.f19462a.p(i29);
            if (viewP == null) {
                if (G(i29, iC2, bVar3)) {
                    a(arrayList, bVar3, i29, i32);
                }
                i16 = i30;
            } else {
                i16 = i30;
                if (viewP.getVisibility() == 8) {
                    bVar3.f19452i++;
                    bVar3.f19451h++;
                    if (G(i29, iC2, bVar3)) {
                        a(arrayList, bVar3, i29, i32);
                    }
                } else {
                    if (viewP instanceof CompoundButton) {
                        o((CompoundButton) viewP);
                    }
                    FlexItem flexItem = (FlexItem) viewP.getLayoutParams();
                    int i34 = iC2;
                    if (flexItem.getAlignSelf() == 4) {
                        bVar3.f19457n.add(Integer.valueOf(i29));
                    }
                    int iZ = z(flexItem, zT);
                    if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                        iZ = Math.round(size * flexItem.getFlexBasisPercent());
                    }
                    if (zT) {
                        i18 = mode;
                        iH = this.f19462a.h(i28, i16 + x(flexItem, true) + v(flexItem, true), iZ);
                        i17 = size;
                        i19 = i32;
                        int iK = this.f19462a.k(i11, iC + iA + w(flexItem, true) + u(flexItem, true) + i32, y(flexItem, true));
                        viewP.measure(iH, iK);
                        Q(i29, iH, iK, viewP);
                        i20 = 0;
                    } else {
                        i17 = size;
                        i18 = mode;
                        i19 = i32;
                        i20 = 0;
                        int iH2 = this.f19462a.h(i11, iC + iA + w(flexItem, false) + u(flexItem, false) + i19, y(flexItem, false));
                        int iK2 = this.f19462a.k(i28, i16 + x(flexItem, false) + v(flexItem, false), iZ);
                        viewP.measure(iH2, iK2);
                        Q(i29, iH2, iK2, viewP);
                        iH = iK2;
                    }
                    this.f19462a.r(i29, viewP);
                    g(viewP, i29);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewP.getMeasuredState());
                    int i35 = i20;
                    i21 = i29;
                    int i36 = iH;
                    b bVar4 = bVar3;
                    int i37 = i33;
                    i22 = i16;
                    i23 = i19;
                    boolean z14 = zT;
                    size = i17;
                    if (H(viewP, i18, size, bVar3.f19448e, F(viewP, zT) + x(flexItem, zT) + v(flexItem, zT), flexItem, i21, i37, arrayList.size())) {
                        if (bVar4.c() > 0) {
                            a(arrayList, bVar4, i21 > 0 ? i21 - 1 : i35, i23);
                            i27 = i23 + bVar4.f19450g;
                        } else {
                            i27 = i23;
                        }
                        if (z14) {
                            if (flexItem.getHeight() == -1) {
                                com.google.android.flexbox.a aVar3 = this.f19462a;
                                viewP.measure(i36, aVar3.k(i11, aVar3.getPaddingTop() + this.f19462a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i27, flexItem.getHeight()));
                                g(viewP, i21);
                            }
                        } else if (flexItem.getWidth() == -1) {
                            com.google.android.flexbox.a aVar4 = this.f19462a;
                            viewP.measure(aVar4.h(i11, aVar4.getPaddingLeft() + this.f19462a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i27, flexItem.getWidth()), i36);
                            g(viewP, i21);
                        }
                        b bVar5 = new b();
                        bVar5.f19451h = 1;
                        bVar5.f19448e = i22;
                        bVar5.f19458o = i21;
                        i23 = i27;
                        i24 = i35;
                        bVar = bVar5;
                        i25 = Integer.MIN_VALUE;
                    } else {
                        bVar = bVar4;
                        bVar.f19451h++;
                        i24 = i37 + 1;
                        i25 = i31;
                    }
                    bVar.f19460q = (bVar.f19460q ? 1 : 0) | (flexItem.getFlexGrow() != 0.0f ? 1 : i35);
                    bVar.f19461r = (bVar.f19461r ? 1 : 0) | (flexItem.getFlexShrink() != 0.0f ? 1 : i35);
                    int[] iArr = this.f19464c;
                    if (iArr != null) {
                        iArr[i21] = arrayList.size();
                    }
                    z10 = z14;
                    bVar.f19448e += F(viewP, z10) + x(flexItem, z10) + v(flexItem, z10);
                    bVar.f19453j += flexItem.getFlexGrow();
                    bVar.f19454k += flexItem.getFlexShrink();
                    this.f19462a.d(viewP, i21, i24, bVar);
                    int iMax = Math.max(i25, E(viewP, z10) + w(flexItem, z10) + u(flexItem, z10) + this.f19462a.m(viewP));
                    bVar.f19450g = Math.max(bVar.f19450g, iMax);
                    if (z10) {
                        if (this.f19462a.n() != 2) {
                            bVar.f19455l = Math.max(bVar.f19455l, viewP.getBaseline() + flexItem.getMarginTop());
                        } else {
                            bVar.f19455l = Math.max(bVar.f19455l, (viewP.getMeasuredHeight() - viewP.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    i26 = i34;
                    if (G(i21, i26, bVar)) {
                        a(arrayList, bVar, i21, i23);
                        i23 += bVar.f19450g;
                    }
                    if (i14 != -1 && arrayList.size() > 0) {
                        if (arrayList.get(arrayList.size() - 1).f19459p >= i14 && i21 >= i14 && !z13) {
                            i23 = -bVar.a();
                            z11 = true;
                        }
                        if (i23 <= i12 && z11) {
                            aVar2 = aVar;
                            i15 = iCombineMeasuredStates;
                            break;
                        }
                        i31 = iMax;
                        z13 = z11;
                        i33 = i24;
                        int i38 = i21 + 1;
                        zT = z10;
                        bVar3 = bVar;
                        i30 = i22;
                        i32 = i23;
                        i28 = i10;
                        iC2 = i26;
                        i29 = i38;
                        mode = i18;
                    }
                    z11 = z13;
                    if (i23 <= i12) {
                    }
                    i31 = iMax;
                    z13 = z11;
                    i33 = i24;
                    int i382 = i21 + 1;
                    zT = z10;
                    bVar3 = bVar;
                    i30 = i22;
                    i32 = i23;
                    i28 = i10;
                    iC2 = i26;
                    i29 = i382;
                    mode = i18;
                }
            }
            i21 = i29;
            i18 = mode;
            i26 = iC2;
            i23 = i32;
            z10 = zT;
            i22 = i16;
            bVar = bVar3;
            int i3822 = i21 + 1;
            zT = z10;
            bVar3 = bVar;
            i30 = i22;
            i32 = i23;
            i28 = i10;
            iC2 = i26;
            i29 = i3822;
            mode = i18;
        }
        aVar2.f19468b = i15;
    }

    public void c(a aVar, int i10, int i11, int i12, int i13, List<b> list) {
        b(aVar, i10, i11, i12, i13, -1, list);
    }

    public void d(a aVar, int i10, int i11, int i12, int i13, List<b> list) {
        b(aVar, i10, i11, i12, 0, i13, list);
    }

    public void e(a aVar, int i10, int i11, int i12, int i13, List<b> list) {
        b(aVar, i11, i10, i12, i13, -1, list);
    }

    public void f(a aVar, int i10, int i11, int i12, int i13, List<b> list) {
        b(aVar, i11, i10, i12, 0, i13, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.getMinWidth()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.getMinWidth()
        L19:
            r3 = r4
            goto L27
        L1b:
            int r3 = r0.getMaxWidth()
            if (r1 <= r3) goto L26
            int r1 = r0.getMaxWidth()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.getMinHeight()
            if (r2 >= r5) goto L32
            int r2 = r0.getMinHeight()
            goto L3e
        L32:
            int r5 = r0.getMaxHeight()
            if (r2 <= r5) goto L3d
            int r2 = r0.getMaxHeight()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.Q(r8, r1, r0, r7)
            com.google.android.flexbox.a r6 = r6.f19462a
            r6.r(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.c.g(android.view.View, int):void");
    }

    public void h(List<b> list, int i10) {
        int i11 = this.f19464c[i10];
        if (i11 == -1) {
            i11 = 0;
        }
        if (list.size() > i11) {
            list.subList(i11, list.size()).clear();
        }
        int[] iArr = this.f19464c;
        int length = iArr.length - 1;
        if (i10 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i10, length, -1);
        }
        long[] jArr = this.f19465d;
        int length2 = jArr.length - 1;
        if (i10 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i10, length2, 0L);
        }
    }

    public void i(int i10, int i11) {
        j(i10, i11, 0);
    }

    public void j(int i10, int i11, int i12) {
        int size;
        int paddingLeft;
        int paddingRight;
        int i13;
        int i14;
        c cVar;
        k(this.f19462a.c());
        if (i12 >= this.f19462a.c()) {
            return;
        }
        int iE = this.f19462a.e();
        int iE2 = this.f19462a.e();
        if (iE2 == 0 || iE2 == 1) {
            int mode = View.MeasureSpec.getMode(i10);
            size = View.MeasureSpec.getSize(i10);
            int iG = this.f19462a.g();
            if (mode != 1073741824) {
                size = Math.min(iG, size);
            }
            paddingLeft = this.f19462a.getPaddingLeft();
            paddingRight = this.f19462a.getPaddingRight();
        } else {
            if (iE2 != 2 && iE2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + iE);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            size = View.MeasureSpec.getSize(i11);
            if (mode2 != 1073741824) {
                size = this.f19462a.g();
            }
            paddingLeft = this.f19462a.getPaddingTop();
            paddingRight = this.f19462a.getPaddingBottom();
        }
        int i15 = paddingLeft + paddingRight;
        int i16 = size;
        int[] iArr = this.f19464c;
        int i17 = iArr != null ? iArr[i12] : 0;
        List<b> listJ = this.f19462a.j();
        int size2 = listJ.size();
        while (i17 < size2) {
            b bVar = listJ.get(i17);
            int i18 = bVar.f19448e;
            if (i18 >= i16 || !bVar.f19460q) {
                i13 = i10;
                i14 = i11;
                if (i18 <= i16 || !bVar.f19461r) {
                    cVar = this;
                } else {
                    cVar = this;
                    cVar.L(i13, i14, bVar, i16, i15, false);
                }
            } else {
                cVar = this;
                i13 = i10;
                i14 = i11;
                cVar.p(i13, i14, bVar, i16, i15, false);
            }
            i17++;
            this = cVar;
            i10 = i13;
            i11 = i14;
        }
    }

    public final void k(int i10) {
        boolean[] zArr = this.f19463b;
        if (zArr == null) {
            this.f19463b = new boolean[Math.max(i10, 10)];
        } else if (zArr.length < i10) {
            this.f19463b = new boolean[Math.max(zArr.length * 2, i10)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public void l(int i10) {
        int[] iArr = this.f19464c;
        if (iArr == null) {
            this.f19464c = new int[Math.max(i10, 10)];
        } else if (iArr.length < i10) {
            this.f19464c = Arrays.copyOf(this.f19464c, Math.max(iArr.length * 2, i10));
        }
    }

    public void m(int i10) {
        long[] jArr = this.f19465d;
        if (jArr == null) {
            this.f19465d = new long[Math.max(i10, 10)];
        } else if (jArr.length < i10) {
            this.f19465d = Arrays.copyOf(this.f19465d, Math.max(jArr.length * 2, i10));
        }
    }

    public void n(int i10) {
        long[] jArr = this.f19466e;
        if (jArr == null) {
            this.f19466e = new long[Math.max(i10, 10)];
        } else if (jArr.length < i10) {
            this.f19466e = Arrays.copyOf(this.f19466e, Math.max(jArr.length * 2, i10));
        }
    }

    public final void o(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable drawableA = androidx.core.widget.c.a(compoundButton);
        int minimumWidth = drawableA == null ? 0 : drawableA.getMinimumWidth();
        int minimumHeight = drawableA != null ? drawableA.getMinimumHeight() : 0;
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = minimumHeight;
        }
        flexItem.setMinHeight(minHeight);
    }

    public final void p(int i10, int i11, b bVar, int i12, int i13, boolean z10) {
        int i14;
        float f10;
        float f11;
        boolean z11;
        int i15;
        int iMax;
        double d10;
        double d11;
        float f12 = bVar.f19453j;
        float f13 = 0.0f;
        if (f12 <= 0.0f || i12 < (i14 = bVar.f19448e)) {
            return;
        }
        float f14 = (i12 - i14) / f12;
        bVar.f19448e = i13 + bVar.f19449f;
        if (!z10) {
            bVar.f19450g = Integer.MIN_VALUE;
        }
        int i16 = 0;
        boolean z12 = false;
        int i17 = 0;
        float f15 = 0.0f;
        while (i16 < bVar.f19451h) {
            int i18 = bVar.f19458o + i16;
            View viewP = this.f19462a.p(i18);
            if (viewP == null || viewP.getVisibility() == 8) {
                f10 = f13;
                f11 = f14;
                z11 = z12;
                i15 = i16;
            } else {
                FlexItem flexItem = (FlexItem) viewP.getLayoutParams();
                int iE = this.f19462a.e();
                f10 = f13;
                if (iE == 0 || iE == 1) {
                    int measuredWidth = viewP.getMeasuredWidth();
                    long[] jArr = this.f19466e;
                    f11 = f14;
                    z11 = z12;
                    if (jArr != null) {
                        measuredWidth = r(jArr[i18]);
                    }
                    int measuredHeight = viewP.getMeasuredHeight();
                    long[] jArr2 = this.f19466e;
                    if (jArr2 != null) {
                        measuredHeight = q(jArr2[i18]);
                    }
                    if (this.f19463b[i18] || flexItem.getFlexGrow() <= f10) {
                        i15 = i16;
                    } else {
                        float flexGrow = measuredWidth + (flexItem.getFlexGrow() * f11);
                        if (i16 == bVar.f19451h - 1) {
                            flexGrow += f15;
                            f15 = f10;
                        }
                        int iRound = Math.round(flexGrow);
                        if (iRound > flexItem.getMaxWidth()) {
                            iRound = flexItem.getMaxWidth();
                            this.f19463b[i18] = true;
                            bVar.f19453j -= flexItem.getFlexGrow();
                            z11 = true;
                            i15 = i16;
                        } else {
                            f15 += flexGrow - iRound;
                            i15 = i16;
                            double d12 = f15;
                            if (d12 > 1.0d) {
                                iRound++;
                                d10 = d12 - 1.0d;
                            } else if (d12 < -1.0d) {
                                iRound--;
                                d10 = d12 + 1.0d;
                            }
                            f15 = (float) d10;
                        }
                        int iS = s(i11, flexItem, bVar.f19456m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewP.measure(iMakeMeasureSpec, iS);
                        int measuredWidth2 = viewP.getMeasuredWidth();
                        int measuredHeight2 = viewP.getMeasuredHeight();
                        Q(i18, iMakeMeasureSpec, iS, viewP);
                        this.f19462a.r(i18, viewP);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i17, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f19462a.m(viewP));
                    bVar.f19448e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewP.getMeasuredHeight();
                    long[] jArr3 = this.f19466e;
                    if (jArr3 != null) {
                        measuredHeight3 = q(jArr3[i18]);
                    }
                    int measuredWidth3 = viewP.getMeasuredWidth();
                    long[] jArr4 = this.f19466e;
                    if (jArr4 != null) {
                        measuredWidth3 = r(jArr4[i18]);
                    }
                    if (!this.f19463b[i18] && flexItem.getFlexGrow() > f10) {
                        float flexGrow2 = measuredHeight3 + (flexItem.getFlexGrow() * f14);
                        if (i16 == bVar.f19451h - 1) {
                            flexGrow2 += f15;
                            f15 = f10;
                        }
                        int iRound2 = Math.round(flexGrow2);
                        if (iRound2 > flexItem.getMaxHeight()) {
                            iRound2 = flexItem.getMaxHeight();
                            this.f19463b[i18] = true;
                            bVar.f19453j -= flexItem.getFlexGrow();
                            z12 = true;
                        } else {
                            f15 += flexGrow2 - iRound2;
                            double d13 = f15;
                            if (d13 > 1.0d) {
                                iRound2++;
                                d11 = d13 - 1.0d;
                            } else if (d13 < -1.0d) {
                                iRound2--;
                                d11 = d13 + 1.0d;
                            }
                            f15 = (float) d11;
                        }
                        int iT = t(i10, flexItem, bVar.f19456m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewP.measure(iT, iMakeMeasureSpec2);
                        int measuredWidth4 = viewP.getMeasuredWidth();
                        int measuredHeight4 = viewP.getMeasuredHeight();
                        Q(i18, iT, iMakeMeasureSpec2, viewP);
                        this.f19462a.r(i18, viewP);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i17, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f19462a.m(viewP));
                    bVar.f19448e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    f11 = f14;
                    z11 = z12;
                    i15 = i16;
                }
                bVar.f19450g = Math.max(bVar.f19450g, iMax);
                i17 = iMax;
            }
            i16 = i15 + 1;
            f14 = f11;
            z12 = z11;
            f13 = f10;
        }
        if (!z12 || i14 == bVar.f19448e) {
            return;
        }
        p(i10, i11, bVar, i12, i13, true);
    }

    public int q(long j10) {
        return (int) (j10 >> 32);
    }

    public int r(long j10) {
        return (int) j10;
    }

    public final int s(int i10, FlexItem flexItem, int i11) {
        com.google.android.flexbox.a aVar = this.f19462a;
        int iK = aVar.k(i10, aVar.getPaddingTop() + this.f19462a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i11, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(iK);
        return size > flexItem.getMaxHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(iK)) : size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(iK)) : iK;
    }

    public final int t(int i10, FlexItem flexItem, int i11) {
        com.google.android.flexbox.a aVar = this.f19462a;
        int iH = aVar.h(i10, aVar.getPaddingLeft() + this.f19462a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i11, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(iH);
        return size > flexItem.getMaxWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(iH)) : size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(iH)) : iH;
    }

    public final int u(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getMarginBottom() : flexItem.getMarginRight();
    }

    public final int v(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getMarginRight() : flexItem.getMarginBottom();
    }

    public final int w(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getMarginTop() : flexItem.getMarginLeft();
    }

    public final int x(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getMarginLeft() : flexItem.getMarginTop();
    }

    public final int y(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getHeight() : flexItem.getWidth();
    }

    public final int z(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getWidth() : flexItem.getHeight();
    }
}
