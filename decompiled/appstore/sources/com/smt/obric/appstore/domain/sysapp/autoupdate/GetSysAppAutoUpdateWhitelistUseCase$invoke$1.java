package com.smt.obric.appstore.domain.sysapp.autoupdate;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.autoupdate.GetSysAppAutoUpdateWhitelistUseCase", f = "GetSysAppAutoUpdateWhitelistUseCase.kt", i = {0}, l = {24}, m = "invoke", n = {"this"}, s = {"L$0"})
public final class GetSysAppAutoUpdateWhitelistUseCase$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetSysAppAutoUpdateWhitelistUseCase this$0;

    public GetSysAppAutoUpdateWhitelistUseCase$invoke$1(GetSysAppAutoUpdateWhitelistUseCase r10, Continuation<? super GetSysAppAutoUpdateWhitelistUseCase$invoke$1> r11) {
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
