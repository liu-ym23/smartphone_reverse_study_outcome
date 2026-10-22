package com.stepos.ailauncher.chat.lockscreen;

import E4.FloatCardOptions;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.AbstractC1417G;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.api.FloatCardScene;
import com.stepos.agentframework.floatcard.view.FloatCardContainerView;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.view.C3016y;
import com.stepos.ailauncher.chat.view.ChatView;
import com.stepos.ailauncher.container.api.IOverlayPageHost;
import com.stepos.ailauncher.container.api.IOverlayPageView;
import com.stepos.ailauncher.container.api.OverlayPageDestroyReason;
import com.stepos.ailauncher.floatcard.api.IFloatCardService;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0002,-B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\nJ\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\nJ\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\nJ\u0015\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR$\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c8\u0006@BX\u0086.¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0011\u0010*\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/c;", "", "Lz5/a;", "activity", "Lcom/stepos/ailauncher/chat/lockscreen/c$b;", "config", "<init>", "(Lz5/a;Lcom/stepos/ailauncher/chat/lockscreen/c$b;)V", "LY8/t;", "f", "()V", "Lkotlin/Function0;", "onUnhandledBack", "m", "(Lp9/a;)V", "", "showAlreadyNewChatToast", "n", "(Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "isChangingConfigurations", Const.INTENT_KEY_BACKGROUND_COMMAND, "k", "q", "Lz5/a;", "Lcom/stepos/ailauncher/chat/lockscreen/c$b;", "Lcom/stepos/ailauncher/chat/view/y;", UxipConstants.f30680s, "agentSpaceView", "Lcom/stepos/ailauncher/chat/view/y;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/chat/view/y;", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "floatCardContainer", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "LG4/h;", "floatCardHost", "LG4/h;", "e", "()Z", "isReady", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.lockscreen.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2670c {
    private static final String TAG = "AgentSpaceHostDelegate";
    private final ActivityC6361a activity;
    private C3016y agentSpaceView;
    private final Config config;
    private FloatCardContainerView floatCardContainer;
    private G4.h floatCardHost;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/c$b;", "", "", "lockScreenMode", "", "floatCardHostId", "", "Lcom/stepos/agentframework/floatcard/api/FloatCardScene;", "floatCardScenes", "Lkotlin/Function0;", "LY8/t;", "onClose", "<init>", "(ZLjava/lang/String;Ljava/util/Set;Lp9/a;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "c", "()Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/Set;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Set;", "Lp9/a;", Const.INTENT_KEY_UMID, "()Lp9/a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.lockscreen.c$b, reason: from toString */
    public static final /* data */ class Config {
        private final String floatCardHostId;
        private final Set<FloatCardScene> floatCardScenes;
        private final boolean lockScreenMode;
        private final InterfaceC5063a<Y8.t> onClose;

        /* JADX WARN: Multi-variable type inference failed */
        public Config(boolean z10, String floatCardHostId, Set<? extends FloatCardScene> floatCardScenes, InterfaceC5063a<Y8.t> onClose) {
            kotlin.jvm.internal.p.i(floatCardHostId, "floatCardHostId");
            kotlin.jvm.internal.p.i(floatCardScenes, "floatCardScenes");
            kotlin.jvm.internal.p.i(onClose, "onClose");
            this.lockScreenMode = z10;
            this.floatCardHostId = floatCardHostId;
            this.floatCardScenes = floatCardScenes;
            this.onClose = onClose;
        }

        /* renamed from: a, reason: from getter */
        public final String getFloatCardHostId() {
            return this.floatCardHostId;
        }

        public final Set<FloatCardScene> b() {
            return this.floatCardScenes;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getLockScreenMode() {
            return this.lockScreenMode;
        }

        public final InterfaceC5063a<Y8.t> d() {
            return this.onClose;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return this.lockScreenMode == config.lockScreenMode && kotlin.jvm.internal.p.d(this.floatCardHostId, config.floatCardHostId) && kotlin.jvm.internal.p.d(this.floatCardScenes, config.floatCardScenes) && kotlin.jvm.internal.p.d(this.onClose, config.onClose);
        }

        public int hashCode() {
            return (((((Boolean.hashCode(this.lockScreenMode) * 31) + this.floatCardHostId.hashCode()) * 31) + this.floatCardScenes.hashCode()) * 31) + this.onClose.hashCode();
        }

        public String toString() {
            return "Config(lockScreenMode=" + this.lockScreenMode + ", floatCardHostId=" + this.floatCardHostId + ", floatCardScenes=" + this.floatCardScenes + ", onClose=" + this.onClose + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/lockscreen/c$c", "Lcom/stepos/ailauncher/container/api/IOverlayPageHost;", "", "animate", "LY8/t;", "closeOverlay", "(Z)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.lockscreen.c$c, reason: collision with other inner class name */
    public static final class C0287c implements IOverlayPageHost {
        public C0287c() {
        }

        @Override // com.stepos.ailauncher.container.api.IOverlayPageHost
        public void closeOverlay(boolean animate) {
            C2670c.this.config.d().invoke();
        }

        @Override // com.stepos.ailauncher.container.api.IOverlayPageHost
        public /* bridge */ void flushPendingPageResume() {
            super.flushPendingPageResume();
        }

        @Override // com.stepos.ailauncher.container.api.IOverlayPageHost
        public /* bridge */ void navigateToPage(String str) {
            super.navigateToPage(str);
        }

        @Override // com.stepos.ailauncher.container.api.IOverlayPageHost
        public /* bridge */ void requestOpenOverlay(boolean z10) {
            super.requestOpenOverlay(z10);
        }

        @Override // com.stepos.ailauncher.container.api.IOverlayPageHost
        public /* bridge */ void setContentOwnsHorizontalGesture(boolean z10) {
            super.setContentOwnsHorizontalGesture(z10);
        }

        @Override // com.stepos.ailauncher.container.api.IOverlayPageHost
        public /* bridge */ void setEdgeBackGestureEnabled(boolean z10) {
            super.setEdgeBackGestureEnabled(z10);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/lockscreen/c$d", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.lockscreen.c$d */
    public static final class d extends AbstractC1417G {
        final /* synthetic */ InterfaceC5063a<Y8.t> $onUnhandledBack;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InterfaceC5063a<Y8.t> interfaceC5063a) {
            super(true);
            this.$onUnhandledBack = interfaceC5063a;
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            if (C2670c.this.d().onBackPressed()) {
                return;
            }
            setEnabled(false);
            this.$onUnhandledBack.invoke();
            setEnabled(true);
        }
    }

    public C2670c(ActivityC6361a activity, Config config) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(config, "config");
        this.activity = activity;
        this.config = config;
    }

    public static final Y8.t l(C2670c c2670c, boolean z10, FloatCardOptions options) {
        kotlin.jvm.internal.p.i(options, "options");
        if (options.getHideChatViewOnShow()) {
            c2670c.d().setVisibility(z10 ? 8 : 0);
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void o(C2670c c2670c, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        c2670c.n(z10);
    }

    public static final void p(C2670c c2670c, boolean z10) {
        Object objB;
        Y8.t tVar;
        try {
            Result.Companion companion = Result.INSTANCE;
            ChatView chatView = (ChatView) c2670c.d().findViewById(R$id.agentChatView);
            if (chatView != null) {
                ChatView.L1(chatView, null, null, z10, 3, null);
                tVar = Y8.t.f7040a;
            } else {
                tVar = null;
            }
            objB = Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "startFreshSession failed", thE, false, 8, null);
        }
    }

    public final C3016y d() {
        C3016y c3016y = this.agentSpaceView;
        if (c3016y != null) {
            return c3016y;
        }
        kotlin.jvm.internal.p.A("agentSpaceView");
        return null;
    }

    public final boolean e() {
        return this.agentSpaceView != null;
    }

    public final void f() {
        C3016y c3016y = new C3016y(this.activity, null, 0, 6, null);
        c3016y.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.agentSpaceView = c3016y;
        FloatCardContainerView floatCardContainerView = new FloatCardContainerView(this.activity, null, 0, 6, null);
        floatCardContainerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.floatCardContainer = floatCardContainerView;
        FrameLayout frameLayout = new FrameLayout(this.activity);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(d());
        FloatCardContainerView floatCardContainerView2 = this.floatCardContainer;
        if (floatCardContainerView2 == null) {
            kotlin.jvm.internal.p.A("floatCardContainer");
            floatCardContainerView2 = null;
        }
        frameLayout.addView(floatCardContainerView2);
        this.activity.setContentView(frameLayout);
        k();
        d().setLockScreenMode(this.config.getLockScreenMode());
        d().onPageCreate(new C0287c());
    }

    public final void g(boolean isChangingConfigurations) {
        Y8.t tVar;
        if (e()) {
            if (!isChangingConfigurations) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ChatView chatView = (ChatView) d().findViewById(R$id.agentChatView);
                    if (chatView != null) {
                        chatView.N3();
                        tVar = Y8.t.f7040a;
                    } else {
                        tVar = null;
                    }
                    Result.b(tVar);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
            q();
            d().onPageDestroy(isChangingConfigurations ? OverlayPageDestroyReason.RELAUNCH : OverlayPageDestroyReason.DESTROY);
        }
    }

    public final void h() {
        if (e()) {
            com.stepos.ailauncher.common.utils.C.a(this.activity, false);
            d().onPagePause();
        }
    }

    public final void i() {
        if (e()) {
            com.stepos.ailauncher.common.utils.C.a(this.activity, true);
            IOverlayPageView.onPageResume$default(d(), null, 1, null);
        }
    }

    public final void j() {
        if (e()) {
            d().onPageStop();
        }
    }

    public final void k() {
        if (this.floatCardHost != null) {
            return;
        }
        String floatCardHostId = this.config.getFloatCardHostId();
        ActivityC6361a activityC6361a = this.activity;
        FloatCardContainerView floatCardContainerView = this.floatCardContainer;
        if (floatCardContainerView == null) {
            kotlin.jvm.internal.p.A("floatCardContainer");
            floatCardContainerView = null;
        }
        G4.h hVar = new G4.h(floatCardHostId, 80, activityC6361a, floatCardContainerView, this.config.b(), new p9.p() { // from class: com.stepos.ailauncher.chat.lockscreen.b
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return C2670c.l(this.f25500a, ((Boolean) obj).booleanValue(), (FloatCardOptions) obj2);
            }
        }, null, null, 192, null);
        this.floatCardHost = hVar;
        IFloatCardService iFloatCardService = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class);
        if (iFloatCardService != null) {
            iFloatCardService.registerHost(hVar);
        }
    }

    public final void m(InterfaceC5063a<Y8.t> onUnhandledBack) {
        kotlin.jvm.internal.p.i(onUnhandledBack, "onUnhandledBack");
        this.activity.getOnBackPressedDispatcher().m(this.activity, new d(onUnhandledBack));
    }

    public final void n(final boolean showAlreadyNewChatToast) {
        AgentConfig.INSTANCE.a().v();
        d().post(new Runnable() { // from class: com.stepos.ailauncher.chat.lockscreen.a
            @Override // java.lang.Runnable
            public final void run() {
                C2670c.p(this.f25498a, showAlreadyNewChatToast);
            }
        });
    }

    public final void q() {
        IFloatCardService iFloatCardService;
        G4.h hVar = this.floatCardHost;
        if (hVar != null && (iFloatCardService = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class)) != null) {
            iFloatCardService.unregisterHost(hVar);
        }
        this.floatCardHost = null;
        if (e()) {
            d().setVisibility(0);
        }
    }
}
