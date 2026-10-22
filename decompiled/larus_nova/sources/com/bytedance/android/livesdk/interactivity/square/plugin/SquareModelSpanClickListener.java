package com.bytedance.android.livesdk.interactivity.square.plugin;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageModelType;
import com.bytedance.android.livesdk.interactivity.square.common.common.CommonModelSpanClickListener;
import com.bytedance.android.livesdk.message.model.vh;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.j;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tb2.g;
import zg1.u;

/* JADX INFO: loaded from: classes9.dex */
public final class SquareModelSpanClickListener extends CommonModelSpanClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<View, g, Boolean> f141177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<View, Unit> f141178c;

    public SquareModelSpanClickListener() {
        this.f141177b = new SquareModelSpanClickListener$userSpanListener$1(this);
        this.f141178c = new SquareModelSpanClickListener$viewClickListener$1(this);
    }

    public static final UserProfileEvent c(SquareModelSpanClickListener r210, IBaseUser r211, gc2.a r212) {
        r210.getClass();
        if (r211 == null) goto L20;
        if (r212 == null) goto L20;
        UserProfileEvent r100 = new UserProfileEvent(r211);
        r100.mSource = "personal_profile";
        r100.setClickUserPosition("personal_profile");
        r100.forceHideDynamicComponent = true;
        r100.forceShowProfile = true;
        r100.setExtraFollowParams(j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        vh r101 = r212.f480818n;
        if (r101 == null) goto L10;
        String r102 = String.valueOf(r101.c());
        if (r102 == null) goto L10;
    L11:
        r100.addProfileShowExtraLog("go_to_ta_live_room_id", r102);
        r100.addProfileShowExtraLog("from_comment_id", String.valueOf(r212.f488290m));
        r100.addProfileShowExtraLog("from_square_msg_type", "common");
        Intrinsics.checkNotNullParameter(r211, "$this$secUidExt");
        if (TextUtils.isEmpty(r211.getCastSecUid()) == false) goto L18;
        String r103 = r211.getIdString();
        String r104 = r212.f488280c;
        if (r104 != null) goto L16;
        String r105 = "";
    L17:
        r100.mCommentReportModel = new u(r103, r105, r212.f488290m, 5, r211.getWebcastUid());
    L19:
        r100.setReportObject(ReportObject.Comment.name());
        r100.addProfileShowExtraLog("comment_enter_position", "comment_user");
        return r100;
    L16:
        r105 = r104;
        goto L17
    L18:
        Intrinsics.checkNotNullParameter(r211, "$this$secUidExt");
        r100.mCommentReportModel = new u(r211.getCastSecUid(), r212.f488280c, r212.f488290m, 5, r211.getWebcastUid());
    L10:
        r102 = "";
    L20:
        return null;
    }

    public static final void d(SquareModelSpanClickListener r100, gc2.a r101, String r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "clickType");
        LinkedHashMap r103 = new LinkedHashMap();
        IPublicAreaCommon r104 = r101.f488282e;
        if (r104 == null) goto L7;
        Map<String, String> r105 = r104.getTrackingParams();
        if (r105 == null) goto L7;
        r103.putAll(r105);
    L7:
        r103.put("msg_id", String.valueOf(r101.f488290m));
        if (r101.f488287j != MessageModelType.Square) goto L10;
        r103.put("square_msg_type", "common");
    L10:
        Boolean r106 = p.f133647a;
        p.b(r101.f488281d, r102, r103);
    }
}
