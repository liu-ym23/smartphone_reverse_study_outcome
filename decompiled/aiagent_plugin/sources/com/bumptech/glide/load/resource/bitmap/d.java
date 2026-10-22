package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends com.bumptech.glide.load.resource.a<Bitmap> {
    private static final String TAG = "BitmapImageDecoder";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f3795b;

    public d() {
        this.f3795b = new com.bumptech.glide.load.engine.a.f();
    }

    @Override // com.bumptech.glide.load.resource.a
    public com.bumptech.glide.load.engine.v<Bitmap> a(ImageDecoder.Source r4, int r5, int r6, ImageDecoder.OnHeaderDecodedListener r7) {
        Bitmap r8 = ImageDecoder.decodeBitmap(r4, (ImageDecoder.OnHeaderDecodedListener) ZeusTransformUtils.wrapperContextForParams(r7, ImageDecoder.OnHeaderDecodedListener.class, "com.obric.aiagent.plugin"));
        if (a(TAG, 2) == false) goto L6;
        a(TAG, "Decoded [" + r8.getWidth() + "x" + r8.getHeight() + "] for [" + r5 + "x" + r6 + "]");
    L6:
        return new e(r8, this.f3795b);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
