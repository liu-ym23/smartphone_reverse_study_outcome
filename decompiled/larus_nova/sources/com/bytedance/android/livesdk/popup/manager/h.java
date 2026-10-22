package com.bytedance.android.livesdk.popup.manager;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f156306a = null;

    static {
        f156306a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        LivePopupInfo.State r101 = (LivePopupInfo.State) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.isAtLeast(LivePopupInfo.State.SHOWING);
    }
}
