package com.stepos.ailauncher.sprite.transport;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.sprite.transport.ISpriteStateCallback;
import com.stepos.ailauncher.sprite.transport.ISpriteTransport;
import com.stepos.ailauncher.sprite.transport.SpriteTransportClient;
import com.stepos.deepbinder.core.constant.Constants;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002>A\u0018\u0000 H2\u00020\u0001:\u0002IJB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00150/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00103R\u0016\u00106\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00107R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0011\u0010G\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bG\u0010\u001c¨\u0006K"}, d2 = {"Lcom/stepos/ailauncher/sprite/transport/SpriteTransportClient;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "packageName", "action", "targetServer", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/sprite/transport/SpriteTransportClient;", "className", "targetServerComponent", "", x5.d.EXTRA_ENABLED, "setAutoReconnect", "(Z)Lcom/stepos/ailauncher/sprite/transport/SpriteTransportClient;", "Lcom/stepos/ailauncher/sprite/transport/SpriteTransportClient$b;", "listener", "setConnectionListener", "(Lcom/stepos/ailauncher/sprite/transport/SpriteTransportClient$b;)Lcom/stepos/ailauncher/sprite/transport/SpriteTransportClient;", "Lcom/stepos/ailauncher/sprite/transport/OnSpriteStateChangeListener;", "addOnSpriteStateChangeListener", "(Lcom/stepos/ailauncher/sprite/transport/OnSpriteStateChangeListener;)Lcom/stepos/ailauncher/sprite/transport/SpriteTransportClient;", "LY8/t;", "removeOnSpriteStateChangeListener", "(Lcom/stepos/ailauncher/sprite/transport/OnSpriteStateChangeListener;)V", Constants.METHOD_CONNECT, "()Z", "disconnect", "()V", "Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;", VoiceWakeupReceiver.EXTRA_STATE, "sendState", "(Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;)Z", "bubbleTxt", "sendBubble", "(Ljava/lang/String;)Z", "Lcom/stepos/ailauncher/sprite/transport/UserEvent;", "event", "sendUserEvent", "(Lcom/stepos/ailauncher/sprite/transport/UserEvent;)Z", "appContext", "Landroid/content/Context;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "targetPackage", "Ljava/lang/String;", "targetAction", "targetClassName", "autoReconnect", "Z", "connectionListener", "Lcom/stepos/ailauncher/sprite/transport/SpriteTransportClient$b;", "Lcom/stepos/ailauncher/sprite/transport/ISpriteTransport;", "binder", "Lcom/stepos/ailauncher/sprite/transport/ISpriteTransport;", "connecting", "com/stepos/ailauncher/sprite/transport/SpriteTransportClient$callback$1", "callback", "Lcom/stepos/ailauncher/sprite/transport/SpriteTransportClient$callback$1;", "com/stepos/ailauncher/sprite/transport/SpriteTransportClient$c", "serviceConnection", "Lcom/stepos/ailauncher/sprite/transport/SpriteTransportClient$c;", "Landroid/os/IBinder$DeathRecipient;", "deathRecipient", "Landroid/os/IBinder$DeathRecipient;", "isConnected", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "sprite-transport-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SpriteTransportClient {
    private static final long RECONNECT_DELAY_MS = 1500;
    private static final String TAG = "SpriteTransportClient";
    private final Context appContext;
    private boolean autoReconnect;
    private volatile ISpriteTransport binder;
    private final SpriteTransportClient$callback$1 callback;
    private volatile boolean connecting;
    private b connectionListener;
    private final IBinder.DeathRecipient deathRecipient;
    private final CopyOnWriteArraySet<OnSpriteStateChangeListener> listeners;
    private final Handler mainHandler;
    private final c serviceConnection;
    private String targetAction;
    private String targetClassName;
    private String targetPackage;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/ailauncher/sprite/transport/SpriteTransportClient$b;", "", "sprite-transport-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface b {
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/sprite/transport/SpriteTransportClient$c", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "LY8/t;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "sprite-transport-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class c implements ServiceConnection {
        public c() {
        }

        public static final void c(SpriteTransportClient this$0) {
            p.i(this$0, "this$0");
            SpriteTransportClient.access$getConnectionListener$p(this$0);
        }

        public static final void d(SpriteTransportClient this$0) {
            p.i(this$0, "this$0");
            SpriteTransportClient.access$getConnectionListener$p(this$0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) throws RemoteException {
            p.i(name, "name");
            p.i(service, "service");
            ISpriteTransport iSpriteTransportAsInterface = ISpriteTransport.Stub.asInterface(service);
            SpriteTransportClient.this.binder = iSpriteTransportAsInterface;
            SpriteTransportClient.this.connecting = false;
            try {
                service.linkToDeath(SpriteTransportClient.this.deathRecipient, 0);
            } catch (RemoteException e10) {
                Log.w(SpriteTransportClient.TAG, "linkToDeath failed", e10);
            }
            try {
                iSpriteTransportAsInterface.registerCallback(SpriteTransportClient.this.callback);
            } catch (RemoteException e11) {
                Log.w(SpriteTransportClient.TAG, "registerCallback failed", e11);
            }
            Handler handler = SpriteTransportClient.this.mainHandler;
            final SpriteTransportClient spriteTransportClient = SpriteTransportClient.this;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.sprite.transport.h
                @Override // java.lang.Runnable
                public final void run() {
                    SpriteTransportClient.c.c(spriteTransportClient);
                }
            });
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            p.i(name, "name");
            SpriteTransportClient.this.binder = null;
            SpriteTransportClient.this.connecting = false;
            Handler handler = SpriteTransportClient.this.mainHandler;
            final SpriteTransportClient spriteTransportClient = SpriteTransportClient.this;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.sprite.transport.g
                @Override // java.lang.Runnable
                public final void run() {
                    SpriteTransportClient.c.d(spriteTransportClient);
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.stepos.ailauncher.sprite.transport.SpriteTransportClient$callback$1] */
    public SpriteTransportClient(Context context) {
        p.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        p.h(applicationContext, "getApplicationContext(...)");
        this.appContext = applicationContext;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.listeners = new CopyOnWriteArraySet<>();
        this.targetAction = SpriteConstants.ACTION_BIND;
        this.autoReconnect = true;
        this.callback = new ISpriteStateCallback.Stub() { // from class: com.stepos.ailauncher.sprite.transport.SpriteTransportClient$callback$1
            @Override // com.stepos.ailauncher.sprite.transport.ISpriteStateCallback
            public void onSpriteBubbleChange(String bubbleTxt) {
                if (bubbleTxt == null) {
                    bubbleTxt = "";
                }
                Iterator it = this.this$0.listeners.iterator();
                while (it.hasNext()) {
                    try {
                        ((OnSpriteStateChangeListener) it.next()).onSpriteBubbleChange(bubbleTxt);
                    } catch (Throwable th) {
                        Log.w("SpriteTransportClient", "client listener threw", th);
                    }
                }
            }

            @Override // com.stepos.ailauncher.sprite.transport.ISpriteStateCallback
            public void onSpriteStateChange(SpriteStateResult state) {
                if (state == null) {
                    return;
                }
                Iterator it = this.this$0.listeners.iterator();
                while (it.hasNext()) {
                    try {
                        ((OnSpriteStateChangeListener) it.next()).onSpriteStateChange(state);
                    } catch (Throwable th) {
                        Log.w("SpriteTransportClient", "client listener threw", th);
                    }
                }
            }
        };
        this.serviceConnection = new c();
        this.deathRecipient = new IBinder.DeathRecipient() { // from class: com.stepos.ailauncher.sprite.transport.d
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                SpriteTransportClient.deathRecipient$lambda$2(this.f28367a);
            }
        };
    }

    public static final /* synthetic */ b access$getConnectionListener$p(SpriteTransportClient spriteTransportClient) {
        spriteTransportClient.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deathRecipient$lambda$2(final SpriteTransportClient this$0) {
        p.i(this$0, "this$0");
        this$0.binder = null;
        this$0.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.sprite.transport.e
            @Override // java.lang.Runnable
            public final void run() {
                SpriteTransportClient.deathRecipient$lambda$2$lambda$0(this.f28368a);
            }
        });
        if (this$0.autoReconnect) {
            this$0.mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.sprite.transport.f
                @Override // java.lang.Runnable
                public final void run() {
                    SpriteTransportClient.deathRecipient$lambda$2$lambda$1(this.f28369a);
                }
            }, 1500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deathRecipient$lambda$2$lambda$0(SpriteTransportClient this$0) {
        p.i(this$0, "this$0");
        this$0.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deathRecipient$lambda$2$lambda$1(SpriteTransportClient this$0) {
        p.i(this$0, "this$0");
        this$0.connect();
    }

    public static /* synthetic */ SpriteTransportClient targetServer$default(SpriteTransportClient spriteTransportClient, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = SpriteConstants.ACTION_BIND;
        }
        return spriteTransportClient.targetServer(str, str2);
    }

    public final SpriteTransportClient addOnSpriteStateChangeListener(OnSpriteStateChangeListener listener) {
        p.i(listener, "listener");
        this.listeners.add(listener);
        return this;
    }

    public final boolean connect() {
        boolean zBindService;
        if (this.binder != null || this.connecting) {
            return false;
        }
        String str = this.targetPackage;
        if (str == null) {
            throw new IllegalStateException("targetServer(packageName=...) must be called before connect()");
        }
        Intent intent = new Intent();
        intent.setAction(this.targetAction);
        String str2 = this.targetClassName;
        if (str2 != null) {
            intent.setComponent(new ComponentName(str, str2));
        } else {
            intent.setPackage(str);
        }
        this.connecting = true;
        try {
            zBindService = this.appContext.bindService(intent, this.serviceConnection, 1);
        } catch (Throwable th) {
            Log.w(TAG, "bindService threw", th);
            zBindService = false;
        }
        if (!zBindService) {
            this.connecting = false;
            Log.w(TAG, "bindService returned false for " + intent);
        }
        return zBindService;
    }

    public final void disconnect() {
        ISpriteTransport iSpriteTransport = this.binder;
        if (iSpriteTransport != null) {
            try {
                iSpriteTransport.unregisterCallback(this.callback);
            } catch (RemoteException e10) {
                Log.w(TAG, "unregisterCallback failed", e10);
            }
        }
        this.binder = null;
        this.connecting = false;
        try {
            this.appContext.unbindService(this.serviceConnection);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final boolean isConnected() {
        return this.binder != null;
    }

    public final void removeOnSpriteStateChangeListener(OnSpriteStateChangeListener listener) {
        p.i(listener, "listener");
        this.listeners.remove(listener);
    }

    public final boolean sendBubble(String bubbleTxt) {
        p.i(bubbleTxt, "bubbleTxt");
        ISpriteTransport iSpriteTransport = this.binder;
        if (iSpriteTransport == null) {
            return false;
        }
        try {
            iSpriteTransport.onSpriteBubbleChange(bubbleTxt);
            return true;
        } catch (RemoteException e10) {
            Log.w(TAG, "sendBubble failed", e10);
            return false;
        }
    }

    public final boolean sendState(SpriteStateResult state) {
        p.i(state, "state");
        ISpriteTransport iSpriteTransport = this.binder;
        if (iSpriteTransport == null) {
            return false;
        }
        try {
            iSpriteTransport.onSpriteStateChange(state);
            return true;
        } catch (RemoteException e10) {
            Log.w(TAG, "sendState failed", e10);
            return false;
        }
    }

    public final boolean sendUserEvent(UserEvent event) {
        p.i(event, "event");
        ISpriteTransport iSpriteTransport = this.binder;
        if (iSpriteTransport == null) {
            return false;
        }
        try {
            iSpriteTransport.onUserEvent(event.getCode());
            return true;
        } catch (RemoteException e10) {
            Log.w(TAG, "sendUserEvent failed", e10);
            return false;
        }
    }

    public final SpriteTransportClient setAutoReconnect(boolean enabled) {
        this.autoReconnect = enabled;
        return this;
    }

    public final SpriteTransportClient setConnectionListener(b listener) {
        return this;
    }

    public final SpriteTransportClient targetServer(String packageName, String action) {
        p.i(packageName, "packageName");
        p.i(action, "action");
        this.targetPackage = packageName;
        this.targetAction = action;
        return this;
    }

    public final SpriteTransportClient targetServerComponent(String packageName, String className) {
        p.i(packageName, "packageName");
        p.i(className, "className");
        this.targetPackage = packageName;
        this.targetClassName = className;
        return this;
    }
}
