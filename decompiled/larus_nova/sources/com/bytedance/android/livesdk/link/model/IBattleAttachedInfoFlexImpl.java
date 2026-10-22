package com.bytedance.android.livesdk.link.model;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleAttachedInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleAttachedInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/p0;", "", "<set-?>", "traceID$delegate", "Ljava/lang/Object;", "getTraceID", "()Ljava/lang/String;", "setTraceID", "(Ljava/lang/String;)V", "traceID", "strategyLogId$delegate", "getStrategyLogId", "setStrategyLogId", "strategyLogId", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleAttachedInfoFlexImpl extends FlexModelBase<p0> implements p0, vh7.h {

    @SerializedName("strategy_log_id")
    protected String _$$strategyLogId;

    @SerializedName(BindCardPayConfirmConstants.Key.TRACE_ID)
    protected String _$$traceID;

    public IBattleAttachedInfoFlexImpl() {
        super(p0.class);
    }

    public IBattleAttachedInfoFlexImpl(am3.g r100) {
        super(p0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 3) goto L8;
        this._$$traceID = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 4) goto L9;
        this._$$strategyLogId = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.p0
    public final String getStrategyLogId() {
        return this._$$strategyLogId;
    }

    @Override // com.bytedance.android.livesdk.link.model.p0
    public final String getTraceID() {
        return this._$$traceID;
    }

    @Override // com.bytedance.android.livesdk.link.model.p0
    public final void setStrategyLogId(String r100) {
        this._$$strategyLogId = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.p0
    public final void setTraceID(String r100) {
        this._$$traceID = r100;
    }
}
