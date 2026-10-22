package com.smt.obric.appstore.domain.app;

import com.bytedanceos.common.ui.AppPermissionActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstaller", f = "AppInstaller.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "testHasActivePlaybackWithRetry", n = {"this", AppPermissionActivity.EXTRA_APP_PKG, "maxTryCnt", "retryInterval", "tried"}, s = {"L$0", "L$1", "I$0", "J$0", "I$1"})
public final class AppInstaller$testHasActivePlaybackWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppInstaller this$0;

    public AppInstaller$testHasActivePlaybackWithRetry$1(AppInstaller r10, Continuation<? super AppInstaller$testHasActivePlaybackWithRetry$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AppInstaller.c(this.this$0, null, 0, 0, this);
    }
}
