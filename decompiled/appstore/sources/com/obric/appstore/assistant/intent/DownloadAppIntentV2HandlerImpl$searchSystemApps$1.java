package com.obric.appstore.assistant.intent;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.assistant.intent.DownloadAppIntentV2HandlerImpl", f = "DownloadAppIntentV2HandlerImpl.kt", i = {0, 0}, l = {287}, m = "searchSystemApps", n = {"appName", "context"}, s = {"L$0", "L$1"})
public final class DownloadAppIntentV2HandlerImpl$searchSystemApps$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadAppIntentV2HandlerImpl this$0;

    public DownloadAppIntentV2HandlerImpl$searchSystemApps$1(DownloadAppIntentV2HandlerImpl r10, Continuation<? super DownloadAppIntentV2HandlerImpl$searchSystemApps$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return DownloadAppIntentV2HandlerImpl.e(this.this$0, null, null, this);
    }
}
