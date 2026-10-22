package com.stepos.ailauncher.agent.aispace.skill.feishu;

import android.view.Lifecycle;
import android.view.RepeatOnLifecycleKt;
import com.stepos.ailauncher.agent.aispace.skill.feishu.AbstractC2306b;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$observeNetworkFailure$1", f = "FeishuConnectActivity.kt", l = {223}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class FeishuConnectActivity$observeNetworkFailure$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ FeishuConnectActivity this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$observeNetworkFailure$1$1", f = "FeishuConnectActivity.kt", l = {224}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$observeNetworkFailure$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;
        final /* synthetic */ FeishuConnectActivity this$0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.FeishuConnectActivity$observeNetworkFailure$1$1$a */
        public static final class a<T> implements Xa.c {
            final /* synthetic */ FeishuConnectActivity this$0;

            public a(FeishuConnectActivity feishuConnectActivity) {
                this.this$0 = feishuConnectActivity;
            }

            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                if (!kotlin.jvm.internal.p.d(this.this$0.n0().getState(), AbstractC2306b.l.INSTANCE)) {
                    return Y8.t.f7040a;
                }
                AbstractC2306b abstractC2306b = this.this$0.lastRenderedState;
                AbstractC2306b.j jVar = AbstractC2306b.j.INSTANCE;
                if (kotlin.jvm.internal.p.d(abstractC2306b, jVar)) {
                    return Y8.t.f7040a;
                }
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                String str2 = String.format("%s failed offline while installing, render local network fail", Arrays.copyOf(new Object[]{str}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                C4148a.u("AILauncher-FeishuConn", str2, false, 4, null);
                this.this$0.S0(jVar);
                return Y8.t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FeishuConnectActivity feishuConnectActivity, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = feishuConnectActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                Xa.o<String> oVarE = com.stepos.ailauncher.agent.aispace.skill.feishu.net.j.INSTANCE.e();
                a aVar = new a(this.this$0);
                this.label = 1;
                if (oVarE.collect(aVar, this) == objG) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeishuConnectActivity$observeNetworkFailure$1(FeishuConnectActivity feishuConnectActivity, InterfaceC4014c<? super FeishuConnectActivity$observeNetworkFailure$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = feishuConnectActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new FeishuConnectActivity$observeNetworkFailure$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((FeishuConnectActivity$observeNetworkFailure$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            FeishuConnectActivity feishuConnectActivity = this.this$0;
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(feishuConnectActivity, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(feishuConnectActivity, state, anonymousClass1, this) == objG) {
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
