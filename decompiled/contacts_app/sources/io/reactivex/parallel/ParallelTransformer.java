package io.reactivex.parallel;

/* JADX INFO: loaded from: classes4.dex */
public interface ParallelTransformer<Upstream, Downstream> {
    ParallelFlowable<Downstream> apply(ParallelFlowable<Upstream> r1);
}
