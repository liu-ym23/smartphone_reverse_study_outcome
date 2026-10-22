package c59;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f22519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e0> f22520b;

    public n() {
        this(null);
    }

    public n(Object r100) {
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        Intrinsics.checkNotNullParameter(r101, "aboveTabCards");
        Intrinsics.checkNotNullParameter(r102, "tabs");
        this.f22519a = r101;
        this.f22520b = r102;
    }
}
