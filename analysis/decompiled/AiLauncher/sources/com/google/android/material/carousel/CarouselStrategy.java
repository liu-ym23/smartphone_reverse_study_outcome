package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;

/* loaded from: classes2.dex */
public abstract class CarouselStrategy {

    /* renamed from: a, reason: collision with root package name */
    public float f20555a;

    /* renamed from: b, reason: collision with root package name */
    public float f20556b;

    public enum StrategyType {
        CONTAINED,
        UNCONTAINED
    }

    public static int[] a(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr2[i10] = iArr[i10] * 2;
        }
        return iArr2;
    }

    public static float b(float f10, float f11, float f12) {
        return 1.0f - ((f10 - f12) / (f11 - f12));
    }

    public float c() {
        return this.f20556b;
    }

    public float d() {
        return this.f20555a;
    }

    public StrategyType e() {
        return StrategyType.CONTAINED;
    }

    public void f(Context context) {
        float fH = this.f20555a;
        if (fH <= 0.0f) {
            fH = a.h(context);
        }
        this.f20555a = fH;
        float fG = this.f20556b;
        if (fG <= 0.0f) {
            fG = a.g(context);
        }
        this.f20556b = fG;
    }

    public abstract b g(I2.b bVar, View view);

    public abstract boolean h(I2.b bVar, int i10);
}
