package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.C2963t;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import u4.m;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fBC\u0012\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0013\u0010\u0014R&\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001d\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/chat/view/t;", "", "Lkotlin/Function1;", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "LY8/t;", "onArtifactsClick", "Lu4/m$d;", "onFileTreeClick", "Lkotlin/Function0;", "onAutoReadToggle", "<init>", "(Lp9/l;Lp9/l;Lp9/a;)V", "e", "()V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "artifacts", "fileTree", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/View;Ljava/util/List;Lu4/m$d;)V", "Lp9/l;", "Lp9/a;", "Landroid/widget/PopupWindow;", "popup", "Landroid/widget/PopupWindow;", "", "f", "()Z", "isShowing", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2963t {
    private static final float MENU_CORNER_DP = 24.0f;
    private static final String TAG = "AgentMoreMenuPopup";
    private final InterfaceC5074l<List<SessionArtifact>, Y8.t> onArtifactsClick;
    private final InterfaceC5063a<Y8.t> onAutoReadToggle;
    private final InterfaceC5074l<m.FolderMessage, Y8.t> onFileTreeClick;
    private PopupWindow popup;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Companion.Showing> showingMenus = new ArrayList();

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/view/t$a;", "", "<init>", "()V", "Landroid/view/View;", "ownerRoot", "", "f", "(Landroid/view/View;)Z", "Lcom/stepos/ailauncher/chat/view/t;", ChatTracker.TOPBAR_MENU, "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/View;Lcom/stepos/ailauncher/chat/view/t;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/chat/view/t;)V", "", "TAG", "Ljava/lang/String;", "", "MENU_CORNER_DP", "F", "", "Lcom/stepos/ailauncher/chat/view/t$a$a;", "showingMenus", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.t$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/view/t$a$a;", "", "Lcom/stepos/ailauncher/chat/view/t;", ChatTracker.TOPBAR_MENU, "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "ownerRoot", "<init>", "(Lcom/stepos/ailauncher/chat/view/t;Ljava/lang/ref/WeakReference;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/chat/view/t;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/view/t;", "Ljava/lang/ref/WeakReference;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/ref/WeakReference;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.view.t$a$a, reason: collision with other inner class name and from toString */
        public static final /* data */ class Showing {
            private final C2963t menu;
            private final WeakReference<View> ownerRoot;

            public Showing(C2963t menu, WeakReference<View> ownerRoot) {
                kotlin.jvm.internal.p.i(menu, "menu");
                kotlin.jvm.internal.p.i(ownerRoot, "ownerRoot");
                this.menu = menu;
                this.ownerRoot = ownerRoot;
            }

            /* renamed from: a, reason: from getter */
            public final C2963t getMenu() {
                return this.menu;
            }

            public final WeakReference<View> b() {
                return this.ownerRoot;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Showing)) {
                    return false;
                }
                Showing showing = (Showing) other;
                return kotlin.jvm.internal.p.d(this.menu, showing.menu) && kotlin.jvm.internal.p.d(this.ownerRoot, showing.ownerRoot);
            }

            public int hashCode() {
                return (this.menu.hashCode() * 31) + this.ownerRoot.hashCode();
            }

            public String toString() {
                return "Showing(menu=" + this.menu + ", ownerRoot=" + this.ownerRoot + ")";
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final boolean g(Showing it) {
            kotlin.jvm.internal.p.i(it, "it");
            return !it.getMenu().f();
        }

        public static final boolean i(C2963t c2963t, Showing it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.getMenu() == c2963t || !it.getMenu().f();
        }

        public static final boolean k(C2963t c2963t, Showing it) {
            kotlin.jvm.internal.p.i(it, "it");
            return it.getMenu() == c2963t;
        }

        public final boolean f(View ownerRoot) {
            boolean z10 = false;
            for (Showing showing : Z8.F.m1(C2963t.showingMenus)) {
                View view = showing.b().get();
                if (ownerRoot == null || view == null || view == ownerRoot) {
                    if (showing.getMenu().f()) {
                        showing.getMenu().e();
                        z10 = true;
                    }
                }
            }
            Z8.A.L(C2963t.showingMenus, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.s
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C2963t.Companion.g((C2963t.Companion.Showing) obj));
                }
            });
            return z10;
        }

        public final void h(View ownerRoot, final C2963t menu) {
            Z8.A.L(C2963t.showingMenus, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.q
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C2963t.Companion.i(menu, (C2963t.Companion.Showing) obj));
                }
            });
            C2963t.showingMenus.add(new Showing(menu, new WeakReference(ownerRoot)));
        }

        public final void j(final C2963t menu) {
            Z8.A.L(C2963t.showingMenus, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.r
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C2963t.Companion.k(menu, (C2963t.Companion.Showing) obj));
                }
            });
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C2963t(InterfaceC5074l<? super List<SessionArtifact>, Y8.t> onArtifactsClick, InterfaceC5074l<? super m.FolderMessage, Y8.t> onFileTreeClick, InterfaceC5063a<Y8.t> onAutoReadToggle) {
        kotlin.jvm.internal.p.i(onArtifactsClick, "onArtifactsClick");
        kotlin.jvm.internal.p.i(onFileTreeClick, "onFileTreeClick");
        kotlin.jvm.internal.p.i(onAutoReadToggle, "onAutoReadToggle");
        this.onArtifactsClick = onArtifactsClick;
        this.onFileTreeClick = onFileTreeClick;
        this.onAutoReadToggle = onAutoReadToggle;
    }

    public static final void h(C2963t c2963t, m.FolderMessage folderMessage, List list, View view) {
        c2963t.e();
        if (folderMessage != null) {
            c2963t.onFileTreeClick.invoke(folderMessage);
        } else {
            c2963t.onArtifactsClick.invoke(list);
        }
    }

    public static final void i(C2963t c2963t, View view) {
        c2963t.e();
        c2963t.onAutoReadToggle.invoke();
    }

    public static final Y8.t j(C2963t c2963t) {
        INSTANCE.j(c2963t);
        return Y8.t.f7040a;
    }

    public final void e() {
        PopupWindow popupWindow = this.popup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final boolean f() {
        PopupWindow popupWindow = this.popup;
        return popupWindow != null && popupWindow.isShowing();
    }

    public final void g(View anchor, final List<SessionArtifact> artifacts, final m.FolderMessage fileTree) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(artifacts, "artifacts");
        int i10 = 0;
        if (!anchor.isAttachedToWindow() || anchor.getWindowToken() == null) {
            C4148a.u(TAG, "skip show: anchor not attached or token null", false, 4, null);
            return;
        }
        Context context = anchor.getContext();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        int i11 = R$layout.popup_agent_more_menu;
        View rootView = anchor.getRootView();
        View viewInflate = layoutInflaterFrom.inflate(i11, rootView instanceof ViewGroup ? (ViewGroup) rootView : null, false);
        View viewFindViewById = viewInflate.findViewById(R$id.item_menu_artifacts);
        if (artifacts.isEmpty() && fileTree == null) {
            i10 = 8;
        }
        viewFindViewById.setVisibility(i10);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2963t.h(this.f26254a, fileTree, artifacts, view);
            }
        });
        com.stepos.agentframework.util.E eA = com.stepos.agentframework.util.E.INSTANCE.a();
        kotlin.jvm.internal.p.f(context);
        ((ImageView) viewInflate.findViewById(R$id.iv_menu_auto_read)).setImageResource(com.stepos.agentframework.util.E.e(eA, context, com.stepos.agentframework.util.C.INSTANCE.b(), false, null, 12, null) ? R$drawable.bg_assistant_icon_right : R$drawable.bg_assistant_icon_right_mute);
        viewInflate.findViewById(R$id.item_menu_auto_read).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2963t.i(this.f26271a, view);
            }
        });
        float f10 = (-anchor.getHeight()) / anchor.getResources().getDisplayMetrics().density;
        kotlin.jvm.internal.p.f(viewInflate);
        PopupWindow popupWindowI = R5.i(anchor, viewInflate, 24.0f, f10, false, false, false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C2963t.j(this.f26285a);
            }
        }, 96, null);
        this.popup = popupWindowI;
        if (popupWindowI == null || !popupWindowI.isShowing()) {
            return;
        }
        Companion companion = INSTANCE;
        View rootView2 = anchor.getRootView();
        kotlin.jvm.internal.p.h(rootView2, "getRootView(...)");
        companion.h(rootView2, this);
    }
}
