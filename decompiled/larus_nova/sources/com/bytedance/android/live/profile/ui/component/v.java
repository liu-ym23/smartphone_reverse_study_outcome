package com.bytedance.android.live.profile.ui.component;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes47.dex */
public final class v implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f86787a;

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void d(ImageInfo r100) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void e(py.k r100) {
    }

    public v(s r100) {
        this.f86787a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void b(py.k r100, Exception r101) {
        int r102 = s.f86765t;
        ALogger.e("ProfileShopComponent", "heartDiamondInfo load failed, imageModel is ".concat(String.valueOf(r100)));
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void c(py.k r100, int r101, int r102, boolean r103) {
        HSImageView r104 = this.f86787a.f86775j;
        if (r104 == null) goto L5;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L6:
        if (r105 == null) goto L8;
        r105.width = r101;
    L8:
        if (r105 == null) goto L10;
        r105.height = r102;
    L10:
        HSImageView r106 = this.f86787a.f86775j;
        if (r106 == null) goto L13;
        r106.setLayoutParams(r105);
    L13:
        this.f86787a.f86777l.set(true);
        this.f86787a.getClass();
        return;
    L5:
        r105 = null;
        goto L6
    }
}
