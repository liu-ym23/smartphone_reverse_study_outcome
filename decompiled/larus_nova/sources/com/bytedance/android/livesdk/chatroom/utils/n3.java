package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.config.gz0;
import com.bytedance.android.livesdkapi.ws.LiveWsBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n3 {
    @JvmStatic
    public static final vlc.d b() {
        MiddlewareRoomContext r100 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.j<vlc.d> r101 = r100.getMessageManager();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    L8:
        return null;
    }

    @JvmStatic
    public static final boolean h() {
        com.ss.ugc.live.sdk.msg.network.l r100 = null;
        MiddlewareRoomContext r101 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L38;
        com.bytedance.live.datacontext.j<vlc.d> r102 = r101.getMessageManager();
        if (r102 == null) goto L39;
        vlc.d r103 = r102.getValue();
        if (r103 != null) goto L10;
        return false;
    L10:
        if ((r103 instanceof vlc.e) == true) goto L12;
        r103 = null;
    L12:
        vlc.e r104 = (vlc.e) r103;
        if (r104 == null) goto L15;
        amc.e r105 = r104.q();
    L17:
        if ((r105 instanceof hm2.h) == true) goto L19;
        r105 = null;
    L19:
        hm2.h r106 = (hm2.h) r105;
        if (r106 == null) goto L40;
        com.ss.ugc.live.sdk.msg.network.l r107 = r106.f485778o;
        if ((r107 instanceof im2.k) == false) goto L25;
        r100 = r107;
    L25:
        im2.k r108 = (im2.k) r100;
        if (r108 == null) goto L34;
        im2.k.d r109 = r108.f490487d;
        if (r109 == null) goto L34;
        LiveWsBridge r110 = r109.f490502a.f490484a;
        if (r110 == null) goto L34;
        if (r110.isConnected() != true) goto L34;
        boolean r111 = true;
    L35:
        if (r111 != true) goto L41;
        return true;
    L41:
        return false;
    L34:
        r111 = false;
        goto L35
    L40:
        return false;
    L15:
        r105 = null;
        goto L17
    L39:
        return false;
    L38:
        return false;
    }

    static {
    }

    @JvmStatic
    public static final ylc.e a(long r100) {
        com.bytedance.android.livesdk.config.setting.q r101 = gz0.f120325a.getValue();
        return new ylc.e(r100, new ylc.d(r101.a(), CollectionsKt.toSet(r101.b())), new bc2.e());
    }

    @JvmStatic
    public static final vlc.d c(long r100) {
        MiddlewareRoomContext r101 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, r100, 1);
        if (r101 == null) goto L8;
        com.bytedance.live.datacontext.j<vlc.d> r102 = r101.getMessageManager();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getValue();
    L8:
        return null;
    }

    @JvmStatic
    public static final vlc.d d(MiddlewareRoomContext r100) {
        if (r100 == null) goto L6;
        com.bytedance.live.datacontext.j<vlc.d> r101 = r100.getMessageManager();
        if (r101 == null) goto L6;
        return r101.getValue();
    L6:
        return null;
    }

    @JvmStatic
    public static final vlc.d e(DataCenter r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return (vlc.d) r100.get("data_message_manager", null);
    }

    public static /* synthetic */ ylc.e g(MiddlewareRoomContext r100) {
        return f(r100, r100.getRoom().getValue().getRoomId());
    }

    @JvmStatic
    public static final ylc.e f(MiddlewareRoomContext r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        ylc.e r102 = r100.getWrdsManager().getValue();
        if (r102 != null) goto L7;
        r102 = a(r101);
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        Intrinsics.checkNotNullParameter(r102, "wrdsManager");
        if (r100.isCleared() == true) goto L7;
        r100.getWrdsManager().d(r102);
    L7:
        return r102;
    }
}
