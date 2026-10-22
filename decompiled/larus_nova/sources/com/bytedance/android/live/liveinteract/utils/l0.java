package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f78791a = null;

    public l0() {
    }

    static {
        f78791a = new l0();
    }

    @JvmStatic
    public static final int a() {
        return ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
    }

    public static void b(Map r100) {
        Integer r101 = Integer.valueOf(a());
        Intrinsics.checkNotNullParameter(r100, "logMap");
        if (r101 != null) goto L6;
    L14:
        if (r101 != null) goto L17;
    L19:
        if (r101 != null) goto L22;
    L24:
        if (r101 != null) goto L27;
    L29:
        if (r101 != null) goto L32;
    L34:
        if (r101 != null) goto L37;
        return;
    L37:
        if (r101.intValue() != 12) goto L48;
        r100.put("function_type", "party");
        return;
    L48:
        return;
    L32:
        if (r101.intValue() != 4) goto L34;
        r100.put("function_type", SourceType.DEFAULT);
        return;
    L27:
        if (r101.intValue() != 10) goto L29;
        r100.put("function_type", "watch");
        return;
    L22:
        if (r101.intValue() != 9) goto L24;
        r100.put("function_type", "ktv");
        return;
    L17:
        if (r101.intValue() != 8) goto L19;
        r100.put("function_type", "radio");
        return;
    L6:
        if (r101.intValue() != 5) goto L14;
        r100.put("function_type", "radio");
        com.bytedance.live.datacontext.m<IRoom> r102 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r102 == null) goto L40;
        IRoom r103 = r102.getValue();
        if (r103 != null) goto L12;
        return;
    L12:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r103) == false) goto L42;
        r100.put("function_type", "party");
        return;
    L42:
        return;
    }

    public static void c(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        com.bytedance.live.datacontext.m<IRoom> r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r101 == null) goto L5;
        IRoom r102 = r101.getValue();
    L6:
        if (r102 == null) goto L9;
        LiveMode r103 = r102.getStreamType();
        int r104 = com.bytedance.android.live.core.utils.h1.f66189a;
        String r105 = (String) r100.put("live_type", com.bytedance.android.live.core.utils.i1.a(r103));
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static void d(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        com.bytedance.live.datacontext.m<IRoom> r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r101 == null) goto L5;
        IRoom r102 = r101.getValue();
    L6:
        if (r102 == null) goto L9;
        LiveMode r103 = r102.getStreamType();
        int r104 = com.bytedance.android.live.core.utils.h1.f66189a;
        String r105 = (String) r100.put("live_type", com.bytedance.android.live.core.utils.i1.a(r103));
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final void e(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r101 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r101 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r102 = r101.getValue();
        if (r102 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r103 = r102.t();
        if (r103 == null) goto L17;
        List<Integer> r104 = r103.f114799b;
        if (r104 != null) goto L11;
        return;
    L11:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r104) == false) goto L13;
        r100.put("seat_fit_status", "on");
        return;
    L13:
        r100.put("seat_fit_status", "off");
        return;
    L17:
        return;
    L16:
        return;
    }
}
