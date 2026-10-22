package ac0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2549c;

    public final String getType() {
        return this.f2547a;
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f2547a = r100;
        this.f2548b = 0;
        this.f2549c = 0;
    }
}
