package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.PopularCardIconModel;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.sti.framework.IShortTermIconFramework;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/ShortTouchFrameWorkServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortTouchFrameWorkServiceWidget extends MiddlewareRoomWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.c f113250a;

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r100 = ho1.a.d(getComponentContext());
        this.f113250a = r100;
        ViewGroup r101 = null;
        if (this.dataContext == null) goto L33;
        if (r100 == null) goto L6;
        boolean r102 = r100.dg();
    L7:
        if (r102 == false) goto L33;
        DataContext r103 = this.dataContext;
        if ((r103 instanceof RoomContext) == true) goto L11;
        r103 = null;
    L11:
        RoomContext r104 = (RoomContext) r103;
        if (r104 == null) goto L16;
        com.bytedance.live.datacontext.j<IShortTermIconFramework> r105 = r104.getShortTermIconFramework();
        if (r105 == null) goto L16;
        IShortTermIconFramework r106 = r105.getValue();
    L18:
        if (tb1.c.f545231c == false) goto L33;
        DataContext r107 = this.dataContext;
        if ((r107 instanceof RoomContext) == true) goto L22;
        r107 = null;
    L22:
        RoomContext r108 = (RoomContext) r107;
        if (r108 == null) goto L30;
        com.bytedance.live.datacontext.m<Room> r109 = r108.getRoom();
        if (r109 == null) goto L30;
        Room r110 = r109.getValue();
        if (r110 == null) goto L30;
        if (r110.isStar() == true) goto L33;
    L30:
        if (r106 == null) goto L33;
        r106.load(PopularCardIconModel.class);
    L16:
        r106 = null;
        goto L18
    L6:
        r102 = false;
    L33:
        if (SettingUtil.isLocalTest() == false) goto L82;
        h70.b r111 = getComponentContext();
        if ((r111 instanceof com.bytedance.android.livesdk.widgetdescriptor.e0) == true) goto L37;
        r111 = null;
    L37:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r112 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r111;
        if (r112 == null) goto L83;
        DataCenter r113 = r112.f467480h;
        if (r113 == null) goto L85;
        h70.b r114 = getComponentContext();
        if ((r114 instanceof com.bytedance.android.livesdk.widgetdescriptor.e0) == true) goto L45;
        r114 = null;
    L45:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r115 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r114;
        if (r115 == null) goto L84;
        MiddlewareRoomContext r116 = d90.e.l(r115);
        if (r116 == null) goto L86;
        h70.b r117 = getComponentContext();
        if (r117 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r118 = ho1.a.i(r117);
        if (r118 == null) goto L55;
        View r119 = r118.Fo();
    L57:
        if ((r119 instanceof ViewGroup) == true) goto L59;
        r119 = null;
    L59:
        ViewGroup r120 = (ViewGroup) r119;
        if (r120 == null) goto L87;
        h70.b r121 = getComponentContext();
        if (r121 == null) goto L67;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r122 = ho1.a.i(r121);
        if (r122 == null) goto L67;
        ViewGroup r123 = r122.Wa();
    L69:
        if ((r123 instanceof RelativeLayout) == false) goto L72;
        r101 = r123;
    L72:
        RelativeLayout r124 = (RelativeLayout) r101;
        if (r124 == null) goto L88;
        com.bytedance.android.livesdk.chatroom.indicator.shortterm.h.a(r113, r116, r120, this, r124);     // Catch: Exception -> L77
        return;
    L77:
        e = move-exception;
        e.printStackTrace();
        return;
    L88:
        return;
    L67:
        r123 = null;
        goto L69
    L87:
        return;
    L55:
        r119 = null;
        goto L57
    L86:
        return;
    L84:
        return;
    L85:
        return;
    L83:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
    }

    public ShortTouchFrameWorkServiceWidget() {
    }
}
