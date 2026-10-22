package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleRankUser")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRankUserFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/e2;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "score$delegate", "Ljava/lang/Object;", "getScore", "()J", com.bytedance.android.ec.core.event.a.KEY_SCORE, "rank$delegate", "getRank", "rank", "gradeBuffScore$delegate", "getGradeBuffScore", "gradeBuffScore", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleRankUserFlexImpl extends FlexModelBase<e2> implements e2, vh7.h {

    @SerializedName("grade_buff_score")
    protected long _$$gradeBuffScore;

    @SerializedName("rank")
    protected long _$$rank;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected long _$$score;

    @SerializedName("user")
    protected IBaseUser user;

    public IBattleRankUserFlexImpl() {
        super(e2.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e2
    public final long getGradeBuffScore() {
        return this._$$gradeBuffScore;
    }

    @Override // com.bytedance.android.livesdk.link.model.e2
    public final long getRank() {
        return this._$$rank;
    }

    @Override // com.bytedance.android.livesdk.link.model.e2
    public final long getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.livesdk.link.model.e2
    public IBaseUser getUser() {
        return this.user;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public IBattleRankUserFlexImpl(am3.g r100) {
        super(e2.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.user = vh7.f.a(r100, IBaseUser.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$score = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$rank = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$gradeBuffScore = r100.j();
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setUser(IBaseUser r100) {
        this.user = r100;
    }
}
