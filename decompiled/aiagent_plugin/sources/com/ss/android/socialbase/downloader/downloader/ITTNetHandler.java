package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface ITTNetHandler {

    public static class DefaultTTNetHandler implements ITTNetHandler {
        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public void enableTTNetLogger() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public JSONArray getABTestInfo() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public int getResponseCode(Throwable r1) {
            return -1;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public IDownloadHttpService getTTNetDownloadHttpService() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public boolean isTTNetEnable() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public JSONObject mergeTNCConfig(JSONObject r1) {
            return r1;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public void saveABTestInfo() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public void saveTNCConfig(String r1) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public void startThrottle(String[] r1, long r2) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public void stopThrottle(String[] r1) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public DownloadTTNetException translateTTNetException(Throwable r1, String r2) {
            return null;
        }

        public DefaultTTNetHandler() {
        }
    }

    void enableTTNetLogger();

    JSONArray getABTestInfo();

    int getResponseCode(Throwable r1);

    IDownloadHttpService getTTNetDownloadHttpService();

    boolean isTTNetEnable();

    JSONObject mergeTNCConfig(JSONObject r1);

    void saveABTestInfo();

    void saveTNCConfig(String r1);

    void startThrottle(String[] r1, long r2);

    void stopThrottle(String[] r1);

    DownloadTTNetException translateTTNetException(Throwable r1, String r2);
}
