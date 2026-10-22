package com.bytedance.android.ec.core.utils;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class h1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f45603a;

    public h1(Function1 r100) {
        this.f45603a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final /* synthetic */ Object apply(Object r100) {
        return this.f45603a.invoke(r100);
    }
}
