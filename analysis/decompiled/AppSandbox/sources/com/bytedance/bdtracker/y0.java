package com.bytedance.bdtracker;

import androidx.viewpager.widget.ViewPager;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class y0 implements ViewPager.OnPageChangeListener {
    public int a;
    public int b;
    public final int c;
    public final Function3<Float, Float, Integer, Unit> d;

    /* JADX WARN: Multi-variable type inference failed */
    public y0(int i, Function3<? super Float, ? super Float, ? super Integer, Unit> sendScrollObserveCallback) {
        Intrinsics.checkParameterIsNotNull(sendScrollObserveCallback, "sendScrollObserveCallback");
        this.c = i;
        this.d = sendScrollObserveCallback;
        this.b = -1;
    }

    public void onPageScrollStateChanged(int i) {
        if (i == 0 && Math.abs(this.a) >= this.c) {
            this.d.invoke(Float.valueOf(this.a), Float.valueOf(0.0f), Integer.valueOf(this.a > this.b ? 4 : 3));
            this.a = 0;
            this.b = -1;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (Math.abs(i2) > this.c || Math.abs(0) > this.c) {
            int i3 = this.a;
            this.a = i2 > 0 ? Math.max(i3, i2) : Math.min(i3, i2);
        }
        if (this.b == -1) {
            this.b = this.a;
        }
    }

    public void onPageSelected(int i) {
    }
}
