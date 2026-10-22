package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppCheckCommentWrap;", "", ServerElements.COMMENT, "Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppCheckCommentEntity;", "(Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppCheckCommentEntity;)V", "getComment", "()Lcom/bytedanceos/appstore/buss/entity/netwrap/TvAppCheckCommentEntity;", "component1", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TvAppCheckCommentWrap {

    @Nullable
    private final TvAppCheckCommentEntity comment;

    public TvAppCheckCommentWrap(@Nullable TvAppCheckCommentEntity r10) {
        this.comment = r10;
    }

    public static /* synthetic */ TvAppCheckCommentWrap copy$default(TvAppCheckCommentWrap r10, TvAppCheckCommentEntity r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.comment;
    L6:
        return r10.copy(r11);
    }

    @Nullable
    public final TvAppCheckCommentEntity component1() {
        return this.comment;
    }

    @NotNull
    public final TvAppCheckCommentWrap copy(@Nullable TvAppCheckCommentEntity r10) {
        return new TvAppCheckCommentWrap(r10);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TvAppCheckCommentWrap) == true) goto L9;
        return false;
    L9:
        if (q.b(this.comment, ((TvAppCheckCommentWrap) r10).comment) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Nullable
    public final TvAppCheckCommentEntity getComment() {
        return this.comment;
    }

    public int hashCode() {
        TvAppCheckCommentEntity r10 = this.comment;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    @NotNull
    public String toString() {
        return "TvAppCheckCommentWrap(comment=" + this.comment + ')';
    }
}
