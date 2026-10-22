package com.stepos.ability.calltool.handler;

import com.stepos.ability.api.ability.calltool.CallToolRequest;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.calltool.handler.CloudCallToolHandler", f = "CloudCallToolHandler.kt", l = {34}, m = "handle", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class CloudCallToolHandler$handle$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public CallToolRequest f3067a;
    public String b;
    public String c;
    public /* synthetic */ Object d;
    public final /* synthetic */ b e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudCallToolHandler$handle$1(b bVar, H7.c cVar) {
        super(cVar);
        this.e = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.handle(null, null, this);
    }
}
