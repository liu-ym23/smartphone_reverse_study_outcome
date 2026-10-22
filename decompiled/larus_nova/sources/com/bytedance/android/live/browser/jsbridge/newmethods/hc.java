package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.SetMessageBoardDataResultModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.oe;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "setMessageBoardData")
public final class hc extends w20.h6<oe, SetMessageBoardDataResultModel> {

    public static final class a {
    }

    static {
    }

    public hc() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        oe r102 = (oe) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r103, "likeRelation") == false) goto L38;
        nm1.e r105 = pm1.f.c();
        com.bytedance.android.livesdk.chatroom.msgboard.a r106 = null;
        if (r105 == null) goto L18;
        ReplayDataContext r107 = r105.h(null);
        if (r107 == null) goto L18;
        com.bytedance.live.datacontext.j<Object> r108 = r107.getVsMsgBoardDataContext();
    L20:
        if ((r108 instanceof com.bytedance.live.datacontext.j) == true) goto L22;
        r108 = null;
    L22:
        if (r108 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.msgboard.a r109 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r108.getValue();
        if (r109 == null) goto L27;
        r106 = r109;
    L32:
        if (r106 == null) goto L36;
        com.bytedance.live.datacontext.n<String> r110 = r106.getCommentLikeRelation();
        if (r110 == null) goto L36;
        r110.setValue(r102.b());
    L36:
        SetMessageBoardDataResultModel r111 = new SetMessageBoardDataResultModel();
        r111.a(SetMessageBoardDataResultModel.Code.Success);
        Unit r112 = Unit.INSTANCE;
        finishWithResult(r111);
        return;
    L27:
        RoomContext r113 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r113 == null) goto L32;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.msgboard.a> r114 = r113.getVsMsgBoardDataContext();
        if (r114 == null) goto L32;
        r106 = r114.getValue();
    L18:
        r108 = null;
        goto L20
    L38:
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
