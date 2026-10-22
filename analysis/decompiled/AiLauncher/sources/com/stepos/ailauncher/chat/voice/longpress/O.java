package com.stepos.ailauncher.chat.voice.longpress;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.longpress.Q;
import com.stepos.ailauncher.speech.view.DotWaveVoiceView;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0017\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001e\u0010\u0017R\u001c\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001fR\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0014\u0010 \u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0014\u0010$\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0014\u0010&\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010!¨\u0006'"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/O;", "Lcom/stepos/ailauncher/chat/voice/longpress/Q$b;", "Lkotlin/Function0;", "Landroid/view/View;", "inputView", "Lcom/stepos/ailauncher/speech/view/DotWaveVoiceView;", "waveform", "Lcom/stepos/ailauncher/chat/voice/longpress/n0;", "visual", "<init>", "(Lp9/a;Lp9/a;Lp9/a;)V", "", "visible", "LY8/t;", "setVisible", "(Z)V", "Lcom/stepos/ailauncher/chat/voice/longpress/l;", "strategy", "moveCenterHorizontally", "holdToTalk", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/voice/longpress/l;ZZ)V", "cancel", "()V", Const.INTENT_KEY_APIKEY, "e", "", "data", "c", "([S)V", "destroy", "Lp9/a;", "isAvailable", "()Z", "isVisible", Const.INTENT_KEY_PKGNAME, "isActive", "f", "isFinalizing", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class O implements Q.b {
    private final InterfaceC5063a<View> inputView;
    private final InterfaceC5063a<n0> visual;
    private final InterfaceC5063a<DotWaveVoiceView> waveform;

    /* JADX WARN: Multi-variable type inference failed */
    public O(InterfaceC5063a<? extends View> inputView, InterfaceC5063a<DotWaveVoiceView> waveform, InterfaceC5063a<n0> visual) {
        kotlin.jvm.internal.p.i(inputView, "inputView");
        kotlin.jvm.internal.p.i(waveform, "waveform");
        kotlin.jvm.internal.p.i(visual, "visual");
        this.inputView = inputView;
        this.waveform = waveform;
        this.visual = visual;
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.b
    public void a() {
        n0 n0VarInvoke = this.visual.invoke();
        if (n0VarInvoke != null) {
            n0VarInvoke.o();
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.b
    public boolean b() {
        n0 n0VarInvoke = this.visual.invoke();
        return n0VarInvoke != null && n0VarInvoke.i();
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.b
    public void c(short[] data) {
        kotlin.jvm.internal.p.i(data, "data");
        n0 n0VarInvoke = this.visual.invoke();
        if (n0VarInvoke != null) {
            n0VarInvoke.q(data);
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.b
    public void cancel() {
        n0 n0VarInvoke = this.visual.invoke();
        if (n0VarInvoke != null) {
            n0VarInvoke.f();
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.b
    public void d(InterfaceC3047l strategy, boolean moveCenterHorizontally, boolean holdToTalk) {
        kotlin.jvm.internal.p.i(strategy, "strategy");
        DotWaveVoiceView dotWaveVoiceViewInvoke = this.waveform.invoke();
        if (dotWaveVoiceViewInvoke != null) {
            dotWaveVoiceViewInvoke.y();
            dotWaveVoiceViewInvoke.setVisibility(4);
        }
        n0 n0VarInvoke = this.visual.invoke();
        if (n0VarInvoke != null) {
            n0VarInvoke.s(moveCenterHorizontally, strategy, holdToTalk);
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.b
    public void destroy() {
        n0 n0VarInvoke = this.visual.invoke();
        if (n0VarInvoke != null) {
            n0VarInvoke.h();
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.b
    public void e() {
        n0 n0VarInvoke = this.visual.invoke();
        if (n0VarInvoke != null) {
            n0VarInvoke.m();
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.b
    public boolean f() {
        n0 n0VarInvoke = this.visual.invoke();
        return n0VarInvoke != null && n0VarInvoke.j();
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.b
    public boolean isAvailable() {
        return this.visual.invoke() != null;
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.b
    public boolean isVisible() {
        View viewInvoke = this.inputView.invoke();
        return viewInvoke != null && viewInvoke.isShown() && viewInvoke.getAlpha() > 0.0f;
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.Q.b
    public void setVisible(boolean visible) {
        View viewInvoke = this.inputView.invoke();
        if (viewInvoke != null) {
            viewInvoke.setVisibility(visible ? 0 : 4);
        }
    }
}
