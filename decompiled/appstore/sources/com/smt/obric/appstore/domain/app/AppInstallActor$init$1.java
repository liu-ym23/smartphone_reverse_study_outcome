package com.smt.obric.appstore.domain.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor", f = "AppInstallActor.kt", i = {0, 1}, l = {256, 258}, m = "init", n = {"this", "this"}, s = {"L$0", "L$0"})
public final class AppInstallActor$init$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppInstallActor this$0;

    public AppInstallActor$init$1(AppInstallActor r10, Continuation<? super AppInstallActor$init$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AppInstallActor.v(this.this$0, null, this);
    }
}
