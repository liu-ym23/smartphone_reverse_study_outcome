package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.appstore.buss.entity.AppCommentEntity;
import com.bytedanceos.appstore.buss.entity.TvGradeScoreEntity;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/AppCommentsWrap;", "", ServerElements.SCORES, "", "count", "", "score", "", "Lcom/bytedanceos/appstore/buss/entity/TvGradeScoreEntity;", ServerElements.COMMENTS, "Lcom/bytedanceos/appstore/buss/entity/AppCommentEntity;", "resId", "(FILjava/util/List;Ljava/util/List;I)V", "getComments", "()Ljava/util/List;", "getCount", "()I", "getResId", "setResId", "(I)V", "getScore", "getScores", "()F", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppCommentsWrap {

    @NotNull
    private final List<AppCommentEntity> comments;
    private final int count;
    private int resId;

    @NotNull
    private final List<TvGradeScoreEntity> score;
    private final float scores;

    public AppCommentsWrap(float r10, int r11, @NotNull List<TvGradeScoreEntity> r12, @NotNull List<AppCommentEntity> r13, int r14) {
        q.g(r12, "score");
        q.g(r13, ServerElements.COMMENTS);
        this.scores = r10;
        this.count = r11;
        this.score = r12;
        this.comments = r13;
        this.resId = r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppCommentsWrap copy$default(AppCommentsWrap r10, float r11, int r12, List r13, List r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.scores;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.count;
    L8:
        int r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.score;
    L11:
        List r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.comments;
    L14:
        List r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.resId;
    L17:
        float r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    public final float component1() {
        return this.scores;
    }

    public final int component2() {
        return this.count;
    }

    @NotNull
    public final List<TvGradeScoreEntity> component3() {
        return this.score;
    }

    @NotNull
    public final List<AppCommentEntity> component4() {
        return this.comments;
    }

    public final int component5() {
        return this.resId;
    }

    @NotNull
    public final AppCommentsWrap copy(float r10, int r11, @NotNull List<TvGradeScoreEntity> r12, @NotNull List<AppCommentEntity> r13, int r14) {
        q.g(r12, "score");
        q.g(r13, ServerElements.COMMENTS);
        return new AppCommentsWrap(r10, r11, r12, r13, r14);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppCommentsWrap) == true) goto L8;
        return false;
    L8:
        AppCommentsWrap r11 = (AppCommentsWrap) r10;
        if (Float.compare(this.scores, r11.scores) == 0) goto L12;
        return false;
    L12:
        if (this.count == r11.count) goto L15;
        return false;
    L15:
        if (q.b(this.score, r11.score) == true) goto L18;
        return false;
    L18:
        if (q.b(this.comments, r11.comments) == true) goto L21;
        return false;
    L21:
        if (this.resId == r11.resId) goto L23;
        return false;
    L23:
        return true;
    }

    @NotNull
    public final List<AppCommentEntity> getComments() {
        return this.comments;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getResId() {
        return this.resId;
    }

    @NotNull
    public final List<TvGradeScoreEntity> getScore() {
        return this.score;
    }

    public final float getScores() {
        return this.scores;
    }

    public int hashCode() {
        return (((((((Float.hashCode(this.scores) * 31) + Integer.hashCode(this.count)) * 31) + this.score.hashCode()) * 31) + this.comments.hashCode()) * 31) + Integer.hashCode(this.resId);
    }

    public final void setResId(int r10) {
        this.resId = r10;
    }

    @NotNull
    public String toString() {
        return "AppCommentsWrap(scores=" + this.scores + ", count=" + this.count + ", score=" + this.score + ", comments=" + this.comments + ", resId=" + this.resId + ')';
    }
}
