package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import android.animation.AnimatorSet;
import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.livesdk.vs.LiveBlurAnimView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f117932e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public py.k f117933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f117934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wr1.b f117935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnimatorSet f117936d;

    public static final class a {
    }

    static {
    }

    public g() {
    }

    private final Context getContext() {
        FrameLayout r100 = this.f117934b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContext();
    }

    public final void b() {
        AnimatorSet r100 = this.f117936d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRunning() != true) goto L11;
        AnimatorSet r101 = this.f117936d;
        if (r101 == null) goto L12;
        r101.cancel();
        return;
    L12:
        return;
    }

    public final void a(py.k r100, FrameLayout r101, int r102, ImageView.ScaleType r103) {
        Intrinsics.checkNotNullParameter(r103, "scaleType");
        this.f117933a = r100;
        this.f117934b = r101;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f117935c != null) goto L8;
        yr1.d r104 = r.d();
        Context r105 = getContext();
        Intrinsics.checkNotNull(r105);
        this.f117935c = r104.j(r105);
    L8:
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-1, -1);
        r106.gravity = 17;
        wr1.b r107 = this.f117935c;
        if (r107 == null) goto L13;
        LiveBlurAnimView r108 = r107.getView();
        if (r108 == null) goto L13;
        r108.setLayoutParams(r106);
        r108.setVisibility(0);
    L13:
        wr1.b r109 = this.f117935c;
        if (r109 != null) goto L16;
    L56:
        wr1.b r110 = this.f117935c;
        if (r110 == null) goto L60;
        r110.a(this.f117933a, r102, r103);
    L60:
        if (this.f117933a == null) goto L70;
        b();
        wr1.b r111 = this.f117935c;
        if (r111 == null) goto L68;
        LiveBlurAnimView r112 = r111.getView();
        if (r112 == null) goto L69;
        r112.setVisibility(0);
        r112.setAlpha(1.0f);
        return;
    L69:
        return;
    L68:
        return;
    L70:
        return;
    L16:
        if (this.f117934b == null) goto L56;
        LiveBlurAnimView r113 = r109.getView();
        if (r113 == null) goto L21;
        r113.setVisibility(8);
    L21:
        wr1.b r114 = this.f117935c;
        LiveBlurAnimView r115 = null;
        if (r114 == null) goto L26;
        LiveBlurAnimView r116 = r114.getView();
        if (r116 == null) goto L26;
        ViewParent r117 = r116.getParent();
    L28:
        if ((r117 instanceof ViewGroup) == true) goto L30;
        r117 = null;
    L30:
        ViewGroup r118 = (ViewGroup) r117;
        if (r118 == null) goto L37;
        wr1.b r119 = this.f117935c;
        if (r119 == null) goto L35;
        LiveBlurAnimView r120 = r119.getView();
    L36:
        r118.removeView(r120);
        goto L37
    L35:
        r120 = null;
    L37:
        FrameLayout r121 = this.f117934b;
        if (r121 == null) goto L56;
        wr1.b r122 = this.f117935c;
        if (r122 == null) goto L42;
        LiveBlurAnimView r123 = r122.getView();
    L44:
        if (r121.indexOfChild(r123) >= 0) goto L56;
        wr1.b r124 = this.f117935c;
        if (r124 == null) goto L50;
        LiveBlurAnimView r125 = r124.getView();
        if (r125 == null) goto L50;
        r125.setVisibility(0);
    L50:
        FrameLayout r126 = this.f117934b;
        if (r126 == null) goto L56;
        wr1.b r127 = this.f117935c;
        if (r127 == null) goto L55;
        r115 = r127.getView();
    L55:
        r126.addView(r115);
        goto L56
    L42:
        r123 = null;
    L26:
        r117 = null;
        goto L28
    }
}
