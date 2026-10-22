package com.obric.appstore.buss.rank;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.rank.RankVM", f = "RankFragment.kt", i = {0, 0, 1}, l = {89, 111, 92}, m = "doLoad", n = {"minDuration$iv", "start$iv$iv", "resp$iv"}, s = {"J$0", "J$1", "L$0"})
public final class RankVM$doLoad$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RankVM this$0;

    public RankVM$doLoad$1(RankVM r10, Continuation<? super RankVM$doLoad$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, this);
    }
}
