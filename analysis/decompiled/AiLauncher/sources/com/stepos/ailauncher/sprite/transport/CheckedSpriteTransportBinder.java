package com.stepos.ailauncher.sprite.transport;

import android.os.RemoteException;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.sprite.transport.ISpriteTransport;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/sprite/transport/CheckedSpriteTransportBinder;", "Lcom/stepos/ailauncher/sprite/transport/ISpriteTransport$Stub;", "Lcom/stepos/ailauncher/sprite/transport/b;", "service", "Lcom/stepos/ailauncher/sprite/transport/ISpriteTransport;", "delegate", "<init>", "(Lcom/stepos/ailauncher/sprite/transport/b;Lcom/stepos/ailauncher/sprite/transport/ISpriteTransport;)V", "Lcom/stepos/ailauncher/sprite/transport/ISpriteStateCallback;", "cb", "LY8/t;", "registerCallback", "(Lcom/stepos/ailauncher/sprite/transport/ISpriteStateCallback;)V", "unregisterCallback", "Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;", VoiceWakeupReceiver.EXTRA_STATE, SpriteConstants.METHOD_ON_SPRITE_STATE_CHANGE, "(Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;)V", "", "bubbleTxt", "onSpriteBubbleChange", "(Ljava/lang/String;)V", "", "code", "onUserEvent", "(I)V", "Lcom/stepos/ailauncher/sprite/transport/b;", "Lcom/stepos/ailauncher/sprite/transport/ISpriteTransport;", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CheckedSpriteTransportBinder extends ISpriteTransport.Stub {
    private final ISpriteTransport delegate;
    private final b service;

    public CheckedSpriteTransportBinder(b service, ISpriteTransport delegate) {
        p.i(service, "service");
        p.i(delegate, "delegate");
        this.service = service;
        this.delegate = delegate;
    }

    @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
    public void onSpriteBubbleChange(String bubbleTxt) throws RemoteException {
        C5.d.INSTANCE.g(this.service, "onSpriteBubbleChange");
        ISpriteTransport iSpriteTransport = this.delegate;
        if (bubbleTxt == null) {
            bubbleTxt = "";
        }
        iSpriteTransport.onSpriteBubbleChange(bubbleTxt);
    }

    @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
    public void onSpriteStateChange(SpriteStateResult state) throws RemoteException {
        C5.d.INSTANCE.g(this.service, SpriteConstants.METHOD_ON_SPRITE_STATE_CHANGE);
        if (state == null) {
            throw new SecurityException("onSpriteStateChange denied: empty state");
        }
        this.delegate.onSpriteStateChange(state);
    }

    @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
    public void onUserEvent(int code) throws RemoteException {
        C5.d.INSTANCE.g(this.service, "onUserEvent");
        c.INSTANCE.a(code);
        this.delegate.onUserEvent(code);
    }

    @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
    public void registerCallback(ISpriteStateCallback cb2) throws RemoteException {
        C5.d.INSTANCE.d(this.service).a(this.service, "registerCallback");
        if (cb2 == null) {
            throw new SecurityException("registerCallback denied: null callback");
        }
        this.delegate.registerCallback(cb2);
    }

    @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
    public void unregisterCallback(ISpriteStateCallback cb2) throws RemoteException {
        C5.d.INSTANCE.g(this.service, "unregisterCallback");
        if (cb2 == null) {
            throw new SecurityException("unregisterCallback denied: null callback");
        }
        this.delegate.unregisterCallback(cb2);
    }
}
