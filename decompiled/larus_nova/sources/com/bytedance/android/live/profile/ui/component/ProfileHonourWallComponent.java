package com.bytedance.android.live.profile.ui.component;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.ActivityBadges;
import com.bytedance.android.live.base.model.user.GiftExhibitionHomeStats;
import com.bytedance.android.live.base.model.user.HonorWallUi;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.component.base.DataAssembler;
import com.bytedance.android.live.profile.ui.component.view.honour.ProfileHonourActivityBadgeView;
import com.bytedance.android.live.profile.ui.component.view.honour.ProfileLevelCardView;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class ProfileHonourWallComponent extends DataAssembler<st0.e> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f86415g = 0;

    public static final class Companion {
        public static void a(ActivityBadges r100, DataAssembler r101) {
            Intrinsics.checkNotNullParameter(r101, "assembler");
            if (r100 == null) goto L10;
            List<ActivityBadges.NewProfileBadge> r102 = r100.badges;
            if (r102 == null) goto L12;
            Iterator<T> r103 = r102.iterator();
        L8:
            if (r103.hasNext() == false) goto L13;
            r101.h(new st0.a((ActivityBadges.NewProfileBadge) r103.next()));
            goto L8
        L13:
            return;
        L12:
            return;
        }

        public static void b(final NewProfileUser r100, DataAssembler r101) {
            Intrinsics.checkNotNullParameter(r100, "user");
            Intrinsics.checkNotNullParameter(r101, "assembler");
            r101.i(new st0.e(8, s1.B(R.string.ttlive_live_profile_honour_high_socre_song_title), true), new ProfileHonourWallComponent$Companion$configCommonProfileCard$1(r100));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.OldHonourWall.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileHonourWallComponent update");
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler
    public final View k(com.bytedance.android.live.profile.ui.component.base.b r100, NewProfileUser r101) {
        st0.e r102 = (st0.e) r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r101, "user");
        int r103 = r102.getType();
        int r104 = 6;
        int r105 = 0;
        boolean r106 = true;
        AttributeSet r107 = null;
        if (r103 != 0) goto L5;
        int r108 = com.bytedance.android.live.profile.ui.util.t.f86960a;
        Intrinsics.checkNotNullParameter(r101, "user");
        HonorWallUi r109 = r101.honorWallUi;
        if (r109 == null) goto L54;
        Map<Integer, HonorWallUi.HonorWallBg> r110 = r109.bgs;
        if (r110 == null) goto L54;
        HonorWallUi.HonorWallBg r111 = r110.get(1);
    L55:
        if (r111 != null) goto L58;
        r106 = false;
    L58:
        if (r106 == false) goto L64;
        View r112 = new ProfileLevelCardView(this.f86436f.getContext(), r107, r104, r105);
    L61:
        return r112;
    L64:
        return null;
    L54:
        r111 = null;
        goto L55
    L5:
        if (r103 == 1) goto L38;
        if (r103 == 2) goto L23;
        if (r103 == 3) goto L20;
        if (r103 != 4) goto L12;
        throw null;
    L12:
        if (r103 != 5) goto L14;
        throw null;
    L14:
        if (r103 != 8) goto L65;
        throw null;
    L65:
        return null;
    L20:
        if (this.f86436f.getChildCount() >= 6) goto L62;
        r112 = new ProfileHonourActivityBadgeView(this.f86436f.getContext(), r107, r104, r105);
        goto L61
    L62:
        return null;
    L23:
        if (com.bytedance.android.livesdk.chatroom.utils.q.a() == false) goto L66;
        GiftExhibitionHomeStats r113 = r101.giftExhibitionInfo;
        if (r113 == null) goto L28;
        int r114 = r113.unlightedNum;
    L29:
        if (r114 > 0) goto L33;
        if (r113 == null) goto L32;
        r105 = r113.lightedNum;
    L32:
        if (r105 > 0) goto L33;
        return null;
    L33:
        qs0.u r115 = os0.b.c().getIPkAudienceLinkOutServiceProxy();
        if (r115 == null) goto L36;
        r115.getPkLinkUserInfoCenter();
    L36:
        os0.b.c().getIInteractService().getLinkUserInfoCenter();
        new HashMap().put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, "old");
        throw null;
    L28:
        r114 = 0;
        goto L29
    L66:
        return null;
    L38:
        int r116 = com.bytedance.android.live.profile.ui.util.t.f86960a;
        Intrinsics.checkNotNullParameter(r101, "user");
        HonorWallUi r117 = r101.honorWallUi;
        if (r117 == null) goto L43;
        Map<Integer, HonorWallUi.HonorWallBg> r118 = r117.bgs;
        if (r118 == null) goto L43;
        HonorWallUi.HonorWallBg r119 = r118.get(2);
    L44:
        if (r119 == null) goto L46;
        r105 = 1;
    L46:
        if (r105 == 0) goto L67;
        throw null;
    L67:
        return null;
    L43:
        r119 = null;
        goto L44
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.DataAssembler
    public final ViewGroup.LayoutParams l(int r100, com.bytedance.android.live.profile.ui.component.base.b r101) {
        Intrinsics.checkNotNullParameter((st0.e) r101, "data");
        throw null;
    }
}
