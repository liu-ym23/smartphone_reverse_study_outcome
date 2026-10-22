package com.bytedance.android.live.profit.fansclub.transfer;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.t;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.live.profit.fansclub.GuardStatus;
import com.larus.nova.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.u;

/* JADX INFO: loaded from: classes47.dex */
public final class m {
    public static final com.bytedance.android.live.profit.fansclub.b c(py.h r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toFansClubData");
        String r101 = r100.getClubName();
        String r102 = "";
        if (r101 != null) goto L5;
        String r103 = "";
    L6:
        int r104 = r100.getLevel();
        com.bytedance.android.live.profit.fansclub.j r105 = a(r100.getUserFansClubStatus(), r100.getUserGuardStatus());
        u r106 = r100.getBadge();
        com.bytedance.android.live.profit.fansclub.m r107 = null;
        if (r106 == null) goto L15;
        Intrinsics.checkNotNullParameter(r106, "$this$toFansClubBadge");
        py.k r108 = r106.getToShowIcon();
        if (r108 == null) goto L15;
        String r109 = r106.getTitle();
        if (r109 == null) goto L14;
        r102 = r109;
    L14:
        com.bytedance.android.live.profit.fansclub.a r110 = new com.bytedance.android.live.profit.fansclub.a(r102, r108);
    L17:
        if (r100.getUserGuardStatus() <= 0) goto L20;
        r107 = new com.bytedance.android.live.profit.fansclub.m(r100.getUserGuardStatus(), r100.getGuardExpiredTime(), 6);
    L20:
        return new com.bytedance.android.live.profit.fansclub.b(r103, r104, r105, r110, r107);
    L15:
        r110 = null;
        goto L17
    L5:
        r103 = r101;
        goto L6
    }

    public static final com.bytedance.android.live.profit.fansclub.e d(n r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toFansClubParticipateIncentive");
        String r101 = s1.B(R.string.ttlive_gift_fans_club_defalut_unit);
        o r102 = r100.participateIncentive;
        if (r102 == null) goto L12;
        String r103 = r102.getAwardUnit();
        if (r103 == null) goto L12;
        if ((!TextUtils.isEmpty(r103)) == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L12;
        r101 = r103;
    L12:
        o r104 = r100.participateIncentive;
        if (r104 == null) goto L15;
        long r105 = r104.getGoldCoinsCount();
    L17:
        return new com.bytedance.android.live.profit.fansclub.e(r105, r101, 4);
    L15:
        r105 = 0;
        goto L17
    }

    public static final com.bytedance.android.live.profit.fansclub.g e(t r100) {
        py.h r101 = r100.getData();
        com.bytedance.android.live.profit.fansclub.b r102 = null;
        if (r101 == null) goto L5;
        com.bytedance.android.live.profit.fansclub.b r103 = c(r101);
    L6:
        Map<Integer, py.h> r104 = r100.getPreferData();
        if (r104 == null) goto L11;
        py.h r105 = r104.get(0);
        if (r105 == null) goto L11;
        com.bytedance.android.live.profit.fansclub.b r106 = c(r105);
    L12:
        Map<Integer, py.h> r107 = r100.getPreferData();
        if (r107 == null) goto L18;
        py.h r108 = r107.get(1);
        if (r108 == null) goto L18;
        r102 = c(r108);
    L18:
        return new com.bytedance.android.live.profit.fansclub.g(r103, r106, r102, true);
    L11:
        r106 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public static final com.bytedance.android.live.profit.fansclub.j a(int r100, int r101) {
        FansClubUserStatus.Companion.getClass();
        FansClubUserStatus r102 = FansClubUserStatus.Active;
        if (r100 == r102.getValue()) goto L9;
        r102 = FansClubUserStatus.Inactive;
        if (r100 == r102.getValue()) goto L9;
        r102 = FansClubUserStatus.Unknown;
    L9:
        GuardStatus.Companion.getClass();
        GuardStatus r103 = GuardStatus.NoGuard;
        if (r101 == r103.getValue()) goto L20;
        r103 = GuardStatus.ActiveGuard;
        if (r101 == r103.getValue()) goto L20;
        r103 = GuardStatus.InactiveGuard;
        if (r101 == r103.getValue()) goto L20;
        r103 = GuardStatus.NotParticipateGuard;
    L20:
        return new com.bytedance.android.live.profit.fansclub.j(r102, r103);
    }

    public static final com.bytedance.android.live.profit.fansclub.b b(n r100, com.bytedance.android.live.profit.fansclub.b r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$toFansClubData");
        p r102 = r100.userFansClubInfo;
        com.bytedance.android.live.profit.fansclub.a r103 = null;
        if (r102 == null) goto L12;
        String r104 = r102.clubName;
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        String r105 = r104;
        int r106 = r102.level;
        com.bytedance.android.live.profit.fansclub.j r107 = a(r102.status, 0);
        if (r101 == null) goto L11;
        r103 = r101.f87279d;
    L11:
        return new com.bytedance.android.live.profit.fansclub.b(r105, r106, r107, r103, null);
    L12:
        return null;
    }
}
