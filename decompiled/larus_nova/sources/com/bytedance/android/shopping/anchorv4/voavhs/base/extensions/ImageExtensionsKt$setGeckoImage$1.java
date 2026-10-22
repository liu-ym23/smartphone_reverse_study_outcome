package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import android.graphics.Bitmap;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ImageExtensionsKt$setGeckoImage$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ SimpleDraweeView $this_setGeckoImage;

    public ImageExtensionsKt$setGeckoImage$1(SimpleDraweeView r100) {
        this.$this_setGeckoImage = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bitmap r100) {
        this.$this_setGeckoImage.setImageBitmap(r100);
    }
}
