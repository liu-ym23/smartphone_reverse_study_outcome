package com.stepos.activeview.download;

import B0.g;
import android.content.Context;
import com.stepos.activeview.json.ActiveData;
import com.stepos.activeview.listener.OnDownloadListener;
import com.stepos.activeview.listener.OnLoadDataListener;
import com.stepos.activeview.listener.OnZipExtractListener;
import com.stepos.activeview.task.DownloadTask;
import com.stepos.activeview.task.LoadDataTask;
import com.stepos.activeview.task.ZipExtractTask;
import com.stepos.activeview.utils.CacheUtils;
import com.stepos.activeview.utils.Constants;
import com.stepos.activeview.utils.FileDownloader;
import com.stepos.activeview.utils.FileUtil;
import com.stepos.activeview.utils.ZipExtractor;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class GetActManager {
    private static final String LOG_TAG = "activeview.GetActManager";
    private static volatile GetActManager managerInstance;
    private final HashMap<String, GetActRequest> mInFlightRequests = new HashMap<>();

    public static class GetActRequest implements OnDownloadListener, OnZipExtractListener, OnLoadDataListener {
        public static final int LOAD_DIR = 2;
        public static final int LOAD_DIR_ASSE = 3;
        public static final int LOAD_EXTRACTED_DATA = 4;
        public static final int LOAD_UNK = 0;
        public static final int LOAD_URL = 1;
        private DownloadTask downloadTask;
        private ZipExtractTask extractTask;
        private LoadDataTask loadDataTask;
        private final ExecutorService mExecutor = Executors.newCachedThreadPool();
        private final List<GetActInterface> mWaitDataHosts;
        private String requestString;
        private int requestType;

        public GetActRequest(String str, int i4, GetActInterface getActInterface) {
            this.requestType = 0;
            ArrayList arrayList = new ArrayList();
            this.mWaitDataHosts = arrayList;
            this.requestString = str;
            if (getActInterface != null) {
                arrayList.add(getActInterface);
            }
            this.requestType = i4;
        }

        private Context getContext() {
            if (this.mWaitDataHosts.size() == 0) {
                return null;
            }
            return this.mWaitDataHosts.get(0).getContextForTask();
        }

        private void notifyAllDownloadError() {
            Iterator<GetActInterface> it = this.mWaitDataHosts.iterator();
            while (it.hasNext()) {
                it.next().onDownloadError();
            }
            GetActManager.getInstance().removeRequest(this.requestString);
        }

        private void notifyAllDownloadSuccess(String str) {
            this.downloadTask.clearTask();
            this.downloadTask = null;
            Iterator<GetActInterface> it = this.mWaitDataHosts.iterator();
            while (it.hasNext()) {
                it.next().onDownloadSuccess(str);
            }
        }

        private void notifyAllExtractError(String str) {
            Iterator<GetActInterface> it = this.mWaitDataHosts.iterator();
            while (it.hasNext()) {
                it.next().onExtractError(str);
            }
            GetActManager.getInstance().removeRequest(this.requestString);
        }

        private synchronized void notifyAllExtractSuccess(String str) {
            this.extractTask.clearTask();
            this.extractTask = null;
            CacheUtils.getInstance(getContext()).saveToSharedPreferences(this.requestString, str);
            Iterator<GetActInterface> it = this.mWaitDataHosts.iterator();
            while (it.hasNext()) {
                it.next().onExtractSuccess(str);
            }
        }

        private void notifyAllLoadDataError() {
            CacheUtils.getInstance(getContext()).removeSharedPreference(this.requestString);
            Iterator<GetActInterface> it = this.mWaitDataHosts.iterator();
            while (it.hasNext()) {
                it.next().onLoadDataError();
            }
            GetActManager.getInstance().removeRequest(this.requestString);
        }

        private void notifyAllLoadDataSuccess(ActiveData activeData) {
            while (this.mWaitDataHosts.size() > 0) {
                GetActInterface getActInterface = (GetActInterface) g.h(this.mWaitDataHosts, 1);
                this.mWaitDataHosts.remove(getActInterface);
                getActInterface.onLoadDataSuccess(activeData);
            }
            GetActManager.getInstance().removeRequest(this.requestString);
        }

        private void startDirTask(String str, boolean z4) {
            Context context = getContext();
            if (context == null) {
                return;
            }
            if (z4) {
                this.extractTask = (ZipExtractTask) ZipExtractor.extractAssetsFileAsync(context, str, true, this);
            } else {
                this.extractTask = (ZipExtractTask) ZipExtractor.extractFileAsync(str, context, this);
            }
        }

        private void startLoadDataTask(final String str) {
            String strConcat = str.endsWith("/") ? str.concat(Constants.JSON_FILE) : str.concat("/data.json");
            File file = new File(strConcat);
            if (file.isDirectory() || !file.exists()) {
                this.mExecutor.execute(new Runnable(this) { // from class: com.stepos.activeview.download.GetActManager.GetActRequest.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FileUtil.deleteDirectory(str);
                    }
                });
                onLoadDataResult(0, null);
            } else {
                LoadDataTask loadDataTask = new LoadDataTask(strConcat, ActiveData.class, this);
                this.loadDataTask = loadDataTask;
                loadDataTask.execute(new Object[0]);
            }
        }

        private void startUrlTask() {
            Context context = getContext();
            if (context != null) {
                this.downloadTask = (DownloadTask) FileDownloader.downloadFileAsync(this.requestString, context, this);
            }
        }

        public void addWaitActiveViews(GetActInterface getActInterface) {
            if (getActInterface == null || this.mWaitDataHosts.contains(getActInterface)) {
                return;
            }
            this.mWaitDataHosts.add(getActInterface);
        }

        public synchronized void clearRequest() {
            try {
                DownloadTask downloadTask = this.downloadTask;
                if (downloadTask != null) {
                    downloadTask.cancel(true);
                    this.downloadTask.clearTask();
                    this.downloadTask = null;
                }
                ZipExtractTask zipExtractTask = this.extractTask;
                if (zipExtractTask != null) {
                    zipExtractTask.cancel(true);
                    this.extractTask.clearTask();
                    this.extractTask = null;
                }
                LoadDataTask loadDataTask = this.loadDataTask;
                if (loadDataTask != null) {
                    loadDataTask.cancel(true);
                    this.loadDataTask.clearTask();
                    this.loadDataTask = null;
                }
                this.mWaitDataHosts.clear();
            } catch (Throwable th) {
                throw th;
            }
        }

        public int getLoadType() {
            return this.requestType;
        }

        public String getRequestString() {
            return this.requestString;
        }

        @Override // com.stepos.activeview.listener.OnDownloadListener
        public void onDownloadError(int i4) {
            notifyAllDownloadError();
        }

        @Override // com.stepos.activeview.listener.OnDownloadListener
        public void onDownloadFinished(int i4, String str) {
            if (1 != i4) {
                notifyAllDownloadError();
            } else {
                notifyAllDownloadSuccess(str);
                startDirTask(str, false);
            }
        }

        @Override // com.stepos.activeview.listener.OnDownloadListener
        public void onDownloadStart(String str) {
        }

        @Override // com.stepos.activeview.listener.OnZipExtractListener
        public void onExtractError(String str) {
            notifyAllExtractError(str);
        }

        @Override // com.stepos.activeview.listener.OnZipExtractListener
        public void onExtractFinished(int i4, String str) {
            if (i4 != 1 || str == null) {
                notifyAllExtractError("error");
            } else {
                notifyAllExtractSuccess(str);
                startLoadDataTask(str);
            }
        }

        @Override // com.stepos.activeview.listener.OnZipExtractListener
        public void onExtractStart(String str) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.stepos.activeview.listener.OnLoadDataListener
        public <T> void onLoadDataResult(int i4, T t4) {
            if (i4 == 1) {
                notifyAllLoadDataSuccess((ActiveData) t4);
            } else {
                notifyAllLoadDataError();
            }
        }

        public int removeWaitActiveView(GetActInterface getActInterface) {
            if (getActInterface != null && this.mWaitDataHosts.contains(getActInterface)) {
                this.mWaitDataHosts.remove(getActInterface);
            }
            return this.mWaitDataHosts.size();
        }

        public void startGetData() {
            int i4 = this.requestType;
            if (i4 == 1) {
                startUrlTask();
                return;
            }
            if (i4 == 2) {
                startDirTask(this.requestString, false);
            } else if (i4 == 3) {
                startDirTask(this.requestString, true);
            } else {
                if (i4 != 4) {
                    throw new IllegalArgumentException("The type of request is not valid.");
                }
                startLoadDataTask(this.requestString);
            }
        }
    }

    private GetActManager() {
    }

    public static GetActManager getInstance() {
        if (managerInstance == null) {
            synchronized (GetActManager.class) {
                try {
                    if (managerInstance == null) {
                        managerInstance = new GetActManager();
                    }
                } finally {
                }
            }
        }
        return managerInstance;
    }

    public GetActRequest createRequest(String str, int i4, GetActInterface getActInterface) {
        if (str != null) {
            return new GetActRequest(str, i4, getActInterface);
        }
        return null;
    }

    public GetActRequest getRequest(String str) {
        return this.mInFlightRequests.get(str);
    }

    public boolean isRequestInFlight(String str) {
        return str != null && this.mInFlightRequests.containsKey(str);
    }

    public void putRequest(GetActRequest getActRequest) {
        if (this.mInFlightRequests.containsKey(getActRequest.getRequestString())) {
            return;
        }
        this.mInFlightRequests.put(getActRequest.getRequestString(), getActRequest);
    }

    public void removeAllRequest() {
        Iterator<GetActRequest> it = this.mInFlightRequests.values().iterator();
        while (it.hasNext()) {
            it.next().clearRequest();
        }
        this.mInFlightRequests.clear();
    }

    public void removeRequest(String str) {
        if (str == null || !this.mInFlightRequests.containsKey(str)) {
            return;
        }
        this.mInFlightRequests.get(str).clearRequest();
        this.mInFlightRequests.remove(str);
    }
}
