package com.bytedanceos.common.tangram.bouncy;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;

/* JADX INFO: loaded from: classes2.dex */
public class SpringScroller extends SimpleSpringListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SpringConfig f9918d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Spring f9919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Spring f9920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SpringScrollerListener f9921c;

    public interface SpringScrollerListener {
        void onSpringAtRest();

        void onSpringUpdate(int r10, int r11);
    }

    static {
        f9918d = new SpringConfig(1000.0d, 200.0d);
    }

    public SpringScroller(double r10, double r11, SpringScrollerListener r12) {
        SpringSystem r13 = SpringSystem.create();
        if (r10 >= 0.0d) goto L5;
    L8:
        SpringConfig r14 = f9918d;
    L9:
        Spring r15 = r13.createSpring().setSpringConfig(r14);
        this.f9919a = r15;
        Spring r16 = r13.createSpring().setSpringConfig(r14);
        this.f9920b = r16;
        r15.addListener(this);
        r16.addListener(this);
        this.f9921c = r12;
        return;
    L5:
        if (r11 < 0.0d) goto L8;
        r14 = new SpringConfig(r10, r11);
        goto L9
    }

    public int a() {
        return (int) Math.round(this.f9919a.getCurrentValue());
    }

    public int b() {
        return (int) Math.round(this.f9920b.getCurrentValue());
    }

    public boolean c() {
        if (this.f9919a.isAtRest() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f9920b.isAtRest() == false) goto L7;
        return true;
    }

    public void d(int r10, int r11) {
        this.f9919a.setCurrentValue(r10);
        this.f9920b.setCurrentValue(r11);
        this.f9919a.setEndValue(0.0d);
        this.f9920b.setEndValue(0.0d);
    }

    public void e() {
        if (this.f9919a.isAtRest() == true) goto L6;
        this.f9919a.setAtRest();
    L6:
        if (this.f9920b.isAtRest() == true) goto L9;
        this.f9920b.setAtRest();
        return;
    }

    @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
    public void onSpringAtRest(Spring r10) {
        if (this.f9921c != null) goto L5;
        return;
    L5:
        if (c() == false) goto L9;
        this.f9921c.onSpringAtRest();
        return;
    }

    @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
    public void onSpringUpdate(Spring r10) {
        SpringScrollerListener r11 = this.f9921c;
        if (r11 == null) goto L6;
        r11.onSpringUpdate(a(), b());
        return;
    }
}
