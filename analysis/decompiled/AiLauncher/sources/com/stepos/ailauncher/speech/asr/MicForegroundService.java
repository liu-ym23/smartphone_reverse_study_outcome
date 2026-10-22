package com.stepos.ailauncher.speech.asr;

import Y8.t;
import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.j;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3202f;
import com.stepos.ailauncher.common.utils.J;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0003¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/MicForegroundService;", "Landroid/app/Service;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "LY8/t;", "onDestroy", "s", "Companion", Const.INTENT_KEY_PKGNAME, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MicForegroundService extends Service {
    private static final String CHANNEL_ID = "mic_recording";
    private static final String CHANNEL_NAME = "语音输入";
    private static final int NOTIFICATION_ID = 19785;
    private static final long SCREEN_OFF_FORCE_STOP_DELAY_MS = 1000;
    private static final long START_PENDING_TIMEOUT_MS = 12000;
    private static final String TAG = "MicFgService";
    private static volatile Context appContextForGuard;
    private static int inFlightStarts;
    private static boolean pendingStopRequested;
    private static volatile CountDownLatch startedLatch;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object stateLock = new Object();
    private static final AtomicInteger epoch = new AtomicInteger(0);
    private static final AtomicBoolean running = new AtomicBoolean(false);
    private static final AtomicBoolean screenGuardInstalled = new AtomicBoolean(false);
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final Runnable forceStopOnScreenOff = new Runnable() { // from class: com.stepos.ailauncher.speech.asr.e
        @Override // java.lang.Runnable
        public final void run() {
            MicForegroundService.r();
        }
    };
    private static final Runnable startPendingTimeout = new Runnable() { // from class: com.stepos.ailauncher.speech.asr.f
        @Override // java.lang.Runnable
        public final void run() {
            MicForegroundService.t();
        }
    };
    private static final a screenListener = new a();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/speech/asr/MicForegroundService$a", "Lcom/stepos/ailauncher/common/utils/J$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements J.a {
        @Override // com.stepos.ailauncher.common.utils.J.a
        public void a() {
            MicForegroundService.mainHandler.removeCallbacks(MicForegroundService.forceStopOnScreenOff);
        }

        @Override // com.stepos.ailauncher.common.utils.J.a
        public void b() {
            if (MicForegroundService.running.get()) {
                MicForegroundService.mainHandler.removeCallbacks(MicForegroundService.forceStopOnScreenOff);
                MicForegroundService.mainHandler.postDelayed(MicForegroundService.forceStopOnScreenOff, 1000L);
            }
        }
    }

    @Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004*\u0001?\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\bR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010#R\u0016\u0010-\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006B"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/MicForegroundService$b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;)I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "timeoutMs", "c", "(J)V", M5.b.CREDENTIAL_TOKEN, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;I)V", "f", "", Const.INTENT_KEY_UMID, "()Z", "restoreStop", Const.INTENT_KEY_APIKEY, "(Z)Z", "e", "k", "", "TAG", "Ljava/lang/String;", "CHANNEL_ID", "CHANNEL_NAME", "NOTIFICATION_ID", "I", "SCREEN_OFF_FORCE_STOP_DELAY_MS", "J", "START_PENDING_TIMEOUT_MS", "Ljava/util/concurrent/CountDownLatch;", "startedLatch", "Ljava/util/concurrent/CountDownLatch;", "stateLock", "Ljava/lang/Object;", "inFlightStarts", "pendingStopRequested", "Z", "Ljava/util/concurrent/atomic/AtomicInteger;", "epoch", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "running", "Ljava/util/concurrent/atomic/AtomicBoolean;", "screenGuardInstalled", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "forceStopOnScreenOff", "Ljava/lang/Runnable;", "startPendingTimeout", "appContextForGuard", "Landroid/content/Context;", "com/stepos/ailauncher/speech/asr/MicForegroundService$a", "screenListener", "Lcom/stepos/ailauncher/speech/asr/MicForegroundService$a;", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.speech.asr.MicForegroundService$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a(boolean restoreStop) {
            return e(restoreStop);
        }

        public final void c(long timeoutMs) {
            try {
                Result.Companion companion = Result.INSTANCE;
                CountDownLatch countDownLatch = MicForegroundService.startedLatch;
                Result.b(countDownLatch != null ? Boolean.valueOf(countDownLatch.await(timeoutMs, TimeUnit.MILLISECONDS)) : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }

        public final boolean d() {
            return e(false);
        }

        public final boolean e(boolean restoreStop) {
            boolean z10;
            synchronized (MicForegroundService.stateLock) {
                try {
                    if (MicForegroundService.inFlightStarts > 0) {
                        MicForegroundService.inFlightStarts--;
                    }
                    if (restoreStop) {
                        MicForegroundService.pendingStopRequested = true;
                    }
                    z10 = false;
                    if (MicForegroundService.inFlightStarts <= 0) {
                        MicForegroundService.mainHandler.removeCallbacks(MicForegroundService.startPendingTimeout);
                        boolean z11 = MicForegroundService.pendingStopRequested;
                        MicForegroundService.pendingStopRequested = false;
                        z10 = z11;
                    }
                } finally {
                }
            }
            return z10;
        }

        public final void f(Context context) {
            p.i(context, "context");
            MicForegroundService.mainHandler.removeCallbacks(MicForegroundService.forceStopOnScreenOff);
            MicForegroundService.epoch.incrementAndGet();
            k(context);
        }

        public final void g(Context context) {
            p.i(context, "context");
            if (MicForegroundService.screenGuardInstalled.compareAndSet(false, true)) {
                Context applicationContext = context.getApplicationContext();
                MicForegroundService.appContextForGuard = applicationContext;
                J j10 = J.INSTANCE;
                p.f(applicationContext);
                J.c(j10, applicationContext, MicForegroundService.screenListener, false, 4, null);
                Log.i(MicForegroundService.TAG, "screenOff guard installed");
            }
        }

        public final int h(Context context) {
            boolean z10;
            p.i(context, "context");
            g(context);
            MicForegroundService.mainHandler.removeCallbacks(MicForegroundService.forceStopOnScreenOff);
            int iIncrementAndGet = MicForegroundService.epoch.incrementAndGet();
            MicForegroundService.startedLatch = new CountDownLatch(1);
            synchronized (MicForegroundService.stateLock) {
                MicForegroundService.running.set(true);
                MicForegroundService.inFlightStarts++;
                z10 = MicForegroundService.pendingStopRequested;
                MicForegroundService.pendingStopRequested = false;
                t tVar = t.f7040a;
            }
            MicForegroundService.mainHandler.removeCallbacks(MicForegroundService.startPendingTimeout);
            MicForegroundService.mainHandler.postDelayed(MicForegroundService.startPendingTimeout, MicForegroundService.START_PENDING_TIMEOUT_MS);
            try {
                context.startForegroundService(new Intent(context, (Class<?>) MicForegroundService.class));
                return iIncrementAndGet;
            } catch (Throwable th) {
                Log.e(MicForegroundService.TAG, "startForegroundService failed", th);
                MicForegroundService.running.set(false);
                CountDownLatch countDownLatch = MicForegroundService.startedLatch;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
                if (a(z10)) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Result.b(Boolean.valueOf(context.stopService(new Intent(context, (Class<?>) MicForegroundService.class))));
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.b(C4849c.a(th2));
                    }
                }
                return 0;
            }
        }

        public final int i(Context context) {
            p.i(context, "context");
            C3202f c3202f = C3202f.INSTANCE;
            String strD = c3202f.d();
            if (c3202f.e()) {
                Log.i(MicForegroundService.TAG, "skip FGS: isForeground top=" + strD);
                return 0;
            }
            Log.i(MicForegroundService.TAG, "start FGS: !isForeground top=" + strD);
            return h(context);
        }

        public final void j(Context context, int token) {
            p.i(context, "context");
            if (token == 0 || token != MicForegroundService.epoch.get()) {
                return;
            }
            MicForegroundService.mainHandler.removeCallbacks(MicForegroundService.forceStopOnScreenOff);
            k(context);
        }

        public final void k(Context context) {
            boolean z10;
            synchronized (MicForegroundService.stateLock) {
                z10 = false;
                MicForegroundService.running.set(false);
                if (MicForegroundService.inFlightStarts > 0) {
                    z10 = true;
                    MicForegroundService.pendingStopRequested = true;
                }
            }
            if (z10) {
                Log.w(MicForegroundService.TAG, "defer stopService: FGS start still pending");
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.b(Boolean.valueOf(context.stopService(new Intent(context, (Class<?>) MicForegroundService.class))));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }

        public Companion() {
        }
    }

    public static final void r() {
        if (running.get()) {
            Log.w(TAG, "SCREEN_OFF guard: force stop residual MicForegroundService");
            Context context = appContextForGuard;
            if (context != null) {
                INSTANCE.f(context);
            }
        }
    }

    public static final void t() {
        Context context;
        synchronized (stateLock) {
            if (inFlightStarts == 0) {
                return;
            }
            inFlightStarts = 0;
            boolean z10 = pendingStopRequested;
            pendingStopRequested = false;
            Log.w(TAG, "FGS start pending timeout, stopNow=" + z10);
            if (!z10 || (context = appContextForGuard) == null) {
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.b(Boolean.valueOf(context.stopService(new Intent(context, (Class<?>) MicForegroundService.class))));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        running.set(false);
        try {
            Result.Companion companion = Result.INSTANCE;
            stopForeground(1);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        s();
        return 2;
    }

    public final void s() {
        Object objB;
        boolean zBooleanValue;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 2));
        }
        Notification notificationB = new j.d(this, CHANNEL_ID).j("正在聆听").i("语音输入进行中").p(R.drawable.ic_btn_speak_now).o(-2).b();
        p.h(notificationB, "build(...)");
        try {
            startForeground(NOTIFICATION_ID, notificationB, 128);
            CountDownLatch countDownLatch = startedLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            zBooleanValue = true;
        } catch (Throwable th) {
            try {
                Log.e(TAG, "startForeground(microphone) failed", th);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    startForeground(NOTIFICATION_ID, notificationB, 0);
                    objB = Result.b(Boolean.TRUE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th2));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    Log.e(TAG, "startForeground(none) fallback failed", thE);
                    objB = Boolean.FALSE;
                }
                zBooleanValue = ((Boolean) objB).booleanValue();
            } finally {
                CountDownLatch countDownLatch2 = startedLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
            }
        }
        if (INSTANCE.d()) {
            Log.w(TAG, "stopSelf: stop requested during FGS start window enteredForeground=" + zBooleanValue);
            stopSelf();
        }
    }
}
