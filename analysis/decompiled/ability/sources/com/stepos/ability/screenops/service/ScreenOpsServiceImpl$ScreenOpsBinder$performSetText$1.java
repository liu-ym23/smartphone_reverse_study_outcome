package com.stepos.ability.screenops.service;

import com.stepos.ability.screenops.service.ScreenOpsServiceImpl;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.screenops.service.ScreenOpsServiceImpl$ScreenOpsBinder", f = "ScreenOpsServiceImpl.kt", l = {137}, m = "performSetText", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenOpsServiceImpl$ScreenOpsBinder$performSetText$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3234a;
    public final /* synthetic */ ScreenOpsServiceImpl.ScreenOpsBinder b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenOpsServiceImpl$ScreenOpsBinder$performSetText$1(ScreenOpsServiceImpl.ScreenOpsBinder screenOpsBinder, H7.c cVar) {
        super(cVar);
        this.b = screenOpsBinder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3234a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.performSetText(null, null, this);
    }
}
