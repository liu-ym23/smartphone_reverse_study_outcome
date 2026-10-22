package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.RequestManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PreloadTarget.java */
/* JADX INFO: loaded from: classes.dex */
public final class g<Z> extends c<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f3970a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RequestManager f3971b;

    @Override // com.bumptech.glide.request.target.i
    public void c(Drawable r1) {
    }

    static {
        f3970a = new Handler(Looper.getMainLooper(), new PreloadTarget$1());
    }

    @Override // com.bumptech.glide.request.target.i
    public void a(Z r2, com.bumptech.glide.request.a.b<? super Z> r3) {
        com.bumptech.glide.request.a.b r4 = (com.bumptech.glide.request.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.a.b.class, "com.obric.aiagent.plugin");
        f3970a.obtainMessage(1, this).sendToTarget();
    }

    void b() {
        this.f3971b.clear(this);
    }
}
