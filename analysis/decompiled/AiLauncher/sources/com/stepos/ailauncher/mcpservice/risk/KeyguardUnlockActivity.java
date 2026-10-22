package com.stepos.ailauncher.mcpservice.risk;

import Y8.t;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/KeyguardUnlockActivity;", "Lb/q;", "<init>", "()V", "Landroid/app/KeyguardManager;", "km", "LY8/t;", "s", "(Landroid/app/KeyguardManager;)V", "t", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "", "hasFocus", "onWindowFocusChanged", "(Z)V", "onDestroy", "Lcom/stepos/ailauncher/mcpservice/risk/UnlockSceneResult;", "result", "r", "(Lcom/stepos/ailauncher/mcpservice/risk/UnlockSceneResult;)V", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "finished", "Z", "dismissRequested", "", "requestId", "Ljava/lang/String;", "Companion", Const.INTENT_KEY_APIKEY, "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KeyguardUnlockActivity extends b.q {
    private static final String EXTRA_REQUEST_ID = "extra_request_id";
    private static final String TAG = "KeyguardUnlockActivity";
    private static final long UNLOCK_TIMEOUT_MS = 60000;
    private boolean dismissRequested;
    private boolean finished;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private String requestId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap<String, InterfaceC5074l<UnlockSceneResult, t>> pendingCallbacks = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R,\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/KeyguardUnlockActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "requestId", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/mcpservice/risk/UnlockSceneResult;", "LY8/t;", "onResult", "c", "(Landroid/content/Context;Ljava/lang/String;Lp9/l;)V", "result", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lcom/stepos/ailauncher/mcpservice/risk/UnlockSceneResult;)V", "TAG", "Ljava/lang/String;", "EXTRA_REQUEST_ID", "", "UNLOCK_TIMEOUT_MS", "J", "Ljava/util/concurrent/ConcurrentHashMap;", "pendingCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.mcpservice.risk.KeyguardUnlockActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void b(String requestId, UnlockSceneResult result) {
            InterfaceC5074l interfaceC5074l = (InterfaceC5074l) KeyguardUnlockActivity.pendingCallbacks.remove(requestId);
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(result);
                return;
            }
            C4148a.u(KeyguardUnlockActivity.TAG, "dispatchResult no callback | requestId=" + requestId + ", result=" + result, false, 4, null);
        }

        public final void c(Context context, String requestId, InterfaceC5074l<? super UnlockSceneResult, t> onResult) {
            Object objB;
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(requestId, "requestId");
            kotlin.jvm.internal.p.i(onResult, "onResult");
            C4148a.k(KeyguardUnlockActivity.TAG, "requestUnlock start | requestId=" + requestId, false, 4, null);
            a.INSTANCE.f(context, "requestUnlock requestId=" + requestId);
            KeyguardUnlockActivity.pendingCallbacks.put(requestId, onResult);
            try {
                Result.Companion companion = Result.INSTANCE;
                context.startActivity(new Intent(context, (Class<?>) KeyguardUnlockActivity.class).putExtra("extra_request_id", requestId).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.g(KeyguardUnlockActivity.TAG, "startActivity failed | requestId=" + requestId, thE, false, 8, null);
                KeyguardUnlockActivity.pendingCallbacks.remove(requestId);
                onResult.invoke(UnlockSceneResult.FAILED);
            }
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/mcpservice/risk/KeyguardUnlockActivity$b", "Landroid/app/KeyguardManager$KeyguardDismissCallback;", "LY8/t;", "onDismissSucceeded", "()V", "onDismissCancelled", "onDismissError", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends KeyguardManager.KeyguardDismissCallback {
        public b() {
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissCancelled() {
            String str = KeyguardUnlockActivity.this.requestId;
            if (str == null) {
                kotlin.jvm.internal.p.A("requestId");
                str = null;
            }
            C4148a.k(KeyguardUnlockActivity.TAG, "keyguard dismiss cancelled | requestId=" + str, false, 4, null);
            KeyguardUnlockActivity.this.r(UnlockSceneResult.CANCELLED);
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissError() {
            String str = KeyguardUnlockActivity.this.requestId;
            if (str == null) {
                kotlin.jvm.internal.p.A("requestId");
                str = null;
            }
            C4148a.u(KeyguardUnlockActivity.TAG, "keyguard dismiss error | requestId=" + str, false, 4, null);
            KeyguardUnlockActivity.this.r(UnlockSceneResult.FAILED);
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissSucceeded() {
            String str = KeyguardUnlockActivity.this.requestId;
            if (str == null) {
                kotlin.jvm.internal.p.A("requestId");
                str = null;
            }
            C4148a.k(KeyguardUnlockActivity.TAG, "keyguard dismiss succeeded | requestId=" + str, false, 4, null);
            KeyguardUnlockActivity.this.r(UnlockSceneResult.SUCCESS);
        }
    }

    private final void s(KeyguardManager km) {
        String str = this.requestId;
        if (str == null) {
            kotlin.jvm.internal.p.A("requestId");
            str = null;
        }
        C4148a.k(TAG, "requestDismissKeyguard | requestId=" + str + ", isDeviceSecure=" + km.isDeviceSecure(), false, 4, null);
        km.requestDismissKeyguard(this, new b());
    }

    private final void t() {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.mcpservice.risk.b
            @Override // java.lang.Runnable
            public final void run() {
                KeyguardUnlockActivity.u(this.f27467a);
            }
        }, 60000L);
    }

    public static final void u(KeyguardUnlockActivity keyguardUnlockActivity) {
        String str = keyguardUnlockActivity.requestId;
        if (str == null) {
            kotlin.jvm.internal.p.A("requestId");
            str = null;
        }
        C4148a.u(TAG, "keyguard unlock timeout | requestId=" + str, false, 4, null);
        keyguardUnlockActivity.r(UnlockSceneResult.TIMEOUT);
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String stringExtra = getIntent().getStringExtra("extra_request_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.requestId = stringExtra;
        String str = null;
        if (stringExtra.length() == 0) {
            C4148a.h(TAG, "missing requestId, finish", false, 4, null);
            finish();
            return;
        }
        setShowWhenLocked(true);
        setTurnScreenOn(true);
        getWindow().addFlags(2621440);
        a aVar = a.INSTANCE;
        String str2 = this.requestId;
        if (str2 == null) {
            kotlin.jvm.internal.p.A("requestId");
        } else {
            str = str2;
        }
        aVar.f(this, "KeyguardUnlockActivity onCreate requestId=" + str);
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
                companion.b(str2, UnlockSceneResult.CANCELLED);
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        f fVar = f.INSTANCE;
        String str = this.requestId;
        if (str == null) {
            kotlin.jvm.internal.p.A("requestId");
            str = null;
        }
        fVar.e(str);
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
        if (keyguardManager.isDeviceLocked()) {
            t();
            s(keyguardManager);
            return;
        }
        String str = this.requestId;
        if (str == null) {
            kotlin.jvm.internal.p.A("requestId");
            str = null;
        }
        C4148a.k(TAG, "onWindowFocusChanged device already unlocked | requestId=" + str, false, 4, null);
        r(UnlockSceneResult.ALREADY_UNLOCKED);
    }

    public final void r(UnlockSceneResult result) {
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
        C4148a.k(TAG, "finishWithResult | requestId=" + str3 + ", result=" + result.toJsonValue(), false, 4, null);
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
}
