package com.stepos.ailauncher;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.AIHOmeBarService;
import com.stepos.ailauncher.IAILauncher2SysUI;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.wake.homebar.HomeBarChatViewCoordinator;
import com.stepos.ailauncher.chat.wake.homebar.HomeBarDisableManager;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u00019\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u0019\u0010\u0018\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\u0003R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/stepos/ailauncher/AIHOmeBarService;", "Landroid/app/Service;", "<init>", "()V", "", "startTime", "", "whitBar", "LY8/t;", "scheduleShowChatView", "(JZ)V", "afterAuth", "openChatViewFromSysUi", "(Z)V", "abortSysUiChatContainer", "continueAfterHomeBarAuth", "Landroid/os/IBinder;", UxipConstants.f30680s, "attachSysUi", "(Landroid/os/IBinder;)V", "detachSysUi", "onCreate", "Landroid/content/Intent;", "intent", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onUnbind", "(Landroid/content/Intent;)Z", "onDestroy", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "chatPanelShowing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/Runnable;", "showChatViewRunnable", "Ljava/lang/Runnable;", "pendingIntentLaunch", "", "lastIntentLaunchKey", "Ljava/lang/String;", "lastIntentLaunchAt", "J", "Lcom/stepos/ailauncher/IAILauncher2SysUI;", "sysUi", "Lcom/stepos/ailauncher/IAILauncher2SysUI;", "sysUiBinder", "Landroid/os/IBinder;", "Landroid/os/IBinder$DeathRecipient;", "deathRecipient", "Landroid/os/IBinder$DeathRecipient;", "com/stepos/ailauncher/AIHOmeBarService$binder$1", "binder", "Lcom/stepos/ailauncher/AIHOmeBarService$binder$1;", "Companion", Const.INTENT_KEY_PKGNAME, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AIHOmeBarService extends Service {
    public static final String ACTION_BIND = "com.stepos.ailauncher.ISysUI2AILauncher";
    private static final long INTENT_DEDUPE_WINDOW_MS = 1000;
    private static final long MAX_SHOW_DELAY_MS = 500;
    private static final String TAG = "AIHomeBar";
    private static volatile AIHOmeBarService instance;
    private static volatile Boolean lastWhitBar;
    private static volatile boolean selfBound;
    private long lastIntentLaunchAt;
    private String lastIntentLaunchKey;
    private Runnable pendingIntentLaunch;
    private volatile IAILauncher2SysUI sysUi;
    private IBinder sysUiBinder;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicBoolean retryPosted = new AtomicBoolean(false);
    private static final a keepAliveConn = new a();
    private static final ArrayList<H> callbacks = new ArrayList<>();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final AtomicBoolean chatPanelShowing = new AtomicBoolean(false);
    private final Runnable showChatViewRunnable = new Runnable() { // from class: com.stepos.ailauncher.e
        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            AIHOmeBarService.openChatViewFromSysUi$default(this.f27094a, false, 1, null);
        }
    };
    private final IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: com.stepos.ailauncher.f
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            AIHOmeBarService.deathRecipient$lambda$0(this.f27150a);
        }
    };
    private final AIHOmeBarService$binder$1 binder = new AIHOmeBarService$binder$1(this);

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/AIHOmeBarService$a", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "LY8/t;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(AIHOmeBarService.TAG, "selfBind connected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Log.w(AIHOmeBarService.TAG, "selfBind disconnected");
            AIHOmeBarService.selfBound = false;
        }
    }

    @Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u00010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u0013J\r\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u0013J\r\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010\u0003J\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0011H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010\u000bR\u0014\u0010%\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\u00198\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010&R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R$\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\f08j\b\u0012\u0004\u0012\u00020\f`98\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/stepos/ailauncher/AIHOmeBarService$b;", "", "<init>", "()V", "Lcom/stepos/ailauncher/IAILauncher2SysUI;", "s", "()Lcom/stepos/ailauncher/IAILauncher2SysUI;", "Landroid/content/Context;", "context", "LY8/t;", "f", "(Landroid/content/Context;)V", "Lcom/stepos/ailauncher/H;", "callback", "e", "(Lcom/stepos/ailauncher/H;)V", "p", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "", "startTime", "k", "(J)V", "show", "", "msg", "q", "(ZLjava/lang/String;)V", "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "m", "white", "o", "(Z)V", "app", "r", "TAG", "Ljava/lang/String;", "MAX_SHOW_DELAY_MS", "J", "INTENT_DEDUPE_WINDOW_MS", "ACTION_BIND", "Ljava/util/concurrent/atomic/AtomicBoolean;", "retryPosted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "selfBound", "Z", "com/stepos/ailauncher/AIHOmeBarService$a", "keepAliveConn", "Lcom/stepos/ailauncher/AIHOmeBarService$a;", "Lcom/stepos/ailauncher/AIHOmeBarService;", "instance", "Lcom/stepos/ailauncher/AIHOmeBarService;", "lastWhitBar", "Ljava/lang/Boolean;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "callbacks", "Ljava/util/ArrayList;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.AIHOmeBarService$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final void g(Context context) {
            Companion companion = AIHOmeBarService.INSTANCE;
            kotlin.jvm.internal.p.f(context);
            companion.r(context);
        }

        public static final void h(Context context) {
            Companion companion = AIHOmeBarService.INSTANCE;
            kotlin.jvm.internal.p.f(context);
            companion.r(context);
        }

        public static final void n(AIHOmeBarService aIHOmeBarService) throws Resources.NotFoundException {
            aIHOmeBarService.openChatViewFromSysUi(true);
        }

        public final void e(H callback) {
            kotlin.jvm.internal.p.i(callback, "callback");
            if (AIHOmeBarService.callbacks.contains(callback)) {
                return;
            }
            AIHOmeBarService.callbacks.add(callback);
        }

        public final void f(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            final Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.p.f(applicationContext);
            r(applicationContext);
            if (AIHOmeBarService.retryPosted.compareAndSet(false, true)) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIHOmeBarService.Companion.g(applicationContext);
                    }
                }, 1500L);
                handler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIHOmeBarService.Companion.h(applicationContext);
                    }
                }, 3500L);
            }
        }

        public final boolean i() {
            AIHOmeBarService aIHOmeBarService = AIHOmeBarService.instance;
            return (aIHOmeBarService != null ? aIHOmeBarService.sysUi : null) != null;
        }

        public final boolean j() {
            Boolean bool = AIHOmeBarService.lastWhitBar;
            if (bool != null) {
                return bool.booleanValue();
            }
            try {
                IAILauncher2SysUI iAILauncher2SysUIS = s();
                if (iAILauncher2SysUIS != null) {
                    return iAILauncher2SysUIS.isWhiteHomeBar();
                }
                return false;
            } catch (RemoteException e10) {
                Log.e(AIHOmeBarService.TAG, "isWhiteHomeBar failed", e10);
                return false;
            }
        }

        public final void k(long startTime) {
            AtomicBoolean atomicBoolean;
            AIHOmeBarService aIHOmeBarService = AIHOmeBarService.instance;
            if (aIHOmeBarService != null && (atomicBoolean = aIHOmeBarService.chatPanelShowing) != null) {
                atomicBoolean.set(false);
            }
            try {
                IAILauncher2SysUI iAILauncher2SysUIS = s();
                if (iAILauncher2SysUIS != null) {
                    iAILauncher2SysUIS.onChatViewClosed(startTime);
                }
                Log.i(AIHOmeBarService.TAG, "onChatViewClosed startTime=" + startTime);
            } catch (RemoteException e10) {
                Log.e(AIHOmeBarService.TAG, "onChatViewClosed failed", e10);
            }
        }

        public final boolean l() {
            IAILauncher2SysUI iAILauncher2SysUIS = s();
            if (iAILauncher2SysUIS == null) {
                return false;
            }
            try {
                iAILauncher2SysUIS.onHomeBarLighted();
                return true;
            } catch (RemoteException e10) {
                Log.e(AIHOmeBarService.TAG, "onHomeBarLighted failed", e10);
                return false;
            }
        }

        public final void m() {
            final AIHOmeBarService aIHOmeBarService = AIHOmeBarService.instance;
            if (aIHOmeBarService == null) {
                return;
            }
            aIHOmeBarService.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.i
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    AIHOmeBarService.Companion.n(aIHOmeBarService);
                }
            });
        }

        public final void o(boolean white) {
            AIHOmeBarService.lastWhitBar = Boolean.valueOf(white);
        }

        public final void p(H callback) {
            kotlin.jvm.internal.p.i(callback, "callback");
            AIHOmeBarService.callbacks.remove(callback);
        }

        public final void q(boolean show, String msg) {
            try {
                Log.d(AIHOmeBarService.TAG, "showHomeBarCapsule show = " + show + " message = " + msg);
                IAILauncher2SysUI iAILauncher2SysUIS = s();
                if (iAILauncher2SysUIS != null) {
                    iAILauncher2SysUIS.showHomeBarCapsule(show, msg);
                }
            } catch (RemoteException e10) {
                Log.e(AIHOmeBarService.TAG, "showHomeBarCapsule failed", e10);
            }
        }

        public final void r(Context app) {
            Intent action = new Intent(app, (Class<?>) AIHOmeBarService.class).setAction("com.stepos.ailauncher.ISysUI2AILauncher");
            kotlin.jvm.internal.p.h(action, "setAction(...)");
            try {
                app.startService(action);
            } catch (Throwable th) {
                Log.w(AIHOmeBarService.TAG, "startService failed", th);
            }
            if (AIHOmeBarService.selfBound) {
                return;
            }
            try {
                AIHOmeBarService.selfBound = app.bindService(action, AIHOmeBarService.keepAliveConn, 1);
                Log.i(AIHOmeBarService.TAG, "selfBind requested ok=" + AIHOmeBarService.selfBound);
            } catch (Throwable th2) {
                AIHOmeBarService.selfBound = false;
                Log.w(AIHOmeBarService.TAG, "selfBind failed", th2);
            }
        }

        public final IAILauncher2SysUI s() {
            AIHOmeBarService aIHOmeBarService = AIHOmeBarService.instance;
            if (aIHOmeBarService != null) {
                return aIHOmeBarService.sysUi;
            }
            return null;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/AIHOmeBarService$c", "Lcom/stepos/ailauncher/chat/manager/AuthManager$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements AuthManager.a {
        public c() {
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void a() {
        }

        @Override // com.stepos.ailauncher.chat.manager.AuthManager.a
        public void b() {
            AIHOmeBarService.this.continueAfterHomeBarAuth();
        }
    }

    private final void abortSysUiChatContainer() throws Resources.NotFoundException {
        HomeBarChatViewCoordinator.INSTANCE.i();
        INSTANCE.k(SystemClock.elapsedRealtime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void attachSysUi(IBinder value) {
        detachSysUi();
        if (value == null) {
            Log.w(TAG, "onInitialize with null binder");
            return;
        }
        try {
            value.linkToDeath(this.deathRecipient, 0);
            this.sysUiBinder = value;
            this.sysUi = IAILauncher2SysUI.Stub.asInterface(value);
            Log.i(TAG, "SystemUI callback initialized");
            this.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.d
                @Override // java.lang.Runnable
                public final void run() {
                    AIHOmeBarService.attachSysUi$lambda$0();
                }
            });
        } catch (RemoteException e10) {
            Log.e(TAG, "Failed to link SystemUI binder", e10);
            this.sysUiBinder = null;
            this.sysUi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachSysUi$lambda$0() {
        Iterator it = Z8.F.m1(callbacks).iterator();
        while (it.hasNext()) {
            ((H) it.next()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void continueAfterHomeBarAuth() {
        this.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.b
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                AIHOmeBarService.continueAfterHomeBarAuth$lambda$0(this.f24693a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void continueAfterHomeBarAuth$lambda$0(AIHOmeBarService aIHOmeBarService) throws Resources.NotFoundException {
        AuthManager authManager = AuthManager.INSTANCE;
        Context applicationContext = aIHOmeBarService.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        if (AuthManager.O(authManager, applicationContext, false, false, 6, null)) {
            aIHOmeBarService.openChatViewFromSysUi(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deathRecipient$lambda$0(final AIHOmeBarService aIHOmeBarService) {
        aIHOmeBarService.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.c
            @Override // java.lang.Runnable
            public final void run() {
                AIHOmeBarService.deathRecipient$lambda$0$0(this.f24694a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deathRecipient$lambda$0$0(AIHOmeBarService aIHOmeBarService) {
        synchronized (aIHOmeBarService) {
            aIHOmeBarService.sysUiBinder = null;
            aIHOmeBarService.sysUi = null;
            Y8.t tVar = Y8.t.f7040a;
        }
        Log.w(TAG, "SystemUI binder died");
    }

    private final synchronized void detachSysUi() {
        IBinder iBinder = this.sysUiBinder;
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this.deathRecipient, 0);
            } catch (Exception unused) {
                Y8.t tVar = Y8.t.f7040a;
            }
            this.sysUiBinder = null;
            this.sysUi = null;
        } else {
            this.sysUiBinder = null;
            this.sysUi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openChatViewFromSysUi(boolean afterAuth) throws Resources.NotFoundException {
        if (HomeBarDisableManager.INSTANCE.e()) {
            abortSysUiChatContainer();
            return;
        }
        AuthManager authManager = AuthManager.INSTANCE;
        if (!authManager.U()) {
            Log.w(TAG, "auth gate: not logged in, restore page then show login dialog");
            abortSysUiChatContainer();
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            AuthManager.r1(authManager, applicationContext, new InterfaceC5063a() { // from class: com.stepos.ailauncher.a
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AIHOmeBarService.openChatViewFromSysUi$lambda$0(this.f23854a);
                }
            }, null, null, 12, null);
            return;
        }
        if (authManager.Y() && authManager.K()) {
            this.chatPanelShowing.set(true);
            if (afterAuth) {
                HomeBarChatViewCoordinator.INSTANCE.n();
                return;
            } else {
                HomeBarChatViewCoordinator.INSTANCE.k();
                return;
            }
        }
        Log.w(TAG, "auth gate privacy=" + authManager.Y() + " agent=" + authManager.K());
        abortSysUiChatContainer();
        c cVar = new c();
        if (authManager.Y()) {
            Context applicationContext2 = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext2, "getApplicationContext(...)");
            authManager.L(applicationContext2, cVar, true);
        } else {
            Context applicationContext3 = getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext3, "getApplicationContext(...)");
            authManager.b0(applicationContext3, false, true, cVar);
        }
    }

    public static /* synthetic */ void openChatViewFromSysUi$default(AIHOmeBarService aIHOmeBarService, boolean z10, int i10, Object obj) throws Resources.NotFoundException {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        aIHOmeBarService.openChatViewFromSysUi(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t openChatViewFromSysUi$lambda$0(AIHOmeBarService aIHOmeBarService) {
        aIHOmeBarService.continueAfterHomeBarAuth();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleShowChatView(long startTime, boolean whitBar) throws Resources.NotFoundException {
        this.mainHandler.removeCallbacks(this.showChatViewRunnable);
        if (HomeBarDisableManager.INSTANCE.e()) {
            abortSysUiChatContainer();
            return;
        }
        long jO = C5685n.o(startTime - SystemClock.elapsedRealtime(), 0L, 500L);
        Log.i(TAG, "tryToShowChatView startTime=" + startTime + " whitBar=" + whitBar + " delay=" + jO);
        if (jO == 0) {
            openChatViewFromSysUi$default(this, false, 1, null);
        } else {
            this.mainHandler.postDelayed(this.showChatViewRunnable, jO);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind action=" + (intent != null ? intent.getAction() : null));
        instance = this;
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mainHandler.removeCallbacks(this.showChatViewRunnable);
        Runnable runnable = this.pendingIntentLaunch;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
        }
        this.pendingIntentLaunch = null;
        this.lastIntentLaunchKey = null;
        this.lastIntentLaunchAt = 0L;
        detachSysUi();
        if (instance == this) {
            instance = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand action=" + (intent != null ? intent.getAction() : null) + " flags=" + flags);
        instance = this;
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind");
        detachSysUi();
        return super.onUnbind(intent);
    }
}
