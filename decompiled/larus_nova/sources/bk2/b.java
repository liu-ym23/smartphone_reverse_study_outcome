package bk2;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f19296a;

    @Override // bk2.d
    public final Disposable ignore(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return r100;
    }

    @Override // bk2.d
    public final void clearDisposable() {
        this.f19296a.clear();
    }

    public b() {
        this.f19296a = new CompositeDisposable();
    }

    @Override // bk2.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f19296a.add(r100);
        return r100;
    }

    @Override // bk2.d
    public final void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f19296a.remove(r100);
    }
}
