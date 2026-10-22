package com.stepos.ailauncher.chat.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import h8.C4148a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0002\u0015\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)V", "", "TAG", "Ljava/lang/String;", "", "RERESOLVE_DEBOUNCE_MS", "J", "Ljava/util/concurrent/atomic/AtomicBoolean;", "installed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "com/stepos/ailauncher/chat/manager/b$a", "accountCallback", "Lcom/stepos/ailauncher/chat/manager/b$a;", "Ljava/lang/Runnable;", "reresolveRunnable", "Ljava/lang/Runnable;", "com/stepos/ailauncher/chat/manager/b$b", "unlockReceiver", "Lcom/stepos/ailauncher/chat/manager/b$b;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.manager.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2686b {
    private static final long RERESOLVE_DEBOUNCE_MS = 300;
    private static final String TAG = "AccountIdentityReconciler";
    public static final C2686b INSTANCE = new C2686b();
    private static final AtomicBoolean installed = new AtomicBoolean(false);
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final a accountCallback = new a();
    private static final Runnable reresolveRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.manager.a
        @Override // java.lang.Runnable
        public final void run() {
            C2686b.e();
        }
    };
    private static final C0289b unlockReceiver = new C0289b();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/manager/b$a", "Lcom/stepos/ailauncher/foundation/account/i;", "Lcom/stepos/ailauncher/foundation/account/a;", "accountInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/account/a;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.b$a */
    public static final class a implements com.stepos.ailauncher.foundation.account.i {
        @Override // com.stepos.ailauncher.foundation.account.i
        public void a(AccountInfo accountInfo) {
            if (accountInfo != null && AuthManager.INSTANCE.Y()) {
                com.stepos.ailauncher.common.startup.g.INSTANCE.q();
                com.stepos.ailauncher.chat.tts.f.INSTANCE.h(C3197a.INSTANCE.a());
            }
            Y.INSTANCE.b();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/manager/b$b", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.b$b, reason: collision with other inner class name */
    public static final class C0289b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent == null || (action = intent.getAction()) == null) {
                return;
            }
            if (kotlin.jvm.internal.p.d(action, "android.intent.action.USER_UNLOCKED") || kotlin.jvm.internal.p.d(action, "android.intent.action.USER_PRESENT")) {
                C2686b.mainHandler.removeCallbacks(C2686b.reresolveRunnable);
                C2686b.mainHandler.postDelayed(C2686b.reresolveRunnable, 300L);
            }
        }
    }

    public static final void e() {
        C4148a.k(TAG, "reresolve after unlock/present", false, 4, null);
        com.stepos.ailauncher.foundation.account.f.INSTANCE.D();
    }

    public final void d(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        if (installed.compareAndSet(false, true)) {
            com.stepos.ailauncher.foundation.account.f fVar = com.stepos.ailauncher.foundation.account.f.INSTANCE;
            fVar.z(accountCallback);
            if (fVar.v() && AuthManager.INSTANCE.Y()) {
                com.stepos.ailauncher.common.startup.g.INSTANCE.q();
                com.stepos.ailauncher.chat.tts.f.INSTANCE.h(C3197a.INSTANCE.a());
                Y.INSTANCE.b();
            }
            Context applicationContext = context.getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_UNLOCKED");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            try {
                Result.Companion companion = Result.INSTANCE;
                applicationContext.registerReceiver(unlockReceiver, intentFilter, 2);
                objB = Result.b(Integer.valueOf(C4148a.k(TAG, "installed", false, 4, null)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                installed.set(false);
                com.stepos.ailauncher.foundation.account.f.INSTANCE.C(accountCallback);
                C4148a.t(TAG, "register unlock receiver failed", thE, false, 8, null);
            }
        }
    }
}
