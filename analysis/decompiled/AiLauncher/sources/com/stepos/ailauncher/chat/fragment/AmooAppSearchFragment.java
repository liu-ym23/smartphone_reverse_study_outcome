package com.stepos.ailauncher.chat.fragment;

import Ua.C1060i;
import Z8.C1173v;
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
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.adapter.C2503i;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.view.C2796d7;
import com.stepos.ailauncher.chat.view.ImeDismissFrameLayout;
import com.stepos.ailauncher.chat.view.PagedListController;
import com.stepos.ailauncher.chat.view.Z8;
import com.stepos.ailauncher.foundation.appstore.api.AppVersionItem;
import com.stepos.ailauncher.sheet.R$id;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 92\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u001b\u0010\r\u001a\u00020\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u0006R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\"R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00106\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00108\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00105¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooAppSearchFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "Y", "Z", ExifInterface.LONGITUDE_WEST, "M", "Landroid/view/MotionEvent;", "Landroid/view/View;", "target", "", "O", "(Landroid/view/MotionEvent;Landroid/view/View;)Z", "N", "()Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroyView", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;", "item", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;)V", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "pages", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "", "query", "Ljava/lang/String;", "", "results", "Ljava/util/List;", ChatTracker.PREVIEW_LOADING, "Lkotlinx/coroutines/g;", "searchJob", "Lkotlinx/coroutines/g;", "answeredQuery", "Landroid/widget/EditText;", "searchInput", "Landroid/widget/EditText;", "Lcom/stepos/ailauncher/chat/view/E;", "searchIme", "Lcom/stepos/ailauncher/chat/view/E;", "Lcom/stepos/ailauncher/chat/adapter/i;", "resultAdapter", "Lcom/stepos/ailauncher/chat/adapter/i;", "e", "()Z", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooAppSearchFragment extends com.stepos.ailauncher.sheet.nav.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int LOAD_MORE_THRESHOLD_PX = 300;
    private static final long SEARCH_DEBOUNCE_MS = 300;
    private String answeredQuery;
    private boolean loading;
    private PagedListController<AppVersionItem> pages;
    private String query;
    private final C2503i resultAdapter;
    private List<AppVersionItem> results;
    private com.stepos.ailauncher.chat.view.E searchIme;
    private EditText searchInput;
    private kotlinx.coroutines.g searchJob;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooAppSearchFragment$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/fragment/AmooAppSearchFragment;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/fragment/AmooAppSearchFragment;", "", "SEARCH_DEBOUNCE_MS", "J", "", "LOAD_MORE_THRESHOLD_PX", "I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.AmooAppSearchFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AmooAppSearchFragment a() {
            return new AmooAppSearchFragment();
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
            AmooAppSearchFragment amooAppSearchFragment = AmooAppSearchFragment.this;
            String string = text != null ? text.toString() : null;
            if (string == null) {
                string = "";
            }
            amooAppSearchFragment.query = string;
            this.$btnClear$inlined.setVisibility(La.H.x0(AmooAppSearchFragment.this.query) ? 8 : 0);
            AmooAppSearchFragment.this.Y();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/fragment/AmooAppSearchFragment$c", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends AbstractC1417G {
        public c() {
            super(true);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            AmooAppSearchFragment.this.W();
        }
    }

    public AmooAppSearchFragment() {
        super(R$layout.fragment_amoo_app_search);
        this.query = "";
        this.results = C1173v.m();
        this.resultAdapter = new C2503i(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooAppSearchFragment.X(this.f25344a, (AppVersionItem) obj);
            }
        }, null, 2, null);
    }

    private final void M() {
        com.stepos.ailauncher.chat.view.E e10 = this.searchIme;
        if (e10 != null) {
            e10.r();
        }
    }

    private final View N() {
        androidx.fragment.app.r activity = getActivity();
        if (activity != null) {
            return activity.findViewById(R$id.ail_settle_hint);
        }
        return null;
    }

    private final boolean O(MotionEvent motionEvent, View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return motionEvent.getRawX() >= ((float) iArr[0]) && motionEvent.getRawX() <= ((float) (iArr[0] + view.getWidth())) && motionEvent.getRawY() >= ((float) iArr[1]) && motionEvent.getRawY() <= ((float) (iArr[1] + view.getHeight()));
    }

    public static final void P(AmooAppSearchFragment amooAppSearchFragment, View view) {
        amooAppSearchFragment.W();
    }

    public static final boolean Q(AmooAppSearchFragment amooAppSearchFragment, View view, MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        EditText editText = amooAppSearchFragment.searchInput;
        if (editText == null || !editText.hasFocus()) {
            return false;
        }
        kotlin.jvm.internal.p.f(view);
        return !amooAppSearchFragment.O(ev, view);
    }

    public static final Y8.t R(AmooAppSearchFragment amooAppSearchFragment) {
        amooAppSearchFragment.M();
        return Y8.t.f7040a;
    }

    public static final String S(AppVersionItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        String packageName = it.getPackageName();
        if (packageName != null) {
            if (La.H.x0(packageName)) {
                packageName = null;
            }
            if (packageName != null) {
                return packageName;
            }
        }
        return String.valueOf(it.getId());
    }

    public static final Y8.t T(AmooAppSearchFragment amooAppSearchFragment, C2796d7 state) {
        kotlin.jvm.internal.p.i(state, "state");
        amooAppSearchFragment.results = state.f();
        amooAppSearchFragment.loading = state.getLoading();
        amooAppSearchFragment.answeredQuery = (state.getCompleted() || !(state.getNextKey() == null || state.f().isEmpty())) ? La.H.D1(amooAppSearchFragment.query).toString() : null;
        amooAppSearchFragment.resultAdapter.g(amooAppSearchFragment.results);
        amooAppSearchFragment.Z();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(EditText editText, View view) {
        editText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W() {
        M();
        Fragment parentFragment = getParentFragment();
        AmooStoreFragment amooStoreFragment = parentFragment instanceof AmooStoreFragment ? (AmooStoreFragment) parentFragment : null;
        if (amooStoreFragment != null) {
            amooStoreFragment.t0();
        }
    }

    public static final Y8.t X(AmooAppSearchFragment amooAppSearchFragment, AppVersionItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooAppSearchFragment.V(item);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y() {
        kotlinx.coroutines.g gVar = this.searchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        PagedListController<AppVersionItem> pagedListController = this.pages;
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
        this.searchJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AmooAppSearchFragment$scheduleSearch$1(this, string, null), 3, null);
    }

    private final void Z() {
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

    public final void V(AppVersionItem item) {
        Context context = getContext();
        if (context != null && AuthManager.O(AuthManager.INSTANCE, context, false, false, 6, null)) {
            com.stepos.ailauncher.sheet.nav.a.z(this, AmooAppDetailFragment.INSTANCE.a(item.getId(), item.getPackageName(), item.getName(), item.getIconUrl()), "ai_app_detail_" + item.getId(), null, null, null, 28, null);
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
        M();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            Result.Companion companion = Result.INSTANCE;
            View viewN = N();
            if (viewN != null) {
                viewN.setVisibility(8);
            }
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

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
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        View viewFindViewById4 = view.findViewById(com.stepos.ailauncher.chat.R$id.searchInputContainer);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        kotlin.jvm.internal.p.f(viewFindViewById3);
        C2773b6.p(c2773b6, new View[]{viewFindViewById4, viewFindViewById3}, null, false, 6, null);
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooAppSearchFragment.P(this.f25325a, view2);
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.m(viewLifecycleOwner2, new c());
        ImeDismissFrameLayout imeDismissFrameLayout = (ImeDismissFrameLayout) view.findViewById(com.stepos.ailauncher.chat.R$id.searchRoot);
        imeDismissFrameLayout.setShouldSwallow(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AmooAppSearchFragment.Q(this.f25328a, viewFindViewById, (MotionEvent) obj));
            }
        });
        imeDismissFrameLayout.setOnSwallowed(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AmooAppSearchFragment.R(this.f25331a);
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
        RecyclerView rvSearchResults = l5.d.a(view).rvSearchResults;
        kotlin.jvm.internal.p.h(rvSearchResults, "rvSearchResults");
        this.pages = new PagedListController<>(viewLifecycleOwner3, rvSearchResults, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooAppSearchFragment.S((AppVersionItem) obj);
            }
        }, false, false, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooAppSearchFragment.T(this.f25336a, (C2796d7) obj);
            }
        }, 40, null);
        kotlin.jvm.internal.p.f(editText);
        editText.addTextChangedListener(new b(viewFindViewById2));
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooAppSearchFragment.U(editText, view2);
            }
        });
        kotlin.jvm.internal.p.f(viewFindViewById);
        LinearLayout searchHints = l5.d.a(view).searchHints;
        kotlin.jvm.internal.p.h(searchHints, "searchHints");
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        com.stepos.ailauncher.chat.view.E e10 = new com.stepos.ailauncher.chat.view.E(view, editText, viewFindViewById, searchHints, viewLifecycleOwner4);
        e10.p();
        this.searchIme = e10;
        Z();
    }
}
