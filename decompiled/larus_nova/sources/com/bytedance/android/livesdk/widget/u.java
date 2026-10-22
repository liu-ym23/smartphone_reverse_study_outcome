package com.bytedance.android.livesdk.widget;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes11.dex */
public final class u implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f162151a;

    public u(Function1 r100) {
        this.f162151a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object r100) {
        this.f162151a.invoke(r100);
    }
}
