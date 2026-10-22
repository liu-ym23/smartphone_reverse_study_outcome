package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f108864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f108865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f108866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f108867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f108868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f108869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f108870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f108871h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f108872i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f108873j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L26;
        b r101 = (b) r100;
        if (this.f108864a == r101.f108864a) goto L8;
        return false;
    L8:
        if (this.f108865b == r101.f108865b) goto L10;
        return false;
    L10:
        if (this.f108866c == r101.f108866c) goto L12;
        return false;
    L12:
        if (this.f108867d == r101.f108867d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f108868e, r101.f108868e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f108869f, r101.f108869f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f108870g, r101.f108870g) == true) goto L20;
        return false;
    L20:
        if (this.f108871h == r101.f108871h) goto L22;
        return false;
    L22:
        if (this.f108872i == r101.f108872i) goto L24;
        return false;
    L24:
        if (this.f108873j == r101.f108873j) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        long r100 = this.f108864a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f108865b;
        ?? r103 = 1;
        ?? r104 = r102;
        if (r102 == false) goto L5;
        r104 = 1;
    L5:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.f108866c;
        ?? r107 = r106;
        if (r106 == false) goto L8;
        r107 = 1;
    L8:
        int r108 = (r105 + r107) * 31;
        boolean r109 = this.f108867d;
        ?? r110 = r109;
        if (r109 == false) goto L11;
        r110 = 1;
    L11:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f108868e;
        int r113 = 0;
        if (r112 == null) goto L14;
        int r114 = r112.hashCode();
    L15:
        int r115 = (r111 + r114) * 31;
        String r116 = this.f108869f;
        if (r116 == null) goto L18;
        int r117 = r116.hashCode();
    L19:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f108870g;
        if (r119 == null) goto L22;
        r113 = r119.hashCode();
    L22:
        int r120 = (r118 + r113) * 31;
        boolean r121 = this.f108871h;
        ?? r122 = r121;
        if (r121 == false) goto L25;
        r122 = 1;
    L25:
        int r123 = (r120 + r122) * 31;
        boolean r124 = this.f108872i;
        ?? r125 = r124;
        if (r124 == false) goto L28;
        r125 = 1;
    L28:
        int r126 = (r123 + r125) * 31;
        boolean r127 = this.f108873j;
        if (r127 == true) goto L33;
        r103 = r127;
    L33:
        return r126 + r103;
    L18:
        r117 = 0;
        goto L19
    L14:
        r114 = 0;
        goto L15
    }

    public final String toString() {
        return "CommentSendLogData(commentID=" + this.f108864a + ", isCommentPlusOne=" + this.f108865b + ", hasEmoji=" + this.f108866c + ", isFromWelcomeComment=" + this.f108867d + ", commentColor=" + this.f108868e + ", commentType=" + this.f108869f + ", plusOneCommentType=" + this.f108870g + ", hasGifEmoji=" + this.f108871h + ", hasSystemEmoji=" + this.f108872i + ", hasKeyboardEmoji=" + this.f108873j + ")";
    }

    public b(long r100, boolean r101, boolean r102, boolean r103, String r104, String r105, boolean r106, boolean r107) {
        this.f108864a = r100;
        this.f108865b = r101;
        this.f108866c = r102;
        this.f108867d = r103;
        this.f108868e = r104;
        this.f108869f = "";
        this.f108870g = r105;
        this.f108871h = false;
        this.f108872i = r106;
        this.f108873j = r107;
    }
}
