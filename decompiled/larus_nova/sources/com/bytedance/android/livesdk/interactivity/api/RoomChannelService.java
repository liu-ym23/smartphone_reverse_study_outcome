package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.interactivity.chatchannel.manager.ChatChannelManager;
import com.bytedance.android.livesdk.interactivity.chatchannel.toolbar.ChatChannelLandscapeToolbarBehavior;
import com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelLandscapeWidgetV2;
import com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelWidgetV2;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelAtmosphereWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelCommentWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelIMEmojiAnimWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelInviteButtonWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelServiceWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.ChannelEmptyWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.z;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0002H\u0016J\u0012\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0002H\u0016J\u0012\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0002H\u0016J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00170\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0002H\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/RoomChannelService;", "Lcom/bytedance/android/livesdk/interactivity/api/IRoomChannelService;", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getChatChannelServiceWidget", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getChannelInviteWidget", "getChannelCommentWidget", "getChannelEmptyWidget", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Ls22/e$b;", "config", "Ls22/e;", "createChatChannelManager", "Ls22/a;", "chatChannel", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/c;", "createChatChannelPage", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "getChatChannelWidget", "", RemoteMessageConst.Notification.CHANNEL_ID, "createChatChannelLandscapeWidget", "manager", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "createChatChannelLandscapeToolbarBehavior", "getChatChannelAtmosphereWidget", "getChatChannelIMEmojiAnimWidget", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomChannelService implements IRoomChannelService {
    public RoomChannelService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomChannelService
    public Widget getChatChannelAtmosphereWidget() {
        return new ChatChannelAtmosphereWidget();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomChannelService
    public Class<? extends LiveRecyclableWidget> getChannelCommentWidget() {
        return ChatChannelCommentWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomChannelService
    public Class<? extends LiveRecyclableWidget> getChannelEmptyWidget() {
        return ChannelEmptyWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomChannelService
    public Class<? extends LiveRecyclableWidget> getChannelInviteWidget() {
        return ChatChannelInviteButtonWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomChannelService
    public Class<? extends LiveRecyclableWidget> getChatChannelIMEmojiAnimWidget() {
        return ChatChannelIMEmojiAnimWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomChannelService
    public Class<? extends Widget> getChatChannelServiceWidget() {
        return ChatChannelServiceWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomChannelService
    public Class<? extends LiveWidget> getChatChannelWidget() {
        return ChatChannelWidgetV2.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomChannelService
    public LiveWidget createChatChannelLandscapeWidget(long r100) {
        return new ChatChannelLandscapeWidgetV2();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomChannelService
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c createChatChannelPage(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "chatChannel");
        return new z(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomChannelService
    public c0.b createChatChannelLandscapeToolbarBehavior(RoomContext r100, DataCenter r101, s22.e r102) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "manager");
        return new ChatChannelLandscapeToolbarBehavior(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IRoomChannelService
    public s22.e createChatChannelManager(RoomContext r100, DataCenter r101, Context r102, s22.e.b r103) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "config");
        return new ChatChannelManager(r100, r101, r102, r103);
    }
}
