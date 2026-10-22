package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Bundle;
import com.bytedance.android.live.media.api.IMediaReplayService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/FullVideoServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FullVideoServiceWidget extends MiddlewareRoomWidget {
    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r100 = ho1.a.d(getComponentContext());
        Room r101 = null;
        if (r100 == null) goto L5;
        Bundle r102 = r100.Wl();
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r103 = ho1.a.d(getComponentContext());
        if (r103 == null) goto L9;
        r101 = r103.getRoom();
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NO_FULL_VIDEO_BTN, false) == false) goto L13;
        return;
    L13:
        if (PadConfigUtils.c() == false) goto L15;
        return;
    L15:
        if (jc1.k.f(IMediaReplayService.class) == null) goto L20;
        IMediaReplayService r104 = (IMediaReplayService) jc1.k.f(IMediaReplayService.class);
        if (r104 == null) goto L20;
        if (r104.isShowGenerating() != true) goto L20;
        return;
    L20:
        RoomContext.a r105 = RoomContext.Companion;
        DataCenter r106 = this.dataCenter;
        long r107 = 0;
        if (r101 == null) goto L23;
        long r108 = r101.getId();
    L24:
        r105.getClass();
        if (RoomContext.a.a(r106, r108) == null) goto L39;
        DataCenter r109 = this.dataCenter;
        if (r101 == null) goto L29;
        r107 = r101.getId();
    L29:
        RoomContext r110 = RoomContext.a.a(r109, r107);
        if (r110 == null) goto L40;
        com.bytedance.live.datacontext.m<Boolean> r111 = r110.getShowFullVideoButton();
        if (r111 == null) goto L41;
        r111.setValue(Boolean.TRUE);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L23:
        r108 = 0;
        goto L24
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
    }

    public FullVideoServiceWidget() {
    }
}
