package com.stepos.ailauncher.chat.fragment;

import Ua.C1060i;
import V0.CreationExtras;
import android.content.Context;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.U;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.controller.InterfaceC2538f;
import com.stepos.ailauncher.chat.view.P7;
import com.stepos.ailauncher.chat.view.SessionCenterView;
import com.stepos.ailauncher.chat.view.SessionSearchView;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import com.stepos.ailauncher.sheet.SheetSettleState;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001*\u0018\u0000 12\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0003J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0003J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0003R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u0004\u0018\u00010-8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/SessionCenterFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "R", "M", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "L", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "k", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "P", "O", "", "suspended", "Q", "(Z)V", "onDestroyView", "I", "G", "H", "Lcom/stepos/ailauncher/chat/fragment/I0;", "coreViewModel$delegate", "LY8/h;", "J", "()Lcom/stepos/ailauncher/chat/fragment/I0;", "coreViewModel", "searchOverlayExiting", "Z", "com/stepos/ailauncher/chat/fragment/SessionCenterFragment$b", "sessionCenterHost", "Lcom/stepos/ailauncher/chat/fragment/SessionCenterFragment$b;", "Lcom/stepos/ailauncher/chat/view/SessionCenterView;", "K", "()Lcom/stepos/ailauncher/chat/view/SessionCenterView;", "sessionCenter", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionCenterFragment extends com.stepos.ailauncher.sheet.nav.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG_SEARCH_OVERLAY = "session_search_overlay";

    /* renamed from: coreViewModel$delegate, reason: from kotlin metadata */
    private final Y8.h coreViewModel;
    private boolean searchOverlayExiting;
    private final b sessionCenterHost = new b();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/SessionCenterFragment$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/fragment/SessionCenterFragment;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/fragment/SessionCenterFragment;", "", "TAG_SEARCH_OVERLAY", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.SessionCenterFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final SessionCenterFragment a() {
            return new SessionCenterFragment();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"com/stepos/ailauncher/chat/fragment/SessionCenterFragment$b", "Lcom/stepos/ailauncher/chat/view/P7;", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "session", "LY8/t;", "f", "(Lcom/stepos/ailauncher/contract/model/search/SidebarSession;)V", "", "sessionId", "c", "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/chat/controller/f;", "target", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/controller/f;)V", Const.INTENT_KEY_PKGNAME, "()V", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements P7 {
        public b() {
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void a(InterfaceC2538f target) {
            kotlin.jvm.internal.p.i(target, "target");
            androidx.fragment.app.r activity = SessionCenterFragment.this.getActivity();
            ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
            if (chatActivity != null) {
                chatActivity.W9(target.getAgentId(), target.getDeviceId(), target.getDisplayName());
            }
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void b() {
            androidx.fragment.app.r activity = SessionCenterFragment.this.getActivity();
            ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
            if (chatActivity != null) {
                ChatActivity.X9(chatActivity, null, null, null, 7, null);
            }
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void c(String sessionId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            androidx.fragment.app.r activity = SessionCenterFragment.this.getActivity();
            ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
            if (chatActivity != null) {
                chatActivity.aa(sessionId, true);
            }
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public /* bridge */ void d(boolean z10) {
            super.d(z10);
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void e() {
            SessionCenterFragment.this.I();
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void f(SidebarSession session) {
            kotlin.jvm.internal.p.i(session, "session");
            androidx.fragment.app.r activity = SessionCenterFragment.this.getActivity();
            ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
            if (chatActivity != null) {
                ChatActivity.ba(chatActivity, session.getSessionId(), false, 2, null);
            }
        }

        @Override // com.stepos.ailauncher.chat.view.P7
        public void g() {
            androidx.fragment.app.r activity = SessionCenterFragment.this.getActivity();
            ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
            if (chatActivity != null) {
                chatActivity.Y8();
            }
        }
    }

    public SessionCenterFragment() {
        final InterfaceC5063a interfaceC5063a = null;
        this.coreViewModel = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.t.b(I0.class), new InterfaceC5063a<android.view.V>() { // from class: com.stepos.ailauncher.chat.fragment.SessionCenterFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final android.view.V invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new InterfaceC5063a<CreationExtras>() { // from class: com.stepos.ailauncher.chat.fragment.SessionCenterFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                InterfaceC5063a interfaceC5063a2 = interfaceC5063a;
                return (interfaceC5063a2 == null || (creationExtras = (CreationExtras) interfaceC5063a2.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new InterfaceC5063a<U.c>() { // from class: com.stepos.ailauncher.chat.fragment.SessionCenterFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final U.c invoke() {
                return this.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final I0 J() {
        return (I0) this.coreViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        SessionCenterView sessionCenterViewK;
        final Fragment fragmentL0 = getChildFragmentManager().l0(TAG_SEARCH_OVERLAY);
        if (fragmentL0 == null || this.searchOverlayExiting) {
            if (fragmentL0 != null || (sessionCenterViewK = K()) == null) {
                return;
            }
            sessionCenterViewK.Z(false, false);
            return;
        }
        View view = fragmentL0.getView();
        final SessionSearchView sessionSearchView = view instanceof SessionSearchView ? (SessionSearchView) view : null;
        g2 g2Var = fragmentL0 instanceof g2 ? (g2) fragmentL0 : null;
        if (g2Var != null) {
            g2Var.M();
        }
        SessionCenterView sessionCenterViewK2 = K();
        if (sessionCenterViewK2 != null) {
            sessionCenterViewK2.Z(false, true);
        }
        if (sessionSearchView != null) {
            this.searchOverlayExiting = true;
            sessionSearchView.C(false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.b2
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return SessionCenterFragment.N(this.f25240a, sessionSearchView, fragmentL0);
                }
            });
            return;
        }
        SessionCenterView sessionCenterViewK3 = K();
        if (sessionCenterViewK3 != null) {
            sessionCenterViewK3.Y();
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.p.h(childFragmentManager, "getChildFragmentManager(...)");
        androidx.fragment.app.K kQ = childFragmentManager.q();
        kQ.o(fragmentL0);
        kQ.g();
    }

    public static final Y8.t N(SessionCenterFragment sessionCenterFragment, SessionSearchView sessionSearchView, Fragment fragment) {
        sessionCenterFragment.searchOverlayExiting = false;
        sessionSearchView.z();
        SessionCenterView sessionCenterViewK = sessionCenterFragment.K();
        if (sessionCenterViewK != null) {
            sessionCenterViewK.Y();
        }
        if (sessionCenterFragment.isAdded() && fragment.isAdded()) {
            FragmentManager childFragmentManager = sessionCenterFragment.getChildFragmentManager();
            kotlin.jvm.internal.p.h(childFragmentManager, "getChildFragmentManager(...)");
            androidx.fragment.app.K kQ = childFragmentManager.q();
            kQ.o(fragment);
            kQ.g();
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        if (getChildFragmentManager().l0(TAG_SEARCH_OVERLAY) != null) {
            SessionCenterView sessionCenterViewK = K();
            if (sessionCenterViewK != null) {
                sessionCenterViewK.Z(true, false);
                return;
            }
            return;
        }
        SessionCenterView sessionCenterViewK2 = K();
        if (sessionCenterViewK2 != null) {
            sessionCenterViewK2.Z(true, true);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.p.h(childFragmentManager, "getChildFragmentManager(...)");
        androidx.fragment.app.K kQ = childFragmentManager.q();
        kQ.b(R$id.fl_session_center_search_host, g2.INSTANCE.a(), TAG_SEARCH_OVERLAY);
        kQ.g();
    }

    public final void G() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new SessionCenterFragment$bindLiveSessionHandler$1(this, null), 3, null);
    }

    public final void H() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new SessionCenterFragment$bindSearchOverlay$1(this, null), 3, null);
    }

    public final void I() {
        o();
    }

    public final SessionCenterView K() {
        View view = getView();
        if (view instanceof SessionCenterView) {
            return (SessionCenterView) view;
        }
        return null;
    }

    public final void L() {
        SessionCenterView sessionCenterViewK = K();
        if (sessionCenterViewK != null) {
            sessionCenterViewK.L();
        }
    }

    public final void O() {
        SessionCenterView sessionCenterViewK = K();
        if (sessionCenterViewK != null) {
            sessionCenterViewK.Q();
        }
    }

    public final void P() {
        SessionCenterView sessionCenterViewK = K();
        if (sessionCenterViewK != null) {
            sessionCenterViewK.R();
        }
    }

    public final void Q(boolean suspended) {
        SessionCenterView sessionCenterViewK = K();
        if (sessionCenterViewK != null) {
            sessionCenterViewK.setGlassSuspended(suspended);
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void k(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        SessionCenterView sessionCenterViewK = K();
        if (sessionCenterViewK != null) {
            sessionCenterViewK.S(state);
        }
        Fragment fragmentL0 = getChildFragmentManager().l0(TAG_SEARCH_OVERLAY);
        g2 g2Var = fragmentL0 instanceof g2 ? (g2) fragmentL0 : null;
        if (g2Var != null) {
            g2Var.k(state);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(inflater, "inflater");
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        SessionCenterView sessionCenterView = new SessionCenterView(contextRequireContext, null, 0, 6, null);
        sessionCenterView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return sessionCenterView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SessionCenterView sessionCenterViewK = K();
        if (sessionCenterViewK != null) {
            sessionCenterViewK.W();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LifecycleOwner viewLifecycleOwner;
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SessionCenterView sessionCenterView = view instanceof SessionCenterView ? (SessionCenterView) view : null;
        if (sessionCenterView == null) {
            return;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null || (viewLifecycleOwner = parentFragment.getViewLifecycleOwner()) == null) {
            viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        }
        sessionCenterView.p(viewLifecycleOwner, this.sessionCenterHost);
        Fragment parentFragment2 = getParentFragment();
        ChatPagerFragment chatPagerFragment = parentFragment2 instanceof ChatPagerFragment ? (ChatPagerFragment) parentFragment2 : null;
        if (chatPagerFragment != null && chatPagerFragment.A0()) {
            sessionCenterView.R();
        }
        Fragment parentFragment3 = getParentFragment();
        ChatPagerFragment chatPagerFragment2 = parentFragment3 instanceof ChatPagerFragment ? (ChatPagerFragment) parentFragment3 : null;
        if (chatPagerFragment2 != null && chatPagerFragment2.getSessionCenterGlassSuspended()) {
            sessionCenterView.setGlassSuspended(true);
        }
        G();
        H();
        SheetSettleState sheetSettleStateV = v();
        if (sheetSettleStateV != null) {
            sessionCenterView.S(sheetSettleStateV);
        }
    }
}
