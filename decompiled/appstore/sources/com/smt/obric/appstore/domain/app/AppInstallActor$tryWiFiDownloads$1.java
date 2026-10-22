package com.smt.obric.appstore.domain.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor", f = "AppInstallActor.kt", i = {}, l = {496}, m = "tryWiFiDownloads", n = {}, s = {})
public final class AppInstallActor$tryWiFiDownloads$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppInstallActor this$0;

    public AppInstallActor$tryWiFiDownloads$1(AppInstallActor r10, Continuation<? super AppInstallActor$tryWiFiDownloads$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AppInstallActor.G(this.this$0, this);
    }
}
