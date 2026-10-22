package com.stepos.ailauncher.agent.skill.essential;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.essential.SkillEssentialViewModel$startPollingSubscription$2", f = "SkillEssentialViewModel.kt", l = {213}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillEssentialViewModel$startPollingSubscription$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ X4.a $service;
    int label;
    final /* synthetic */ SkillEssentialViewModel this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ SkillEssentialViewModel this$0;

        public a(SkillEssentialViewModel skillEssentialViewModel) {
            this.this$0 = skillEssentialViewModel;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(Set<String> set, InterfaceC4014c<? super t> interfaceC4014c) {
            this.this$0.v(set);
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillEssentialViewModel$startPollingSubscription$2(X4.a aVar, SkillEssentialViewModel skillEssentialViewModel, InterfaceC4014c<? super SkillEssentialViewModel$startPollingSubscription$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$service = aVar;
        this.this$0 = skillEssentialViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SkillEssentialViewModel$startPollingSubscription$2(this.$service, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SkillEssentialViewModel$startPollingSubscription$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.t<Set<String>> tVarL = this.$service.l();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (tVarL.collect(aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
