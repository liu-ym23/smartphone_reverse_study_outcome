package b49;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f17665g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f17666h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f17667i;

    public final String toString() {
        return "FlowDoraDataFrame(stage=" + this.f17659a + ", scene=" + this.f17660b + ", id=" + this.f17661c + ", type=" + this.f17662d + ", seq=" + this.f17663e + ", count=" + this.f17664f + ", data=" + Arrays.toString(this.f17665g) + ", assId=" + this.f17666h + ", assData=" + Arrays.toString(this.f17667i) + ')';
    }

    public final int getType() {
        return this.f17662d;
    }

    public g(int r100, int r101, int r102, int r103, int r104, int r105, byte[] r106, int r107, byte[] r110) {
        Intrinsics.checkNotNullParameter(r106, "data");
        Intrinsics.checkNotNullParameter(r110, "assData");
        this.f17659a = r100;
        this.f17660b = r101;
        this.f17661c = r102;
        this.f17662d = r103;
        this.f17663e = r104;
        this.f17664f = r105;
        this.f17665g = r106;
        this.f17666h = r107;
        this.f17667i = r110;
    }
}
