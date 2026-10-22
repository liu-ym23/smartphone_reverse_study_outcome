package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import android.os.Build;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.interactivity.api.settings.config.v0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.w0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r52.c4;
import r52.d4;
import r52.f0;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0 f132972a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f132973b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Integer> f132974c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Integer> f132975d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final w0 f132976e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Boolean f132977f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f132978g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f132979h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f132980i = false;

    static {
        c4 r100 = c4.f536162a;
        v0 r101 = r100.getValue();
        f132972a = r101;
        f132973b = r100.getValue().h();
        List<Integer> r102 = r101.a();
        if (r102 != null) goto L5;
        r102 = CollectionsKt.emptyList();
    L5:
        f132974c = r102;
        List<Integer> r103 = r101.d();
        if (r103 != null) goto L8;
        r103 = CollectionsKt.emptyList();
    L8:
        f132975d = r103;
        w0 r104 = d4.f536168a.getValue();
        f132976e = r104;
        f132977f = f0.f536176a.getValue();
        f132978g = r104.i();
        f132979h = r104.g();
        if (r104.h() == true) goto L11;
    L13:
        boolean r105 = false;
    L14:
        f132980i = r105;
        return;
    L11:
        if (Build.VERSION.SDK_INT < 31) goto L13;
        r105 = true;
        goto L14
    }

    public static boolean d(User r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r100.isMysteryMan() == true) goto L16;
        IInteractService r101 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r101 == null) goto L12;
        if (r101.isAnonymousUser(r100.getUserId()) != true) goto L12;
        return true;
    L12:
        if (r100.isAnonymous() == true) goto L18;
        return false;
    L18:
        return true;
    L16:
        return true;
    }

    public static boolean a(DataCenter r110, MiddlewareRoomContext r111) {
        Intrinsics.checkNotNullParameter(r111, "roomContext");
        boolean r100 = r111.isAnchor().getValue().booleanValue();
        boolean r101 = r111.getRoom().getValue().getRoomAuthStatus().isEnableAnchorChannel();
        boolean r112 = r111.getRoom().getValue().getRoomAuthStatus().isEnableRoomChannel();
        com.bytedance.android.livesdk.interactivity.api.h r102 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r102 == null) goto L9;
        com.bytedance.live.datacontext.j<Long> r103 = r102.getUserFansCountOnStart();
        if (r103 == null) goto L9;
        Long r104 = r103.getValue();
        if (r104 == null) goto L9;
        long r105 = r104.longValue();
    L10:
        w0 r106 = f132976e;
        if (r105 < r106.c()) goto L13;
        boolean r107 = true;
    L14:
        boolean r108 = r106.b();
        List<Integer> r109 = r106.a();
        if (r109 != null) goto L17;
        r109 = CollectionsKt.emptyList();
    L17:
        boolean r113 = c(r110, r109);
        if (r108 == false) goto L26;
        if (r100 == false) goto L27;
        if (r112 == false) goto L28;
        if (r101 == false) goto L29;
        if (r107 == false) goto L30;
        if (r113 == true) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L29:
        return false;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    L13:
        r107 = false;
    L9:
        r105 = 0;
        goto L10
    }

    public static boolean b(DataCenter r110, IBaseUser r111) {
        if (f132973b == true) goto L5;
        return false;
    L5:
        MiddlewareRoomContext.a r100 = MiddlewareRoomContext.Companion;
        User r101 = null;
        long r102 = 0;
        MiddlewareRoomContext r103 = MiddlewareRoomContext.a.c(r100, null, 0, 3);
        if (r103 == null) goto L12;
        com.bytedance.live.datacontext.i<Boolean> r104 = r103.isAnchor();
        if (r104 == null) goto L12;
        if (r104.getValue().booleanValue() != true) goto L12;
        boolean r105 = true;
    L13:
        com.bytedance.android.livesdk.interactivity.api.h r106 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        MiddlewareRoomContext r107 = MiddlewareRoomContext.a.c(r100, null, 0, 3);
        if (r107 == null) goto L18;
        com.bytedance.live.datacontext.m<Room> r108 = r107.getRoom();
        if (r108 == null) goto L18;
        Room r109 = r108.getValue();
    L19:
        if (r109 == null) goto L156;
        RoomAuthStatus r112 = r109.getRoomAuthStatus();
        if (r112 != null) goto L23;
        return false;
    L23:
        if (r112.isEnableSecretChat() != true) goto L168;
        if (r111 == null) goto L37;
        String r113 = r111.getUserId();
        if (r113 == null) goto L37;
        com.bytedance.live.datacontext.m<IRoom> r114 = o3.f().getRoom();
        if (r114 == null) goto L33;
        IRoom r115 = r114.getValue();
        if (r115 == null) goto L33;
        String r116 = r115.getAnchorId();
    L35:
        if (r113.equals(r116) != true) goto L37;
    L54:
        boolean r117 = true;
    L55:
        if (r117 == true) goto L57;
        return false;
    L57:
        MiddlewareRoomContext r118 = MiddlewareRoomContext.a.c(r100, null, 0, 3);
        if (r118 == null) goto L63;
        com.bytedance.live.datacontext.m<User> r119 = r118.getUser();
        if (r119 == null) goto L63;
        r101 = r119.getValue();
    L63:
        if (d(r101) == false) goto L65;
        return false;
    L65:
        if (r105 == false) goto L85;
        v0 r120 = f132972a;
        if (r120.b() == false) goto L158;
        if (r106 == null) goto L75;
        com.bytedance.live.datacontext.j<Long> r121 = r106.getUserFansCountOnStart();
        if (r121 == null) goto L75;
        Long r122 = r121.getValue();
        if (r122 == null) goto L75;
        r102 = r122.longValue();
    L75:
        if (r102 < r120.c()) goto L159;
        Map<String, String> r123 = r109.anchorAbMap;
        if (r123 == null) goto L160;
        String r124 = r123.get("room_secret_chat");
        if (r124 != null) goto L81;
        return false;
    L81:
        if (r124.equals("1") == true) goto L83;
        return false;
    L83:
        if (c(r110, f132974c) == true) goto L163;
    L154:
        return true;
    L163:
        return false;
    L160:
        return false;
    L159:
        return false;
    L158:
        return false;
    L85:
        v0 r125 = f132972a;
        if (r125.e() == false) goto L164;
        List<Integer> r126 = f132975d;
        if (r126.contains(1) == false) goto L92;
        if (y3.m(r110).n(ToolbarButton.COMMERCE) == false) goto L92;
    L127:
        boolean r127 = true;
    L129:
        if (r127 == true) goto L165;
        if (r106 == null) goto L136;
        com.bytedance.live.datacontext.j<Integer> r128 = r106.getUserHonorLevelOnStart();
        if (r128 == null) goto L136;
        Integer r129 = r128.getValue();
        if (r129 == null) goto L136;
        int r130 = r129.intValue();
    L138:
        if (r130 >= r125.g()) goto L154;
        IInteractService r131 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r131 != null) goto L142;
    L144:
        boolean r132 = false;
    L145:
        if (r132 != true) goto L166;
        if (r106 == null) goto L153;
        com.bytedance.live.datacontext.j<Long> r133 = r106.getUserFansCountOnStart();
        if (r133 == null) goto L153;
        Long r134 = r133.getValue();
        if (r134 == null) goto L153;
        r102 = r134.longValue();
    L153:
        if (r102 >= r125.f()) goto L154;
        return false;
    L166:
        return false;
    L142:
        if (r131.isAudienceLinkEngineOn() != true) goto L144;
        r132 = true;
    L136:
        r130 = 0;
        goto L138
    L165:
        return false;
    L92:
        if (r126.contains(2) != true) goto L96;
        if (y3.m(r110).n(ToolbarButton.COMMERCE_LIVE_AD) == true) goto L127;
    L96:
        if (r126.contains(3) == false) goto L100;
        if (y3.m(r110).n(ToolbarButton.MINI_APP) == true) goto L127;
    L100:
        if (r126.contains(4) == false) goto L104;
        if (y3.m(r110).n(ToolbarButton.WELFARE) == true) goto L127;
    L104:
        if (r126.contains(5) == false) goto L108;
        if (y3.m(r110).n(ToolbarButton.GAME_PROMOTE_AUDIENCE) == true) goto L127;
    L108:
        if (r126.contains(6) == false) goto L112;
        if (y3.m(r110).n(ToolbarButton.OPEN_PLATFORM_MINI_GAME) == true) goto L127;
    L112:
        if (r126.contains(6) == false) goto L116;
        if (y3.m(r110).n(ToolbarButton.LITTLE_GAME) == true) goto L127;
    L116:
        if (r126.contains(6) == false) goto L120;
        if (y3.m(r110).n(ToolbarButton.OPEN_PLATFORM_LYNX_GAME) == true) goto L127;
    L120:
        if (r126.contains(7) == false) goto L124;
        if (y3.m(r110).n(ToolbarButton.GROUP_PURCHASE_AUDIENCE) == true) goto L127;
    L124:
        if (r126.contains(8) == true) goto L126;
    L128:
        r127 = false;
        goto L129
    L126:
        if (y3.m(r110).n(ToolbarButton.TICKET_SALE) == false) goto L128;
    L164:
        return false;
    L33:
        r116 = null;
    L37:
        com.bytedance.live.datacontext.m<IRoom> r135 = o3.f().getRoom();
        if (r135 == null) goto L54;
        IRoom r136 = r135.getValue();
        if (r136 == null) goto L54;
        IRoomAuthStatus r137 = r136.getRoomAuthStatus();
        if (r137 == null) goto L54;
        if (r137.getEnableUserCard() == true) goto L54;
        if ((!Intrinsics.areEqual(o3.f().isAnchor(), Boolean.TRUE)) == false) goto L54;
        User r138 = o3.f().getUser();
        if (r138 == null) goto L53;
        py.t r139 = r138.getUserAttr();
        if (r139 == null) goto L53;
        if (r139.isAdmin() == true) goto L54;
    L53:
        r117 = false;
        goto L55
    L168:
        return false;
    L156:
        return false;
    L18:
        r109 = null;
    L12:
        r105 = false;
        goto L13
    }

    public static boolean c(DataCenter r100, List r101) {
        if (r101.contains(1) == false) goto L7;
        if (y3.m(r100).n(ToolbarButton.COMMERCE) == false) goto L7;
        return true;
    L7:
        if (r101.contains(2) != true) goto L11;
        if (y3.m(r100).n(ToolbarButton.TRANSFORM_WIDGET) == false) goto L11;
        return true;
    L11:
        if (r101.contains(3) == false) goto L15;
        if (y3.m(r100).n(ToolbarButton.MINI_APP) == false) goto L15;
        return true;
    L15:
        if (r101.contains(4) == false) goto L19;
        if (y3.m(r100).n(ToolbarButton.WELFARE) == false) goto L19;
        return true;
    L19:
        if (r101.contains(5) == false) goto L23;
        if (y3.m(r100).n(ToolbarButton.GAME_PROMOTE) == false) goto L23;
        return true;
    L23:
        if (r101.contains(6) == false) goto L27;
        if (y3.m(r100).n(ToolbarButton.LITTLE_GAME) == false) goto L27;
        return true;
    L27:
        if (r101.contains(7) == false) goto L31;
        if (y3.m(r100).n(ToolbarButton.GROUP_PURCHASE) == false) goto L31;
        return true;
    L31:
        if (r101.contains(8) == true) goto L33;
    L35:
        return false;
    L33:
        if (y3.m(r100).n(ToolbarButton.TICKET_SALE_ANCHOR) == false) goto L35;
        return true;
    }
}
