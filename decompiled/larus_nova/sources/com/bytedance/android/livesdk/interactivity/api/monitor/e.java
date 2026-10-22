package com.bytedance.android.livesdk.interactivity.api.monitor;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InteractivityMonitor.Event f133321a = null;

    static {
        f133321a = InteractivityMonitor.Event.CommentUserSendSelfShow;
    }

    @JvmStatic
    public static final void a(String r100, String r101, long r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "sendType");
        Intrinsics.checkNotNullParameter(r101, "showType");
        JSONObject r104 = new JSONObject();
        r104.put("send_type", r100);
        r104.put("show_type", r101);
        JSONObject r105 = new JSONObject();
        r105.put("use_time", r102);
        r105.put("api_use_time", r103);
        InteractivityMonitor.Event r106 = f133321a;
        LiveTracingMonitor.f(r106.getEventName(), r106.getEventModule(), r104, r105, new JSONObject());
    }
}
