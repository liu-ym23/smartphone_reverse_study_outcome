package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q3<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f131697a;

    public q3(Function0 r100) {
        this.f131697a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f131697a.invoke();
    }
}
