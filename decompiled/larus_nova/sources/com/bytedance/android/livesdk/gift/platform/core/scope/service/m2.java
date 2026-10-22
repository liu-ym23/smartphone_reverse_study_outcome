package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class m2<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f131642a;

    public m2(Ref.LongRef r100) {
        this.f131642a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Intrinsics.checkNotNullParameter((Long) r100, "it");
        if (this.f131642a.element <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
