package com.alibaba.gaiax.render.view.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/render/view/drawable/GXBlurBitmapDrawable;", "Landroid/graphics/drawable/BitmapDrawable;", "res", "Landroid/content/res/Resources;", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXBlurBitmapDrawable extends BitmapDrawable {
    public GXBlurBitmapDrawable(Resources r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, "res");
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        super(r100, r101);
    }
}
