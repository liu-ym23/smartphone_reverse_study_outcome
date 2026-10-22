package com.stepos.activeview.task;

import B0.g;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Pair;
import com.stepos.activeview.download.HttpsRequest;
import com.stepos.activeview.download.IFileChecker;
import com.stepos.activeview.listener.OnDownloadListener;
import com.stepos.activeview.utils.ActiveUsageStatsUtils;
import com.stepos.activeview.utils.FileUtil;
import com.stepos.activeview.utils.LogUtil;
import com.stepos.activeview.utils.Md5Helper;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.util.List;

/* loaded from: classes.dex */
public class DownloadTask extends AsyncTask<Void, Integer, Integer> {
    public static final int DOWNLOAD_RESULT_CODE_CANCEL = 0;
    public static final int FILE_NAME_LENGTH_LIMIT = 255;
    private static final String LOG_TAG = "DownloadTask";
    private WeakReference<Context> mContext;
    private OnDownloadListener mDownloadListener;
    private IFileChecker mFileChecker;
    private String mFileName;
    private String mFilePath;
    private String mOutputPath;
    private URL mUrl;

    public interface DownloadProgressListener {
        void onProgress(float f4);
    }

    public DownloadTask(String str, Context context, OnDownloadListener onDownloadListener) {
        this(str, context, (String) null, onDownloadListener);
    }

    private int download() {
        WeakReference<Context> weakReference;
        Context context;
        if (this.mUrl == null || (weakReference = this.mContext) == null || (context = weakReference.get()) == null || !init(context)) {
            return 0;
        }
        OnDownloadListener onDownloadListener = this.mDownloadListener;
        if (onDownloadListener != null) {
            onDownloadListener.onDownloadStart(this.mUrl.toString());
        }
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        try {
            if (!new HttpsRequest(this.mFilePath).download(this.mUrl, (List<Pair<String, String>>) null, new DownloadProgressListener(this) { // from class: com.stepos.activeview.task.DownloadTask.1
                @Override // com.stepos.activeview.task.DownloadTask.DownloadProgressListener
                public void onProgress(float f4) {
                    LogUtil.i("progress:" + f4);
                }
            })) {
                return 0;
            }
            IFileChecker iFileChecker = this.mFileChecker;
            if (iFileChecker != null && !iFileChecker.checkFileDataInfo(this.mFilePath).isMatch()) {
                return 3;
            }
            LogUtil.i("Download file:" + this.mFilePath + ", UseTime =" + String.valueOf(SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis));
            return 1;
        } catch (FileNotFoundException e4) {
            e4.printStackTrace();
            return 0;
        } catch (SocketException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    private boolean init(Context context) {
        try {
            String activeViewCachesDir = this.mOutputPath;
            if (activeViewCachesDir == null) {
                activeViewCachesDir = FileUtil.getActiveViewCachesDir(context);
            }
            if (activeViewCachesDir == null) {
                OnDownloadListener onDownloadListener = this.mDownloadListener;
                if (onDownloadListener != null) {
                    onDownloadListener.onDownloadFinished(0, "Failed to get cache dir from context");
                    this.mDownloadListener = null;
                }
                return false;
            }
            if (this.mFileName == null && this.mUrl != null) {
                this.mFileName = new File(this.mUrl.getFile()).getName();
                File file = new File(activeViewCachesDir);
                if (!file.exists() && !file.mkdir()) {
                    recordException("Failed to make directories:" + file.getAbsolutePath());
                    OnDownloadListener onDownloadListener2 = this.mDownloadListener;
                    if (onDownloadListener2 != null) {
                        onDownloadListener2.onDownloadFinished(0, "Failed to make directories:" + file.getAbsolutePath());
                        this.mDownloadListener = null;
                    }
                    return false;
                }
            }
            String str = this.mFileName;
            if (str != null && str.length() > 255) {
                this.mFileName = Md5Helper.MD5Encode(this.mFileName);
            }
            this.mFilePath = new File(activeViewCachesDir, this.mFileName).getAbsolutePath();
            return true;
        } catch (NullPointerException e4) {
            OnDownloadListener onDownloadListener3 = this.mDownloadListener;
            if (onDownloadListener3 != null) {
                onDownloadListener3.onDownloadFinished(0, "Failed to create file :" + this.mUrl);
                this.mDownloadListener = null;
            }
            recordException("Failed to create file, err=" + e4.toString());
            return false;
        }
    }

    private void recordException(String str) {
        URL url = this.mUrl;
        ActiveUsageStatsUtils.recordException(url != null ? url.toString() : null, str);
    }

    private void setResult(Integer num) {
        if (this.mDownloadListener != null) {
            int iIntValue = num.intValue();
            if (iIntValue == 0) {
                this.mDownloadListener.onDownloadFinished(0, "Download Fail. URL=" + this.mUrl);
            } else if (iIntValue != 1) {
                this.mDownloadListener.onDownloadError(num.intValue());
            } else {
                this.mDownloadListener.onDownloadFinished(1, this.mFilePath);
            }
            this.mDownloadListener = null;
        }
    }

    public void clearTask() {
        this.mDownloadListener = null;
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.mContext = null;
    }

    public String doDownloadSync() {
        int iDownload = download();
        setResult(Integer.valueOf(iDownload));
        if (iDownload == 1) {
            return this.mFilePath;
        }
        return null;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        clearTask();
        super.onCancelled();
    }

    public void setFileChecker(IFileChecker iFileChecker) {
        this.mFileChecker = iFileChecker;
    }

    public DownloadTask(String str, Context context, String str2, OnDownloadListener onDownloadListener) {
        this(str, context, str2, onDownloadListener, null);
    }

    @Override // android.os.AsyncTask
    public Integer doInBackground(Void... voidArr) {
        if (!isCancelled()) {
            return Integer.valueOf(download());
        }
        this.mDownloadListener = null;
        return 0;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Integer num) {
        if (!isCancelled()) {
            setResult(num);
            return;
        }
        this.mDownloadListener = null;
        if (1 == num.intValue()) {
            setResult(num);
        } else {
            setResult(0);
        }
    }

    public DownloadTask(String str, Context context, String str2, OnDownloadListener onDownloadListener, String str3) {
        this.mDownloadListener = onDownloadListener;
        if (str != null && !str.isEmpty() && context != null) {
            try {
                this.mUrl = new URL(str);
                LogUtil.i(LOG_TAG, "mUrl =" + this.mUrl);
                this.mContext = new WeakReference<>(context);
                this.mFileName = str2;
                this.mOutputPath = str3;
                return;
            } catch (MalformedURLException e4) {
                OnDownloadListener onDownloadListener2 = this.mDownloadListener;
                if (onDownloadListener2 != null) {
                    onDownloadListener2.onDownloadFinished(0, "Bad URL:".concat(str));
                    this.mDownloadListener = null;
                }
                this.mUrl = null;
                recordException(e4.toString());
                return;
            }
        }
        OnDownloadListener onDownloadListener3 = this.mDownloadListener;
        if (onDownloadListener3 != null) {
            onDownloadListener3.onDownloadFinished(0, "URL=" + str);
            this.mDownloadListener = null;
        }
        recordException(g.m("DOWNLOAD_FAIL URL=", str));
    }

    public DownloadTask(String str, Context context) {
        this(str, context, null);
    }

    public DownloadTask(String str, String str2, Context context, OnDownloadListener onDownloadListener) {
        this(str, context, null, onDownloadListener, str2);
    }
}
