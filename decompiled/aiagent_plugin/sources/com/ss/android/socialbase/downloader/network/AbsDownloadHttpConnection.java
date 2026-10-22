package com.ss.android.socialbase.downloader.network;

import android.util.Pair;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbsDownloadHttpConnection implements IDownloadHttpConnection {
    public String getHostIp() {
        return "";
    }

    public String getRedirectPartialUrlResults() {
        return "";
    }

    public String getRequestLog() {
        return "";
    }

    public List<Pair<String, String>> getResponseHeaders() {
        return null;
    }

    public boolean isOkhttp() {
        return false;
    }

    public void monitorNetworkInfo(JSONObject r1, boolean r2) {
    }

    public void onThrowable(Throwable r1) {
    }

    public void setThrottleNetSpeedWhenRunning(long r1) {
    }

    public AbsDownloadHttpConnection() {
    }
}
