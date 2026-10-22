package io.reactivex;

import io.reactivex.annotations.NonNull;
import mf.c;

/* JADX INFO: loaded from: classes4.dex */
public interface MaybeTransformer<Upstream, Downstream> {
    @NonNull
    MaybeSource<Downstream> apply(@NonNull c r10);
}
