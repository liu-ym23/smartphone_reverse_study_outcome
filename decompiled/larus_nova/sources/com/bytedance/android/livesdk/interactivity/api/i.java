package com.bytedance.android.livesdk.interactivity.api;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: classes9.dex */
public final class i {
    public static final h c(MiddlewareRoomContext r100) {
        Object r101 = null;
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.j<ViewModel> r102 = r100.getInteractivityContext();
        if (r102 == null) goto L7;
        ViewModel r103 = r102.getValue();
    L9:
        if ((r103 instanceof h) == false) goto L13;
        r101 = r103;
    L13:
        return (h) r101;
    L7:
        r103 = null;
        goto L9
    }

    public static final h a(DataContext r100, DataCenter r101) {
        Object r102 = null;
        if (r100 == null) goto L18;
        IRoomContextService r103 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r103 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.o r104 = r103.getRoomDataContext(r100);
        if (r104 == null) goto L11;
        com.bytedance.live.datacontext.j<ViewModel> r105 = r104.M1();
        if (r105 == null) goto L11;
        ViewModel r106 = r105.getValue();
    L13:
        if ((r106 instanceof h) == false) goto L17;
        r102 = r106;
    L17:
        return (h) r102;
    L11:
        r106 = null;
        goto L13
    L18:
        IRoomContextService r107 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r107 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.o r108 = IRoomContextService.a.a(r107, r101, 0, 2);
        if (r108 == null) goto L25;
        com.bytedance.live.datacontext.j<ViewModel> r109 = r108.M1();
        if (r109 == null) goto L25;
        ViewModel r110 = r109.getValue();
    L27:
        if ((r110 instanceof h) == false) goto L31;
        r102 = r110;
    L31:
        return (h) r102;
    L25:
        r110 = null;
        goto L27
    }

    public static /* synthetic */ h b(DataCenter r100, int r101) {
        if ((r101 & 2) == 0) goto L6;
        r100 = null;
    L6:
        return a(null, r100);
    }
}
