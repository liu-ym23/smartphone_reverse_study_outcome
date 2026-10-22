package com.stepos.stepclaw.provider.handlers;

import a6.f0;
import b5.a0;
import d6.b;
import d6.z;
import f5.c;
import g5.a;
import h5.e;
import h5.i;
import kotlin.Metadata;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lcom/stepos/stepclaw/provider/backend/ConfigData;", "<anonymous>", "(La6/f0;)Lcom/stepos/stepclaw/provider/backend/ConfigData;"}, k = 3, mv = {2, 2, 0})
@e(c = "com.stepos.stepclaw.provider.handlers.ConfigModelHandler$query$config$1", f = "ConfigModelHandler.kt", l = {19}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class ConfigModelHandler$query$config$1 extends i implements p {
    int label;
    final /* synthetic */ ConfigModelHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigModelHandler$query$config$1(ConfigModelHandler configModelHandler, c cVar) {
        super(2, cVar);
        this.this$0 = configModelHandler;
    }

    @Override // h5.a
    public final c create(Object obj, c cVar) {
        return new ConfigModelHandler$query$config$1(this.this$0, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, c cVar) {
        return ((ConfigModelHandler$query$config$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        a aVar = a.f2984a;
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            return obj;
        }
        a.a.c0(obj);
        b configFlow = this.this$0.configStore.getConfigFlow();
        this.label = 1;
        Object objD = z.d(configFlow, this);
        return objD == aVar ? aVar : objD;
    }
}
