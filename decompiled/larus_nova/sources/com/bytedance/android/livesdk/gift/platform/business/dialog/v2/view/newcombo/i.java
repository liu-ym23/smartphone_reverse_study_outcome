package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.nova.R;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComboProgressAnimationViewNew f126866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f126867b;

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void a(ImageInfo r100, Animatable r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void b(py.k r100, Exception r101) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void d(ImageInfo r100) {
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final /* synthetic */ void e(py.k r100) {
    }

    public i(ComboProgressAnimationViewNew r100) {
        this.f126866a = r100;
        this.f126867b = true;
    }

    @Override // com.bytedance.android.live.core.utils.p0
    public final void c(py.k r100, int r101, int r102, boolean r103) {
        HSImageView r104 = this.f126866a.f126763x;
        ViewGroup.LayoutParams r105 = null;
        if (r104 == null) goto L5;
        ViewGroup.LayoutParams r106 = r104.getLayoutParams();
    L7:
        if ((r106 instanceof ViewGroup.LayoutParams) == false) goto L19;
        float r107 = r101 / r102;
        HSImageView r108 = this.f126866a.f126763x;
        if (r108 == null) goto L11;
        r105 = r108.getLayoutParams();
    L11:
        if (r105 == null) goto L13;
        r105.height = (int) this.f126866a.getContext().getResources().getDimension(R.dimen.ttlive_gift_combo_hint_view_height_new);
    L13:
        if (r105 == null) goto L15;
        r105.width = (int) (r105.height * r107);
    L15:
        HSImageView r109 = this.f126866a.f126763x;
        if (r109 == null) goto L19;
        r109.setLayoutParams(r105);
    L19:
        if (b02.a.e() == true) goto L28;
        if ((new SecureRandom().nextInt(10) % 2) != 0) goto L23;
        float r110 = -5.0f;
    L24:
        HSImageView r111 = this.f126866a.f126763x;
        if (r111 == null) goto L28;
        r111.setRotation(r110);
        goto L28
    L23:
        r110 = 5.0f;
    L28:
        if (this.f126867b == false) goto L31;
        ComboProgressAnimationViewNew.a(this.f126866a, false, false);
        return;
    L31:
        return;
    L5:
        r106 = null;
        goto L7
    }
}
