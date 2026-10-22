package com.stepos.ailauncher.chat.trace;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.J;
import h8.C4148a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.N;
import kotlin.Result;
import kotlin.jvm.internal.p;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0004*\u0002\u0016\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/trace/e;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)V", "c", "", "PAGE_NAME", "Ljava/lang/String;", "EVENT_EXPOSE", "Ljava/util/concurrent/atomic/AtomicBoolean;", RobotInfo.STATUS_STARTED, "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "exposeReported", "Z", "appContext", "Landroid/content/Context;", "com/stepos/ailauncher/chat/trace/e$a", "screenListener", "Lcom/stepos/ailauncher/chat/trace/e$a;", "com/stepos/ailauncher/chat/trace/e$b", "unlockReceiver", "Lcom/stepos/ailauncher/chat/trace/e$b;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    private static final String EVENT_EXPOSE = "lockscreen_expose";
    private static final String PAGE_NAME = "lockscreen";
    private static Context appContext;
    private static volatile boolean exposeReported;
    public static final e INSTANCE = new e();
    private static final AtomicBoolean started = new AtomicBoolean(false);
    private static final a screenListener = new a();
    private static final b unlockReceiver = new b();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/trace/e$a", "Lcom/stepos/ailauncher/common/utils/J$a;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements J.a {
        @Override // com.stepos.ailauncher.common.utils.J.a
        public void a() {
            e.INSTANCE.c();
        }

        @Override // com.stepos.ailauncher.common.utils.J.a
        public void b() {
            e.exposeReported = false;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/trace/e$b", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (p.d(intent != null ? intent.getAction() : null, "android.intent.action.USER_PRESENT")) {
                e.exposeReported = false;
            }
        }
    }

    public final void c() {
        if (exposeReported) {
            return;
        }
        J j10 = J.INSTANCE;
        Context context = appContext;
        if (context == null) {
            p.A("appContext");
            context = null;
        }
        if (j10.f(context)) {
            return;
        }
        Context context2 = appContext;
        if (context2 == null) {
            p.A("appContext");
            context2 = null;
        }
        Object systemService = context2.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
            return;
        }
        exposeReported = true;
        C4148a.k("Track", "lockscreen_expose page=lockscreen {}", false, 4, null);
        N.a(EVENT_EXPOSE, "lockscreen", kotlin.collections.a.i());
    }

    public final void d(Context context) {
        Context context2;
        Object objB;
        p.i(context, "context");
        if (started.compareAndSet(false, true)) {
            Context applicationContext = context.getApplicationContext();
            p.h(applicationContext, "getApplicationContext(...)");
            appContext = applicationContext;
            J j10 = J.INSTANCE;
            Context context3 = appContext;
            Context context4 = null;
            if (context3 == null) {
                p.A("appContext");
                context2 = null;
            } else {
                context2 = context3;
            }
            J.c(j10, context2, screenListener, false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                Context context5 = appContext;
                if (context5 == null) {
                    p.A("appContext");
                } else {
                    context4 = context5;
                }
                objB = Result.b(context4.registerReceiver(unlockReceiver, new IntentFilter("android.intent.action.USER_PRESENT"), 2));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t("Track", "lockscreen_expose USER_PRESENT register failed", thE, false, 8, null);
            }
            c();
        }
    }
}
