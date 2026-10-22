package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.AppPermissionActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ<\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/CommonAppCommentEntity;", "", AppPermissionActivity.EXTRA_APP_PKG, "", ServerElements.SCORES, "", "count", "", "resId", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPkg", "()Ljava/lang/String;", "getResId", "getScores", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedanceos/appstore/buss/entity/CommonAppCommentEntity;", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CommonAppCommentEntity {

    @Nullable
    private final Integer count;

    @NotNull
    private final String pkg;

    @Nullable
    private final Integer resId;

    @Nullable
    private final Float scores;

    public CommonAppCommentEntity(@NotNull String r10, @Nullable Float r11, @Nullable Integer r12, @Nullable Integer r13) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        this.pkg = r10;
        this.scores = r11;
        this.count = r12;
        this.resId = r13;
    }

    public static /* synthetic */ CommonAppCommentEntity copy$default(CommonAppCommentEntity r10, String r11, Float r12, Integer r13, Integer r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.pkg;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.scores;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.count;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.resId;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @NotNull
    public final String component1() {
        return this.pkg;
    }

    @Nullable
    public final Float component2() {
        return this.scores;
    }

    @Nullable
    public final Integer component3() {
        return this.count;
    }

    @Nullable
    public final Integer component4() {
        return this.resId;
    }

    @NotNull
    public final CommonAppCommentEntity copy(@NotNull String r10, @Nullable Float r11, @Nullable Integer r12, @Nullable Integer r13) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        return new CommonAppCommentEntity(r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CommonAppCommentEntity) == true) goto L8;
        return false;
    L8:
        CommonAppCommentEntity r11 = (CommonAppCommentEntity) r10;
        if (q.b(this.pkg, r11.pkg) == true) goto L12;
        return false;
    L12:
        if (q.b(this.scores, r11.scores) == true) goto L15;
        return false;
    L15:
        if (q.b(this.count, r11.count) == true) goto L18;
        return false;
    L18:
        if (q.b(this.resId, r11.resId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final Integer getCount() {
        return this.count;
    }

    @NotNull
    public final String getPkg() {
        return this.pkg;
    }

    @Nullable
    public final Integer getResId() {
        return this.resId;
    }

    @Nullable
    public final Float getScores() {
        return this.scores;
    }

    public int hashCode() {
        int r10 = this.pkg.hashCode() * 31;
        Float r11 = this.scores;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        Integer r15 = this.count;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        Integer r18 = this.resId;
        if (r18 == null) goto L15;
        r12 = r18.hashCode();
    L15:
        return r17 + r12;
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "CommonAppCommentEntity(pkg=" + this.pkg + ", scores=" + this.scores + ", count=" + this.count + ", resId=" + this.resId + ')';
    }
}
