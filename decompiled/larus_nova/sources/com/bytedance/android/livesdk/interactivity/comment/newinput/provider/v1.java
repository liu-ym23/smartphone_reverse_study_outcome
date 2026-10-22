package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class v1<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f136000a;

    public v1(long r100) {
        this.f136000a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        c32.c r102 = (c32.c) r101.data;
        if (r102 == null) goto L5;
        r102.f22266a = this.f136000a;
    L5:
        return r101;
    }
}
