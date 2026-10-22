package com.bytedance.android.livesdk.livecommerce.userinfo.fragment.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u000b\u001a\u0004\u0018\u00010\n\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u00052\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\bH\u0080@"}, d2 = {"V", "", "maxRetries", "", "delayMillis", "Lkotlin/Function0;", "Lio/reactivex/Observable;", "getObservable", "Lkotlin/coroutines/Continuation;", "continuation", "", "tryGetObservable"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.userinfo.fragment.repository.AbsRepository", f = "AbsRepository.kt", i = {0, 0, 0}, l = {31}, m = "tryGetObservable$livecommerce_saasRelease", n = {"getObservable", "maxRetries", "delayMillis"}, s = {"L$0", "I$0", "J$0"})
public final class AbsRepository$tryGetObservable$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbsRepository this$0;

    public AbsRepository$tryGetObservable$1(AbsRepository r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, 0, null, this);
    }
}
