package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f133433a;

    public c(Function1 r100) {
        this.f133433a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(T r100) {
        this.f133433a.invoke(r100);
    }
}
