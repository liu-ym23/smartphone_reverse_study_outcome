package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.livesdk.interactivity.service.textrender.inject.IFansClubMemberUser;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/FansClubMemberUser;", "Lcom/bytedance/android/livesdk/interactivity/service/textrender/inject/IFansClubMemberUser;", "()V", "canShowVipSingleBadge", "", "enableEcomFansClubReverse", "isShopFansClubUser", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class FansClubMemberUser implements IFansClubMemberUser {
    public FansClubMemberUser() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.inject.IFansClubMemberUser
    public boolean enableEcomFansClubReverse() {
        boolean r100 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        return ((com.bytedance.android.live.profit.fansclub.n) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.fansclub.n.class)).enableEcomFansClubReverse();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.inject.IFansClubMemberUser
    public boolean canShowVipSingleBadge() {
        com.bytedance.android.live.profit.vip.e r100 = yt0.c.l();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r101 = r100.getCanShowVipSingleBadge();
        if (r101 == null) goto L9;
        Boolean r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.booleanValue();
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.inject.IFansClubMemberUser
    public boolean isShopFansClubUser() {
        com.bytedance.android.live.profit.fansclub.o r100 = yt0.c.c();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<? extends com.bytedance.android.live.profit.fansclub.r> r101 = r100.getShopFansClubData();
        if (r101 == null) goto L9;
        com.bytedance.android.live.profit.fansclub.r r102 = r101.getValue();
        if (r102 == null) goto L9;
        com.bytedance.android.live.profit.fansclub.s r103 = r102.userData;
    L10:
        if (r103 == null) goto L12;
        return true;
    L12:
        return false;
    L9:
        r103 = null;
        goto L10
    }
}
