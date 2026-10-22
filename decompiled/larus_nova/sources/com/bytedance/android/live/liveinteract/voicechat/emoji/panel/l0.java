package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l0 extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.model.interact.r f80226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f80227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f80228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f80229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f80230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ILinkmicInteractEntrance f80231k;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        ILinkmicInteractEntrance r100 = this.f80231k;
        if (r100 == null) goto L6;
        String r101 = r100.getName();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String f() {
        return this.f80227g;
    }

    public final Context getContext() {
        return this.f80229i;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final boolean i() {
        return this.f80228h;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void a(HSImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        com.bytedance.android.livesdk.chatroom.model.interact.r r101 = this.f80226f;
        if (r101 == null) goto L5;
        py.k r102 = r101.getIcon();
    L6:
        ImageUtil.loadRoundImage(r100, r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r110) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        com.bytedance.android.livesdk.chatroom.model.interact.r r111 = this.f80226f;
        if (r111 == null) goto L6;
        String r112 = r111.getSchema();
        if (r112 == null) goto L6;
    L8:
        if (r112.length() <= 0) goto L10;
        boolean r100 = true;
    L11:
        if (r100 == false) goto L13;
        u6 r101 = new u6(r112);
        u6 r113 = r101.d("url");
        r113.b(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, this.f80230j.toString());
        r113.b("function_type", ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentFunctionType());
        r113.b("live_type", ((IInteractService) jc1.k.n(IInteractService.class)).getLiveTypeForLog());
        ((IBaseLiveActionHandler) jc1.k.n(IBaseLiveActionHandler.class)).handle(this.f80229i, r101.c());
    L13:
        int r114 = dk0.b.f468988a;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_link_interact_panel_head_decorate_icon_click", new HashMap(), new Object[]{IRoom.class});
        com.bytedance.android.livesdk.chatroom.model.interact.r r115 = this.f80226f;
        Map<String, List<ILinkmicInteractEntrance>> r102 = null;
        List<ILinkmicInteractEntrance> r103 = null;
        if (r115 == null) goto L16;
        Boolean r116 = r115.getClickToNext();
    L18:
        if (Intrinsics.areEqual(r116, Boolean.TRUE) == false) goto L95;
        String r117 = this.f80230j;
        if (r117 != null) goto L22;
    L25:
        boolean r118 = true;
    L26:
        if (r118 == false) goto L59;
        IInteractService r119 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r119 == null) goto L30;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r120 = r119.getLinkUserInfoCenter();
    L32:
        if ((r120 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L34;
        r120 = null;
    L34:
        com.bytedance.android.live.liveinteract.plantform.core.y r121 = (com.bytedance.android.live.liveinteract.plantform.core.y) r120;
        if (r121 == null) goto L37;
        r103 = r121.D;
    L37:
        if (r103 == null) goto L95;
        ArrayList r122 = new ArrayList();
        Iterator r104 = r103.iterator();
    L40:
        if (r104.hasNext() == false) goto L49;
        Object r105 = r104.next();
        ILinkmicInteractEntrance r106 = (ILinkmicInteractEntrance) r105;
        if ((r106 instanceof ILinkmicInteractEntrance) == true) goto L44;
    L46:
        boolean r107 = false;
    L47:
        if (r107 == false) goto L40;
        r122.add(r105);
        goto L40
    L44:
        if (r106.getEntranceId() != this.f80231k.getEntranceId()) goto L46;
        r107 = true;
        goto L47
    L49:
        ILinkmicInteractEntrance r123 = (ILinkmicInteractEntrance) CollectionsKt.firstOrNull(r122);
        if (r123 == null) goto L95;
        List<com.bytedance.android.livesdk.chatroom.model.interact.r> r108 = r123.getButtons();
        if (r108 == null) goto L54;
        int r109 = r108.size();
    L55:
        if (r109 <= 1) goto L95;
        List<com.bytedance.android.livesdk.chatroom.model.interact.r> r124 = r123.getButtons();
        if (r124 == null) goto L95;
        com.bytedance.android.livesdk.chatroom.model.interact.r r125 = (com.bytedance.android.livesdk.chatroom.model.interact.r) ListProtector.remove(r124, 0);
        goto L95
    L54:
        r109 = 0;
        goto L55
    L30:
        r120 = null;
        goto L32
    L59:
        IInteractService r126 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r126 == null) goto L62;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r127 = r126.getLinkUserInfoCenter();
    L64:
        if ((r127 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L66;
        r127 = null;
    L66:
        com.bytedance.android.live.liveinteract.plantform.core.y r128 = (com.bytedance.android.live.liveinteract.plantform.core.y) r127;
        if (r128 == null) goto L69;
        r102 = r128.E;
    L69:
        if (r102 == null) goto L95;
        if (r102.containsKey(this.f80230j) != true) goto L95;
        List<ILinkmicInteractEntrance> r129 = r102.get(this.f80230j);
        if (r129 == null) goto L95;
        ArrayList r130 = new ArrayList();
        Iterator<T> r131 = r129.iterator();
    L76:
        if (r131.hasNext() == false) goto L85;
        Object r132 = r131.next();
        ILinkmicInteractEntrance r133 = (ILinkmicInteractEntrance) r132;
        if ((r133 instanceof ILinkmicInteractEntrance) == true) goto L80;
    L82:
        boolean r134 = false;
    L83:
        if (r134 == false) goto L76;
        r130.add(r132);
        goto L76
    L80:
        if (r133.getEntranceId() != this.f80231k.getEntranceId()) goto L82;
        r134 = true;
        goto L83
    L85:
        ILinkmicInteractEntrance r135 = (ILinkmicInteractEntrance) CollectionsKt.firstOrNull(r130);
        if (r135 == null) goto L95;
        List<com.bytedance.android.livesdk.chatroom.model.interact.r> r136 = r135.getButtons();
        if (r136 == null) goto L90;
        int r137 = r136.size();
    L91:
        if (r137 <= 1) goto L95;
        List<com.bytedance.android.livesdk.chatroom.model.interact.r> r138 = r135.getButtons();
        if (r138 == null) goto L95;
        com.bytedance.android.livesdk.chatroom.model.interact.r r139 = (com.bytedance.android.livesdk.chatroom.model.interact.r) ListProtector.remove(r138, 0);
        goto L95
    L90:
        r137 = 0;
        goto L91
    L62:
        r127 = null;
        goto L64
    L22:
        if (r117.length() == 0) goto L25;
        r118 = false;
    L95:
        this.f80221e.dismissDialog();
        return;
    L16:
        r116 = null;
        goto L18
    L10:
        r100 = false;
    L6:
        r112 = "";
        goto L8
    }

    public l0(q0 r100, Context r101, String r102, ILinkmicInteractEntrance r103) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "targetUser");
        Intrinsics.checkNotNullParameter(r103, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        super(r100);
        this.f80229i = r101;
        this.f80230j = r102;
        this.f80231k = r103;
        List<com.bytedance.android.livesdk.chatroom.model.interact.r> r104 = r103.getButtons();
        boolean r105 = false;
        if (r104 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.model.interact.r r106 = (com.bytedance.android.livesdk.chatroom.model.interact.r) ListProtector.get(r104, 0);
    L6:
        this.f80226f = r106;
        if (r106 == null) goto L10;
        String r107 = r106.getToast();
        if (r107 == null) goto L10;
    L11:
        this.f80227g = r107;
        if (r106 == null) goto L14;
        r105 = r106.getDisable();
    L14:
        this.f80228h = r105;
        return;
    L10:
        r107 = "";
        goto L11
    L5:
        r106 = null;
        goto L6
    }
}
