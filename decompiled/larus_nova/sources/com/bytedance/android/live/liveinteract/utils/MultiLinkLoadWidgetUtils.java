package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiLinkLoadWidgetUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f78649a = null;

    static {
        f78649a = LazyKt.lazy(MultiLinkLoadWidgetUtils$preloadALogEnable$2.INSTANCE);
    }

    public static boolean g() {
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().innerPreload() == false) goto L7;
        return true;
    }

    public static boolean a() {
        return vm2.h.W().byteLinkWrdsPreload();
    }

    public static boolean b() {
        if (g() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().functionTypeLogFallBack() == false) goto L7;
        return true;
    }

    public static boolean c() {
        if (l() == true) goto L5;
    L9:
        return false;
    L5:
        if (vm2.h.W().enablePreFetchListData() == false) goto L9;
        if (((a50.a) vm2.f.f556074e.getValue(null, vm2.f.f556070a[3])).i() != true) goto L9;
        return true;
    }

    public static boolean d() {
        if (g() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().logFallback() == false) goto L7;
        return true;
    }

    public static boolean e() {
        if (g() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().logPageSelect() == false) goto L7;
        return true;
    }

    public static boolean f() {
        boolean r100 = l();
        boolean r101 = vm2.h.W().isInitFastModeEnable();
        if (r100 == false) goto L6;
        if (r101 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean h() {
        if (g() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().publicScreenOpt() == false) goto L7;
        return true;
    }

    public static boolean i() {
        if (g() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().smoothEnter() == false) goto L7;
        return true;
    }

    public static boolean j() {
        if (g() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.W().useServerLinkTypeWhenPreload() == false) goto L7;
        return true;
    }

    public static boolean k() {
        return vm2.h.W().isEnablePassedThroughAudioStageData();
    }

    public static boolean l() {
        boolean r100 = vm2.h.W().isTotalEnable();
        com.bytedance.android.livesdk.chatroom.o r101 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        LiveMode r102 = null;
        if (r101 == null) goto L5;
        Boolean r103 = r101.isAnchor();
    L6:
        boolean r104 = Intrinsics.areEqual(r103, Boolean.TRUE);
        com.bytedance.android.livesdk.chatroom.o r105 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r105 == null) goto L13;
        com.bytedance.live.datacontext.m<IRoom> r106 = r105.getRoom();
        if (r106 == null) goto L13;
        IRoom r107 = r106.getValue();
        if (r107 == null) goto L13;
        r102 = r107.getStreamType();
    L13:
        if (r100 == false) goto L18;
        if (r104 == true) goto L18;
        if (r102 == LiveMode.THIRD_PARTY) goto L18;
        return true;
    L18:
        return false;
    L5:
        r103 = null;
        goto L6
    }

    @Deprecated(message = "支持直播间多实例后，应使用printKeyLog(dataCenter: DataCenter?, step: String, content: String)", replaceWith = @ReplaceWith(expression = "printKeyLog(null, step, content)", imports = {"com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils.printKeyLog"}))
    public static void o(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        Intrinsics.checkNotNullParameter(r101, "content");
        n(null, r100, r101);
    }

    public static void m(DataCenter r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "step");
        Intrinsics.checkNotNullParameter(r102, "content");
        StringBuilder r103 = new StringBuilder("dataCenter(hash:");
        String r104 = null;
        if (r100 == null) goto L5;
        Integer r105 = Integer.valueOf(r100.hashCode());
    L6:
        r103.append(r105);
        r103.append(",rid:");
        if (r100 == null) goto L11;
        IRoom r106 = com.bytedance.android.live.core.utils.a0.o(r100);
        if (r106 == null) goto L11;
        r104 = r106.getIdStr();
    L11:
        r103.append(r104);
        r103.append(") ");
        String r107 = r103.toString();
        if (vm2.h.S().d() == true) goto L16;
        ALogger.e("ttlive_link", "MultiLinkLoadWidget, " + r107 + ", printKeyLog: step = " + r101 + ", content = " + r102);
        return;
    L16:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public static void n(DataCenter r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "step");
        Intrinsics.checkNotNullParameter(r102, "content");
        Integer r103 = null;
        if (r100 == null) goto L5;
        IRoom r104 = com.bytedance.android.live.core.utils.a0.o(r100);
    L6:
        if (r100 == null) goto L8;
        Boolean r105 = (Boolean) r100.get("data_is_feed");
    L10:
        if ((r105 instanceof Boolean) == true) goto L12;
        r105 = null;
    L12:
        if (r105 == null) goto L14;
        boolean r106 = r105.booleanValue();
    L15:
        StringBuilder r107 = new StringBuilder("(");
        if (r104 == null) goto L20;
        IBaseUser r108 = r104.getOwner();
        if (r108 == null) goto L20;
        String r109 = r108.getNickName();
    L21:
        r107.append(r109);
        r107.append(", ");
        if (r100 == null) goto L26;
        IRoom r110 = com.bytedance.android.live.core.utils.a0.o(r100);
        if (r110 == null) goto L26;
        String r111 = r110.getIdStr();
    L27:
        r107.append(r111);
        r107.append(", ");
        if (r106 == false) goto L30;
        String r112 = "feed";
    L31:
        r107.append(r112);
        r107.append("), dataCenter(hash:");
        if (r100 == null) goto L34;
        r103 = Integer.valueOf(r100.hashCode());
    L34:
        r107.append(r103);
        r107.append(')');
        String r113 = r107.toString();
        if (vm2.h.S().d() == true) goto L39;
        ALogger.i("ttlive_link", "MultiLinkLoadWidget, " + r113 + " printKeyLog: step = " + r101 + ", content = " + r102);
        return;
    L39:
        return;
    L30:
        r112 = "room";
    L26:
        r111 = null;
    L20:
        r109 = null;
        goto L21
    L14:
        r106 = false;
        goto L15
    L8:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public static void p(DataCenter r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "step");
        Intrinsics.checkNotNullParameter(r102, "content");
        if (((Boolean) f78649a.getValue()).booleanValue() == false) goto L5;
        n(r100, r101, r102);
        return;
    L5:
        Boolean r103 = null;
        if (r100 == null) goto L8;
        IRoom r104 = com.bytedance.android.live.core.utils.a0.o(r100);
    L9:
        if (r100 == null) goto L11;
        Boolean r105 = (Boolean) r100.get("data_is_feed");
    L13:
        if ((r105 instanceof Boolean) == false) goto L16;
        r103 = r105;
    L16:
        if (r103 == null) goto L19;
        r103.booleanValue();
    L19:
        if (r104 == null) goto L23;
        IBaseUser r106 = r104.getOwner();
        if (r106 == null) goto L23;
        r106.getNickName();
    L23:
        if (r100 == null) goto L27;
        IRoom r107 = com.bytedance.android.live.core.utils.a0.o(r100);
        if (r107 == null) goto L27;
        r107.getIdStr();
    L27:
        if (r100 == null) goto L30;
        r100.hashCode();
    L30:
        return;
    L11:
        r105 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    }
}
