package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.newcontainer.business.community.slidetip.session.LiveRoomSlideTipsBusiness;
import com.bytedance.android.livesdk.config.ng1;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.ies.utility.SharedPrefHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f114423a = "live.pref.SHOW_SCROLL_TIPS";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f114424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f114425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f114426d = null;

    static {
        ArrayList r100 = new ArrayList();
        f114426d = r100;
        r100.add("tv_broadcast_feed_card");
        r100.add("tv_broadcast_task");
    }

    public static boolean a() {
        if (ng1.f120831a.getValue().intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void b(String r100, ILiveRoomListProvider r101, boolean r102, LiveRoomSlideTipsBusiness.b r103) {
        if (tb1.c.f545229a == true) goto L5;
        return;
    L5:
        if (a() == false) goto L7;
    L9:
        f114425c = false;
        f114423a = "live.pref.SHOW_SCROLL_TIPS";
        f114424b = 0;
        if (r101 != null) goto L12;
    L22:
        f114424b = 1;
        if (SharedPrefHelper.b(com.bytedance.android.live.core.utils.s1.getContext()).f("live.pref.SHOW_SCROLL_TIPS", true) == false) goto L31;
        if (r101 != null) goto L26;
        return;
    L26:
        if (r101.size() > 1) goto L33;
        f114425c = true;
        return;
    L33:
        return;
    L31:
        return;
    L12:
        if (r101.size() <= 1) goto L22;
        if (r103 == null) goto L22;
        if (r102 == false) goto L17;
        f114424b = 1;
        return;
    L17:
        SharedPrefHelper r104 = SharedPrefHelper.b(com.bytedance.android.live.core.utils.s1.getContext());
        if (r104.f("live.pref.SHOW_SCROLL_TIPS", true) == true) goto L21;
        r103.a(false);
        return;
    L21:
        r104.l("live.pref.SHOW_SCROLL_TIPS", Boolean.FALSE);
        r104.a();
        r103.a(true);
        f114424b = 2;
        return;
    L7:
        if (((ArrayList) f114426d).contains(r100) == true) goto L9;
    }
}
