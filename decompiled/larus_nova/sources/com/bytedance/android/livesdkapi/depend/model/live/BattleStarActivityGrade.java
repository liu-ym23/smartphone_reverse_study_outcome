package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BattleStarActivityGrade")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGrade;", "", "()V", "grade", "", "getGrade", "()Ljava/lang/String;", "setGrade", "(Ljava/lang/String;)V", "gradeMedal", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGradeMedal;", "getGradeMedal", "()Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGradeMedal;", "setGradeMedal", "(Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGradeMedal;)V", "level", "", "getLevel", "()J", "setLevel", "(J)V", "starCount", "getStarCount", "setStarCount", "targetStarCount", "getTargetStarCount", "setTargetStarCount", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattleStarActivityGrade implements h {

    @SerializedName("grade")
    protected String grade;

    @SerializedName("star_activity_grade_medal")
    protected BattleStarActivityGradeMedal gradeMedal;

    @SerializedName("level")
    protected long level;

    @SerializedName("star_count")
    protected long starCount;

    @SerializedName("target_star_count")
    protected long targetStarCount;

    public BattleStarActivityGrade() {
    }

    public final String getGrade() {
        return this.grade;
    }

    public final BattleStarActivityGradeMedal getGradeMedal() {
        return this.gradeMedal;
    }

    public final long getLevel() {
        return this.level;
    }

    public final long getStarCount() {
        return this.starCount;
    }

    public final long getTargetStarCount() {
        return this.targetStarCount;
    }

    public BattleStarActivityGrade(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.grade = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.level = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.starCount = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.targetStarCount = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.gradeMedal = new BattleStarActivityGradeMedal(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setGrade(String r100) {
        this.grade = r100;
    }

    public final void setGradeMedal(BattleStarActivityGradeMedal r100) {
        this.gradeMedal = r100;
    }

    public final void setLevel(long r100) {
        this.level = r100;
    }

    public final void setStarCount(long r100) {
        this.starCount = r100;
    }

    public final void setTargetStarCount(long r100) {
        this.targetStarCount = r100;
    }
}
