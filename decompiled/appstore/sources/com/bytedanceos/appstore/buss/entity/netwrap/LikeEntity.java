package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.common.model.AppInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/LikeEntity;", "", "appId", "", "commentId", "(JJ)V", "getAppId", "()J", "getCommentId", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LikeEntity {

    @SerializedName("app_id")
    private final long appId;

    @SerializedName("comment_id")
    private final long commentId;

    public LikeEntity() {
        long r10 = 0;
        long r11 = 0;
        this(r10, r11, 3, null);
    }

    public static /* synthetic */ LikeEntity copy$default(LikeEntity r10, long r11, long r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.appId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.commentId;
    L9:
        return r10.copy(r11, r12);
    }

    public final long component1() {
        return this.appId;
    }

    public final long component2() {
        return this.commentId;
    }

    @NotNull
    public final LikeEntity copy(long r10, long r11) {
        return new LikeEntity(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof LikeEntity) == true) goto L8;
        return false;
    L8:
        LikeEntity r11 = (LikeEntity) r10;
        if (this.appId == r11.appId) goto L12;
        return false;
    L12:
        if (this.commentId == r11.commentId) goto L14;
        return false;
    L14:
        return true;
    }

    public final long getAppId() {
        return this.appId;
    }

    public final long getCommentId() {
        return this.commentId;
    }

    public int hashCode() {
        return (Long.hashCode(this.appId) * 31) + Long.hashCode(this.commentId);
    }

    @NotNull
    public String toString() {
        return "LikeEntity(appId=" + this.appId + ", commentId=" + this.commentId + ')';
    }

    public LikeEntity(long r10, long r11) {
        this.appId = r10;
        this.commentId = r11;
    }

    public /* synthetic */ LikeEntity(long r10, long r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = 0;
    L8:
        this(r10, r11);
    }
}
