package com.google.android.material.carousel;

import android.content.Context;
import com.google.android.material.R$dimen;
import com.google.android.material.carousel.b;

/* loaded from: classes2.dex */
public final class a {
    public static float a(float f10, float f11, int i10) {
        return f10 + (Math.max(0, i10 - 1) * f11);
    }

    public static float b(float f10, float f11, int i10) {
        return i10 > 0 ? f10 + (f11 / 2.0f) : f10;
    }

    public static b c(Context context, float f10, int i10, I2.a aVar) {
        float f11;
        float f12;
        float fMin = Math.min(f(context) + f10, aVar.f3352f);
        float f13 = fMin / 2.0f;
        float f14 = 0.0f - f13;
        float fB = b(0.0f, aVar.f3348b, aVar.f3349c);
        float fJ = j(0.0f, a(fB, aVar.f3348b, (int) Math.floor(aVar.f3349c / 2.0f)), aVar.f3348b, aVar.f3349c);
        float fB2 = b(fJ, aVar.f3351e, aVar.f3350d);
        float fJ2 = j(fJ, a(fB2, aVar.f3351e, (int) Math.floor(aVar.f3350d / 2.0f)), aVar.f3351e, aVar.f3350d);
        float fB3 = b(fJ2, aVar.f3352f, aVar.f3353g);
        float fJ3 = j(fJ2, a(fB3, aVar.f3352f, aVar.f3353g), aVar.f3352f, aVar.f3353g);
        float fB4 = b(fJ3, aVar.f3351e, aVar.f3350d);
        float fB5 = b(j(fJ3, a(fB4, aVar.f3351e, (int) Math.ceil(aVar.f3350d / 2.0f)), aVar.f3351e, aVar.f3350d), aVar.f3348b, aVar.f3349c);
        float f15 = i10 + f13;
        float fB6 = CarouselStrategy.b(fMin, aVar.f3352f, f10);
        float fB7 = CarouselStrategy.b(aVar.f3348b, aVar.f3352f, f10);
        float fB8 = CarouselStrategy.b(aVar.f3351e, aVar.f3352f, f10);
        b.C0231b c0231bA = new b.C0231b(aVar.f3352f, i10).a(f14, fB6, fMin);
        if (aVar.f3349c > 0) {
            f11 = 2.0f;
            f12 = fB6;
            c0231bA.g(fB, fB7, aVar.f3348b, (int) Math.floor(r7 / 2.0f));
        } else {
            f11 = 2.0f;
            f12 = fB6;
        }
        if (aVar.f3350d > 0) {
            c0231bA.g(fB2, fB8, aVar.f3351e, (int) Math.floor(r4 / f11));
        }
        c0231bA.h(fB3, 0.0f, aVar.f3352f, aVar.f3353g, true);
        if (aVar.f3350d > 0) {
            c0231bA.g(fB4, fB8, aVar.f3351e, (int) Math.ceil(r4 / f11));
        }
        if (aVar.f3349c > 0) {
            c0231bA.g(fB5, fB7, aVar.f3348b, (int) Math.ceil(r0 / f11));
        }
        c0231bA.a(f15, f12, fMin);
        return c0231bA.i();
    }

    public static b d(Context context, float f10, int i10, I2.a aVar, int i11) {
        return i11 == 1 ? c(context, f10, i10, aVar) : e(context, f10, i10, aVar);
    }

    public static b e(Context context, float f10, int i10, I2.a aVar) {
        float fMin = Math.min(f(context) + f10, aVar.f3352f);
        float f11 = fMin / 2.0f;
        float f12 = 0.0f - f11;
        float fB = b(0.0f, aVar.f3352f, aVar.f3353g);
        float fJ = j(0.0f, a(fB, aVar.f3352f, aVar.f3353g), aVar.f3352f, aVar.f3353g);
        float fB2 = b(fJ, aVar.f3351e, aVar.f3350d);
        float fB3 = b(j(fJ, fB2, aVar.f3351e, aVar.f3350d), aVar.f3348b, aVar.f3349c);
        float f13 = i10 + f11;
        float fB4 = CarouselStrategy.b(fMin, aVar.f3352f, f10);
        float fB5 = CarouselStrategy.b(aVar.f3348b, aVar.f3352f, f10);
        float fB6 = CarouselStrategy.b(aVar.f3351e, aVar.f3352f, f10);
        b.C0231b c0231bH = new b.C0231b(aVar.f3352f, i10).a(f12, fB4, fMin).h(fB, 0.0f, aVar.f3352f, aVar.f3353g, true);
        if (aVar.f3350d > 0) {
            c0231bH.b(fB2, fB6, aVar.f3351e);
        }
        int i11 = aVar.f3349c;
        if (i11 > 0) {
            c0231bH.g(fB3, fB5, aVar.f3348b, i11);
        }
        c0231bH.a(f13, fB4, fMin);
        return c0231bH.i();
    }

    public static float f(Context context) {
        return context.getResources().getDimension(R$dimen.m3_carousel_gone_size);
    }

    public static float g(Context context) {
        return context.getResources().getDimension(R$dimen.m3_carousel_small_item_size_max);
    }

    public static float h(Context context) {
        return context.getResources().getDimension(R$dimen.m3_carousel_small_item_size_min);
    }

    public static int i(int[] iArr) {
        int i10 = Integer.MIN_VALUE;
        for (int i11 : iArr) {
            if (i11 > i10) {
                i10 = i11;
            }
        }
        return i10;
    }

    public static float j(float f10, float f11, float f12, int i10) {
        return i10 > 0 ? f11 + (f12 / 2.0f) : f10;
    }
}
