package com.stepos.ailauncher.agent.aispace.market;

import Ua.C1060i;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketOperaManager;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.agent.skill.opera.SkillOperaManager;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.model.StoreInstallActivity;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\r\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u000f*\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/StoreInstallActivityTracker;", "", "<init>", "()V", "", "", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "agents", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "skills", "", "f", "(Ljava/util/Map;Ljava/util/Map;)I", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/Map;)I", "", "l", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;)Z", "k", "LUa/M;", "scope", "LUa/M;", "LXa/k;", "Lcom/stepos/ailauncher/contract/model/StoreInstallActivity;", "_state", "LXa/k;", "LXa/t;", VoiceWakeupReceiver.EXTRA_STATE, "LXa/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()LXa/t;", "", "skillInstalling", "Ljava/util/Set;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StoreInstallActivityTracker {
    public static final StoreInstallActivityTracker INSTANCE = new StoreInstallActivityTracker();
    private static final Xa.k<StoreInstallActivity> _state;
    private static final Ua.M scope;
    private static Set<String> skillInstalling;
    private static final Xa.t<StoreInstallActivity> state;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.StoreInstallActivityTracker$1", f = "StoreInstallActivityTracker.kt", l = {60}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.StoreInstallActivityTracker$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.market.StoreInstallActivityTracker$1$a */
        public static final class a<T> implements Xa.c {
            public static final a<T> INSTANCE = new a<>();

            /* JADX WARN: Multi-variable type inference failed */
            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(AgentMarketOperaManager.a aVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                Object value;
                StoreInstallActivity storeInstallActivity;
                Object value2;
                StoreInstallActivity storeInstallActivity2;
                Object value3;
                StoreInstallActivity storeInstallActivity3;
                Object value4;
                StoreInstallActivity storeInstallActivity4;
                Object value5;
                StoreInstallActivity storeInstallActivity5;
                if (aVar instanceof AgentMarketOperaManager.a.InstallSucceeded) {
                    if (AgentMarketOperaManager.INSTANCE.D(((AgentMarketOperaManager.a.InstallSucceeded) aVar).getAssetId())) {
                        Xa.k kVar = StoreInstallActivityTracker._state;
                        do {
                            value5 = kVar.getValue();
                            storeInstallActivity5 = (StoreInstallActivity) value5;
                        } while (!kVar.d(value5, StoreInstallActivity.copy$default(storeInstallActivity5, 0, 0, 0, 0, storeInstallActivity5.getTestingAgentActivityCount() + 1, 15, null)));
                    } else {
                        Xa.k kVar2 = StoreInstallActivityTracker._state;
                        do {
                            value4 = kVar2.getValue();
                            storeInstallActivity4 = (StoreInstallActivity) value4;
                        } while (!kVar2.d(value4, StoreInstallActivity.copy$default(storeInstallActivity4, 0, storeInstallActivity4.getSucceededCount() + 1, storeInstallActivity4.getAgentListRevision() + 1, storeInstallActivity4.getAgentInstalledCount() + 1, 0, 17, null)));
                    }
                } else if (aVar instanceof AgentMarketOperaManager.a.UpdateSucceeded) {
                    if (AgentMarketOperaManager.INSTANCE.D(((AgentMarketOperaManager.a.UpdateSucceeded) aVar).getAssetId())) {
                        Xa.k kVar3 = StoreInstallActivityTracker._state;
                        do {
                            value3 = kVar3.getValue();
                            storeInstallActivity3 = (StoreInstallActivity) value3;
                        } while (!kVar3.d(value3, StoreInstallActivity.copy$default(storeInstallActivity3, 0, 0, 0, 0, storeInstallActivity3.getTestingAgentActivityCount() + 1, 15, null)));
                    } else {
                        Xa.k kVar4 = StoreInstallActivityTracker._state;
                        do {
                            value2 = kVar4.getValue();
                            storeInstallActivity2 = (StoreInstallActivity) value2;
                        } while (!kVar4.d(value2, StoreInstallActivity.copy$default(storeInstallActivity2, 0, storeInstallActivity2.getSucceededCount() + 1, storeInstallActivity2.getAgentListRevision() + 1, 0, 0, 25, null)));
                    }
                } else if (aVar instanceof AgentMarketOperaManager.a.UninstallSucceeded) {
                    Xa.k kVar5 = StoreInstallActivityTracker._state;
                    do {
                        value = kVar5.getValue();
                        storeInstallActivity = (StoreInstallActivity) value;
                    } while (!kVar5.d(value, StoreInstallActivity.copy$default(storeInstallActivity, 0, 0, storeInstallActivity.getAgentListRevision() + 1, 0, 0, 27, null)));
                }
                return Y8.t.f7040a;
            }
        }

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(interfaceC4014c);
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
                Xa.o<AgentMarketOperaManager.a> oVarU = AgentMarketOperaManager.INSTANCE.u();
                Xa.c<? super AgentMarketOperaManager.a> cVar = a.INSTANCE;
                this.label = 1;
                if (oVarU.collect(cVar, this) == objG) {
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
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.StoreInstallActivityTracker$2", f = "StoreInstallActivityTracker.kt", l = {97}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.StoreInstallActivityTracker$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0002H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "agents", "skills"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.StoreInstallActivityTracker$2$1", f = "StoreInstallActivityTracker.kt", l = {}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.agent.aispace.market.StoreInstallActivityTracker$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p9.q<Map<String, ? extends AgentMarketStatus>, Map<String, ? extends SkillItem>, InterfaceC4014c<? super Pair<? extends Map<String, ? extends AgentMarketStatus>, ? extends Map<String, ? extends SkillItem>>>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(3, interfaceC4014c);
            }

            @Override // p9.q
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Map<String, ? extends AgentMarketStatus> map, Map<String, SkillItem> map2, InterfaceC4014c<? super Pair<? extends Map<String, ? extends AgentMarketStatus>, ? extends Map<String, SkillItem>>> interfaceC4014c) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
                anonymousClass1.L$0 = map;
                anonymousClass1.L$1 = map2;
                return anonymousClass1.invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Map map = (Map) this.L$0;
                Map map2 = (Map) this.L$1;
                C4063a.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return Y8.j.a(map, map2);
            }
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.aispace.market.StoreInstallActivityTracker$2$a */
        public static final class a<T> implements Xa.c {
            public static final a<T> INSTANCE = new a<>();

            /* JADX WARN: Multi-variable type inference failed */
            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(Pair<? extends Map<String, ? extends AgentMarketStatus>, ? extends Map<String, SkillItem>> pair, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                Object value;
                StoreInstallActivity storeInstallActivity;
                Map<String, ? extends AgentMarketStatus> mapA = pair.a();
                Map<String, SkillItem> mapB = pair.b();
                StoreInstallActivityTracker storeInstallActivityTracker = StoreInstallActivityTracker.INSTANCE;
                int iG = storeInstallActivityTracker.g(mapB);
                int iF = storeInstallActivityTracker.f(mapA, mapB);
                Xa.k kVar = StoreInstallActivityTracker._state;
                do {
                    value = kVar.getValue();
                    storeInstallActivity = (StoreInstallActivity) value;
                } while (!kVar.d(value, StoreInstallActivity.copy$default(storeInstallActivity, iF, storeInstallActivity.getSucceededCount() + iG, 0, 0, 0, 28, null)));
                return Y8.t.f7040a;
            }
        }

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(interfaceC4014c);
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
                Xa.b bVarN = Xa.d.n(AgentMarketOperaManager.INSTANCE.w(), SkillOperaManager.INSTANCE.j(), new AnonymousClass1(null));
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

    static {
        Ua.M mA = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
        scope = mA;
        Xa.k<StoreInstallActivity> kVarA = Xa.u.a(new StoreInstallActivity(0, 0, 0, 0, 0, 31, null));
        _state = kVarA;
        state = Xa.d.c(kVarA);
        skillInstalling = Z8.Y.e();
        C1060i.d(mA, null, null, new AnonymousClass1(null), 3, null);
        C1060i.d(mA, null, null, new AnonymousClass2(null), 3, null);
    }

    public static final boolean h(Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return INSTANCE.l((SkillItem) it.getValue());
    }

    public static final String i(Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return (String) it.getKey();
    }

    public final int f(Map<String, ? extends AgentMarketStatus> agents, Map<String, SkillItem> skills) {
        int i10;
        int i11 = 0;
        if (agents.isEmpty()) {
            i10 = 0;
        } else {
            Iterator<Map.Entry<String, ? extends AgentMarketStatus>> it = agents.entrySet().iterator();
            i10 = 0;
            while (it.hasNext()) {
                AgentMarketStatus value = it.next().getValue();
                if (value == AgentMarketStatus.INSTALLING || value == AgentMarketStatus.QUEUED) {
                    i10++;
                }
            }
        }
        if (!skills.isEmpty()) {
            Iterator<Map.Entry<String, SkillItem>> it2 = skills.entrySet().iterator();
            while (it2.hasNext()) {
                if (INSTANCE.l(it2.next().getValue())) {
                    i11++;
                }
            }
        }
        return i10 + i11;
    }

    public final int g(Map<String, SkillItem> skills) {
        Set<String> setF0 = SequencesKt___SequencesKt.f0(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.F(Z8.T.D(skills), new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.S0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StoreInstallActivityTracker.h((Map.Entry) obj));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.market.T0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StoreInstallActivityTracker.i((Map.Entry) obj);
            }
        }));
        Set setM = Z8.Z.m(skillInstalling, setF0);
        skillInstalling = setF0;
        int i10 = 0;
        if (setM.isEmpty()) {
            return 0;
        }
        Set<String> set = setM;
        if ((set instanceof Collection) && set.isEmpty()) {
            return 0;
        }
        for (String str : set) {
            SkillItem skillItem = skills.get(str);
            if (skillItem != null && INSTANCE.k(skillItem) && !SkillOperaManager.INSTANCE.b0(str) && (i10 = i10 + 1) < 0) {
                C1173v.v();
            }
        }
        return i10;
    }

    public final Xa.t<StoreInstallActivity> j() {
        return state;
    }

    public final boolean k(SkillItem skillItem) {
        return skillItem.getStatus() == SkillStatus.INSTALLED_ENABLED || skillItem.getStatus() == SkillStatus.INSTALLED_DISABLED || skillItem.getStatus() == SkillStatus.INSTALLED || skillItem.getStatus() == SkillStatus.CONNECTED;
    }

    public final boolean l(SkillItem skillItem) {
        return skillItem.getStatus() == SkillStatus.INSTALLING || skillItem.getStatus() == SkillStatus.QUEUED;
    }
}
