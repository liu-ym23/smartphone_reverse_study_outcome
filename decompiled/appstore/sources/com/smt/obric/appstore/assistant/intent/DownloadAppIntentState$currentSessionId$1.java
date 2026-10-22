package com.smt.obric.appstore.assistant.intent;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.assistant.intent.DownloadAppIntentState", f = "DownloadAppIntentImpl.kt", i = {0}, l = {436}, m = "currentSessionId", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class DownloadAppIntentState$currentSessionId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadAppIntentState this$0;

    public DownloadAppIntentState$currentSessionId$1(DownloadAppIntentState r10, Continuation<? super DownloadAppIntentState$currentSessionId$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
