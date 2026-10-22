package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class n implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f66362a;

    public n(Function1 r100) {
        this.f66362a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final /* synthetic */ Object apply(Object r100) {
        return this.f66362a.invoke(r100);
    }
}
