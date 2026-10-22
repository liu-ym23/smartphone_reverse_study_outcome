package com.bytedance.android.livesdk.floatview.inner;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes8.dex */
public final class q<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f125226a;

    public q(k r100) {
        this.f125226a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Pair r101 = (Pair) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (((Number) r101.getFirst()).intValue() != 0) goto L7;
        return;
    L7:
        if (((Number) r101.getSecond()).intValue() == 0) goto L13;
        this.f125226a.f125217y.onVideoSizeChanged(((Number) r101.getFirst()).intValue(), ((Number) r101.getSecond()).intValue());
        return;
    }
}
