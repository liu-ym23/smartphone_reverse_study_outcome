package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f78743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f78744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f78745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f78746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f78747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f78748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f78749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f78750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f78751i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f78752j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IMessageBoardInfo f78753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f78754l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f78755m;

    public d() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L32;
        d r101 = (d) r100;
        if (this.f78743a == r101.f78743a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f78744b, r101.f78744b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f78745c, r101.f78745c) == true) goto L12;
        return false;
    L12:
        if (this.f78746d == r101.f78746d) goto L14;
        return false;
    L14:
        if (this.f78747e == r101.f78747e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f78748f, r101.f78748f) == true) goto L18;
        return false;
    L18:
        if (this.f78749g == r101.f78749g) goto L20;
        return false;
    L20:
        if (this.f78750h == r101.f78750h) goto L22;
        return false;
    L22:
        if (this.f78751i == r101.f78751i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f78752j, r101.f78752j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f78753k, r101.f78753k) == true) goto L28;
        return false;
    L28:
        if (this.f78754l == r101.f78754l) goto L30;
        return false;
    L30:
        if (this.f78755m == r101.f78755m) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    public final int hashCode() {
        boolean r100 = this.f78743a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f78744b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f78745c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (((r107 + r109) * 31) + this.f78746d) * 31;
        long r111 = this.f78747e;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        String r113 = this.f78748f;
        if (r113 == null) goto L16;
        int r114 = r113.hashCode();
    L17:
        int r115 = (((r112 + r114) * 31) + this.f78749g) * 31;
        boolean r116 = this.f78750h;
        if (r116 == true) goto L21;
        r101 = r116;
    L21:
        long r117 = this.f78751i;
        int r118 = (((r115 + r101) * 31) + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        Map<String, String> r119 = this.f78752j;
        if (r119 == null) goto L24;
        int r120 = r119.hashCode();
    L25:
        int r121 = (r118 + r120) * 31;
        IMessageBoardInfo r122 = this.f78753k;
        if (r122 == null) goto L28;
        r105 = r122.hashCode();
    L28:
        int r123 = (r121 + r105) * 31;
        long r124 = this.f78754l;
        int r125 = (r123 + ((int) (r124 ^ (r124 >>> 32)))) * 31;
        long r126 = this.f78755m;
        return r125 + ((int) ((r126 >>> 32) ^ r126));
    L24:
        r120 = 0;
        goto L25
    L16:
        r114 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "AudienceLogParams(isAutoApproved=" + this.f78743a + ", connectionType=" + this.f78744b + ", fromUserId=" + this.f78745c + ", applySource=" + this.f78746d + ", roomId=" + this.f78747e + ", anchorId=" + this.f78748f + ", initLinkType=" + this.f78749g + ", isLinkMicQuickInvite=" + this.f78750h + ", talkDuration=" + this.f78751i + ", rechargeParam=" + this.f78752j + ", messageBoardInfo=" + this.f78753k + ", waitTime=" + this.f78754l + ", watchDuration=" + this.f78755m + ")";
    }

    public d(Object r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(com.bytedance.android.livesdk.chatroom.model.interact.e1.REPLY_ACTION_APPLY, "connectionType");
        Intrinsics.checkNotNullParameter("0", "fromUserId");
        Intrinsics.checkNotNullParameter("0", "anchorId");
        Intrinsics.checkNotNullParameter(r101, "rechargeParam");
        this.f78743a = false;
        this.f78744b = com.bytedance.android.livesdk.chatroom.model.interact.e1.REPLY_ACTION_APPLY;
        this.f78745c = "0";
        this.f78746d = 0;
        this.f78747e = 0;
        this.f78748f = "0";
        this.f78749g = 2;
        this.f78750h = false;
        this.f78751i = 0;
        this.f78752j = r101;
        this.f78753k = null;
        this.f78754l = 0;
        this.f78755m = 0;
    }
}
