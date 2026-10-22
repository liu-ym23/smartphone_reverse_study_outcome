package com.smt.obric.appstore.domain.app;

import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.app.AppInstallActor", f = "AppInstallActor.kt", i = {0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 7}, l = {1061, 1065, 1078, 1087, 1098, 1107, 1114, 1126}, m = "syncWithDownloader", n = {"this", "this", "timeout", "this", "allDownloads", "this", "allDownloads", "this", "toAdd", "appStatus", ServerElements.INFO, "this", "toAdd", "this", "toAdd", ServerElements.INFO, "this"}, s = {"L$0", "L$0", "J$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$3", "L$4", "L$0", "L$1", "L$0", "L$1", "L$3", "L$0"})
public final class AppInstallActor$syncWithDownloader$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppInstallActor this$0;

    public AppInstallActor$syncWithDownloader$1(AppInstallActor r10, Continuation<? super AppInstallActor$syncWithDownloader$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AppInstallActor.F(this.this$0, this);
    }
}
