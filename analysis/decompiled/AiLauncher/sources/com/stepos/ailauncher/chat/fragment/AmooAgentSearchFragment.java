package com.stepos.ailauncher.chat.fragment;

import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import b.AbstractC1417G;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.adapter.C2495a;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.view.C2796d7;
import com.stepos.ailauncher.chat.view.ImeDismissFrameLayout;
import com.stepos.ailauncher.chat.view.PagedListController;
import com.stepos.ailauncher.chat.view.Z8;
import com.stepos.ailauncher.contract.api.agent.IAgentMarketService;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentUiService;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import com.stepos.ailauncher.sheet.R$id;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import l5.C4873b;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u001b\u0010\u0017\u001a\u00020\r*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0003R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\tR\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010/R\u0018\u00101\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010(R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u000fR\u0014\u0010>\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u000f¨\u0006A"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooAgentSearchFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "g0", "j0", "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "agent", "Z", "(Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;)V", ExifInterface.LATITUDE_SOUTH, "i0", "", "c0", "()Z", "a0", "h0", "b0", "P", "Landroid/view/MotionEvent;", "Landroid/view/View;", "target", "R", "(Landroid/view/MotionEvent;Landroid/view/View;)Z", "Q", "()Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroyView", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "pages", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "", "query", "Ljava/lang/String;", "", "results", "Ljava/util/List;", ChatTracker.PREVIEW_LOADING, "Lkotlinx/coroutines/g;", "searchJob", "Lkotlinx/coroutines/g;", "actionStateJob", "answeredQuery", "Landroid/widget/EditText;", "searchInput", "Landroid/widget/EditText;", "Lcom/stepos/ailauncher/chat/view/E;", "searchIme", "Lcom/stepos/ailauncher/chat/view/E;", "Lcom/stepos/ailauncher/chat/adapter/a;", "resultAdapter", "Lcom/stepos/ailauncher/chat/adapter/a;", "e", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooAgentSearchFragment extends com.stepos.ailauncher.sheet.nav.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int LOAD_MORE_THRESHOLD_PX = 300;
    private static final int PAGE_SIZE = 20;
    private static final long SEARCH_DEBOUNCE_MS = 300;
    private kotlinx.coroutines.g actionStateJob;
    private String answeredQuery;
    private boolean loading;
    private PagedListController<MarketAgentBrief> pages;
    private String query;
    private final C2495a resultAdapter;
    private List<MarketAgentBrief> results;
    private com.stepos.ailauncher.chat.view.E searchIme;
    private EditText searchInput;
    private kotlinx.coroutines.g searchJob;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooAgentSearchFragment$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/fragment/AmooAgentSearchFragment;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/fragment/AmooAgentSearchFragment;", "", "SEARCH_DEBOUNCE_MS", "J", "", "PAGE_SIZE", "I", "LOAD_MORE_THRESHOLD_PX", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.AmooAgentSearchFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AmooAgentSearchFragment a() {
            return new AmooAgentSearchFragment();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "LY8/t;", "afterTextChanged", "(Landroid/text/Editable;)V", "", "text", "", "start", "count", "after", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements TextWatcher {
        final /* synthetic */ View $btnClear$inlined;

        public b(View view) {
            this.$btnClear$inlined = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence text, int start, int before, int count) {
            AmooAgentSearchFragment amooAgentSearchFragment = AmooAgentSearchFragment.this;
            String string = text != null ? text.toString() : null;
            if (string == null) {
                string = "";
            }
            amooAgentSearchFragment.query = string;
            this.$btnClear$inlined.setVisibility(La.H.x0(AmooAgentSearchFragment.this.query) ? 8 : 0);
            AmooAgentSearchFragment.this.g0();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/fragment/AmooAgentSearchFragment$c", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends AbstractC1417G {
        public c() {
            super(true);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            AmooAgentSearchFragment.this.b0();
        }
    }

    public AmooAgentSearchFragment() {
        super(R$layout.fragment_amoo_agent_search);
        this.query = "";
        this.results = C1173v.m();
        this.resultAdapter = new C2495a(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooAgentSearchFragment.d0(this.f25276a, (MarketAgentBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooAgentSearchFragment.e0(this.f25280a, (MarketAgentBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooAgentSearchFragment.f0(this.f25295a, (MarketAgentBrief) obj);
            }
        }, false, 8, null);
    }

    private final View Q() {
        androidx.fragment.app.r activity = getActivity();
        if (activity != null) {
            return activity.findViewById(R$id.ail_settle_hint);
        }
        return null;
    }

    public static final void T(AmooAgentSearchFragment amooAgentSearchFragment, View view) {
        amooAgentSearchFragment.b0();
    }

    public static final boolean U(AmooAgentSearchFragment amooAgentSearchFragment, View view, MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        EditText editText = amooAgentSearchFragment.searchInput;
        if (editText == null || !editText.hasFocus()) {
            return false;
        }
        kotlin.jvm.internal.p.f(view);
        return !amooAgentSearchFragment.R(ev, view);
    }

    public static final Y8.t V(AmooAgentSearchFragment amooAgentSearchFragment) {
        amooAgentSearchFragment.P();
        return Y8.t.f7040a;
    }

    public static final String W(MarketAgentBrief it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getAssetId();
    }

    public static final Y8.t X(AmooAgentSearchFragment amooAgentSearchFragment, C2796d7 state) {
        kotlin.jvm.internal.p.i(state, "state");
        amooAgentSearchFragment.results = state.f();
        amooAgentSearchFragment.loading = state.getLoading();
        amooAgentSearchFragment.answeredQuery = (state.getCompleted() || !(state.getNextKey() == null || state.f().isEmpty())) ? La.H.D1(amooAgentSearchFragment.query).toString() : null;
        amooAgentSearchFragment.resultAdapter.l(amooAgentSearchFragment.results);
        amooAgentSearchFragment.a0();
        amooAgentSearchFragment.j0();
        return Y8.t.f7040a;
    }

    public static final void Y(EditText editText, View view) {
        editText.setText("");
    }

    public static final Y8.t d0(AmooAgentSearchFragment amooAgentSearchFragment, MarketAgentBrief agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        amooAgentSearchFragment.S(agent);
        return Y8.t.f7040a;
    }

    public static final Y8.t e0(AmooAgentSearchFragment amooAgentSearchFragment, MarketAgentBrief agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        amooAgentSearchFragment.i0(agent);
        return Y8.t.f7040a;
    }

    public static final Y8.t f0(AmooAgentSearchFragment amooAgentSearchFragment, MarketAgentBrief agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        amooAgentSearchFragment.Z(agent);
        return Y8.t.f7040a;
    }

    public final void P() {
        com.stepos.ailauncher.chat.view.E e10 = this.searchIme;
        if (e10 != null) {
            e10.r();
        }
    }

    public final boolean R(MotionEvent motionEvent, View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return motionEvent.getRawX() >= ((float) iArr[0]) && motionEvent.getRawX() <= ((float) (iArr[0] + view.getWidth())) && motionEvent.getRawY() >= ((float) iArr[1]) && motionEvent.getRawY() <= ((float) (iArr[1] + view.getHeight()));
    }

    public final void S(MarketAgentBrief agent) {
        IAgentMarketService iAgentMarketService;
        if (c0() && (iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class)) != null) {
            iAgentMarketService.installAgent(agent);
        }
    }

    public final void Z(MarketAgentBrief agent) {
        IExternalAgentUiService iExternalAgentUiService;
        Fragment fragmentCreateAgentMarketDetailFragment;
        if (!c0() || (iExternalAgentUiService = (IExternalAgentUiService) D5.a.INSTANCE.a(IExternalAgentUiService.class)) == null || (fragmentCreateAgentMarketDetailFragment = iExternalAgentUiService.createAgentMarketDetailFragment(agent)) == null) {
            return;
        }
        com.stepos.ailauncher.sheet.nav.a.z(this, fragmentCreateAgentMarketDetailFragment, AgentMarketDetailFragment.TAG, null, null, null, 28, null);
    }

    public final void a0() {
        IAgentMarketService iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class);
        if (iAgentMarketService == null) {
            return;
        }
        List<MarketAgentBrief> list = this.results;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
        for (MarketAgentBrief marketAgentBrief : list) {
            Pair pairA = Y8.j.a(marketAgentBrief.getAssetId(), iAgentMarketService.getAgentStatus(marketAgentBrief));
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        List<MarketAgentBrief> list2 = this.results;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list2, 10)), 16));
        for (MarketAgentBrief marketAgentBrief2 : list2) {
            Pair pairA2 = Y8.j.a(marketAgentBrief2.getAssetId(), Integer.valueOf(iAgentMarketService.getInstallProgress(marketAgentBrief2.getAssetId())));
            linkedHashMap2.put(pairA2.e(), pairA2.f());
        }
        this.resultAdapter.m(linkedHashMap, linkedHashMap2);
    }

    public final void b0() {
        P();
        Fragment parentFragment = getParentFragment();
        AmooStoreFragment amooStoreFragment = parentFragment instanceof AmooStoreFragment ? (AmooStoreFragment) parentFragment : null;
        if (amooStoreFragment != null) {
            amooStoreFragment.s0();
        }
    }

    public final boolean c0() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return AuthManager.O(AuthManager.INSTANCE, context, false, false, 6, null);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    public final void g0() {
        kotlinx.coroutines.g gVar = this.searchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        PagedListController<MarketAgentBrief> pagedListController = this.pages;
        if (pagedListController == null) {
            kotlin.jvm.internal.p.A("pages");
            pagedListController = null;
        }
        pagedListController.m();
        String string = La.H.D1(this.query).toString();
        if (La.H.x0(string)) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.searchJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AmooAgentSearchFragment$scheduleSearch$1(this, string, null), 3, null);
    }

    public final void h0() {
        kotlinx.coroutines.g gVar = this.actionStateJob;
        if (gVar == null || !gVar.b()) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            this.actionStateJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AmooAgentSearchFragment$startActionStateTicker$1(this, null), 3, null);
        }
    }

    public final void i0(MarketAgentBrief agent) {
        IAgentMarketService iAgentMarketService;
        if (c0() && (iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class)) != null) {
            iAgentMarketService.uninstallAgent(agent);
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    public final void j0() {
        View view = getView();
        if (view == null) {
            return;
        }
        String string = La.H.D1(this.query).toString();
        boolean zX0 = La.H.x0(string);
        int i10 = 8;
        view.findViewById(com.stepos.ailauncher.chat.R$id.rvSearchResults).setVisibility(!this.results.isEmpty() ? 0 : 8);
        view.findViewById(com.stepos.ailauncher.chat.R$id.searchInitialHint).setVisibility(zX0 ? 0 : 8);
        View viewFindViewById = view.findViewById(com.stepos.ailauncher.chat.R$id.searchEmptyHint);
        if (!zX0 && kotlin.jvm.internal.p.d(this.answeredQuery, string) && this.results.isEmpty()) {
            i10 = 0;
        }
        viewFindViewById.setVisibility(i10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        kotlinx.coroutines.g gVar = this.searchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.searchJob = null;
        this.searchIme = null;
        this.searchInput = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        kotlinx.coroutines.g gVar = this.actionStateJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.actionStateJob = null;
        P();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            Result.Companion companion = Result.INSTANCE;
            View viewQ = Q();
            if (viewQ != null) {
                viewQ.setVisibility(8);
            }
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        h0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final View viewFindViewById = view.findViewById(com.stepos.ailauncher.chat.R$id.searchBottomBar);
        final EditText editText = (EditText) view.findViewById(com.stepos.ailauncher.chat.R$id.etSearch);
        this.searchInput = editText;
        View viewFindViewById2 = view.findViewById(com.stepos.ailauncher.chat.R$id.btnSearchClear);
        View viewFindViewById3 = view.findViewById(com.stepos.ailauncher.chat.R$id.btnSearchClose);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, 0 == true ? 1 : 0);
        View viewFindViewById4 = view.findViewById(com.stepos.ailauncher.chat.R$id.searchInputContainer);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        kotlin.jvm.internal.p.f(viewFindViewById3);
        C2773b6.p(c2773b6, new View[]{viewFindViewById4, viewFindViewById3}, null, false, 6, null);
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooAgentSearchFragment.T(this.f25237a, view2);
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.m(viewLifecycleOwner2, new c());
        ImeDismissFrameLayout imeDismissFrameLayout = (ImeDismissFrameLayout) view.findViewById(com.stepos.ailauncher.chat.R$id.searchRoot);
        imeDismissFrameLayout.setShouldSwallow(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AmooAgentSearchFragment.U(this.f25243a, viewFindViewById, (MotionEvent) obj));
            }
        });
        imeDismissFrameLayout.setOnSwallowed(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AmooAgentSearchFragment.V(this.f25250a);
            }
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(com.stepos.ailauncher.chat.R$id.rvSearchResults);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.setAdapter(this.resultAdapter);
        Context context = recyclerView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        recyclerView.addItemDecoration(new Z8(context));
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        RecyclerView rvSearchResults = C4873b.a(view).rvSearchResults;
        kotlin.jvm.internal.p.h(rvSearchResults, "rvSearchResults");
        this.pages = new PagedListController<>(viewLifecycleOwner3, rvSearchResults, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooAgentSearchFragment.W((MarketAgentBrief) obj);
            }
        }, false, false, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooAgentSearchFragment.X(this.f25268a, (C2796d7) obj);
            }
        }, 40, null);
        kotlin.jvm.internal.p.f(editText);
        editText.addTextChangedListener(new b(viewFindViewById2));
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooAgentSearchFragment.Y(editText, view2);
            }
        });
        kotlin.jvm.internal.p.f(viewFindViewById);
        LinearLayout searchHints = C4873b.a(view).searchHints;
        kotlin.jvm.internal.p.h(searchHints, "searchHints");
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        com.stepos.ailauncher.chat.view.E e10 = new com.stepos.ailauncher.chat.view.E(view, editText, viewFindViewById, searchHints, viewLifecycleOwner4);
        e10.p();
        this.searchIme = e10;
        j0();
    }
}
