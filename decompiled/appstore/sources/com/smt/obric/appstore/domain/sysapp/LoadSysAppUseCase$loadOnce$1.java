package com.smt.obric.appstore.domain.sysapp;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.LoadSysAppUseCase", f = "LoadSysAppUseCase.kt", i = {0}, l = {62, 65}, m = "loadOnce-IoAF18A", n = {"this"}, s = {"L$0"})
public final class LoadSysAppUseCase$loadOnce$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadSysAppUseCase this$0;

    public LoadSysAppUseCase$loadOnce$1(LoadSysAppUseCase r10, Continuation<? super LoadSysAppUseCase$loadOnce$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        Object r11 = LoadSysAppUseCase.g(this.this$0, this);
        if (r11 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r11;
    L6:
        return Result.m34boximpl(r11);
    }
}
