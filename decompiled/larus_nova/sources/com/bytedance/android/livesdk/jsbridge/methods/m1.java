package com.bytedance.android.livesdk.jsbridge.methods;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p1 f142156a;

    public m1(p1 r100) {
        this.f142156a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        int r102 = ((Number) r101.getFirst()).intValue();
        String r103 = (String) r101.getSecond();
        if (r102 != 0) goto L5;
        this.f142156a.finishWithSuccess();
        return;
    L5:
        this.f142156a.j(r102, r103);
    }
}
