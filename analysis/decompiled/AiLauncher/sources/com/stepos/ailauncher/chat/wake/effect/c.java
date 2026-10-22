package com.stepos.ailauncher.chat.wake.effect;

import Y8.t;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.display.OverlayRefreshPriority;
import com.stepos.ailauncher.chat.view.BaseInputView;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import s.C5423E;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0012J\r\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u000eJ\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u000eJ\u000f\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u000eJ\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010(\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u001e\u0010+\u001a\n\u0018\u00010)j\u0004\u0018\u0001`*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R$\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R$\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101¨\u00063"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/effect/c;", "", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "Lcom/stepos/ailauncher/chat/wake/effect/d;", "config", "<init>", "(Landroid/view/View;Lcom/stepos/ailauncher/chat/wake/effect/d;)V", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "input", "LY8/t;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/view/BaseInputView;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", "", "shown", "l", "(Z)V", "cancel", "k", "defer", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "o", "m", "n", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroid/view/View;", "Lcom/stepos/ailauncher/chat/wake/effect/d;", "", "TAG", "Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/wake/effect/g;", "spectrum", "Lcom/stepos/ailauncher/chat/wake/effect/g;", "popupShown", "Z", "inCancel", "deferred", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "refreshLease", "Ljava/lang/AutoCloseable;", "attachedInput", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "Lkotlin/Function1;", "prevPopupShownListener", "Lp9/l;", "prevCancelListener", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    private final String TAG;
    private final View anchor;
    private BaseInputView attachedInput;
    private final SpectrumBorderConfig config;
    private boolean deferred;
    private boolean inCancel;
    private boolean popupShown;
    private InterfaceC5074l<? super Boolean, t> prevCancelListener;
    private InterfaceC5074l<? super Boolean, t> prevPopupShownListener;
    private AutoCloseable refreshLease;
    private g spectrum;

    public c(View anchor, SpectrumBorderConfig config) {
        p.i(anchor, "anchor");
        p.i(config, "config");
        this.anchor = anchor;
        this.config = config;
        this.TAG = "RecordingSpectrumController";
    }

    public static final t e(InterfaceC5074l interfaceC5074l, c cVar, boolean z10) {
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
        cVar.l(z10);
        return t.f7040a;
    }

    public static final t f(InterfaceC5074l interfaceC5074l, c cVar, boolean z10) {
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
        cVar.k(z10);
        return t.f7040a;
    }

    public final void c() {
        if (this.refreshLease != null) {
            return;
        }
        this.refreshLease = com.stepos.agentframework.display.e.INSTANCE.e(this.anchor, OverlayRefreshPriority.RECORDING, 60.0f);
        C4148a.k(this.TAG, "recording refresh lease acquired", false, 4, null);
    }

    public final void d(BaseInputView input) {
        p.i(input, "input");
        if (this.attachedInput != null) {
            g();
        }
        this.attachedInput = input;
        this.prevPopupShownListener = input.getOnSpeechPopupShown();
        final InterfaceC5074l<Boolean, t> onSpeechCancelStateChanged = input.getOnSpeechCancelStateChanged();
        this.prevCancelListener = onSpeechCancelStateChanged;
        final InterfaceC5074l<? super Boolean, t> interfaceC5074l = this.prevPopupShownListener;
        input.setOnSpeechPopupShown(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.effect.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return c.e(interfaceC5074l, this, ((Boolean) obj).booleanValue());
            }
        });
        input.setOnSpeechCancelStateChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.effect.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return c.f(onSpeechCancelStateChanged, this, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final void g() {
        BaseInputView baseInputView = this.attachedInput;
        if (baseInputView == null) {
            return;
        }
        baseInputView.setOnSpeechPopupShown(this.prevPopupShownListener);
        baseInputView.setOnSpeechCancelStateChanged(this.prevCancelListener);
        this.prevPopupShownListener = null;
        this.prevCancelListener = null;
        this.attachedInput = null;
    }

    public final void h() {
        g();
        n();
        this.popupShown = false;
        this.inCancel = false;
        this.deferred = false;
    }

    public final void i() throws Exception {
        AutoCloseable autoCloseable = this.refreshLease;
        if (autoCloseable != null) {
            C5423E.a(autoCloseable);
        }
        this.refreshLease = null;
    }

    public final void j(boolean defer) throws Exception {
        if (this.deferred == defer) {
            return;
        }
        this.deferred = defer;
        o();
    }

    public final void k(boolean cancel) {
        this.inCancel = cancel;
        o();
    }

    public final void l(boolean shown) {
        this.popupShown = shown;
        if (!shown) {
            this.inCancel = false;
        }
        o();
    }

    public final void m() {
        C4148a.k(this.TAG, "spectrum START (popupShown=" + this.popupShown + " inCancel=" + this.inCancel + ")", false, 4, null);
        c();
        g gVar = this.spectrum;
        if (gVar != null) {
            gVar.o();
        }
        g gVar2 = new g(this.anchor, this.config);
        gVar2.j(true);
        g.l(gVar2, 0L, 0L, 2, null);
        this.spectrum = gVar2;
    }

    public final void n() throws Exception {
        C4148a.k(this.TAG, "spectrum STOP", false, 4, null);
        g gVar = this.spectrum;
        if (gVar != null) {
            gVar.o();
        }
        this.spectrum = null;
        i();
    }

    public final void o() throws Exception {
        BaseInputView baseInputView;
        if (!this.popupShown || this.inCancel || this.deferred || ((baseInputView = this.attachedInput) != null && baseInputView.K7())) {
            n();
        } else {
            m();
        }
    }

    public /* synthetic */ c(View view, SpectrumBorderConfig spectrumBorderConfig, int i10, i iVar) {
        this(view, (i10 & 2) != 0 ? new SpectrumBorderConfig(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255, null) : spectrumBorderConfig);
    }
}
