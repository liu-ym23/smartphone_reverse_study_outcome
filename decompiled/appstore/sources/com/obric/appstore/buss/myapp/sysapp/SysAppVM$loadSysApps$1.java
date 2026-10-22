package com.obric.appstore.buss.myapp.sysapp;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.myapp.sysapp.SysAppVM", f = "SysAppVM.kt", i = {}, l = {36}, m = "loadSysApps", n = {}, s = {})
public final class SysAppVM$loadSysApps$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SysAppVM this$0;

    public SysAppVM$loadSysApps$1(SysAppVM r10, Continuation<? super SysAppVM$loadSysApps$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return SysAppVM.v(this.this$0, this);
    }
}
