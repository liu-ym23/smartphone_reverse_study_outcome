package com.bytedance.android.live.profile.ui.component;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.p0;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes47.dex */
public final class t implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f86785a;

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void b(py.k r100, Exception r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void d(ImageInfo r100) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void e(py.k r100) {
    }

    public t(s r100) {
        this.f86785a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void c(py.k r100, int r101, int r102, boolean r103) {
        s r104 = this.f86785a;
        int r105 = r104.f86780o + 1;
        r104.f86780o = r105;
        if (r105 != r104.f86779n) goto L6;
        r104.f86776k.set(true);
        this.f86785a.getClass();
        return;
    }
}
