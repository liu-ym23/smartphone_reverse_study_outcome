package com.bytedance.apm.alog.net;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class AlogUploadService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f6352a = "https://mon.zijieapi.com/monitor/collect/c/logcollect";

    public interface AlogCallBack {
        void onSuccess(boolean r10, int r11, Exception r12, JSONObject r13);
    }

    static {
    }

    public static void a(String r10) {
        f6352a = "https://" + r10 + "/monitor/collect/c/logcollect";
    }
}
