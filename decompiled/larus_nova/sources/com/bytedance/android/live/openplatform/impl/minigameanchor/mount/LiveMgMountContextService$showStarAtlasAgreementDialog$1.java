package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"reportClick", "", "clickType", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveMgMountContextService$showStarAtlasAgreementDialog$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ LiveMgMountContextService this$0;

    public LiveMgMountContextService$showStarAtlasAgreementDialog$1(LiveMgMountContextService r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "clickType");
        LiveMgMountContextService r101 = this.this$0;
        int r102 = LiveMgMountContextService.f85202h;
        AnchorMiniGameAppLogContextService r103 = (AnchorMiniGameAppLogContextService) r101.getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class);
        HashMap<String, String> r104 = new HashMap();
        int r105 = v.f85256a;
        c0 r106 = this.this$0.f85208f;
        if (r106 == null) goto L5;
        String r107 = r106.f59335a;
    L6:
        r104.put("source", v.a(r107));
        r104.put("click_type", r100);
        Unit r108 = Unit.INSTANCE;
        r103.reportLiveRoomMgAppLog("mp_star_task_authorization_click", r104);
        return;
    L5:
        r107 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
