package com.bytedanceos.appstore.buss.network.cms;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.network.cms.CmsBaseRepository", f = "CmsBaseRepository.kt", i = {}, l = {24}, m = "safeCall", n = {}, s = {})
public final class CmsBaseRepository$safeCall$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CmsBaseRepository this$0;

    public CmsBaseRepository$safeCall$1(CmsBaseRepository r10, Continuation<? super CmsBaseRepository$safeCall$1> r11) {
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
