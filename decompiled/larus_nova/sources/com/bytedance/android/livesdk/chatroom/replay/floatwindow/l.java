package com.bytedance.android.livesdk.chatroom.replay.floatwindow;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.android.live.core.utils.s1;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f108668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f108669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f108670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f108671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f108672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f108673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ m f108674g;

    public l(m r100) {
        this.f108674g = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = r101.getAction();
        boolean r103 = true;
        if (r102 != 0) goto L5;
        this.f108674g.f108681g = r101.getRawX();
        this.f108674g.f108682h = r101.getRawY();
        this.f108668a = r101.getRawX();
        this.f108669b = r101.getRawY();
        m r104 = this.f108674g;
        ValueAnimator r105 = r104.f108677c;
        if (r105 != null) goto L72;
    L76:
        this.f108674g.f108690p = s1.w();
        this.f108674g.f108689o = s1.y();
    L78:
        return this.f108674g.f108685k;
    L72:
        if (r105.isRunning() != true) goto L76;
        ValueAnimator r106 = r104.f108677c;
        if (r106 == null) goto L76;
        r106.cancel();
        goto L76
    L5:
        if (r102 == 1) goto L33;
        if (r102 != 2) goto L78;
        this.f108670c = r101.getRawX() - this.f108668a;
        this.f108671d = r101.getRawY() - this.f108669b;
        float r107 = 0;
        if (Math.abs(this.f108670c) <= r107) goto L11;
    L14:
        if (r103 == false) goto L32;
        m r108 = this.f108674g;
        int r109 = (int) (r108.f108679e + this.f108670c);
        this.f108672e = r109;
        this.f108673f = (int) (r108.f108680f + this.f108671d);
        ReplayFloatWindowManager.a r110 = r108.f108694t;
        if (r110.f108639k == false) goto L29;
        int r111 = r110.f108633e;
        if (r109 >= r111) goto L20;
        this.f108672e = r111;
    L20:
        int r112 = this.f108672e;
        int r113 = r108.f108689o - r100.getWidth();
        m r114 = this.f108674g;
        int r115 = r114.f108694t.f108634f;
        if (r112 <= (r113 - r115)) goto L23;
        this.f108672e = (r114.f108689o - r115) - r100.getWidth();
    L23:
        int r116 = this.f108673f;
        this.f108674g.f108694t.getClass();
        if (r116 >= 0) goto L26;
        this.f108674g.f108694t.getClass();
        this.f108673f = 0;
    L26:
        int r117 = this.f108673f;
        int r118 = this.f108674g.f108690p - r100.getHeight();
        this.f108674g.f108694t.getClass();
        if (r117 <= (r118 - 0)) goto L29;
        m r119 = this.f108674g;
        int r120 = r119.f108690p;
        r119.f108694t.getClass();
        this.f108673f = (r120 - 0) - r100.getHeight();
    L29:
        m r121 = this.f108674g;
        if (r121.f108694t.f108632d == 5) goto L32;
        r121.c(this.f108672e, this.f108673f);
    L32:
        this.f108668a = r101.getRawX();
        this.f108669b = r101.getRawY();
        goto L78
    L11:
        if (Math.abs(this.f108671d) > r107) goto L14;
        r103 = false;
        goto L14
    L33:
        this.f108674g.f108683i = r101.getRawX();
        this.f108674g.f108684j = r101.getRawY();
        this.f108674g.f108686l = ViewConfiguration.get(s1.getContext()).getScaledTouchSlop();
        m r122 = this.f108674g;
        float r123 = Math.abs(r122.f108683i - r122.f108681g);
        m r124 = this.f108674g;
        if (r123 <= r124.f108686l) goto L36;
    L39:
        boolean r125 = true;
    L40:
        r122.f108685k = r125;
        m r126 = this.f108674g;
        ReplayFloatWindowManager.a r127 = r126.f108694t;
        int r128 = r127.f108632d;
        if (r128 == 3) goto L54;
        if (r128 != 4) goto L45;
        PropertyValuesHolder r129 = PropertyValuesHolder.ofInt("x", new int[]{r126.f108679e, 0});
        r126.f108694t.getClass();
        ValueAnimator r130 = ObjectAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{r129, PropertyValuesHolder.ofInt("y", new int[]{r126.f108680f, 0})});
        r126.f108677c = r130;
        if (r130 == null) goto L52;
        r130.addUpdateListener(new j(r126));
    L52:
        r126.b();
        goto L78
    L45:
        if (r126.f108685k == true) goto L78;
        a r131 = r127.f108638j;
        if (r131 == null) goto L78;
        r131.onClick();
        goto L78
    L54:
        if (r126.f108685k == false) goto L78;
        int r132 = r126.f108679e;
        if (((r132 * 2) + r100.getWidth()) <= s1.y()) goto L58;
        int r133 = (s1.y() - r100.getWidth()) - r126.f108692r;
    L59:
        int r134 = r126.f108680f;
        if (r134 >= 0) goto L63;
    L65:
        ValueAnimator r135 = ObjectAnimator.ofInt(new int[]{r132, r133});
        r126.f108677c = r135;
        if (r135 == null) goto L68;
        r135.addUpdateListener(new k(r126));
    L68:
        r126.b();
        goto L78
    L63:
        if (r134 <= (s1.w() - 0)) goto L65;
        s1.w();
        goto L65
    L58:
        r133 = r126.f108691q;
        goto L59
    L36:
        if (Math.abs(r124.f108684j - r124.f108682h) > this.f108674g.f108686l) goto L39;
        r125 = false;
        goto L40
    }
}
