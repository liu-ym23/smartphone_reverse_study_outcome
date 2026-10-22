package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.functions.BiPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class sa<T1, T2> implements BiPredicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sa f63654a = null;

    static {
        f63654a = new sa();
    }

    public sa() {
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
