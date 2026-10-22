package com.stepos.ailauncher.chat.voice.longpress;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0017\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u0017J\u0015\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\b¢\u0006\u0004\b\"\u0010\u0015J\r\u0010#\u001a\u00020\b¢\u0006\u0004\b#\u0010\u0015J\r\u0010$\u001a\u00020\b¢\u0006\u0004\b$\u0010\u0015J\r\u0010%\u001a\u00020\b¢\u0006\u0004\b%\u0010\u0015J\r\u0010&\u001a\u00020\b¢\u0006\u0004\b&\u0010\u0015J\r\u0010'\u001a\u00020\b¢\u0006\u0004\b'\u0010\u0015J\r\u0010(\u001a\u00020\b¢\u0006\u0004\b(\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010*R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010+R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R$\u00101\u001a\u00020/2\u0006\u00100\u001a\u00020/8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0011\u00107\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b5\u00106R\u0011\u00109\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b8\u00106¨\u0006:"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/n0;", "", "Lcom/stepos/ailauncher/chat/voice/longpress/g0;", "barAnimator", "Lcom/stepos/ailauncher/chat/voice/longpress/q;", "effect", "Lkotlin/Function1;", "", "LY8/t;", "onActiveChanged", "Lkotlin/Function0;", "onFinalizingInteractive", "<init>", "(Lcom/stepos/ailauncher/chat/voice/longpress/g0;Lcom/stepos/ailauncher/chat/voice/longpress/q;Lp9/l;Lp9/a;)V", "moveCenterHorizontally", "Lcom/stepos/ailauncher/chat/voice/longpress/l;", "strategy", "holdToTalk", "s", "(ZLcom/stepos/ailauncher/chat/voice/longpress/l;Z)V", "k", "()V", "x", "(Z)V", "", "data", "q", "([S)V", "cancel", "l", "", "remainingMs", "r", "(J)V", "w", "v", "o", "f", "m", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lcom/stepos/ailauncher/chat/voice/longpress/g0;", "Lcom/stepos/ailauncher/chat/voice/longpress/q;", "Lp9/l;", "Lp9/a;", "interactionStrategy", "Lcom/stepos/ailauncher/chat/voice/longpress/l;", "Lcom/stepos/ailauncher/chat/voice/longpress/VoiceLongPressVisualState;", UxipConstants.f30680s, VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/chat/voice/longpress/VoiceLongPressVisualState;", "getState", "()Lcom/stepos/ailauncher/chat/voice/longpress/VoiceLongPressVisualState;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "isActive", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "isFinalizing", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class n0 {
    private final g0 barAnimator;
    private final C3052q effect;
    private InterfaceC3047l interactionStrategy;
    private final InterfaceC5074l<Boolean, Y8.t> onActiveChanged;
    private final InterfaceC5063a<Y8.t> onFinalizingInteractive;
    private VoiceLongPressVisualState state;

    /* JADX WARN: Multi-variable type inference failed */
    public n0(g0 barAnimator, C3052q effect, InterfaceC5074l<? super Boolean, Y8.t> onActiveChanged, InterfaceC5063a<Y8.t> onFinalizingInteractive) {
        kotlin.jvm.internal.p.i(barAnimator, "barAnimator");
        kotlin.jvm.internal.p.i(effect, "effect");
        kotlin.jvm.internal.p.i(onActiveChanged, "onActiveChanged");
        kotlin.jvm.internal.p.i(onFinalizingInteractive, "onFinalizingInteractive");
        this.barAnimator = barAnimator;
        this.effect = effect;
        this.onActiveChanged = onActiveChanged;
        this.onFinalizingInteractive = onFinalizingInteractive;
        this.state = VoiceLongPressVisualState.IDLE;
    }

    public static final Y8.t g(n0 n0Var) {
        n0Var.state = o0.INSTANCE.a(n0Var.state, VoiceLongPressVisualEvent.EXIT_FINISHED);
        n0Var.interactionStrategy = null;
        n0Var.onActiveChanged.invoke(Boolean.FALSE);
        return Y8.t.f7040a;
    }

    public static final Y8.t n(n0 n0Var) {
        n0Var.state = o0.INSTANCE.a(n0Var.state, VoiceLongPressVisualEvent.EXIT_FINISHED);
        n0Var.interactionStrategy = null;
        n0Var.onActiveChanged.invoke(Boolean.FALSE);
        return Y8.t.f7040a;
    }

    public static final Y8.t p(n0 n0Var) {
        if (n0Var.state == VoiceLongPressVisualState.FINALIZING) {
            n0Var.onFinalizingInteractive.invoke();
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void t(n0 n0Var, boolean z10, InterfaceC3047l interfaceC3047l, boolean z11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        n0Var.s(z10, interfaceC3047l, z11);
    }

    public static final Y8.t u(n0 n0Var) {
        n0Var.state = o0.INSTANCE.a(n0Var.state, VoiceLongPressVisualEvent.ENTER_FINISHED);
        return Y8.t.f7040a;
    }

    public final void e() {
        VoiceLongPressVisualState voiceLongPressVisualState = this.state;
        VoiceLongPressVisualState voiceLongPressVisualState2 = VoiceLongPressVisualState.IDLE;
        if (voiceLongPressVisualState != voiceLongPressVisualState2) {
            this.onActiveChanged.invoke(Boolean.FALSE);
        }
        this.state = voiceLongPressVisualState2;
        this.interactionStrategy = null;
        this.effect.q();
        this.barAnimator.L();
    }

    public final void f() {
        VoiceLongPressVisualState voiceLongPressVisualState = this.state;
        if (voiceLongPressVisualState == VoiceLongPressVisualState.IDLE || voiceLongPressVisualState == VoiceLongPressVisualState.EXITING) {
            return;
        }
        this.state = o0.INSTANCE.a(voiceLongPressVisualState, VoiceLongPressVisualEvent.CANCELLED);
        this.effect.l();
        this.barAnimator.u(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.j0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return n0.g(this.f26474a);
            }
        });
    }

    public final void h() {
        VoiceLongPressVisualState voiceLongPressVisualState = this.state;
        VoiceLongPressVisualState voiceLongPressVisualState2 = VoiceLongPressVisualState.IDLE;
        if (voiceLongPressVisualState != voiceLongPressVisualState2) {
            this.onActiveChanged.invoke(Boolean.FALSE);
        }
        this.state = voiceLongPressVisualState2;
        this.interactionStrategy = null;
        this.effect.j();
        this.barAnimator.L();
    }

    public final boolean i() {
        VoiceLongPressVisualState voiceLongPressVisualState = this.state;
        return (voiceLongPressVisualState == VoiceLongPressVisualState.IDLE || voiceLongPressVisualState == VoiceLongPressVisualState.EXITING) ? false : true;
    }

    public final boolean j() {
        return this.state == VoiceLongPressVisualState.FINALIZING;
    }

    public final void k() {
        if (!i() || j()) {
            return;
        }
        C3039d c3039d = C3039d.INSTANCE;
        this.interactionStrategy = c3039d;
        this.barAnimator.P(c3039d.b(true));
    }

    public final void l(boolean cancel) {
        if (!i() || j()) {
            return;
        }
        this.barAnimator.M(cancel);
        this.effect.m(cancel);
    }

    public final void m() {
        VoiceLongPressVisualState voiceLongPressVisualState = this.state;
        if (voiceLongPressVisualState != VoiceLongPressVisualState.FINALIZING) {
            return;
        }
        this.state = o0.INSTANCE.a(voiceLongPressVisualState, VoiceLongPressVisualEvent.FINALIZE_FINISHED);
        this.barAnimator.H(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.m0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return n0.n(this.f26478a);
            }
        });
    }

    public final void o() {
        VoiceLongPressVisualState voiceLongPressVisualStateA = o0.INSTANCE.a(this.state, VoiceLongPressVisualEvent.FINALIZE_STARTED);
        if (voiceLongPressVisualStateA != VoiceLongPressVisualState.FINALIZING) {
            return;
        }
        this.state = voiceLongPressVisualStateA;
        this.effect.l();
        this.barAnimator.E(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.l0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return n0.p(this.f26476a);
            }
        });
    }

    public final void q(short[] data) {
        kotlin.jvm.internal.p.i(data, "data");
        VoiceLongPressVisualState voiceLongPressVisualState = this.state;
        if (voiceLongPressVisualState == VoiceLongPressVisualState.ENTERING || voiceLongPressVisualState == VoiceLongPressVisualState.LISTENING || voiceLongPressVisualState == VoiceLongPressVisualState.RELEASE_GRACE) {
            this.effect.o(p0.b(p0.INSTANCE, data, 0.0f, 2, null));
        }
    }

    public final void r(long remainingMs) {
        if (!i() || j()) {
            return;
        }
        this.barAnimator.Q(remainingMs);
    }

    public final void s(boolean moveCenterHorizontally, InterfaceC3047l strategy, boolean holdToTalk) {
        kotlin.jvm.internal.p.i(strategy, "strategy");
        VoiceLongPressVisualState voiceLongPressVisualState = this.state;
        if (voiceLongPressVisualState == VoiceLongPressVisualState.RELEASE_GRACE) {
            this.state = o0.INSTANCE.a(voiceLongPressVisualState, VoiceLongPressVisualEvent.RELEASE_GRACE_RESUMED);
            return;
        }
        if (voiceLongPressVisualState != VoiceLongPressVisualState.IDLE) {
            return;
        }
        this.interactionStrategy = strategy;
        this.state = o0.INSTANCE.a(voiceLongPressVisualState, VoiceLongPressVisualEvent.RECORDING_STARTED);
        this.onActiveChanged.invoke(Boolean.TRUE);
        g0 g0Var = this.barAnimator;
        InterfaceC3047l interfaceC3047l = this.interactionStrategy;
        if (interfaceC3047l == null) {
            throw new IllegalStateException("Required value was null.");
        }
        g0Var.B(moveCenterHorizontally, interfaceC3047l.b(holdToTalk), new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.k0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return n0.u(this.f26475a);
            }
        });
        this.effect.k();
    }

    public final void v() {
        this.state = o0.INSTANCE.a(this.state, VoiceLongPressVisualEvent.RELEASE_GRACE_RESUMED);
        this.barAnimator.M(false);
        this.effect.m(false);
    }

    public final void w() {
        this.state = o0.INSTANCE.a(this.state, VoiceLongPressVisualEvent.RELEASE_GRACE_STARTED);
    }

    public final void x(boolean holdToTalk) {
        InterfaceC3047l interfaceC3047l;
        if (!i() || j() || (interfaceC3047l = this.interactionStrategy) == null) {
            return;
        }
        this.barAnimator.P(interfaceC3047l.b(holdToTalk));
    }
}
