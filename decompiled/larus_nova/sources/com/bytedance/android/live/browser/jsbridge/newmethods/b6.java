package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.browser.jsbridge.base.LiveGameCommonInvokeResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.gameCommonInvoke")
public final class b6 extends w20.p2<w20.pa, LiveGameCommonInvokeResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f63314a = 0;

    public static final class a {
    }

    static {
    }

    public b6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.pa r102 = (w20.pa) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i("LiveGameCommonInvokeMethod", "param " + r102);
        String r103 = r102.a();
        boolean r104 = false;
        boolean r105 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == false) goto L21;
        JsonObject r107 = r102.b();
        if (r107 == null) goto L13;
        String r108 = r107.getAsString();
    L14:
        if (r108 != null) goto L16;
    L19:
        boolean r109 = true;
    L20:
        if (r109 == false) goto L21;
    L22:
        if (r104 == true) goto L24;
        finishWithFailure(new Throwable("params invalid"));
        return;
    L24:
        JsonObject r110 = r102.b();
        Intrinsics.checkNotNull(r110);
        JsonElement r111 = r110.get("from");
        if (r111 == null) goto L29;
        String r112 = r111.getAsString();
        if (r112 == null) goto L29;
        r105 = Intrinsics.areEqual(r112, "mg");
    L29:
        if (r105 == false) goto L33;
        IOpenPlatformMgAnchorService r113 = (IOpenPlatformMgAnchorService) jc1.k.f(IOpenPlatformMgAnchorService.class);
        if (r113 == null) goto L38;
        String r114 = r102.a();
        Intrinsics.checkNotNull(r114);
        JsonObject r115 = r102.b();
        Intrinsics.checkNotNull(r115);
        r113.handleCommonJSBInvoke(r114, r115, new LiveGameCommonInvokeMethod$invoke$1(this));
        return;
    L38:
        return;
    L33:
        IInteractGameService r116 = (IInteractGameService) jc1.k.f(IInteractGameService.class);
        if (r116 == null) goto L40;
        String r117 = r102.a();
        Intrinsics.checkNotNull(r117);
        JsonObject r118 = r102.b();
        Intrinsics.checkNotNull(r118);
        r116.handleAnchorPanelJSBInvoke(r117, r118, new LiveGameCommonInvokeMethod$invoke$2(this));
        return;
    L40:
        return;
    L16:
        if (r108.length() == 0) goto L19;
        r109 = false;
        goto L20
    L13:
        r108 = null;
    L21:
        r104 = true;
        goto L22
    L5:
        if (r103.length() == 0) goto L8;
        r106 = false;
        goto L9
    }
}
