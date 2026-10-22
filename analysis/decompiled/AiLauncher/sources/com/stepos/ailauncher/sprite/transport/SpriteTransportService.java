package com.stepos.ailauncher.sprite.transport;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.sprite.transport.ISpriteTransport;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/sprite/transport/SpriteTransportService;", "Landroid/app/Service;", "<init>", "()V", "LY8/t;", "onCreate", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "onDestroy", "Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;", VoiceWakeupReceiver.EXTRA_STATE, "broadcastStateInternal$sprite_transport_sdk_release", "(Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;)V", "broadcastStateInternal", "", "bubbleTxt", "broadcastBubbleInternal$sprite_transport_sdk_release", "(Ljava/lang/String;)V", "broadcastBubbleInternal", "", "registeredClientCount$sprite_transport_sdk_release", "()I", "registeredClientCount", "Landroid/os/RemoteCallbackList;", "Lcom/stepos/ailauncher/sprite/transport/ISpriteStateCallback;", "callbacks", "Landroid/os/RemoteCallbackList;", "Lcom/stepos/ailauncher/sprite/transport/ISpriteTransport$Stub;", "binder", "Lcom/stepos/ailauncher/sprite/transport/ISpriteTransport$Stub;", "Companion", Const.INTENT_KEY_APIKEY, "sprite-transport-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SpriteTransportService extends Service {
    private static final String TAG = "SpriteTransportSvc";
    private final RemoteCallbackList<ISpriteStateCallback> callbacks = new RemoteCallbackList<>();
    private final ISpriteTransport.Stub binder = new ISpriteTransport.Stub() { // from class: com.stepos.ailauncher.sprite.transport.SpriteTransportService$binder$1
        @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
        public void onSpriteBubbleChange(String bubbleTxt) {
            if (bubbleTxt == null) {
                bubbleTxt = "";
            }
            SpriteTransportServer.INSTANCE.dispatchIncomingBubble$sprite_transport_sdk_release(bubbleTxt);
            this.this$0.broadcastBubbleInternal$sprite_transport_sdk_release(bubbleTxt);
        }

        @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
        public void onSpriteStateChange(SpriteStateResult state) {
            if (state == null) {
                return;
            }
            SpriteTransportServer.INSTANCE.dispatchIncomingState$sprite_transport_sdk_release(state);
            this.this$0.broadcastStateInternal$sprite_transport_sdk_release(state);
        }

        @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
        public void onUserEvent(int event) {
            UserEvent userEventA = UserEvent.INSTANCE.a(event);
            if (userEventA != null) {
                SpriteTransportServer.INSTANCE.dispatchIncomingUserEvent$sprite_transport_sdk_release(userEventA);
                return;
            }
            Log.w("SpriteTransportSvc", "Ignoring unknown user event code: " + event);
        }

        @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
        public void registerCallback(ISpriteStateCallback callback) {
            if (callback == null) {
                return;
            }
            this.this$0.callbacks.register(callback);
        }

        @Override // com.stepos.ailauncher.sprite.transport.ISpriteTransport
        public void unregisterCallback(ISpriteStateCallback callback) {
            if (callback == null) {
                return;
            }
            this.this$0.callbacks.unregister(callback);
        }
    };

    public final void broadcastBubbleInternal$sprite_transport_sdk_release(String bubbleTxt) {
        p.i(bubbleTxt, "bubbleTxt");
        int iBeginBroadcast = this.callbacks.beginBroadcast();
        for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
            try {
                try {
                    ((ISpriteStateCallback) this.callbacks.getBroadcastItem(i10)).onSpriteBubbleChange(bubbleTxt);
                } catch (RemoteException e10) {
                    Log.w(TAG, "Bubble broadcast to client #" + i10 + " failed", e10);
                }
            } finally {
                this.callbacks.finishBroadcast();
            }
        }
    }

    public final void broadcastStateInternal$sprite_transport_sdk_release(SpriteStateResult state) {
        p.i(state, "state");
        int iBeginBroadcast = this.callbacks.beginBroadcast();
        for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
            try {
                try {
                    ((ISpriteStateCallback) this.callbacks.getBroadcastItem(i10)).onSpriteStateChange(state);
                } catch (RemoteException e10) {
                    Log.w(TAG, "State broadcast to client #" + i10 + " failed", e10);
                }
            } finally {
                this.callbacks.finishBroadcast();
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        SpriteTransportServer.INSTANCE.attach$sprite_transport_sdk_release(this);
        Log.i(TAG, "SpriteTransportService onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        SpriteTransportServer.INSTANCE.detach$sprite_transport_sdk_release(this);
        this.callbacks.kill();
        Log.i(TAG, "SpriteTransportService onDestroy");
        super.onDestroy();
    }

    public final int registeredClientCount$sprite_transport_sdk_release() {
        int iBeginBroadcast = this.callbacks.beginBroadcast();
        this.callbacks.finishBroadcast();
        return iBeginBroadcast;
    }
}
