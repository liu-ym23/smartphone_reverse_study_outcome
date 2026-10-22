package com.stepos.ailauncher.chat.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.C2851i7;
import com.stepos.ailauncher.chat.view.GlassAttachment;
import com.stepos.ailauncher.chat.view.InterfaceC2797d8;
import com.stepos.ailauncher.chat.view.SessionSearchView;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.container.glass.SheetGlassStyle;
import com.stepos.ailauncher.sheet.SheetSettleState;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00017\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001f\u0010\u0003J\u0017\u0010 \u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010!J#\u0010%\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R \u00105\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0013048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u0004\u0018\u00010:8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/g2;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "N", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "M", "k", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "", "progress", "f", "(F)V", "onResume", "onPause", "onDestroyView", "G", "(Landroid/view/View;)V", "", "rebind", "force", ExifInterface.LONGITUDE_EAST, "(ZZ)V", "Lcom/stepos/ailauncher/chat/view/GlassAttachment;", "rootGlass", "Lcom/stepos/ailauncher/chat/view/GlassAttachment;", "rootGlassStyle", "Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "", "rootGlassTint", "I", "rootGlassBlurPx", "F", "Lcom/stepos/ailauncher/container/glass/j;", "rootGlassCommit", "Lcom/stepos/ailauncher/container/glass/j;", "Lkotlin/Function1;", "imeLift", "Lp9/l;", "com/stepos/ailauncher/chat/fragment/g2$b", "searchHost", "Lcom/stepos/ailauncher/chat/fragment/g2$b;", "Lcom/stepos/ailauncher/chat/view/SessionSearchView;", "J", "()Lcom/stepos/ailauncher/chat/view/SessionSearchView;", "searchPage", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g2 extends com.stepos.ailauncher.sheet.nav.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float ROOT_GLASS_CORNER_DP = 28.0f;
    private final InterfaceC5074l<Integer, Y8.t> imeLift;
    private GlassAttachment rootGlass;
    private float rootGlassBlurPx;
    private final com.stepos.ailauncher.container.glass.j rootGlassCommit;
    private SheetGlassStyle rootGlassStyle;
    private int rootGlassTint;
    private final b searchHost;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/g2$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/fragment/g2;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/fragment/g2;", "", "ROOT_GLASS_CORNER_DP", "F", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.g2$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final g2 a() {
            return new g2();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/fragment/g2$b", "Lcom/stepos/ailauncher/chat/view/d8;", "", "sessionId", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC2797d8 {
        public b() {
        }

        @Override // com.stepos.ailauncher.chat.view.InterfaceC2797d8
        public void a() {
            androidx.fragment.app.r activity = g2.this.getActivity();
            ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
            if (chatActivity != null) {
                chatActivity.e7();
            }
        }

        @Override // com.stepos.ailauncher.chat.view.InterfaceC2797d8
        public void b(String sessionId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            ChatTracker.INSTANCE.y("sidebar_historychat");
            androidx.fragment.app.r activity = g2.this.getActivity();
            ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
            if (chatActivity != null) {
                chatActivity.aa(sessionId, true);
            }
        }

        @Override // com.stepos.ailauncher.chat.view.InterfaceC2797d8
        public /* bridge */ void c() {
            super.c();
        }
    }

    public g2() {
        SheetGlassStyle sheetGlassStyle = SheetGlassStyle.HALF;
        this.rootGlassStyle = sheetGlassStyle;
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        this.rootGlassTint = c2851i7.l(sheetGlassStyle);
        this.rootGlassBlurPx = c2851i7.j(sheetGlassStyle);
        this.rootGlassCommit = new com.stepos.ailauncher.container.glass.j(0L, 1, null);
        this.imeLift = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.d2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g2.K(this.f25253a, ((Integer) obj).intValue());
            }
        };
        this.searchHost = new b();
    }

    public static /* synthetic */ void F(g2 g2Var, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        g2Var.E(z10, z11);
    }

    public static final float H(View it) {
        kotlin.jvm.internal.p.i(it, "it");
        return 0.0f;
    }

    public static final y7.E I(g2 g2Var, View v10, boolean z10, Float f10, y7.o oVar) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(oVar, "<unused var>");
        return C2851i7.INSTANCE.g(v10, g2Var.rootGlassTint, g2Var.rootGlassBlurPx, z10, f10);
    }

    public static final Y8.t K(g2 g2Var, int i10) {
        SessionSearchView sessionSearchViewJ = g2Var.J();
        if (sessionSearchViewJ != null) {
            sessionSearchViewJ.m(i10);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t L(View view, g2 g2Var, SessionSearchView sessionSearchView) {
        if (!((SessionSearchView) view).isAttachedToWindow()) {
            return Y8.t.f7040a;
        }
        g2Var.G(view);
        sessionSearchView.H();
        return Y8.t.f7040a;
    }

    private final SheetGlassStyle N(SheetSettleState state) {
        return state == SheetSettleState.FULL ? SheetGlassStyle.FULL : SheetGlassStyle.HALF;
    }

    public static /* synthetic */ SheetGlassStyle O(g2 g2Var, SheetSettleState sheetSettleState, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            sheetSettleState = g2Var.s();
        }
        return g2Var.N(sheetSettleState);
    }

    public final void E(boolean rebind, boolean force) {
        GlassAttachment glassAttachment;
        com.stepos.ailauncher.sheet.S sT = t();
        Pair<Integer, Float> pairK = C2851i7.INSTANCE.k(sT != null ? sT.W1() : this.rootGlassStyle == SheetGlassStyle.FULL ? 1.0f : 0.0f);
        int iIntValue = pairK.a().intValue();
        float fFloatValue = pairK.b().floatValue();
        if (iIntValue != this.rootGlassTint || Math.abs(fFloatValue - this.rootGlassBlurPx) >= 0.5f) {
            if (!rebind || this.rootGlassCommit.a(force)) {
                this.rootGlassTint = iIntValue;
                this.rootGlassBlurPx = fFloatValue;
                if (!rebind || (glassAttachment = this.rootGlass) == null) {
                    return;
                }
                glassAttachment.p();
            }
        }
    }

    public final void G(View view) {
        this.rootGlassStyle = O(this, null, 1, null);
        F(this, false, false, 2, null);
        this.rootGlass = new GlassAttachment(view, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.e2
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Float.valueOf(g2.H((View) obj));
            }
        }, null, null, new p9.r() { // from class: com.stepos.ailauncher.chat.fragment.f2
            @Override // p9.r
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return g2.I(this.f25271a, (View) obj, ((Boolean) obj2).booleanValue(), (Float) obj3, (y7.o) obj4);
            }
        }, 24, null).t();
        C2851i7.INSTANCE.b(view, 28.0f);
    }

    public final SessionSearchView J() {
        View view = getView();
        if (view instanceof SessionSearchView) {
            return (SessionSearchView) view;
        }
        return null;
    }

    public final void M() {
        GlassAttachment glassAttachment = this.rootGlass;
        if (glassAttachment != null) {
            glassAttachment.n();
        }
        this.rootGlass = null;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void f(float progress) {
        F(this, false, false, 3, null);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void k(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        this.rootGlassStyle = N(state);
        F(this, false, true, 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(inflater, "inflater");
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        SessionSearchView sessionSearchView = new SessionSearchView(contextRequireContext, null, 0, 6, null);
        sessionSearchView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return sessionSearchView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() throws Resources.NotFoundException {
        com.stepos.ailauncher.sheet.S sT = t();
        if (sT != null) {
            sT.e1(null);
        }
        SessionSearchView sessionSearchViewJ = J();
        if (sessionSearchViewJ != null) {
            sessionSearchViewJ.O();
        }
        GlassAttachment glassAttachment = this.rootGlass;
        if (glassAttachment != null) {
            glassAttachment.n();
        }
        this.rootGlass = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() throws Resources.NotFoundException {
        SessionSearchView sessionSearchViewJ = J();
        if (sessionSearchViewJ != null) {
            sessionSearchViewJ.M();
        }
        com.stepos.ailauncher.sheet.S sT = t();
        if (sT != null) {
            sT.e1(null);
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        com.stepos.ailauncher.sheet.S sT = t();
        if (sT != null) {
            sT.e1(this.imeLift);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final SessionSearchView sessionSearchView = view instanceof SessionSearchView ? (SessionSearchView) view : null;
        if (sessionSearchView == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        sessionSearchView.n(viewLifecycleOwner, this.searchHost);
        Fragment parentFragment = getParentFragment();
        SessionCenterFragment sessionCenterFragment = parentFragment instanceof SessionCenterFragment ? (SessionCenterFragment) parentFragment : null;
        if (sessionCenterFragment != null) {
            sessionCenterFragment.L();
        }
        sessionSearchView.C(true, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.c2
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g2.L(view, this, sessionSearchView);
            }
        });
    }
}
