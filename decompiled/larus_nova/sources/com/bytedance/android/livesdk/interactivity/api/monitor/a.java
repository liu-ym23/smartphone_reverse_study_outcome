package com.bytedance.android.livesdk.interactivity.api.monitor;

import android.util.Log;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.ss.android.lark.search.dto.UserGroupScene;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InteractivityMonitor.Event f133313a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InteractivityMonitor.Event f133314b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LiveTracingMonitor.EventModule f133315c = null;

    static {
        f133313a = InteractivityMonitor.Event.CommentUserSend;
        f133314b = InteractivityMonitor.Event.CommentIntercept;
        f133315c = LiveTracingMonitor.EventModule.common;
    }

    @JvmStatic
    public static final String a(t r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        String r101 = r100.getMessageMethod();
        if (r101 != null) goto L6;
    L25:
        return "unknow";
    L6:
        switch(r101.hashCode()) {
            case -1142270555: goto L23;
            case 41447196: goto L20;
            case 1163169388: goto L15;
            case 1906410492: goto L12;
            case 2129329488: goto L9;
            default: goto L25;
        };
    L9:
        if (r101.equals("WebcastScreenChatMessage") == false) goto L25;
        return UserGroupScene.DEFAULT_NAME_SPACE;
    L12:
        if (r101.equals("WebcastEmojiChatMessage") == false) goto L25;
        return "subscribe";
    L15:
        if (r101.equals("WebcastAudioChatMessage") == false) goto L17;
    L18:
        return "audio";
    L17:
        if (r101.equals("WebcastAudioChatMessage") == false) goto L25;
    L20:
        if (r101.equals("WebcastChatMessage") == false) goto L25;
        return UserGroupScene.DEFAULT_NAME_SPACE;
    L23:
        if (r101.equals("WebcastPrivilegeScreenChatMessage") == false) goto L25;
        return "privilege";
    }

    @JvmStatic
    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sendType");
        JSONObject r101 = new JSONObject();
        r101.put("send_type", r100);
        r101.put("send_status", "start_send");
        InteractivityMonitor.Event r102 = f133313a;
        LiveTracingMonitor.f(r102.getEventName(), r102.getEventModule(), r101, new JSONObject(), new JSONObject());
    }

    @JvmStatic
    public static final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sendType");
        JSONObject r101 = new JSONObject();
        r101.put("send_type", r100);
        r101.put("send_status", "send_success");
        InteractivityMonitor.Event r102 = f133313a;
        LiveTracingMonitor.f(r102.getEventName(), r102.getEventModule(), r101, new JSONObject(), new JSONObject());
    }

    @JvmStatic
    public static final void b(Throwable r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter("send comment message", "msg");
        JSONObject r102 = new JSONObject();
        r102.put("msg", "send comment message");
        r102.put("cause", r100.getCause());
        r102.put("throwable_msg", r100.getMessage());
        r102.put("stack", Log.getStackTraceString(r100));
        LiveTracingMonitor.EventModule r103 = f133315c;
        JSONObject r104 = new JSONObject();
        r104.put("status_code", r101);     // Catch: JSONException -> L8
    L10:
        r104.put("category_1", "live");     // Catch: JSONException -> L9
    L6:
        LiveMonitor r105 = new LiveMonitor();
        r105.mCategory = r104;
        r105.mEventModule = r103;
        r105.mServiceName = "ttlive_comment_monitor";
        r105.mExtraLog = r102;
        r105.mMetrics = null;
        LiveMonitor.access$002(r105, false);
        LiveMonitor.access$102(r105, false);
        LiveMonitor.access$202(r105, true);
        LiveMonitor.access$302(r105, false);
        LiveMonitor.access$402(r105, false);
        r105.report();
    }

    @JvmStatic
    public static final void d(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "sendType");
        JSONObject r103 = new JSONObject();
        r103.put("send_type", r100);
        r103.put("send_status", "send_fail");
        if ((r102 instanceof CustomApiServerException) == false) goto L9;
        String r104 = ((CustomApiServerException) r102).getErrorMsg();
        if (r104 != null) goto L7;
        r104 = "unknown api exception";
    L7:
        r103.put("reason", r104);
    L15:
        if (r102 == null) goto L24;
        JSONObject r105 = new JSONObject();
        r105.put("send_type", r100);
        if (r101 != null) goto L19;
        r101 = "unknown";
    L19:
        r105.put("reason", r101);
        Throwable r106 = r102.getCause();
        if (r106 == null) goto L22;
        String r107 = r106.getMessage();
    L23:
        r105.put("cause", r107);
        r105.put("throwable_msg", r102.getMessage());
        r105.put("stack", Log.getStackTraceString(r102));
    L25:
        InteractivityMonitor.Event r108 = f133313a;
        LiveTracingMonitor.f(r108.getEventName(), r108.getEventModule(), r103, new JSONObject(), r105);
        return;
    L22:
        r107 = null;
        goto L23
    L24:
        r105 = new JSONObject();
        goto L25
    L9:
        if ((r102 instanceof NetworkErrorException) == false) goto L11;
        r103.put("reason", "network_error: " + ((NetworkErrorException) r102).statusCode);
        goto L15
    L11:
        if (r101 != null) goto L13;
        String r109 = "unknown";
    L14:
        r103.put("reason", r109);
        goto L15
    L13:
        r109 = r101;
        goto L14
    }
}
