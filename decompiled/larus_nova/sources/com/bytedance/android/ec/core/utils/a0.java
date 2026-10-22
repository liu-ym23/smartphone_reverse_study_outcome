package com.bytedance.android.ec.core.utils;

import androidx.arch.core.util.Function;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class a0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f45550a;

    public a0(Function1 r100) {
        this.f45550a = r100;
    }

    @Override // androidx.arch.core.util.Function
    public final /* synthetic */ Object apply(Object r100) {
        return this.f45550a.invoke(r100);
    }
}
