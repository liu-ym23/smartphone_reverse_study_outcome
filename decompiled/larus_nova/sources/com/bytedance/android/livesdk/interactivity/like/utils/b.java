package com.bytedance.android.livesdk.interactivity.like.utils;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.logsdk.format.Spm;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f137723a = 0;

    static {
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "spm");
        Intrinsics.checkNotNullParameter(r101, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a(r100).addArg("info", r101), "DiggWidget");
    }

    public static void a(String r100, boolean r101, boolean r102, boolean r103, Room r104) {
        Intrinsics.checkNotNullParameter("a100.a100.a175", "spm");
        Intrinsics.checkNotNullParameter(r100, "triggerReason");
        StringBuilder r105 = new StringBuilder();
        r105.append(r100);
        r105.append(", Anchor:");
        r105.append(r101);
        r105.append(", Portrait:");
        r105.append(r102);
        r105.append(", isLogin:");
        r105.append(((IUserService) jc1.k.n(IUserService.class)).user().isLogin());
        r105.append(", RoomEnable:");
        if (r104 == null) goto L7;
        RoomAuthStatus r106 = r104.getRoomAuthStatus();
        if (r106 == null) goto L7;
        Boolean r107 = Boolean.valueOf(r106.getEnableDigg());
    L8:
        r105.append(r107);
        r105.append(", DiggHide:");
        r105.append(r103);
        b("a100.a100.a175", r105.toString());
        return;
    L7:
        r107 = null;
        goto L8
    }
}
