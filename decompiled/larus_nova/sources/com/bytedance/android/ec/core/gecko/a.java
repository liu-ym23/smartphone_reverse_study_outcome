package com.bytedance.android.ec.core.gecko;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f44101a = null;

    static {
        f44101a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        com.bytedance.geckox.b r101 = com.bytedance.geckox.b.a.f245076a;
        com.bytedance.geckox.b.e(new ECGeckoRegister());
    }
}
