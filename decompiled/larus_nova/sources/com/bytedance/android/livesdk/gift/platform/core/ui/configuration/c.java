package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f131965a;

    public c(Function0 r100) {
        this.f131965a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Function0 r102 = this.f131965a;
        if (r102 == null) goto L6;
        Unit r103 = (Unit) r102.invoke();
        return;
    }
}
