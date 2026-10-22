package com.bytedance.android.live;

import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import l81.k;
import l81.l;
import l81.m;
import l81.n;
import l81.o;
import l81.p;
import l81.q;
import l81.r;
import l81.s;
import l81.t;
import l81.u;
import l81.v;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020.H\u0016¨\u00062"}, d2 = {"Lcom/bytedance/android/live/NavigationProxyService;", "Lcom/bytedance/android/live/room/api/userinfo/INavigationProxyService;", "Ll81/t;", "getToolbarConfig", "Ll81/k;", "getLivePlatformPlayerManager", "Ll81/i;", "getLiveLayerContextExt", "Ll81/e;", "getDrawCleanScreenViewModel", "Ll81/n;", "getILiveSdkProjectModeService", "Ll81/o;", "getMicRoomService", "Ll81/g;", "getLinkPlayerState", "Ll81/v;", "getVSMediaUIConfigHelper", "Ll81/j;", "getLiveLogger", "Ll81/s;", "getScreenRotateService", "Ll81/c;", "getDataCenterExtProxy", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Ll81/d;", "getDiggContext", "Ll81/u;", "getUserService", "Ll81/q;", "getRechargeServiceExternal", "Ll81/r;", "getRoomMessageHelper", "Ll81/p;", "getPromotionAdLogger", "Ll81/m;", "getLiveRoomEventParamUtils", "Ll81/f;", "getHsLiveAdMocService", "Ll81/a;", "getAudienceGameContext", "Ll81/h;", "getLinkServiceExternal", "Ll81/l;", "getLivePushPermissionHelper", "Ll81/b;", "getBroadcastService", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class NavigationProxyService implements INavigationProxyService {
    public NavigationProxyService() {
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public l81.a getAudienceGameContext() {
        return yn0.a.f568495a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public l81.b getBroadcastService() {
        return yn0.b.f568496a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public l81.c getDataCenterExtProxy() {
        return yn0.c.f568499a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public l81.e getDrawCleanScreenViewModel() {
        return yn0.e.f568501a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public l81.f getHsLiveAdMocService() {
        return yn0.f.f568502a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public n getILiveSdkProjectModeService() {
        return yn0.n.f568510a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public l81.g getLinkPlayerState() {
        return yn0.g.f568503a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public l81.h getLinkServiceExternal() {
        return yn0.h.f568504a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public l81.i getLiveLayerContextExt() {
        return yn0.i.f568505a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public l81.j getLiveLogger() {
        return yn0.j.f568506a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public k getLivePlatformPlayerManager() {
        return yn0.k.f568507a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public l getLivePushPermissionHelper() {
        return yn0.l.f568508a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public m getLiveRoomEventParamUtils() {
        return yn0.m.f568509a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public o getMicRoomService() {
        return yn0.o.f568511a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public p getPromotionAdLogger() {
        return yn0.p.f568512a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public q getRechargeServiceExternal() {
        return yn0.q.f568513a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public r getRoomMessageHelper() {
        return yn0.r.f568514a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public s getScreenRotateService() {
        return yn0.s.f568515a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public t getToolbarConfig() {
        return yn0.t.f568516a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public u getUserService() {
        return yn0.u.f568517a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public v getVSMediaUIConfigHelper() {
        return yn0.v.f568518a;
    }

    @Override // com.bytedance.android.live.room.api.userinfo.INavigationProxyService
    public l81.d getDiggContext(DataCenter r100) {
        return new yn0.d(r100);
    }
}
