package c19;

import android.graphics.Path;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f22102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f22103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Path> f22104c;

    public h() {
        throw null;
    }

    public h(Path r100, d r101) {
        List<Path> r102 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r102, "clips");
        this.f22102a = r100;
        this.f22103b = r101;
        this.f22104c = r102;
    }
}
