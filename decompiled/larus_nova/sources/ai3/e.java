package ai3;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements ul.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f3733a;

    public e(Function1 r100) {
        this.f3733a = r100;
    }

    @Override // ul.c
    public final void a(boolean r100) {
        this.f3733a.invoke(Boolean.valueOf(r100));
    }
}
