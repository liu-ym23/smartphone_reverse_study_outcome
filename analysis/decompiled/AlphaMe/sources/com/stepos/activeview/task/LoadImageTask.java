package com.stepos.activeview.task;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.stepos.activeview.listener.OnAsyncTaskListener;
import com.stepos.activeview.utils.ActiveUsageStatsUtils;
import com.stepos.activeview.utils.BitmapUtils;
import com.stepos.activeview.utils.ImageCacheUtils;
import com.stepos.activeview.utils.LogUtil;
import java.io.File;

/* loaded from: classes.dex */
public class LoadImageTask extends AsyncTask<Void, Integer, Bitmap> {
    private static final String LOG_TAG = "LoadImageTask";
    private String mFilePath;
    OnAsyncTaskListener mOnAsyncTaskListener;
    private float mReqHeight;
    private float mReqWidth;

    public LoadImageTask(String str, OnAsyncTaskListener onAsyncTaskListener, float f4, float f5) {
        this.mFilePath = str;
        this.mOnAsyncTaskListener = onAsyncTaskListener;
        this.mReqWidth = f4;
        this.mReqHeight = f5;
    }

    private void recordException(String str) {
        ActiveUsageStatsUtils.recordException(this.mFilePath, str);
    }

    public String getImagePath() {
        return this.mFilePath;
    }

    @Override // android.os.AsyncTask
    public Bitmap doInBackground(Void... voidArr) {
        if (isCancelled()) {
            return null;
        }
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        try {
            Bitmap bitmapFromImageCache = ImageCacheUtils.getInstance().getBitmapFromImageCache(this.mFilePath);
            LogUtil.i(LOG_TAG, "GET MemoryCache=" + this.mFilePath + ", bitmap=" + bitmapFromImageCache);
            if (bitmapFromImageCache != null && !bitmapFromImageCache.isRecycled()) {
                return bitmapFromImageCache;
            }
            if (new File(this.mFilePath).exists()) {
                bitmapFromImageCache = BitmapUtils.decodeSampledBitmapFromFile(this.mFilePath, (int) this.mReqWidth, (int) this.mReqHeight);
            }
            LogUtil.i(LOG_TAG, "Load image file:" + this.mFilePath + ", UseTime =" + String.valueOf(SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis));
            return bitmapFromImageCache;
        } catch (Exception e4) {
            recordException("create image error :" + e4.toString());
            return null;
        } catch (OutOfMemoryError e5) {
            recordException("create image OOM :" + e5.toString());
            return null;
        } catch (Throwable th) {
            recordException("create image error :" + th.toString());
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        OnAsyncTaskListener onAsyncTaskListener = this.mOnAsyncTaskListener;
        if (onAsyncTaskListener != null) {
            onAsyncTaskListener.onLoadFinished(this, bitmap);
            this.mOnAsyncTaskListener = null;
        }
        if (isCancelled() || bitmap == null) {
            return;
        }
        ImageCacheUtils.getInstance().putBitmapToImageCache(this.mFilePath, bitmap);
    }
}
