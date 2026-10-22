package com.bytedance.android.live.recharge.platform.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.data.DiamondExtra")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R)\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/DiamondExtraInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/model/DiamondExtraInfo;", "Lcom/bytedance/android/live/recharge/platform/model/RechargeBannerInfoFlexImpl;", "rechargeBannerInfo$delegate", "Ljava/lang/Object;", "getRechargeBannerInfo", "()Lcom/bytedance/android/live/recharge/platform/model/RechargeBannerInfoFlexImpl;", "rechargeBannerInfo", "", "", "bizExtra$delegate", "getBizExtra", "()Ljava/util/Map;", "bizExtra", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DiamondExtraInfoFlexImpl extends FlexModelBase<DiamondExtraInfo> implements DiamondExtraInfo, vh7.h {

    @SerializedName("biz_extra")
    protected Map<String, String> _$$bizExtra;

    @SerializedName("banner_recharge_info")
    protected RechargeBannerInfoFlexImpl _$$rechargeBannerInfo;

    public DiamondExtraInfoFlexImpl() {
        super(DiamondExtraInfo.class);
    }

    public DiamondExtraInfoFlexImpl(am3.g r110) {
        super(DiamondExtraInfo.class);
        this._$$bizExtra = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        this._$$rechargeBannerInfo = new RechargeBannerInfoFlexImpl(r110);
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L11:
        int r106 = r110.f();
        if (r106 == (-1)) goto L18;
        if (r106 != 1) goto L14;
        r104 = am3.h.c(r110);
        goto L11
    L14:
        if (r106 != 2) goto L15;
        r105 = am3.h.c(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r103);
        Map<String, String> r107 = this._$$bizExtra;
        if (r104 == null) goto L25;
        if (r105 == null) goto L23;
        r107.put(r104, r105);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.d(r102, r110);
        goto L3
    L27:
        r110.d(r100);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.recharge.platform.model.DiamondExtraInfo
    public /* bridge */ /* synthetic */ RechargeBannerInfo getRechargeBannerInfo() {
        return getRechargeBannerInfo();
    }

    @Override // com.bytedance.android.live.recharge.platform.model.DiamondExtraInfo
    public final Map<String, String> getBizExtra() {
        return this._$$bizExtra;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.DiamondExtraInfo
    public final RechargeBannerInfoFlexImpl getRechargeBannerInfo() {
        return this._$$rechargeBannerInfo;
    }
}
