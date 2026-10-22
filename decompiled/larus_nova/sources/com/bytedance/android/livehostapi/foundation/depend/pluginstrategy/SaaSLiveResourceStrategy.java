package com.bytedance.android.livehostapi.foundation.depend.pluginstrategy;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.NewPluginType;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.paas.c;
import com.bytedance.pia.core.metrics.ErrorType;
import com.mammon.audiosdk.BuildConfig;
import jc1.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class SaaSLiveResourceStrategy extends SaaSPluginStrategy {
    public static final String TAG = "LiveBroadcastContext_SaaSLiveResourceStrategy";

    public static String[] getLoadHostLibraryList() {
        return new String[]{"yuv", "c++_shared", "gaia_lib", "AGFX", "ttffmpeg", "iesapplogger", "bytenn", BuildConfig.LIBNAME, "quick", "napi", "jazz", "bytevc0", "fastcv", "lens", "napi_v8", ErrorType.WORKER, "bytemonitor", "bytebench", "effect", "fdk-aac", "RealXBase", "RealXAudio", "RealX", "byteaudio", "vcbasekit", "bytevc1enc", "avframework", "logtransport", com.ss.bytertc.BuildConfig.RTC_TARGET_NAME, "ttquic", "byterts"};
    }

    private static JSONObject generateFinalExtra(JSONObject r100) {
        JSONObject r101 = new JSONObject();
        r101.put("tag", "ttlive_sdk");     // Catch: JSONException -> L7
        r101.put("ttlive_sdk_version", String.valueOf(c.b()));     // Catch: JSONException -> L7
        if (r100 == null) goto L9;
        r101.put("extra", r100);     // Catch: JSONException -> L7
    L9:
        return r101;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static void loadHostLibraryDefault(Context r100, ClassLoader r101) {
        loadHostLibraryByList(r100, r101, getLoadHostLibraryList());
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.PluginStrategy, com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void load(Context r100, boolean r101) {
        if (r101 == false) goto L14;
        loadHostLibraryDefault(r100, getClass().getClassLoader());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L9
        r102.put("message", th.getMessage());     // Catch: Throwable -> L9
        r102.put("service", "hotsoon_live_soplugin_load_failed");     // Catch: Throwable -> L9
        JSONObject r103 = generateFinalExtra(r102);     // Catch: Throwable -> L9
        ((IHostMonitor) k.f(IHostMonitor.class)).monitorStatusRate("ttlive_soplugin_load_error", 1, r103);     // Catch: Throwable -> L9
    L7:
        th.printStackTrace();
        return;
    }

    public SaaSLiveResourceStrategy(String r100, boolean r101, String r102) {
        super(r100, r101, r102);
    }

    public static Pair<Boolean, String> loadHostLibrary(Context r100, String r101, ClassLoader r102) {
        IHostPlugin r103 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r103 == null) goto L7;
        return r103.loadLibraryV2(0, r100, NewPluginType.LiveResource.getPackageName(), r101, r102);
    L7:
        return new Pair(Boolean.FALSE, "IHostPlugin null");
    }

    public static void loadHostLibraryByList(Context r100, ClassLoader r101, String[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L10;
        ALogger.e(TAG, "start load library:" + r102[r103]);     // Catch: Throwable -> L7
        Pair<Boolean, String> r104 = loadHostLibrary(r100, r102[r103], r101);     // Catch: Throwable -> L7
        ALogger.e(TAG, "start load library done :" + r102[r103] + r104.first + ((String) r104.second));     // Catch: Throwable -> L7
    L9:
        r103 = r103 + 1;
    L7:
        th = move-exception;
        ALogger.e(TAG, "start load library error :" + r102[r103]);
        th.printStackTrace();
        goto L9
    }
}
