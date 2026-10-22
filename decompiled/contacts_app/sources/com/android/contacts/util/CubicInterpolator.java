package com.android.contacts.util;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public class CubicInterpolator implements Interpolator {
    public static CubicInterpolator IN;
    public static final CubicInterpolator INOUT = null;
    public static final CubicInterpolator OUT = null;

    public CubicInterpolator() {
    }

    static {
        IN = new AnonymousClass1();
        OUT = new AnonymousClass2();
        INOUT = new AnonymousClass3();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r1) {
        return OUT.getInterpolation(r1);
    }
}
