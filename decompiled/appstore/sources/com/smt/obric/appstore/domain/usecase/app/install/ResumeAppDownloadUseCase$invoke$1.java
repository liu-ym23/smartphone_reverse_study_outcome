package com.smt.obric.appstore.domain.usecase.app.install;

import com.bytedanceos.common.ui.AppPermissionActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.usecase.app.install.ResumeAppDownloadUseCase", f = "ResumeAppDownloadUseCase.kt", i = {0, 0, 0, 1, 1}, l = {13, 17}, m = "invoke", n = {AppPermissionActivity.EXTRA_APP_PKG, "ack", "wifiOnly", AppPermissionActivity.EXTRA_APP_PKG, "wifiOnly"}, s = {"L$0", "L$1", "Z$0", "L$0", "Z$0"})
public final class ResumeAppDownloadUseCase$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResumeAppDownloadUseCase this$0;

    public ResumeAppDownloadUseCase$invoke$1(ResumeAppDownloadUseCase r10, Continuation<? super ResumeAppDownloadUseCase$invoke$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, false, this);
    }
}
