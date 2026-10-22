package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class v implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f66380a;

    public v(Function1 r100) {
        this.f66380a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final /* synthetic */ Object apply(Object r100) {
        return this.f66380a.invoke(r100);
    }
}
