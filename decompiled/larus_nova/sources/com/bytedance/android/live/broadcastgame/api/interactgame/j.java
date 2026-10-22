package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.profit.miniplay.SupportLiveScene;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f59311a = 0;

    public static int a() {
        su0.a r100 = yt0.c.g();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.pf();
    }

    static {
    }

    public static boolean e(List r100) {
        Intrinsics.checkNotNullParameter(r100, "supportLiveScene");
        if (r100.contains(Integer.valueOf(SupportLiveScene.VIDEO_AUDIENCE_LINK.getValue())) == false) goto L5;
    L16:
        return true;
    L5:
        if (r100.contains(Integer.valueOf(SupportLiveScene.VIDEO_CHAT_ROOM.getValue())) == true) goto L16;
        if (r100.contains(Integer.valueOf(SupportLiveScene.VIDEO_EQUAL_CHAT_ROOM.getValue())) == true) goto L16;
        if (r100.contains(Integer.valueOf(SupportLiveScene.AUDIO_CHAT_ROOM.getValue())) == true) goto L16;
        if (r100.contains(Integer.valueOf(SupportLiveScene.AUDIO_KTV_ROOM.getValue())) == true) goto L16;
        if (r100.contains(Integer.valueOf(SupportLiveScene.AUDIO_LINK_ROOM.getValue())) == true) goto L16;
        return false;
    }

    public static u c(long r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        List r102 = (List) r101.get("data_broadcast_game_list", null);
        List r103 = r102;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L18;
        Iterator r105 = r102.iterator();
    L12:
        if (r105.hasNext() == false) goto L18;
        u r106 = (u) r105.next();
        r r107 = r106.c();
        if (r107 == null) goto L12;
        if (r107.p() != r100) goto L12;
        return r106;
    L18:
        return null;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    public static u d(String r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "appid");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        List r102 = (List) r101.get("data_broadcast_new_game_list", null);
        List r103 = r102;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L20;
        Iterator r105 = r102.iterator();
    L12:
        if (r105.hasNext() == false) goto L20;
        u r106 = (u) r105.next();
        r r107 = r106.c();
        if (r107 == null) goto L16;
        String r108 = r107.b();
    L18:
        if (Intrinsics.areEqual(r108, r100) == false) goto L12;
        return r106;
    L16:
        r108 = null;
    L20:
        return null;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    public static boolean b(List r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "supportLiveScene");
        if (r101 != 10) goto L6;
        return false;
    L6:
        su0.a r103 = yt0.c.g();
        if (r103 == null) goto L9;
        Integer r104 = Integer.valueOf(r103.X9(r102, r101));
    L11:
        return r100.contains(r104);
    L9:
        r104 = null;
        goto L11
    }
}
