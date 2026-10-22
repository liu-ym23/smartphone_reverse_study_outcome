package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.f.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CustomTarget.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> implements i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.request.d f3968c;

    @Override // com.bumptech.glide.request.target.i
    public void a(Drawable r1) {
    }

    @Override // com.bumptech.glide.request.target.i
    public void b(Drawable r1) {
    }

    @Override // com.bumptech.glide.request.target.i
    public final void b(h r2) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
    }

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public c(int r3, int r4) {
        if (k.a(r3, r4) == false) goto L7;
        this.f3966a = r3;
        this.f3967b = r4;
        return;
    L7:
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + r3 + " and height: " + r4);
    }

    @Override // com.bumptech.glide.request.target.i
    public final void a(h r3) {
        ((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin")).a(this.f3966a, this.f3967b);
    }

    @Override // com.bumptech.glide.request.target.i
    public final void a(com.bumptech.glide.request.d r3) {
        this.f3968c = (com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.request.target.i
    public final com.bumptech.glide.request.d a() {
        return this.f3968c;
    }
}
