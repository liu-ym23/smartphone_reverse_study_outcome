package com.bytedance.android.livesdk.interactivity.utils;

import android.net.Uri;
import com.bytedance.android.live.base.model.message.h0;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.bd;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f141415a = 0;

    static {
    }

    public static boolean a(com.bytedance.android.livesdk.interactivity.api.entity.l r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.bytedance.android.live.base.model.message.t r101 = r100.f133174b;
        String r102 = null;
        if ((r101 instanceof bd) == true) goto L5;
        r101 = null;
    L5:
        bd r103 = (bd) r101;
        if (r103 == null) goto L11;
        com.bytedance.android.live.base.model.data.m r104 = r103.itemStyle;
        if (r104 == null) goto L11;
        r102 = r104.itemType;
    L11:
        return Intrinsics.areEqual(r102, BdpAppEventConstant.MICRO_APP);
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = null;
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L8
    L9:
        if (r102 == null) goto L11;
        String r103 = r102.getHost();
    L13:
        if (Intrinsics.areEqual(r103, AppbrandHostConstants.Micro_Host.HOST_APPBRAND) == true) goto L18;
        if (r102 == null) goto L17;
        r101 = r102.getHost();
    L17:
        if (Intrinsics.areEqual(r101, AppbrandHostConstants.Micro_Host.HOST_GAME) == true) goto L18;
        return false;
    L18:
        return true;
    L11:
        r103 = null;
    L8:
        r102 = null;
        goto L9
    }

    public static boolean c(com.bytedance.android.livesdk.interactivity.api.entity.l r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.bytedance.android.live.base.model.message.t r101 = r100.f133174b;
        String r102 = null;
        if ((r101 instanceof h0) == true) goto L5;
        r101 = null;
    L5:
        h0 r103 = (h0) r101;
        if (r103 == null) goto L9;
        r102 = r103.getMessageMethod();
    L9:
        return Intrinsics.areEqual(r102, "WebcastVideoShareMessage");
    }

    public static void d(String r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L11;
        com.bytedance.live.datacontext.i<Boolean> r101 = r100.isAnchor();
        if (r101 == null) goto L11;
        Boolean r102 = r101.getValue();
        if (r102 == null) goto L11;
        r102.booleanValue();
    L11:
        Pair r111 = com.bytedance.android.livesdk.interactivity.p.b(r110, "live_other", g4.d(), com.bytedance.android.ec.core.event.a.VALUE_COMMENT_CARD, com.bytedance.android.ec.core.event.a.VALUE_COMMENT_CARD, LaunchParamConstant$Scene.f83957c);
        if (r111 != null) goto L14;
        return;
    L14:
        com.bytedance.android.livesdk.log.u.l().h(BdpAppEventConstant.EVENT_MP_CLICK, (Map) r111.getSecond(), new Object[]{Room.class});
        TTLiveSDK.hostService().hostOpenPlatform().openMiniApp((String) r111.getFirst(), null);
    }
}
