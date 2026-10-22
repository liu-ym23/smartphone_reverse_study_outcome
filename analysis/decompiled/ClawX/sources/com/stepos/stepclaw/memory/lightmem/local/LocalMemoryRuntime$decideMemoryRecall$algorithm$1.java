package com.stepos.stepclaw.memory.lightmem.local;

import a6.f0;
import b5.a0;
import f5.c;
import g5.a;
import h5.e;
import h5.i;
import kotlin.Metadata;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lv2/c;", "<anonymous>", "(La6/f0;)Lv2/c;"}, k = 3, mv = {2, 2, 0})
@e(c = "com.stepos.stepclaw.memory.lightmem.local.LocalMemoryRuntime$decideMemoryRecall$algorithm$1", f = "LocalMemoryRuntime.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class LocalMemoryRuntime$decideMemoryRecall$algorithm$1 extends i implements p {
    int label;
    final /* synthetic */ LocalMemoryRuntime this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalMemoryRuntime$decideMemoryRecall$algorithm$1(LocalMemoryRuntime localMemoryRuntime, c cVar) {
        super(2, cVar);
        this.this$0 = localMemoryRuntime;
    }

    @Override // h5.a
    public final c create(Object obj, c cVar) {
        return new LocalMemoryRuntime$decideMemoryRecall$algorithm$1(this.this$0, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, c cVar) {
        return ((LocalMemoryRuntime$decideMemoryRecall$algorithm$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        a aVar = a.f2984a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        a.a.c0(obj);
        return this.this$0.reloadMemoryAlgorithm();
    }
}
