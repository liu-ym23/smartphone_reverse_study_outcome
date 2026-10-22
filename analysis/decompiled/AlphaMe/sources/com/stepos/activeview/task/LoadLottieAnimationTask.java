package com.stepos.activeview.task;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.h;
import com.stepos.activeview.listener.OnAsyncTaskListener;
import com.stepos.activeview.utils.ActiveUsageStatsUtils;
import com.stepos.activeview.utils.LogUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class LoadLottieAnimationTask extends AsyncTask<Void, Integer, LottieComposition> {
    private static final String LOG_TAG = "LoadImageTask";
    private static Method sLottieFactoryMethod;
    private Context mContext;
    private String mFilePath;
    OnAsyncTaskListener mOnAsyncTaskListener;

    public LoadLottieAnimationTask(Context context, String str, OnAsyncTaskListener onAsyncTaskListener) {
        this.mContext = context;
        this.mFilePath = str;
        this.mOnAsyncTaskListener = onAsyncTaskListener;
    }

    private void recordException(String str) {
        ActiveUsageStatsUtils.recordException(this.mFilePath, str);
    }

    public String getLottieAnimationPath() {
        return this.mFilePath;
    }

    @Override // android.os.AsyncTask
    public LottieComposition doInBackground(Void... voidArr) {
        LottieComposition lottieComposition = null;
        if (isCancelled()) {
            return null;
        }
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        try {
            if (sLottieFactoryMethod == null) {
                Method declaredMethod = h.class.getDeclaredMethod("fromInputStream", Resources.class, InputStream.class);
                sLottieFactoryMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            lottieComposition = (LottieComposition) sLottieFactoryMethod.invoke(null, this.mContext.getResources(), new FileInputStream(this.mFilePath));
        } catch (FileNotFoundException e4) {
            recordException(e4.toString());
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        } catch (IllegalStateException e6) {
            recordException(e6.toString());
        } catch (NoSuchMethodException e7) {
            e7.printStackTrace();
        } catch (InvocationTargetException e8) {
            e8.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        LogUtil.i(LOG_TAG, "Load Lottie anim json file:" + this.mFilePath + ", UseTime =" + String.valueOf(SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis));
        return lottieComposition;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(LottieComposition lottieComposition) {
        if (isCancelled()) {
            this.mContext = null;
            return;
        }
        OnAsyncTaskListener onAsyncTaskListener = this.mOnAsyncTaskListener;
        if (onAsyncTaskListener != null) {
            onAsyncTaskListener.onLoadFinished(this, lottieComposition);
            this.mOnAsyncTaskListener = null;
        }
    }
}
