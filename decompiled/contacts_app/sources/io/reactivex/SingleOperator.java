package io.reactivex;

/* JADX INFO: loaded from: classes4.dex */
public interface SingleOperator<Downstream, Upstream> {
    SingleObserver<? super Upstream> apply(SingleObserver<? super Downstream> r1) throws Exception;
}
