package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f92416a = null;

    static {
        f92416a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        if (r101 == null) goto L5;
        com.bytedance.android.livesdk.link.model.g r102 = (com.bytedance.android.livesdk.link.model.g) r101.data;
    L6:
        if (r102 == null) goto L14;
        com.bytedance.android.livesdk.link.model.g r103 = (com.bytedance.android.livesdk.link.model.g) r101.data;
        if (r103 == null) goto L10;
        com.bytedance.android.livesdk.link.model.h r104 = r103.getAnchorBattleUserSettings();
    L11:
        if (r104 == null) goto L15;
        l51.a.x(r104.isTurnOn());
        l51.a.P(r104.getAllowGiftToOtherAnchorsInPK());
        l51.a.s(r104.getAcceptFollowedInvite());
        l51.a.u(r104.getAcceptPopularityRankInvite());
        l51.a.t(r104.getAcceptHourlyRankInvite());
        l51.a.w(r104.getAcceptNotFollowerInvite());
        l51.a.y(r104.getPkAutoConfirm());
        l51.a.D.setValue(null, l51.a.f507436a[29], Boolean.valueOf(r104.getPkAcceptVolumeUp()));
        l51.a.K(r104.getAutoStartPropCard());
        l51.a.z(r104.getAllowGiftToOtherAnchorsInLinkmic());
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
