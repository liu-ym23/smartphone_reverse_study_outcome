package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: classes4.dex */
final class ActionDisposable extends ReferenceDisposable<Action> {
    private static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(Action r10) {
        super(r10);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public /* bridge */ /* synthetic */ void onDisposed(@NonNull Action r10) {
        onDisposed2(r10);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    public void onDisposed2(@NonNull Action r10) {
        r10.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }
}
