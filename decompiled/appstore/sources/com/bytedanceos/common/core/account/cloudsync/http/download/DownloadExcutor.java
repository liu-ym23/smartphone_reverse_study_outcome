package com.bytedanceos.common.core.account.cloudsync.http.download;

import com.bytedanceos.common.core.account.cloudsync.util.CloudSyncFile;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public interface DownloadExcutor {
    public static final int DOWNLOADING = 3;
    public static final int INIT = 1;
    public static final int PAUSE = 5;
    public static final int STOP = 2;
    public static final int SUCCESS = 4;

    public interface DownloadProgressListener {
        void onCompleted(CloudSyncFile r10);

        void onError(CloudSyncFile r10) throws Exception;

        void onPause(CloudSyncFile r10);

        void onProgress(CloudSyncFile r10);

        void onStart(CloudSyncFile r10);

        void onStop(CloudSyncFile r10);
    }

    void startDownloadFile(String r10, String r11, DownloadProgressListener r12, HashMap<String, String> r13) throws Exception;

    void stopDownloadFile(int r10);
}
