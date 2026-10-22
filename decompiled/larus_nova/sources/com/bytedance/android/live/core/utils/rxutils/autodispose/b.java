package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class b implements ScopeProvider {
    public /* synthetic */ b() {
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ScopeProvider
    public final CompletableSource requestScope() {
        return Completable.complete();
    }
}
