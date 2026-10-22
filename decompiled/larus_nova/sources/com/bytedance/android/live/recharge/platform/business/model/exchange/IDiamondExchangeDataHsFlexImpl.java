package com.bytedance.android.live.recharge.platform.business.model.exchange;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.wallet.DiamondExchangeResult.DiamondExchangeData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/exchange/IDiamondExchangeDataHsFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/exchange/a;", "", "userType$delegate", "Ljava/lang/Object;", "getUserType", "()I", "userType", "", "prompt$delegate", "getPrompt", "()Ljava/lang/String;", EventConstant.Key.RETAIN_PROMPT, "promptBody$delegate", "getPromptBody", "promptBody", "orderId$delegate", "getOrderId", "orderId", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IDiamondExchangeDataHsFlexImpl extends FlexModelBase<a> implements a, h {

    @SerializedName("order_id")
    protected String _$$orderId;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    protected String _$$prompt;

    @SerializedName("prompt_body")
    protected String _$$promptBody;

    @SerializedName("user_type")
    protected int _$$userType;

    public IDiamondExchangeDataHsFlexImpl() {
        super(a.class);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.exchange.a, com.bytedance.android.live.recharge.platform.business.model.exchange.c
    public final String getOrderId() {
        return this._$$orderId;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.exchange.a
    public final String getPrompt() {
        return this._$$prompt;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.exchange.a
    public final String getPromptBody() {
        return this._$$promptBody;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.exchange.a
    public final int getUserType() {
        return this._$$userType;
    }

    public IDiamondExchangeDataHsFlexImpl(g r100) {
        super(a.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$orderId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$userType = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$prompt = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$promptBody = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }
}
