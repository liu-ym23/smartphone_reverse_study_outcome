package com.smt.obric.appstore.domain.oapplet;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.oapplet.OAppletUtil", f = "OAppletUtil.kt", i = {}, l = {138}, m = "installOApplet-0E7RQCE", n = {}, s = {})
public final class OAppletUtil$installOApplet$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OAppletUtil this$0;

    public OAppletUtil$installOApplet$1(OAppletUtil r10, Continuation<? super OAppletUtil$installOApplet$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        Object r11 = this.this$0.f(null, null, this);
        if (r11 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r11;
    L6:
        return Result.m34boximpl(r11);
    }
}
