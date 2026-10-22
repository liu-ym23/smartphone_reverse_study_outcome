package com.bytedance.android.ui.ec.widget.ecdraweeview;

import android.graphics.drawable.Animatable;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"com/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView$controllerListener$1", "Lcom/facebook/drawee/controller/BaseControllerListener;", "", "onFinalImageSet", "", "id", "", "imageInfo", "animatable", "Landroid/graphics/drawable/Animatable;", "onIntermediateImageSet", "onRelease", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECDraweeView$controllerListener$1 extends BaseControllerListener<Object> {
    final /* synthetic */ ECDraweeView this$0;

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onRelease(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
    }

    public ECDraweeView$controllerListener$1(ECDraweeView r100) {
        this.this$0 = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        super.onIntermediateImageSet(r100, r101);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String r100, Object r101, Animatable r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if (this.this$0.getAutoPlayAnimation() == true) goto L6;
        if (r102 == null) goto L6;
        r102.stop();
    L6:
        ECDraweeView r103 = this.this$0;
        if ((r101 instanceof ImageInfo) == true) goto L9;
        r101 = null;
    L9:
        r103.setImageInfo((ImageInfo) r101);
        if (this.this$0.getAdjustMode() != 0) goto L12;
        return;
    L12:
        if (ViewCompat.isInLayout(this.this$0) == false) goto L14;
        this.this$0.post(new ECDraweeView$controllerListener$1$onFinalImageSet$1(this));
        return;
    L14:
        this.this$0.requestLayout();
    }
}
