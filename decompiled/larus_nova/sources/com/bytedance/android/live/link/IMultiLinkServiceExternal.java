package com.bytedance.android.live.link;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.l;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import pc0.e;
import yr0.a;
import yr0.c;
import yr0.d;
import yr0.f;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J&\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J.\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\n2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eH&J\b\u0010\u0012\u001a\u00020\u0011H\u0017J\b\u0010\u0014\u001a\u00020\u0013H\u0017J\b\u0010\u0016\u001a\u00020\u0015H\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0017J\b\u0010\u001a\u001a\u00020\u0019H\u0017R\u0014\u0010\u001d\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/bytedance/android/live/link/IMultiLinkServiceExternal;", "Lcom/bytedance/android/live/base/IService;", "Lpc0/e;", "createRevRtcData", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "isPaidLive", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Lcom/bytedance/android/livesdk/vscore_api/paid/PaidSceneEnum;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/l;", "registerCurrentStateChangeForAllScene", "scene", "", "exceptScenes", "hasRightEnteringScene", "", "getLinkAnchorCountString", "Lyr0/d;", "getMultiDataHolderExternal", "Lyr0/f;", "getPkServiceExternal", "Lyr0/a;", "getControlServiceExternal", "Lyr0/c;", "getMultiAnchorServiceExternal", "getAnchorCountString", "()Ljava/lang/String;", "anchorCountString", "", "getAnchorCount", "()I", "anchorCount", "getPkService", "()Lyr0/f;", "pkService", "getMultiDataHolder", "()Lyr0/d;", "multiDataHolder", "getControlService", "()Lyr0/a;", "controlService", "getMultiAnchorService", "()Lyr0/c;", "multiAnchorService", "multilink-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMultiLinkServiceExternal extends IService {
    e createRevRtcData();

    int getAnchorCount();

    String getAnchorCountString();

    a getControlService();

    @Deprecated(message = "controlService")
    a getControlServiceExternal();

    @Deprecated(message = "linkAnchorCount")
    String getLinkAnchorCountString();

    c getMultiAnchorService();

    @Deprecated(message = "multiAnchorService")
    c getMultiAnchorServiceExternal();

    d getMultiDataHolder();

    @Deprecated(message = "multiDataHolder")
    d getMultiDataHolderExternal();

    f getPkService();

    @Deprecated(message = "pkService")
    f getPkServiceExternal();

    boolean hasRightEnteringScene(DataCenter r100, PaidSceneEnum r101, List<? extends PaidSceneEnum> r102);

    boolean isPaidLive(DataCenter r100);

    Observable<Pair<PaidSceneEnum, l>> registerCurrentStateChangeForAllScene(DataCenter r100);
}
