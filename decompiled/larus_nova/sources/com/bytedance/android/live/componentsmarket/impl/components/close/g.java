package com.bytedance.android.live.componentsmarket.impl.components.close;

import com.bytedance.android.live.core.tetris.widgets.y;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomCloseWidget f64644a;

    public g(RoomCloseWidget r100) {
        this.f64644a = r100;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        y r101 = (y) r100;
        Intrinsics.checkNotNullParameter(r101, "<name for destructuring parameter 0>");
        r101.getClass();
        int r102 = r101.f66043b;
        this.f64644a.getClass();
        if ((r102 & 8) != r102) goto L5;
        return true;
    L5:
        return false;
    }
}
