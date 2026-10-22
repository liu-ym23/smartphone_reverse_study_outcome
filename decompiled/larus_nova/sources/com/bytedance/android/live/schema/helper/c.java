package com.bytedance.android.live.schema.helper;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f100515a;

    public c(Ref.ObjectRef r100) {
        this.f100515a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        ((Disposable) this.f100515a.element).dispose();
    }
}
