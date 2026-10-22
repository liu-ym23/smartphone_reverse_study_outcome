package com.stepos.ailauncher.chat.fragment;

import Ua.C1060i;
import Z8.C1174w;
import android.content.Context;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.view.C2796d7;
import com.stepos.ailauncher.chat.view.PagedListController;
import com.stepos.ailauncher.chat.view.Z8;
import com.stepos.ailauncher.contract.api.skill.ISkillUiService;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;
import v9.C5685n;
import y7.G;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u001b\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0003R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooSkillListFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "X", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "P", "(Landroid/view/View;)V", "O", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "item", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)V", "N", "Y", "", "", "Lcom/stepos/ailauncher/contract/api/skill/ISkillUiService$SkillUiStatus;", "M", "()Ljava/util/Map;", ExifInterface.LONGITUDE_WEST, "Lcom/stepos/ailauncher/chat/view/PagedListController;", "pages", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "Lkotlinx/coroutines/g;", "actionStateJob", "Lkotlinx/coroutines/g;", "Lcom/stepos/ailauncher/chat/adapter/h0;", "adapter", "Lcom/stepos/ailauncher/chat/adapter/h0;", "", "e", "()Z", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooSkillListFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_NECESSARY = "necessary";
    private static final String ARG_PREVIEW_KEY = "preview_key";
    private static final String ARG_SHOW_CLI = "show_cli";
    private static final String ARG_TESTING = "testing";
    private static final String ARG_TITLE = "title";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long FULL_LOAD_DEFER_MS = 420;
    private kotlinx.coroutines.g actionStateJob;
    private final com.stepos.ailauncher.chat.adapter.h0 adapter;
    private PagedListController<SkillItemBrief> pages;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooSkillListFragment$a;", "", "<init>", "()V", "", "title", "", AmooSkillListFragment.ARG_NECESSARY, "", "showCli", AmooSkillListFragment.ARG_TESTING, "", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "preview", "Lcom/stepos/ailauncher/chat/fragment/AmooSkillListFragment;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;IZZLjava/util/List;)Lcom/stepos/ailauncher/chat/fragment/AmooSkillListFragment;", "ARG_TITLE", "Ljava/lang/String;", "ARG_NECESSARY", "ARG_SHOW_CLI", "ARG_TESTING", "ARG_PREVIEW_KEY", "", "FULL_LOAD_DEFER_MS", "J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.AmooSkillListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ AmooSkillListFragment b(Companion companion, String str, int i10, boolean z10, boolean z11, List list, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                z11 = false;
            }
            boolean z12 = z11;
            if ((i11 & 16) != 0) {
                list = null;
            }
            return companion.a(str, i10, z10, z12, list);
        }

        public final AmooSkillListFragment a(String title, int necessary, boolean showCli, boolean testing, List<SkillItemBrief> preview) {
            kotlin.jvm.internal.p.i(title, "title");
            AmooSkillListFragment amooSkillListFragment = new AmooSkillListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putInt(AmooSkillListFragment.ARG_NECESSARY, necessary);
            bundle.putBoolean(AmooSkillListFragment.ARG_SHOW_CLI, showCli);
            bundle.putBoolean(AmooSkillListFragment.ARG_TESTING, testing);
            if (preview != null) {
                if (preview.isEmpty()) {
                    preview = null;
                }
                if (preview != null) {
                    N n10 = N.INSTANCE;
                    String strB = n10.b(necessary, testing);
                    n10.d(strB, preview);
                    bundle.putString(AmooSkillListFragment.ARG_PREVIEW_KEY, strB);
                }
            }
            amooSkillListFragment.setArguments(bundle);
            return amooSkillListFragment;
        }

        public Companion() {
        }
    }

    public AmooSkillListFragment() {
        super(R$layout.fragment_amoo_skill_list);
        this.adapter = new com.stepos.ailauncher.chat.adapter.h0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.I
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooSkillListFragment.J(this.f25178a, (SkillItemBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.J
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooSkillListFragment.K(this.f25181a, (SkillItemBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.K
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooSkillListFragment.L(this.f25183a, (SkillItemBrief) obj);
            }
        }, false, 8, null);
    }

    public static final Y8.t J(AmooSkillListFragment amooSkillListFragment, SkillItemBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooSkillListFragment.V(item);
        return Y8.t.f7040a;
    }

    public static final Y8.t K(AmooSkillListFragment amooSkillListFragment, SkillItemBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooSkillListFragment.N(item);
        return Y8.t.f7040a;
    }

    public static final Y8.t L(AmooSkillListFragment amooSkillListFragment, SkillItemBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooSkillListFragment.Y(item);
        return Y8.t.f7040a;
    }

    public static final void Q(AmooSkillListFragment amooSkillListFragment) {
        if (amooSkillListFragment.isAdded()) {
            amooSkillListFragment.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t R(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final void S(AmooSkillListFragment amooSkillListFragment, View view) {
        if (amooSkillListFragment.x()) {
            return;
        }
        amooSkillListFragment.o();
    }

    public static final String T(SkillItemBrief it) {
        kotlin.jvm.internal.p.i(it, "it");
        String id = it.getId();
        if (id != null) {
            return id;
        }
        String name = it.getName();
        return name == null ? "" : name;
    }

    public static final Y8.t U(AmooSkillListFragment amooSkillListFragment, RecyclerView recyclerView, C2796d7 state) {
        kotlin.jvm.internal.p.i(state, "state");
        amooSkillListFragment.adapter.p(state.f());
        recyclerView.setVisibility(state.f().isEmpty() ? 8 : 0);
        amooSkillListFragment.W();
        if (state.getCompleted()) {
            N n10 = N.INSTANCE;
            Bundle arguments = amooSkillListFragment.getArguments();
            int i10 = arguments != null ? arguments.getInt(ARG_NECESSARY, 1) : 1;
            Bundle arguments2 = amooSkillListFragment.getArguments();
            n10.e(n10.b(i10, arguments2 != null ? arguments2.getBoolean(ARG_TESTING, false) : false), state.f());
        }
        return Y8.t.f7040a;
    }

    private final void X() {
        kotlinx.coroutines.g gVar = this.actionStateJob;
        if (gVar == null || !gVar.b()) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            this.actionStateJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AmooSkillListFragment$startActionStateTicker$1(this, null), 3, null);
        }
    }

    public final Map<String, ISkillUiService.SkillUiStatus> M() {
        ISkillUiService.SkillUiStatus skillStatus;
        ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
        if (iSkillUiService == null) {
            return kotlin.collections.a.i();
        }
        List<SkillItemBrief> listI = this.adapter.i();
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(listI, 10)), 16));
        for (SkillItemBrief skillItemBrief : listI) {
            String strB = M.b(skillItemBrief);
            CliKind cliKindA = Q1.a(skillItemBrief);
            if (cliKindA == null || (skillStatus = Q1.e(cliKindA, skillItemBrief)) == null) {
                skillStatus = iSkillUiService.getSkillStatus(skillItemBrief);
            }
            Pair pairA = Y8.j.a(strB, skillStatus);
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return linkedHashMap;
    }

    public final void N(SkillItemBrief item) {
        if (Q1.a(item) != null) {
            V(item);
            return;
        }
        ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
        if (iSkillUiService != null) {
            iSkillUiService.installSkill(item);
        }
    }

    public final void O() {
        PagedListController<SkillItemBrief> pagedListController;
        Bundle arguments = getArguments();
        int i10 = arguments != null ? arguments.getInt(ARG_NECESSARY, 1) : 1;
        Bundle arguments2 = getArguments();
        boolean z10 = arguments2 != null ? arguments2.getBoolean(ARG_TESTING, false) : false;
        Bundle arguments3 = getArguments();
        boolean z11 = arguments3 != null ? arguments3.getBoolean(ARG_SHOW_CLI, false) : false;
        PagedListController<SkillItemBrief> pagedListController2 = this.pages;
        if (pagedListController2 == null) {
            kotlin.jvm.internal.p.A("pages");
            pagedListController = null;
        } else {
            pagedListController = pagedListController2;
        }
        PagedListController.x(pagedListController, 0, this.adapter.i(), new AmooSkillListFragment$loadSkills$1(i10, z10, z11, null), 1, null);
    }

    public final void P(View view) {
        Bundle arguments = getArguments();
        int i10 = arguments != null ? arguments.getInt(ARG_NECESSARY, 1) : 1;
        Bundle arguments2 = getArguments();
        boolean z10 = arguments2 != null ? arguments2.getBoolean(ARG_TESTING, false) : false;
        N n10 = N.INSTANCE;
        Bundle arguments3 = getArguments();
        List<SkillItemBrief> listA = n10.a(arguments3 != null ? arguments3.getString(ARG_PREVIEW_KEY) : null);
        if (listA == null) {
            listA = n10.c(n10.b(i10, z10));
        }
        List<SkillItemBrief> list = listA;
        if (list == null || list.isEmpty()) {
            O();
            return;
        }
        this.adapter.p(listA);
        view.findViewById(R$id.rvSkills).setVisibility(0);
        this.adapter.n(M());
        view.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.L
            @Override // java.lang.Runnable
            public final void run() {
                AmooSkillListFragment.Q(this.f25187a);
            }
        }, 420L);
    }

    public final void V(SkillItemBrief item) {
        Fragment fragmentCreateSkillDetailFragment;
        CliKind cliKindA = Q1.a(item);
        if (cliKindA != null) {
            Fragment fragmentC = Q1.c(cliKindA, item, requireContext());
            if (fragmentC != null) {
                com.stepos.ailauncher.sheet.nav.a.z(this, fragmentC, cliKindA == CliKind.FEISHU ? "feishu_connect" : "wecom_connect", null, null, null, 28, null);
                return;
            }
            return;
        }
        Bundle arguments = getArguments();
        boolean z10 = arguments != null ? arguments.getBoolean(ARG_TESTING, false) : false;
        ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
        if (iSkillUiService == null || (fragmentCreateSkillDetailFragment = iSkillUiService.createSkillDetailFragment(item, z10)) == null) {
            return;
        }
        String id = item.getId();
        if (id == null) {
            id = "";
        }
        com.stepos.ailauncher.sheet.nav.a.z(this, fragmentCreateSkillDetailFragment, "skill_detail_" + id, null, null, null, 28, null);
    }

    public final void W() {
        this.adapter.q(M());
    }

    public final void Y(SkillItemBrief item) {
        CliKind cliKindA = Q1.a(item);
        if (cliKindA != null) {
            androidx.fragment.app.r rVarRequireActivity = requireActivity();
            kotlin.jvm.internal.p.h(rVarRequireActivity, "requireActivity(...)");
            Q1.b(cliKindA, rVarRequireActivity);
        } else {
            ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
            if (iSkillUiService != null) {
                iSkillUiService.uninstallSkill(item);
            }
        }
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
    public void onPause() {
        kotlinx.coroutines.g gVar = this.actionStateJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.actionStateJob = null;
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        X();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        com.stepos.ailauncher.container.glass.k.b(view, 0, 1, null);
        View viewFindViewById = view.findViewById(R$id.btnBack);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.p.f(viewFindViewById);
        C2773b6 c2773b6P = C2773b6.p(c2773b6, new View[]{viewFindViewById}, null, false, 6, null);
        View viewFindViewById2 = view.findViewById(R$id.topChromeBlur);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        C2773b6.j(c2773b6P, new View[]{viewFindViewById2}, G.a.f43886a.g(), null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooSkillListFragment.R((A7.B) obj);
            }
        }, 4, null);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.F
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooSkillListFragment.S(this.f25170a, view2);
            }
        });
        TextView textView = (TextView) view.findViewById(R$id.tvTitle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("title") : null;
        if (string == null) {
            string = "";
        }
        textView.setText(string);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.rvSkills);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.setAdapter(this.adapter);
        Context context = recyclerView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        recyclerView.addItemDecoration(new Z8(context));
        final RecyclerView rvSkills = l5.f.a(view).rvSkills;
        kotlin.jvm.internal.p.h(rvSkills, "rvSkills");
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        this.pages = new PagedListController<>(viewLifecycleOwner2, rvSkills, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.G
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooSkillListFragment.T((SkillItemBrief) obj);
            }
        }, false, false, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.H
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooSkillListFragment.U(this.f25175a, rvSkills, (C2796d7) obj);
            }
        }, 56, null);
        P(view);
    }
}
