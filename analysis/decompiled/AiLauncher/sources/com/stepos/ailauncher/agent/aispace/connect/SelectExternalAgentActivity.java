package com.stepos.ailauncher.agent.aispace.connect;

import Ua.C1060i;
import Y4.C1124h;
import Z8.C1173v;
import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.C1398p;
import android.view.Lifecycle;
import android.view.RepeatOnLifecycleKt;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceGroup;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceItem;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceResponseData;
import d.AbstractC3936b;
import d.InterfaceC3935a;
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

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/SelectExternalAgentActivity;", "Landroidx/appcompat/app/d;", "<init>", "()V", "LY8/t;", "B", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "Lcom/stepos/ailauncher/agent/aispace/connect/data/i;", "agents", "z", "(Ljava/util/List;)V", "LY4/h;", "binding", "LY4/h;", "", "entrySource", "Ljava/lang/String;", "Lcom/stepos/ailauncher/agent/aispace/connect/n0;", "agentAdapter", "Lcom/stepos/ailauncher/agent/aispace/connect/n0;", "Ld/b;", "Landroid/content/Intent;", "connectLauncher", "Ld/b;", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SelectExternalAgentActivity extends androidx.appcompat.app.d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_ENTRY_SOURCE = "extra_entry_source";
    private C1124h binding;
    private String entrySource = W4.c.SOURCE_UNCONNECTED;
    private final C2220n0 agentAdapter = new C2220n0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.connect.g1
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return SelectExternalAgentActivity.y(this.f24044a, (AgentEntranceItem) obj);
        }
    });
    private final AbstractC3936b<Intent> connectLauncher = registerForActivityResult(new e.e(), new InterfaceC3935a() { // from class: com.stepos.ailauncher.agent.aispace.connect.h1
        @Override // d.InterfaceC3935a
        public final void a(Object obj) {
            SelectExternalAgentActivity.A(this.f24045a, (ActivityResult) obj);
        }
    });

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/SelectExternalAgentActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "entrySource", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)V", "EXTRA_ENTRY_SOURCE", "Ljava/lang/String;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Context context, String entrySource) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(entrySource, "entrySource");
            Intent intent = new Intent(context, (Class<?>) SelectExternalAgentActivity.class);
            intent.addFlags(268468224);
            intent.putExtra(SelectExternalAgentActivity.EXTRA_ENTRY_SOURCE, entrySource);
            context.startActivity(intent);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentActivity$onCreate$2", f = "SelectExternalAgentActivity.kt", l = {70}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentActivity$onCreate$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentActivity$onCreate$2$1", f = "SelectExternalAgentActivity.kt", l = {71}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentActivity$onCreate$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
            int label;
            final /* synthetic */ SelectExternalAgentActivity this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentActivity$onCreate$2$1$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ SelectExternalAgentActivity this$0;

                public a(SelectExternalAgentActivity selectExternalAgentActivity) {
                    this.this$0 = selectExternalAgentActivity;
                }

                @Override // Xa.c
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(AgentEntranceResponseData agentEntranceResponseData, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    AgentEntranceGroup otherAgents;
                    SelectExternalAgentActivity selectExternalAgentActivity = this.this$0;
                    List<AgentEntranceItem> listA = (agentEntranceResponseData == null || (otherAgents = agentEntranceResponseData.getOtherAgents()) == null) ? null : otherAgents.a();
                    if (listA == null) {
                        listA = C1173v.m();
                    }
                    selectExternalAgentActivity.z(listA);
                    return Y8.t.f7040a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SelectExternalAgentActivity selectExternalAgentActivity, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = selectExternalAgentActivity;
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
            return SelectExternalAgentActivity.this.new AnonymousClass2(interfaceC4014c);
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
                SelectExternalAgentActivity selectExternalAgentActivity = SelectExternalAgentActivity.this;
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(selectExternalAgentActivity, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.b(selectExternalAgentActivity, state, anonymousClass1, this) == objG) {
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
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentActivity$onCreate$3", f = "SelectExternalAgentActivity.kt", l = {77}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.aispace.connect.SelectExternalAgentActivity$onCreate$3, reason: invalid class name */
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

    public static final void A(SelectExternalAgentActivity selectExternalAgentActivity, ActivityResult result) {
        kotlin.jvm.internal.p.i(result, "result");
        if (result.getResultCode() == -1) {
            selectExternalAgentActivity.finish();
        }
    }

    private final void B() {
        ViewGroup viewGroup;
        if (C2215l.INSTANCE.a() || (viewGroup = (ViewGroup) findViewById(R.id.content)) == null) {
            return;
        }
        final String string = getString(R$string.agent_auth_external_protocol);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        C2213k c2213k = C2213k.INSTANCE;
        String string2 = getString(R$string.agent_auth_external_title);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = getString(R$string.agent_auth_external_content);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        c2213k.k(viewGroup, string2, string3, string, W4.c.ENTRY_REMOTE, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.j1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SelectExternalAgentActivity.C(this.f24059a, string);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.k1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SelectExternalAgentActivity.D();
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.agent.aispace.connect.l1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SelectExternalAgentActivity.E(this.f24065a);
            }
        });
    }

    public static final Y8.t C(SelectExternalAgentActivity selectExternalAgentActivity, String str) {
        com.stepos.ailauncher.chat.util.j.INSTANCE.f(selectExternalAgentActivity, "gnsqsf", La.H.E1(str, 12298, 12299));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t D() {
        C2215l.INSTANCE.d();
        return Y8.t.f7040a;
    }

    public static final Y8.t E(SelectExternalAgentActivity selectExternalAgentActivity) {
        selectExternalAgentActivity.finish();
        return Y8.t.f7040a;
    }

    public static final void F(SelectExternalAgentActivity selectExternalAgentActivity, View view) {
        selectExternalAgentActivity.finish();
    }

    public static final Y8.t y(SelectExternalAgentActivity selectExternalAgentActivity, AgentEntranceItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        W4.c.INSTANCE.e(item.getName());
        selectExternalAgentActivity.connectLauncher.a(ConnectExternalAgentActivity.INSTANCE.a(selectExternalAgentActivity, item.getName(), selectExternalAgentActivity.entrySource));
        return Y8.t.f7040a;
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        AgentEntranceGroup otherAgents;
        super.onCreate(savedInstanceState);
        C1124h c1124hC = C1124h.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(c1124hC, "inflate(...)");
        this.binding = c1124hC;
        if (c1124hC == null) {
            kotlin.jvm.internal.p.A("binding");
            c1124hC = null;
        }
        setContentView(c1124hC.b());
        String stringExtra = getIntent().getStringExtra(EXTRA_ENTRY_SOURCE);
        if (stringExtra == null) {
            stringExtra = W4.c.SOURCE_UNCONNECTED;
        }
        this.entrySource = stringExtra;
        W4.c.INSTANCE.f();
        C1124h c1124h = this.binding;
        if (c1124h == null) {
            kotlin.jvm.internal.p.A("binding");
            c1124h = null;
        }
        c1124h.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectExternalAgentActivity.F(this.f24051a, view);
            }
        });
        C1124h c1124h2 = this.binding;
        if (c1124h2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1124h2 = null;
        }
        c1124h2.rvAgents.setLayoutManager(new LinearLayoutManager(this));
        C1124h c1124h3 = this.binding;
        if (c1124h3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1124h3 = null;
        }
        c1124h3.rvAgents.setAdapter(this.agentAdapter);
        AgentEntranceResponseData agentEntranceResponseDataA = AgentEntranceCache.INSTANCE.a();
        List<AgentEntranceItem> listA = (agentEntranceResponseDataA == null || (otherAgents = agentEntranceResponseDataA.getOtherAgents()) == null) ? null : otherAgents.a();
        if (listA == null) {
            listA = C1173v.m();
        }
        z(listA);
        C1060i.d(C1398p.a(this), null, null, new AnonymousClass2(null), 3, null);
        C1060i.d(C1398p.a(this), null, null, new AnonymousClass3(null), 3, null);
        B();
    }

    public final void z(List<AgentEntranceItem> agents) {
        this.agentAdapter.g(agents);
    }
}
