package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.setting.c3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f78836a = 0;

    public static boolean a() {
        if (b() == true) goto L5;
    L7:
        return false;
    L5:
        if (vm2.h.i().asyncLoadLynx() == false) goto L7;
        return true;
    }

    public static boolean b() {
        boolean r100 = MultiLinkLoadWidgetUtils.l();
        boolean r101 = vm2.h.i().isTotalEnable();
        boolean r102 = Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE);
        com.bytedance.live.datacontext.m<IRoom> r103 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r103 == null) goto L7;
        IRoom r104 = r103.getValue();
        if (r104 == null) goto L7;
        LiveMode r105 = r104.getStreamType();
    L8:
        if (r100 == false) goto L14;
        if (r101 == false) goto L14;
        if (r102 == true) goto L14;
        if (r105 == LiveMode.THIRD_PARTY) goto L14;
        return true;
    L14:
        return false;
    L7:
        r105 = null;
        goto L8
    }

    public static boolean e() {
        return vm2.h.i().slowFunctionOpt();
    }

    static {
    }

    public static boolean c(IRoom r100) {
        if (r100 != null) goto L8;
        com.bytedance.live.datacontext.m<IRoom> r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r101 == null) goto L6;
        r100 = r101.getValue();
        goto L8
    L6:
        r100 = null;
    L8:
        if (com.bytedance.android.live.core.setting.o0.f65371a.getValue().booleanValue() == false) goto L13;
        if (r100 == null) goto L13;
        if (r100.isLiveTypeAudio() != true) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean d(IRoom r100) {
        if (c(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (c3.f65271a.getValue().booleanValue() == false) goto L7;
        return true;
    }
}
