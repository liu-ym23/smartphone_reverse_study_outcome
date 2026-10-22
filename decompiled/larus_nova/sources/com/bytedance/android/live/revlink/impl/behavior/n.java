package com.bytedance.android.live.revlink.impl.behavior;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.p0;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes47.dex */
public final class n implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f92181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f92182b;

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void b(py.k r100, Exception r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void c(py.k r100, int r101, int r102, boolean r103) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void d(ImageInfo r100) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void e(py.k r100) {
    }

    public n(m0 r100, f r101) {
        this.f92181a = r100;
        this.f92182b = r101;
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void a(ImageInfo r100, Animatable r101) {
        if ((r101 instanceof AnimatedDrawable2) == true) goto L5;
        r101 = null;
    L5:
        AnimatedDrawable2 r102 = (AnimatedDrawable2) r101;
        this.f92181a.a();
        if (r102 == null) goto L11;
        AnimationBackend r103 = r102.getAnimationBackend();
        if (r103 == null) goto L11;
        r102.setAnimationBackend(new g(r103));
    L11:
        if (r102 == null) goto L13;
        int r104 = r102.getFrameCount();
    L14:
        if (r102 == null) goto L16;
        r102.setAnimationListener(new l(this, r104, r102));
    L16:
        f r105 = this.f92182b;
        r105.sendMessageDelayed(r105.obtainMessage(1, new m(this, r102)), ((Number) o.f92184b.getValue(null, o.f92183a[0])).longValue());
        return;
    L13:
        r104 = 0;
        goto L14
    }
}
