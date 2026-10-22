package a1c;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.ttvideoengine.log.VideoEventListener;
import com.ss.ttvideoengine.log.VideoEventManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements VideoEventListener {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.ss.ttvideoengine.log.VideoEventListener
    public final void onEvent() {
        JSONArray r100 = VideoEventManager.instance.popAllEvents();     // Catch: JSONException -> L11
        if (r100 == null) goto L19;
        int r101 = r100.length();     // Catch: JSONException -> L11
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L20;
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r100, r102);     // Catch: JSONException -> L11
        if (r103 == null) goto L10;
        Log.e("LarkVideoEventListener", "onEvent: " + r103);     // Catch: JSONException -> L11
        Statistics.recordMiscLog("video_playq", r103);     // Catch: JSONException -> L11
    L10:
        r102 = r102 + 1;
        goto L6
    L20:
        return;
    L19:
        return;
    L11:
        e = move-exception;
        Log.e("LarkVideoEventListener", "VideoEventManager, onEvent exception: " + e.getMessage());
    }

    @Override // com.ss.ttvideoengine.log.VideoEventListener
    public void onEventV2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitor_name");
        JSONArray r101 = VideoEventManager.instance.popAllEventsV2();     // Catch: JSONException -> L13
        if (r101 == null) goto L22;
        int r102 = r101.length();     // Catch: JSONException -> L13
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L23;
        JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r101, r103);     // Catch: JSONException -> L13
        if (r104 == null) goto L12;
        if (TextUtils.isEmpty(r100) == true) goto L12;
        r104.putOpt("params_for_special", "videoplayer_monitor");     // Catch: JSONException -> L13
        Log.e("LarkVideoEventListener", "onEventV2: " + r104);     // Catch: JSONException -> L13
        Statistics.sendEvent(r100, r104);     // Catch: JSONException -> L13
    L12:
        r103 = r103 + 1;
        goto L6
    L23:
        return;
    L22:
        return;
    L13:
        e = move-exception;
        Log.e("LarkVideoEventListener", "VideoEventManager, onEventV2 exception: " + e.getMessage());
    }
}
