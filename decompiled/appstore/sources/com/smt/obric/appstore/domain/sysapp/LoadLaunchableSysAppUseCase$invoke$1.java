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
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.LoadLaunchableSysAppUseCase", f = "LoadLaunchableSysAppUseCase.kt", i = {}, l = {24}, m = "invoke-IoAF18A", n = {}, s = {})
public final class LoadLaunchableSysAppUseCase$invoke$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadLaunchableSysAppUseCase this$0;

    public LoadLaunchableSysAppUseCase$invoke$1(LoadLaunchableSysAppUseCase r10, Continuation<? super LoadLaunchableSysAppUseCase$invoke$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        Object r11 = this.this$0.b(this);
        if (r11 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r11;
    L6:
        return Result.m34boximpl(r11);
    }
}
