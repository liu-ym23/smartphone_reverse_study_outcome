package com.stepos.ailauncher.common.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005*\u0001+\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u000b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/common/utils/J;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)V", "Lcom/stepos/ailauncher/common/utils/J$a;", "listener", "", "notifyCurrent", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Lcom/stepos/ailauncher/common/utils/J$a;Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/common/utils/J$a;)V", "f", "(Landroid/content/Context;)Z", "", "windowMs", Const.INTENT_KEY_BACKGROUND_COMMAND, "(J)Z", "isOff", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Z)V", "e", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "screenOff", "Ljava/util/concurrent/atomic/AtomicLong;", "lastScreenOffAt", "Ljava/util/concurrent/atomic/AtomicLong;", "lastScreenOnAt", "appContext", "Landroid/content/Context;", "com/stepos/ailauncher/common/utils/J$b", "receiver", "Lcom/stepos/ailauncher/common/utils/J$b;", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class J {
    private static final String TAG = "ScreenStateMonitor";
    private static Context appContext;
    public static final J INSTANCE = new J();
    private static final CopyOnWriteArraySet<a> listeners = new CopyOnWriteArraySet<>();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final AtomicBoolean screenOff = new AtomicBoolean(false);
    private static final AtomicLong lastScreenOffAt = new AtomicLong(0);
    private static final AtomicLong lastScreenOnAt = new AtomicLong(0);
    private static final b receiver = new b();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/common/utils/J$a;", "", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        default void a() {
        }

        default void b() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/common/utils/J$b", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode == -2128145023) {
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        J.INSTANCE.i(true);
                    }
                } else if (iHashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                    J.INSTANCE.i(false);
                }
            }
        }
    }

    public static /* synthetic */ void c(J j10, Context context, a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        j10.b(context, aVar, z10);
    }

    public final void b(Context context, a listener, boolean notifyCurrent) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(listener, "listener");
        d(context);
        listeners.add(listener);
        if (notifyCurrent) {
            if (f(context)) {
                listener.b();
            } else {
                listener.a();
            }
        }
    }

    public final void d(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        if (initialized.compareAndSet(false, true)) {
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            appContext = applicationContext;
            Context context2 = null;
            if (applicationContext == null) {
                kotlin.jvm.internal.p.A("appContext");
                applicationContext = null;
            }
            boolean zE = e(applicationContext);
            AtomicBoolean atomicBoolean = screenOff;
            atomicBoolean.set(!zE);
            if (!zE) {
                lastScreenOffAt.compareAndSet(0L, SystemClock.elapsedRealtime());
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            try {
                Result.Companion companion = Result.INSTANCE;
                Context context3 = appContext;
                if (context3 == null) {
                    kotlin.jvm.internal.p.A("appContext");
                } else {
                    context2 = context3;
                }
                context2.registerReceiver(receiver, intentFilter, 4);
                objB = Result.b(Integer.valueOf(Log.i(TAG, "registered initialScreenOff=" + atomicBoolean.get())));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                initialized.set(false);
                Log.w(TAG, "register failed", thE);
            }
        }
    }

    public final boolean e(Context context) {
        Object systemService = context.getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager != null) {
            return powerManager.isInteractive();
        }
        return true;
    }

    public final boolean f(Context context) {
        if (initialized.get()) {
            return screenOff.get();
        }
        if (context == null) {
            return false;
        }
        J j10 = INSTANCE;
        kotlin.jvm.internal.p.h(context.getApplicationContext(), "getApplicationContext(...)");
        return !j10.e(r2);
    }

    public final boolean g(long windowMs) {
        long j10 = lastScreenOnAt.get();
        long j11 = lastScreenOffAt.get();
        if (j10 != 0 && j11 != 0 && j10 >= j11) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - j10;
            if (0 <= jElapsedRealtime && jElapsedRealtime < windowMs) {
                return true;
            }
        }
        return false;
    }

    public final void h(a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        listeners.remove(listener);
    }

    public final void i(boolean isOff) {
        Object objB;
        (isOff ? lastScreenOffAt : lastScreenOnAt).set(SystemClock.elapsedRealtime());
        if (screenOff.getAndSet(isOff) == isOff) {
            return;
        }
        CopyOnWriteArraySet<a> copyOnWriteArraySet = listeners;
        Log.i(TAG, "screenState changed screenOff=" + isOff + " listeners=" + copyOnWriteArraySet.size());
        for (a aVar : copyOnWriteArraySet) {
            try {
                Result.Companion companion = Result.INSTANCE;
                if (isOff) {
                    aVar.b();
                } else {
                    aVar.a();
                }
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.w(TAG, "listener callback failed", thE);
            }
        }
    }
}
