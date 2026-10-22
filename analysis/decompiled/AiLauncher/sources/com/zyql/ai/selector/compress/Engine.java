package com.zyql.ai.selector.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.tools.BitmapUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
class Engine {
    private static final int DEFAULT_QUALITY = 80;
    private int compressQuality;
    private final Context context;

    @Deprecated
    private final boolean focusAlpha;
    private final boolean isAutoRotating;
    private int srcHeight;
    private final InputStreamProvider srcImg;
    private int srcWidth;
    private final File tagImg;

    public Engine(Context context, InputStreamProvider inputStreamProvider, File file, boolean z10, int i10, boolean z11) throws IOException {
        this.tagImg = file;
        this.srcImg = inputStreamProvider;
        this.context = context;
        this.focusAlpha = z10;
        this.isAutoRotating = z11;
        this.compressQuality = i10 <= 0 ? 80 : i10;
        if (inputStreamProvider.getMedia().getWidth() > 0 && inputStreamProvider.getMedia().getHeight() > 0) {
            this.srcWidth = inputStreamProvider.getMedia().getWidth();
            this.srcHeight = inputStreamProvider.getMedia().getHeight();
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeStream(inputStreamProvider.open(), null, options);
        this.srcWidth = options.outWidth;
        this.srcHeight = options.outHeight;
    }

    private int computeSize() {
        int i10 = this.srcWidth;
        if (i10 % 2 == 1) {
            i10++;
        }
        this.srcWidth = i10;
        int i11 = this.srcHeight;
        if (i11 % 2 == 1) {
            i11++;
        }
        this.srcHeight = i11;
        int iMax = Math.max(i10, i11);
        float fMin = Math.min(this.srcWidth, this.srcHeight) / iMax;
        if (fMin > 1.0f || fMin <= 0.5625d) {
            double d10 = fMin;
            if (d10 > 0.5625d || d10 <= 0.5d) {
                return (int) Math.ceil(iMax / (1280.0d / d10));
            }
            int i12 = iMax / 1280;
            if (i12 == 0) {
                return 1;
            }
            return i12;
        }
        if (iMax < 1664) {
            return 1;
        }
        if (iMax < 4990) {
            return 2;
        }
        if (iMax <= 4990 || iMax >= 10240) {
            return iMax / 1280;
        }
        return 4;
    }

    public File compress() throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = computeSize();
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.srcImg.open(), null, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.isAutoRotating && Checker.SINGLE.isJPG(this.srcImg.getMedia().getMimeType())) {
            String path = (!this.srcImg.getMedia().isCut() || TextUtils.isEmpty(this.srcImg.getMedia().getCutPath())) ? this.srcImg.getMedia().getPath() : this.srcImg.getMedia().getCutPath();
            int pictureDegree = PictureMimeType.isContent(path) ? BitmapUtils.readPictureDegree(this.srcImg.open()) : BitmapUtils.readPictureDegree(this.context, path);
            if (pictureDegree > 0) {
                bitmapDecodeStream = BitmapUtils.rotatingImage(bitmapDecodeStream, pictureDegree);
            }
        }
        if (bitmapDecodeStream == null) {
            return null;
        }
        int i10 = this.compressQuality;
        if (i10 <= 0 || i10 > 100) {
            i10 = 80;
        }
        this.compressQuality = i10;
        bitmapDecodeStream.compress((this.focusAlpha || bitmapDecodeStream.hasAlpha()) ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, this.compressQuality, byteArrayOutputStream);
        bitmapDecodeStream.recycle();
        FileOutputStream fileOutputStream = new FileOutputStream(this.tagImg);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        return this.tagImg;
    }
}
