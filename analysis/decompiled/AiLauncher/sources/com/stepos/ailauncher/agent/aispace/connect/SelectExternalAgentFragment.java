package com.stepos.ailauncher.agent.aispace.connect;

import Ua.C1060i;
import Y4.C1124h;
import Z8.C1173v;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LayoutInflater;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.RepeatOnLifecycleKt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.connect.ConnectExternalAgentFragment;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceGroup;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceItem;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceResponseData;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService;
import com.stepos.ailauncher.sheet.R$dimen;
import com.stepos.ailauncher.sheet.R$id;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0014\u0010'\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/SelectExternalAgentFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "K", "", "Lcom/stepos/ailauncher/agent/aispace/connect/data/i;", "agents", "H", "(Ljava/util/List;)V", "I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "LY4/h;", "_binding", "LY4/h;", "Lcom/stepos/ailauncher/agent/aispace/connect/n0;", "agentAdapter", "Lcom/stepos/ailauncher/agent/aispace/connect/n0;", "", "e", "()Z", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "J", "()LY4/h;", "binding", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SelectExternalAgentFragment extends com.stepos.ailauncher.sheet.nav.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "select_external_agent";
    private C1124h _binding;
    private final C2220n0 agentAdapter = new C2220n0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.connect.n1
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return SelectExternalAgentFragment.G(this.f24069a, (AgentEntranceItem) obj);
        }
    });

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/SelectExternalAgentFragment$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/agent/aispace/connect/SelectExternalAgentFragment;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/aispace/connect/SelectExternalAgentFragment;", "", "TAG", "Ljava/lang/String;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final SelectExternalAgentFragment a() {
            return new SelectExternalAgentFragment();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentFragment$onViewCreated$2", f = "SelectExternalAgentFragment.kt", l = {65}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentFragment$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentFragment$onViewCreated$2$1", f = "SelectExternalAgentFragment.kt", l = {66}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentFragment$onViewCreated$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
            int label;
            final /* synthetic */ SelectExternalAgentFragment this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentFragment$onViewCreated$2$1$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ SelectExternalAgentFragment this$0;

                public a(SelectExternalAgentFragment selectExternalAgentFragment) {
                    this.this$0 = selectExternalAgentFragment;
                }

                @Override // Xa.c
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(AgentEntranceResponseData agentEntranceResponseData, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    AgentEntranceGroup otherAgents;
                    SelectExternalAgentFragment selectExternalAgentFragment = this.this$0;
                    List<AgentEntranceItem> listA = (agentEntranceResponseData == null || (otherAgents = agentEntranceResponseData.getOtherAgents()) == null) ? null : otherAgents.a();
                    if (listA == null) {
                        listA = C1173v.m();
                    }
                    selectExternalAgentFragment.H(listA);
                    return Y8.t.f7040a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SelectExternalAgentFragment selectExternalAgentFragment, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = selectExternalAgentFragment;
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
                    Xa.t<AgentEntranceResponseData> tVarB = AgentEntranceCache.INSTANCE.b();
                    a aVar = new a(this.this$0);
                    this.label = 1;
                    if (tVarB.collect(aVar, this) == objG) {
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

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return SelectExternalAgentFragment.this.new AnonymousClass2(interfaceC4014c);
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
                LifecycleOwner viewLifecycleOwner = SelectExternalAgentFragment.this.getViewLifecycleOwner();
                kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(SelectExternalAgentFragment.this, null);
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

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentFragment$onViewCreated$3", f = "SelectExternalAgentFragment.kt", l = {71}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentFragment$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass3(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                AgentEntranceCache agentEntranceCache = AgentEntranceCache.INSTANCE;
                this.label = 1;
                if (AgentEntranceCache.d(agentEntranceCache, null, this, 1, null) == objG) {
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

    public static final Y8.t G(SelectExternalAgentFragment selectExternalAgentFragment, AgentEntranceItem item) {
        Fragment fragmentB;
        kotlin.jvm.internal.p.i(item, "item");
        IExternalAgentUiService iExternalAgentUiService = (IExternalAgentUiService) D5.a.INSTANCE.a(IExternalAgentUiService.class);
        if (iExternalAgentUiService == null || (fragmentB = IExternalAgentUiService.createConnectFragment$default(iExternalAgentUiService, item.getName(), null, 2, null)) == null) {
            fragmentB = ConnectExternalAgentFragment.Companion.b(ConnectExternalAgentFragment.INSTANCE, item.getName(), null, 2, null);
        }
        com.stepos.ailauncher.sheet.nav.a.z(selectExternalAgentFragment, fragmentB, item.getName(), null, null, null, 28, null);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(List<AgentEntranceItem> agents) {
        this.agentAdapter.g(agents);
    }

    private final void I() throws Resources.NotFoundException {
        J().b().setBackgroundColor(-15658735);
        J().b().setFitsSystemWindows(false);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        ImageButton btnBack = J().btnBack;
        kotlin.jvm.internal.p.h(btnBack, "btnBack");
        C2773b6.p(c2773b6, new View[]{btnBack}, null, false, 6, null);
        ImageButton imageButton = J().btnBack;
        imageButton.setBackgroundResource(R$drawable.bg_amoo_store_icon_btn);
        imageButton.setImageResource(R$drawable.ic_amoo_back);
        int dimensionPixelSize = imageButton.getResources().getDimensionPixelSize(R$dimen.ail_sheet_title_icon_padding);
        imageButton.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        imageButton.setImageTintList(null);
    }

    private final void K() {
        ViewGroup viewGroup;
        if (C2215l.INSTANCE.a() || (viewGroup = (ViewGroup) requireActivity().findViewById(R$id.ail_sheet_panel)) == null) {
            return;
        }
        final String string = getString(R$string.agent_auth_external_protocol);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        C2213k c2213k = C2213k.INSTANCE;
        String string2 = getString(R$string.agent_auth_external_title);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = getString(R$string.agent_auth_external_content);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        c2213k.k(viewGroup, string2, string3, string, W4.c.ENTRY_REMOTE, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.o1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SelectExternalAgentFragment.L(this.f24070a, string);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.p1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SelectExternalAgentFragment.M();
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.q1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SelectExternalAgentFragment.N(this.f24077a);
            }
        });
    }

    public static final Y8.t L(SelectExternalAgentFragment selectExternalAgentFragment, String str) {
        com.stepos.ailauncher.chat.util.j jVar = com.stepos.ailauncher.chat.util.j.INSTANCE;
        androidx.fragment.app.r rVarRequireActivity = selectExternalAgentFragment.requireActivity();
        kotlin.jvm.internal.p.h(rVarRequireActivity, "requireActivity(...)");
        jVar.f(rVarRequireActivity, "gnsqsf", La.H.E1(str, 12298, 12299));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t M() {
        C2215l.INSTANCE.d();
        return Y8.t.f7040a;
    }

    public static final Y8.t N(SelectExternalAgentFragment selectExternalAgentFragment) {
        if (!selectExternalAgentFragment.x()) {
            selectExternalAgentFragment.o();
        }
        return Y8.t.f7040a;
    }

    public static final void O(SelectExternalAgentFragment selectExternalAgentFragment, View view) {
        if (selectExternalAgentFragment.x()) {
            return;
        }
        selectExternalAgentFragment.o();
    }

    public final C1124h J() {
        C1124h c1124h = this._binding;
        kotlin.jvm.internal.p.f(c1124h);
        return c1124h;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(inflater, "inflater");
        this._binding = C1124h.d(inflater, container, false);
        LinearLayout linearLayoutB = J().b();
        kotlin.jvm.internal.p.h(linearLayoutB, "getRoot(...)");
        return linearLayoutB;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this._binding = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        AgentEntranceGroup otherAgents;
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        I();
        J().btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SelectExternalAgentFragment.O(this.f24068a, view2);
            }
        });
        J().rvAgents.setLayoutManager(new LinearLayoutManager(requireContext()));
        J().rvAgents.setAdapter(this.agentAdapter);
        AgentEntranceResponseData agentEntranceResponseDataA = AgentEntranceCache.INSTANCE.a();
        List<AgentEntranceItem> listA = (agentEntranceResponseDataA == null || (otherAgents = agentEntranceResponseDataA.getOtherAgents()) == null) ? null : otherAgents.a();
        if (listA == null) {
            listA = C1173v.m();
        }
        H(listA);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AnonymousClass2(null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner2), null, null, new AnonymousClass3(null), 3, null);
        K();
    }
}
