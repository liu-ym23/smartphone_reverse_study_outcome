package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.browser.jsbridge.base.CheckEffectInUsedResultModel;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "checkEffectInUsed")
public final class w1 extends w20.s<w20.c8, CheckEffectInUsedResultModel> {
    public w1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        w20.c8 r101 = (w20.c8) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r111 = r101.b();
        if (Intrinsics.areEqual(r111, com.bytedance.android.live.effect.api.d0.f66755e) == false) goto L5;
    L8:
        String r112 = com.bytedance.android.live.effect.api.d0.f66753c;
    L9:
        if (r112 != null) goto L11;
        r112 = "";
    L11:
        String r102 = r101.a();
        if (r102 == null) goto L16;
        Long r103 = StringsKt.toLongOrNull(r102);
        if (r103 == null) goto L16;
        long r104 = r103.longValue();
    L17:
        boolean r105 = false;
        if (r112.length() != 0) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == false) goto L23;
    L52:
        finishWithFailure();
        return;
    L23:
        if (r104 == 0) goto L52;
        if (RoomContext.a.c(RoomContext.Companion, null, 0, 3) != null) goto L34;
        IBroadcastService r107 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        if (r107 == null) goto L30;
        LiveMode r108 = r107.getPreviewLiveMode();
    L32:
        if (r108 != LiveMode.VIDEO) goto L34;
        boolean r109 = true;
    L35:
        if (r109 == true) goto L44;
        RoomContext r113 = RoomContext.a.a(null, 0);
        if (r113 == null) goto L43;
        com.bytedance.live.datacontext.i<Boolean> r114 = r113.isAnchor();
        if (r114 == null) goto L43;
        if (r114.getValue().booleanValue() == true) goto L44;
    L43:
        LiveEffectContextFactoryDelegate$Type r115 = LiveEffectContextFactoryDelegate$Type.LINK;
    L45:
        List<String> r116 = LiveEffectContext.f66734h;
        Iterator<Sticker> r117 = LiveEffectContext.a.a(r115).a().o(r112).iterator();
    L47:
        if (r117.hasNext() == false) goto L51;
        if (r117.next().getId() != r104) goto L47;
        r105 = true;
    L51:
        CheckEffectInUsedResultModel r118 = new CheckEffectInUsedResultModel();
        r118.a(CheckEffectInUsedResultModel.Code.Success);
        CheckEffectInUsedResultModel.a r119 = new CheckEffectInUsedResultModel.a();
        r119.a(Boolean.valueOf(r105));
        Unit r120 = Unit.INSTANCE;
        r118.b(r119);
        finishWithResult(r118);
        return;
    L44:
        r115 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        goto L45
    L30:
        r108 = null;
    L34:
        r109 = false;
        goto L35
    L20:
        r106 = false;
    L16:
        r104 = 0;
        goto L17
    L5:
        if (Intrinsics.areEqual(r111, com.bytedance.android.live.effect.api.d0.f66756f) == true) goto L8;
        r112 = r101.b();
        goto L9
    }
}
