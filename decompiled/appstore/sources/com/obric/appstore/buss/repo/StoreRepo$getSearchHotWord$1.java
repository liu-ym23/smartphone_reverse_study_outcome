package com.obric.appstore.buss.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.repo.StoreRepo", f = "StoreRepo.kt", i = {}, l = {90}, m = "getSearchHotWord", n = {}, s = {})
public final class StoreRepo$getSearchHotWord$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StoreRepo this$0;

    public StoreRepo$getSearchHotWord$1(StoreRepo r10, Continuation<? super StoreRepo$getSearchHotWord$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(this);
    }
}
