package com.bytedance.android.gamecp.common.ui.popup.manager;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f57047a = null;

    static {
        f57047a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        LivePopupInfo.State r101 = (LivePopupInfo.State) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.isAtLeast(LivePopupInfo.State.SHOWING);
    }
}
