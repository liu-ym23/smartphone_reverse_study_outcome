package io.reactivex;

import io.reactivex.annotations.NonNull;
import mf.e;

/* JADX INFO: loaded from: classes4.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    @NonNull
    ObservableSource<Downstream> apply(@NonNull e r10);
}
