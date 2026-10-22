package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.activity.C2436g;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.sla.SlaChatController;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.sla.SlaRouter;
import com.stepos.ailauncher.sla.SlaVoiceBridge;
import h8.C4148a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import y4.InterfaceC5940b;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\fJ\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/chat/view/HomeInputView;", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "onAttachedToWindow", "()V", "onDetachedFromWindow", "", "y6", "()Z", "td", "ud", "x6", "U7", "O8", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sd", "()Lcom/stepos/agentframework/chatcore/SessionHandler;", "Lcom/stepos/ailauncher/chat/wake/effect/c;", "spectrumController", "Lcom/stepos/ailauncher/chat/wake/effect/c;", "Lcom/stepos/ailauncher/chat/view/sla/SlaChatController;", "slaController", "Lcom/stepos/ailauncher/chat/view/sla/SlaChatController;", "Landroid/view/View;", "spectrumView", "Landroid/view/View;", "getSpectrumView", "()Landroid/view/View;", "setSpectrumView", "(Landroid/view/View;)V", "Companion", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeInputView extends BaseInputView {
    private static final String TAG = "HomeInputView";
    private SlaChatController slaController;
    private com.stepos.ailauncher.chat.wake.effect.c spectrumController;
    private View spectrumView;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J?\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/chat/view/HomeInputView$a", "Ly4/b$f;", "", "message", "", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "images", "", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements InterfaceC5940b.f {
        final /* synthetic */ Context $context;

        public a(Context context) {
            this.$context = context;
        }

        @Override // y4.InterfaceC5940b.f
        public void a(String message, List<FileInfo> images, Map<String, String> params) {
            int length = message != null ? message.length() : -1;
            int size = images != null ? images.size() : 0;
            C4148a.k("DIAG-WAKE-NOSEND", "HomeInputView.onClicked text='" + message + "' textLen=" + length + " imgs=" + size + " this=" + System.identityHashCode(HomeInputView.this), false, 4, null);
            ChatTracker.INSTANCE.y("home_inputbar");
            WakeService.Companion companion = WakeService.INSTANCE;
            companion.m1(true);
            AgentConfig.INSTANCE.a().w(HomeInputView.this.sd());
            companion.L1(this.$context, message, images, true, "home");
            HomeInputView.this.b(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HomeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView
    public void O8() throws Resources.NotFoundException {
        if (U7()) {
            AuthManager authManager = AuthManager.INSTANCE;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            if (C2436g.INSTANCE.a(AuthManager.O(authManager, context, false, false, 6, null), authManager.x0())) {
                n6();
            }
        }
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView
    public boolean U7() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            String name = context.getClass().getName();
            kotlin.jvm.internal.p.h(name, "getName(...)");
            if (La.H.g0(name, ".oobe.", false, 2, null)) {
                return false;
            }
        }
        return true;
    }

    public final View getSpectrumView() {
        return this.spectrumView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.ailauncher.chat.view.BaseInputView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = this.spectrumView;
        if (view != null) {
            com.stepos.ailauncher.chat.wake.effect.c cVar = new com.stepos.ailauncher.chat.wake.effect.c(view, null, 2, 0 == true ? 1 : 0);
            cVar.d(this);
            this.spectrumController = cVar;
        }
        td();
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.stepos.ailauncher.chat.wake.effect.c cVar = this.spectrumController;
        if (cVar != null) {
            cVar.h();
        }
        this.spectrumController = null;
        ud();
    }

    public final SessionHandler sd() {
        SessionHandler sessionHandler = getSessionHandler();
        if (sessionHandler != null) {
            return sessionHandler;
        }
        SessionHandler sessionHandlerQ = AgentConfig.INSTANCE.a().q();
        b(sessionHandlerQ);
        return sessionHandlerQ;
    }

    public final void setSpectrumView(View view) {
        this.spectrumView = view;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void td() {
        /*
            r8 = this;
            com.stepos.ailauncher.sla.SlaRouter r0 = com.stepos.ailauncher.sla.SlaRouter.INSTANCE
            android.content.Context r1 = r8.getContext()
            java.lang.String r2 = "getContext(...)"
            kotlin.jvm.internal.p.h(r1, r2)
            boolean r0 = r0.v(r1)
            r1 = 4
            r3 = 0
            java.lang.String r4 = "HomeInputView"
            r5 = 0
            if (r0 != 0) goto L1c
            java.lang.String r8 = "bindSlaVoiceBridgeIfNeeded skip: sla unavailable"
            h8.C4148a.k(r4, r8, r3, r1, r5)
            return
        L1c:
            com.stepos.ailauncher.sla.SlaVoiceBridge r0 = com.stepos.ailauncher.sla.SlaVoiceBridge.INSTANCE
            boolean r0 = r0.t()
            if (r0 == 0) goto L2a
            java.lang.String r8 = "bindSlaVoiceBridgeIfNeeded skip: chat layout holds gate"
            h8.C4148a.k(r4, r8, r3, r1, r5)
            return
        L2a:
            com.stepos.agentframework.chatcore.SessionHandler r0 = r8.getSessionHandler()
            if (r0 != 0) goto L34
            com.stepos.agentframework.chatcore.SessionHandler r0 = r8.sd()
        L34:
            com.stepos.ailauncher.chat.view.sla.SlaChatController r6 = r8.slaController
            if (r6 == 0) goto L42
            boolean r7 = r6.B0(r0)
            if (r7 == 0) goto L3f
            goto L40
        L3f:
            r6 = r5
        L40:
            if (r6 != 0) goto L50
        L42:
            com.stepos.ailauncher.chat.view.sla.SlaChatController r6 = new com.stepos.ailauncher.chat.view.sla.SlaChatController
            android.content.Context r7 = r8.getContext()
            kotlin.jvm.internal.p.h(r7, r2)
            r6.<init>(r7, r0)
            r8.slaController = r6
        L50:
            boolean r8 = r6.A0()
            if (r8 == 0) goto L5b
            java.lang.String r8 = "bindSlaVoiceBridgeIfNeeded: gate bound for home SLA-only"
            h8.C4148a.k(r4, r8, r3, r1, r5)
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.HomeInputView.td():void");
    }

    public final void ud() {
        SlaChatController slaChatController = this.slaController;
        if (slaChatController != null) {
            slaChatController.Q0();
        }
        C4148a.d(TAG, "releaseSlaVoiceBridge", false, 4, null);
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView
    public void x6() {
        sd();
    }

    @Override // com.stepos.ailauncher.chat.view.BaseInputView
    public boolean y6() {
        SlaRouter slaRouter = SlaRouter.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (!slaRouter.v(context)) {
            C4148a.k(TAG, "ensureSlaVoiceGateBound: sla unavailable", false, 4, null);
            return false;
        }
        SlaVoiceBridge slaVoiceBridge = SlaVoiceBridge.INSTANCE;
        if (slaVoiceBridge.p() == null) {
            C4148a.k(TAG, "ensureSlaVoiceGateBound: slot empty, bind VOICE_ONLY", false, 4, null);
            td();
        }
        boolean z10 = slaVoiceBridge.p() != null;
        if (!z10) {
            C4148a.u(TAG, "ensureSlaVoiceGateBound: still no gate after bind", false, 4, null);
        }
        return z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeInputView(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        setLayoutId(R$layout.layout_input_float);
        c(context, attributeSet, null);
        setSendMessageListener(new a(context));
    }

    public /* synthetic */ HomeInputView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
