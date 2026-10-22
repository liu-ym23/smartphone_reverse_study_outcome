package com.obric.oui.orecyclerview.widget;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Interpolator f15696a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Interpolator f15697b = null;

    public class a implements Interpolator {
        public a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            return (((r10 * r10) * r10) * r10) * r10;
        }
    }

    public class b implements Interpolator {
        public b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            float r11 = r10 - 1.0f;
            return ((((r11 * r11) * r11) * r11) * r11) + 1.0f;
        }
    }

    static {
        f15696a = new a();
        f15697b = new b();
    }
}
