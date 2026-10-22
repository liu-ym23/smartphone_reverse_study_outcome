package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import e1.InterfaceC0682a;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private float f12510a;

    /* renamed from: b, reason: collision with root package name */
    private float f12511b;

    enum a {
        CONTAINED,
        UNCONTAINED
    }

    static int[] a(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr2[i5] = iArr[i5] * 2;
        }
        return iArr2;
    }

    public static float b(float f5, float f6, float f7) {
        return 1.0f - ((f5 - f7) / (f6 - f7));
    }

    public float c() {
        return this.f12511b;
    }

    public float d() {
        return this.f12510a;
    }

    a e() {
        return a.CONTAINED;
    }

    void f(Context context) {
        float fH = this.f12510a;
        if (fH <= 0.0f) {
            fH = d.h(context);
        }
        this.f12510a = fH;
        float fG = this.f12511b;
        if (fG <= 0.0f) {
            fG = d.g(context);
        }
        this.f12511b = fG;
    }

    public abstract e g(InterfaceC0682a interfaceC0682a, View view);

    public abstract boolean h(InterfaceC0682a interfaceC0682a, int i5);
}
