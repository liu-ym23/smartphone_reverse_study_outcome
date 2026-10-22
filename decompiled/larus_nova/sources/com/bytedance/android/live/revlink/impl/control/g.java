package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f92414a = null;

    static {
        f92414a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        if (r101 == null) goto L5;
        com.bytedance.android.livesdk.link.model.o r102 = (com.bytedance.android.livesdk.link.model.o) r101.data;
    L6:
        if (r102 == null) goto L14;
        com.bytedance.android.livesdk.link.model.o r103 = (com.bytedance.android.livesdk.link.model.o) r101.data;
        if (r103 == null) goto L10;
        com.bytedance.android.livesdk.link.model.u r104 = r103.getAnchorLinkmicUserSettings();
    L11:
        if (r104 == null) goto L15;
        boolean r105 = r104.isTurnOn();
        com.bytedance.tools.kcp.spongepreference.runtime.a r106 = l51.a.f507448g;
        KProperty<?>[] r107 = l51.a.f507436a;
        r106.setValue(null, r107[6], Boolean.valueOf(r105));
        l51.a.P(r104.getAllowGiftToOtherAnchorsInPK());
        l51.a.f507450h.setValue(null, r107[7], Boolean.valueOf(r104.getAcceptMultiAnchorLink()));
        l51.a.C(r104.getAcceptNotFollowerInvite());
        l51.a.A(r104.getAcceptFriendInvite());
        l51.a.B(r104.getAcceptHourlyRankInvite());
        l51.a.D(r104.getAcceptPopularityRankInvite());
        l51.a.E(r104.getAcceptRecommendSearchInvite());
        l51.a.F(r104.getAcceptBigLayout());
        l51.a.z(r104.getAllowGiftToOtherAnchorsInLinkmic());
        l51.a.L(r104.getAutoStartStealDragon());
        l51.a.v(r104.getAcceptFindPeopleInvite());
        return;
    L15:
        return;
    L10:
        r104 = null;
        goto L11
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
