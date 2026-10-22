package com.stepos.ailauncher.chat.voice.longpress;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0003J\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0003R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/J;", "Lcom/stepos/ailauncher/chat/voice/longpress/N;", "<init>", "()V", "Lkotlin/Function0;", "LY8/t;", "finish", "e", "(Lp9/a;)V", "c", "cancel", "dispose", Const.INTENT_KEY_PKGNAME, "listener", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "f", "", "effectDone", "Z", AlipayXuiIsland.REASON_ENDED, "onFinished", "Lp9/a;", com.stepos.ailauncher.foundation.appui.card.provider.didi.o0.TRACK_STATUS_TERMINAL, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class J implements N {
    private boolean effectDone;
    private boolean ended;
    private InterfaceC5063a<Y8.t> onFinished;
    private InterfaceC5063a<Y8.t> terminal;

    @Override // com.stepos.ailauncher.chat.voice.longpress.N
    public void a(InterfaceC5063a<Y8.t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        if (this.ended) {
            listener.invoke();
        } else {
            this.onFinished = listener;
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.N
    public void b() {
        c();
    }

    public final void c() {
        if (this.ended) {
            return;
        }
        this.effectDone = true;
        f();
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.N
    public void cancel() {
        if (this.ended) {
            return;
        }
        this.ended = true;
        this.terminal = null;
        d();
    }

    public final void d() {
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onFinished;
        this.onFinished = null;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.N
    public void dispose() {
        cancel();
    }

    public final void e(InterfaceC5063a<Y8.t> finish) {
        kotlin.jvm.internal.p.i(finish, "finish");
        if (this.ended || this.terminal != null) {
            return;
        }
        this.terminal = finish;
        f();
    }

    public final void f() {
        InterfaceC5063a<Y8.t> interfaceC5063a;
        if (this.effectDone && (interfaceC5063a = this.terminal) != null) {
            this.ended = true;
            this.terminal = null;
            d();
            interfaceC5063a.invoke();
        }
    }
}
