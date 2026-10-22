package com.bytedance.android.livesdk.interactivity.api.monitor;

import android.util.Log;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.livesdk.interactivity.api.settings.config.n;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.v0;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f133316a = null;

    static {
        f133316a = v0.f536272a.getValue();
    }

    @JvmStatic
    public static final void a(boolean r100) {
        if (f133316a.monitorCostClick == true) goto L5;
        return;
    L5:
        int r101 = 0;
        String r102 = null;
        long r103 = 0;
        LinkedHashMap r104 = new LinkedHashMap();
        if (r100 == false) goto L8;
        String r105 = BdpAppEventConstant.YES;
    L9:
        r104.put("button", r105);
        Unit r106 = Unit.INSTANCE;
        c r107 = new c(r101, r102, r103, r104, 7);
        r107.a(InteractivityMonitor.Event.CostConfirmWindowClick);
        r107.b(InteractivityTraceMonitor.Event.CostConfirmWindowClick);
        return;
    L8:
        r105 = BdpAppEventConstant.NO;
        goto L9
    }

    public static void d(String r100, String r101) {
        if (f133316a.monitorJsbEvent == true) goto L5;
        return;
    L5:
        int r102 = 0;
        String r103 = null;
        long r104 = 0;
        LinkedHashMap r105 = new LinkedHashMap();
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        r105.put("request_source", r100);
        if (r101 != null) goto L11;
        r101 = "";
    L11:
        r105.put("content", r101);
        Unit r106 = Unit.INSTANCE;
        c r107 = new c(r102, r103, r104, r105, 7);
        r107.a(InteractivityMonitor.Event.ReceiveOpenCommentPanelEvent);
        r107.b(InteractivityTraceMonitor.Event.ReceiveOpenCommentPanelEvent);
    }

    @JvmStatic
    public static final void f(String r100, String r101) {
        if (f133316a.monitorAiParam == true) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
        int r102 = 0;
    L8:
        if (r101 != null) goto L10;
        String r103 = "";
    L11:
        long r104 = 0;
        LinkedHashMap r105 = new LinkedHashMap();
        if (r100 == null) goto L14;
        String r106 = (String) r105.put("params", r100);
    L14:
        if (r101 == null) goto L16;
        r105.put("error", r101);
    L16:
        Unit r107 = Unit.INSTANCE;
        new c(r102, r103, r104, r105, 4).b(InteractivityTraceMonitor.Event.InputAIParamLog);
        return;
    L10:
        r103 = r101;
        goto L11
    L7:
        r102 = -1;
        goto L8
    }

    @JvmStatic
    public static final void b(boolean r100, String r101, Integer r110) {
        if (f133316a.monitorDanmakuClick == true) goto L5;
        return;
    L5:
        int r102 = 0;
        String r103 = null;
        long r104 = 0;
        LinkedHashMap r105 = new LinkedHashMap();
        if (r100 == false) goto L8;
        String r106 = "on";
    L9:
        r105.put("beforeClick", r106);
        if (r101 != null) goto L12;
        r101 = "";
    L12:
        r105.put("scene", r101);
        r105.put("tab", String.valueOf(r110));
        Unit r107 = Unit.INSTANCE;
        c r108 = new c(r102, r103, r104, r105, 7);
        r108.a(InteractivityMonitor.Event.DanmakuSwitchClick);
        r108.b(InteractivityTraceMonitor.Event.DanmakuSwitchClick);
        return;
    L8:
        r106 = "off";
        goto L9
    }

    @JvmStatic
    public static final void e(String r100, String r101, Throwable r110) {
        Intrinsics.checkNotNullParameter(r100, "sendType");
        if (f133316a.monitorSendFailed == true) goto L6;
        return;
    L6:
        if ((r110 instanceof CustomApiServerException) == false) goto L11;
        String r102 = ((CustomApiServerException) r110).getErrorMsg();
        if (r102 != null) goto L14;
        r102 = "unknown api exception";
    L14:
        int r103 = -1;
        String r104 = "";
        if (r101 != null) goto L17;
        String r105 = "";
    L18:
        long r106 = 0;
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("send_type", r100);
        if (r102 != null) goto L21;
        r102 = "";
    L21:
        r107.put("fail_reason", r102);
        if (r110 == null) goto L27;
        Throwable r108 = r110.getCause();
        if (r108 == null) goto L27;
        String r109 = r108.getMessage();
        if (r109 == null) goto L27;
    L28:
        r107.put("cause", r109);
        if (r110 == null) goto L34;
        String r111 = r110.getMessage();
        if (r111 == null) goto L34;
        r104 = r111;
    L34:
        r107.put("throwable_msg", r104);
        if (r110 == null) goto L37;
        r107.put("stack", Log.getStackTraceString(r110));
    L37:
        Unit r112 = Unit.INSTANCE;
        new c(r103, r105, r106, r107, 4).b(InteractivityTraceMonitor.Event.SendIntercept);
        return;
    L27:
        r109 = "";
        goto L28
    L17:
        r105 = r101;
        goto L18
    L11:
        if ((r110 instanceof NetworkErrorException) == false) goto L13;
        r102 = "network_error: " + ((NetworkErrorException) r110).statusCode;
        goto L14
    L13:
        r102 = r101;
        goto L14
    }

    @JvmStatic
    public static final void c(String r100, boolean r110, String r111, String r112, Integer r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (f133316a.monitorShow == true) goto L5;
        return;
    L5:
        if (r110 == false) goto L7;
        int r101 = 0;
    L9:
        if (r110 == false) goto L11;
        r111 = "success";
    L13:
        String r102 = r111;
    L14:
        long r103 = 0;
        LinkedHashMap r104 = new LinkedHashMap();
        if (r114 != null) goto L17;
        r114 = "";
    L17:
        r104.put("scene", r114);
        r104.put("source", r100);
        if (r112 != null) goto L20;
        r112 = "";
    L20:
        r104.put("danmakuSwitchStatus", r112);
        r104.put("tab", String.valueOf(r113));
        Unit r105 = Unit.INSTANCE;
        c r106 = new c(r101, r102, r103, r104, 4);
        r106.a(InteractivityMonitor.Event.InputPanelShow);
        r106.b(InteractivityTraceMonitor.Event.InputPanelShow);
        return;
    L11:
        if (r111 != null) goto L13;
        r102 = "";
        goto L14
    L7:
        r101 = -1;
        goto L9
    }
}
