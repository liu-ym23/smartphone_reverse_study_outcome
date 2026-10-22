package com.bytedance.android.livesdk.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountdownTaskWidget f161703a;

    public g(CountdownTaskWidget r100) {
        this.f161703a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L6;
        CountdownTaskWidget r101 = this.f161703a;
        int r102 = CountdownTaskWidget.f160797j;
        r101.xq();
        return;
    }
}
