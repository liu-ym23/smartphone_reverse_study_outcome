package com.stepos.ailauncher.agent.aispace;

import La.H;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Z8.C1173v;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.agentbus.bff.ExternalAgent;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.connect.AddAgentBottomSheet;
import com.stepos.ailauncher.agent.aispace.connect.C2213k;
import com.stepos.ailauncher.agent.aispace.connect.C2215l;
import com.stepos.ailauncher.agent.aispace.connect.ConnectExternalAgentActivity;
import com.stepos.ailauncher.agent.aispace.connect.ConnectExternalAgentFragment;
import com.stepos.ailauncher.agent.aispace.connect.ConnectStepAgentActivity;
import com.stepos.ailauncher.agent.aispace.connect.ConnectStepAgentFragment;
import com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentActivity;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceGroup;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceItem;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceResponseData;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment;
import com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsActivity;
import com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsFragment;
import com.stepos.ailauncher.chat.activity.PolicySheetActivity;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0019\u001a\u00020\u00182\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00060\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u00020 2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020 2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b+\u0010*J\u0016\u0010-\u001a\u0004\u0018\u00010,*\u00020\u001bH\u0082\u0010¢\u0006\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/ExternalAgentUiServiceImpl;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentUiService;", "<init>", "()V", "Landroid/view/ViewGroup;", "host", "LY8/t;", "showAddAgentSheet", "(Landroid/view/ViewGroup;)V", "", "agentType", "", "isCrossDeviceAuthorized", "(Ljava/lang/String;)Z", "Lkotlin/Function0;", "onAuthorized", "showCrossDeviceAuthDialog", "(Landroid/view/ViewGroup;Ljava/lang/String;Lp9/a;)V", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentUiService$RemoteAgentEntry;", "getRemoteAgentEntries", "()Ljava/util/List;", "Lkotlin/Function1;", "onUpdated", "Lkotlinx/coroutines/g;", "refreshRemoteAgentEntries", "(Lp9/l;)Lkotlinx/coroutines/g;", "Landroid/content/Context;", "context", "connectRemoteAgent", "(Landroid/content/Context;Ljava/lang/String;)V", "displayName", "Landroidx/fragment/app/Fragment;", "createConnectFragment", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/fragment/app/Fragment;", "createConnectedAgentsFragment", "()Landroidx/fragment/app/Fragment;", "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "agent", "createAgentMarketDetailFragment", "(Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;)Landroidx/fragment/app/Fragment;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/app/Activity;", "f", "(Landroid/content/Context;)Landroid/app/Activity;", "LUa/M;", "scope", "LUa/M;", "stepaiType", "Ljava/lang/String;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExternalAgentUiServiceImpl implements IExternalAgentUiService {
    private final M scope = kotlinx.coroutines.d.a(Y.b().plus(L0.b(null, 1, null)));
    private final String stepaiType = ConnectedAgentsActivity.FILTER_STEPAI;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.ExternalAgentUiServiceImpl$refreshRemoteAgentEntries$1", f = "ExternalAgentUiServiceImpl.kt", l = {140, 142}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.ExternalAgentUiServiceImpl$refreshRemoteAgentEntries$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ InterfaceC5074l<List<IExternalAgentUiService.RemoteAgentEntry>, Y8.t> $onUpdated;
        Object L$0;
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.ExternalAgentUiServiceImpl$refreshRemoteAgentEntries$1$1", f = "ExternalAgentUiServiceImpl.kt", l = {}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.agent.aispace.ExternalAgentUiServiceImpl$refreshRemoteAgentEntries$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02571 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
            final /* synthetic */ List<IExternalAgentUiService.RemoteAgentEntry> $entries;
            final /* synthetic */ InterfaceC5074l<List<IExternalAgentUiService.RemoteAgentEntry>, Y8.t> $onUpdated;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C02571(InterfaceC5074l<? super List<IExternalAgentUiService.RemoteAgentEntry>, Y8.t> interfaceC5074l, List<IExternalAgentUiService.RemoteAgentEntry> list, InterfaceC4014c<? super C02571> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.$onUpdated = interfaceC5074l;
                this.$entries = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new C02571(this.$onUpdated, this.$entries, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((C02571) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                C4063a.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                this.$onUpdated.invoke(this.$entries);
                return Y8.t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super List<IExternalAgentUiService.RemoteAgentEntry>, Y8.t> interfaceC5074l, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onUpdated = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return ExternalAgentUiServiceImpl.this.new AnonymousClass1(this.$onUpdated, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
        
            if (Ua.C1056g.j(r1, r4, r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r6.label
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r6 = r6.L$0
                java.util.List r6 = (java.util.List) r6
                kotlin.C4849c.b(r7)
                goto L51
            L17:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1f:
                kotlin.C4849c.b(r7)
                goto L31
            L23:
                kotlin.C4849c.b(r7)
                com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache r7 = com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache.INSTANCE
                r6.label = r4
                java.lang.Object r7 = com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache.d(r7, r3, r6, r4, r3)
                if (r7 != r0) goto L31
                goto L50
            L31:
                com.stepos.ailauncher.agent.aispace.ExternalAgentUiServiceImpl r7 = com.stepos.ailauncher.agent.aispace.ExternalAgentUiServiceImpl.this
                java.util.List r7 = r7.getRemoteAgentEntries()
                Ua.A0 r1 = Ua.Y.c()
                com.stepos.ailauncher.agent.aispace.ExternalAgentUiServiceImpl$refreshRemoteAgentEntries$1$1 r4 = new com.stepos.ailauncher.agent.aispace.ExternalAgentUiServiceImpl$refreshRemoteAgentEntries$1$1
                p9.l<java.util.List<com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService$RemoteAgentEntry>, Y8.t> r5 = r6.$onUpdated
                r4.<init>(r5, r7, r3)
                java.lang.Object r7 = g9.h.a(r7)
                r6.L$0 = r7
                r6.label = r2
                java.lang.Object r6 = Ua.C1056g.j(r1, r4, r6)
                if (r6 != r0) goto L51
            L50:
                return r0
            L51:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.ExternalAgentUiServiceImpl.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Y8.t i(ExternalAgentUiServiceImpl externalAgentUiServiceImpl, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        externalAgentUiServiceImpl.h(context);
        return Y8.t.f7040a;
    }

    public static final Y8.t j(ExternalAgentUiServiceImpl externalAgentUiServiceImpl, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        externalAgentUiServiceImpl.g(context);
        return Y8.t.f7040a;
    }

    public static final Y8.t k(boolean z10, String str, ExternalAgentUiServiceImpl externalAgentUiServiceImpl, Context context) {
        String str2 = z10 ? "zlgnsq" : "gnsqsf";
        String strE1 = H.E1(str, 12298, 12299);
        kotlin.jvm.internal.p.f(context);
        Activity activityF = externalAgentUiServiceImpl.f(context);
        if (activityF != null) {
            com.stepos.ailauncher.chat.util.j.INSTANCE.f(activityF, str2, strE1);
        } else {
            PolicySheetActivity.INSTANCE.c(context, str2, strE1);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t l(boolean z10, InterfaceC5063a interfaceC5063a) {
        if (z10) {
            C2215l.INSTANCE.e();
        } else {
            C2215l.INSTANCE.d();
        }
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final Y8.t m() {
        return Y8.t.f7040a;
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService
    public void connectRemoteAgent(Context context, String agentType) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(agentType, "agentType");
        if (ExternalAgent.INSTANCE.b(agentType) == ExternalAgent.STEPAI) {
            h(context);
            return;
        }
        Intent intentB = ConnectExternalAgentActivity.Companion.b(ConnectExternalAgentActivity.INSTANCE, context, agentType, null, 4, null);
        intentB.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intentB);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService
    public Fragment createAgentMarketDetailFragment(MarketAgentBrief agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        return AgentMarketDetailFragment.INSTANCE.a(agent);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService
    public Fragment createConnectFragment(String agentType, String displayName) {
        kotlin.jvm.internal.p.i(agentType, "agentType");
        return ExternalAgent.INSTANCE.b(agentType) == ExternalAgent.STEPAI ? ConnectStepAgentFragment.INSTANCE.a(displayName) : ConnectExternalAgentFragment.INSTANCE.a(agentType, displayName);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService
    public Fragment createConnectedAgentsFragment() {
        return ConnectedAgentsFragment.INSTANCE.b();
    }

    public final Activity f(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
            kotlin.jvm.internal.p.h(context, "getBaseContext(...)");
        }
        return (Activity) context;
    }

    public final void g(Context context) {
        SelectExternalAgentActivity.INSTANCE.a(context, "sidebar_agent");
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService
    public List<IExternalAgentUiService.RemoteAgentEntry> getRemoteAgentEntries() {
        AgentEntranceResponseData agentEntranceResponseDataA = AgentEntranceCache.INSTANCE.a();
        if (agentEntranceResponseDataA == null) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        AgentEntranceGroup stepai = agentEntranceResponseDataA.getStepai();
        if (stepai != null) {
            if (H.x0(stepai.getTitle())) {
                stepai = null;
            }
            if (stepai != null) {
                arrayList.add(new IExternalAgentUiService.RemoteAgentEntry(this.stepaiType, stepai.getTitle(), stepai.getDescription(), x.INSTANCE.b(this.stepaiType)));
            }
        }
        AgentEntranceGroup otherAgents = agentEntranceResponseDataA.getOtherAgents();
        List<AgentEntranceItem> listA = otherAgents != null ? otherAgents.a() : null;
        if (listA == null) {
            listA = C1173v.m();
        }
        for (AgentEntranceItem agentEntranceItem : listA) {
            arrayList.add(new IExternalAgentUiService.RemoteAgentEntry(agentEntranceItem.getName(), agentEntranceItem.getTitle(), agentEntranceItem.getDescription(), x.INSTANCE.b(agentEntranceItem.getName())));
        }
        return arrayList;
    }

    public final void h(Context context) {
        Intent intent = new Intent(context, (Class<?>) ConnectStepAgentActivity.class);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intent);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService
    public boolean isCrossDeviceAuthorized(String agentType) {
        kotlin.jvm.internal.p.i(agentType, "agentType");
        return ExternalAgent.INSTANCE.b(agentType) == ExternalAgent.STEPAI ? C2215l.INSTANCE.b() : C2215l.INSTANCE.a();
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService
    public kotlinx.coroutines.g refreshRemoteAgentEntries(InterfaceC5074l<? super List<IExternalAgentUiService.RemoteAgentEntry>, Y8.t> onUpdated) {
        kotlin.jvm.internal.p.i(onUpdated, "onUpdated");
        return C1060i.d(this.scope, null, null, new AnonymousClass1(onUpdated, null), 3, null);
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService
    public void showAddAgentSheet(final ViewGroup host) {
        kotlin.jvm.internal.p.i(host, "host");
        AddAgentBottomSheet.INSTANCE.f(host, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.B
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ExternalAgentUiServiceImpl.i(this.f23903a, host);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.C
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ExternalAgentUiServiceImpl.j(this.f23905a, host);
            }
        });
    }

    @Override // com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService
    public void showCrossDeviceAuthDialog(ViewGroup host, String agentType, final InterfaceC5063a<Y8.t> onAuthorized) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(agentType, "agentType");
        kotlin.jvm.internal.p.i(onAuthorized, "onAuthorized");
        final Context context = host.getContext();
        final boolean z10 = ExternalAgent.INSTANCE.b(agentType) == ExternalAgent.STEPAI;
        final String string = context.getString(z10 ? R$string.agent_auth_stepai_protocol : R$string.agent_auth_external_protocol);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        C2213k c2213k = C2213k.INSTANCE;
        String string2 = context.getString(z10 ? R$string.agent_auth_stepai_title : R$string.agent_auth_external_title);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = context.getString(z10 ? R$string.agent_auth_stepai_content : R$string.agent_auth_external_content);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        c2213k.k(host, string2, string3, string, z10 ? W4.c.ENTRY_STEPAI : W4.c.ENTRY_REMOTE, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ExternalAgentUiServiceImpl.k(z10, string, this, context);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.z
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ExternalAgentUiServiceImpl.l(z10, onAuthorized);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.A
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ExternalAgentUiServiceImpl.m();
            }
        });
    }
}
