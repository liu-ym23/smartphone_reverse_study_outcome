package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleCloudCollaborateConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleCloudCollaborateConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/v0;", "", "<set-?>", "panelType$delegate", "Ljava/lang/Object;", "getPanelType", "()I", "setPanelType", "(I)V", "panelType", "", "startLightningEffect$delegate", "getStartLightningEffect", "()Z", "setStartLightningEffect", "(Z)V", "startLightningEffect", "", "targetValue$delegate", "getTargetValue", "()Ljava/lang/String;", "setTargetValue", "(Ljava/lang/String;)V", "targetValue", "expandTimePerRound$delegate", "getExpandTimePerRound", "setExpandTimePerRound", "expandTimePerRound", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleCloudCollaborateConfigFlexImpl extends FlexModelBase<v0> implements v0, vh7.h {

    @SerializedName("expand_time_per_round")
    protected String _$$expandTimePerRound;

    @SerializedName(ShareConstants.KEY_PANEL_TYPE)
    protected int _$$panelType;

    @SerializedName("start_lightning_effect")
    protected boolean _$$startLightningEffect;

    @SerializedName("target_value")
    protected String _$$targetValue;

    public IBattleCloudCollaborateConfigFlexImpl() {
        super(v0.class);
        this._$$startLightningEffect = false;
        this._$$targetValue = "";
        this._$$expandTimePerRound = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.v0
    public final String getExpandTimePerRound() {
        return this._$$expandTimePerRound;
    }

    @Override // com.bytedance.android.livesdk.link.model.v0
    public final int getPanelType() {
        return this._$$panelType;
    }

    @Override // com.bytedance.android.livesdk.link.model.v0
    public final boolean getStartLightningEffect() {
        return this._$$startLightningEffect;
    }

    @Override // com.bytedance.android.livesdk.link.model.v0
    public final String getTargetValue() {
        return this._$$targetValue;
    }

    public IBattleCloudCollaborateConfigFlexImpl(am3.g r100) {
        super(v0.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        this._$$panelType = r100.i();
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this._$$startLightningEffect = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this._$$targetValue = am3.h.c(r100);
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this._$$expandTimePerRound = am3.h.c(r100);
        goto L3
    L12:
        am3.h.d(r104, r100);
        goto L3
    L17:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 2) != 0) goto L21;
        this._$$startLightningEffect = false;
    L21:
        if (this._$$targetValue != null) goto L24;
        this._$$targetValue = "";
    L24:
        if (this._$$expandTimePerRound != null) goto L42;
        this._$$expandTimePerRound = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.v0
    public final void setExpandTimePerRound(String r100) {
        this._$$expandTimePerRound = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.v0
    public final void setPanelType(int r100) {
        this._$$panelType = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.v0
    public final void setStartLightningEffect(boolean r100) {
        this._$$startLightningEffect = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.v0
    public final void setTargetValue(String r100) {
        this._$$targetValue = r100;
    }
}
