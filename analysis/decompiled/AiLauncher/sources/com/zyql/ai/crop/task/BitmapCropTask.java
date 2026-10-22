package com.zyql.ai.crop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.zyql.ai.crop.callback.BitmapCropCallback;
import com.zyql.ai.crop.model.CropParameters;
import com.zyql.ai.crop.model.ImageState;
import com.zyql.ai.crop.util.BitmapLoadUtils;
import com.zyql.ai.crop.util.ImageHeaderParser;
import com.zyql.ai.selector.PictureContentResolver;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.tools.PictureFileUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {
    private static final String TAG = "BitmapCropTask";
    private int cropOffsetX;
    private int cropOffsetY;
    private Bitmap.CompressFormat mCompressFormat;
    private final int mCompressQuality;
    private final WeakReference<Context> mContextWeakReference;
    private final BitmapCropCallback mCropCallback;
    private final RectF mCropRect;
    private int mCroppedImageHeight;
    private int mCroppedImageWidth;
    private float mCurrentAngle;
    private final RectF mCurrentImageRect;
    private float mCurrentScale;
    private final String mImageInputPath;
    private final String mImageOutputPath;
    private final int mMaxResultImageSizeX;
    private final int mMaxResultImageSizeY;
    private Bitmap mViewBitmap;

    public BitmapCropTask(Context context, Bitmap bitmap, ImageState imageState, CropParameters cropParameters, BitmapCropCallback bitmapCropCallback) {
        this.mContextWeakReference = new WeakReference<>(context);
        this.mViewBitmap = bitmap;
        this.mCropRect = imageState.getCropRect();
        this.mCurrentImageRect = imageState.getCurrentImageRect();
        this.mCurrentScale = imageState.getCurrentScale();
        this.mCurrentAngle = imageState.getCurrentAngle();
        this.mMaxResultImageSizeX = cropParameters.getMaxResultImageSizeX();
        this.mMaxResultImageSizeY = cropParameters.getMaxResultImageSizeY();
        this.mCompressFormat = cropParameters.getCompressFormat();
        this.mCompressQuality = cropParameters.getCompressQuality();
        this.mImageInputPath = cropParameters.getImageInputPath();
        this.mImageOutputPath = cropParameters.getImageOutputPath();
        this.mCropCallback = bitmapCropCallback;
    }

    private boolean crop() throws Throwable {
        ExifInterface exifInterface;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        if (this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0) {
            float fWidth = this.mCropRect.width() / this.mCurrentScale;
            float fHeight = this.mCropRect.height() / this.mCurrentScale;
            int i10 = this.mMaxResultImageSizeX;
            if (fWidth > i10 || fHeight > this.mMaxResultImageSizeY) {
                float fMin = Math.min(i10 / fWidth, this.mMaxResultImageSizeY / fHeight);
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(this.mViewBitmap, Math.round(r2.getWidth() * fMin), Math.round(this.mViewBitmap.getHeight() * fMin), false);
                Bitmap bitmap = this.mViewBitmap;
                if (bitmap != bitmapCreateScaledBitmap) {
                    bitmap.recycle();
                }
                this.mViewBitmap = bitmapCreateScaledBitmap;
                this.mCurrentScale /= fMin;
            }
        }
        if (this.mCurrentAngle != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.mCurrentAngle, this.mViewBitmap.getWidth() / 2, this.mViewBitmap.getHeight() / 2);
            Bitmap bitmap2 = this.mViewBitmap;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.mViewBitmap.getHeight(), matrix, true);
            Bitmap bitmap3 = this.mViewBitmap;
            if (bitmap3 != bitmapCreateBitmap) {
                bitmap3.recycle();
            }
            this.mViewBitmap = bitmapCreateBitmap;
        }
        this.cropOffsetX = Math.round((this.mCropRect.left - this.mCurrentImageRect.left) / this.mCurrentScale);
        this.cropOffsetY = Math.round((this.mCropRect.top - this.mCurrentImageRect.top) / this.mCurrentScale);
        this.mCroppedImageWidth = Math.round(this.mCropRect.width() / this.mCurrentScale);
        int iRound = Math.round(this.mCropRect.height() / this.mCurrentScale);
        this.mCroppedImageHeight = iRound;
        boolean zShouldCrop = shouldCrop(this.mCroppedImageWidth, iRound);
        Log.i(TAG, "Should crop: " + zShouldCrop);
        if (!zShouldCrop) {
            if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(this.mImageInputPath)) {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor2 = getContext().getContentResolver().openFileDescriptor(Uri.parse(this.mImageInputPath), "r");
                PictureFileUtils.copyFile(new FileInputStream(parcelFileDescriptorOpenFileDescriptor2.getFileDescriptor()), this.mImageOutputPath);
                BitmapLoadUtils.close(parcelFileDescriptorOpenFileDescriptor2);
            } else {
                PictureFileUtils.copyFile(this.mImageInputPath, this.mImageOutputPath);
            }
            return false;
        }
        if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(this.mImageInputPath)) {
            parcelFileDescriptorOpenFileDescriptor = getContext().getContentResolver().openFileDescriptor(Uri.parse(this.mImageInputPath), "r");
            exifInterface = new ExifInterface(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()));
        } else {
            exifInterface = new ExifInterface(this.mImageInputPath);
            parcelFileDescriptorOpenFileDescriptor = null;
        }
        saveImage(Bitmap.createBitmap(this.mViewBitmap, this.cropOffsetX, this.cropOffsetY, this.mCroppedImageWidth, this.mCroppedImageHeight));
        if (this.mCompressFormat.equals(Bitmap.CompressFormat.JPEG)) {
            ImageHeaderParser.copyExif(exifInterface, this.mCroppedImageWidth, this.mCroppedImageHeight, this.mImageOutputPath);
        }
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            return true;
        }
        BitmapLoadUtils.close(parcelFileDescriptorOpenFileDescriptor);
        return true;
    }

    private Context getContext() {
        return this.mContextWeakReference.get();
    }

    private void saveImage(Bitmap bitmap) throws IOException {
        Context context = getContext();
        if (context == null) {
            return;
        }
        OutputStream contentResolverOpenOutputStream = null;
        try {
            contentResolverOpenOutputStream = PictureContentResolver.getContentResolverOpenOutputStream(context, Uri.fromFile(new File(this.mImageOutputPath)));
            if (bitmap.hasAlpha()) {
                Bitmap.CompressFormat compressFormat = this.mCompressFormat;
                Bitmap.CompressFormat compressFormat2 = Bitmap.CompressFormat.PNG;
                if (!compressFormat.equals(compressFormat2)) {
                    this.mCompressFormat = compressFormat2;
                }
            }
            bitmap.compress(this.mCompressFormat, this.mCompressQuality, contentResolverOpenOutputStream);
            bitmap.recycle();
            BitmapLoadUtils.close(contentResolverOpenOutputStream);
        } catch (Throwable th) {
            BitmapLoadUtils.close(contentResolverOpenOutputStream);
            throw th;
        }
    }

    private boolean shouldCrop(int i10, int i11) {
        int iRound = Math.round(Math.max(i10, i11) / 1000.0f) + 1;
        if (this.mMaxResultImageSizeX <= 0 || this.mMaxResultImageSizeY <= 0) {
            float f10 = iRound;
            if (Math.abs(this.mCropRect.left - this.mCurrentImageRect.left) <= f10 && Math.abs(this.mCropRect.top - this.mCurrentImageRect.top) <= f10 && Math.abs(this.mCropRect.bottom - this.mCurrentImageRect.bottom) <= f10 && Math.abs(this.mCropRect.right - this.mCurrentImageRect.right) <= f10 && this.mCurrentAngle == 0.0f) {
                return false;
            }
        }
        return true;
    }

    @Override // android.os.AsyncTask
    public Throwable doInBackground(Void... voidArr) {
        Bitmap bitmap = this.mViewBitmap;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.mCurrentImageRect.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            crop();
            this.mViewBitmap = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Throwable th) {
        BitmapCropCallback bitmapCropCallback = this.mCropCallback;
        if (bitmapCropCallback != null) {
            if (th != null) {
                bitmapCropCallback.onCropFailure(th);
            } else {
                this.mCropCallback.onBitmapCropped(Uri.fromFile(new File(this.mImageOutputPath)), this.cropOffsetX, this.cropOffsetY, this.mCroppedImageWidth, this.mCroppedImageHeight);
            }
        }
    }
}
