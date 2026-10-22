package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import e1.InterfaceC0682a;

/* loaded from: classes.dex */
public final class h extends c {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f12546d = {1};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f12547e = {1, 0};

    /* renamed from: c, reason: collision with root package name */
    private int f12548c = 0;

    @Override // com.google.android.material.carousel.c
    public e g(InterfaceC0682a interfaceC0682a, View view) {
        boolean z5;
        int iB = interfaceC0682a.b();
        if (interfaceC0682a.r()) {
            iB = interfaceC0682a.a();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f5 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (interfaceC0682a.r()) {
            f5 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float fD = d() + f5;
        float fMax = Math.max(c() + f5, fD);
        float f6 = iB;
        float fMin = Math.min(measuredHeight + f5, f6);
        float fA = B.a.a((measuredHeight / 3.0f) + f5, fD + f5, fMax + f5);
        float f7 = (fMin + fA) / 2.0f;
        int[] iArrA = f12546d;
        float f8 = 2.0f * fD;
        if (f6 <= f8) {
            iArrA = new int[]{0};
        }
        int[] iArrA2 = f12547e;
        if (interfaceC0682a.o() == 1) {
            iArrA = c.a(iArrA);
            iArrA2 = c.a(iArrA2);
        }
        int[] iArr = iArrA2;
        int[] iArr2 = iArrA;
        float f9 = f5;
        int iMax = (int) Math.max(1.0d, Math.floor(((f6 - (d.i(iArr) * f7)) - (d.i(iArr2) * fMax)) / fMin));
        int iCeil = (int) Math.ceil(f6 / fMin);
        int i5 = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            iArr3[i6] = iCeil - i6;
        }
        a aVarC = a.c(f6, fA, fD, fMax, iArr2, f7, iArr, fMin, iArr3);
        this.f12548c = aVarC.e();
        boolean zI = i(aVarC, interfaceC0682a.getItemCount());
        int i7 = aVarC.f12502d;
        if (i7 == 0 && aVarC.f12501c == 0 && f6 > f8) {
            aVarC.f12501c = 1;
            z5 = true;
        } else {
            z5 = zI;
        }
        if (z5) {
            aVarC = a.c(f6, fA, fD, fMax, new int[]{aVarC.f12501c}, f7, new int[]{i7}, fMin, new int[]{aVarC.f12505g});
        }
        return d.d(view.getContext(), f9, iB, aVarC, interfaceC0682a.o());
    }

    @Override // com.google.android.material.carousel.c
    public boolean h(InterfaceC0682a interfaceC0682a, int i5) {
        if (i5 >= this.f12548c || interfaceC0682a.getItemCount() < this.f12548c) {
            return i5 >= this.f12548c && interfaceC0682a.getItemCount() < this.f12548c;
        }
        return true;
    }

    boolean i(a aVar, int i5) {
        int iE = aVar.e() - i5;
        boolean z5 = iE > 0 && (aVar.f12501c > 0 || aVar.f12502d > 1);
        while (iE > 0) {
            int i6 = aVar.f12501c;
            if (i6 > 0) {
                aVar.f12501c = i6 - 1;
            } else {
                int i7 = aVar.f12502d;
                if (i7 > 1) {
                    aVar.f12502d = i7 - 1;
                }
            }
            iE--;
        }
        return z5;
    }
}
