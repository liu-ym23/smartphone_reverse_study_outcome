package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppCheckCommentEntity;", "", ServerElements.CONTENT, "", "score", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getScore", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TvAppCheckCommentEntity {

    @Nullable
    private final String content;

    @Nullable
    private final String score;

    public TvAppCheckCommentEntity(@Nullable String r10, @Nullable String r11) {
        this.content = r10;
        this.score = r11;
    }

    public static /* synthetic */ TvAppCheckCommentEntity copy$default(TvAppCheckCommentEntity r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.content;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.score;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String component1() {
        return this.content;
    }

    @Nullable
    public final String component2() {
        return this.score;
    }

    @NotNull
    public final TvAppCheckCommentEntity copy(@Nullable String r10, @Nullable String r11) {
        return new TvAppCheckCommentEntity(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvAppCheckCommentEntity) == true) goto L8;
        return false;
    L8:
        TvAppCheckCommentEntity r11 = (TvAppCheckCommentEntity) r10;
        if (q.b(this.content, r11.content) == true) goto L12;
        return false;
    L12:
        if (q.b(this.score, r11.score) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getScore() {
        return this.score;
    }

    public int hashCode() {
        String r10 = this.content;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.score;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "TvAppCheckCommentEntity(content=" + this.content + ", score=" + this.score + ')';
    }
}
