package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BattleStarActivityGradeChange")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGradeChange;", "", "()V", a.KEY_SCORE, "", "getScore", "()J", "setScore", "(J)V", ScoreTags.SCORE_TYPE_STAR, "getStar", "setStar", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattleStarActivityGradeChange implements h {

    @SerializedName(a.KEY_SCORE)
    protected long score;

    @SerializedName(ScoreTags.SCORE_TYPE_STAR)
    protected long star;

    public BattleStarActivityGradeChange() {
    }

    public final long getScore() {
        return this.score;
    }

    public final long getStar() {
        return this.star;
    }

    public BattleStarActivityGradeChange(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.star = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.score = r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setScore(long r100) {
        this.score = r100;
    }

    public final void setStar(long r100) {
        this.star = r100;
    }
}
