package com.bytedance.android.livesdk.chatroom.utils;

import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n0 implements com.bytedance.android.livesdk.log.filter.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f114561a = null;

    public n0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f114561a = new n0();
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        switch(r100.hashCode()) {
            case -1877516040: goto L51;
            case -1642623552: goto L48;
            case -1617968008: goto L45;
            case -1511597779: goto L42;
            case -1330248535: goto L39;
            case -1115125979: goto L36;
            case -804282046: goto L33;
            case -795864119: goto L30;
            case -485772598: goto L27;
            case -405326491: goto L24;
            case -17674694: goto L21;
            case 3321751: goto L18;
            case 21313630: goto L15;
            case 839717743: goto L12;
            case 1059589542: goto L9;
            case 2041791848: goto L6;
            default: goto L77;
        };
    L77:
        return;
    L6:
        if (r100.equals("livesdk_like") == true) goto L53;
        return;
    L53:
        if (com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.d.c() == false) goto L58;
        com.bytedance.android.livesdk.castscreen.views.b r102 = com.bytedance.android.livesdk.castscreen.views.b.f104777d;
        if (Intrinsics.areEqual(com.bytedance.android.livesdk.castscreen.views.b.a.c(), Boolean.TRUE) == false) goto L57;
        String r103 = "2";
    L59:
        r101.put("mirror_type", r103);
        return;
    L57:
        r103 = "1";
        goto L59
    L58:
        r103 = "0";
        goto L59
    L9:
        if (r100.equals("livesdk_live_user_report") == true) goto L53;
        return;
    L12:
        if (r100.equals("video_play_pause") == true) goto L53;
        return;
    L15:
        if (r100.equals("livesdk_audience_live_message") == true) goto L53;
        return;
    L18:
        if (r100.equals(IStrategyStateSupplier.KEY_INFO_LIKE) == true) goto L53;
        return;
    L21:
        if (r100.equals("video_play_finish") == true) goto L53;
        return;
    L24:
        if (r100.equals("favourite_video") == true) goto L53;
        return;
    L27:
        if (r100.equals("progress_bar_click") == true) goto L53;
        return;
    L30:
        if (r100.equals("enter_personal_detail") == true) goto L53;
        return;
    L33:
        if (r100.equals("livesdk_follow") == true) goto L53;
        return;
    L36:
        if (r100.equals("click_more_button") == true) goto L53;
        return;
    L39:
        if (r100.equals("click_comment_button") == true) goto L53;
        return;
    L42:
        if (r100.equals("live_cancel") == true) goto L53;
        return;
    L45:
        if (r100.equals("video_play") == true) goto L53;
        return;
    L48:
        if (r100.equals("post_comment") == true) goto L53;
        return;
    L51:
        if (r100.equals(HistoryTableOperate.HISTORY_PLAY_TIME) == true) goto L53;
    }
}
