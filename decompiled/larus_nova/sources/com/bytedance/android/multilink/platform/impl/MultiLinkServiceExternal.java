package com.bytedance.android.multilink.platform.impl;

import a03.f;
import a03.g;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.l;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.List;
import jc1.k;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pc0.e;
import yr0.a;
import yr0.c;
import yr0.d;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J*\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eH\u0016R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/bytedance/android/multilink/platform/impl/MultiLinkServiceExternal;", "Lcom/bytedance/android/live/link/IMultiLinkServiceExternal;", "Lpc0/e;", "createRevRtcData", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "isPaidLive", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lcom/bytedance/android/livesdk/vscore_api/paid/PaidSceneEnum;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/l;", "registerCurrentStateChangeForAllScene", "scene", "", "exceptScenes", "hasRightEnteringScene", "Lcom/bytedance/android/live/link/ILinkServiceExternal;", "realService", "Lcom/bytedance/android/live/link/ILinkServiceExternal;", "getRealService", "()Lcom/bytedance/android/live/link/ILinkServiceExternal;", "", "getAnchorCountString", "()Ljava/lang/String;", "anchorCountString", "", "getAnchorCount", "()I", "anchorCount", "Lyr0/f;", "getPkService", "()Lyr0/f;", "pkService", "Lyr0/d;", "getMultiDataHolder", "()Lyr0/d;", "multiDataHolder", "Lyr0/a;", "getControlService", "()Lyr0/a;", "controlService", "Lyr0/c;", "getMultiAnchorService", "()Lyr0/c;", "multiAnchorService", "<init>", "()V", "multilink-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiLinkServiceExternal implements IMultiLinkServiceExternal {
    private final ILinkServiceExternal realService;

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    public e createRevRtcData() {
        return this.realService.createRevRtcData();
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    public int getAnchorCount() {
        Integer r100 = StringsKt.toIntOrNull(this.realService.getAnchorCount());
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    public String getAnchorCountString() {
        return this.realService.getAnchorCount();
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    public a getControlService() {
        return new a03.a(this.realService.getControlService());
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    public c getMultiAnchorService() {
        return new a03.e(this.realService.getMultiAnchorService());
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    public d getMultiDataHolder() {
        return new f(this.realService.getMultiDataHolder());
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    public yr0.f getPkService() {
        return new g(this.realService.getPkService());
    }

    public MultiLinkServiceExternal() {
        this.realService = (ILinkServiceExternal) k.n(ILinkServiceExternal.class);
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    @Deprecated(message = "controlService")
    public a getControlServiceExternal() {
        return getControlService();
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    @Deprecated(message = "linkAnchorCount")
    public String getLinkAnchorCountString() {
        return getAnchorCountString();
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    @Deprecated(message = "multiAnchorService")
    public c getMultiAnchorServiceExternal() {
        return getMultiAnchorService();
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    @Deprecated(message = "multiDataHolder")
    public d getMultiDataHolderExternal() {
        return getMultiDataHolder();
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    @Deprecated(message = "pkService")
    public yr0.f getPkServiceExternal() {
        return getPkService();
    }

    public final ILinkServiceExternal getRealService() {
        return this.realService;
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    public boolean isPaidLive(DataCenter r100) {
        return com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r100).isPaidLive();
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    public Observable<Pair<PaidSceneEnum, l>> registerCurrentStateChangeForAllScene(DataCenter r100) {
        pu2.c r101 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r100).V1();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.qh();
    }

    @Override // com.bytedance.android.live.link.IMultiLinkServiceExternal
    public boolean hasRightEnteringScene(DataCenter r100, PaidSceneEnum r101, List<? extends PaidSceneEnum> r102) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        return com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r100).N0(r101, r102);
    }
}
