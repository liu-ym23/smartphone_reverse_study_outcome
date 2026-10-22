package io.reactivex;

import io.reactivex.annotations.NonNull;
import mf.b;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes4.dex */
public interface FlowableTransformer<Upstream, Downstream> {
    @NonNull
    Publisher<Downstream> apply(@NonNull b r10);
}
