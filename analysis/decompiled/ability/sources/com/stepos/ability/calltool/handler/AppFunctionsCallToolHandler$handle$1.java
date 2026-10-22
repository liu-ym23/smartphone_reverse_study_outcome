package com.stepos.ability.calltool.handler;

import com.stepos.ability.api.ability.calltool.CallToolRequest;
import com.stepos.ability.appfunctions.DirectAppFunctions;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.calltool.handler.AppFunctionsCallToolHandler", f = "AppFunctionsCallToolHandler.kt", l = {59, 68}, m = "handle", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AppFunctionsCallToolHandler$handle$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public CallToolRequest f3064a;
    public String b;
    public String c;
    public String d;
    public Object e;
    public String f;
    public DirectAppFunctions.Entry g;
    public /* synthetic */ Object h;
    public final /* synthetic */ a i;

    /* renamed from: j, reason: collision with root package name */
    public int f3065j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFunctionsCallToolHandler$handle$1(a aVar, H7.c cVar) {
        super(cVar);
        this.i = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.h = obj;
        this.f3065j |= Integer.MIN_VALUE;
        return this.i.handle(null, null, this);
    }
}
