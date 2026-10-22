package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicProfitEggContributeContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ILinkmicProfitEggContributeContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/p9;", "", "<set-?>", "score$delegate", "Ljava/lang/Object;", "getScore", "()J", "setScore", "(J)V", com.bytedance.android.ec.core.event.a.KEY_SCORE, "", "eggId$delegate", "getEggId", "()Ljava/lang/String;", "setEggId", "(Ljava/lang/String;)V", "eggId", "teamId$delegate", "getTeamId", "setTeamId", "teamId", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicProfitEggContributeContentFlexImpl extends FlexModelBase<p9> implements p9, vh7.h {

    @SerializedName("egg_id")
    protected String _$$eggId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected long _$$score;

    @SerializedName("team_id")
    protected String _$$teamId;

    public ILinkmicProfitEggContributeContentFlexImpl() {
        super(p9.class);
        this._$$eggId = "";
        this._$$teamId = "";
    }

    @Override // com.bytedance.android.livesdk.message.model.p9
    public final String getEggId() {
        return this._$$eggId;
    }

    @Override // com.bytedance.android.livesdk.message.model.p9
    public final long getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.livesdk.message.model.p9
    public final String getTeamId() {
        return this._$$teamId;
    }

    public ILinkmicProfitEggContributeContentFlexImpl(am3.g r100) {
        super(p9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$score = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$eggId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$teamId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$eggId != null) goto L19;
        this._$$eggId = "";
    L19:
        if (this._$$teamId != null) goto L34;
        this._$$teamId = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.message.model.p9
    public final void setEggId(String r100) {
        this._$$eggId = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.p9
    public final void setScore(long r100) {
        this._$$score = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.p9
    public final void setTeamId(String r100) {
        this._$$teamId = r100;
    }
}
