package com.stepos.ailauncher.chat.lockscreen;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/LockScreenUnlockActivity;", "Lb/q;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "", "hasFocus", "onWindowFocusChanged", "(Z)V", "onDestroy", "Landroid/app/KeyguardManager;", "km", "s", "(Landroid/app/KeyguardManager;)V", "t", "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenUnlockActivity$UnlockResult;", "result", "r", "(Lcom/stepos/ailauncher/chat/lockscreen/LockScreenUnlockActivity$UnlockResult;)V", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "finished", "Z", "dismissRequested", "", "requestId", "Ljava/lang/String;", "Companion", "UnlockResult", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LockScreenUnlockActivity extends b.q {
    private static final String EXTRA_REQUEST_ID = "extra_request_id";
    private static final String TAG = "LockScreenUnlockActivity";
    private static final long UNLOCK_TIMEOUT_MS = 60000;
    private boolean dismissRequested;
    private boolean finished;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private String requestId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap<String, InterfaceC5074l<UnlockResult, Y8.t>> pendingCallbacks = new ConcurrentHashMap<>();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/LockScreenUnlockActivity$UnlockResult;", "", "<init>", "(Ljava/lang/String;I)V", AMapLocationStaticsEntity.SUCCESS_STATUS, "CANCELLED", "FAILED", "TIMEOUT", "ALREADY_UNLOCKED", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UnlockResult {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ UnlockResult[] $VALUES;
        public static final UnlockResult SUCCESS = new UnlockResult(AMapLocationStaticsEntity.SUCCESS_STATUS, 0);
        public static final UnlockResult CANCELLED = new UnlockResult("CANCELLED", 1);
        public static final UnlockResult FAILED = new UnlockResult("FAILED", 2);
        public static final UnlockResult TIMEOUT = new UnlockResult("TIMEOUT", 3);
        public static final UnlockResult ALREADY_UNLOCKED = new UnlockResult("ALREADY_UNLOCKED", 4);

        private static final /* synthetic */ UnlockResult[] $values() {
            return new UnlockResult[]{SUCCESS, CANCELLED, FAILED, TIMEOUT, ALREADY_UNLOCKED};
        }

        static {
            UnlockResult[] unlockResultArr$values = $values();
            $VALUES = unlockResultArr$values;
            $ENTRIES = kotlin.enums.a.a(unlockResultArr$values);
        }

        private UnlockResult(String str, int i10) {
        }

        public static InterfaceC4149a<UnlockResult> getEntries() {
            return $ENTRIES;
        }

        public static UnlockResult valueOf(String str) {
            return (UnlockResult) Enum.valueOf(UnlockResult.class, str);
        }

        public static UnlockResult[] values() {
            return (UnlockResult[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R,\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/LockScreenUnlockActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "requestId", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenUnlockActivity$UnlockResult;", "LY8/t;", "onResult", "c", "(Landroid/content/Context;Ljava/lang/String;Lp9/l;)V", "result", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lcom/stepos/ailauncher/chat/lockscreen/LockScreenUnlockActivity$UnlockResult;)V", "TAG", "Ljava/lang/String;", "EXTRA_REQUEST_ID", "", "UNLOCK_TIMEOUT_MS", "J", "Ljava/util/concurrent/ConcurrentHashMap;", "pendingCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.lockscreen.LockScreenUnlockActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void b(String requestId, UnlockResult result) {
            InterfaceC5074l interfaceC5074l = (InterfaceC5074l) LockScreenUnlockActivity.pendingCallbacks.remove(requestId);
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(result);
                return;
            }
            C4148a.u(LockScreenUnlockActivity.TAG, "dispatchResult no callback | requestId=" + requestId + ", result=" + result, false, 4, null);
        }

        public final void c(Context context, String requestId, InterfaceC5074l<? super UnlockResult, Y8.t> onResult) {
            Object objB;
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(requestId, "requestId");
            kotlin.jvm.internal.p.i(onResult, "onResult");
            C4148a.k(LockScreenUnlockActivity.TAG, "requestUnlock start | requestId=" + requestId, false, 4, null);
            LockScreenUnlockActivity.pendingCallbacks.put(requestId, onResult);
            try {
                Result.Companion companion = Result.INSTANCE;
                context.startActivity(new Intent(context, (Class<?>) LockScreenUnlockActivity.class).putExtra("extra_request_id", requestId).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.g(LockScreenUnlockActivity.TAG, "startActivity failed | requestId=" + requestId, thE, false, 8, null);
                LockScreenUnlockActivity.pendingCallbacks.remove(requestId);
                onResult.invoke(UnlockResult.FAILED);
            }
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/lockscreen/LockScreenUnlockActivity$b", "Landroid/app/KeyguardManager$KeyguardDismissCallback;", "LY8/t;", "onDismissSucceeded", "()V", "onDismissCancelled", "onDismissError", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends KeyguardManager.KeyguardDismissCallback {
        public b() {
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissCancelled() {
            String str = LockScreenUnlockActivity.this.requestId;
            if (str == null) {
                kotlin.jvm.internal.p.A("requestId");
                str = null;
            }
            C4148a.k(LockScreenUnlockActivity.TAG, "keyguard dismiss cancelled | requestId=" + str, false, 4, null);
            LockScreenUnlockActivity.this.r(UnlockResult.CANCELLED);
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissError() {
            String str = LockScreenUnlockActivity.this.requestId;
            if (str == null) {
                kotlin.jvm.internal.p.A("requestId");
                str = null;
            }
            C4148a.u(LockScreenUnlockActivity.TAG, "keyguard dismiss error | requestId=" + str, false, 4, null);
            LockScreenUnlockActivity.this.r(UnlockResult.FAILED);
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissSucceeded() {
            String str = LockScreenUnlockActivity.this.requestId;
            if (str == null) {
                kotlin.jvm.internal.p.A("requestId");
                str = null;
            }
            C4148a.k(LockScreenUnlockActivity.TAG, "keyguard dismiss succeeded | requestId=" + str, false, 4, null);
            LockScreenUnlockActivity.this.r(UnlockResult.SUCCESS);
        }
    }

    public static final void u(LockScreenUnlockActivity lockScreenUnlockActivity) {
        String str = lockScreenUnlockActivity.requestId;
        if (str == null) {
            kotlin.jvm.internal.p.A("requestId");
            str = null;
        }
        C4148a.u(TAG, "keyguard unlock timeout | requestId=" + str, false, 4, null);
        lockScreenUnlockActivity.r(UnlockResult.TIMEOUT);
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String stringExtra = getIntent().getStringExtra("extra_request_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.requestId = stringExtra;
        if (stringExtra.length() == 0) {
            C4148a.h(TAG, "missing requestId, finish", false, 4, null);
            finish();
            return;
        }
        setShowWhenLocked(true);
        setTurnScreenOn(true);
        String str = this.requestId;
        if (str == null) {
            kotlin.jvm.internal.p.A("requestId");
            str = null;
        }
        C4148a.k(TAG, "onCreate requestId=" + str, false, 4, null);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (!this.finished) {
            String str = this.requestId;
            String str2 = null;
            if (str == null) {
                kotlin.jvm.internal.p.A("requestId");
                str = null;
            }
            if (str.length() > 0) {
                String str3 = this.requestId;
                if (str3 == null) {
                    kotlin.jvm.internal.p.A("requestId");
                    str3 = null;
                }
                C4148a.u(TAG, "destroyed before unlock finished | requestId=" + str3, false, 4, null);
                this.finished = true;
                this.mainHandler.removeCallbacksAndMessages(null);
                Companion companion = INSTANCE;
                String str4 = this.requestId;
                if (str4 == null) {
                    kotlin.jvm.internal.p.A("requestId");
                } else {
                    str2 = str4;
                }
                companion.b(str2, UnlockResult.CANCELLED);
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!hasFocus || this.dismissRequested) {
            return;
        }
        this.dismissRequested = true;
        Object systemService = getSystemService("keyguard");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        if (L.a(keyguardManager.isDeviceLocked(), keyguardManager.isKeyguardLocked())) {
            t();
            s(keyguardManager);
            return;
        }
        String str = this.requestId;
        if (str == null) {
            kotlin.jvm.internal.p.A("requestId");
            str = null;
        }
        C4148a.k(TAG, "onWindowFocusChanged keyguard already gone | requestId=" + str, false, 4, null);
        r(UnlockResult.ALREADY_UNLOCKED);
    }

    public final void r(UnlockResult result) {
        String str = null;
        if (this.finished) {
            String str2 = this.requestId;
            if (str2 == null) {
                kotlin.jvm.internal.p.A("requestId");
                str2 = null;
            }
            C4148a.u(TAG, "finishWithResult ignored duplicate | requestId=" + str2 + ", result=" + result, false, 4, null);
            return;
        }
        this.finished = true;
        this.mainHandler.removeCallbacksAndMessages(null);
        String str3 = this.requestId;
        if (str3 == null) {
            kotlin.jvm.internal.p.A("requestId");
            str3 = null;
        }
        C4148a.k(TAG, "finishWithResult | requestId=" + str3 + ", result=" + result, false, 4, null);
        Companion companion = INSTANCE;
        String str4 = this.requestId;
        if (str4 == null) {
            kotlin.jvm.internal.p.A("requestId");
        } else {
            str = str4;
        }
        companion.b(str, result);
        finish();
    }

    public final void s(KeyguardManager km) {
        String str = this.requestId;
        if (str == null) {
            kotlin.jvm.internal.p.A("requestId");
            str = null;
        }
        C4148a.k(TAG, "requestDismissKeyguard | requestId=" + str + ", isDeviceSecure=" + km.isDeviceSecure(), false, 4, null);
        km.requestDismissKeyguard(this, new b());
    }

    public final void t() {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.lockscreen.K
            @Override // java.lang.Runnable
            public final void run() {
                LockScreenUnlockActivity.u(this.f25496a);
            }
        }, 60000L);
    }
}
