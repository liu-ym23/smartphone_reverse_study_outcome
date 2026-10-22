package com.stepos.ability.mcpserver.search;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.mcpserver.search.ToolSearchEngine", f = "ToolSearchEngine.kt", l = {41}, m = "rebuildIndex", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class ToolSearchEngine$rebuildIndex$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3195a;
    public final /* synthetic */ b b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolSearchEngine$rebuildIndex$1(b bVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.b = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3195a = obj;
        this.c |= Integer.MIN_VALUE;
        return b.a(this.b, this);
    }
}
