package com.bytedance.crash;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class NpthApi {

    public interface CustomDataCallback {
        Map<String, String> getData();
    }

    public interface RetraceDataCallback {
        JSONObject getData();
    }

    static {
    }

    public static String a() {
        return "";
    }
}
