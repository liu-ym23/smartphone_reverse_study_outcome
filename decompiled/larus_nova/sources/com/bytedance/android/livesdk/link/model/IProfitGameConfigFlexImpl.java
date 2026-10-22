package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.api.battle.ProfitGameConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IProfitGameConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/z7;", "", "<set-?>", "gameAppId$delegate", "Ljava/lang/Object;", "getGameAppId", "()Ljava/lang/String;", "setGameAppId", "(Ljava/lang/String;)V", "gameAppId", "gameExtra$delegate", "getGameExtra", "setGameExtra", "gameExtra", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IProfitGameConfigFlexImpl extends FlexModelBase<z7> implements z7, vh7.h {

    @SerializedName("game_app_id")
    protected String _$$gameAppId;

    @SerializedName("game_extra")
    protected String _$$gameExtra;

    public IProfitGameConfigFlexImpl() {
        super(z7.class);
        this._$$gameAppId = "";
        this._$$gameExtra = "";
    }

    public IProfitGameConfigFlexImpl(am3.g r100) {
        super(z7.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$gameAppId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$gameExtra = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$gameAppId != null) goto L16;
        this._$$gameAppId = "";
    L16:
        if (this._$$gameExtra != null) goto L28;
        this._$$gameExtra = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.z7
    public final String getGameAppId() {
        return this._$$gameAppId;
    }

    @Override // com.bytedance.android.livesdk.link.model.z7
    public final String getGameExtra() {
        return this._$$gameExtra;
    }

    @Override // com.bytedance.android.livesdk.link.model.z7
    public final void setGameAppId(String r100) {
        this._$$gameAppId = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.z7
    public final void setGameExtra(String r100) {
        this._$$gameExtra = r100;
    }
}
