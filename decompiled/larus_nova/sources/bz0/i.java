package bz0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i implements yy0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cq2.b f21826a;

    @Override // yy0.f
    public final void b() {
        this.f21826a.a();
    }

    public i(cq2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f21826a = r100;
    }

    @Override // yy0.f
    public final void a(String r100) {
        this.f21826a.setTitle(r100);
    }
}
