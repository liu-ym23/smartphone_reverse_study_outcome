package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ImageExtensionsKt$asGeckoBitmap$1 extends Lambda implements Function1<byte[], Unit> {
    final /* synthetic */ Function1 $bmpCB;

    public ImageExtensionsKt$asGeckoBitmap$1(Function1 r100) {
        this.$bmpCB = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(byte[] r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(byte[] r100) {
        Function1 r101 = this.$bmpCB;
        if (r100 == null) goto L5;
        Bitmap r102 = BitmapFactory.decodeByteArray(r100, 0, r100.length);
    L6:
        r101.invoke(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
