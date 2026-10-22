package com.stepos.ailauncher.chat.controller;

import Ua.C1060i;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.C3024y7;
import com.stepos.ailauncher.chat.view.O7;
import com.stepos.ailauncher.chat.view.SessionAction;
import com.stepos.ailauncher.chat.view.X8;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 52\u00020\u0001:\u000267B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0015J'\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010 \u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J'\u0010\"\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\"\u0010\u001cJ)\u0010&\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00102\b\b\u0001\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J!\u0010)\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010(\u001a\u00020$H\u0002¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u0004\u0018\u00010+*\u00020\u0018H\u0002¢\u0006\u0004\b,\u0010-R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010.R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010.R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010.¨\u00068"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SidebarSessionActionsController;", "", "Lcom/stepos/ailauncher/chat/controller/SidebarSessionActionsController$b;", "host", "Lkotlin/Function0;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", "<init>", "(Lcom/stepos/ailauncher/chat/controller/SidebarSessionActionsController$b;Lp9/a;)V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "session", "", "rawX", "rawY", "", "D", "(Landroid/view/View;Lcom/stepos/ailauncher/contract/model/search/SidebarSession;FF)Z", "LY8/t;", "r", "()V", "s", "w", "Landroid/content/Context;", "context", "ownerKey", "y", "(Landroid/content/Context;Ljava/lang/Object;Lcom/stepos/ailauncher/contract/model/search/SidebarSession;)V", "", "sessionId", "newTitle", "x", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "m", "success", "", "failedToastRes", "u", "(Landroid/content/Context;ZI)V", "resId", "G", "(Landroid/content/Context;I)V", "Landroidx/fragment/app/r;", "t", "(Landroid/content/Context;)Landroidx/fragment/app/r;", "Lp9/a;", "Lcom/stepos/ailauncher/chat/controller/SidebarSessionActionsController$b;", "Landroid/widget/PopupWindow;", "actionsPopup", "Landroid/widget/PopupWindow;", "deleteDismiss", "renameDismiss", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SidebarSessionActionsController {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "SidebarSessionActions";
    private PopupWindow actionsPopup;
    private InterfaceC5063a<Y8.t> deleteDismiss;
    private b host;
    private InterfaceC5063a<Y8.t> renameDismiss;
    private final InterfaceC5063a<SessionHandler> sessionHandler;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SidebarSessionActionsController$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SidebarSessionActionsController$b;", "", "LUa/M;", Const.INTENT_KEY_APIKEY, "()LUa/M;", "", "sessionId", "LY8/t;", "c", "(Ljava/lang/String;)V", "", ChatTracker.PREVIEW_LOADING, "f", "(Z)V", "Lkotlin/Function0;", "onUpdated", "e", "(Lp9/a;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        Ua.M a();

        void c(String sessionId);

        void e(InterfaceC5063a<Y8.t> onUpdated);

        void f(boolean loading);
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SessionAction.values().length];
            try {
                iArr[SessionAction.Rename.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionAction.Delete.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SidebarSessionActionsController(b host, InterfaceC5063a<? extends SessionHandler> sessionHandler) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(sessionHandler, "sessionHandler");
        this.sessionHandler = sessionHandler;
        this.host = host;
    }

    public static final Y8.t A(SidebarSessionActionsController sidebarSessionActionsController, Context context, String str, String newTitle) {
        kotlin.jvm.internal.p.i(newTitle, "newTitle");
        sidebarSessionActionsController.x(context, str, newTitle);
        return Y8.t.f7040a;
    }

    public static final Y8.t B(SidebarSessionActionsController sidebarSessionActionsController, Context context, String str, String newTitle) {
        kotlin.jvm.internal.p.i(newTitle, "newTitle");
        sidebarSessionActionsController.x(context, str, newTitle);
        return Y8.t.f7040a;
    }

    public static final Y8.t C(SidebarSessionActionsController sidebarSessionActionsController) {
        sidebarSessionActionsController.renameDismiss = null;
        return Y8.t.f7040a;
    }

    public static final Y8.t E(SidebarSessionActionsController sidebarSessionActionsController) {
        b bVar = sidebarSessionActionsController.host;
        if (bVar != null) {
            bVar.c(null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t F(SidebarSessionActionsController sidebarSessionActionsController, Context context, View view, SidebarSession sidebarSession, SessionAction action) {
        kotlin.jvm.internal.p.i(action, "action");
        int i10 = c.$EnumSwitchMapping$0[action.ordinal()];
        if (i10 == 1) {
            com.stepos.ailauncher.chat.trace.f.INSTANCE.e(com.stepos.ailauncher.chat.trace.f.CLICK_SESSION_RENAME);
            kotlin.jvm.internal.p.f(context);
            kotlin.jvm.internal.p.f(view);
            sidebarSessionActionsController.y(context, view, sidebarSession);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            com.stepos.ailauncher.chat.trace.f.INSTANCE.e(com.stepos.ailauncher.chat.trace.f.CLICK_SESSION_DELETE);
            kotlin.jvm.internal.p.f(context);
            kotlin.jvm.internal.p.f(view);
            sidebarSessionActionsController.m(context, view, sidebarSession);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t n(final SidebarSessionActionsController sidebarSessionActionsController, final Context context, SidebarSession sidebarSession) {
        sidebarSessionActionsController.deleteDismiss = null;
        b bVar = sidebarSessionActionsController.host;
        if (bVar == null) {
            return Y8.t.f7040a;
        }
        if (!com.stepos.ailauncher.common.utils.I.INSTANCE.b(context)) {
            sidebarSessionActionsController.G(context, R$string.chat_network_error_retry_later);
            return Y8.t.f7040a;
        }
        Ua.M mA = bVar.a();
        if (mA == null) {
            return Y8.t.f7040a;
        }
        SidebarSessionMutations.INSTANCE.a(mA, sidebarSession.getSessionId(), false, sidebarSessionActionsController.sessionHandler.invoke(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.s1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SidebarSessionActionsController.o(this.f25130a, context, ((Boolean) obj).booleanValue());
            }
        });
        return Y8.t.f7040a;
    }

    public static final Y8.t o(SidebarSessionActionsController sidebarSessionActionsController, Context context, boolean z10) {
        if (z10) {
            b bVar = sidebarSessionActionsController.host;
            if (bVar != null) {
                bVar.e(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.t1
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return SidebarSessionActionsController.p();
                    }
                });
            }
        } else {
            sidebarSessionActionsController.G(context, com.stepos.ailauncher.chat.R$string.chat_history_delete_failed);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t p() {
        return Y8.t.f7040a;
    }

    public static final Y8.t q(SidebarSessionActionsController sidebarSessionActionsController) {
        sidebarSessionActionsController.deleteDismiss = null;
        return Y8.t.f7040a;
    }

    public static final Y8.t v(SidebarSessionActionsController sidebarSessionActionsController) {
        b bVar = sidebarSessionActionsController.host;
        if (bVar != null) {
            bVar.f(false);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t z(FragmentManager fragmentManager) {
        Fragment fragmentL0 = fragmentManager.l0(C3024y7.TAG);
        DialogInterfaceOnCancelListenerC1374l dialogInterfaceOnCancelListenerC1374l = fragmentL0 instanceof DialogInterfaceOnCancelListenerC1374l ? (DialogInterfaceOnCancelListenerC1374l) fragmentL0 : null;
        if (dialogInterfaceOnCancelListenerC1374l != null) {
            dialogInterfaceOnCancelListenerC1374l.dismissAllowingStateLoss();
        }
        return Y8.t.f7040a;
    }

    public final boolean D(View anchor, final SidebarSession session, float rawX, float rawY) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(session, "session");
        b bVar = this.host;
        if (bVar == null) {
            return false;
        }
        PopupWindow popupWindow = this.actionsPopup;
        if (popupWindow != null) {
            if (!popupWindow.isShowing()) {
                popupWindow = null;
            }
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
        bVar.c(session.getSessionId());
        final Context context = anchor.getContext();
        final View rootView = anchor.getRootView();
        this.actionsPopup = O7.c(anchor, rawX, rawY, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.j1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SidebarSessionActionsController.E(this.f25088a);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.l1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SidebarSessionActionsController.F(this.f25095a, context, rootView, session, (SessionAction) obj);
            }
        });
        return true;
    }

    public final void G(Context context, int resId) {
        Toast.makeText(context.getApplicationContext(), resId, 0).show();
    }

    public final void m(final Context context, Object ownerKey, final SidebarSession session) {
        InterfaceC5063a<Y8.t> interfaceC5063a = this.deleteDismiss;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.deleteDismiss = O7.f(context, ownerKey, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.q1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SidebarSessionActionsController.n(this.f25121a, context, session);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.r1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SidebarSessionActionsController.q(this.f25128a);
            }
        });
    }

    public final void r() {
        PopupWindow popupWindow = this.actionsPopup;
        if (popupWindow != null) {
            if (!popupWindow.isShowing()) {
                popupWindow = null;
            }
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
        this.actionsPopup = null;
    }

    public final void s() {
        r();
        InterfaceC5063a<Y8.t> interfaceC5063a = this.deleteDismiss;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.deleteDismiss = null;
        InterfaceC5063a<Y8.t> interfaceC5063a2 = this.renameDismiss;
        if (interfaceC5063a2 != null) {
            interfaceC5063a2.invoke();
        }
        this.renameDismiss = null;
    }

    public final androidx.fragment.app.r t(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof androidx.fragment.app.r) {
                return (androidx.fragment.app.r) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            kotlin.jvm.internal.p.h(context, "getBaseContext(...)");
        }
        return null;
    }

    public final void u(Context context, boolean success, int failedToastRes) {
        b bVar = this.host;
        if (bVar == null) {
            return;
        }
        if (success) {
            bVar.e(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.k1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return SidebarSessionActionsController.v(this.f25092a);
                }
            });
        } else {
            bVar.f(false);
            G(context, failedToastRes);
        }
    }

    public final void w() {
        s();
        this.host = null;
    }

    public final void x(Context context, String sessionId, String newTitle) {
        b bVar = this.host;
        if (bVar == null) {
            return;
        }
        if (!com.stepos.ailauncher.common.utils.I.INSTANCE.b(context)) {
            G(context, com.stepos.ailauncher.chat.R$string.session_rename_failed);
            return;
        }
        Ua.M mA = bVar.a();
        if (mA == null) {
            return;
        }
        bVar.f(true);
        C1060i.d(mA, null, null, new SidebarSessionActionsController$renameSession$1(this, context, this.sessionHandler.invoke(), sessionId, newTitle, null), 3, null);
    }

    public final void y(final Context context, Object ownerKey, SidebarSession session) {
        final String sessionId = session.getSessionId();
        androidx.fragment.app.r rVarT = t(context);
        InterfaceC5063a<Y8.t> interfaceC5063a = null;
        final FragmentManager supportFragmentManager = rVarT != null ? rVarT.getSupportFragmentManager() : null;
        if (supportFragmentManager != null) {
            this.renameDismiss = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.m1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return SidebarSessionActionsController.z(supportFragmentManager);
                }
            };
            if (supportFragmentManager.l0(C3024y7.TAG) != null) {
                return;
            }
            C3024y7 c3024y7A = C3024y7.INSTANCE.a(session.getTitle());
            c3024y7A.x(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.n1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SidebarSessionActionsController.A(this.f25105a, context, sessionId, (String) obj);
                }
            });
            c3024y7A.show(supportFragmentManager, C3024y7.TAG);
            return;
        }
        InterfaceC5063a<Y8.t> interfaceC5063a2 = this.renameDismiss;
        if (interfaceC5063a2 != null) {
            interfaceC5063a2.invoke();
        }
        InterfaceC5063a<Y8.t> interfaceC5063aX = X8.x(context, ownerKey, session.getTitle(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.o1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SidebarSessionActionsController.B(this.f25113a, context, sessionId, (String) obj);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.p1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SidebarSessionActionsController.C(this.f25118a);
            }
        });
        if (interfaceC5063aX == null) {
            C4148a.u(TAG, "Rename dialog not attachable, sessionId=" + sessionId, false, 4, null);
            G(context, com.stepos.ailauncher.chat.R$string.session_rename_failed);
        } else {
            interfaceC5063a = interfaceC5063aX;
        }
        this.renameDismiss = interfaceC5063a;
    }
}
