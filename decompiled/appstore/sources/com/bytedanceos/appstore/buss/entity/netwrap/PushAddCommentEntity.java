package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/PushAddCommentEntity;", "", "score", "", "packageName", "versionCode", "versionName", ServerElements.CONTENT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getPackageName", "getScore", "getVersionCode", "getVersionName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PushAddCommentEntity {

    @Nullable
    private final String content;

    @SerializedName("package")
    @NotNull
    private final String packageName;

    @NotNull
    private final String score;

    @SerializedName("version_code")
    @NotNull
    private final String versionCode;

    @SerializedName("version")
    @NotNull
    private final String versionName;

    public PushAddCommentEntity(@NotNull String r10, @NotNull String r11, @NotNull String r12, @NotNull String r13, @Nullable String r14) {
        q.g(r10, "score");
        q.g(r11, "packageName");
        q.g(r12, "versionCode");
        q.g(r13, "versionName");
        this.score = r10;
        this.packageName = r11;
        this.versionCode = r12;
        this.versionName = r13;
        this.content = r14;
    }

    public static /* synthetic */ PushAddCommentEntity copy$default(PushAddCommentEntity r10, String r11, String r12, String r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.score;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.packageName;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.versionCode;
    L11:
        String r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.versionName;
    L14:
        String r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.content;
    L17:
        String r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    @NotNull
    public final String component1() {
        return this.score;
    }

    @NotNull
    public final String component2() {
        return this.packageName;
    }

    @NotNull
    public final String component3() {
        return this.versionCode;
    }

    @NotNull
    public final String component4() {
        return this.versionName;
    }

    @Nullable
    public final String component5() {
        return this.content;
    }

    @NotNull
    public final PushAddCommentEntity copy(@NotNull String r10, @NotNull String r11, @NotNull String r12, @NotNull String r13, @Nullable String r14) {
        q.g(r10, "score");
        q.g(r11, "packageName");
        q.g(r12, "versionCode");
        q.g(r13, "versionName");
        return new PushAddCommentEntity(r10, r11, r12, r13, r14);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PushAddCommentEntity) == true) goto L8;
        return false;
    L8:
        PushAddCommentEntity r11 = (PushAddCommentEntity) r10;
        if (q.b(this.score, r11.score) == true) goto L12;
        return false;
    L12:
        if (q.b(this.packageName, r11.packageName) == true) goto L15;
        return false;
    L15:
        if (q.b(this.versionCode, r11.versionCode) == true) goto L18;
        return false;
    L18:
        if (q.b(this.versionName, r11.versionName) == true) goto L21;
        return false;
    L21:
        if (q.b(this.content, r11.content) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getScore() {
        return this.score;
    }

    @NotNull
    public final String getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        int r10 = ((((((this.score.hashCode() * 31) + this.packageName.hashCode()) * 31) + this.versionCode.hashCode()) * 31) + this.versionName.hashCode()) * 31;
        String r11 = this.content;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    @NotNull
    public String toString() {
        return "PushAddCommentEntity(score=" + this.score + ", packageName=" + this.packageName + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", content=" + this.content + ')';
    }
}
