package com.bytedance.android.gamecp.live_impl.utils;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f58088a = 0;

    static {
    }

    public static void a(String r100, boolean r101, Boolean r102, ILiveRoomControllerProvider.ProviderSource r103, Boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Pair[] r105 = new Pair[5];
        String r106 = "1";
        if (r101 == false) goto L5;
        Object r107 = "1";
    L6:
        r105[0] = TuplesKt.to("is_from_im", r107);
        if (r103 != null) goto L9;
    L11:
        Object r108 = "0";
    L12:
        r105[1] = TuplesKt.to(AudienceGamePromoteDetailActionHandler.PARA_IS_LIVE_CELL_REPORT, r108);
        Boolean r109 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r109) == false) goto L15;
        Object r110 = "1";
    L16:
        r105[2] = TuplesKt.to("screen_orientation_change", r110);
        r105[3] = TuplesKt.to("status", "0");
        if (Intrinsics.areEqual(r104, r109) == true) goto L20;
        r106 = "0";
    L20:
        r105[4] = TuplesKt.to("is_preload_scene", r106);
        i.a("dygame_tech_promote_icon_show", r100, MapsKt.hashMapOf(r105));
        return;
    L15:
        r110 = "0";
        goto L16
    L9:
        if (com.bytedance.android.gamecp.live_impl.preview.e.b(r103) != true) goto L11;
        r108 = "1";
        goto L12
    L5:
        r107 = "0";
        goto L6
    }
}
