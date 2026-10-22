package com.smt.obric.appstore.domain.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor", f = "AppInstallActor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {1136, 1172, 1173, 1182, 1184}, m = "restoreInstallTasks", n = {"this", "toInstall", "waitInstallRetry", "waitWiFiDownload", "this", "toInstall", "waitInstallRetry", "waitWiFiDownload", "task", "this", "toInstall", "waitInstallRetry", "waitWiFiDownload", "this", "toInstall", "waitInstallRetry", "waitWiFiDownload", "this", "toInstall", "waitInstallRetry", "waitWiFiDownload", "task"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$5"})
public final class AppInstallActor$restoreInstallTasks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppInstallActor this$0;

    public AppInstallActor$restoreInstallTasks$1(AppInstallActor r10, Continuation<? super AppInstallActor$restoreInstallTasks$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AppInstallActor.B(this.this$0, this);
    }
}
