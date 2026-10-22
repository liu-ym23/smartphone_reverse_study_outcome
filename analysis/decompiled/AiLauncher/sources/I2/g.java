package I2;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselStrategy;
import w0.C5715a;

/* loaded from: classes2.dex */
public final class g extends CarouselStrategy {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f3360d = {1};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f3361e = {1, 0};

    /* renamed from: c, reason: collision with root package name */
    public int f3362c = 0;

    @Override // com.google.android.material.carousel.CarouselStrategy
    public com.google.android.material.carousel.b g(b bVar, View view) {
        boolean z10;
        int iB = bVar.b();
        if (bVar.l()) {
            iB = bVar.a();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (bVar.l()) {
            f10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float fD = d() + f10;
        float fMax = Math.max(c() + f10, fD);
        float f11 = iB;
        float fMin = Math.min(measuredHeight + f10, f11);
        float fA = C5715a.a((measuredHeight / 3.0f) + f10, fD + f10, fMax + f10);
        float f12 = (fMin + fA) / 2.0f;
        int[] iArrA = f3360d;
        float f13 = 2.0f * fD;
        if (f11 <= f13) {
            iArrA = new int[]{0};
        }
        int[] iArrA2 = f3361e;
        if (bVar.i() == 1) {
            iArrA = CarouselStrategy.a(iArrA);
            iArrA2 = CarouselStrategy.a(iArrA2);
        }
        int[] iArr = iArrA2;
        int[] iArr2 = iArrA;
        float f14 = f10;
        int iMax = (int) Math.max(1.0d, Math.floor(((f11 - (com.google.android.material.carousel.a.i(iArr) * f12)) - (com.google.android.material.carousel.a.i(iArr2) * fMax)) / fMin));
        int iCeil = (int) Math.ceil(f11 / fMin);
        int i10 = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr3[i11] = iCeil - i11;
        }
        a aVarC = a.c(f11, fA, fD, fMax, iArr2, f12, iArr, fMin, iArr3);
        this.f3362c = aVarC.e();
        boolean zI = i(aVarC, bVar.getItemCount());
        int i12 = aVarC.f3350d;
        if (i12 == 0 && aVarC.f3349c == 0 && f11 > f13) {
            aVarC.f3349c = 1;
            z10 = true;
        } else {
            z10 = zI;
        }
        if (z10) {
            aVarC = a.c(f11, fA, fD, fMax, new int[]{aVarC.f3349c}, f12, new int[]{i12}, fMin, new int[]{aVarC.f3353g});
        }
        return com.google.android.material.carousel.a.d(view.getContext(), f14, iB, aVarC, bVar.i());
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean h(b bVar, int i10) {
        if (i10 >= this.f3362c || bVar.getItemCount() < this.f3362c) {
            return i10 >= this.f3362c && bVar.getItemCount() < this.f3362c;
        }
        return true;
    }

    public boolean i(a aVar, int i10) {
        int iE = aVar.e() - i10;
        boolean z10 = iE > 0 && (aVar.f3349c > 0 || aVar.f3350d > 1);
        while (iE > 0) {
            int i11 = aVar.f3349c;
            if (i11 > 0) {
                aVar.f3349c = i11 - 1;
            } else {
                int i12 = aVar.f3350d;
                if (i12 > 1) {
                    aVar.f3350d = i12 - 1;
                }
            }
            iE--;
        }
        return z10;
    }
}
