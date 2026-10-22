package com.stepos.activeview.task;

import android.os.AsyncTask;
import android.os.SystemClock;
import com.stepos.activeview.listener.OnLoadDataListener;
import com.stepos.activeview.utils.ActiveUsageStatsUtils;
import com.stepos.activeview.utils.JsonParser;
import com.stepos.activeview.utils.LogUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class LoadDataTask<T> extends AsyncTask<Object, Integer, T> {
    private static final String LOG_TAG = "activeview.LoadDataTask";
    private WeakReference<Class<T>> mClass;
    private String mFilePath;
    private OnLoadDataListener mListener;

    public LoadDataTask(String str, Class<T> cls, OnLoadDataListener onLoadDataListener) {
        this.mFilePath = str;
        this.mListener = onLoadDataListener;
        this.mClass = new WeakReference<>(cls);
    }

    private void recordException(String str) {
        String str2 = this.mFilePath;
        if (str2 == null) {
            str2 = null;
        }
        ActiveUsageStatsUtils.recordException(str2, str);
    }

    public void clearTask() {
        this.mListener = null;
        this.mClass = null;
    }

    @Override // android.os.AsyncTask
    public T doInBackground(Object... objArr) throws IOException {
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        try {
            File file = new File(this.mFilePath);
            if (!file.isDirectory() && file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                StringBuilder sb = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                            sb.append("\n");
                        }
                    } catch (IOException e4) {
                        LogUtil.e(LOG_TAG, "doInBackground IOException:" + e4.getMessage());
                        e4.printStackTrace();
                        recordException(e4.toString());
                    }
                    if (sb.length() <= 0) {
                        LogUtil.e(LOG_TAG, "Read file data.json is empty!");
                        return null;
                    }
                    LogUtil.i(LOG_TAG, "Load data.json file:" + this.mFilePath + ", UseTime =" + String.valueOf(SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis));
                    return (T) JsonParser.parseJson(sb.toString(), this.mClass.get());
                } finally {
                    fileInputStream.close();
                }
            }
            LogUtil.e(LOG_TAG, "file:" + file.toString() + "is a Directory!");
            return null;
        } catch (Exception e5) {
            LogUtil.d(LOG_TAG, "doInBackground exception:" + e5.getMessage());
            this.mListener.onLoadDataResult(0, null);
            recordException(e5.toString());
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        LogUtil.d(LOG_TAG, "load task canceled!");
        clearTask();
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(T t4) {
        if (isCancelled()) {
            LogUtil.e(LOG_TAG, "onPostExecute() task isCancelled = ");
            this.mListener = null;
            return;
        }
        OnLoadDataListener onLoadDataListener = this.mListener;
        if (onLoadDataListener != null) {
            onLoadDataListener.onLoadDataResult(t4 != null ? 1 : 0, t4);
            this.mListener = null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }
}
