package com.bytedance.android.gamecp.hybrid_impl.lynx;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f57598a;

    public d(Ref.ObjectRef r100) {
        this.f57598a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Disposable r100 = (Disposable) this.f57598a.element;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }
}
