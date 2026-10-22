package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.anchor.AnchorTrayPostEffectService;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.scope.m;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import i12.o;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatedDrawable2 f129942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f129943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f129944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f129945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f129946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f129947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f129948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f129949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q02.d f129950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NormalGiftMessage f129951j;

    public static final class a {
    }

    static {
    }

    public final void b() {
        HSImageView r100 = this.f129944c;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        AnimatedDrawable2 r101 = this.f129942a;
        if (r101 == null) goto L8;
        r101.stop();
    L8:
        this.f129942a = null;
        q02.d r102 = this.f129950i;
        if (r102 == null) goto L12;
        r102.b();
        return;
    }

    public final void c() {
        AnimatedDrawable2 r100 = this.f129942a;
        if (r100 == null) goto L5;
        r100.stop();
    L5:
        this.f129942a = null;
        AnimatorSet r101 = this.f129943b;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isRunning() != true) goto L18;
        AnimatorSet r102 = this.f129943b;
        if (r102 == null) goto L12;
        r102.removeAllListeners();
    L12:
        AnimatorSet r103 = this.f129943b;
        if (r103 == null) goto L15;
        r103.cancel();
    L15:
        this.f129943b = null;
        return;
    }

    public static final void a(f r100) {
        r100.getClass();
        i12.e r101 = o.b();
        if (r101 == null) goto L5;
        Object r102 = m.f163449e.d(r101, AnchorTrayPostEffectService.class);
    L6:
        AnchorTrayPostEffectService r103 = (AnchorTrayPostEffectService) r102;
        if (r103 != null) goto L9;
    L12:
        AnimatedDrawable2 r104 = r100.f129942a;
        if (r104 == null) goto L15;
        r104.stop();
    L15:
        r100.f129942a = null;
        q02.d r105 = r100.f129950i;
        if (r105 == null) goto L19;
        r105.b();
        return;
    L19:
        return;
    L9:
        if (com.bytedance.android.livesdk.gift.platform.business.anchor.c.a().b() == false) goto L12;
        r103.f126519a.set(false);
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public f(HSImageView r100, View r101, View r102, View r103, ViewGroup r104, TextView r105, q02.d r106, NormalGiftMessage r107) {
        this.f129944c = r100;
        this.f129945d = r101;
        this.f129946e = r102;
        this.f129947f = r103;
        this.f129948g = r104;
        this.f129949h = r105;
        this.f129950i = r106;
        this.f129951j = r107;
    }
}
