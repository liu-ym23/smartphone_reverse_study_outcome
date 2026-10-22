package com.bytedance.android.ec.core.imagex.opt;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeBitmapConfigStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m extends ImageDecodeBitmapConfigStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageDecodeBitmapConfigStrategy f44871a;

    public m(ImageDecodeBitmapConfigStrategy r100) {
        this.f44871a = r100;
    }

    @Override // com.facebook.imagepipeline.common.ImageDecodeBitmapConfigStrategy
    public final Bitmap.Config getBitmapConfig(String r110, int r111, int r112, int r113, int r114, boolean r115, ImageFormat r116) {
        boolean r100 = false;
        Uri r101 = UriProtector.parse(r110);     // Catch: Exception -> L8
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r101, "from_ec_image_loaded"), "1") == false) goto L9;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r101, "ec_rgb565"), "1") == false) goto L9;
        r100 = true;
    L9:
        if (r100 == false) goto L12;
        return ImageDecodeBitmapConfigStrategy.MEMORY_AT_LEAST.getBitmapConfig(r110, r111, r112, r113, r114, r115, r116);
    L12:
        return this.f44871a.getBitmapConfig(r110, r111, r112, r113, r114, r115, r116);
    }
}
