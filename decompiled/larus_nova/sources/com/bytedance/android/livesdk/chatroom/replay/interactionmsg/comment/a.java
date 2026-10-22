package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f108857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f108858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f108859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f108860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f108861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f108862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f108863g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (this.f108857a == r101.f108857a) goto L8;
        return false;
    L8:
        if (this.f108858b == r101.f108858b) goto L10;
        return false;
    L10:
        if (this.f108859c == r101.f108859c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f108860d, r101.f108860d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f108861e, r101.f108861e) == true) goto L16;
        return false;
    L16:
        if (this.f108862f == r101.f108862f) goto L18;
        return false;
    L18:
        if (this.f108863g == r101.f108863g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        long r100 = this.f108857a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f108858b;
        ?? r103 = 1;
        ?? r104 = r102;
        if (r102 == false) goto L5;
        r104 = 1;
    L5:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.f108859c;
        ?? r107 = r106;
        if (r106 == false) goto L8;
        r107 = 1;
    L8:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f108860d;
        int r110 = 0;
        if (r109 == null) goto L11;
        int r111 = r109.hashCode();
    L12:
        int r112 = (r108 + r111) * 31;
        String r113 = this.f108861e;
        if (r113 == null) goto L15;
        r110 = r113.hashCode();
    L15:
        int r114 = (((r112 + r110) * 31) + this.f108862f) * 31;
        boolean r115 = this.f108863g;
        if (r115 == true) goto L20;
        r103 = r115;
    L20:
        return r114 + r103;
    L11:
        r111 = 0;
        goto L12
    }

    public final String toString() {
        return "CommentClickLogData(commentID=" + this.f108857a + ", isCommentPlusOne=" + this.f108858b + ", hasEmoji=" + this.f108859c + ", commentColor=" + this.f108860d + ", commentType=" + this.f108861e + ", startWatchRecord=" + this.f108862f + ", isSelfSendFake=" + this.f108863g + ")";
    }

    public a(long r100, boolean r101, boolean r102, String r103, String r104, int r105, boolean r106) {
        this.f108857a = r100;
        this.f108858b = r101;
        this.f108859c = r102;
        this.f108860d = r103;
        this.f108861e = r104;
        this.f108862f = r105;
        this.f108863g = r106;
    }
}
