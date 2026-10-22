package com.stepos.ability.calltool.handler;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.calltool.handler.JetpackAppFunctionsCallToolHandler", f = "JetpackAppFunctionsCallToolHandler.kt", l = {156}, m = "resolveMetadata", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class JetpackAppFunctionsCallToolHandler$resolveMetadata$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f3070a;
    public String b;
    public /* synthetic */ Object c;
    public final /* synthetic */ c d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JetpackAppFunctionsCallToolHandler$resolveMetadata$1(c cVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.d = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.e(null, null, null, this);
    }
}
