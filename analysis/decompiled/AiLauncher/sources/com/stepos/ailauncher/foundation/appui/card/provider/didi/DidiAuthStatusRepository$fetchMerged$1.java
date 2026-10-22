package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository", f = "DidiAuthStatusRepository.kt", l = {397, 360, 407, 407}, m = "fetchMerged", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DidiAuthStatusRepository$fetchMerged$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DidiAuthStatusRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DidiAuthStatusRepository$fetchMerged$1(DidiAuthStatusRepository didiAuthStatusRepository, InterfaceC4014c<? super DidiAuthStatusRepository$fetchMerged$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = didiAuthStatusRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.r(null, null, null, 0L, this);
    }
}
