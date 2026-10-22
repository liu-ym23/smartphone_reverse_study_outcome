package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/AnchorV4CustomViewCompatVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CustomViewCompatVH extends TransitionViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f168555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f168556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<View> f168557c;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4CustomViewCompatVH(View r100, List<? extends View> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "viewProvider");
        super(r100);
        this.f168557c = r101;
        this.f168555a = r100.findViewById(R.id.custom_root_view);
        this.f168556b = (ViewGroup) r100.findViewById(R.id.custom_view_holder_layout);
    }
}
