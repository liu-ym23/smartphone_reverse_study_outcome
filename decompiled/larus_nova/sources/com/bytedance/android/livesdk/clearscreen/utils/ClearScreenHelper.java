package com.bytedance.android.livesdk.clearscreen.utils;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$InteractType;
import com.bytedance.android.livesdk.chatroom.event.ToolbarClearScreenEvent;
import com.bytedance.android.livesdk.config.n1;
import com.bytedance.android.livesdk.config.q1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.android.livesdkapi.feed.tabviewmodel.LiveInnerMultiTabConfig;
import com.bytedance.android.livesdkapi.feed.tabviewmodel.MultiTabContainerConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import gd0.v;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ClearScreenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f119484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f119485b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f119486c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f119487d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f119488e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f119489f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f119490g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f119491h = null;

    public static final n1 j() {
        return (n1) f119485b.getValue();
    }

    public static final q1 k() {
        return (q1) f119486c.getValue();
    }

    static {
        f119484a = LazyKt.lazy(ClearScreenHelper$multiTabContainerConfig$2.INSTANCE);
        f119485b = LazyKt.lazy(ClearScreenHelper$csGestureConfig$2.INSTANCE);
        f119486c = LazyKt.lazy(ClearScreenHelper$csGuideMock$2.INSTANCE);
        f119487d = LazyKt.lazy(ClearScreenHelper$csClickDelayTime$2.INSTANCE);
        f119488e = LazyKt.lazy(ClearScreenHelper$csClickPlayerOpt$2.INSTANCE);
        f119489f = LazyKt.lazy(ClearScreenHelper$fixClearBeforeCompLoaded$2.INSTANCE);
        f119490g = LazyKt.lazy(ClearScreenHelper$fixTransAnimViewGone$2.INSTANCE);
        f119491h = LazyKt.lazy(ClearScreenHelper$enableConsumeClick$2.INSTANCE);
    }

    public static boolean b() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L9;
        i<Boolean> r101 = r100.isAnchor();
        if (r101 == null) goto L9;
        if (r101.getValue().booleanValue() == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean a() {
        if (b() == false) goto L9;
        LiveInnerMultiTabConfig.Companion r100 = LiveInnerMultiTabConfig.Companion;
        if (r100.getCleanScreenMethod() != 1) goto L7;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
    L13:
        return true;
    L12:
        if (j().a() == true) goto L13;
        return false;
    L7:
        if (r100.getCleanScreenMethod() == 3) goto L8;
    L9:
        r101 = false;
        goto L10
    }

    public static boolean c() {
        if (b() == false) goto L11;
        LiveInnerMultiTabConfig.Companion r100 = LiveInnerMultiTabConfig.Companion;
        if (r100.getCleanScreenMethod() == 1) goto L9;
        if (r100.getCleanScreenMethod() != 3) goto L11;
    L9:
        if (((MultiTabContainerConfig) f119484a.getValue()).getEnableAlphaClear() == false) goto L11;
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
    L15:
        return true;
    L14:
        if (j().a() == true) goto L15;
        return false;
    L11:
        r101 = false;
        goto L12
    }

    public static boolean g() {
        if (b() == true) goto L5;
    L9:
        return false;
    L5:
        if (LiveInnerMultiTabConfig.Companion.getCleanScreenMethod() != 1) goto L9;
        if (((MultiTabContainerConfig) f119484a.getValue()).getEnableAlphaClear() == false) goto L9;
        return true;
    }

    @JvmStatic
    public static final boolean d(DataCenter r100) {
        if (l(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (j().a() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean e(DataCenter r100) {
        if (l(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (j().h() == false) goto L7;
        return true;
    }

    public static boolean h(DataCenter r110) {
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        Integer r111 = (Integer) r110.get("data_link_state", 0);
        if (wt2.a.n() != 2) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L46;
        RoomContext.a r101 = RoomContext.Companion;
        RoomContext r102 = RoomContext.a.c(r101, null, 0, 3);
        if (r102 == null) goto L16;
        m<Boolean> r103 = r102.getPlayerInInteractMode();
        if (r103 == null) goto L16;
        if (r103.getValue().booleanValue() != true) goto L16;
        return false;
    L16:
        RoomContext r104 = RoomContext.a.c(r101, null, 0, 3);
        if (r104 == null) goto L48;
        m<Integer> r105 = r104.getCleanMode();
        if (r105 != null) goto L21;
        return false;
    L21:
        if (r105.getValue().intValue() != ClearScreenConst$InteractType.PURE_CLEAR.getId()) goto L50;
        int r112 = r111.intValue();
        if (v.a(r112, 2) == false) goto L25;
    L42:
        boolean r113 = true;
    L43:
        if (r113 == true) goto L51;
        return true;
    L51:
        return false;
    L25:
        if (v.a(r112, 4) == true) goto L42;
        if (v.a(r112, 8) == true) goto L42;
        if (v.a(r112, 16) == true) goto L42;
        if (v.a(r112, 32) == true) goto L42;
        if (v.a(r112, 64) == true) goto L42;
        if (v.a(r112, 128) == true) goto L42;
        if (v.a(r112, 256) == true) goto L42;
        if (v.a(r112, 512) == true) goto L42;
        r113 = false;
        goto L43
    L50:
        return false;
    L48:
        return false;
    L46:
        return false;
    L5:
        if (wt2.a.n() == 4) goto L8;
        r100 = false;
        goto L9
    }

    @JvmStatic
    public static final boolean i(DataCenter r100) {
        if (l(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) f119489f.getValue()).booleanValue() == false) goto L7;
        return true;
    }

    public static boolean l(DataCenter r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L8;
    L9:
        return true;
    L8:
        if (z.e(r100, false) != true) goto L9;
        return false;
    L5:
        if (z.m(r100, true) == true) goto L6;
        return false;
    }

    @JvmStatic
    public static final void m(boolean r100) {
        if (c() == false) goto L5;
        xs2.b.a().post(new ToolbarClearScreenEvent(r100, true));
        return;
    L5:
        xs2.b.a().post(new ToolbarClearScreenEvent(r100, false));
    }

    @JvmStatic
    public static final boolean f(RoomContext r100, DataCenter r101) {
        if (j().i() == true) goto L5;
        return false;
    L5:
        if (j().a() == false) goto L35;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (z.e(r101, false) == false) goto L10;
        return false;
    L10:
        if (z.m(r101, true) != true) goto L38;
        if (r100 != null) goto L13;
        return false;
    L13:
        if (r100.isVSOrMedia() == true) goto L40;
        Intrinsics.checkNotNullParameter(r100, "$this$isHorizontalStream");
        m<Room> r102 = r100.getRoom();
        if (r102 == null) goto L17;
        Room r103 = r102.getValue();
    L18:
        if (r103 == null) goto L30;
        StreamUrl r104 = r103.getStreamUrl();
        if (r104 != null) goto L22;
    L24:
        StreamUrlExtra r105 = r103.getStreamUrlExtraSafely();
        if (r105.getWidth() <= r105.getHeight()) goto L27;
        boolean r106 = true;
    L28:
        if (r106 == false) goto L30;
    L29:
        boolean r107 = true;
    L31:
        if (r107 != true) goto L41;
        return true;
    L41:
        return false;
    L27:
        r106 = false;
        goto L28
    L22:
        if (r104.getStreamOrientation() != 2) goto L24;
    L30:
        r107 = false;
        goto L31
    L17:
        r103 = null;
        goto L18
    L40:
        return false;
    L38:
        return false;
    L35:
        return false;
    }
}
