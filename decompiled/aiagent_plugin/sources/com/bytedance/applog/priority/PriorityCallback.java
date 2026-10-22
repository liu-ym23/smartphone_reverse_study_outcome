package com.bytedance.applog.priority;

/* JADX INFO: loaded from: classes.dex */
public interface PriorityCallback {
    PriorityHttpResponse doHttpPost(String r1, byte[] r2);

    String getHeaderJson();

    boolean isMonitorEnabled();

    boolean isNetworkAvailable();

    boolean isStageEnabled();

    void monitorError(String r1, String r2);

    void monitorIncreaseStats(String r1, int r2);

    void monitorStage(String r1, String r2, int r3, int r4, String r5, String r6, long r7);

    void printLog(int r1, String r2);
}
