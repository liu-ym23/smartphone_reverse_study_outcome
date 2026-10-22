package com.stepos.ailauncher.agent.ability;

import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$ensureForegroundObserver$1", f = "RiskCardHandoffCoordinator.kt", l = {286}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class RiskCardHandoffCoordinator$ensureForegroundObserver$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "<unused var>", "", "", "LY8/t;", "<anonymous>", "(Ljava/lang/String;Ljava/util/Set;ZZLjava/lang/String;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$ensureForegroundObserver$1$1", f = "RiskCardHandoffCoordinator.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$ensureForegroundObserver$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.t<String, Set<? extends String>, Boolean, Boolean, String, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(6, interfaceC4014c);
        }

        public final Object f(String str, Set<String> set, boolean z10, boolean z11, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return new AnonymousClass1(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }

        @Override // p9.t
        public /* bridge */ /* synthetic */ Object m(String str, Set<? extends String> set, Boolean bool, Boolean bool2, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return f(str, set, bool.booleanValue(), bool2.booleanValue(), str2, interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LY8/t;", "<unused var>", "", "", "<anonymous>", "(VLjava/util/Set;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$ensureForegroundObserver$1$2", f = "RiskCardHandoffCoordinator.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$ensureForegroundObserver$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.q<Y8.t, Set<? extends String>, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Y8.t tVar, Set<String> set, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return new AnonymousClass2(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return Y8.t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        public static final a<T> INSTANCE = new a<>();

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(Y8.t tVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            RiskCardHandoffCoordinator.INSTANCE.y();
            return Y8.t.f7040a;
        }
    }

    public RiskCardHandoffCoordinator$ensureForegroundObserver$1(InterfaceC4014c<? super RiskCardHandoffCoordinator$ensureForegroundObserver$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RiskCardHandoffCoordinator$ensureForegroundObserver$1(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((RiskCardHandoffCoordinator$ensureForegroundObserver$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
            Xa.b bVarN = Xa.d.n(Xa.d.k(vVar.i(), vVar.g(), vVar.d(), vVar.e(), vVar.f(), new AnonymousClass1(null)), vVar.h(), new AnonymousClass2(null));
            Xa.c cVar = a.INSTANCE;
            this.label = 1;
            if (bVarN.collect(cVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
