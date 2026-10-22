package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.api.battle.PKRecord")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPKRecordFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/k7;", "", "battleStartTime$delegate", "Ljava/lang/Object;", "getBattleStartTime", "()J", "battleStartTime", "", "resultType$delegate", "getResultType", "()I", "resultType", "Lcom/bytedance/android/livesdk/link/model/IBattleUserInfoFlexImpl;", "userInfo$delegate", "getUserInfo", "()Lcom/bytedance/android/livesdk/link/model/IBattleUserInfoFlexImpl;", "userInfo", "", "myScoreText$delegate", "getMyScoreText", "()Ljava/lang/String;", "myScoreText", "oppositeScoreText$delegate", "getOppositeScoreText", "oppositeScoreText", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPKRecordFlexImpl extends FlexModelBase<k7> implements k7, vh7.h {

    @SerializedName("battle_start_time")
    protected long _$$battleStartTime;

    @SerializedName("anchor_score_text")
    protected String _$$myScoreText;

    @SerializedName("opposite_score_text")
    protected String _$$oppositeScoreText;

    @SerializedName("result_type")
    protected int _$$resultType;

    @SerializedName("user_info")
    protected IBattleUserInfoFlexImpl _$$userInfo;

    public IPKRecordFlexImpl() {
        super(k7.class);
        this._$$myScoreText = "";
        this._$$oppositeScoreText = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.k7
    public /* bridge */ /* synthetic */ IBattleUserInfo getUserInfo() {
        return getUserInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.k7
    public final long getBattleStartTime() {
        return this._$$battleStartTime;
    }

    @Override // com.bytedance.android.livesdk.link.model.k7
    public final String getMyScoreText() {
        return this._$$myScoreText;
    }

    @Override // com.bytedance.android.livesdk.link.model.k7
    public final String getOppositeScoreText() {
        return this._$$oppositeScoreText;
    }

    @Override // com.bytedance.android.livesdk.link.model.k7
    public final int getResultType() {
        return this._$$resultType;
    }

    @Override // com.bytedance.android.livesdk.link.model.k7
    public final IBattleUserInfoFlexImpl getUserInfo() {
        return this._$$userInfo;
    }

    public IPKRecordFlexImpl(am3.g r100) {
        super(k7.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$battleStartTime = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$resultType = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$userInfo = new IBattleUserInfoFlexImpl(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$myScoreText = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._$$oppositeScoreText = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$myScoreText != null) goto L25;
        this._$$myScoreText = "";
    L25:
        if (this._$$oppositeScoreText != null) goto L46;
        this._$$oppositeScoreText = "";
        return;
    }
}
