package com.baidu.mshield.x6;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.mshield.x6.b.b;
import com.baidu.mshield.x6.e.h;
import com.baidu.mshield.x6.f.f;
import com.baidu.mshield.x6.f.g;
import com.baidu.mshield.x6.f.m.c;
import com.baidu.mshield.x6.recv.MyReceiver;
import java.util.HashMap;

/* loaded from: classes.dex */
public class EngineImpl {
    public static final String KEY_ACCOUNT_ID = "aid";
    public static final String KEY_ANDROID_ID = "arid";
    public static final String KEY_ANDROID_LEVEL = "arl";
    public static final String KEY_ANDROID_VERSION = "arv";
    public static final String KEY_CUID = "cuid";
    public static final String KEY_MODEL = "mod";
    public static final String KEY_OAID = "oid";
    public static final String KEY_PACKAGE = "p";
    public static final String KEY_SENSOR_LIST = "sl";
    public static final String KEY_SIGNATURE = "s";
    public static final String KEY_WIFI_STATE = "ws";
    private static EngineImpl instance = null;
    public static String sAppkey = null;
    public static String sLoadVersion = "4.2.6";
    public static String sSecKey;
    private IntentFilter alarmIntentFilter;
    private Context mContext;
    private a mSecApi;
    private MyReceiver receiver;
    public static final HashMap<String, String> PROPERTY_MAP = new HashMap<>();
    public static boolean isUnload = false;

    private EngineImpl(Context context) {
        this.mContext = context;
    }

    public static synchronized EngineImpl getInstance(Context context) {
        try {
            if (instance == null) {
                instance = new EngineImpl(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    private void registerReceiver() {
        try {
            if (this.alarmIntentFilter == null) {
                this.alarmIntentFilter = new IntentFilter();
            }
            this.alarmIntentFilter.addAction("com.baidu.mshield.x6.alarm.work.zid");
            this.alarmIntentFilter.addAction("com.baidu.mshield.x6.alarm.work.finger");
            this.alarmIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.alarmIntentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
            MyReceiver myReceiver = new MyReceiver();
            this.receiver = myReceiver;
            try {
                this.mContext.registerReceiver(myReceiver, this.alarmIntentFilter, 4);
            } catch (Throwable th) {
                f.b(th);
            }
        } catch (Throwable th2) {
            f.b(th2);
        }
    }

    private void unRegister() {
        try {
            this.mContext.unregisterReceiver(this.receiver);
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public void bdsd(int i4, boolean z4) {
        h.a(this.mContext).a(i4, z4);
    }

    public String bqp() {
        return "";
    }

    public String getEmulatorSig() {
        return "";
    }

    public String getPropertyByType(String str) {
        try {
            HashMap<String, String> map = PROPERTY_MAP;
            if (map.size() <= 0) {
                return "";
            }
            synchronized (map) {
                try {
                    if (!map.containsKey(str)) {
                        return "";
                    }
                    return map.get(str);
                } finally {
                }
            }
        } catch (Throwable th) {
            f.b(th);
            return "";
        }
    }

    public a getSecApi() {
        return this.mSecApi;
    }

    public synchronized boolean init(int i4, boolean z4) {
        isUnload = false;
        f.h(this.mContext);
        registerReceiver();
        com.baidu.mshield.x6.f.a.b(this.mContext);
        com.baidu.mshield.x6.f.a.c(this.mContext);
        h.a(this.mContext).b();
        return true;
    }

    public void setBusy(boolean z4) {
    }

    public void setPkgNameVersion(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            g.f8513a = str;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sLoadVersion = str2;
    }

    public void setRunStatus(int i4) {
    }

    public void setSecImpl(a aVar) {
        this.mSecApi = aVar;
    }

    public void setSecurityVerifyInfo(String str, String str2, HashMap<String, String> map) {
        sAppkey = str;
        sSecKey = str2;
        if (map != null) {
            HashMap<String, String> map2 = PROPERTY_MAP;
            synchronized (map2) {
                map2.putAll(map);
            }
        }
    }

    public void uccs(int i4, int i5) {
        new b(this.mContext).k(i4);
        h.a(this.mContext).a(i4, i5);
    }

    public void ud(HashMap<String, String> map) {
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return;
                }
                synchronized (PROPERTY_MAP) {
                    try {
                        for (String str : map.keySet()) {
                            PROPERTY_MAP.put(str, map.get(str));
                        }
                    } finally {
                    }
                }
                com.baidu.xclient.gdid.a.a(map);
            } catch (Throwable th) {
                f.b(th);
            }
        }
    }

    public synchronized void unload() {
        com.baidu.mshield.x6.f.a.a(this.mContext);
        unRegister();
        c.b().c();
        isUnload = true;
    }
}
