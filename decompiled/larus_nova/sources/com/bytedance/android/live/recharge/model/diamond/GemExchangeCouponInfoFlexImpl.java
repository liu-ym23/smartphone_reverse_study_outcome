package com.bytedance.android.live.recharge.model.diamond;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.diamond.DiamondListBizExtra.AllowGemExchangeCoupon")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/recharge/model/diamond/GemExchangeCouponInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/model/diamond/d;", "", "canShow$delegate", "Ljava/lang/Object;", "getCanShow", "()Z", "canShow", "", "mainTitle$delegate", "getMainTitle", "()Ljava/lang/String;", "mainTitle", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GemExchangeCouponInfoFlexImpl extends FlexModelBase<d> implements d, h {

    @SerializedName("can_show")
    protected boolean _$$canShow;

    @SerializedName(BdpAppEventConstant.PARAMS_MAIN_TITLE)
    protected String _$$mainTitle;

    public GemExchangeCouponInfoFlexImpl() {
        super(d.class);
        this._$$canShow = false;
        this._$$mainTitle = "";
    }

    public GemExchangeCouponInfoFlexImpl(g r100) {
        super(d.class);
        setThreadSafe(false);
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$canShow = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L8:
        if (r103 != 3) goto L9;
        this._$$mainTitle = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r104, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & true) == true) goto L16;
        this._$$canShow = false;
    L16:
        if (this._$$mainTitle != null) goto L28;
        this._$$mainTitle = "";
        return;
    }

    @Override // com.bytedance.android.live.recharge.model.diamond.d
    public final boolean getCanShow() {
        return this._$$canShow;
    }

    @Override // com.bytedance.android.live.recharge.model.diamond.d
    public final String getMainTitle() {
        return this._$$mainTitle;
    }
}
