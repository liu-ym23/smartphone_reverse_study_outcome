package com.bytedance.android.livesdk.microom.enhance;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f153845a;

    public f() {
        this.f153845a = 60;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Long r101 = (Long) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Long.valueOf((((long) this.f153845a) - r101.longValue()) - 1);
    }
}
