package com.bytedance.android.livesdkapi.depend.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.diamond.PrePayCashierInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nRG\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00188V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/IPrePayCashierInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/IPrePayCashierInfo;", "", "<set-?>", "oneStepPay$delegate", "Ljava/lang/Object;", "getOneStepPay", "()J", "setOneStepPay", "(J)V", "oneStepPay", "batchQueryInfo$delegate", "getBatchQueryInfo", "setBatchQueryInfo", "batchQueryInfo", "", "Lcom/bytedance/android/livesdkapi/depend/model/IDiamondRenderDataInfo;", "renderDataMap$delegate", "getRenderDataMap", "()Ljava/util/Map;", "setRenderDataMap", "(Ljava/util/Map;)V", "renderDataMap", "", "customOneStepPay$delegate", "getCustomOneStepPay", "()I", "setCustomOneStepPay", "(I)V", "customOneStepPay", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPrePayCashierInfoFlexImpl extends FlexModelBase<IPrePayCashierInfo> implements IPrePayCashierInfo, h {

    @SerializedName("need_batch_query_cashier_info")
    protected long _$$batchQueryInfo;

    @SerializedName("support_custom_one_step_pay")
    protected int _$$customOneStepPay;

    @SerializedName("support_one_step_pay")
    protected long _$$oneStepPay;

    @SerializedName("render_data_map")
    protected Map<Long, ? extends IDiamondRenderDataInfo> _$$renderDataMap;

    public IPrePayCashierInfoFlexImpl() {
        super(IPrePayCashierInfo.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo
    public final long getBatchQueryInfo() {
        return this._$$batchQueryInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo
    public final int getCustomOneStepPay() {
        return this._$$customOneStepPay;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo
    public final long getOneStepPay() {
        return this._$$oneStepPay;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo
    public final Map<Long, IDiamondRenderDataInfo> getRenderDataMap() {
        return this._$$renderDataMap;
    }

    public IPrePayCashierInfoFlexImpl(g r110) {
        super(IPrePayCashierInfo.class);
        this._$$renderDataMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        this._$$oneStepPay = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this._$$batchQueryInfo = r110.j();
        goto L3
    L10:
        if (r101 != 3) goto L12;
        long r103 = r110.c();
        Long r104 = null;
        Object r105 = null;
    L16:
        int r106 = r110.f();
        if (r106 == (-1)) goto L23;
        if (r106 != 1) goto L19;
        r104 = Long.valueOf(r110.j());
        goto L16
    L19:
        if (r106 != 2) goto L20;
        r105 = f.a(r110, IDiamondRenderDataInfo.class);
        goto L16
    L20:
        am3.h.e(r110);
        goto L16
    L23:
        r110.d(r103);
        Map<Long, ? extends IDiamondRenderDataInfo> r107 = this._$$renderDataMap;
        if (r104 == null) goto L30;
        if (r105 == null) goto L28;
        r107.put(r104, r105);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r101 != 4) goto L13;
        this._$$customOneStepPay = r110.i();
        goto L3
    L13:
        am3.h.d(r102, r110);
        goto L3
    L33:
        r110.d(r100);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo
    public final void setBatchQueryInfo(long r100) {
        this._$$batchQueryInfo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo
    public final void setCustomOneStepPay(int r100) {
        this._$$customOneStepPay = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo
    public final void setOneStepPay(long r100) {
        this._$$oneStepPay = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo
    public final void setRenderDataMap(Map<Long, ? extends IDiamondRenderDataInfo> r100) {
        this._$$renderDataMap = r100;
    }
}
