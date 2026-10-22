package com.stepos.ailauncher.chat.view;

import Z8.C1173v;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.chat.activity.AmooStoreActivity;
import com.stepos.ailauncher.chat.controller.C2540g;
import com.stepos.ailauncher.chat.controller.InterfaceC2538f;
import com.stepos.ailauncher.chat.controller.SessionCenterListController;
import com.stepos.ailauncher.chat.controller.SessionCenterStoreBadgeController;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.api.repair.IRepairService;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import com.stepos.ailauncher.sheet.R$dimen;
import com.stepos.ailauncher.sheet.SheetSettleState;
import h8.C4148a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001_\u0018\u0000 b2\u00020\u0001:\u0001cB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\r\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u0014J\u0017\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0011H\u0000¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u000e¢\u0006\u0004\b\"\u0010\u0016J\r\u0010#\u001a\u00020\u000e¢\u0006\u0004\b#\u0010\u0016J\r\u0010$\u001a\u00020\u000e¢\u0006\u0004\b$\u0010\u0016J\u0017\u0010'\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u0015\u0010+\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u000e¢\u0006\u0004\b-\u0010\u0016J\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u000eH\u0002¢\u0006\u0004\b0\u0010\u0016J\u0017\u00101\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b1\u0010/J\u0017\u00102\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b2\u0010/J\u0015\u00105\u001a\b\u0012\u0004\u0012\u00020403H\u0002¢\u0006\u0004\b5\u00106J\u0015\u00107\u001a\b\u0012\u0004\u0012\u00020403H\u0002¢\u0006\u0004\b7\u00106J\u0017\u00109\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u0011H\u0002¢\u0006\u0004\b9\u0010\u0014J\u000f\u0010:\u001a\u00020\u000eH\u0002¢\u0006\u0004\b:\u0010\u0016J\u000f\u0010;\u001a\u00020\u000eH\u0002¢\u0006\u0004\b;\u0010\u0016J\u0017\u0010>\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\bD\u0010\u0014J\u000f\u0010E\u001a\u00020\u000eH\u0002¢\u0006\u0004\bE\u0010\u0016J\u001f\u0010F\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\bF\u0010!J\u000f\u0010G\u001a\u00020\u000eH\u0002¢\u0006\u0004\bG\u0010\u0016R\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010VR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010 R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010a¨\u0006d"}, d2 = {"Lcom/stepos/ailauncher/chat/view/SessionCenterView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/stepos/ailauncher/chat/view/P7;", "host", "LY8/t;", "p", "(Landroidx/lifecycle/LifecycleOwner;Lcom/stepos/ailauncher/chat/view/P7;)V", "", "suspended", "setGlassSuspended", "(Z)V", "L", "()V", "Y", "b0", "M", "visible", "o", "animate", "G", "(Z)Z", "searchActive", "Z", "(ZZ)V", "R", "Q", "F", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "setLiveSessionHandler", "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", ExifInterface.LONGITUDE_WEST, "w", "(Landroidx/lifecycle/LifecycleOwner;)V", "n", "z", "t", "", "Landroid/view/View;", "J", "()Ljava/util/List;", ExifInterface.LONGITUDE_EAST, "shown", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "q", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "session", "U", "(Lcom/stepos/ailauncher/contract/model/search/SidebarSession;)V", "Lcom/stepos/ailauncher/chat/view/s8;", "agent", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/stepos/ailauncher/chat/view/s8;)V", "N", "K", "a0", "X", "Ll5/j;", "binding", "Ll5/j;", "Lcom/stepos/ailauncher/chat/controller/SessionCenterListController;", "listController", "Lcom/stepos/ailauncher/chat/controller/SessionCenterListController;", "Lcom/stepos/ailauncher/chat/controller/SessionCenterStoreBadgeController;", "storeBadgeController", "Lcom/stepos/ailauncher/chat/controller/SessionCenterStoreBadgeController;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/stepos/ailauncher/chat/view/P7;", "Lcom/stepos/ailauncher/chat/view/SessionSearchView;", "searchView", "Lcom/stepos/ailauncher/chat/view/SessionSearchView;", "exitingSearchView", "Ljava/lang/Runnable;", "exitingSearchTimeout", "Ljava/lang/Runnable;", "imeVisible", "Lcom/stepos/ailauncher/chat/view/b6;", "chromeGlass", "Lcom/stepos/ailauncher/chat/view/b6;", "com/stepos/ailauncher/chat/view/SessionCenterView$b", "searchHost", "Lcom/stepos/ailauncher/chat/view/SessionCenterView$b;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionCenterView extends FrameLayout {
    private static final long HIDE_OVERLAY_TIMEOUT_SLACK_MS = 100;
    private static final long SEARCH_CROSSFADE_MS = 220;
    private static final String TAG = "SessionCenterView";
    private final l5.j binding;
    private C2773b6 chromeGlass;
    private final Runnable exitingSearchTimeout;
    private SessionSearchView exitingSearchView;
    private P7 host;
    private boolean imeVisible;
    private LifecycleOwner lifecycleOwner;
    private SessionCenterListController listController;
    private final b searchHost;
    private SessionSearchView searchView;
    private SessionCenterStoreBadgeController storeBadgeController;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"com/stepos/ailauncher/chat/view/SessionCenterView$b", "Lcom/stepos/ailauncher/chat/view/d8;", "", "sessionId", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "()V", "c", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC2797d8 {
        public b() {
        }

        @Override // com.stepos.ailauncher.chat.view.InterfaceC2797d8
        public void a() {
            SessionCenterView.O(SessionCenterView.this, false, 1, null);
        }

        @Override // com.stepos.ailauncher.chat.view.InterfaceC2797d8
        public void b(String sessionId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            ChatTracker.INSTANCE.y("sidebar_historychat");
            P7 p72 = SessionCenterView.this.host;
            if (p72 != null) {
                p72.c(sessionId);
            }
        }

        @Override // com.stepos.ailauncher.chat.view.InterfaceC2797d8
        public void c() {
            com.stepos.ailauncher.container.m0.INSTANCE.j();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionCenterView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        l5.j jVarB = l5.j.b(LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.p.h(jVarB, "inflate(...)");
        this.binding = jVarB;
        C2851i7.INSTANCE.b(this, getResources().getDimension(R$dimen.ail_sheet_corner) / getResources().getDisplayMetrics().density);
        this.exitingSearchTimeout = new Runnable() { // from class: com.stepos.ailauncher.chat.view.W7
            @Override // java.lang.Runnable
            public final void run() {
                SessionCenterView.I(this.f26021a);
            }
        };
        this.searchHost = new b();
    }

    public static final void B(SessionCenterView sessionCenterView, View view) {
        AmooStoreActivity.Companion aVar = AmooStoreActivity.INSTANCE;
        Context context = sessionCenterView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        aVar.a(context);
    }

    public static final void C(SessionCenterView sessionCenterView, View view) {
        IRepairService iRepairService;
        AuthManager authManager = AuthManager.INSTANCE;
        Context context = sessionCenterView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (AuthManager.O(authManager, context, false, false, 6, null) && (iRepairService = (IRepairService) D5.a.INSTANCE.a(IRepairService.class)) != null) {
            Context context2 = sessionCenterView.getContext();
            kotlin.jvm.internal.p.h(context2, "getContext(...)");
            iRepairService.openPage(context2);
        }
    }

    public static final void D(SessionCenterView sessionCenterView, View view) {
        P7 p72 = sessionCenterView.host;
        if (p72 != null) {
            p72.e();
        }
    }

    public static /* synthetic */ boolean H(SessionCenterView sessionCenterView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return sessionCenterView.G(z10);
    }

    public static final void I(SessionCenterView sessionCenterView) {
        sessionCenterView.K();
    }

    public static /* synthetic */ void O(SessionCenterView sessionCenterView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        sessionCenterView.N(z10);
    }

    public static final Y8.t P(SessionCenterView sessionCenterView) {
        sessionCenterView.K();
        return Y8.t.f7040a;
    }

    public static final void r(SessionCenterView sessionCenterView, View view) {
        com.stepos.ailauncher.chat.trace.f.INSTANCE.e(com.stepos.ailauncher.chat.trace.f.CLICK_SEARCH);
        P7 p72 = sessionCenterView.host;
        if (p72 != null) {
            p72.g();
        }
    }

    public static final void s(SessionCenterView sessionCenterView, View view) {
        P7 p72 = sessionCenterView.host;
        if (p72 != null) {
            p72.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSessionContentVisible$lambda$0(FrameLayout frameLayout) {
        frameLayout.setVisibility(4);
        frameLayout.setAlpha(1.0f);
    }

    public static final Y8.t u(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final Y8.t v(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final Y8.t x(SessionCenterView sessionCenterView, SidebarSession session) {
        kotlin.jvm.internal.p.i(session, "session");
        sessionCenterView.U(session);
        return Y8.t.f7040a;
    }

    public static final Y8.t y(SessionCenterView sessionCenterView, SidebarAgentItem agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        sessionCenterView.T(agent);
        return Y8.t.f7040a;
    }

    public final void A() {
        this.binding.btnSessionCenterStore.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.Z7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SessionCenterView.B(this.f26054a, view);
            }
        });
        this.binding.btnSessionCenterSettings.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.a8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SessionCenterView.C(this.f26066a, view);
            }
        });
        this.binding.btnSessionCenterClose.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.b8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SessionCenterView.D(this.f26076a, view);
            }
        });
    }

    public final List<View> E() {
        LinearLayout btnSessionCenterSearch = this.binding.btnSessionCenterSearch;
        kotlin.jvm.internal.p.h(btnSessionCenterSearch, "btnSessionCenterSearch");
        ImageView btnSessionCenterNewChat = this.binding.btnSessionCenterNewChat;
        kotlin.jvm.internal.p.h(btnSessionCenterNewChat, "btnSessionCenterNewChat");
        return C1173v.p(btnSessionCenterSearch, btnSessionCenterNewChat);
    }

    public final void F() {
        SessionCenterListController sessionCenterListController = this.listController;
        if (sessionCenterListController != null) {
            sessionCenterListController.e0();
        }
    }

    public final boolean G(boolean animate) {
        if (this.searchView == null) {
            return false;
        }
        N(animate);
        return true;
    }

    public final List<View> J() {
        LinearLayout btnSessionCenterStore = this.binding.btnSessionCenterStore;
        kotlin.jvm.internal.p.h(btnSessionCenterStore, "btnSessionCenterStore");
        ImageView btnSessionCenterSettings = this.binding.btnSessionCenterSettings;
        kotlin.jvm.internal.p.h(btnSessionCenterSettings, "btnSessionCenterSettings");
        ImageView btnSessionCenterClose = this.binding.btnSessionCenterClose;
        kotlin.jvm.internal.p.h(btnSessionCenterClose, "btnSessionCenterClose");
        return C1173v.p(btnSessionCenterStore, btnSessionCenterSettings, btnSessionCenterClose);
    }

    public final void K() {
        SessionSearchView sessionSearchView = this.exitingSearchView;
        if (sessionSearchView == null) {
            return;
        }
        this.exitingSearchView = null;
        removeCallbacks(this.exitingSearchTimeout);
        sessionSearchView.clearAnimation();
        Y();
        ViewParent parent = sessionSearchView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(sessionSearchView);
        }
        sessionSearchView.O();
    }

    public final void L() {
        V(false);
    }

    public final void M() {
        SessionSearchView sessionSearchView = this.searchView;
        if (sessionSearchView != null) {
            sessionSearchView.M();
        }
    }

    public final void N(boolean animate) {
        SessionSearchView sessionSearchView = this.searchView;
        if (sessionSearchView == null) {
            return;
        }
        this.searchView = null;
        P7 p72 = this.host;
        if (p72 != null) {
            p72.d(false);
        }
        sessionSearchView.M();
        if (animate) {
            this.exitingSearchView = sessionSearchView;
            a0(true, true);
            sessionSearchView.C(false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.S7
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return SessionCenterView.P(this.f25956a);
                }
            });
            postDelayed(this.exitingSearchTimeout, 320L);
            return;
        }
        sessionSearchView.clearAnimation();
        ViewParent parent = sessionSearchView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(sessionSearchView);
        }
        sessionSearchView.O();
        a0(true, false);
    }

    public final void Q() {
        SessionCenterListController sessionCenterListController = this.listController;
        if (sessionCenterListController != null) {
            sessionCenterListController.r0();
        }
    }

    public final void R() {
        SessionCenterListController sessionCenterListController = this.listController;
        if (sessionCenterListController != null) {
            sessionCenterListController.s0();
        }
    }

    public final void S(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        int i10 = com.stepos.ailauncher.chat.util.u.a(state) ? 8 : 0;
        this.binding.btnSessionCenterStore.setVisibility(i10);
        this.binding.btnSessionCenterSettings.setVisibility(i10);
        this.binding.btnSessionCenterClose.setVisibility(i10);
    }

    public final void T(SidebarAgentItem agent) {
        InterfaceC2538f interfaceC2538fA = C2540g.a(agent);
        if (interfaceC2538fA != null) {
            P7 p72 = this.host;
            if (p72 != null) {
                p72.a(interfaceC2538fA);
                return;
            }
            return;
        }
        C4148a.u(TAG, "Skip installed agent without assetId: " + agent.getDisplayName(), false, 4, null);
    }

    public final void U(SidebarSession session) {
        ChatTracker.INSTANCE.y("sidebar_historychat");
        P7 p72 = this.host;
        if (p72 != null) {
            p72.f(session);
        }
    }

    public final void V(boolean shown) {
        float f10 = shown ? 1.0f : 0.0f;
        for (View view : E()) {
            view.animate().cancel();
            view.setAlpha(f10);
        }
    }

    public final void W() {
        SessionSearchView sessionSearchView = this.searchView;
        if (sessionSearchView != null) {
            sessionSearchView.clearAnimation();
            ViewParent parent = sessionSearchView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(sessionSearchView);
            }
            sessionSearchView.O();
        }
        this.searchView = null;
        K();
        X();
        SessionCenterListController sessionCenterListController = this.listController;
        if (sessionCenterListController != null) {
            sessionCenterListController.y0();
        }
        this.listController = null;
        SessionCenterStoreBadgeController sessionCenterStoreBadgeController = this.storeBadgeController;
        if (sessionCenterStoreBadgeController != null) {
            sessionCenterStoreBadgeController.d();
        }
        this.storeBadgeController = null;
        this.chromeGlass = null;
        this.lifecycleOwner = null;
        this.host = null;
    }

    public final void X() {
        a0(true, false);
    }

    public final void Y() {
        V(true);
    }

    public final void Z(boolean searchActive, boolean animate) {
        a0(!searchActive, animate);
    }

    public final void a0(boolean visible, boolean animate) {
        l5.j jVar = this.binding;
        Iterator it = C1173v.p(jVar.llTopContainer, jVar.llBottomContainer).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            kotlin.jvm.internal.p.h(next, "next(...)");
            LinearLayout linearLayout = (LinearLayout) next;
            linearLayout.animate().cancel();
            linearLayout.setAlpha(1.0f);
            linearLayout.setVisibility(0);
        }
        final FrameLayout flSessionCenterList = this.binding.flSessionCenterList;
        kotlin.jvm.internal.p.h(flSessionCenterList, "flSessionCenterList");
        flSessionCenterList.animate().cancel();
        if (!animate) {
            flSessionCenterList.setAlpha(1.0f);
            flSessionCenterList.setVisibility(visible ? 0 : 4);
            for (View view : J()) {
                view.animate().cancel();
                view.setAlpha(visible ? 1.0f : 0.0f);
            }
            V(visible);
            return;
        }
        for (View view2 : J()) {
            view2.animate().cancel();
            view2.setAlpha(visible ? 0.0f : view2.getAlpha());
            view2.animate().alpha(visible ? 1.0f : 0.0f).setDuration(220L).start();
        }
        if (visible) {
            if (flSessionCenterList.getVisibility() != 0) {
                flSessionCenterList.setAlpha(0.0f);
                flSessionCenterList.setVisibility(0);
            }
            flSessionCenterList.animate().alpha(1.0f).setDuration(220L).start();
            return;
        }
        if (flSessionCenterList.getVisibility() == 0) {
            flSessionCenterList.animate().alpha(0.0f).setDuration(220L).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.chat.view.R7
                @Override // java.lang.Runnable
                public final void run() {
                    SessionCenterView.setSessionContentVisible$lambda$0(flSessionCenterList);
                }
            }).start();
        } else {
            flSessionCenterList.setVisibility(4);
            flSessionCenterList.setAlpha(1.0f);
        }
    }

    public final void b0() {
        LifecycleOwner lifecycleOwner;
        if (this.searchView == null && this.exitingSearchView == null && (lifecycleOwner = this.lifecycleOwner) != null) {
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            SessionSearchView sessionSearchView = new SessionSearchView(context, null, 0, 6, null);
            this.binding.flSessionCenterSearchHost.addView(sessionSearchView, new FrameLayout.LayoutParams(-1, -1));
            sessionSearchView.n(lifecycleOwner, this.searchHost);
            sessionSearchView.l(this.imeVisible);
            this.searchView = sessionSearchView;
            P7 p72 = this.host;
            if (p72 != null) {
                p72.d(true);
            }
            a0(false, true);
            L();
            SessionSearchView.D(sessionSearchView, true, null, 2, null);
            sessionSearchView.H();
        }
    }

    public final void n() {
        float f10 = getResources().getDisplayMetrics().density;
        this.binding.rvSessionCenter.e(76.0f * f10, 144.0f * f10, 15.2f * f10, f10 * 28.8f);
    }

    public final void o(boolean visible) {
        this.imeVisible = visible;
        SessionSearchView sessionSearchView = this.searchView;
        if (sessionSearchView != null) {
            sessionSearchView.l(visible);
        }
    }

    public final void p(LifecycleOwner owner, P7 host) {
        kotlin.jvm.internal.p.i(owner, "owner");
        kotlin.jvm.internal.p.i(host, "host");
        this.lifecycleOwner = owner;
        this.host = host;
        w(owner);
        z(owner);
        t(owner);
        A();
        q();
    }

    public final void q() {
        this.binding.btnSessionCenterSearch.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.X7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SessionCenterView.r(this.f26029a, view);
            }
        });
        this.binding.btnSessionCenterNewChat.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.Y7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SessionCenterView.s(this.f26040a, view);
            }
        });
    }

    public final void setGlassSuspended(boolean suspended) {
        C2773b6 c2773b6 = this.chromeGlass;
        if (c2773b6 != null) {
            c2773b6.u(suspended);
        }
    }

    public final void setLiveSessionHandler(SessionHandler handler) {
        SessionCenterListController sessionCenterListController = this.listController;
        if (sessionCenterListController != null) {
            sessionCenterListController.A0(handler);
        }
    }

    public final void t(LifecycleOwner owner) {
        C2773b6 c2773b6 = new C2773b6(owner, false, 2, null);
        LinearLayout btnSessionCenterStore = this.binding.btnSessionCenterStore;
        kotlin.jvm.internal.p.h(btnSessionCenterStore, "btnSessionCenterStore");
        ImageView btnSessionCenterSettings = this.binding.btnSessionCenterSettings;
        kotlin.jvm.internal.p.h(btnSessionCenterSettings, "btnSessionCenterSettings");
        ImageView btnSessionCenterClose = this.binding.btnSessionCenterClose;
        kotlin.jvm.internal.p.h(btnSessionCenterClose, "btnSessionCenterClose");
        ImageView btnSessionCenterNewChat = this.binding.btnSessionCenterNewChat;
        kotlin.jvm.internal.p.h(btnSessionCenterNewChat, "btnSessionCenterNewChat");
        C2773b6 c2773b6P = C2773b6.p(c2773b6, new View[]{btnSessionCenterStore, btnSessionCenterSettings, btnSessionCenterClose, btnSessionCenterNewChat}, y7.o.INSTANCE.i(), false, 4, null);
        LinearLayout btnSessionCenterSearch = this.binding.btnSessionCenterSearch;
        kotlin.jvm.internal.p.h(btnSessionCenterSearch, "btnSessionCenterSearch");
        C2773b6 c2773b6N = c2773b6P.n(new View[]{btnSessionCenterSearch}, new SessionCenterView$bindGlass$group$1(K7.INSTANCE));
        LinearLayout llTopContainer = this.binding.llTopContainer;
        kotlin.jvm.internal.p.h(llTopContainer, "llTopContainer");
        c2773b6N.i(new View[]{llTopContainer}, G.a.f43886a.g(), Float.valueOf(getResources().getDimension(R$dimen.ail_sheet_corner) / getResources().getDisplayMetrics().density), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.U7
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SessionCenterView.u((A7.B) obj);
            }
        });
        LinearLayout llBottomContainer = this.binding.llBottomContainer;
        kotlin.jvm.internal.p.h(llBottomContainer, "llBottomContainer");
        C2773b6.j(c2773b6N, new View[]{llBottomContainer}, null, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.V7
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SessionCenterView.v((A7.B) obj);
            }
        }, 6, null);
        this.binding.llTopContainer.forceHasOverlappingRendering(false);
        this.binding.llBottomContainer.forceHasOverlappingRendering(false);
        this.chromeGlass = c2773b6N;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(LifecycleOwner owner) {
        SessionCenterListController sessionCenterListController = new SessionCenterListController(null, 1, 0 == true ? 1 : 0);
        sessionCenterListController.C0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.Q7
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SessionCenterView.x(this.f25938a, (SidebarSession) obj);
            }
        });
        sessionCenterListController.B0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.T7
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SessionCenterView.y(this.f25978a, (SidebarAgentItem) obj);
            }
        });
        ViewportFadeRecyclerView rvSessionCenter = this.binding.rvSessionCenter;
        kotlin.jvm.internal.p.h(rvSessionCenter, "rvSessionCenter");
        sessionCenterListController.X(rvSessionCenter, owner, this.binding.flSessionCenterList);
        this.listController = sessionCenterListController;
        n();
    }

    public final void z(LifecycleOwner owner) {
        SessionCenterStoreBadgeController sessionCenterStoreBadgeController = new SessionCenterStoreBadgeController();
        ImageView ivSessionCenterStoreBadge = this.binding.ivSessionCenterStoreBadge;
        kotlin.jvm.internal.p.h(ivSessionCenterStoreBadge, "ivSessionCenterStoreBadge");
        sessionCenterStoreBadgeController.c(ivSessionCenterStoreBadge, owner);
        this.storeBadgeController = sessionCenterStoreBadgeController;
    }

    public /* synthetic */ SessionCenterView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
