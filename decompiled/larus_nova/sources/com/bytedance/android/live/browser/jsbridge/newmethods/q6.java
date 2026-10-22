package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.LiveNotifyLongPressResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.notifyLongPress")
public final class q6 extends w20.b3<JsonObject, LiveNotifyLongPressResultModel> {
    public q6() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i("LiveNotifyLongPressMethod", AbsMethodDelegate.TAG_INVOKE);
        IRoomContextService r102 = (IRoomContextService) jc1.k.f(IRoomContextService.class);     // Catch: Exception -> L12
        IRoom r103 = null;
        if (r102 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.o r104 = IRoomContextService.a.a(r102, null, 0, 3);     // Catch: Exception -> L12
        if (r104 == null) goto L10;
        com.bytedance.live.datacontext.m<IRoom> r105 = r104.getRoom();     // Catch: Exception -> L12
        if (r105 == null) goto L10;
        r103 = r105.getValue();     // Catch: Exception -> L12
    L10:
        xs2.b.a().post(new zg1.h1(26, r103));     // Catch: Exception -> L12
        LiveNotifyLongPressResultModel r106 = new LiveNotifyLongPressResultModel();     // Catch: Exception -> L12
        r106.a(LiveNotifyLongPressResultModel.Code.Success);     // Catch: Exception -> L12
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L12
        finishWithResult(r106);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        ALogger.e("LiveNotifyLongPressMethod", "invoke failed ex " + e.getMessage());
        LiveNotifyLongPressResultModel r108 = new LiveNotifyLongPressResultModel();
        r108.a(LiveNotifyLongPressResultModel.Code.Failed);
        r108.b(e.getMessage());
        Unit r109 = Unit.INSTANCE;
        finishWithResult(r108);
    }
}
