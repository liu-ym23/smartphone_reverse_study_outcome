package com.bytedance.android.shopping.commentfeed.viewholder;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.bytedance.android.ec.core.widget.DoubleColorBallStatusView;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentImageVH;", "Lcom/bytedance/android/shopping/commentfeed/viewholder/CommentBaseViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentImageVH extends CommentBaseViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f172383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f172384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoubleColorBallStatusView f172385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f172386e;

    public static final class a implements ControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentImageVH f172387a;

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageFailed(String r100, Throwable r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onRelease(String r100) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
        }

        public a(CommentImageVH r100) {
            this.f172387a = r100;
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r100, ImageInfo r101) {
        }

        @Override // com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, ImageInfo r101, Animatable r102) {
            this.f172387a.f172385d.a();
        }
    }

    public CommentImageVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f172383b = r100.findViewById(R.id.ec_comment_image_rootview);
        this.f172384c = (SimpleDraweeView) r100.findViewById(R.id.ec_commerce_comment_sv_image);
        this.f172385d = (DoubleColorBallStatusView) r100.findViewById(R.id.ec_commerce_comment_image_loading);
        this.f172386e = new a(this);
    }
}
