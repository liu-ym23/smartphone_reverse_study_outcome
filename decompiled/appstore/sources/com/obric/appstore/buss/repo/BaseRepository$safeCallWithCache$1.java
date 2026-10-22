package com.obric.appstore.buss.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.repo.BaseRepository", f = "BaseRepository.kt", i = {0, 0}, l = {35, 38}, m = "safeCallWithCache", n = {"this", "call"}, s = {"L$0", "L$1"})
public final class BaseRepository$safeCallWithCache$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseRepository this$0;

    public BaseRepository$safeCallWithCache$1(BaseRepository r10, Continuation<? super BaseRepository$safeCallWithCache$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
