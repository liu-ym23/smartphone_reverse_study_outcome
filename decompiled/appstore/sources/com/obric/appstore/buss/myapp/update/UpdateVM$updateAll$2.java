package com.obric.appstore.buss.myapp.update;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.appstore.buss.myapp.update.UpdateVM", f = "UpdateVM.kt", i = {0, 0, 0, 1, 1, 1}, l = {212, 217}, m = "updateAll", n = {"this", "runningTasksByPkg", "wifiOnly", "this", "runningTasksByPkg", "wifiOnly"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
public final class UpdateVM$updateAll$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateVM this$0;

    public UpdateVM$updateAll$2(UpdateVM r10, Continuation<? super UpdateVM$updateAll$2> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return UpdateVM.w(this.this$0, null, false, this);
    }
}
