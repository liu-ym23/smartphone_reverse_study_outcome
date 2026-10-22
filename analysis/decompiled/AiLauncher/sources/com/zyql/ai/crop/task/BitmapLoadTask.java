package com.zyql.ai.crop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.a;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import com.zyql.ai.crop.callback.BitmapLoadCallback;
import com.zyql.ai.crop.model.ExifInfo;
import com.zyql.ai.crop.util.BitmapLoadUtils;
import com.zyql.ai.selector.PictureContentResolver;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.tools.PictureFileUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes4.dex */
public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapWorkerResult> {
    private static final int MAX_BITMAP_SIZE = 104857600;
    private static final String TAG = "BitmapWorkerTask";
    private final BitmapLoadCallback mBitmapLoadCallback;
    private final Context mContext;
    private Uri mInputUri;
    private final Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public BitmapLoadTask(Context context, Uri uri, Uri uri2, int i10, int i11, BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = context;
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = i10;
        this.mRequiredHeight = i11;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    private boolean checkSize(Bitmap bitmap, BitmapFactory.Options options) {
        if ((bitmap != null ? bitmap.getByteCount() : 0) <= MAX_BITMAP_SIZE) {
            return false;
        }
        options.inSampleSize *= 2;
        return true;
    }

    private void copyFile(Uri uri, Uri uri2) throws Throwable {
        InputStream contentResolverOpenInputStream;
        FileOutputStream fileOutputStream;
        Log.d(TAG, "copyFile");
        if (uri2 == null) {
            throw new NullPointerException("Output Uri is null - cannot copy image");
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            contentResolverOpenInputStream = PictureContentResolver.getContentResolverOpenInputStream(this.mContext, uri);
            try {
                fileOutputStream = new FileOutputStream(new File(uri2.getPath()));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            contentResolverOpenInputStream = null;
        }
        try {
            if (contentResolverOpenInputStream == null) {
                throw new NullPointerException("InputStream for given input Uri is null");
            }
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = contentResolverOpenInputStream.read(bArr);
                if (i10 <= 0) {
                    BitmapLoadUtils.close(fileOutputStream);
                    BitmapLoadUtils.close(contentResolverOpenInputStream);
                    this.mInputUri = this.mOutputUri;
                    return;
                }
                fileOutputStream.write(bArr, 0, i10);
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            BitmapLoadUtils.close(fileOutputStream2);
            BitmapLoadUtils.close(contentResolverOpenInputStream);
            this.mInputUri = this.mOutputUri;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    private void downloadFile(Uri uri, Uri uri2) throws Throwable {
        BufferedInputStream bufferedInputStream;
        byte[] bArr;
        Log.d(TAG, "downloadFile");
        if (uri2 == 0) {
            throw new NullPointerException("Output Uri is null - cannot download image");
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                URL url = new URL(uri.toString());
                bArr = new byte[1024];
                bufferedInputStream = new BufferedInputStream(url.openStream());
                try {
                    uri2 = PictureContentResolver.getContentResolverOpenOutputStream(this.mContext, uri2);
                } catch (Exception e10) {
                    e = e10;
                    uri2 = 0;
                } catch (Throwable th) {
                    th = th;
                    uri2 = 0;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
            uri2 = 0;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            uri2 = 0;
            bufferedInputStream = null;
        }
        if (uri2 != 0) {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(uri2);
                while (true) {
                    try {
                        int i10 = bufferedInputStream.read(bArr);
                        if (i10 <= -1) {
                            break;
                        } else {
                            bufferedOutputStream2.write(bArr, 0, i10);
                        }
                    } catch (Exception e12) {
                        e = e12;
                        bufferedOutputStream = bufferedOutputStream2;
                        e.printStackTrace();
                        uri2 = uri2;
                        this.mInputUri = this.mOutputUri;
                        BitmapLoadUtils.close(bufferedOutputStream);
                        BitmapLoadUtils.close(bufferedInputStream);
                        BitmapLoadUtils.close(uri2);
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = bufferedOutputStream2;
                        this.mInputUri = this.mOutputUri;
                        BitmapLoadUtils.close(bufferedOutputStream);
                        BitmapLoadUtils.close(bufferedInputStream);
                        BitmapLoadUtils.close(uri2);
                        throw th;
                    }
                }
                bufferedOutputStream2.flush();
                bufferedOutputStream = bufferedOutputStream2;
                uri2 = uri2;
            } catch (Exception e13) {
                e = e13;
            }
        }
        this.mInputUri = this.mOutputUri;
        BitmapLoadUtils.close(bufferedOutputStream);
        BitmapLoadUtils.close(bufferedInputStream);
        BitmapLoadUtils.close(uri2);
    }

    private String getFilePath() {
        return a.a(this.mContext, "android.permission.READ_EXTERNAL_STORAGE") == 0 ? PictureFileUtils.getPath(this.mContext, this.mInputUri) : "";
    }

    private void processInputUri() throws IOException, NullPointerException {
        String scheme = this.mInputUri.getScheme();
        Log.d(TAG, "Uri scheme: " + scheme);
        if ("http".equals(scheme) || "https".equals(scheme)) {
            try {
                downloadFile(this.mInputUri, this.mOutputUri);
                return;
            } catch (IOException | NullPointerException e10) {
                Log.e(TAG, "Downloading failed", e10);
                throw e10;
            }
        }
        if (SkillStoreKt.SKILL_DOC_TYPE_CONTENT.equals(scheme)) {
            String filePath = getFilePath();
            if (!TextUtils.isEmpty(filePath) && new File(filePath).exists()) {
                this.mInputUri = SdkVersionUtils.checkedAndroid_Q() ? this.mInputUri : Uri.fromFile(new File(filePath));
                return;
            }
            try {
                copyFile(this.mInputUri, this.mOutputUri);
                return;
            } catch (IOException | NullPointerException e11) {
                Log.e(TAG, "Copying failed", e11);
                throw e11;
            }
        }
        if (Const.STR_FILE.equals(scheme)) {
            return;
        }
        Log.e(TAG, "Invalid Uri scheme " + scheme);
        throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
    }

    @Override // android.os.AsyncTask
    public BitmapWorkerResult doInBackground(Void... voidArr) {
        InputStream contentResolverOpenInputStream;
        if (this.mInputUri == null) {
            return new BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            processInputUri();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, this.mRequiredWidth, this.mRequiredHeight);
            boolean z10 = false;
            options.inJustDecodeBounds = false;
            Bitmap bitmapDecodeStream = null;
            while (!z10) {
                try {
                    contentResolverOpenInputStream = PictureContentResolver.getContentResolverOpenInputStream(this.mContext, this.mInputUri);
                    try {
                        bitmapDecodeStream = BitmapFactory.decodeStream(contentResolverOpenInputStream, null, options);
                    } finally {
                        BitmapLoadUtils.close(contentResolverOpenInputStream);
                    }
                } catch (Exception e10) {
                    Log.e(TAG, "doInBackground: ImageDecoder.createSource: ", e10);
                    return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]", e10));
                } catch (OutOfMemoryError e11) {
                    Log.e(TAG, "doInBackground: BitmapFactory.decodeFileDescriptor: ", e11);
                    options.inSampleSize *= 2;
                }
                if (options.outWidth == -1 || options.outHeight == -1) {
                    return new BitmapWorkerResult(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.mInputUri + "]"));
                }
                BitmapLoadUtils.close(contentResolverOpenInputStream);
                if (!checkSize(bitmapDecodeStream, options)) {
                    z10 = true;
                }
            }
            if (bitmapDecodeStream == null) {
                return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]"));
            }
            int exifOrientation = BitmapLoadUtils.getExifOrientation(this.mContext, this.mInputUri);
            int iExifToDegrees = BitmapLoadUtils.exifToDegrees(exifOrientation);
            int iExifToTranslation = BitmapLoadUtils.exifToTranslation(exifOrientation);
            ExifInfo exifInfo = new ExifInfo(exifOrientation, iExifToDegrees, iExifToTranslation);
            Matrix matrix = new Matrix();
            if (iExifToDegrees != 0) {
                matrix.preRotate(iExifToDegrees);
            }
            if (iExifToTranslation != 1) {
                matrix.postScale(iExifToTranslation, 1.0f);
            }
            return !matrix.isIdentity() ? new BitmapWorkerResult(BitmapLoadUtils.transformBitmap(bitmapDecodeStream, matrix), exifInfo) : new BitmapWorkerResult(bitmapDecodeStream, exifInfo);
        } catch (IOException | NullPointerException e12) {
            return new BitmapWorkerResult(e12);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(BitmapWorkerResult bitmapWorkerResult) {
        Exception exc = bitmapWorkerResult.mBitmapWorkerException;
        if (exc != null) {
            this.mBitmapLoadCallback.onFailure(exc);
            return;
        }
        String string = this.mInputUri.toString();
        BitmapLoadCallback bitmapLoadCallback = this.mBitmapLoadCallback;
        Bitmap bitmap = bitmapWorkerResult.mBitmapResult;
        ExifInfo exifInfo = bitmapWorkerResult.mExifInfo;
        if (!PictureMimeType.isContent(string)) {
            string = this.mInputUri.getPath();
        }
        Uri uri = this.mOutputUri;
        bitmapLoadCallback.onBitmapLoaded(bitmap, exifInfo, string, uri == null ? null : uri.getPath());
    }

    public static class BitmapWorkerResult {
        Bitmap mBitmapResult;
        Exception mBitmapWorkerException;
        ExifInfo mExifInfo;

        public BitmapWorkerResult(Bitmap bitmap, ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(Exception exc) {
            this.mBitmapWorkerException = exc;
        }
    }
}
