package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc;

import android.view.View;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f116641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f116642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f116643c;

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStart(AnimatedDrawable2 r100) {
        this.f116641a = -1;
        View r101 = this.f116642b.f116644a.f116629g;
        if (r101 == null) goto L6;
        r101.setBackground(null);
        return;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        OgcVSWebActivityBehavior r101 = this.f116642b.f116644a;
        View r102 = r101.f116629g;
        if (r102 == null) goto L5;
        r102.setBackground(r101.f116630h);
    L5:
        this.f116642b.f116645b.setVisibility(8);
    }

    public b(c r100, int r101) {
        this.f116642b = r100;
        this.f116643c = r101;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        int r102 = this.f116641a;
        if (r102 == 0) goto L5;
    L6:
        if (r102 > r101) goto L8;
        this.f116641a = r101;
        return;
    L8:
        if (r100 == null) goto L10;
        r100.stop();
    L10:
        this.f116642b.f116645b.setVisibility(8);
        this.f116642b.f116645b.setController(null);
        return;
    L5:
        if (this.f116643c <= 1) goto L8;
        goto L6
    }
}
