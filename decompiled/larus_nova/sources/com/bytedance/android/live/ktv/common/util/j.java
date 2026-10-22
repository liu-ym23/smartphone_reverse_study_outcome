package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.search.dto.UserGroupScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j {
    public static final void j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
    }

    public static final String c() {
        return ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2();
    }

    public static final String d() {
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L7;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L7;
        return f(r101);
    L7:
        return "";
    }

    public static final String g() {
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L6;
        return "anchor";
    L6:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isAudienceLinkEngineOn() == false) goto L9;
        return "guest";
    L9:
        if (a.g() == false) goto L11;
        return UserGroupScene.DEFAULT_NAME_SPACE;
    L11:
        return "user";
    }

    public static final boolean i() {
        return Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE);
    }

    public static final String a(DataCenter r100) {
        if (r100 == null) goto L6;
        Integer r101 = (Integer) r100.get("data_link_state", 0);
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
    L8:
        if (gd0.v.a(r102, 8) == false) goto L11;
        return "radio";
    L11:
        return "live";
    L6:
        r102 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        goto L8
    }

    public static final String b(DataCenter r100) {
        if (r100 == null) goto L6;
        Integer r101 = (Integer) r100.get("data_link_state", 0);
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
    L8:
        if (r102 != 0) goto L11;
        return "";
    L11:
        if (gd0.v.a(r102, 64) == false) goto L15;
        return "anchor";
    L15:
        if (gd0.v.a(r102, 2) == false) goto L17;
        return SourceType.DEFAULT;
    L17:
        if (gd0.v.a(r102, 8) == false) goto L19;
        return SourceType.DEFAULT;
    L19:
        if (gd0.v.a(r102, 32) == false) goto L22;
        return SourceType.DEFAULT;
    L22:
        if (gd0.v.a(r102, 4) == false) goto L33;
        int r103 = ((IMultiLinkServiceExternal) jc1.k.n(IMultiLinkServiceExternal.class)).getMultiDataHolderExternal().getMatchType();
        if (r103 != 0) goto L26;
        return "invite_pk";
    L26:
        if (r103 != 1) goto L35;
        return "random_pk";
    L35:
        return "";
    L33:
        return "";
    L6:
        r102 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        goto L8
    }

    public static final String e(DataCenter r100) {
        if (r100 == null) goto L6;
        IRoom r101 = (IRoom) r100.get("data_room", null);
        if (r101 == null) goto L6;
        return f(r101);
    L6:
        com.bytedance.android.livesdk.chatroom.o r102 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        Intrinsics.checkNotNullParameter(r102, "$this$liveTypeStr");
        com.bytedance.live.datacontext.m<IRoom> r103 = r102.getRoom();
        if (r103 == null) goto L11;
        IRoom r104 = r103.getValue();
        if (r104 == null) goto L11;
        return f(r104);
    L11:
        return "";
    }

    public static final String f(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$liveTypeStr");
        if (KtvUtilsKt.v() == false) goto L6;
        return "game";
    L6:
        if (r100.isLiveTypeAudio() == false) goto L8;
        return "voice_live";
    L8:
        return "video_live";
    }

    public static final String h(com.bytedance.android.livesdk.chatroom.o r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$userTypeStr");
        if (Intrinsics.areEqual(r100.isAnchor(), Boolean.TRUE) == false) goto L6;
        return "anchor";
    L6:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isAudienceLinkEngineOn() == false) goto L8;
        return "guest";
    L8:
        return "user";
    }
}
