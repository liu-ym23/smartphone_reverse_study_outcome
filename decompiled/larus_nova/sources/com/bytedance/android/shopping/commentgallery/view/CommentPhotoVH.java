package com.bytedance.android.shopping.commentgallery.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cc3.b;
import cc3.h;
import cc3.k;
import cc3.l;
import com.bytedance.android.shopping.gallery2.PhotoVH;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/commentgallery/view/CommentPhotoVH;", "Lcom/bytedance/android/shopping/gallery2/PhotoVH;", "Lcc3/l;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentPhotoVH extends PhotoVH implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f172548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f172549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f172550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f172551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f172552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f172553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f172554j;

    @Override // cc3.l
    public final void onPageSelected(int r100) {
        b r101 = this.f172553i;
        if (r101 == null) goto L11;
        k r102 = r101.f23227o;
        if (r102 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r102.f23243e, "pic") == false) goto L9;
        r102.f23246h = r100;
    L9:
        t53.b r103 = t53.b.f544622a;
        Context r104 = this.f172554j.getContext();
        r103.getClass();
        t53.b.d(r104, r102);
        return;
    }

    public CommentPhotoVH(View r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        super(r101);
        this.f172554j = r100;
        this.f172548d = r101.findViewById(R.id.ec_old_place_holder_view);
        View r102 = r101.findViewById(R.id.ec_new_place_holder_view);
        this.f172549e = r102;
        this.f172550f = 1.0f;
        this.f172551g = 1.0f;
        this.f176147a.setDoubleClickScaleEnabled(true);
        this.f176147a.setTranslationEnabled(true);
        this.f176147a.setSingleTagDismissEnabled(true);
        this.f176147a.setScaleEnabled(true);
        this.f176147a.setMaxScaleFactor(2.0f);
        TransitionPhotoDraweeView r103 = this.f176147a;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r104 = null;
    L5:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 == null) goto L8;
        r105.bottomMargin = (int) UIUtils.dip2Px(r101.getContext(), 66.0f);
        r103.setLayoutParams(r105);
    L8:
        TransitionPhotoDraweeView r106 = this.f176147a;
        h r107 = this.f172552h;
        if (r107 != null) goto L12;
        r107 = new h(this);
        this.f172552h = r107;
    L12:
        r106.addTransitionListener(r107);
        r102.setVisibility(0);
    }
}
