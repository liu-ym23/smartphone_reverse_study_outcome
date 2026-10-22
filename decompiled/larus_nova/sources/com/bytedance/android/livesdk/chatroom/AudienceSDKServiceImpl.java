package com.bytedance.android.livesdk.chatroom;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.interact.AbsAudienceInteractionFragment;
import com.bytedance.android.livesdk.chatroom.interact.AudiencePortraitInteractionFragment;
import com.bytedance.android.livesdk.chatroom.ui.AbsInteractionFragment;
import com.bytedance.android.livesdk.chatroom.vs_host.ReplayDelegateFragment;
import com.bytedance.android.livesdk.config.ku;
import com.bytedance.android.livesdk.performance.event.EventType;
import com.bytedance.android.livesdk.utils.i5;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.distribution.ILiveDistributionController;
import com.bytedance.android.livesdkapi.distribution.InitParams;
import com.bytedance.android.livesdkapi.distribution.LiveExternalType;
import com.bytedance.android.livesdkapi.service.ILiveAudienceSDKService;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0002¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/AudienceSDKServiceImpl;", "Lcom/bytedance/android/livesdkapi/service/ILiveAudienceSDKService;", "()V", "createInstance", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRoomPageFragment;", "roomId", "", "bundle", "Landroid/os/Bundle;", "createLiveDistributionController", "Lcom/bytedance/android/livesdkapi/distribution/ILiveDistributionController;", "useSimpleContainer", "", "initParams", "Lcom/bytedance/android/livesdkapi/distribution/InitParams;", "createLiveRoomFragment", "gcInhibition", "", "logEnterVS", "needPreLoadingClasses", "", "Ljava/lang/Class;", "triggerEnterRoom", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AudienceSDKServiceImpl implements ILiveAudienceSDKService {
    @Override // com.bytedance.android.livesdkapi.service.ILiveAudienceSDKService
    public List<Class<?>> needPreLoadingClasses() {
        return CollectionsKt.listOf(new Class[]{AbsInteractionFragment.class, AbsAudienceInteractionFragment.class, AudiencePortraitInteractionFragment.class});
    }

    private final void gcInhibition() {
        Integer r100 = ku.f120629a.getValue();
        if (i5.a("gc_inhibit") == true) goto L5;
        return;
    L5:
        if (r100.intValue() <= 0) goto L9;
        cu2.b.a r101 = cu2.b.f465422c;
        int r102 = r100.intValue();
        r101.getClass();
        cu2.b.a.a(r102);
        return;
    }

    private final void triggerEnterRoom() {
        com.bytedance.android.livesdk.performance.gc.opt.controller.b.f154641b.start();
        boolean r100 = com.bytedance.android.livesdk.performance.event.c.f154591a;
        com.bytedance.android.livesdk.performance.event.c.c(EventType.h.f154584e, null);
    }

    public AudienceSDKServiceImpl() {
        jc1.k.l(ILiveAudienceSDKService.class, this);
    }

    private final void logEnterVS(Bundle r100) {
        HashMap r101 = new HashMap();
        if (r100 == null) goto L5;
        String r102 = r100.getString("enter_from_merge", "");
        String r103 = r100.getString("enter_method", "");
        r101.put("enter_from_merge", r102);
        r101.put("enter_method", r103);
    L5:
        com.bytedance.android.livesdk.log.u.l().sendLog("live_enter_vs_video_play_room", r101, new Object[]{null});
    }

    private final ILiveRoomPageFragment createInstance(long r100, Bundle r101) {
        return LiveRoomFragmentV2.T90(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveAudienceSDKService
    public ILiveDistributionController createLiveDistributionController(boolean r100, InitParams r101) {
        Intrinsics.checkNotNullParameter(r101, "initParams");
        if (r101.getType() != LiveExternalType.Single) goto L7;
        if (r100 == false) goto L7;
        return new com.bytedance.android.livesdk.chatroom.distribution.m(r101);
    L7:
        return new com.bytedance.android.livesdk.chatroom.distribution.j(r101);
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveAudienceSDKService
    public ILiveRoomPageFragment createLiveRoomFragment(long r100, Bundle r101) {
        triggerEnterRoom();
        gcInhibition();
        jm1.f r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.getInt(VSConstants.EXTRA_ITEM_TYPE, VSConstants.LIVE_NORMAL));
    L6:
        int r104 = VSConstants.VS_EPISODE;
        if (r103 != null) goto L10;
    L12:
        if (r103 == null) goto L21;
        if (r103.intValue() != 23) goto L21;
        int r105 = ReplayDelegateFragment.f118253e;
        nm1.e r106 = pm1.f.c();
        if (r106 == null) goto L19;
        r102 = r106.a(r100, r101);
    L19:
        ReplayDelegateFragment r107 = new ReplayDelegateFragment();
        r107.f118254d = r102;
        return r107;
    L21:
        return createInstance(r100, r101);
    L10:
        if (r103.intValue() != r104) goto L12;
        logEnterVS(r101);
        return createInstance(r100, r101);
    L5:
        r103 = null;
        goto L6
    }
}
