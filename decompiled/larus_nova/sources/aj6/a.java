package aj6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f3934b;

    public final String toString() {
        return "RTCPositionInfo(position=" + this.f3933a + ", orientation=" + this.f3934b + ')';
    }

    public a(d r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "position");
        Intrinsics.checkNotNullParameter(r101, "orientation");
        this.f3933a = r100;
        this.f3934b = r101;
    }
}
