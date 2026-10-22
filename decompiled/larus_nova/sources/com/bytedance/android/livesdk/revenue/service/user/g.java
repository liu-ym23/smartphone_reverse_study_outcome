package com.bytedance.android.livesdk.revenue.service.user;

import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f157505a = null;

    static {
        f157505a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        FollowPair r101 = (FollowPair) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101;
    }
}
