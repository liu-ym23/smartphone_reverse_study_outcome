package com.stepos.agentframework.chatui.task.view;

import Z8.F;
import android.view.View;
import android.widget.PopupWindow;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.agentframework.chatui.task.view.B;
import h8.C4148a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatui/task/view/B;", "", "<init>", "()V", "Landroid/view/View;", "ownerRoot", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/View;)Z", "Landroid/widget/PopupWindow;", "popup", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/widget/PopupWindow;Landroid/view/View;)V", "p", "(Landroid/widget/PopupWindow;)V", "", "Lcom/stepos/agentframework/chatui/task/view/B$a;", "activeEntries", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class B {
    public static final B INSTANCE = new B();
    private static final List<Entry> activeEntries = new ArrayList();

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000eR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/agentframework/chatui/task/view/B$a;", "", "Landroid/widget/PopupWindow;", "popup", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "ownerRoot", "", "layerId", "Lcom/stepos/agentframework/chatui/panelui/i;", "recentsVisibility", "<init>", "(Landroid/widget/PopupWindow;Ljava/lang/ref/WeakReference;Ljava/lang/String;Lcom/stepos/agentframework/chatui/panelui/i;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/widget/PopupWindow;", "c", "()Landroid/widget/PopupWindow;", "Ljava/lang/ref/WeakReference;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/ref/WeakReference;", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/agentframework/chatui/panelui/i;", "getRecentsVisibility", "()Lcom/stepos/agentframework/chatui/panelui/i;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.task.view.B$a, reason: from toString */
    public static final /* data */ class Entry {
        private final String layerId;
        private final WeakReference<View> ownerRoot;
        private final PopupWindow popup;
        private final com.stepos.agentframework.chatui.panelui.i recentsVisibility;

        public Entry(PopupWindow popup, WeakReference<View> ownerRoot, String layerId, com.stepos.agentframework.chatui.panelui.i recentsVisibility) {
            kotlin.jvm.internal.p.i(popup, "popup");
            kotlin.jvm.internal.p.i(ownerRoot, "ownerRoot");
            kotlin.jvm.internal.p.i(layerId, "layerId");
            kotlin.jvm.internal.p.i(recentsVisibility, "recentsVisibility");
            this.popup = popup;
            this.ownerRoot = ownerRoot;
            this.layerId = layerId;
            this.recentsVisibility = recentsVisibility;
        }

        /* renamed from: a, reason: from getter */
        public final String getLayerId() {
            return this.layerId;
        }

        public final WeakReference<View> b() {
            return this.ownerRoot;
        }

        /* renamed from: c, reason: from getter */
        public final PopupWindow getPopup() {
            return this.popup;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return kotlin.jvm.internal.p.d(this.popup, entry.popup) && kotlin.jvm.internal.p.d(this.ownerRoot, entry.ownerRoot) && kotlin.jvm.internal.p.d(this.layerId, entry.layerId) && kotlin.jvm.internal.p.d(this.recentsVisibility, entry.recentsVisibility);
        }

        public int hashCode() {
            return (((((this.popup.hashCode() * 31) + this.ownerRoot.hashCode()) * 31) + this.layerId.hashCode()) * 31) + this.recentsVisibility.hashCode();
        }

        public String toString() {
            return "Entry(popup=" + this.popup + ", ownerRoot=" + this.ownerRoot + ", layerId=" + this.layerId + ", recentsVisibility=" + this.recentsVisibility + ")";
        }
    }

    public static final boolean h(View ownerRoot) {
        Object objB;
        boolean z10 = false;
        for (Entry entry : F.m1(activeEntries)) {
            PopupWindow popup = entry.getPopup();
            View view = entry.b().get();
            if (ownerRoot == null || view == null || view == ownerRoot) {
                if (popup.isShowing()) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        popup.dismiss();
                        z10 = true;
                        objB = Result.b(Y8.t.f7040a);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB = Result.b(C4849c.a(th));
                    }
                    Throwable thE = Result.e(objB);
                    if (thE != null) {
                        C4148a.u("ChatPopupMenuView", "dismissAllForWake failed: " + thE.getMessage(), false, 4, null);
                    }
                }
            }
        }
        Z8.A.L(activeEntries, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(B.i((B.Entry) obj));
            }
        });
        return z10;
    }

    public static final boolean i(Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !it.getPopup().isShowing();
    }

    public static final boolean k(PopupWindow popupWindow, Entry entry) {
        kotlin.jvm.internal.p.i(entry, "entry");
        if (entry.getPopup() != popupWindow && entry.getPopup().isShowing()) {
            return false;
        }
        com.stepos.agentframework.chatui.panelui.f.INSTANCE.c(entry.getLayerId());
        return true;
    }

    public static final boolean l(PopupWindow popupWindow) {
        return popupWindow.isShowing();
    }

    public static final Y8.t m(PopupWindow popupWindow) {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        return Y8.t.f7040a;
    }

    public static final boolean n(com.stepos.agentframework.chatui.panelui.i iVar) {
        return iVar.e();
    }

    public static final boolean o(com.stepos.agentframework.chatui.panelui.i iVar) {
        return iVar.c();
    }

    public static final boolean q(PopupWindow popupWindow, Entry entry) {
        kotlin.jvm.internal.p.i(entry, "entry");
        if (entry.getPopup() != popupWindow) {
            return false;
        }
        com.stepos.agentframework.chatui.panelui.f.INSTANCE.c(entry.getLayerId());
        return true;
    }

    public final void j(final PopupWindow popup, View ownerRoot) {
        kotlin.jvm.internal.p.i(popup, "popup");
        kotlin.jvm.internal.p.i(ownerRoot, "ownerRoot");
        List<Entry> list = activeEntries;
        Z8.A.L(list, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(B.k(popup, (B.Entry) obj));
            }
        });
        com.stepos.agentframework.chatui.panelui.f fVar = com.stepos.agentframework.chatui.panelui.f.INSTANCE;
        String strA = fVar.a("chat_pop_menu");
        final com.stepos.agentframework.chatui.panelui.i iVar = new com.stepos.agentframework.chatui.panelui.i(popup);
        list.add(new Entry(popup, new WeakReference(ownerRoot), strA, iVar));
        fVar.b(strA, PanelHomePolicy.DISMISS_TOP_ONLY, ownerRoot, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.task.view.x
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(B.l(popup));
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.task.view.y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return B.m(popup);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.task.view.z
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(B.n(iVar));
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.task.view.A
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(B.o(iVar));
            }
        });
    }

    public final void p(final PopupWindow popup) {
        kotlin.jvm.internal.p.i(popup, "popup");
        Z8.A.L(activeEntries, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(B.q(popup, (B.Entry) obj));
            }
        });
    }
}
