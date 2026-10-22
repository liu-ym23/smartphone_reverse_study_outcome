package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BaseTarget.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class a<Z> implements i<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.request.d f3965a;

    @Override // com.bumptech.glide.request.target.i
    public void a(Drawable r1) {
    }

    @Override // com.bumptech.glide.request.target.i
    public void b(Drawable r1) {
    }

    @Override // com.bumptech.glide.request.target.i
    public void c(Drawable r1) {
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

    public a() {
    }

    @Override // com.bumptech.glide.request.target.i
    public void a(com.bumptech.glide.request.d r3) {
        this.f3965a = (com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.request.target.i
    public com.bumptech.glide.request.d a() {
        return this.f3965a;
    }
}
