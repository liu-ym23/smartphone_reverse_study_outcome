package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.SendLiveMicroAppLogResultModel;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendLiveMicroAppLog")
public final class sb extends w20.a6<w20.ge, SendLiveMicroAppLogResultModel> {
    public sb() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        w20.ge r112 = (w20.ge) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        RoomContext r113 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r113 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r100 = r113.isAnchor();
        if (r100 == null) goto L9;
        Boolean r101 = r100.getValue();
        if (r101 == null) goto L9;
        boolean r102 = r101.booleanValue();
    L10:
        if (r102 == false) goto L12;
        Map<String, String> r103 = ((IOpenPlatformAnchorService) jc1.k.n(IOpenPlatformAnchorService.class)).getCommonEventParams();
    L14:
        if (r113 != null) goto L16;
        Object[] r114 = new Object[0];
    L17:
        com.bytedance.android.livesdk.log.g r104 = com.bytedance.android.livesdk.log.u.l();
        String r105 = r112.a();
        LinkedHashMap r106 = new LinkedHashMap();
        if (r103 != null) goto L20;
        r103 = MapsKt.emptyMap();
    L20:
        r106.putAll(r103);
        JsonObject r115 = r112.b();
        LinkedHashMap r107 = new LinkedHashMap();
        if (r115 == null) goto L28;
        Set<String> r108 = r115.keySet();
        if (r108 == null) goto L28;
        Iterator<T> r109 = r108.iterator();
    L26:
        if (r109.hasNext() == false) goto L28;
        String r116 = (String) r109.next();
        r107.put(r116, r115.get(r116).getAsString());
    L28:
        r106.putAll(r107);
        Unit r117 = Unit.INSTANCE;
        r104.h(r105, r106, new Object[]{r114});
        finishWithSuccess();
        return;
    L16:
        r114 = new Class[]{Room.class, am2.x.class};
        goto L17
    L12:
        r103 = ((IOpenPlatformAudienceService) jc1.k.n(IOpenPlatformAudienceService.class)).getCommonEventParams();
    L9:
        r102 = true;
        goto L10
    }
}
