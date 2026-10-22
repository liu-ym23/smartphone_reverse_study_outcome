package com.stepos.ailauncher.sprite.transport;

import android.util.Log;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010$\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0011\u00101\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/stepos/ailauncher/sprite/transport/SpriteTransportServer;", "", "<init>", "()V", "Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;", VoiceWakeupReceiver.EXTRA_STATE, "", "publishState", "(Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;)Z", "", "bubbleTxt", "publishBubble", "(Ljava/lang/String;)Z", "Lcom/stepos/ailauncher/sprite/transport/OnSpriteStateChangeListener;", "listener", "LY8/t;", "addOnSpriteStateChangeListener", "(Lcom/stepos/ailauncher/sprite/transport/OnSpriteStateChangeListener;)V", "removeOnSpriteStateChangeListener", "Lcom/stepos/ailauncher/sprite/transport/SpriteTransportService;", "svc", "attach$sprite_transport_sdk_release", "(Lcom/stepos/ailauncher/sprite/transport/SpriteTransportService;)V", "attach", "detach$sprite_transport_sdk_release", "detach", "dispatchIncomingState$sprite_transport_sdk_release", "(Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;)V", "dispatchIncomingState", "dispatchIncomingBubble$sprite_transport_sdk_release", "(Ljava/lang/String;)V", "dispatchIncomingBubble", "Lcom/stepos/ailauncher/sprite/transport/UserEvent;", "event", "dispatchIncomingUserEvent$sprite_transport_sdk_release", "(Lcom/stepos/ailauncher/sprite/transport/UserEvent;)V", "dispatchIncomingUserEvent", "TAG", "Ljava/lang/String;", "service", "Lcom/stepos/ailauncher/sprite/transport/SpriteTransportService;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "isRunning", "()Z", "", "getConnectedClientCount", "()I", "connectedClientCount", "sprite-transport-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SpriteTransportServer {
    private static final String TAG = "SpriteTransportServer";
    private static volatile SpriteTransportService service;
    public static final SpriteTransportServer INSTANCE = new SpriteTransportServer();
    private static final CopyOnWriteArraySet<OnSpriteStateChangeListener> listeners = new CopyOnWriteArraySet<>();

    private SpriteTransportServer() {
    }

    public final void addOnSpriteStateChangeListener(OnSpriteStateChangeListener listener) {
        p.i(listener, "listener");
        listeners.add(listener);
    }

    public final void attach$sprite_transport_sdk_release(SpriteTransportService svc) {
        p.i(svc, "svc");
        service = svc;
    }

    public final void detach$sprite_transport_sdk_release(SpriteTransportService svc) {
        p.i(svc, "svc");
        if (service == svc) {
            service = null;
        }
    }

    public final void dispatchIncomingBubble$sprite_transport_sdk_release(String bubbleTxt) {
        p.i(bubbleTxt, "bubbleTxt");
        Iterator<OnSpriteStateChangeListener> it = listeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onSpriteBubbleChange(bubbleTxt);
            } catch (Throwable th) {
                Log.w(TAG, "listener threw while consuming bubble", th);
            }
        }
    }

    public final void dispatchIncomingState$sprite_transport_sdk_release(SpriteStateResult state) {
        p.i(state, "state");
        Iterator<OnSpriteStateChangeListener> it = listeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onSpriteStateChange(state);
            } catch (Throwable th) {
                Log.w(TAG, "listener threw while consuming state", th);
            }
        }
    }

    public final void dispatchIncomingUserEvent$sprite_transport_sdk_release(UserEvent event) {
        p.i(event, "event");
        Iterator<OnSpriteStateChangeListener> it = listeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onUserEvent(event);
            } catch (Throwable th) {
                Log.w(TAG, "listener threw while consuming user event", th);
            }
        }
    }

    public final int getConnectedClientCount() {
        SpriteTransportService spriteTransportService = service;
        if (spriteTransportService != null) {
            return spriteTransportService.registeredClientCount$sprite_transport_sdk_release();
        }
        return 0;
    }

    public final boolean isRunning() {
        return service != null;
    }

    public final boolean publishBubble(String bubbleTxt) {
        p.i(bubbleTxt, "bubbleTxt");
        SpriteTransportService spriteTransportService = service;
        if (spriteTransportService == null) {
            Log.w(TAG, "publishBubble called while service is not running; payload dropped");
            return false;
        }
        spriteTransportService.broadcastBubbleInternal$sprite_transport_sdk_release(bubbleTxt);
        return true;
    }

    public final boolean publishState(SpriteStateResult state) {
        p.i(state, "state");
        SpriteTransportService spriteTransportService = service;
        if (spriteTransportService == null) {
            Log.w(TAG, "publishState called while service is not running; payload dropped");
            return false;
        }
        spriteTransportService.broadcastStateInternal$sprite_transport_sdk_release(state);
        return true;
    }

    public final void removeOnSpriteStateChangeListener(OnSpriteStateChangeListener listener) {
        p.i(listener, "listener");
        listeners.remove(listener);
    }
}
