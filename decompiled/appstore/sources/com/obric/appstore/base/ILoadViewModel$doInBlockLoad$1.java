package com.obric.appstore.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.base.ILoadViewModel", f = "LoadViewModel.kt", i = {0}, l = {121}, m = "doInBlockLoad", n = {"this"}, s = {"L$0"})
public final class ILoadViewModel$doInBlockLoad$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ILoadViewModel this$0;

    public ILoadViewModel$doInBlockLoad$1(ILoadViewModel r10, Continuation<? super ILoadViewModel$doInBlockLoad$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, this);
    }
}
