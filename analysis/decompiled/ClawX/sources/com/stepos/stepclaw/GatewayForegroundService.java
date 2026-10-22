package com.stepos.stepclaw;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.stepclaw.gateway.GatewayAutoStart;
import com.stepos.stepclaw.keepalive.DynamicKeepAliveManager;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0005*\u0002\u0014\u0018\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J)\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/stepclaw/GatewayForegroundService;", "Landroid/app/Service;", "<init>", "()V", "Lb5/a0;", "onCreate", "Landroid/content/Intent;", "intent", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "onBind", "(Landroid/content/Intent;)Ljava/lang/Void;", "Landroid/os/Handler;", "heartbeatHandler", "Landroid/os/Handler;", "com/stepos/stepclaw/GatewayForegroundService$heartbeatRunnable$1", "heartbeatRunnable", "Lcom/stepos/stepclaw/GatewayForegroundService$heartbeatRunnable$1;", "keepAliveHandler", "com/stepos/stepclaw/GatewayForegroundService$keepAliveRunnable$1", "keepAliveRunnable", "Lcom/stepos/stepclaw/GatewayForegroundService$keepAliveRunnable$1;", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewayForegroundService extends Service {
    private static final String ACTION_STOP = "com.stepos.stepclaw.action.STOP";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long HEARTBEAT_INTERVAL_MS = 300000;
    private static final long KEEP_ALIVE_INTERVAL_MS = 1800000;
    private static final int KEEP_ALIVE_TIMEOUT_MS = 3600000;
    private static final String TAG = "GatewayForegroundService";
    private final Handler heartbeatHandler = new Handler(Looper.getMainLooper());
    private final GatewayForegroundService$heartbeatRunnable$1 heartbeatRunnable = new Runnable() { // from class: com.stepos.stepclaw.GatewayForegroundService$heartbeatRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Object systemService = this.this$0.getSystemService("power");
            p.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            PowerManager powerManager = (PowerManager) systemService;
            boolean zIsInteractive = powerManager.isInteractive();
            boolean zIsIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(this.this$0.getPackageName());
            Log.i("GatewayForegroundService", "[CronDiag] heartbeat uptime=" + jUptimeMillis + "ms realtime=" + jElapsedRealtime + "ms screen=" + (zIsInteractive ? "on" : "off") + " batteryOptIgnored=" + zIsIgnoringBatteryOptimizations);
            this.this$0.heartbeatHandler.postDelayed(this, 300000L);
        }
    };
    private final Handler keepAliveHandler = new Handler(Looper.getMainLooper());
    private final GatewayForegroundService$keepAliveRunnable$1 keepAliveRunnable = new Runnable() { // from class: com.stepos.stepclaw.GatewayForegroundService$keepAliveRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            DynamicKeepAliveManager dynamicKeepAliveManager = DynamicKeepAliveManager.INSTANCE;
            dynamicKeepAliveManager.stop(1);
            dynamicKeepAliveManager.start(1, 3600000);
            this.this$0.keepAliveHandler.postDelayed(this, 1800000L);
        }
    };

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/stepos/stepclaw/GatewayForegroundService$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Landroid/content/Context;", "context", "Lb5/a0;", "start", "(Landroid/content/Context;)V", "stop", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "TAG", "Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "HEARTBEAT_INTERVAL_MS", "J", "KEEP_ALIVE_INTERVAL_MS", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "KEEP_ALIVE_TIMEOUT_MS", "I", "ACTION_STOP", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final void start(Context context) {
            p.e(context, "context");
            context.startService(new Intent(context, (Class<?>) GatewayForegroundService.class));
        }

        public final void stop(Context context) {
            p.e(context, "context");
            Intent action = new Intent(context, (Class<?>) GatewayForegroundService.class).setAction(GatewayForegroundService.ACTION_STOP);
            p.d(action, "setAction(...)");
            context.startService(action);
        }

        private Companion() {
        }
    }

    @Override // android.app.Service
    public Void onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "[CronDiag] service created, uptimeMillis=" + SystemClock.uptimeMillis());
        Application application = getApplication();
        p.c(application, "null cannot be cast to non-null type com.stepos.stepclaw.StepClawApp");
        ((StepClawApp) application).getRuntime();
        this.heartbeatHandler.postDelayed(this.heartbeatRunnable, HEARTBEAT_INTERVAL_MS);
        this.keepAliveHandler.post(this.keepAliveRunnable);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.i(TAG, "[CronDiag] service destroyed");
        this.heartbeatHandler.removeCallbacks(this.heartbeatRunnable);
        this.keepAliveHandler.removeCallbacks(this.keepAliveRunnable);
        DynamicKeepAliveManager.INSTANCE.stop(1);
        GatewayAutoStart.INSTANCE.stopGateway();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent != null ? intent.getAction() : null;
        if (action == null || action.hashCode() != -2073374456 || !action.equals(ACTION_STOP)) {
            return 1;
        }
        GatewayAutoStart.INSTANCE.stopGateway();
        Application application = getApplication();
        p.c(application, "null cannot be cast to non-null type com.stepos.stepclaw.StepClawApp");
        ((StepClawApp) application).getRuntime().disconnect();
        stopSelf();
        return 2;
    }

    @Override // android.app.Service
    public /* bridge */ /* synthetic */ IBinder onBind(Intent intent) {
        return (IBinder) onBind(intent);
    }
}
