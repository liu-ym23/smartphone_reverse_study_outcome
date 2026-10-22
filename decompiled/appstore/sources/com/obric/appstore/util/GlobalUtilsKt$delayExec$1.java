package com.obric.appstore.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "com.obric.appstore.util.GlobalUtilsKt", f = "GlobalUtils.kt", i = {0}, l = {36}, m = "delayExec", n = {"resp"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nGlobalUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlobalUtils.kt\ncom/obric/appstore/util/GlobalUtilsKt$delayExec$1\n*L\n1#1,123:1\n*E\n"})
public final class GlobalUtilsKt$delayExec$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public GlobalUtilsKt$delayExec$1(Continuation<? super GlobalUtilsKt$delayExec$1> r10) {
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return GlobalUtilsKt.a(0, null, this);
    }
}
