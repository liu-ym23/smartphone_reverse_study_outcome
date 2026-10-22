package com.stepos.ailauncher.agent.aispace.market;

import Ua.C1060i;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.RepeatOnLifecycleKt;
import com.stepos.ailauncher.agent.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$observeStatus$1", f = "AgentMarketDetailFragment.kt", l = {282}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketDetailFragment$observeStatus$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ AgentMarketDetailFragment this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$observeStatus$1$1", f = "AgentMarketDetailFragment.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$observeStatus$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AgentMarketDetailFragment this$0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$observeStatus$1$1$1", f = "AgentMarketDetailFragment.kt", l = {284}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$observeStatus$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02591 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
            int label;
            final /* synthetic */ AgentMarketDetailFragment this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$observeStatus$1$1$1$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ AgentMarketDetailFragment this$0;

                public a(AgentMarketDetailFragment agentMarketDetailFragment) {
                    this.this$0 = agentMarketDetailFragment;
                }

                @Override // Xa.c
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(Map<String, ? extends AgentMarketStatus> map, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    if (!this.this$0.isHidden()) {
                        AgentMarketDetailFragment agentMarketDetailFragment = this.this$0;
                        AgentMarketItem agentMarketItem = agentMarketDetailFragment.item;
                        AgentMarketItem agentMarketItem2 = null;
                        if (agentMarketItem == null) {
                            kotlin.jvm.internal.p.A("item");
                            agentMarketItem = null;
                        }
                        AgentMarketStatus initialStatus = map.get(agentMarketItem.getAssetId());
                        if (initialStatus == null) {
                            AgentMarketItem agentMarketItem3 = this.this$0.item;
                            if (agentMarketItem3 == null) {
                                kotlin.jvm.internal.p.A("item");
                            } else {
                                agentMarketItem2 = agentMarketItem3;
                            }
                            initialStatus = agentMarketItem2.getInitialStatus();
                        }
                        agentMarketDetailFragment.y0(initialStatus);
                    }
                    return Y8.t.f7040a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02591(AgentMarketDetailFragment agentMarketDetailFragment, InterfaceC4014c<? super C02591> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = agentMarketDetailFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new C02591(this.this$0, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((C02591) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    Xa.t<Map<String, AgentMarketStatus>> tVarW = AgentMarketOperaManager.INSTANCE.w();
                    a aVar = new a(this.this$0);
                    this.label = 1;
                    if (tVarW.collect(aVar, this) == objG) {
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

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$observeStatus$1$1$2", f = "AgentMarketDetailFragment.kt", l = {289}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$observeStatus$1$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
            int label;
            final /* synthetic */ AgentMarketDetailFragment this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$observeStatus$1$1$2$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ AgentMarketDetailFragment this$0;

                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$observeStatus$1$1$2$a$a, reason: collision with other inner class name */
                public static final /* synthetic */ class C0260a {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[AgentMarketStatus.values().length];
                        try {
                            iArr[AgentMarketStatus.INSTALLING.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[AgentMarketStatus.QUEUED.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[AgentMarketStatus.UPDATING.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                public a(AgentMarketDetailFragment agentMarketDetailFragment) {
                    this.this$0 = agentMarketDetailFragment;
                }

                @Override // Xa.c
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(Map<String, Integer> map, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    if (this.this$0.isHidden()) {
                        return Y8.t.f7040a;
                    }
                    AgentMarketOperaManager agentMarketOperaManager = AgentMarketOperaManager.INSTANCE;
                    AgentMarketItem agentMarketItem = this.this$0.item;
                    AgentMarketItem agentMarketItem2 = null;
                    if (agentMarketItem == null) {
                        kotlin.jvm.internal.p.A("item");
                        agentMarketItem = null;
                    }
                    String assetId = agentMarketItem.getAssetId();
                    AgentMarketItem agentMarketItem3 = this.this$0.item;
                    if (agentMarketItem3 == null) {
                        kotlin.jvm.internal.p.A("item");
                        agentMarketItem3 = null;
                    }
                    int i10 = C0260a.$EnumSwitchMapping$0[agentMarketOperaManager.Q(assetId, agentMarketItem3.getInitialStatus()).ordinal()];
                    Integer numF = (i10 == 1 || i10 == 2) ? C4109a.f(R$string.agent_detail_installing_percent) : i10 != 3 ? null : C4109a.f(R$string.agent_detail_updating_percent);
                    if (numF != null) {
                        AgentMarketItem agentMarketItem4 = this.this$0.item;
                        if (agentMarketItem4 == null) {
                            kotlin.jvm.internal.p.A("item");
                        } else {
                            agentMarketItem2 = agentMarketItem4;
                        }
                        Integer num = map.get(agentMarketItem2.getAssetId());
                        int iIntValue = num != null ? num.intValue() : 0;
                        this.this$0.W0().btnBottom.setText(this.this$0.getString(numF.intValue(), C4109a.f(iIntValue)));
                        this.this$0.s1(iIntValue);
                        this.this$0.W0().btnBottom.setProgressFraction(iIntValue / 100.0f);
                    }
                    return Y8.t.f7040a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(AgentMarketDetailFragment agentMarketDetailFragment, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = agentMarketDetailFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass2(this.this$0, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    Xa.t<Map<String, Integer>> tVarV = AgentMarketOperaManager.INSTANCE.v();
                    a aVar = new a(this.this$0);
                    this.label = 1;
                    if (tVarV.collect(aVar, this) == objG) {
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
        public AnonymousClass1(AgentMarketDetailFragment agentMarketDetailFragment, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = agentMarketDetailFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ua.M m10 = (Ua.M) this.L$0;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            C1060i.d(m10, null, null, new C02591(this.this$0, null), 3, null);
            C1060i.d(m10, null, null, new AnonymousClass2(this.this$0, null), 3, null);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketDetailFragment$observeStatus$1(AgentMarketDetailFragment agentMarketDetailFragment, InterfaceC4014c<? super AgentMarketDetailFragment$observeStatus$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentMarketDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketDetailFragment$observeStatus$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketDetailFragment$observeStatus$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Lifecycle.State state = Lifecycle.State.RESUMED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(viewLifecycleOwner, state, anonymousClass1, this) == objG) {
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
