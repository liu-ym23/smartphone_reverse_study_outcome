package ch0;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f23734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f23736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f23737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f23738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f23739g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L20;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f23733a, r101.f23733a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f23734b, r101.f23734b) == true) goto L10;
        return false;
    L10:
        if (this.f23735c == r101.f23735c) goto L12;
        return false;
    L12:
        if (this.f23736d == r101.f23736d) goto L14;
        return false;
    L14:
        if (this.f23737e == r101.f23737e) goto L16;
        return false;
    L16:
        if (this.f23738f == r101.f23738f) goto L18;
        return false;
    L18:
        if (this.f23739g == r101.f23739g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        String r100 = this.f23733a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        View r104 = this.f23734b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f23735c;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f23736d;
        ?? r111 = r110;
        if (r110 == false) goto L15;
        r111 = 1;
    L15:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f23737e;
        if (r113 == true) goto L19;
        r107 = r113;
    L19:
        long r114 = this.f23738f;
        return ((((r112 + r107) * 31) + ((int) (r114 ^ (r114 >>> 32)))) * 31) + this.f23739g;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RtcRemoteUserInfo(interactId=" + this.f23733a + ", surfaceView=" + this.f23734b + ", isVideoMute=" + this.f23735c + ", isAudioMute=" + this.f23736d + ", isTalking=" + this.f23737e + ", lastTalkingTime=" + this.f23738f + ", localUserOnlineStatus=" + this.f23739g + ")";
    }

    public /* synthetic */ h(String r110, boolean r111, boolean r112, int r113, int r114) {
        if ((r114 & 64) == 0) goto L5;
        int r100 = 0;
    L6:
        this(r110, null, r111, r112, false, 0, r100);
        return;
    L5:
        r100 = r113;
        goto L6
    }

    public h(String r100, View r101, boolean r102, boolean r103, boolean r104, long r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        this.f23733a = r100;
        this.f23734b = r101;
        this.f23735c = r102;
        this.f23736d = r103;
        this.f23737e = r104;
        this.f23738f = r105;
        this.f23739g = r106;
    }

    public static h a(h r110, View r111, boolean r112, boolean r113, boolean r114, int r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        String r100 = r110.f23733a;
    L6:
        String r101 = r100;
        if ((r116 & 2) == 0) goto L9;
        View r102 = r110.f23734b;
    L11:
        if ((r116 & 4) == 0) goto L13;
        boolean r103 = r110.f23735c;
    L15:
        if ((r116 & 8) == 0) goto L17;
        boolean r104 = r110.f23736d;
    L19:
        if ((r116 & 16) == 0) goto L21;
        boolean r105 = r110.f23737e;
    L23:
        if ((r116 & 32) == 0) goto L25;
        long r106 = r110.f23738f;
    L26:
        long r107 = r106;
        if ((r116 & 64) == 0) goto L29;
        int r117 = r110.f23739g;
    L30:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "interactId");
        return new h(r101, r102, r103, r104, r105, r107, r117);
    L29:
        r117 = r115;
        goto L30
    L25:
        r106 = 0;
        goto L26
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = null;
        goto L6
    }
}
