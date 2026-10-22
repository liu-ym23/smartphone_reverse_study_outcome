package com.smt.obric.appstore.domain.oapplet;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.smt.obric.appstore.domain.oapplet.InstalledOApplets", f = "InstalledOApplet.kt", i = {}, l = {67}, m = "refresh", n = {}, s = {})
public final class InstalledOApplets$refresh$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InstalledOApplets this$0;

    public InstalledOApplets$refresh$1(InstalledOApplets r10, Continuation<? super InstalledOApplets$refresh$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return InstalledOApplets.c(this.this$0, this);
    }
}
