package com.obric.appstore.buss.search;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.search.SearchAppFragment$autoDownloadIfFirstExactMatch$2$3$1", f = "SearchAppFragment.kt", i = {0}, l = {235, 256}, m = "emit", n = {"this"}, s = {"L$0"})
public final class SearchAppFragment$autoDownloadIfFirstExactMatch$2$3$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SearchAppFragment$autoDownloadIfFirstExactMatch$2.AnonymousClass3.AnonymousClass1 this$0;

    public SearchAppFragment$autoDownloadIfFirstExactMatch$2$3$1$emit$1(SearchAppFragment$autoDownloadIfFirstExactMatch$2.AnonymousClass3.AnonymousClass1 r10, Continuation<? super SearchAppFragment$autoDownloadIfFirstExactMatch$2$3$1$emit$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
