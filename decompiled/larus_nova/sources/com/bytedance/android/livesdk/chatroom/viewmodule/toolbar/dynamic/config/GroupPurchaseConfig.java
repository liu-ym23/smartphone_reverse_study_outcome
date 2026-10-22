package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarGroupPurchaseAudienceBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarGroupPurchaseWidgetBehavior;
import com.bytedance.android.livesdk.room.placeholder.behavior.AudienceGroupPurchaseWrapper;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class GroupPurchaseConfig extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f115972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f115973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f115974h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean m() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(ToolbarButton.GROUP_PURCHASE_AUDIENCE, null, ToolbarButton.GROUP_PURCHASE, ToolbarButton.GROUP_PURCHASE_MORE);
    }

    public final Context getContext() {
        return this.f115973g;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.LifeGroupon.INSTANCE;
    }

    public GroupPurchaseConfig(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super(null, null, 7);
        this.f115973g = r100;
        this.f115974h = r101;
        this.f115972f = LazyKt.lazy(GroupPurchaseConfig$liveLocalLifeService$2.INSTANCE);
        IHostLiveLocalLife r102 = (IHostLiveLocalLife) jc1.k.f(IHostLiveLocalLife.class);
        if (r102 == null) goto L7;
        if (r102.getLiveLifeIconButtonOptEnable() != true) goto L7;
        return;
    L7:
        if (com.bytedance.android.live.core.utils.z.e(r101, false) == true) goto L12;
        Lazy r103 = ToolbarComponentCheckManager.f115947a;
        ToolbarComponentCheckManager.e(r101, NewToolbarButtonConstants.LifeGroupon.INSTANCE, new k(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "button");
        if (r102 == false) goto L8;
        LiveMode r103 = (LiveMode) this.f115974h.get("data_live_mode", LiveMode.VIDEO);
        int r104 = ToolbarGroupPurchaseWidgetBehavior.f116985l;
        if (ToolbarGroupPurchaseWidgetBehavior.a.a(r103) == true) goto L17;
        return null;
    L17:
        return new ToolbarGroupPurchaseWidgetBehavior(r101);
    L8:
        Object r105 = r100.f116202l.f116105c;
        IHostLiveLocalLife r106 = (IHostLiveLocalLife) jc1.k.f(IHostLiveLocalLife.class);
        if (r106 == null) goto L16;
        if (r106.getLiveLifeIconButtonOptEnable() != true) goto L16;
        if ((r105 instanceof IExternalButton) == false) goto L16;
        return new AudienceGroupPurchaseWrapper((IExternalButton) r105);
    L16:
        return new ToolbarGroupPurchaseAudienceBehavior(this.f115973g);
    }

    public static final void q(GroupPurchaseConfig r110, boolean r111, long r112, ToolbarMatchInterface r113, Function0 r114, Function1 r115, boolean r116, String r117) {
        IHostLiveLocalLife r100 = (IHostLiveLocalLife) r110.f115972f.getValue();
        if (r100 == null) goto L9;
        if (r111 == false) goto L6;
        String r101 = "push";
    L7:
        r100.getLifeComponentInfo(r101, r112, new j(r110, r111, r115, r116, r113, r114), com.bytedance.android.live.core.utils.z.d(r110.f115974h, null), r117);
        return;
    L6:
        r101 = "enter";
        goto L7
    }
}
