package com.bytedance.android.ec.core.gallery2.opt;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/opt/PhotoVHV2;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoVHV2 extends TransitionViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransitionPhotoDraweeView f44071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECStatusView f44072b;

    public static final class a extends BaseControllerListener<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoVHV2 f44073a;

        public a(PhotoVHV2 r100) {
            this.f44073a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            super.onFailure(r100, r101);
            ECStatusView r102 = this.f44073a.f44072b;
            r102.setVisibility(0);
            oj.b r103 = r102.f46000a;
            if (r103 == null) goto L6;
            r103.e();
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
            super.onSubmit(r100, r101);
            this.f44073a.f44072b.c();
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            super.onFinalImageSet(r100, r101, r102);
            this.f44073a.f44072b.a();
        }
    }

    public PhotoVHV2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        TransitionPhotoDraweeView r101 = (TransitionPhotoDraweeView) r100.findViewById(R.id.photo_view);
        this.f44071a = r101;
        ECStatusView r102 = (ECStatusView) r100.findViewById(R.id.ec_status_view);
        this.f44072b = r102;
        r102.a();
        r102.b(r100.getContext(), null, null);
        r101.setControllerListener(new a(this));
    }
}
