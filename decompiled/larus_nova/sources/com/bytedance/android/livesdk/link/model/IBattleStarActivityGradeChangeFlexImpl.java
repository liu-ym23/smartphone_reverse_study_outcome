package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleStarActivityGradeChange")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeChangeFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/z2;", "", "star$delegate", "Ljava/lang/Object;", "getStar", "()J", ScoreTags.SCORE_TYPE_STAR, "score$delegate", "getScore", com.bytedance.android.ec.core.event.a.KEY_SCORE, "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleStarActivityGradeChangeFlexImpl extends FlexModelBase<z2> implements z2, vh7.h {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected long _$$score;

    @SerializedName(ScoreTags.SCORE_TYPE_STAR)
    protected long _$$star;

    public IBattleStarActivityGradeChangeFlexImpl() {
        super(z2.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.z2
    public final long getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.livesdk.link.model.z2
    public final long getStar() {
        return this._$$star;
    }

    public IBattleStarActivityGradeChangeFlexImpl(am3.g r100) {
        super(z2.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$star = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$score = r100.j();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }
}
