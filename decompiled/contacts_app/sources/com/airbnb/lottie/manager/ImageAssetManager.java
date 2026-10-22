package com.airbnb.lottie.manager;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ImageAssetManager {
    private static final Object bitmapHashLock = null;
    private final Context context;
    private ImageAssetDelegate delegate;
    private final Map<String, LottieImageAsset> imageAssets;
    private final String imagesFolder;

    static {
        bitmapHashLock = new Object();
    }

    public ImageAssetManager(Drawable.Callback r3, String r4, ImageAssetDelegate r5, Map<String, LottieImageAsset> r6) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L7:
        this.imagesFolder = r4;
    L8:
        this.imageAssets = r6;
        setDelegate(r5);
        if ((r3 instanceof View) == true) goto L12;
        this.context = null;
        return;
    L12:
        this.context = ((View) r3).getContext().getApplicationContext();
        return;
    L5:
        if (r4.charAt(r4.length() - 1) == '/') goto L7;
        this.imagesFolder = r4 + '/';
        goto L8
    }

    public void setDelegate(ImageAssetDelegate r1) {
        this.delegate = r1;
    }

    public Bitmap updateBitmap(String r2, Bitmap r3) {
        if (r3 != null) goto L5;
        LottieImageAsset r1 = this.imageAssets.get(r2);
        Bitmap r4 = r1.getBitmap();
        r1.setBitmap(null);
        return r4;
    L5:
        Bitmap r0 = this.imageAssets.get(r2).getBitmap();
        putBitmap(r2, r3);
        return r0;
    }

    public LottieImageAsset getImageAssetById(String r1) {
        return this.imageAssets.get(r1);
    }

    public Bitmap bitmapForId(String r8) {
        LottieImageAsset r0 = this.imageAssets.get(r8);
        if (r0 != null) goto L5;
        return null;
    L5:
        Bitmap r2 = r0.getBitmap();
        if (r2 == null) goto L8;
        return r2;
    L8:
        ImageAssetDelegate r3 = this.delegate;
        if (r3 == null) goto L14;
        Bitmap r1 = r3.fetchBitmap(r0);
        if (r1 == null) goto L13;
        putBitmap(r8, r1);
    L13:
        return r1;
    L14:
        Context r4 = this.context;
        if (r4 != null) goto L17;
        return null;
    L17:
        String r5 = r0.getFileName();
        BitmapFactory.Options r6 = new BitmapFactory.Options();
        r6.inScaled = true;
        r6.inDensity = 160;
        if (r5.startsWith("data:") == true) goto L20;
    L49:
    L42:
        e = move-exception;
        Logger.warning("Unable to open asset.", e);
        return null;
    L29:
        if (TextUtils.isEmpty(this.imagesFolder) == true) goto L41;
        Bitmap r7 = BitmapFactory.decodeStream(r4.getAssets().open(this.imagesFolder + r5), null, r6);     // Catch: IllegalArgumentException -> L37
        if (r7 != null) goto L36;
        Logger.warning("Decoded image `" + r8 + "` is null.");
        return null;
    L36:
        return putBitmap(r8, Utils.resizeBitmapIfNeeded(r7, r0.getWidth(), r0.getHeight()));
    L37:
        e = move-exception;
        Logger.warning("Unable to decode image `" + r8 + "`.", e);
        return null;
    L41:
        throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");     // Catch: IOException -> L42
    L20:
        if (r5.indexOf("base64,") <= 0) goto L49;
        byte[] r9 = Base64.decode(r5.substring(r5.indexOf(44) + 1), 0);     // Catch: IllegalArgumentException -> L25
        return putBitmap(r8, BitmapFactory.decodeByteArray(r9, 0, r9.length, r6));
    L25:
        e = move-exception;
        Logger.warning("data URL did not have correct base64 format.", e);
        return null;
    }

    public boolean hasSameContext(Context r2) {
        if ((this.context instanceof Application) == false) goto L6;
        r2 = r2.getApplicationContext();
    L6:
        if (r2 != this.context) goto L8;
        return true;
    L8:
        return false;
    }

    private Bitmap putBitmap(String r2, Bitmap r3) {
        Object r0 = bitmapHashLock;
        monitor-enter(r0);
        this.imageAssets.get(r2).setBitmap(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }
}
