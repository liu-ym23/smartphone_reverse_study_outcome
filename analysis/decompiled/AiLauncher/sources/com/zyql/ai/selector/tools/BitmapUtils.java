package com.zyql.ai.selector.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.zyql.ai.selector.PictureContentResolver;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class BitmapUtils {
    public static int readPictureDegree(Context context, String str) {
        ExifInterface exifInterface;
        InputStream contentResolverOpenInputStream = null;
        try {
            try {
                if (PictureMimeType.isContent(str)) {
                    contentResolverOpenInputStream = PictureContentResolver.getContentResolverOpenInputStream(context, Uri.parse(str));
                    exifInterface = new ExifInterface(contentResolverOpenInputStream);
                } else {
                    exifInterface = new ExifInterface(str);
                }
                int attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                if (attributeInt == 3) {
                    PictureFileUtils.close(contentResolverOpenInputStream);
                    return 180;
                }
                if (attributeInt == 6) {
                    PictureFileUtils.close(contentResolverOpenInputStream);
                    return 90;
                }
                if (attributeInt != 8) {
                    PictureFileUtils.close(contentResolverOpenInputStream);
                    return 0;
                }
                PictureFileUtils.close(contentResolverOpenInputStream);
                return SubsamplingScaleImageView.ORIENTATION_270;
            } catch (Exception e10) {
                e10.printStackTrace();
                PictureFileUtils.close(contentResolverOpenInputStream);
                return 0;
            }
        } catch (Throwable th) {
            PictureFileUtils.close(contentResolverOpenInputStream);
            throw th;
        }
    }

    public static void rotateImage(Context context, boolean z10, String str) throws Throwable {
        if (z10) {
            try {
                int pictureDegree = readPictureDegree(context, str);
                if (pictureDegree > 0) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    File file = new File(str);
                    Bitmap bitmapRotatingImage = rotatingImage(BitmapFactory.decodeFile(file.getAbsolutePath(), options), pictureDegree);
                    if (bitmapRotatingImage != null) {
                        saveBitmapFile(bitmapRotatingImage, file);
                        bitmapRotatingImage.recycle();
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static Bitmap rotatingImage(Bitmap bitmap, int i10) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i10);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static void saveBitmapFile(Bitmap bitmap, File file) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
            bufferedOutputStream.flush();
            PictureFileUtils.close(bufferedOutputStream);
        } catch (Exception e11) {
            e = e11;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            PictureFileUtils.close(bufferedOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            PictureFileUtils.close(bufferedOutputStream2);
            throw th;
        }
    }

    public static int readPictureDegree(InputStream inputStream) {
        try {
            int attributeInt = new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return SubsamplingScaleImageView.ORIENTATION_270;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }
}
