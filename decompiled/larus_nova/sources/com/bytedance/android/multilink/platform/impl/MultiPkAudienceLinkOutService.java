package com.bytedance.android.multilink.platform.impl;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.live.pkaudience.api.b;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import gd0.x;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.c;
import yr0.e;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\"\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u001a\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020\nH\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016R\u0019\u0010+\u001a\u0004\u0018\u00010*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/bytedance/android/multilink/platform/impl/MultiPkAudienceLinkOutService;", "Lcom/bytedance/android/live/pk/audience/IMultiPkAudienceLinkOutService;", "", "roomId", "", "uid", "secUid", "", "layout", "msgBoardItemId", "", "invite", "", "handleInteractClick", "mode", "unLoadOtherWidget", "isRealHasAudienceBeforePk", "showInviteAndPermitDialog", "revSecUid", "reqFrom", "kickOut", "isRtcEngineOn", "Lgd0/x;", "createRtcData", "", "getLiveVideoClientFactory", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "user", "permit", "Lyr0/e;", "listener", "addPkGuestListener", "revRtcData", "videoClientFactory", "setRevGuestManagerData", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerBattleConnectContent;", "content", "setLinkerContentMap", "onFirstRemoteVideoSend", "getGuestLinkViewNew", "Lyr0/b;", "getPkLinkUserInfoCenter", "Lcom/bytedance/android/live/pkaudience/api/IPkAudienceLinkOutService;", "realService", "Lcom/bytedance/android/live/pkaudience/api/IPkAudienceLinkOutService;", "getRealService", "()Lcom/bytedance/android/live/pkaudience/api/IPkAudienceLinkOutService;", "<init>", "()V", "multilink-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiPkAudienceLinkOutService implements IMultiPkAudienceLinkOutService {
    private final IPkAudienceLinkOutService realService;

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f163388a;

        public a(e r100) {
            this.f163388a = r100;
        }

        @Override // com.bytedance.android.live.pkaudience.api.b
        public final void onPermitSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uid");
            this.f163388a.onPermitSuccess(r100);
        }

        @Override // com.bytedance.android.live.pkaudience.api.b
        public final void l(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uid");
            this.f163388a.a(r101);
        }
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public x createRtcData() {
        IPkAudienceLinkOutService r100 = this.realService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.createRevRtcData();
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public Object getGuestLinkViewNew() {
        IPkAudienceLinkOutService r100 = this.realService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getGuestLinkViewNew();
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public Object getLiveVideoClientFactory() {
        IPkAudienceLinkOutService r100 = this.realService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLiveVideoClientFactory();
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public yr0.b getPkLinkUserInfoCenter() {
        IPkAudienceLinkOutService r100 = this.realService;
        Intrinsics.checkNotNull(r100);
        return new a03.b(r100.getPkLinkUserInfoCenter());
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public boolean handleInteractClick() {
        IPkAudienceLinkOutService r100 = this.realService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.handleInteractClick();
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public boolean isRealHasAudienceBeforePk() {
        IPkAudienceLinkOutService r100 = this.realService;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isRealHasAudienceBeforePk();
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public boolean isRtcEngineOn() {
        IPkAudienceLinkOutService r100 = this.realService;
        Intrinsics.checkNotNull(r100);
        return r100.isRtcEngineOn();
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public void onFirstRemoteVideoSend() {
        IPkAudienceLinkOutService r100 = this.realService;
        if (r100 == null) goto L6;
        r100.onFirstRemoteVideoSend();
        return;
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public void showInviteAndPermitDialog() {
        IPkAudienceLinkOutService r100 = this.realService;
        if (r100 == null) goto L6;
        r100.showInviteAndPermitDialog();
        return;
    }

    public MultiPkAudienceLinkOutService() {
        this.realService = (IPkAudienceLinkOutService) k.f(IPkAudienceLinkOutService.class);
    }

    public final IPkAudienceLinkOutService getRealService() {
        return this.realService;
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public void addPkGuestListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        IPkAudienceLinkOutService r101 = this.realService;
        if (r101 == null) goto L6;
        r101.addPkGuestListener(new a(r100));
        return;
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public void permit(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        IPkAudienceLinkOutService r101 = this.realService;
        if (r101 == null) goto L9;
        c r102 = jm2.a.d(r100);
        if (r102 == null) goto L8;
        r101.permit((LinkPlayerInfo) r102);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo");
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public void setLinkerContentMap(ILinkerBattleConnectContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        IPkAudienceLinkOutService r101 = this.realService;
        if (r101 == null) goto L6;
        r101.setLinkerContentMap(r100);
        return;
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public void unLoadOtherWidget(int r100) {
        IPkAudienceLinkOutService r101 = this.realService;
        if (r101 == null) goto L6;
        r101.unLoadOtherWidget(r100);
        return;
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public void setRevGuestManagerData(x r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "revRtcData");
        IPkAudienceLinkOutService r102 = this.realService;
        if (r102 == null) goto L6;
        r102.setRevGuestManagerData(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public void kickOut(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r102, "reqFrom");
        IPkAudienceLinkOutService r103 = this.realService;
        Intrinsics.checkNotNull(r103);
        r103.kickOut(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService
    public void invite(long r110, String r111, String r112, int r113, long r114) {
        Intrinsics.checkNotNullParameter(r111, "uid");
        IPkAudienceLinkOutService r100 = this.realService;
        if (r100 == null) goto L6;
        r100.invite(r110, r111, r112, r113, r114);
        return;
    }
}
