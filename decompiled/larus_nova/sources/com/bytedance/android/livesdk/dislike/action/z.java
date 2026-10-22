package com.bytedance.android.livesdk.dislike.action;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livehostapi.business.base.IBaseHostShare;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.depend.model.live.LiveRoomMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class z extends OptionAction {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ActionsManager f122100e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final cz.c f() {
        return cz.c.m.f466007c;
    }

    public z(ActionsManager r100) {
        Intrinsics.checkNotNullParameter(r100, "actionManager");
        super(r100);
        this.f122100e = r100;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r310) {
        Intrinsics.checkNotNullParameter(r310, BaseSwitches.V);
        if (LivePlatformPlayerManager.f() != null) goto L5;
        ALogger.e("ShareLiveToDailyAction", "LivePlatformPlayerManager currentClient is null");
    L16:
        Context r100 = r310.getContext();
        com.bytedance.android.livesdk.log.g r101 = com.bytedance.android.livesdk.log.u.l();
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("share_to_story_type", "live_room");
        r102.put("enter_method", "live_room_inner_long_press");
        r102.put("enter_from", this.f122100e.f121952e);
        Unit r103 = Unit.INSTANCE;
        ((ILiveShareService) jc1.k.n(ILiveShareService.class)).cacheMob(r100, r102);
        r101.h("click_share_to_diary", r102, new Object[0]);
        return;
    L5:
        Room r104 = this.f122100e.f121951d;
        if (r104 == null) goto L16;
        Map<String, String> r105 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap();
        ILiveShareService r106 = (ILiveShareService) jc1.k.n(ILiveShareService.class);
        ShareParams.Builder r107 = ShareParams.buildUponRoom(r104).setPlatform(IBaseHostShare.SHARE_TO_DAILY).setLivePlayerClient(LivePlatformPlayerManager.f()).setShareEnterFrom(r105.get("enter_from_merge")).setEnterMethod(r105.get("enter_method")).setShareEnterMethod("inner_long_press");
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() > 0) goto L14;
        Room r108 = this.f122100e.f121951d;
        if (r108 != null) goto L13;
    L15:
        Unit r109 = Unit.INSTANCE;
        ShareParams r110 = r107.build();
        r106.share(new i81.a(null, ContextUtil.contextToActivity(r310.getContext()), null, r110, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "ShareLiveToDailyAction", LiveShareType.SHARE_DIRECT, new a0());
        goto L16
    L13:
        if (r108.getLiveRoomMode() != LiveRoomMode.Audio.getValue()) goto L15;
    L14:
        r107.setEnableScreenShot(false);
        goto L15
    }
}
