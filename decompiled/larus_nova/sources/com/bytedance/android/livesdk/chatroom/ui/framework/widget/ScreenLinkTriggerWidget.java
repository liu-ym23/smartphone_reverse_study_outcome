package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.utils.f4;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/ScreenLinkTriggerWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/s;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScreenLinkTriggerWidget extends MiddlewareRoomWidget implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.c f113206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.a f113207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f4 f113208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y0 f113209d;

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.s
    public final tlc.d gi() {
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L8;
        vlc.d r101 = (vlc.d) r100.get("data_message_manager", null);
        if (r101 == null) goto L8;
        r101.removeMessageListener(this.f113208c);
    L8:
        return this.f113208c.f114469a;
    }

    public final void wq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r100 = this.f113206a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.hq() != true) goto L11;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r101 = this.f113207b;
        if (r101 == null) goto L12;
        j70.f r102 = com.bytedance.android.livesdk.chatroom.ui.framework.f.f112942a;
        r101.Og(com.bytedance.android.livesdk.chatroom.ui.framework.f.L);
        return;
    L12:
        return;
    }

    public ScreenLinkTriggerWidget() {
        this.f113208c = new f4();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.f113206a = ho1.a.d(getComponentContext());
        this.f113207b = ho1.a.c(getComponentContext());
        ho1.a.p(getComponentContext(), s.class, this);
        LivePluginSPIManager.f85856e.getClass();
        if (LivePluginSPIManager.b() == true) goto L5;
    L17:
        wq();
        return;
    L5:
        if (LivePluginSPIManager.c() == true) goto L17;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r100 = this.f113206a;
        if (r100 != null) goto L9;
    L11:
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L16;
        vlc.d r102 = (vlc.d) r101.get("data_message_manager", null);
        if (r102 == null) goto L16;
        r102.addMessageListener(MessageType.LINKER.getIntType(), this.f113208c);
    L16:
        y0 r103 = new y0(this);
        this.f113209d = r103;
        Unit r104 = Unit.INSTANCE;
        LivePluginSPIManager.d(r103);
        return;
    L9:
        if (r100.o5() != true) goto L11;
        LivePluginSPIManager.a().addOnSuccess(new x0(this)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare("AudienceLandscapeInteractionFragment");
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        y0 r100 = this.f113209d;
        if (r100 == null) goto L5;
        LivePluginSPIManager.f85856e.getClass();
        LivePluginSPIManager.e(r100);
    L5:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        ho1.a.q(getComponentContext(), s.class);
        this.f113206a = null;
        this.f113207b = null;
    }
}
