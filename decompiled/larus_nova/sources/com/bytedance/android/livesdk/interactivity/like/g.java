package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f137672a;

    public g(d r100) {
        this.f137672a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Intrinsics.checkNotNullParameter((Long) r100, "it");
        if (this.f137672a.f137654b <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
