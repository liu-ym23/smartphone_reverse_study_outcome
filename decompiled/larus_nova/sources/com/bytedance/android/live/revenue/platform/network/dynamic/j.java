package com.bytedance.android.live.revenue.platform.network.dynamic;

import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T1, T2> implements BiPredicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f91527a = null;

    static {
        f91527a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.BiPredicate
    public final boolean test(Object r100, Object r101) {
        com.ss.ugc.live.sdk.message.wrsc.data.a r102 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r100;
        com.ss.ugc.live.sdk.message.wrsc.data.a r103 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r101;
        Intrinsics.checkNotNullParameter(r102, "old");
        Intrinsics.checkNotNullParameter(r103, "new");
        if (r102.f458180a != r103.f458180a) goto L5;
        return true;
    L5:
        return false;
    }
}
