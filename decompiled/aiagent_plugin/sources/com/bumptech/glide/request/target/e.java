package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e<Z> extends ViewTarget<ImageView, Z> implements com.bumptech.glide.request.a.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Animatable f3969b;

    public abstract void a(Z r1);

    public e(ImageView r1) {
        super(r1);
    }

    public void e(Drawable r3) {
        ((ImageView) ZeusTransformUtils.preCheckCast(this.f3957a, ImageView.class, "com.obric.aiagent.plugin")).setImageDrawable(r3);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.i
    public void a(Drawable r2) {
        super.a(r2);
        b(null);
        e(r2);
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.i
    public void b(Drawable r2) {
        super.b(r2);
        b(null);
        e(r2);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.i
    public void c(Drawable r2) {
        super.c(r2);
        Animatable r0 = this.f3969b;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        b(null);
        e(r2);
    }

    @Override // com.bumptech.glide.request.target.i
    public void a(Z r3, com.bumptech.glide.request.a.b<? super Z> r4) {
        com.bumptech.glide.request.a.b r5 = (com.bumptech.glide.request.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.a.b.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
    L8:
        b(r3);
        return;
    L5:
        if (r5.a(r3, this) == false) goto L8;
        c(r3);
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.manager.i
    public void onStart() {
        Animatable r0 = this.f3969b;
        if (r0 == null) goto L6;
        r0.start();
        return;
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.manager.i
    public void onStop() {
        Animatable r0 = this.f3969b;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    private void b(Z r1) {
        a(r1);
        c(r1);
    }

    private void c(Z r3) {
        if (ZeusTransformUtils.instanceOf(r3, Animatable.class) == false) goto L5;
        Animatable r4 = (Animatable) ZeusTransformUtils.preCheckCast(r3, Animatable.class, "com.obric.aiagent.plugin");
        this.f3969b = r4;
        r4.start();
        return;
    L5:
        this.f3969b = null;
    }
}
