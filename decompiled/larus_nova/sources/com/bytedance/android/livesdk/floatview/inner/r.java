package com.bytedance.android.livesdk.floatview.inner;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes8.dex */
public final class r<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f125227a;

    public r(k r100) {
        this.f125227a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        if (r101 == null) goto L7;
        this.f125227a.f125217y.onError(r101);
        return;
    }
}
