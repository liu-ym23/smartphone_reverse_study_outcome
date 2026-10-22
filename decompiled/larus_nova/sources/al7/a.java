package al7;

import com.bytedance.ug.sdk.luckydog.api.stage.LuckyActivityBlockStage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f4161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LuckyActivityBlockStage f4162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f4164i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4165j;

    public final String toString() {
        return "ActivityStageBean(entryId=" + this.f4156a + ", resourceId=" + this.f4157b + ", cycleId=" + this.f4158c + ", startTime=" + this.f4159d + ", endTime=" + this.f4160e + ", resourceDate=" + this.f4161f + ", bk=" + this.f4162g + ", extra=" + this.f4163h + ", version=" + this.f4164i + ", timeFailed=" + this.f4165j + ")";
    }

    public final int hashCode() {
        return ((((70 + this.f4156a.hashCode()) * 5) + this.f4157b.hashCode()) * 5) + this.f4158c.hashCode();
    }

    public final boolean equals(Object r100) {
        boolean r101 = r100 instanceof a;
        if (r101 == true) goto L5;
        return false;
    L5:
        String r102 = null;
        if (r101 == true) goto L8;
        r100 = null;
    L8:
        a r103 = (a) r100;
        String r104 = this.f4156a;
        if (r103 == null) goto L12;
        r102 = r103.f4156a;
    L12:
        if (Intrinsics.areEqual(r104, r102) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f4157b, r103.f4157b) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f4158c, r103.f4158c) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public a(String r100, String r101, String r102, long r103, long r104, String r105, LuckyActivityBlockStage r106, String r110, int r111, boolean r112) {
        this.f4156a = r100;
        this.f4157b = r101;
        this.f4158c = r102;
        this.f4159d = r103;
        this.f4160e = r104;
        this.f4161f = r105;
        this.f4162g = r106;
        this.f4163h = r110;
        this.f4164i = r111;
        this.f4165j = r112;
    }
}
