package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.luckybox.BoxListResponse.ResponseData.JumpSchema")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/ILuckyBoxResponseData_IJumpSchemaFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/redpacket/model/b$c;", "", "<set-?>", "jumpText$delegate", "Ljava/lang/Object;", "getJumpText", "()Ljava/lang/String;", "setJumpText", "(Ljava/lang/String;)V", "jumpText", "jumpSchema$delegate", "getJumpSchema", "setJumpSchema", "jumpSchema", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ILuckyBoxResponseData_IJumpSchemaFlexImpl extends FlexModelBase<b.c> implements b.c, vh7.h {

    @SerializedName("jump_schema")
    protected String _$$jumpSchema;

    @SerializedName("jump_text")
    protected String _$$jumpText;

    public ILuckyBoxResponseData_IJumpSchemaFlexImpl() {
        super(b.c.class);
        this._$$jumpText = "";
        this._$$jumpSchema = "";
    }

    public ILuckyBoxResponseData_IJumpSchemaFlexImpl(am3.g r100) {
        super(b.c.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$jumpText = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$jumpSchema = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$jumpText != null) goto L16;
        this._$$jumpText = "";
    L16:
        if (this._$$jumpSchema != null) goto L28;
        this._$$jumpSchema = "";
        return;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b.c
    public final String getJumpSchema() {
        return this._$$jumpSchema;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b.c
    public final String getJumpText() {
        return this._$$jumpText;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b.c
    public final void setJumpSchema(String r100) {
        this._$$jumpSchema = r100;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.b.c
    public final void setJumpText(String r100) {
        this._$$jumpText = r100;
    }
}
