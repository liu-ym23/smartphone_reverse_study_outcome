package c21;

import com.bytedance.android.live.revlink.impl.mergepk.params.BattleInviteType;
import com.bytedance.android.livesdk.link.model.v3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BattleInviteType f22182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f22185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f22186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v3 f22187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f22188g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L20;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f22182a, r101.f22182a) == true) goto L8;
        return false;
    L8:
        if (this.f22183b == r101.f22183b) goto L10;
        return false;
    L10:
        if (this.f22184c == r101.f22184c) goto L12;
        return false;
    L12:
        if (this.f22185d == r101.f22185d) goto L14;
        return false;
    L14:
        if (this.f22186e == r101.f22186e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f22187f, r101.f22187f) == true) goto L18;
        return false;
    L18:
        if (this.f22188g == r101.f22188g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        BattleInviteType r100 = this.f22182a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f22183b;
        int r104 = ((((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f22184c) * 31;
        boolean r105 = this.f22185d;
        ?? r106 = r105;
        if (r105 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r104 + r106) * 31;
        long r108 = this.f22186e;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        v3 r110 = this.f22187f;
        if (r110 == null) goto L12;
        r101 = r110.hashCode();
    L12:
        int r111 = (r109 + r101) * 31;
        long r112 = this.f22188g;
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommonParams(inviteType=" + this.f22182a + ", duration=" + this.f22183b + ", multiPkMode=" + this.f22184c + ", isOnceMore=" + this.f22185d + ", decideDuration=" + this.f22186e + ", clientAttachedInfo=" + this.f22187f + ", activityType=" + this.f22188g + ")";
    }

    public l(BattleInviteType r100, long r101, int r102, boolean r103, long r104, v3 r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = BattleInviteType.UNKNOWN;
    L6:
        if ((r111 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r111 & 8) == 0) goto L11;
        r103 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, "inviteType");
        this.f22182a = r100;
        this.f22183b = r101;
        this.f22184c = r102;
        this.f22185d = r103;
        this.f22186e = r104;
        this.f22187f = r110;
        this.f22188g = 0;
    }
}
