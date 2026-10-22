package com.bytedance.android.livesdk.module;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.room.IEntranceContext;
import com.bytedance.android.live.room.ILiveSDKService;
import com.bytedance.android.live.room.m;
import com.bytedance.android.live.room.o;
import com.bytedance.android.live.room.t;
import com.bytedance.android.live.room.v;
import com.bytedance.android.livehostapi.business.depend.IStartLiveVerifyCallback;
import com.bytedance.android.livesdk.chatroom.end.NewLiveBroadcastEndFragment;
import com.bytedance.android.livesdk.livebuild.LottiePlayService;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdk.utils.k2;
import com.bytedance.android.livesdk.utils.r5;
import com.bytedance.android.livesdk.utils.z4;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes11.dex */
public class LiveSDKService implements ILiveSDKService {
    private com.bytedance.android.live.room.j mLiveCommerceService;
    private m mLottiePlayService;

    public class a implements com.bytedance.android.live.room.j {
        public a() {
        }
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService
    public com.bytedance.android.live.room.i createLiveBroadcastEndFragment() {
        return new NewLiveBroadcastEndFragment();
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService, com.bytedance.android.live.room.IMiddlewareLiveSDKService
    public m getLottiePlayService() {
        if (this.mLottiePlayService != null) goto L6;
        this.mLottiePlayService = new LottiePlayService();
    L6:
        return this.mLottiePlayService;
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService
    public com.bytedance.android.live.room.j liveCommerceService() {
        if (this.mLiveCommerceService != null) goto L6;
        this.mLiveCommerceService = new a();
    L6:
        return this.mLiveCommerceService;
    }

    public LiveSDKService() {
        jc1.k.l(ILiveSDKService.class, this);
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService
    public com.bytedance.android.live.room.e dnsOptimizer() {
        return is0.c.c().dnsOptimizer();
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService
    public v getXTSDKService() {
        return (v) l.d().b().a(v.class);
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService
    public t hostStickerViewService() {
        if (jc1.a.c() == false) goto L7;
        return null;
    L7:
        return (t) l.d().b().a(t.class);
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService, com.bytedance.android.live.room.IMiddlewareLiveSDKService
    public /* bridge */ /* synthetic */ o getLottiePlayService() {
        return getLottiePlayService();
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService
    public vlc.d getMessageManager(long r110, boolean r111, Context r112) {
        return z4.a(r112, new r5(r110, "", r111, false, false, "", null, false));
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService
    public void handleRealNameConflict(Activity r100, int r101, com.bytedance.android.live.base.model.verify.c r102, Bundle r110) {
        hu2.k.b(r100, r101, r102, r110, "", null);
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService
    public void handleRealNameConflictWithoutDialog(Activity r100, int r101, com.bytedance.android.live.base.model.verify.c r102, Bundle r103) {
        hu2.k.a(r100, r101, r102, r103, null);
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService
    public void handleRealNameConflictWithoutDialog(Activity r100, int r101, com.bytedance.android.live.base.model.verify.c r102, Bundle r103, IStartLiveVerifyCallback r104) {
        hu2.k.a(r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService, com.bytedance.android.live.room.IMiddlewareLiveSDKService
    public void handleRealNameConflict(Activity r100, int r101, com.bytedance.android.live.base.model.verify.c r102, Bundle r103, String r104, IStartLiveVerifyCallback r105) {
        hu2.k.b(r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.android.live.room.IMiddlewareLiveSDKService
    public com.bytedance.android.live.room.g createImagePicker(Activity r110, Fragment r111, String r112, DataCenter r113, int r114, int r115, int r116, int r210, com.bytedance.android.live.room.g.b r211, IEntranceContext r212) {
        return createImagePicker(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, "");
    }

    @Override // com.bytedance.android.live.room.ILiveSDKService, com.bytedance.android.live.room.IMiddlewareLiveSDKService
    public com.bytedance.android.live.room.g createImagePicker(Activity r110, Fragment r111, String r112, DataCenter r113, int r114, int r115, int r210, int r211, com.bytedance.android.live.room.g.b r212, IEntranceContext r213, String r214) {
        return new k2(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }
}
