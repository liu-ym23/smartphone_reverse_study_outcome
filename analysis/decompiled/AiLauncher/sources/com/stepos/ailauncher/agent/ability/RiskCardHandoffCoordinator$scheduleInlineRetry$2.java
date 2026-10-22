package com.stepos.ailauncher.agent.ability;

import Ua.M;
import Ua.U;
import com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator;
import com.stepos.ailauncher.chat.risk.RiskInlineHostPolicy;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator$scheduleInlineRetry$2", f = "RiskCardHandoffCoordinator.kt", l = {555}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class RiskCardHandoffCoordinator$scheduleInlineRetry$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ RiskCardHandoffCoordinator.a $active;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RiskInlineHostPolicy.RetryTick.values().length];
            try {
                iArr[RiskInlineHostPolicy.RetryTick.SwitchToInline.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RiskInlineHostPolicy.RetryTick.KeepRetrying.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RiskInlineHostPolicy.RetryTick.Stop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RiskCardHandoffCoordinator$scheduleInlineRetry$2(RiskCardHandoffCoordinator.a aVar, InterfaceC4014c<? super RiskCardHandoffCoordinator$scheduleInlineRetry$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$active = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RiskCardHandoffCoordinator$scheduleInlineRetry$2(this.$active, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((RiskCardHandoffCoordinator$scheduleInlineRetry$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        RiskCardHandoffCoordinator.a aVar;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            this.label = 1;
            if (U.a(250L, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        RiskCardHandoffCoordinator.a aVar2 = (RiskCardHandoffCoordinator.a) RiskCardHandoffCoordinator.actives.get(this.$active.getParams().getRequestId());
        if (aVar2 != null && aVar2 == (aVar = this.$active)) {
            RiskCardHandoffCoordinator riskCardHandoffCoordinator = RiskCardHandoffCoordinator.INSTANCE;
            int i11 = a.$EnumSwitchMapping$0[riskCardHandoffCoordinator.w(aVar).ordinal()];
            if (i11 == 1) {
                riskCardHandoffCoordinator.V(this.$active);
            } else if (i11 == 2) {
                riskCardHandoffCoordinator.K(this.$active);
            } else {
                if (i11 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                this.$active.k(0);
            }
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }
}
