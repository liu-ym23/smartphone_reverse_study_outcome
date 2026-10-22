package com.bytedance.android.livesdkapi.depend.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.diamond.RenderDataInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/IDiamondRenderDataInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/IDiamondRenderDataInfo;", "", "<set-?>", "renderData$delegate", "Ljava/lang/Object;", "getRenderData", "()Ljava/lang/String;", "setRenderData", "(Ljava/lang/String;)V", "renderData", "payBizParams$delegate", "getPayBizParams", "setPayBizParams", "payBizParams", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IDiamondRenderDataInfoFlexImpl extends FlexModelBase<IDiamondRenderDataInfo> implements IDiamondRenderDataInfo, h {

    @SerializedName("pay_biz_params")
    protected String _$$payBizParams;

    @SerializedName("render_data")
    protected String _$$renderData;

    public IDiamondRenderDataInfoFlexImpl() {
        super(IDiamondRenderDataInfo.class);
    }

    public IDiamondRenderDataInfoFlexImpl(g r100) {
        super(IDiamondRenderDataInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$renderData = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$payBizParams = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoBase
    public final String getPayBizParams() {
        return this._$$payBizParams;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoBase
    public final String getRenderData() {
        return this._$$renderData;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoBase
    public final void setPayBizParams(String r100) {
        this._$$payBizParams = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoBase
    public final void setRenderData(String r100) {
        this._$$renderData = r100;
    }
}
