package com.bytedance.android.livesdk.interactivity;

import android.content.Context;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.IPSOperatePanelService;
import com.bytedance.android.livesdk.interactivity.utils.PSMessageTypeMap;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/PSOperatePanelService;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/api/IPSOperatePanelService;", "Lcom/bytedance/android/live/base/model/message/t;", "message", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/s;", "messageModel", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/r;", "callback", "", "openOperatePanel", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PSOperatePanelService implements IPSOperatePanelService {
    public PSOperatePanelService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.IPSOperatePanelService
    public void openOperatePanel(com.bytedance.android.live.base.model.message.t r100, Context r110, com.bytedance.android.livesdk.interactivity.api.publicscreen.s r111, com.bytedance.android.livesdk.interactivity.api.publicscreen.r r112) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = com.bytedance.android.livesdk.interactivity.utils.s.f141415a;
        Intrinsics.checkNotNullParameter(r100, "message");
        Boolean r102 = PSMessageTypeMap.f141317a;
        List r103 = PSMessageTypeMap.b(r100.getMessageMethod());
        boolean r104 = false;
        if (r103 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r106 == null) goto L14;
        com.bytedance.live.datacontext.i<Boolean> r107 = r106.isAnchor();
        if (r107 == null) goto L14;
        if (r107.getValue().booleanValue() != true) goto L14;
    L22:
        boolean r108 = true;
    L24:
        ALogger.d("PSOperatePanel", "isValidMessageType:" + r105 + ",isValidPermission:" + r108);
        if (r105 == false) goto L28;
        if (r108 == false) goto L28;
        r104 = true;
    L28:
        if (r104 == false) goto L30;
        ALogger.d("PSOperatePanel", "canOpenPSOperatePanel");
        xs2.b r109 = xs2.b.a();
        com.bytedance.android.livesdk.interactivity.api.entity.l r113 = new com.bytedance.android.livesdk.interactivity.api.entity.l(r100, r110, r112);
        r113.f133173a = r111;
        Unit r114 = Unit.INSTANCE;
        r109.post(r113);
        return;
    L30:
        ALogger.d("PSOperatePanel", "can't OpenPSOperatePanel");
        if (r112 == null) goto L35;
        r112.onFailed();
        return;
    L35:
        return;
    L14:
        IMiddlewareUserService r115 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r115 == null) goto L23;
        com.bytedance.android.livesdk.user.e r116 = r115.user();
        if (r116 == null) goto L23;
        UserAttr r117 = r116.q();
        if (r117 == null) goto L23;
        if (r117.isAdmin() == true) goto L22;
    L23:
        r108 = false;
        goto L24
    L5:
        if ((!r103.isEmpty()) != true) goto L7;
        r105 = true;
        goto L8
    }
}
