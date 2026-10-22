package com.stepos.ailauncher.chat.controller;

import Ua.C1060i;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.view.AgentAction;
import com.stepos.ailauncher.chat.view.C2788d;
import com.stepos.ailauncher.chat.view.SidebarAgentItem;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0012J/\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u001f\u0010!\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010)¨\u0006,"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SidebarAgentActionsController;", "", "Lcom/stepos/ailauncher/chat/controller/SidebarAgentActionsController$a;", "host", "<init>", "(Lcom/stepos/ailauncher/chat/controller/SidebarAgentActionsController$a;)V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "Lcom/stepos/ailauncher/chat/view/s8;", "agent", "", "rawX", "rawY", "", "u", "(Landroid/view/View;Lcom/stepos/ailauncher/chat/view/s8;FF)Z", "LY8/t;", "q", "()V", "r", "t", "Landroid/content/Context;", "context", "ownerKey", "Lcom/stepos/ailauncher/chat/view/AgentAction;", "action", "s", "(Landroid/content/Context;Ljava/lang/Object;Lcom/stepos/ailauncher/chat/view/s8;Lcom/stepos/ailauncher/chat/view/AgentAction;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;Ljava/lang/Object;Lcom/stepos/ailauncher/chat/view/s8;)V", "m", "", "resId", "x", "(Landroid/content/Context;I)V", "Lcom/stepos/ailauncher/chat/controller/SidebarAgentActionsController$a;", "Landroid/widget/PopupWindow;", "actionsPopup", "Landroid/widget/PopupWindow;", "Lkotlin/Function0;", "disconnectDismiss", "Lp9/a;", "uninstallDismiss", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SidebarAgentActionsController {
    private PopupWindow actionsPopup;
    private InterfaceC5063a<Y8.t> disconnectDismiss;
    private a host;
    private InterfaceC5063a<Y8.t> uninstallDismiss;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/controller/SidebarAgentActionsController$a;", "", "LUa/M;", Const.INTENT_KEY_APIKEY, "()LUa/M;", "Lcom/stepos/ailauncher/chat/view/s8;", "agent", "LY8/t;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/view/s8;)V", "", "assetId", "", "uninstalling", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        Ua.M a();

        void d(SidebarAgentItem agent);

        void g(String assetId, boolean uninstalling);

        void h();
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentAction.values().length];
            try {
                iArr[AgentAction.Disconnect.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentAction.Uninstall.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SidebarAgentActionsController(a host) {
        kotlin.jvm.internal.p.i(host, "host");
        this.host = host;
    }

    public static final Y8.t k(SidebarAgentItem sidebarAgentItem, SidebarAgentActionsController sidebarAgentActionsController, Context context) {
        Ua.M mA;
        com.stepos.ailauncher.chat.trace.f.INSTANCE.a("confirm", sidebarAgentItem.getAgentId(), sidebarAgentItem.getAgentId());
        sidebarAgentActionsController.disconnectDismiss = null;
        a aVar = sidebarAgentActionsController.host;
        if (aVar != null && (mA = aVar.a()) != null) {
            C1060i.d(mA, null, null, new SidebarAgentActionsController$confirmAndDisconnect$1$1(sidebarAgentActionsController, context, sidebarAgentItem, null), 3, null);
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t l(SidebarAgentItem sidebarAgentItem, SidebarAgentActionsController sidebarAgentActionsController) {
        com.stepos.ailauncher.chat.trace.f.INSTANCE.a("cancel", sidebarAgentItem.getAgentId(), sidebarAgentItem.getAgentId());
        sidebarAgentActionsController.disconnectDismiss = null;
        return Y8.t.f7040a;
    }

    public static final Y8.t n(final String str, final SidebarAgentActionsController sidebarAgentActionsController, final Context context, SidebarAgentItem sidebarAgentItem) {
        com.stepos.ailauncher.chat.trace.f.INSTANCE.d("confirm", str);
        sidebarAgentActionsController.uninstallDismiss = null;
        a aVar = sidebarAgentActionsController.host;
        if (aVar == null) {
            return Y8.t.f7040a;
        }
        aVar.g(str, true);
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService != null) {
            iExternalAgentBindService.uninstallInstalledAgent(str, sidebarAgentItem.getReversionId(), sidebarAgentItem.getSemver(), sidebarAgentItem.getDisplayName(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.i1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SidebarAgentActionsController.o(this.f25081a, context, str, ((Boolean) obj).booleanValue());
                }
            });
            return Y8.t.f7040a;
        }
        aVar.g(str, false);
        sidebarAgentActionsController.x(context, R$string.sidebar_agent_uninstall_failed);
        return Y8.t.f7040a;
    }

    public static final Y8.t o(SidebarAgentActionsController sidebarAgentActionsController, Context context, String str, boolean z10) {
        sidebarAgentActionsController.x(context, z10 ? R$string.sidebar_agent_uninstall_done : R$string.sidebar_agent_uninstall_failed);
        a aVar = sidebarAgentActionsController.host;
        if (aVar != null) {
            aVar.g(str, false);
            aVar.h();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t p(String str, SidebarAgentActionsController sidebarAgentActionsController) {
        com.stepos.ailauncher.chat.trace.f.INSTANCE.d("cancel", str);
        sidebarAgentActionsController.uninstallDismiss = null;
        return Y8.t.f7040a;
    }

    public static final Y8.t v(SidebarAgentActionsController sidebarAgentActionsController) {
        a aVar = sidebarAgentActionsController.host;
        if (aVar != null) {
            aVar.d(null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t w(SidebarAgentActionsController sidebarAgentActionsController, Context context, View view, SidebarAgentItem sidebarAgentItem, AgentAction action) {
        kotlin.jvm.internal.p.i(action, "action");
        kotlin.jvm.internal.p.f(context);
        kotlin.jvm.internal.p.f(view);
        sidebarAgentActionsController.s(context, view, sidebarAgentItem, action);
        return Y8.t.f7040a;
    }

    public final void j(final Context context, Object ownerKey, final SidebarAgentItem agent) {
        InterfaceC5063a<Y8.t> interfaceC5063a = this.disconnectDismiss;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.disconnectDismiss = C2788d.e(context, ownerKey, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.e1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SidebarAgentActionsController.k(agent, this, context);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.f1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SidebarAgentActionsController.l(agent, this);
            }
        });
    }

    public final void m(final Context context, Object ownerKey, final SidebarAgentItem agent) {
        final String assetId = agent.getAssetId();
        if (La.H.x0(assetId)) {
            assetId = null;
        }
        if (assetId == null) {
            return;
        }
        InterfaceC5063a<Y8.t> interfaceC5063a = this.uninstallDismiss;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.uninstallDismiss = C2788d.f(context, ownerKey, agent.getDisplayName(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.g1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SidebarAgentActionsController.n(assetId, this, context, agent);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.h1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SidebarAgentActionsController.p(assetId, this);
            }
        });
    }

    public final void q() {
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

    public final void r() {
        q();
        InterfaceC5063a<Y8.t> interfaceC5063a = this.disconnectDismiss;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        this.disconnectDismiss = null;
        InterfaceC5063a<Y8.t> interfaceC5063a2 = this.uninstallDismiss;
        if (interfaceC5063a2 != null) {
            interfaceC5063a2.invoke();
        }
        this.uninstallDismiss = null;
    }

    public final void s(Context context, Object ownerKey, SidebarAgentItem agent, AgentAction action) {
        String str;
        com.stepos.ailauncher.chat.trace.f fVar = com.stepos.ailauncher.chat.trace.f.INSTANCE;
        int[] iArr = b.$EnumSwitchMapping$0;
        int i10 = iArr[action.ordinal()];
        if (i10 == 1) {
            str = "disconnect";
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = "uninstall";
        }
        fVar.c(str, agent.getAgentId(), agent.getAgentId());
        int i11 = iArr[action.ordinal()];
        if (i11 == 1) {
            j(context, ownerKey, agent);
        } else {
            if (i11 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            m(context, ownerKey, agent);
        }
    }

    public final void t() {
        r();
        this.host = null;
    }

    public final boolean u(View anchor, final SidebarAgentItem agent, float rawX, float rawY) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(agent, "agent");
        a aVar = this.host;
        if (aVar == null) {
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
        aVar.d(agent);
        final Context context = anchor.getContext();
        final View rootView = anchor.getRootView();
        PopupWindow popupWindowC = C2788d.c(anchor, agent, rawX, rawY, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.controller.c1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SidebarAgentActionsController.v(this.f25058a);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.d1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SidebarAgentActionsController.w(this.f25060a, context, rootView, agent, (AgentAction) obj);
            }
        });
        this.actionsPopup = popupWindowC;
        if (popupWindowC != null) {
            return true;
        }
        aVar.d(null);
        return false;
    }

    public final void x(Context context, int resId) {
        Toast.makeText(context.getApplicationContext(), resId, 0).show();
    }
}
