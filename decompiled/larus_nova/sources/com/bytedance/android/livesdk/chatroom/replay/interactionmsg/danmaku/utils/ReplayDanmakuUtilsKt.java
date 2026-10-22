package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.utils;

import android.graphics.Color;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.livesdk.chatroom.danmaku.VSDanmakuContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayDanmakuUtilsKt {
    public static final int c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toColorInt");
        return Color.parseColor("#" + r100);
    L5:
        return -1;
    }

    public static final boolean d(jq1.b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMultiColor");
        o1 r101 = r100.getLandscapeAreaCommon();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.getShowFontColor() != true) goto L14;
        List<String> r102 = r100.b();
        if (r102 == null) goto L9;
        int r103 = r102.size();
    L10:
        if (r103 <= 1) goto L15;
        return true;
    L15:
        return false;
    L9:
        r103 = 0;
        goto L10
    L14:
        return false;
    }

    public static final int a(jq1.b r100, com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.d r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getSingleColor");
        Intrinsics.checkNotNullParameter(r101, "danmakuSettingConfig");
        List<String> r102 = r100.b();
        if (r102 == null) goto L7;
        String r103 = (String) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L7;
        return c(r103);
    L7:
        return -1;
    }

    public static final CharSequence b(jq1.b r100, com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.d r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getTextContent");
        Intrinsics.checkNotNullParameter(r101, "danmakuSettingConfig");
        return r.e().c(r100.getChatContent(), r101.f108996a.f109004b);
    }

    public static final void e(DataCenter r100, final boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r102 = ReplayDataContext.a.b(r100);
        if (r102 == null) goto L10;
        j<VSDanmakuContext> r103 = r102.getVsDanmakuContext();
        if (r103 == null) goto L11;
        r103.c(new ReplayDanmakuUtilsKt$setDanmakuHandlePopupShow$1(r101));
        return;
    L11:
        return;
    }
}
