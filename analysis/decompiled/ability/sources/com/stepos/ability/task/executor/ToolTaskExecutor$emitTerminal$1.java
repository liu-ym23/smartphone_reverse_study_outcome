package com.stepos.ability.task.executor;

import android.os.Bundle;
import com.stepos.ability.bean.InternalTask;
import com.stepos.ability.beaninternal.ability.FunctionCallResult;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.task.executor.ToolTaskExecutor", f = "ToolTaskExecutor.kt", l = {730}, m = "emitTerminal", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class ToolTaskExecutor$emitTerminal$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public InternalTask f3296a;
    public FunctionCallResult b;
    public String c;
    public Bundle d;
    public kotlinx.coroutines.sync.a e;
    public /* synthetic */ Object f;
    public final /* synthetic */ g g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolTaskExecutor$emitTerminal$1(g gVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.g = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        return this.g.b(null, null, null, null, null, this);
    }
}
