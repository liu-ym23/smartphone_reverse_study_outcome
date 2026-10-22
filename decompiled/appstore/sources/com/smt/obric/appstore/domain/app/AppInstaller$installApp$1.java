package com.smt.obric.appstore.domain.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstaller", f = "AppInstaller.kt", i = {0, 0, 1, 1, 2, 2}, l = {90, 102, 111, 127}, m = "installApp", n = {"this", "task", "this", "task", "this", "task"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class AppInstaller$installApp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppInstaller this$0;

    public AppInstaller$installApp$1(AppInstaller r10, Continuation<? super AppInstaller$installApp$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
