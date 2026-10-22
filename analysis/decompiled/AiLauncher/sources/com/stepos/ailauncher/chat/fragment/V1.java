package com.stepos.ailauncher.chat.fragment;

import Z8.C1173v;
import android.os.Bundle;
import android.view.LifecycleOwner;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService;
import com.stepos.ailauncher.sheet.R$id;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u0003J%\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/V1;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "G", "()Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "onResume", Parameters.ROOT, "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentUiService$RemoteAgentEntry;", "entries", "F", "(Landroid/view/View;Ljava/util/List;)V", "Lcom/stepos/ailauncher/chat/adapter/I;", "adapter", "Lcom/stepos/ailauncher/chat/adapter/I;", "Lkotlinx/coroutines/g;", "refreshJob", "Lkotlinx/coroutines/g;", "", "e", "()Z", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class V1 extends com.stepos.ailauncher.sheet.nav.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "connect_remote_agent";
    private final com.stepos.ailauncher.chat.adapter.I adapter;
    private kotlinx.coroutines.g refreshJob;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/V1$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/fragment/V1;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/fragment/V1;", "", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.V1$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final V1 a() {
            return new V1();
        }

        public Companion() {
        }
    }

    public V1() {
        super(R$layout.fragment_connect_remote_agent);
        this.adapter = new com.stepos.ailauncher.chat.adapter.I(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.U1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return V1.E(this.f25220a, (IExternalAgentUiService.RemoteAgentEntry) obj);
            }
        });
    }

    public static final Y8.t E(V1 v12, IExternalAgentUiService.RemoteAgentEntry entry) {
        Fragment fragmentCreateConnectFragment;
        kotlin.jvm.internal.p.i(entry, "entry");
        IExternalAgentUiService iExternalAgentUiService = (IExternalAgentUiService) D5.a.INSTANCE.a(IExternalAgentUiService.class);
        if (iExternalAgentUiService != null && (fragmentCreateConnectFragment = iExternalAgentUiService.createConnectFragment(entry.getAgentType(), entry.getTitle())) != null) {
            com.stepos.ailauncher.sheet.nav.a.z(v12, fragmentCreateConnectFragment, entry.getAgentType(), null, null, null, 28, null);
        }
        return Y8.t.f7040a;
    }

    private final View G() {
        androidx.fragment.app.r activity = getActivity();
        if (activity != null) {
            return activity.findViewById(R$id.ail_settle_hint);
        }
        return null;
    }

    public static final Y8.t H(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final void I(V1 v12, View view) {
        if (v12.x()) {
            return;
        }
        v12.o();
    }

    public static final Y8.t J(View view, V1 v12, List entries) {
        kotlin.jvm.internal.p.i(entries, "entries");
        if (view != null) {
            v12.F(view, entries);
        }
        return Y8.t.f7040a;
    }

    public final void F(View root, List<IExternalAgentUiService.RemoteAgentEntry> entries) {
        this.adapter.g(entries);
        root.findViewById(com.stepos.ailauncher.chat.R$id.rvRemoteAgents).setVisibility(entries.isEmpty() ? 8 : 0);
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
    public void onDestroyView() {
        kotlinx.coroutines.g gVar = this.refreshJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.refreshJob = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            Result.Companion companion = Result.INSTANCE;
            View viewG = G();
            if (viewG != null) {
                viewG.setVisibility(8);
            }
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        com.stepos.ailauncher.container.glass.k.b(view, 0, 1, null);
        View viewFindViewById = view.findViewById(com.stepos.ailauncher.chat.R$id.btnConnBack);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        kotlin.jvm.internal.p.f(viewFindViewById);
        C2773b6 c2773b6P = C2773b6.p(c2773b6, new View[]{viewFindViewById}, null, false, 6, null);
        View viewFindViewById2 = view.findViewById(com.stepos.ailauncher.chat.R$id.topChromeBlur);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        C2773b6.j(c2773b6P, new View[]{viewFindViewById2}, G.a.f43886a.g(), null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.R1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return V1.H((A7.B) obj);
            }
        }, 4, null);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.S1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                V1.I(this.f25212a, view2);
            }
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(com.stepos.ailauncher.chat.R$id.rvRemoteAgents);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.adapter);
        IExternalAgentUiService iExternalAgentUiService = (IExternalAgentUiService) D5.a.INSTANCE.a(IExternalAgentUiService.class);
        List<IExternalAgentUiService.RemoteAgentEntry> remoteAgentEntries = iExternalAgentUiService != null ? iExternalAgentUiService.getRemoteAgentEntries() : null;
        if (remoteAgentEntries == null) {
            remoteAgentEntries = C1173v.m();
        }
        F(view, remoteAgentEntries);
        this.refreshJob = iExternalAgentUiService != null ? iExternalAgentUiService.refreshRemoteAgentEntries(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.T1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return V1.J(view, this, (List) obj);
            }
        }) : null;
    }
}
