package com.bytedance.android.live.profile;

import com.bytedance.android.live.profile.model.EnterExitStateType;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f86015a = null;

    static {
        f86015a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        com.bytedance.android.live.profile.model.a r101 = (com.bytedance.android.live.profile.model.a) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (r101.f86063a != EnterExitStateType.ENTER_END) goto L5;
        return true;
    L5:
        return false;
    }
}
