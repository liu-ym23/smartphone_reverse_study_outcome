package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.h0;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import ec2.z;
import kotlin.jvm.internal.Intrinsics;
import zg1.u;

/* JADX INFO: loaded from: classes9.dex */
public final class e {
    static {
    }

    public static UserProfileEvent a(t r210, IBaseUser r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r210, "message");
        Intrinsics.checkNotNullParameter(r211, "user");
        UserProfileEvent r100 = new UserProfileEvent(r211);
        r100.mSource = "personal_profile";
        r100.setClickUserPosition("personal_profile");
        r100.forceShowToast = r212;
        r100.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        boolean r101 = r210 instanceof h0;
        t r102 = null;
        if (r101 == false) goto L5;
    L6:
        Intrinsics.checkNotNullParameter(r211, "$this$secUidExt");
        if (TextUtils.isEmpty(r211.getCastSecUid()) == false) goto L17;
        String r103 = r211.getIdString();
        if (r101 == true) goto L11;
        t r104 = null;
    L12:
        h0 r105 = (h0) r104;
        if (r105 == null) goto L15;
        String r106 = r105.getChatContent();
    L16:
        r100.mCommentReportModel = new u(r103, r106, r210.getMessageId(), 1, r211.getWebcastUid());
    L26:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r210) == null) goto L33;
        u r107 = r100.mCommentReportModel;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r108 = com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r210);
        if (r108 == null) goto L31;
        String r109 = r108.e();
    L32:
        r107.g(r109);
        goto L33
    L31:
        r109 = null;
    L33:
        r100.setReportObject(ReportObject.Comment.name());
    L35:
        if (r210.isFromOtherIntercomRoom() == false) goto L45;
        r100.setFromOtherIntercomRoom(true);
        if ((r210 instanceof k0) == false) goto L40;
        r102 = r210;
    L40:
        k0 r110 = (k0) r102;
        if (r110 == null) goto L43;
        boolean r111 = r110.intercomHideUserCard();
    L44:
        r100.setIntercomHideUserCard(r111);
        goto L45
    L43:
        r111 = false;
    L45:
        r100.addProfileShowExtraLog("comment_enter_position", "comment_user");
        r100.mClickFromMessage = r210;
        return r100;
    L15:
        r106 = null;
        goto L16
    L11:
        r104 = r210;
        goto L12
    L17:
        Intrinsics.checkNotNullParameter(r211, "$this$secUidExt");
        String r112 = r211.getCastSecUid();
        if (r101 == true) goto L20;
        t r113 = null;
    L21:
        h0 r114 = (h0) r113;
        if (r114 == null) goto L24;
        String r115 = r114.getChatContent();
    L25:
        r100.mCommentReportModel = new u(r112, r115, r210.getMessageId(), 1, r211.getWebcastUid());
        goto L26
    L24:
        r115 = null;
        goto L25
    L20:
        r113 = r210;
        goto L21
    L5:
        if (z.f472072a.getValue().booleanValue() == false) goto L35;
        goto L6
    }
}
