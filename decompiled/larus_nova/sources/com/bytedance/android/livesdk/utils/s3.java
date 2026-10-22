package com.bytedance.android.livesdk.utils;

import androidx.arch.core.util.Function;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes11.dex */
public final class s3<I, O> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KProperty1 f159158a;

    public s3(KProperty1 r100) {
        this.f159158a = r100;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object r100) {
        return this.f159158a.get(r100);
    }
}
