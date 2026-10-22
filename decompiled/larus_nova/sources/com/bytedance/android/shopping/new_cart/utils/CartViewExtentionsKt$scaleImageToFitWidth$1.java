package com.bytedance.android.shopping.new_cart.utils;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"applyMatrix", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class CartViewExtentionsKt$scaleImageToFitWidth$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ImageView $this_scaleImageToFitWidth;

    public CartViewExtentionsKt$scaleImageToFitWidth$1(ImageView r100) {
        this.$this_scaleImageToFitWidth = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Drawable r100 = this.$this_scaleImageToFitWidth.getDrawable();
        if (r100 != null) goto L5;
        return;
    L5:
        float r101 = (this.$this_scaleImageToFitWidth.getWidth() - this.$this_scaleImageToFitWidth.getPaddingLeft()) - this.$this_scaleImageToFitWidth.getPaddingRight();
        float r102 = r100.getIntrinsicWidth();
        if (r102 > 0.0f) goto L8;
        return;
    L8:
        if (r101 <= 0.0f) goto L16;
        float r103 = r101 / r102;
        Matrix r104 = this.$this_scaleImageToFitWidth.getImageMatrix();
        if (r104 != null) goto L13;
        r104 = new Matrix();
    L13:
        r104.reset();
        r104.setScale(r103, r103);
        r104.postTranslate(0.0f, 0.0f);
        this.$this_scaleImageToFitWidth.setImageMatrix(r104);
        return;
    }
}
