package com.stepos.agentbus.generated;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.d;
import m9.InterfaceC1733z;
import p9.j;

@c(c = "com.stepos.agentbus.generated.AgentBusBindingBase$writeFrame$out$1$2", f = "AgentBusBindingBase.kt", l = {592}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class AgentBusBindingBase$writeFrame$out$1$2 extends SuspendLambda implements n {
    final /* synthetic */ AgentBusBindingBase $this_run;
    int label;

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase$writeFrame$out$1$2$1", f = "AgentBusBindingBase.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$writeFrame$out$1$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(cVar);
            anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass1;
        }

        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (H7.c<? super Boolean>) obj2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z10 = this.Z$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return Boolean.valueOf(z10);
        }

        public final Object invoke(boolean z10, H7.c<? super Boolean> cVar) {
            return ((AnonymousClass1) create(Boolean.valueOf(z10), cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusBindingBase$writeFrame$out$1$2(AgentBusBindingBase agentBusBindingBase, H7.c<? super AgentBusBindingBase$writeFrame$out$1$2> cVar) {
        super(2, cVar);
        this.$this_run = agentBusBindingBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new AgentBusBindingBase$writeFrame$out$1$2(this.$this_run, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        j jVar = this.$this_run.connectedFlow;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
        this.label = 1;
        Object objI = d.i(jVar, anonymousClass1, this);
        return objI == coroutineSingletons ? coroutineSingletons : objI;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
        return ((AgentBusBindingBase$writeFrame$out$1$2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
