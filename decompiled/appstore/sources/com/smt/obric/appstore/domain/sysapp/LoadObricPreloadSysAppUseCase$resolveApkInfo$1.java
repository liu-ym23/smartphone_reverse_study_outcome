package com.smt.obric.appstore.domain.sysapp;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.LoadObricPreloadSysAppUseCase", f = "LoadObricPreloadSysAppUseCase.kt", i = {0, 0, 0, 0, 0}, l = {68}, m = "resolveApkInfo", n = {"apkFile", "$this$resolveApkInfo_u24lambda_u243", "packageInfo", "pm", "packageName"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class LoadObricPreloadSysAppUseCase$resolveApkInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadObricPreloadSysAppUseCase this$0;

    public LoadObricPreloadSysAppUseCase$resolveApkInfo$1(LoadObricPreloadSysAppUseCase r10, Continuation<? super LoadObricPreloadSysAppUseCase$resolveApkInfo$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return LoadObricPreloadSysAppUseCase.a(this.this$0, null, this);
    }
}
