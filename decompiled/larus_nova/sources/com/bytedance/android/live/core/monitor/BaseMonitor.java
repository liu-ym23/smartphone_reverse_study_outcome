package com.bytedance.android.live.core.monitor;

import com.bytedance.common.utility.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public class BaseMonitor {
    public static final int STATUS_CANCEL = 2;
    public static final int STATUS_FAIL = 1;
    public static final int STATUS_LEAVE = 3;
    public static final int STATUS_SUCCESS = 0;
    private static final String TAG = "BaseMonitor";

    public static final enum MonitorEventModule extends Enum<MonitorEventModule> {
        public static final MonitorEventModule BROADCAST = null;
        public static final MonitorEventModule COMMON = null;
        public static final MonitorEventModule ENTER_ROOM = null;
        public static final MonitorEventModule HYBRID = null;
        public static final MonitorEventModule PAY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MonitorEventModule[] f64897a = null;
        private String name;

        static {
            MonitorEventModule r100 = new MonitorEventModule("COMMON", 0, "common");
            COMMON = r100;
            MonitorEventModule r101 = new MonitorEventModule("ENTER_ROOM", 1, "enter_room");
            ENTER_ROOM = r101;
            MonitorEventModule r102 = new MonitorEventModule("BROADCAST", 2, "broadcast");
            BROADCAST = r102;
            MonitorEventModule r103 = new MonitorEventModule("HYBRID", 3, "hybrid");
            HYBRID = r103;
            MonitorEventModule r104 = new MonitorEventModule("PAY", 4, "pay");
            PAY = r104;
            f64897a = new MonitorEventModule[]{r100, r101, r102, r103, r104};
        }

        public static MonitorEventModule[] values() {
            return (MonitorEventModule[]) f64897a.clone();
        }

        public String getName() {
            return this.name;
        }

        public static MonitorEventModule valueOf(String r100) {
            return (MonitorEventModule) a.a(MonitorEventModule.class, r100);
        }

        public MonitorEventModule(String r100, int r101, String r102) {
            super(r100, r101);
            this.name = r102;
        }
    }

    public BaseMonitor() {
    }

    public static void add(JSONObject r100, String r101, float r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        Logger.e(TAG, "", e);
    }

    public static void add(JSONObject r100, String r101, int r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "", e);
    }

    public static void add(JSONObject r100, String r101, long r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "", e);
    }

    public static void add(JSONObject r100, String r101, String r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "", e);
    }

    public static void add(JSONObject r100, String r101, JSONObject r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "", e);
    }

    public static void add(JSONObject r100, String r101, boolean r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "", e);
    }
}
