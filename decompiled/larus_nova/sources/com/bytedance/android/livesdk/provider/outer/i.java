package com.bytedance.android.livesdk.provider.outer;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f156745a;

    public i(e r100) {
        this.f156745a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == true) goto L13;
        e r101 = this.f156745a;
        if (r101.f156736r < r101.f156737s) goto L8;
        return;
    L8:
        if ((System.currentTimeMillis() - r101.f156730l) < r101.f156731m) goto L14;
        r101.f156730l = System.currentTimeMillis();
        r101.c();
        return;
    L14:
        return;
    }
}
