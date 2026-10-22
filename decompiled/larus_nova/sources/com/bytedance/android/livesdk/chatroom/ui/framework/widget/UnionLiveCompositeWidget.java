package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.AnchorUnionLiveDataContext;
import com.bytedance.android.livesdk.message.model.om;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/UnionLiveCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UnionLiveCompositeWidget extends MiddlewareRoomWidget implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.widget.unionlive.c f113265a;

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        if (this.dataContext == null) goto L12;
        AnchorUnionLiveDataContext r100 = new AnchorUnionLiveDataContext();
        r100.reqAnchorUnionLiveAccess(this.dataCenter);
        DataContext r101 = this.dataContext;
        if ((r101 instanceof RoomContext) == true) goto L7;
        r101 = null;
    L7:
        RoomContext r102 = (RoomContext) r101;
        if (r102 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.room.c> r103 = r102.getAnchorUnionLiveDataContext();
        if (r103 == null) goto L12;
        r103.d(r100);
    L12:
        DataCenter r104 = this.dataCenter;
        if (r104 == null) goto L18;
        vlc.d r105 = (vlc.d) r104.get("data_message_manager", null);
        if (r105 == null) goto L19;
        r105.addMessageListener(MessageType.ROOM_UNION_LIVE_MESSAGE.getWsMethod(), this);
        r105.addMessageListener(MessageType.UNION_LIVE_NOTICE_MESSAGE.getWsMethod(), this);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L8;
        vlc.d r101 = (vlc.d) r100.get("data_message_manager", null);
        if (r101 == null) goto L9;
        r101.removeMessageListener(this);
        return;
    L9:
        return;
    }

    public UnionLiveCompositeWidget() {
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getMessageMethod();
        if (r101 == null) goto L5;
    L7:
        if (Intrinsics.areEqual(r101, MessageType.ROOM_UNION_LIVE_MESSAGE.getWsMethod()) == false) goto L10;
        int r102 = com.bytedance.android.live.room.utils.c.f100395a;
        com.bytedance.android.live.room.utils.c.a(this.dataCenter, r100);
        return;
    L10:
        if (Intrinsics.areEqual(r101, MessageType.UNION_LIVE_NOTICE_MESSAGE.getWsMethod()) == true) goto L12;
        return;
    L12:
        if ((r100 instanceof om) == false) goto L59;
        om r103 = (om) r100;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r104 = ho1.a.d(getComponentContext());
        if (r104 != null) goto L16;
    L17:
        if (r104 != null) goto L19;
        return;
    L19:
        if (r104.V9() != true) goto L63;
    L21:
        com.bytedance.android.livesdk.chatroom.widget.unionlive.c r105 = this.f113265a;
        FragmentActivity r106 = null;
        if (r105 == null) goto L41;
        Handler r107 = DialogLancet.resolveDialogHandler(r105);
        if (r107 != null) goto L26;
    L28:
        DialogLancet.beforeDialogDismiss(r105);
        r105.dismiss();     // Catch: Throwable -> L31 Exception -> L33
    L37:
        DialogLancet.afterDialogDismiss(r105);
    L38:
        this.f113265a = null;
        goto L41
    L31:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r105);
        throw th;
    L33:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L31
        Throwable r108 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L31
        if (r108 == null) goto L37;
        com.bytedance.crash.d.d(r108, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L31
        goto L37
    L26:
        if (Looper.myLooper() == r107.getLooper()) goto L28;
        r107.post(DialogLancet.createDismissRunnable(r105));
    L41:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r109 = ho1.a.d(getComponentContext());
        if (r109 == null) goto L44;
        r106 = r109.p0();
    L44:
        if (r106 == null) goto L61;
        com.bytedance.android.livesdk.chatroom.widget.unionlive.c r110 = new com.bytedance.android.livesdk.chatroom.widget.unionlive.c(r106, r103);
        this.f113265a = r110;
        if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r110);
        return;
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L51
    L49:
        DialogLancet.beforeDialogShow(r110);
        r110.show();
        DialogLancet.afterDialogShow(r110);
        return;
    L61:
        return;
    L63:
        return;
    L16:
        if (r104.dg() == true) goto L21;
    L59:
        return;
    L5:
        r101 = "";
        goto L7
    }
}
