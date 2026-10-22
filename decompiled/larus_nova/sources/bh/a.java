package bh;

import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class a<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f18987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f18988b;

    public a(b r100, Function1 r101) {
        this.f18987a = r100;
        this.f18988b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        Integer r100 = this.f18987a.b();
        this.f18988b.invoke(r100);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
