package com.bytedance.android.livesdkapi.monitor;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveHybridMonitor {
    public static final int STATUS_CANCEL = 2;
    public static final int STATUS_FAIL = 1;
    public static final int STATUS_LEAVE = 3;
    public static final int STATUS_SUCCESS = 0;

    public interface BusinessParams {
        public static final String CONTAINER_TYPE = "container_type";
        public static final String ERROR_MSG = "error_msg";
        public static final String METHOD_NAME = "method_name";
        public static final String SCHEMA = "schema";
        public static final String URL = "url";
    }

    public interface ContainerType {
        public static final String ANNIE = "annie";
        public static final String LYNX = "lynx";
        public static final String UNKNOWN = "unknown";
        public static final String WEB = "web";
    }

    void monitorContainer(String r100, String r101, String r102, String r103, int r104, String r105, JSONObject r106);
}
