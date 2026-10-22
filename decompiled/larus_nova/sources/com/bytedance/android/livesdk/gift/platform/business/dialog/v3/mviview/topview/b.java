package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftMVIActivityTopView f128116a;

    public b(GiftMVIActivityTopView r100) {
        this.f128116a = r100;
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
        if (r101 == 0) goto L17;
        if (r102 == 0) goto L18;
        HSImageView r104 = this.f128116a.f127981o;
        if (r104 == null) goto L7;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L8:
        int r106 = (int) com.bytedance.android.live.revenue.common.i.a(15);
        if (r105 == null) goto L11;
        r105.height = r106;
    L11:
        if (r105 == null) goto L13;
        r105.width = (int) ((r106 / r102) * r101);
    L13:
        HSImageView r107 = this.f128116a.f127981o;
        if (r107 == null) goto L19;
        r107.setLayoutParams(r105);
        return;
    L19:
        return;
    L7:
        r105 = null;
        goto L8
    L18:
        return;
    }
}
