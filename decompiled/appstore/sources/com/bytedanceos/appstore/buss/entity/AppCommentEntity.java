package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000fHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003Jw\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010/\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u000bHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012¨\u00063"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/AppCommentEntity;", "", "id", "", "uid", ServerElements.CONTENT, "score", "version", "createTime", ServerElements.NICKNAME, "ifLike", "", ServerElements.LIKE, "is_black", "isOpen", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "getContent", "()Ljava/lang/String;", "getCreateTime", "getId", "getIfLike", "()I", "setIfLike", "(I)V", "()Z", "setOpen", "(Z)V", "getLike", "setLike", "(Ljava/lang/String;)V", "getNickname", "getScore", "getUid", "getVersion", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppCommentEntity {

    @NotNull
    private final String content;

    @SerializedName("create_time")
    @NotNull
    private final String createTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f8425id;

    @SerializedName(ServerElements.IFLIKE)
    private int ifLike;
    private boolean isOpen;

    @NotNull
    private final String is_black;

    @NotNull
    private String like;

    @NotNull
    private final String nickname;

    @NotNull
    private final String score;

    @NotNull
    private final String uid;

    @NotNull
    private final String version;

    public AppCommentEntity(@NotNull String r10, @NotNull String r11, @NotNull String r12, @NotNull String r13, @NotNull String r14, @NotNull String r15, @NotNull String r16, int r17, @NotNull String r18, @NotNull String r19, boolean r110) {
        q.g(r10, "id");
        q.g(r11, "uid");
        q.g(r12, ServerElements.CONTENT);
        q.g(r13, "score");
        q.g(r14, "version");
        q.g(r15, "createTime");
        q.g(r16, ServerElements.NICKNAME);
        q.g(r18, ServerElements.LIKE);
        q.g(r19, "is_black");
        this.f8425id = r10;
        this.uid = r11;
        this.content = r12;
        this.score = r13;
        this.version = r14;
        this.createTime = r15;
        this.nickname = r16;
        this.ifLike = r17;
        this.like = r18;
        this.is_black = r19;
        this.isOpen = r110;
    }

    public static /* synthetic */ AppCommentEntity copy$default(AppCommentEntity r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, int r20, String r21, String r22, boolean r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r10 = r12.f8425id;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r11 = r12.uid;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r26 = r12.content;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r27 = r12.score;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r28 = r12.version;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r29 = r12.createTime;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r30 = r12.nickname;
    L31:
        if ((r24 & 128) == 0) goto L33;
        int r31 = r12.ifLike;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r110 = r12.like;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r111 = r12.is_black;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        boolean r32 = r12.isOpen;
    L47:
        return r12.copy(r10, r11, r26, r27, r28, r29, r30, r31, r110, r111, r32);
    L45:
        r32 = r23;
        goto L47
    L41:
        r111 = r22;
        goto L43
    L37:
        r110 = r21;
        goto L39
    L33:
        r31 = r20;
        goto L35
    L29:
        r30 = r19;
        goto L31
    L25:
        r29 = r18;
        goto L27
    L21:
        r28 = r17;
        goto L23
    L17:
        r27 = r16;
        goto L19
    L13:
        r26 = r15;
        goto L15
    L9:
        r11 = r14;
        goto L11
    L5:
        r10 = r13;
        goto L7
    }

    @NotNull
    public final String component1() {
        return this.f8425id;
    }

    @NotNull
    public final String component10() {
        return this.is_black;
    }

    public final boolean component11() {
        return this.isOpen;
    }

    @NotNull
    public final String component2() {
        return this.uid;
    }

    @NotNull
    public final String component3() {
        return this.content;
    }

    @NotNull
    public final String component4() {
        return this.score;
    }

    @NotNull
    public final String component5() {
        return this.version;
    }

    @NotNull
    public final String component6() {
        return this.createTime;
    }

    @NotNull
    public final String component7() {
        return this.nickname;
    }

    public final int component8() {
        return this.ifLike;
    }

    @NotNull
    public final String component9() {
        return this.like;
    }

    @NotNull
    public final AppCommentEntity copy(@NotNull String r14, @NotNull String r15, @NotNull String r16, @NotNull String r17, @NotNull String r18, @NotNull String r19, @NotNull String r20, int r21, @NotNull String r22, @NotNull String r23, boolean r24) {
        q.g(r14, "id");
        q.g(r15, "uid");
        q.g(r16, ServerElements.CONTENT);
        q.g(r17, "score");
        q.g(r18, "version");
        q.g(r19, "createTime");
        q.g(r20, ServerElements.NICKNAME);
        q.g(r22, ServerElements.LIKE);
        q.g(r23, "is_black");
        return new AppCommentEntity(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppCommentEntity) == true) goto L8;
        return false;
    L8:
        AppCommentEntity r11 = (AppCommentEntity) r10;
        if (q.b(this.f8425id, r11.f8425id) == true) goto L12;
        return false;
    L12:
        if (q.b(this.uid, r11.uid) == true) goto L15;
        return false;
    L15:
        if (q.b(this.content, r11.content) == true) goto L18;
        return false;
    L18:
        if (q.b(this.score, r11.score) == true) goto L21;
        return false;
    L21:
        if (q.b(this.version, r11.version) == true) goto L24;
        return false;
    L24:
        if (q.b(this.createTime, r11.createTime) == true) goto L27;
        return false;
    L27:
        if (q.b(this.nickname, r11.nickname) == true) goto L30;
        return false;
    L30:
        if (this.ifLike == r11.ifLike) goto L33;
        return false;
    L33:
        if (q.b(this.like, r11.like) == true) goto L36;
        return false;
    L36:
        if (q.b(this.is_black, r11.is_black) == true) goto L39;
        return false;
    L39:
        if (this.isOpen == r11.isOpen) goto L41;
        return false;
    L41:
        return true;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getId() {
        return this.f8425id;
    }

    public final int getIfLike() {
        return this.ifLike;
    }

    @NotNull
    public final String getLike() {
        return this.like;
    }

    @NotNull
    public final String getNickname() {
        return this.nickname;
    }

    @NotNull
    public final String getScore() {
        return this.score;
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((((this.f8425id.hashCode() * 31) + this.uid.hashCode()) * 31) + this.content.hashCode()) * 31) + this.score.hashCode()) * 31) + this.version.hashCode()) * 31) + this.createTime.hashCode()) * 31) + this.nickname.hashCode()) * 31) + Integer.hashCode(this.ifLike)) * 31) + this.like.hashCode()) * 31) + this.is_black.hashCode()) * 31) + Boolean.hashCode(this.isOpen);
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    @NotNull
    public final String is_black() {
        return this.is_black;
    }

    public final void setIfLike(int r10) {
        this.ifLike = r10;
    }

    public final void setLike(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.like = r10;
    }

    public final void setOpen(boolean r10) {
        this.isOpen = r10;
    }

    @NotNull
    public String toString() {
        return "AppCommentEntity(id=" + this.f8425id + ", uid=" + this.uid + ", content=" + this.content + ", score=" + this.score + ", version=" + this.version + ", createTime=" + this.createTime + ", nickname=" + this.nickname + ", ifLike=" + this.ifLike + ", like=" + this.like + ", is_black=" + this.is_black + ", isOpen=" + this.isOpen + ')';
    }

    public /* synthetic */ AppCommentEntity(String r14, String r15, String r16, String r17, String r18, String r19, String r20, int r21, String r22, String r23, boolean r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 1024) == 0) goto L5;
        boolean r12 = false;
    L6:
        this(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r12);
        return;
    L5:
        r12 = r24;
        goto L6
    }
}
