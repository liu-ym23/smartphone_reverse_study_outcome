package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.config.iq;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f116300a;

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f116300a.isDisposed();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f116300a.dispose();
    }

    public f(int r100) {
        if ((r100 & 2) == 0) goto L6;
        iq.f120472a.getValue().longValue();
    L6:
        if ((r100 & 4) == 0) goto L8;
        CompositeDisposable r101 = new CompositeDisposable();
    L9:
        Intrinsics.checkNotNullParameter(r101, "disposable");
        this.f116300a = r101;
        new LinkedHashMap();
        return;
    L8:
        r101 = null;
        goto L9
    }
}
