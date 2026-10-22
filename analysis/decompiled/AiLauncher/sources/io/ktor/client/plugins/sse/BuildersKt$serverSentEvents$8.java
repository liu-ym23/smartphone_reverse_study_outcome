package io.ktor.client.plugins.sse;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "io.ktor.client.plugins.sse.BuildersKt", f = "builders.kt", l = {700, 708}, m = "serverSentEvents-Mswn-_c")
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BuildersKt$serverSentEvents$8 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;

    public BuildersKt$serverSentEvents$8(InterfaceC4014c<? super BuildersKt$serverSentEvents$8> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BuildersKt.m92serverSentEventsMswn_c(null, null, null, null, null, null, null, this);
    }
}
