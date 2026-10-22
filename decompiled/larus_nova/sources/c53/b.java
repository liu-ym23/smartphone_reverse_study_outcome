package c53;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f22480a;

    @Override // c53.d
    public final Disposable ignore(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return r100;
    }

    @Override // c53.d
    public final void doClear() {
        this.f22480a.clear();
    }

    public b() {
        this.f22480a = new CompositeDisposable();
    }

    @Override // c53.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f22480a.add(r100);
        return r100;
    }

    @Override // c53.d
    public final void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f22480a.remove(r100);
    }
}
