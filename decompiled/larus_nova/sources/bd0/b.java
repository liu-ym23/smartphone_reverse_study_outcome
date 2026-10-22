package bd0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f18624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f18625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f18626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f18627e;

    public final String toString() {
        return "MultiLinkRegion(uid='" + this.f18623a + "', x=" + this.f18624b + ", y=" + this.f18625c + ", width=" + this.f18626d + ", height=" + this.f18627e + ')';
    }

    public b(String r100, float r101, float r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        this.f18623a = r100;
        this.f18624b = r101;
        this.f18625c = r102;
        this.f18626d = r103;
        this.f18627e = r104;
    }
}
