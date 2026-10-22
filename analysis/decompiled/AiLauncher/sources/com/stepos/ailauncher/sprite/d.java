package com.stepos.ailauncher.sprite;

import L4.l;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.j;
import Y8.t;
import Z8.r;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.display.BackScreenAnimationInfo;
import android.hardware.display.StepOSDisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.J;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.sprite.d;
import com.stepos.ailauncher.sprite.transport.SpriteStateResult;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.p;
import l6.C4874a;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0004*\u0004EHMP\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0003JC\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0013\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0003R\u0014\u0010!\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010+R\u0014\u00100\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010\"RB\u00107\u001a.\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0013\u0018\u000105j\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0013\u0018\u0001`68\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010%R\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006S"}, d2 = {"Lcom/stepos/ailauncher/sprite/d;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "o", "(Landroid/content/Context;)V", "Lkotlin/Function0;", "action", "w", "(Lp9/a;)V", "", "bubbleTxt", "q", "(Ljava/lang/String;)V", "u", "", "", "arr", "target", "Lkotlin/Pair;", "", "n", "(Ljava/util/Map;Ljava/lang/String;)Lkotlin/Pair;", "r", "Landroid/content/res/Resources;", "m", "()Landroid/content/res/Resources;", "p", "t", "y", "TAG", "Ljava/lang/String;", "", "ENABLE_SPRITE_TRANSPORT", "Z", "", "RESYNC_INTERVAL_MS", "J", "Landroid/os/HandlerThread;", "workerThread", "Landroid/os/HandlerThread;", "Landroid/os/Handler;", "workerHandler", "Landroid/os/Handler;", "backScreenThread", "backScreenHandler", "Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;", "lastState", "Lcom/stepos/ailauncher/sprite/transport/SpriteStateResult;", "lastBubble", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "lastLoadedBubbleArr", "Ljava/util/HashMap;", "lastClientCount", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "screenOff", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lk6/a;", "minuteMonitor", "Lk6/a;", "minuteMonitorRegistered", "LUa/M;", "networkScope", "LUa/M;", "com/stepos/ailauncher/sprite/d$e", "screenPowerListener", "Lcom/stepos/ailauncher/sprite/d$e;", "com/stepos/ailauncher/sprite/d$d", "resyncRunnable", "Lcom/stepos/ailauncher/sprite/d$d;", "appContext", "Landroid/content/Context;", "com/stepos/ailauncher/sprite/d$a", "localeChangedReceiver", "Lcom/stepos/ailauncher/sprite/d$a;", "com/stepos/ailauncher/sprite/d$f", "transportConnection", "Lcom/stepos/ailauncher/sprite/d$f;", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    private static final boolean ENABLE_SPRITE_TRANSPORT = false;
    public static final d INSTANCE = new d();
    private static final long RESYNC_INTERVAL_MS = 2000;
    private static final String TAG = "AgentSprite";
    private static Context appContext;
    private static final Handler backScreenHandler;
    private static final HandlerThread backScreenThread;
    private static volatile String lastBubble;
    private static int lastClientCount;
    private static volatile HashMap<String, String[]> lastLoadedBubbleArr;
    private static volatile SpriteStateResult lastState;
    private static final a localeChangedReceiver;
    private static final k6.a minuteMonitor;
    private static boolean minuteMonitorRegistered;
    private static final M networkScope;
    private static final RunnableC0329d resyncRunnable;
    private static final AtomicBoolean screenOff;
    private static final e screenPowerListener;
    private static final f transportConnection;
    private static final Handler workerHandler;
    private static final HandlerThread workerThread;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/sprite/d$a", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (p.d(intent != null ? intent.getAction() : null, "android.intent.action.LOCALE_CHANGED")) {
                Log.i(d.TAG, "ACTION_LOCALE_CHANGED received, reload bubble text");
                d.INSTANCE.u();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"com/stepos/ailauncher/sprite/d$b", "LW5/b;", "", "eventName", "", "isTaskExecuting", "isForeground", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;ZZ)V", "c", "(Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements W5.b {
        final /* synthetic */ StepOSDisplayManager $backScreenManager;

        public b(StepOSDisplayManager stepOSDisplayManager) {
            this.$backScreenManager = stepOSDisplayManager;
        }

        public static final void g(String str, StepOSDisplayManager stepOSDisplayManager) {
            Log.d(d.TAG, "setBackScreenAgentState agentEvent eventName=" + str);
            stepOSDisplayManager.setBackScreenAgentState(str, Bundle.EMPTY);
        }

        public static final void h(String str, boolean z10, boolean z11, StepOSDisplayManager stepOSDisplayManager) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(W5.a.EXTRA_IS_READ, z11);
            Log.d(d.TAG, "setBackScreenAgentState eventName=" + str + " isTaskExecuting=" + z10 + " isForeground=" + z11);
            stepOSDisplayManager.setBackScreenAgentState(str, bundle);
        }

        public static final void i(String str, StepOSDisplayManager stepOSDisplayManager) {
            Log.d(d.TAG, "setBackScreenAgentState taskRead eventName=" + str);
            Bundle bundle = new Bundle();
            bundle.putBoolean(W5.a.EXTRA_IS_READ, true);
            stepOSDisplayManager.setBackScreenAgentState(str, bundle);
        }

        @Override // W5.b
        public void a(final String eventName, final boolean isTaskExecuting, final boolean isForeground) {
            p.i(eventName, "eventName");
            Log.i(d.TAG, "IBackSpriteCallback eventName=" + eventName + " isTaskExecuting=" + isTaskExecuting + " isForeground=" + isForeground);
            Handler handler = d.backScreenHandler;
            final StepOSDisplayManager stepOSDisplayManager = this.$backScreenManager;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.sprite.f
                @Override // java.lang.Runnable
                public final void run() {
                    d.b.h(eventName, isTaskExecuting, isForeground, stepOSDisplayManager);
                }
            });
        }

        @Override // W5.b
        public void b(final String eventName) {
            p.i(eventName, "eventName");
            Log.i(d.TAG, "IBackSpriteCallback onAgentEvent eventName=" + eventName);
            Handler handler = d.backScreenHandler;
            final StepOSDisplayManager stepOSDisplayManager = this.$backScreenManager;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.sprite.g
                @Override // java.lang.Runnable
                public final void run() {
                    d.b.g(eventName, stepOSDisplayManager);
                }
            });
        }

        @Override // W5.b
        public void c(final String eventName) {
            p.i(eventName, "eventName");
            Log.i(d.TAG, "IBackSpriteCallback onTaskReadEvent eventName=" + eventName);
            Handler handler = d.backScreenHandler;
            final StepOSDisplayManager stepOSDisplayManager = this.$backScreenManager;
            handler.post(new Runnable() { // from class: com.stepos.ailauncher.sprite.e
                @Override // java.lang.Runnable
                public final void run() {
                    d.b.i(eventName, stepOSDisplayManager);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/sprite/d$c", "Landroid/hardware/display/StepOSDisplayManager$BackScreenAnimationListener;", "Landroid/hardware/display/BackScreenAnimationInfo;", "info", "", "success", "LY8/t;", "onBackScreenAnimationResult", "(Landroid/hardware/display/BackScreenAnimationInfo;Z)V", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements StepOSDisplayManager.BackScreenAnimationListener {
        public void onBackScreenAnimationResult(BackScreenAnimationInfo info, boolean success) {
            p.i(info, "info");
            C4874a.INSTANCE.a(info, success);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/sprite/d$d", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sprite.d$d, reason: collision with other inner class name */
    public static final class RunnableC0329d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/sprite/d$e", "Lcom/stepos/ailauncher/common/utils/J$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements J.a {
        @Override // com.stepos.ailauncher.common.utils.J.a
        public void a() {
            d.screenOff.set(false);
            d.INSTANCE.t();
            d.minuteMonitor.c();
            Log.i(d.TAG, "screenOn: resync kicked, minute monitor registered");
        }

        @Override // com.stepos.ailauncher.common.utils.J.a
        public void b() {
            d.screenOff.set(true);
            d.INSTANCE.y();
            Log.i(d.TAG, "screenOff: resync paused, minute monitor unregistered");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/sprite/d$f", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "LY8/t;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements ServiceConnection {
        public static final void b() {
            d.lastClientCount = 0;
            d.workerHandler.removeCallbacks(d.resyncRunnable);
            d.workerHandler.post(d.resyncRunnable);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            d.workerHandler.post(new Runnable() { // from class: com.stepos.ailauncher.sprite.h
                @Override // java.lang.Runnable
                public final void run() {
                    d.f.b();
                }
            });
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("agent-sprite-worker");
        handlerThread.start();
        workerThread = handlerThread;
        workerHandler = new Handler(handlerThread.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("agent-sprite-backscreen");
        handlerThread2.start();
        backScreenThread = handlerThread2;
        backScreenHandler = new Handler(handlerThread2.getLooper());
        screenOff = new AtomicBoolean(false);
        minuteMonitor = new k6.a();
        networkScope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.c().getImmediate()));
        screenPowerListener = new e();
        resyncRunnable = new RunnableC0329d();
        localeChangedReceiver = new a();
        transportConnection = new f();
    }

    public static final void s(StepOSDisplayManager stepOSDisplayManager) {
        stepOSDisplayManager.setBackScreenAgentState(l.C0072l.INSTANCE.getKey(), Bundle.EMPTY);
    }

    public static final t v() {
        String[] strArr;
        String str = lastBubble;
        d dVar = INSTANCE;
        Pair<String, Integer> pairN = dVar.n(lastLoadedBubbleArr, str);
        dVar.p();
        if (pairN == null) {
            Log.i(TAG, "no last bubble to re-publish after locale change");
            return t.f7040a;
        }
        String strA = pairN.a();
        int iIntValue = pairN.b().intValue();
        HashMap<String, String[]> map = lastLoadedBubbleArr;
        String str2 = (map == null || (strArr = map.get(strA)) == null) ? null : (String) r.j0(strArr, iIntValue);
        if (str2 == null || str2.length() == 0) {
            Log.w(TAG, "cannot map last bubble to new locale (key=" + strA + " index=" + iIntValue + ")");
            return t.f7040a;
        }
        Log.i(TAG, "re-publish last bubble in new locale: '" + str + "' -> '" + str2 + "'");
        dVar.q(str2);
        return t.f7040a;
    }

    public static final void x(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public final Resources m() {
        Context context = appContext;
        Context context2 = null;
        if (context == null) {
            p.A("appContext");
            context = null;
        }
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocales(Resources.getSystem().getConfiguration().getLocales());
        Context context3 = appContext;
        if (context3 == null) {
            p.A("appContext");
        } else {
            context2 = context3;
        }
        Resources resources = context2.createConfigurationContext(configuration).getResources();
        p.h(resources, "getResources(...)");
        return resources;
    }

    public final Pair<String, Integer> n(Map<String, String[]> arr, String target) {
        if (arr == null || target == null || target.length() == 0) {
            return null;
        }
        for (Map.Entry<String, String[]> entry : arr.entrySet()) {
            String key = entry.getKey();
            int iO0 = r.o0(entry.getValue(), target);
            if (iO0 >= 0) {
                return j.a(key, Integer.valueOf(iO0));
            }
        }
        return null;
    }

    public final void o(Context context) {
        p.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        p.h(applicationContext, "getApplicationContext(...)");
        appContext = applicationContext;
        Log.i(TAG, "SpriteTransport disabled, skip initTransportServer");
        r(context);
        p();
        Context context2 = appContext;
        if (context2 == null) {
            p.A("appContext");
            context2 = null;
        }
        context2.registerReceiver(localeChangedReceiver, new IntentFilter("android.intent.action.LOCALE_CHANGED"));
    }

    public final void p() {
        Resources resourcesM = m();
        HashMap<String, String[]> map = new HashMap<>();
        map.put("agent_team", resourcesM.getStringArray(R$array.bubble_agent_team));
        map.put("agent_fix_room", resourcesM.getStringArray(R$array.bubble_fix_room));
        map.put("skill_browse", resourcesM.getStringArray(R$array.bubble_skill_browse));
        map.put("skill_early_installing", resourcesM.getStringArray(R$array.bubble_skill_early_installing));
        map.put("skill_installing", resourcesM.getStringArray(R$array.bubble_skill_installing));
        map.put("skill_install_success", resourcesM.getStringArray(R$array.bubble_skill_install_success));
        map.put(SpriteEventAction.TASK_RUNNING, resourcesM.getStringArray(R$array.bubble_task_running));
        map.put("task_running_safe", resourcesM.getStringArray(R$array.bubble_task_running_safe));
        map.put("task_waiting", resourcesM.getStringArray(R$array.bubble_task_waiting));
        map.put(SpriteEventAction.TASK_SUCCESS, resourcesM.getStringArray(R$array.bubble_task_success));
        map.put("task_fail", resourcesM.getStringArray(R$array.bubble_task_fail));
        map.put(SpriteEventAction.TASK_INTERRUPTED, resourcesM.getStringArray(R$array.bubble_task_interrupted));
        map.put("gui_safe", resourcesM.getStringArray(R$array.bubble_gui_safe));
        map.put("idle_night", resourcesM.getStringArray(R$array.bubble_idle_night));
        map.put("idle_loafing", resourcesM.getStringArray(R$array.bubble_idle_loafing));
        map.put("idle_music", resourcesM.getStringArray(R$array.bubble_idle_music));
        map.put("idle_exercise", resourcesM.getStringArray(R$array.bubble_idle_exercise));
        map.put("idle_flying", resourcesM.getStringArray(R$array.bubble_idle_flying));
        map.put("idle_night_wakeup", resourcesM.getStringArray(R$array.bubble_wake_up));
        map.put("idle_safe", resourcesM.getStringArray(R$array.bubble_idle_safe));
        U5.b.INSTANCE.q(map);
        lastLoadedBubbleArr = map;
    }

    public final void q(String bubbleTxt) {
        lastBubble = bubbleTxt;
    }

    public final void r(Context context) {
        Object systemService = context.getSystemService("display_ext");
        p.g(systemService, "null cannot be cast to non-null type android.hardware.display.StepOSDisplayManager");
        final StepOSDisplayManager stepOSDisplayManager = (StepOSDisplayManager) systemService;
        backScreenHandler.post(new Runnable() { // from class: com.stepos.ailauncher.sprite.a
            @Override // java.lang.Runnable
            public final void run() {
                d.s(stepOSDisplayManager);
            }
        });
        U5.b.INSTANCE.p(new b(stepOSDisplayManager));
        stepOSDisplayManager.registerBackScreenAnimationListener(context.getMainExecutor(), new c());
    }

    public final void t() {
        if (minuteMonitorRegistered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.TIME_SET");
        Context context = appContext;
        if (context == null) {
            p.A("appContext");
            context = null;
        }
        context.registerReceiver(minuteMonitor, intentFilter);
        minuteMonitorRegistered = true;
    }

    public final void u() {
        w(new InterfaceC5063a() { // from class: com.stepos.ailauncher.sprite.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return d.v();
            }
        });
    }

    public final void w(final InterfaceC5063a<t> action) {
        if (p.d(Looper.myLooper(), workerThread.getLooper())) {
            action.invoke();
        } else {
            workerHandler.post(new Runnable() { // from class: com.stepos.ailauncher.sprite.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.x(action);
                }
            });
        }
    }

    public final void y() {
        if (minuteMonitorRegistered) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Context context = appContext;
                if (context == null) {
                    p.A("appContext");
                    context = null;
                }
                context.unregisterReceiver(minuteMonitor);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            minuteMonitorRegistered = false;
        }
    }
}
