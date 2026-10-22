package com.stepos.ability.screenops.service;

import com.stepos.ability.screenops.service.ScreenOpsServiceImpl;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.screenops.service.ScreenOpsServiceImpl$ScreenOpsBinder", f = "ScreenOpsServiceImpl.kt", l = {205}, m = "performGetTextList", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenOpsServiceImpl$ScreenOpsBinder$performGetTextList$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f3233a;
    public /* synthetic */ Object b;
    public final /* synthetic */ ScreenOpsServiceImpl.ScreenOpsBinder c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenOpsServiceImpl$ScreenOpsBinder$performGetTextList$1(ScreenOpsServiceImpl.ScreenOpsBinder screenOpsBinder, H7.c cVar) {
        super(cVar);
        this.c = screenOpsBinder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.performGetTextList(null, this);
    }
}
