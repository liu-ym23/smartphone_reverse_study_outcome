package com.bytedance.android.livesdk.chatroom;

import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f119318a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f119319b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f119320c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f119321d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f119322e = 0;

    static {
        f119318a = s1.j(R.dimen.ttlive_ktv_voice_chat_room_scene_height) - UtilityKotlinExtentionsKt.i(21);
        f119319b = s1.j(R.dimen.ttlive_ktv_voice_chorus_room_scene_height) - UtilityKotlinExtentionsKt.i(21);
        f119320c = (s1.j(R.dimen.ttlive_voice_chat_container_margin_top_normal) + s1.j(R.dimen.ttlive_voice_chat_anchor_container_height)) + s1.j(R.dimen.ttlive_voice_chat_seat_container_height);
        f119321d = UtilityKotlinExtentionsKt.i(140);
        f119322e = UtilityKotlinExtentionsKt.i(400);
    }

    public static final int b(long r100) {
        InteractionWidgetsPosContext r101 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r100, 1);
        int r102 = 0;
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.m<Integer> r103 = r101.getVideoEqualTalkBottomPos();
        if (r103 == null) goto L9;
        Integer r104 = r103.getValue();
        if (r104 == null) goto L9;
        int r105 = r104.intValue();
    L10:
        if (r105 <= 0) goto L12;
        return r105;
    L12:
        int r106 = (int) ((s1.f(140.0f) + (((s1.y() * 8.0f) / 27.0f) * 3)) + (s1.f(2.0f) * 2));
        if (FoldScreenUtils.f() == false) goto L22;
        if (FoldScreenUtils.a() != 0) goto L22;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L22;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == true) goto L22;
        r102 = StatusBarUtil.getStatusBarHeight(s1.getContext());
    L22:
        return r106 + r102;
    L9:
        r105 = 0;
        goto L10
    }

    public static final int a(boolean r100, long r101) {
        if (r100 == false) goto L12;
        InteractionWidgetsPosContext r102 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r101, 1);
        if (r102 == null) goto L22;
        com.bytedance.live.datacontext.m<Integer> r103 = r102.getKtvChorusBottomPos();
        if (r103 == null) goto L22;
        Integer r104 = r103.getValue();
        if (r104 == null) goto L22;
        return r104.intValue();
    L22:
        return f119319b;
    L12:
        InteractionWidgetsPosContext r105 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r101, 1);
        if (r105 == null) goto L20;
        com.bytedance.live.datacontext.m<Integer> r106 = r105.getKtvSeatBottomPos();
        if (r106 == null) goto L20;
        Integer r107 = r106.getValue();
        if (r107 == null) goto L20;
        return r107.intValue();
    L20:
        return f119318a;
    }
}
