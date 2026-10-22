package com.obric.appstore.assistant.intent;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.assistant.intent.DownloadAppIntentV2HandlerImpl", f = "DownloadAppIntentV2HandlerImpl.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {239, 244, 250, 260, 260}, m = "handleUpdateAll", n = {"this", "params", "context", "this", "params", "context", "this", "params", "context", "destination$iv$iv", "element$iv$iv", "this", "context", "destination$iv$iv", "element$iv$iv", "this", "context", "destination$iv$iv", "element$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$2", "L$4"})
public final class DownloadAppIntentV2HandlerImpl$handleUpdateAll$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadAppIntentV2HandlerImpl this$0;

    public DownloadAppIntentV2HandlerImpl$handleUpdateAll$1(DownloadAppIntentV2HandlerImpl r10, Continuation<? super DownloadAppIntentV2HandlerImpl$handleUpdateAll$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return DownloadAppIntentV2HandlerImpl.b(this.this$0, null, null, this);
    }
}
