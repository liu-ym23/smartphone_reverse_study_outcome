package com.stepos.ailauncher.chat.fragment;

import Ua.C1060i;
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
import android.widget.Toast;
import androidx.activity.OnBackPressedDispatcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import b.AbstractC1417G;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.view.C2796d7;
import com.stepos.ailauncher.chat.view.ImeDismissFrameLayout;
import com.stepos.ailauncher.chat.view.PagedListController;
import com.stepos.ailauncher.chat.view.Z8;
import com.stepos.ailauncher.contract.api.skill.ISkillUiService;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import com.stepos.ailauncher.sheet.R$id;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u001b\u0010\u0016\u001a\u00020\u0006*\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\u0003R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010'R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\bR\u0014\u00108\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\b¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooSkillSearchFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "g0", "", "c0", "()Z", "b0", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "item", "Z", "(Lcom/stepos/ailauncher/contract/model/SkillItemBrief;)V", ExifInterface.LATITUDE_SOUTH, "i0", "a0", "h0", "P", "Landroid/view/MotionEvent;", "Landroid/view/View;", "target", "R", "(Landroid/view/MotionEvent;Landroid/view/View;)Z", "Q", "()Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroyView", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "pages", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "Lkotlinx/coroutines/g;", "searchJob", "Lkotlinx/coroutines/g;", "", "query", "Ljava/lang/String;", "actionStateJob", "Landroid/widget/EditText;", "searchInput", "Landroid/widget/EditText;", "Lcom/stepos/ailauncher/chat/view/E;", "searchIme", "Lcom/stepos/ailauncher/chat/view/E;", "Lcom/stepos/ailauncher/chat/adapter/h0;", "resultAdapter", "Lcom/stepos/ailauncher/chat/adapter/h0;", "e", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooSkillSearchFragment extends com.stepos.ailauncher.sheet.nav.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "amoo_skill_search";
    private kotlinx.coroutines.g actionStateJob;
    private PagedListController<SkillItemBrief> pages;
    private String query;
    private final com.stepos.ailauncher.chat.adapter.h0 resultAdapter;
    private com.stepos.ailauncher.chat.view.E searchIme;
    private EditText searchInput;
    private kotlinx.coroutines.g searchJob;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooSkillSearchFragment$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/fragment/AmooSkillSearchFragment;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/fragment/AmooSkillSearchFragment;", "", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.AmooSkillSearchFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AmooSkillSearchFragment a() {
            return new AmooSkillSearchFragment();
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
            AmooSkillSearchFragment amooSkillSearchFragment = AmooSkillSearchFragment.this;
            String string = text != null ? text.toString() : null;
            if (string == null) {
                string = "";
            }
            amooSkillSearchFragment.query = string;
            this.$btnClear$inlined.setVisibility(La.H.x0(AmooSkillSearchFragment.this.query) ? 8 : 0);
            AmooSkillSearchFragment.this.g0();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/fragment/AmooSkillSearchFragment$c", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends AbstractC1417G {
        public c() {
            super(true);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            AmooSkillSearchFragment.this.b0();
        }
    }

    public AmooSkillSearchFragment() {
        super(R$layout.fragment_amoo_skill_search);
        this.query = "";
        this.resultAdapter = new com.stepos.ailauncher.chat.adapter.h0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.O
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooSkillSearchFragment.d0(this.f25197a, (SkillItemBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.P
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooSkillSearchFragment.e0(this.f25202a, (SkillItemBrief) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.Q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooSkillSearchFragment.f0(this.f25207a, (SkillItemBrief) obj);
            }
        }, false, 8, null);
    }

    private final void P() {
        com.stepos.ailauncher.chat.view.E e10 = this.searchIme;
        if (e10 != null) {
            e10.r();
        }
    }

    private final View Q() {
        androidx.fragment.app.r activity = getActivity();
        if (activity != null) {
            return activity.findViewById(R$id.ail_settle_hint);
        }
        return null;
    }

    private final boolean R(MotionEvent motionEvent, View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return motionEvent.getRawX() >= ((float) iArr[0]) && motionEvent.getRawX() <= ((float) (iArr[0] + view.getWidth())) && motionEvent.getRawY() >= ((float) iArr[1]) && motionEvent.getRawY() <= ((float) (iArr[1] + view.getHeight()));
    }

    private final void S(SkillItemBrief item) {
        if (c0()) {
            if (Q1.a(item) != null) {
                Z(item);
                return;
            }
            ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
            if (iSkillUiService != null) {
                iSkillUiService.installSkill(item);
            }
        }
    }

    public static final void T(AmooSkillSearchFragment amooSkillSearchFragment, View view) {
        amooSkillSearchFragment.b0();
    }

    public static final boolean U(AmooSkillSearchFragment amooSkillSearchFragment, View view, MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        EditText editText = amooSkillSearchFragment.searchInput;
        if (editText == null || !editText.hasFocus()) {
            return false;
        }
        kotlin.jvm.internal.p.f(view);
        return !amooSkillSearchFragment.R(ev, view);
    }

    public static final Y8.t V(AmooSkillSearchFragment amooSkillSearchFragment) {
        amooSkillSearchFragment.P();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String W(SkillItemBrief it) {
        kotlin.jvm.internal.p.i(it, "it");
        String id = it.getId();
        if (id != null) {
            return id;
        }
        String name = it.getName();
        return name == null ? "" : name;
    }

    public static final Y8.t X(AmooSkillSearchFragment amooSkillSearchFragment, View view, C2796d7 state) {
        kotlin.jvm.internal.p.i(state, "state");
        amooSkillSearchFragment.resultAdapter.o(La.H.D1(amooSkillSearchFragment.query).toString());
        amooSkillSearchFragment.resultAdapter.p(state.f());
        amooSkillSearchFragment.a0();
        view.findViewById(com.stepos.ailauncher.chat.R$id.rvSearchResults).setVisibility(state.f().isEmpty() ? 8 : 0);
        view.findViewById(com.stepos.ailauncher.chat.R$id.searchInitialHint).setVisibility(La.H.x0(amooSkillSearchFragment.query) ? 0 : 8);
        view.findViewById(com.stepos.ailauncher.chat.R$id.searchEmptyHint).setVisibility((!La.H.x0(amooSkillSearchFragment.query) && state.getCompleted() && state.f().isEmpty()) ? 0 : 8);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(EditText editText, View view) {
        editText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0() {
        /*
            r6 = this;
            D5.a r0 = D5.a.INSTANCE
            java.lang.Class<com.stepos.ailauncher.contract.api.skill.ISkillUiService> r1 = com.stepos.ailauncher.contract.api.skill.ISkillUiService.class
            java.lang.Object r0 = r0.a(r1)
            com.stepos.ailauncher.contract.api.skill.ISkillUiService r0 = (com.stepos.ailauncher.contract.api.skill.ISkillUiService) r0
            if (r0 != 0) goto Ld
            return
        Ld:
            com.stepos.ailauncher.chat.adapter.h0 r1 = r6.resultAdapter
            java.util.List r1 = r1.i()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r2 = 10
            int r2 = Z8.C1174w.x(r1, r2)
            int r2 = Z8.Q.e(r2)
            r3 = 16
            int r2 = v9.C5685n.f(r2, r3)
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L2e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L72
            java.lang.Object r2 = r1.next()
            com.stepos.ailauncher.contract.model.SkillItemBrief r2 = (com.stepos.ailauncher.contract.model.SkillItemBrief) r2
            java.lang.String r4 = r2.getId()
            if (r4 == 0) goto L4a
            boolean r5 = La.H.x0(r4)
            if (r5 != 0) goto L47
            goto L48
        L47:
            r4 = 0
        L48:
            if (r4 != 0) goto L52
        L4a:
            java.lang.String r4 = r2.getName()
            if (r4 != 0) goto L52
            java.lang.String r4 = ""
        L52:
            com.stepos.ailauncher.chat.fragment.CliKind r5 = com.stepos.ailauncher.chat.fragment.Q1.a(r2)
            if (r5 == 0) goto L5e
            com.stepos.ailauncher.contract.api.skill.ISkillUiService$SkillUiStatus r5 = com.stepos.ailauncher.chat.fragment.Q1.e(r5, r2)
            if (r5 != 0) goto L62
        L5e:
            com.stepos.ailauncher.contract.api.skill.ISkillUiService$SkillUiStatus r5 = r0.getSkillStatus(r2)
        L62:
            kotlin.Pair r2 = Y8.j.a(r4, r5)
            java.lang.Object r4 = r2.e()
            java.lang.Object r2 = r2.f()
            r3.put(r4, r2)
            goto L2e
        L72:
            com.stepos.ailauncher.chat.adapter.h0 r6 = r6.resultAdapter
            r6.q(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.fragment.AmooSkillSearchFragment.a0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0() {
        P();
        Fragment parentFragment = getParentFragment();
        AmooStoreFragment amooStoreFragment = parentFragment instanceof AmooStoreFragment ? (AmooStoreFragment) parentFragment : null;
        if (amooStoreFragment != null) {
            amooStoreFragment.u0();
        }
    }

    private final boolean c0() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        return AuthManager.O(AuthManager.INSTANCE, context, false, false, 6, null);
    }

    public static final Y8.t d0(AmooSkillSearchFragment amooSkillSearchFragment, SkillItemBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooSkillSearchFragment.Z(item);
        return Y8.t.f7040a;
    }

    public static final Y8.t e0(AmooSkillSearchFragment amooSkillSearchFragment, SkillItemBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooSkillSearchFragment.S(item);
        return Y8.t.f7040a;
    }

    public static final Y8.t f0(AmooSkillSearchFragment amooSkillSearchFragment, SkillItemBrief item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooSkillSearchFragment.i0(item);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        kotlinx.coroutines.g gVar = this.searchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        PagedListController<SkillItemBrief> pagedListController = this.pages;
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
        this.searchJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AmooSkillSearchFragment$scheduleSearch$1(this, string, null), 3, null);
    }

    private final void h0() {
        kotlinx.coroutines.g gVar = this.actionStateJob;
        if (gVar == null || !gVar.b()) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            this.actionStateJob = C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AmooSkillSearchFragment$startActionStateTicker$1(this, null), 3, null);
        }
    }

    private final void i0(SkillItemBrief item) {
        if (c0()) {
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
    }

    public final void Z(SkillItemBrief item) {
        Fragment fragmentCreateSkillDetailFragment$default;
        if (c0()) {
            CliKind cliKindA = Q1.a(item);
            if (cliKindA != null) {
                Fragment fragmentC = Q1.c(cliKindA, item, requireContext());
                if (fragmentC != null) {
                    com.stepos.ailauncher.sheet.nav.a.z(this, fragmentC, cliKindA == CliKind.FEISHU ? "feishu_connect" : "wecom_connect", null, null, null, 28, null);
                    return;
                }
                return;
            }
            ISkillUiService iSkillUiService = (ISkillUiService) D5.a.INSTANCE.a(ISkillUiService.class);
            if (iSkillUiService == null || (fragmentCreateSkillDetailFragment$default = ISkillUiService.createSkillDetailFragment$default(iSkillUiService, item, false, 2, null)) == null) {
                Context contextRequireContext = requireContext();
                String name = item.getName();
                Toast.makeText(contextRequireContext, name != null ? name : "", 0).show();
            } else {
                String id = item.getId();
                com.stepos.ailauncher.sheet.nav.a.z(this, fragmentCreateSkillDetailFragment$default, "skill_detail_" + (id != null ? id : ""), null, null, null, 28, null);
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
    public void onDestroyView() {
        kotlinx.coroutines.g gVar = this.searchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
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
    public void onViewCreated(final View view, Bundle savedInstanceState) {
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
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.S
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooSkillSearchFragment.T(this.f25210a, view2);
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.m(viewLifecycleOwner2, new c());
        ImeDismissFrameLayout imeDismissFrameLayout = (ImeDismissFrameLayout) view.findViewById(com.stepos.ailauncher.chat.R$id.searchRoot);
        imeDismissFrameLayout.setShouldSwallow(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.T
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AmooSkillSearchFragment.U(this.f25213a, viewFindViewById, (MotionEvent) obj));
            }
        });
        imeDismissFrameLayout.setOnSwallowed(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.U
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AmooSkillSearchFragment.V(this.f25218a);
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
        RecyclerView rvSearchResults = l5.g.a(view).rvSearchResults;
        kotlin.jvm.internal.p.h(rvSearchResults, "rvSearchResults");
        this.pages = new PagedListController<>(viewLifecycleOwner3, rvSearchResults, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.V
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooSkillSearchFragment.W((SkillItemBrief) obj);
            }
        }, false, false, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.W
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooSkillSearchFragment.X(this.f25222a, view, (C2796d7) obj);
            }
        }, 40, null);
        kotlin.jvm.internal.p.f(editText);
        editText.addTextChangedListener(new b(viewFindViewById2));
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.X
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooSkillSearchFragment.Y(editText, view2);
            }
        });
        kotlin.jvm.internal.p.f(viewFindViewById);
        LinearLayout searchHints = l5.g.a(view).searchHints;
        kotlin.jvm.internal.p.h(searchHints, "searchHints");
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        com.stepos.ailauncher.chat.view.E e10 = new com.stepos.ailauncher.chat.view.E(view, editText, viewFindViewById, searchHints, viewLifecycleOwner4);
        e10.p();
        this.searchIme = e10;
        g0();
    }
}
