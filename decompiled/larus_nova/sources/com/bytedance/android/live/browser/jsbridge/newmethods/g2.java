package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g2<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f63382a;

    public g2(Object r100) {
        this.f63382a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        com.bytedance.android.livesdk.event.z r101 = (com.bytedance.android.livesdk.event.z) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.f123383a != this.f63382a) goto L5;
        return true;
    L5:
        return false;
    }
}
