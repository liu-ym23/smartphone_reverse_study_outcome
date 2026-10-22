package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkInviteLogDataContext;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.biz.service.k;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements k, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PkInviteLogDataContext f95237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.global.c f95238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f95239c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void finishMultiAnchor(int r100, Function0<Unit> r101, boolean r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r111, "reqSrc");
        this.f95239c.finishMultiAnchor(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final com.bytedance.android.live.revenuelink.connect.f getAnchorConnectService() {
        return this.f95239c.getAnchorConnectService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final i11.b getAnchorLinkUserCenter() {
        return this.f95239c.getAnchorLinkUserCenter();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final t getConnectMonitor() {
        return this.f95239c.getConnectMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final f21.a getConnectionContext() {
        return this.f95239c.getConnectionContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final MultiLinkAnchorControlContext getControlContext() {
        return this.f95239c.getControlContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final f41.a getJsbInvitePkCallback() {
        return this.f95239c.getJsbInvitePkCallback();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final u getLaunchParameters() {
        return this.f95239c.getLaunchParameters();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final u.a getLaunchRecord() {
        return this.f95239c.getLaunchRecord();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final com.bytedance.android.live.revlink.impl.multianchor.scope.c getLinkDialogService() {
        return this.f95239c.getLinkDialogService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final ld.a getLinkInternalDataSet() {
        return this.f95239c.getLinkInternalDataSet();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final n getLinkOutManager() {
        return this.f95239c.getLinkOutManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final i11.b getMLinkUserCenter() {
        return this.f95239c.getMLinkUserCenter();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final IRoom getMRoom() {
        return this.f95239c.getMRoom();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final MutableLiveData<q11.c> getPkLinkState() {
        return this.f95239c.getPkLinkState();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final x11.a getRevInternalLinkService() {
        return this.f95239c.getRevInternalLinkService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final wq2.f getRoomDataCenterService() {
        return this.f95239c.getRoomDataCenterService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final AnchorRtcConnectManager getRtcConnectManager() {
        return this.f95239c.getRtcConnectManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final AnchorRtcConnectModel getRtcConnectModel() {
        return this.f95239c.getRtcConnectModel();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final Function0<v51.b> getStreamInteractScopeFn() {
        return this.f95239c.getStreamInteractScopeFn();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final UnexpectedFrameMonitor getUnexpectedFrameMonitor() {
        return this.f95239c.getUnexpectedFrameMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final boolean isLinkWithAudience() {
        return this.f95239c.isLinkWithAudience();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setConnectionContext(f21.a r100) {
        this.f95239c.setConnectionContext(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setJsbInvitePkCallback(f41.a r100) {
        this.f95239c.setJsbInvitePkCallback(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setLaunchParameters(u r100) {
        this.f95239c.setLaunchParameters(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setRtcConnectModel(AnchorRtcConnectModel r100) {
        this.f95239c.setRtcConnectModel(r100);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.f95238b;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void reset(String r100) {
        Intrinsics.checkNotNullParameter(r100, "src");
        getLaunchRecord().p(r100);
        getPkLinkState().setValue(q11.c.b.f531278b);
        i.h(this).f488161g = "";
        ((qr2.c) vh6.c.b(qr2.c.class)).resetLinkData();
        jy0.b.f("ttlive_pk", "PKLinkBizDataContext.reset by ".concat(r100), null, 4);
    }

    public d(com.bytedance.android.live.revlink.impl.global.c r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r101, "layoutOutStrategyContext");
        this.f95238b = r100;
        this.f95239c = r101;
        this.f95237a = new PkInviteLogDataContext(r100);
    }
}
