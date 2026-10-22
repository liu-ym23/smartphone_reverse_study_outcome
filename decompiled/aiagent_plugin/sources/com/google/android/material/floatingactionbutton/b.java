package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.core.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BaseMotionStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f13401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExtendedFloatingActionButton f13402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<Animator.AnimatorListener> f13403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f13404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.google.android.material.animation.c f13405e;
    private com.google.android.material.animation.c f;

    static /* synthetic */ ExtendedFloatingActionButton a(b r0) {
        return r0.f13402b;
    }

    b(ExtendedFloatingActionButton r3, a r4) {
        this.f13403c = new ArrayList();
        this.f13402b = r3;
        this.f13401a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f13404d = r4;
    }

    @Override // com.google.android.material.floatingactionbutton.c
    public final void a(com.google.android.material.animation.c r1) {
        this.f = r1;
    }

    public final com.google.android.material.animation.c a() {
        com.google.android.material.animation.c r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.f13405e != null) goto L9;
        this.f13405e = com.google.android.material.animation.c.a(this.f13401a, h());
    L9:
        return (com.google.android.material.animation.c) ZeusTransformUtils.preCheckCast(g.a(this.f13405e), com.google.android.material.animation.c.class, "com.obric.aiagent.plugin");
    }

    @Override // com.google.android.material.floatingactionbutton.c
    public final void a(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        this.f13403c.add(r4);
    }

    @Override // com.google.android.material.floatingactionbutton.c
    public final void b(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        this.f13403c.remove(r4);
    }

    @Override // com.google.android.material.floatingactionbutton.c
    public final List<Animator.AnimatorListener> b() {
        return this.f13403c;
    }

    @Override // com.google.android.material.floatingactionbutton.c
    public com.google.android.material.animation.c c() {
        return this.f;
    }

    @Override // com.google.android.material.floatingactionbutton.c
    public void a(Animator r1) {
        this.f13404d.a(r1);
    }

    @Override // com.google.android.material.floatingactionbutton.c
    public void d() {
        this.f13404d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.c
    public void e() {
        this.f13404d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.c
    public AnimatorSet f() {
        return b(a());
    }

    AnimatorSet b(com.google.android.material.animation.c r7) {
        ArrayList r0 = new ArrayList();
        if (r7.c("opacity") == false) goto L6;
        r0.add(r7.a("opacity", this.f13402b, View.ALPHA));
    L6:
        if (r7.c("scale") == false) goto L9;
        r0.add(r7.a("scale", this.f13402b, View.SCALE_Y));
        r0.add(r7.a("scale", this.f13402b, View.SCALE_X));
    L9:
        if (r7.c("width") == false) goto L12;
        r0.add(r7.a("width", this.f13402b, ExtendedFloatingActionButton.WIDTH));
    L12:
        if (r7.c("height") == false) goto L15;
        r0.add(r7.a("height", this.f13402b, ExtendedFloatingActionButton.HEIGHT));
    L15:
        if (r7.c("paddingStart") == false) goto L18;
        r0.add(r7.a("paddingStart", this.f13402b, ExtendedFloatingActionButton.PADDING_START));
    L18:
        if (r7.c("paddingEnd") == false) goto L21;
        r0.add(r7.a("paddingEnd", this.f13402b, ExtendedFloatingActionButton.PADDING_END));
    L21:
        if (r7.c("labelOpacity") == false) goto L23;
        final Class<Float> r4 = Float.class;
        final String r5 = "LABEL_OPACITY_PROPERTY";
        r0.add(r7.a("labelOpacity", this.f13402b, new BaseMotionStrategy$1(this, r4, r5)));
    L23:
        AnimatorSet r6 = new AnimatorSet();
        com.google.android.material.animation.b.a(r6, r0);
        return r6;
    }
}
