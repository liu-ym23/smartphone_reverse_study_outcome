package com.stepos.ability.task.executor;

import com.stepos.ability.bean.Task;
import com.stepos.ability.beaninternal.ability.AbilityMetaDataResult;
import com.stepos.ability.beaninternal.ability.AiActivityWidgetInfo;
import com.stepos.ability.commoninternal.AbilityType;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.task.executor.ToolTaskExecutor", f = "ToolTaskExecutor.kt", l = {482, 492, 498, 559}, m = "executeToolCall", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class ToolTaskExecutor$executeToolCall$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Long f3306a;
    public String b;
    public String c;
    public String d;
    public Long e;
    public String f;
    public Task g;
    public String h;
    public AbilityMetaDataResult i;

    /* renamed from: j, reason: collision with root package name */
    public AbilityType f3307j;
    public String k;
    public AiActivityWidgetInfo l;
    public boolean m;
    public int n;
    public /* synthetic */ Object o;
    public final /* synthetic */ g p;

    /* renamed from: q, reason: collision with root package name */
    public int f3308q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolTaskExecutor$executeToolCall$1(g gVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.p = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.o = obj;
        this.f3308q |= Integer.MIN_VALUE;
        return this.p.c(null, null, null, null, null, null, null, null, null, false, 0, this);
    }
}
