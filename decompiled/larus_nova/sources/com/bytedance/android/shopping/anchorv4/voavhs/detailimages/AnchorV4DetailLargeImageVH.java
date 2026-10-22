package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.view.View;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailimages/AnchorV4DetailLargeImageVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailLargeImageVH extends TransitionViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f168289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LargeImageView f168290b;

    public static final class a {
    }

    static {
    }

    public AnchorV4DetailLargeImageVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f168290b = (LargeImageView) r100.findViewById(R.id.iv_large_image);
    }
}
