package com.smt.obric.appstore.domain.sysapp;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.sysapp.GmsUtil", f = "GmsUtil.kt", i = {}, l = {17}, m = "getGmsServiceEnabled", n = {}, s = {})
public final class GmsUtil$getGmsServiceEnabled$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GmsUtil this$0;

    public GmsUtil$getGmsServiceEnabled$1(GmsUtil r10, Continuation<? super GmsUtil$getGmsServiceEnabled$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
