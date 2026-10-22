package c21;

import com.bytedance.android.live.revlink.impl.mergepk.params.LinkmicBizType;
import com.bytedance.android.live.revlink.impl.mergepk.params.ReplyType;
import com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkmicBizType f22171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReplyType f22173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f22174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f22175f;

    public h() {
        this(0, null, null, false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L18;
        h r101 = (h) r100;
        if (this.f22170a == r101.f22170a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f22171b, r101.f22171b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f22172c, r101.f22172c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22173d, r101.f22173d) == true) goto L14;
        return false;
    L14:
        if (this.f22174e == r101.f22174e) goto L16;
        return false;
    L16:
        if (this.f22175f == r101.f22175f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        int r100 = this.f22170a * 31;
        LinkmicBizType r101 = this.f22171b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f22172c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        ReplyType r108 = this.f22173d;
        if (r108 == null) goto L13;
        r102 = r108.hashCode();
    L13:
        int r109 = (r107 + r102) * 31;
        boolean r110 = this.f22174e;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r109 + r112) * 31;
        boolean r114 = this.f22175f;
        if (r114 == true) goto L21;
        r111 = r114;
    L21:
        return r113 + r111;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "BizCommonParams(inviteType=" + this.f22170a + ", bizType=" + this.f22171b + ", gameAppId=" + this.f22172c + ", replyStatus=" + this.f22173d + ", limitedByStreamMixType=" + this.f22174e + ", isOnceMore=" + this.f22175f + ")";
    }

    public h(int r100, LinkmicBizType r101, String r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = ILinkMicBizInviteMessage.BizInviteType.BizInviteDefault.ordinal();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = LinkmicBizType.LinkmicBizTypeUnknown;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        ReplyType r105 = ReplyType.Undefined;
    L16:
        if ((r104 & 16) == 0) goto L18;
        r103 = false;
    L18:
        Intrinsics.checkNotNullParameter(r101, "bizType");
        Intrinsics.checkNotNullParameter(r102, "gameAppId");
        Intrinsics.checkNotNullParameter(r105, "replyStatus");
        this.f22170a = r100;
        this.f22171b = r101;
        this.f22172c = r102;
        this.f22173d = r105;
        this.f22174e = r103;
        this.f22175f = false;
        return;
    L14:
        r105 = null;
        goto L16
    }
}
