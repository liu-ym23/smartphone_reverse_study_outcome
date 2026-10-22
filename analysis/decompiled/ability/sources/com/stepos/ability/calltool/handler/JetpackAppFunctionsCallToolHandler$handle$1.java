package com.stepos.ability.calltool.handler;

import com.stepos.ability.api.ability.calltool.CallToolRequest;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.calltool.handler.JetpackAppFunctionsCallToolHandler", f = "JetpackAppFunctionsCallToolHandler.kt", l = {72, 81}, m = "handle", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class JetpackAppFunctionsCallToolHandler$handle$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public CallToolRequest f3069a;
    public String b;
    public String c;
    public String d;
    public Object e;
    public String f;
    public /* synthetic */ Object g;
    public final /* synthetic */ c h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JetpackAppFunctionsCallToolHandler$handle$1(c cVar, H7.c cVar2) {
        super(cVar2);
        this.h = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= Integer.MIN_VALUE;
        return this.h.handle(null, null, this);
    }
}
