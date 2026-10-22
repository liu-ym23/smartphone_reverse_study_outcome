package com.bytedance.android.debug;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DebugGiftPreviewDebugWidget f42620a;

    public g(DebugGiftPreviewDebugWidget r100) {
        this.f42620a = r100;
    }

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

    @Override // com.bytedance.android.live.core.utils.p0
    public final void c(py.k r100, int r101, int r102, boolean r103) {
        if (r101 == 0) goto L20;
        if (r102 == 0) goto L21;
        HSImageView r104 = this.f42620a.f42581g;
        if (r104 == null) goto L7;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L8:
        HSImageView r106 = this.f42620a.f42581g;
        if (r106 == null) goto L11;
        int r107 = r106.getWidth();
    L12:
        if (r105 == null) goto L14;
        r105.height = (int) ((r107 / r101) * r102);
    L14:
        if (r105 == null) goto L16;
        r105.width = r107;
    L16:
        HSImageView r108 = this.f42620a.f42581g;
        if (r108 == null) goto L22;
        r108.setLayoutParams(r105);
        return;
    L22:
        return;
    L11:
        r107 = 0;
        goto L12
    L7:
        r105 = null;
        goto L8
    L21:
        return;
    }
}
