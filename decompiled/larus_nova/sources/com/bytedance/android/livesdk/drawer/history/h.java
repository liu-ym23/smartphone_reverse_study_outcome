package com.bytedance.android.livesdk.drawer.history;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoadingViewHolder f122490a;

    public h(LoadingViewHolder r100) {
        this.f122490a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L5;
        LoadingViewHolder r101 = this.f122490a;
        r101.f122482a.setVisibility(0);
        r101.f122482a.b();
        return;
    L5:
        LoadingViewHolder r102 = this.f122490a;
        r102.f122482a.setVisibility(8);
        r102.f122482a.c();
    }
}
