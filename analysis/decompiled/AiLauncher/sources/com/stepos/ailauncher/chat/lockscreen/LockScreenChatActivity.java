package com.stepos.ailauncher.chat.lockscreen;

import Z8.Y;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.api.FloatCardScene;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$style;
import com.stepos.ailauncher.chat.lockscreen.C2670c;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.view.ChatView;
import com.stepos.ailauncher.chat.wake.DialogC3116e0;
import com.stepos.ailauncher.chat.wake.WakeDialogImpl;
import com.stepos.ailauncher.chat.wake.WakeService;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.lang.ref.WeakReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import o5.C5006a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007*\u00019\u0018\u0000 <2\u00020\u0001:\u0002=>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0019\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\u000fJ\u000f\u0010\u0019\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u0003J!\u0010!\u001a\u00020\u000b2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000b0\u001e¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u000b¢\u0006\u0004\b#\u0010\u0003J\r\u0010$\u001a\u00020\u000b¢\u0006\u0004\b$\u0010\u0003J\r\u0010%\u001a\u00020\u000b¢\u0006\u0004\b%\u0010\u0003J\r\u0010&\u001a\u00020\u000b¢\u0006\u0004\b&\u0010\u0003J\r\u0010'\u001a\u00020\u000b¢\u0006\u0004\b'\u0010\u0003J\r\u0010(\u001a\u00020\u000b¢\u0006\u0004\b(\u0010\u0003R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010-R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R$\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity;", "Lz5/a;", "<init>", "()V", "", "event", "Landroid/content/Intent;", "intent", "", "savedState", "sessionAction", "LY8/t;", "L", "(Ljava/lang/String;Landroid/content/Intent;Ljava/lang/Boolean;Ljava/lang/String;)V", "H", "(Landroid/content/Intent;)V", "K", "G", "R", ExifInterface.LONGITUDE_WEST, "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onNewIntent", "onResume", "onPause", "onStop", "onDestroy", "finish", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity$UnlockResult;", "onResult", "U", "(Lp9/l;)V", "N", "J", "F", "O", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_EAST, "Lcom/stepos/ailauncher/chat/lockscreen/c;", "host", "Lcom/stepos/ailauncher/chat/lockscreen/c;", "unlockHandoffInProgress", "Z", "handoffTransitionInProgress", "suppressFinishOnKeyguardGone", "screenOffReceiverRegistered", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "unlockTimeoutRunnable", "Ljava/lang/Runnable;", "pendingUnlockResultCallback", "Lp9/l;", "com/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity$c", "screenOffReceiver", "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity$c;", "Companion", "UnlockResult", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LockScreenChatActivity extends ActivityC6361a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "LockScreenChatActivity";
    private static final long UNLOCK_TIMEOUT_MS = 60000;
    private static volatile WeakReference<LockScreenChatActivity> instanceRef;
    private boolean handoffTransitionInProgress;
    private C2670c host;
    private InterfaceC5074l<? super UnlockResult, Y8.t> pendingUnlockResultCallback;
    private boolean screenOffReceiverRegistered;
    private boolean suppressFinishOnKeyguardGone;
    private boolean unlockHandoffInProgress;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Runnable unlockTimeoutRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.lockscreen.p
        @Override // java.lang.Runnable
        public final void run() {
            LockScreenChatActivity.V(this.f25507a);
        }
    };
    private final c screenOffReceiver = new c();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity$UnlockResult;", "", "<init>", "(Ljava/lang/String;I)V", AMapLocationStaticsEntity.SUCCESS_STATUS, "CANCELLED", "FAILED", "TIMEOUT", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UnlockResult {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ UnlockResult[] $VALUES;
        public static final UnlockResult SUCCESS = new UnlockResult(AMapLocationStaticsEntity.SUCCESS_STATUS, 0);
        public static final UnlockResult CANCELLED = new UnlockResult("CANCELLED", 1);
        public static final UnlockResult FAILED = new UnlockResult("FAILED", 2);
        public static final UnlockResult TIMEOUT = new UnlockResult("TIMEOUT", 3);

        private static final /* synthetic */ UnlockResult[] $values() {
            return new UnlockResult[]{SUCCESS, CANCELLED, FAILED, TIMEOUT};
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

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity$a;", "", "<init>", "()V", "", Const.INTENT_KEY_PKGNAME, "()Z", "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity;", "", "TAG", "Ljava/lang/String;", "", "UNLOCK_TIMEOUT_MS", "J", "Ljava/lang/ref/WeakReference;", "instanceRef", "Ljava/lang/ref/WeakReference;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.lockscreen.LockScreenChatActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final LockScreenChatActivity a() {
            LockScreenChatActivity lockScreenChatActivity;
            WeakReference weakReference = LockScreenChatActivity.instanceRef;
            if (weakReference == null || (lockScreenChatActivity = (LockScreenChatActivity) weakReference.get()) == null || lockScreenChatActivity.isFinishing()) {
                return null;
            }
            return lockScreenChatActivity;
        }

        public final boolean b() {
            LockScreenChatActivity lockScreenChatActivity;
            WeakReference weakReference = LockScreenChatActivity.instanceRef;
            return (weakReference == null || (lockScreenChatActivity = (LockScreenChatActivity) weakReference.get()) == null || lockScreenChatActivity.isFinishing() || lockScreenChatActivity.isDestroyed()) ? false : true;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity$b", "Landroid/app/KeyguardManager$KeyguardDismissCallback;", "LY8/t;", "onDismissSucceeded", "()V", "onDismissCancelled", "onDismissError", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends KeyguardManager.KeyguardDismissCallback {
        public b() {
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissCancelled() {
            LockScreenChatActivity.this.mainHandler.removeCallbacks(LockScreenChatActivity.this.unlockTimeoutRunnable);
            LockScreenChatActivity.this.unlockHandoffInProgress = false;
            InterfaceC5074l interfaceC5074l = LockScreenChatActivity.this.pendingUnlockResultCallback;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(UnlockResult.CANCELLED);
            }
            LockScreenChatActivity.this.pendingUnlockResultCallback = null;
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissError() {
            LockScreenChatActivity.this.mainHandler.removeCallbacks(LockScreenChatActivity.this.unlockTimeoutRunnable);
            LockScreenChatActivity.this.unlockHandoffInProgress = false;
            InterfaceC5074l interfaceC5074l = LockScreenChatActivity.this.pendingUnlockResultCallback;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(UnlockResult.FAILED);
            }
            LockScreenChatActivity.this.pendingUnlockResultCallback = null;
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissSucceeded() {
            LockScreenChatActivity.this.mainHandler.removeCallbacks(LockScreenChatActivity.this.unlockTimeoutRunnable);
            LockScreenChatActivity.this.unlockHandoffInProgress = false;
            InterfaceC5074l interfaceC5074l = LockScreenChatActivity.this.pendingUnlockResultCallback;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(UnlockResult.SUCCESS);
            }
            LockScreenChatActivity.this.pendingUnlockResultCallback = null;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/lockscreen/LockScreenChatActivity$c", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (kotlin.jvm.internal.p.d(intent != null ? intent.getAction() : null, "android.intent.action.SCREEN_OFF")) {
                C4148a.d(LockScreenChatActivity.TAG, "SCREEN_OFF -> finish", false, 4, null);
                LockScreenChatActivity.this.K();
            }
        }
    }

    public static final void I(LockScreenChatActivity lockScreenChatActivity, Intent intent) {
        C5006a c5006a = C5006a.INSTANCE;
        C2670c c2670c = lockScreenChatActivity.host;
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        c5006a.b(lockScreenChatActivity, intent, c2670c.d());
    }

    public static /* synthetic */ void M(LockScreenChatActivity lockScreenChatActivity, String str, Intent intent, Boolean bool, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            bool = null;
        }
        lockScreenChatActivity.L(str, intent, bool, str2);
    }

    public static final Y8.t P(LockScreenChatActivity lockScreenChatActivity) {
        lockScreenChatActivity.K();
        return Y8.t.f7040a;
    }

    public static final Y8.t Q(LockScreenChatActivity lockScreenChatActivity) {
        lockScreenChatActivity.K();
        return Y8.t.f7040a;
    }

    private final void R() {
        Object objB;
        if (this.screenOffReceiverRegistered) {
            return;
        }
        this.screenOffReceiverRegistered = true;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(getApplicationContext().registerReceiver(this.screenOffReceiver, new IntentFilter("android.intent.action.SCREEN_OFF"), 2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "register SCREEN_OFF failed", thE, false, 8, null);
            this.screenOffReceiverRegistered = false;
        }
    }

    public static final void T(LockScreenChatActivity lockScreenChatActivity, LockScreenChatAction lockScreenChatAction) {
        C2670c c2670c = lockScreenChatActivity.host;
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        c2670c.d().k0(lockScreenChatAction);
    }

    public static final void V(LockScreenChatActivity lockScreenChatActivity) {
        if (lockScreenChatActivity.unlockHandoffInProgress) {
            C4148a.u(TAG, "unlock timeout", false, 4, null);
            lockScreenChatActivity.unlockHandoffInProgress = false;
            InterfaceC5074l<? super UnlockResult, Y8.t> interfaceC5074l = lockScreenChatActivity.pendingUnlockResultCallback;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(UnlockResult.TIMEOUT);
            }
            lockScreenChatActivity.pendingUnlockResultCallback = null;
        }
    }

    private final void W() {
        if (this.screenOffReceiverRegistered) {
            this.screenOffReceiverRegistered = false;
            try {
                Result.Companion companion = Result.INSTANCE;
                getApplicationContext().unregisterReceiver(this.screenOffReceiver);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void E() {
        C2670c c2670c = this.host;
        C2670c c2670c2 = null;
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        if (c2670c.e()) {
            C2670c c2670c3 = this.host;
            if (c2670c3 == null) {
                kotlin.jvm.internal.p.A("host");
            } else {
                c2670c2 = c2670c3;
            }
            ChatView chatView = (ChatView) c2670c2.d().findViewById(R$id.agentChatView);
            if (chatView != null) {
                y.INSTANCE.a(chatView);
            }
        }
    }

    public final void F() {
        this.handoffTransitionInProgress = false;
        this.unlockHandoffInProgress = false;
    }

    public final void G() {
        DialogC3116e0 dialogC3116e0Y0 = InputViewManager.INSTANCE.y0();
        WakeDialogImpl wakeDialogImpl = dialogC3116e0Y0 instanceof WakeDialogImpl ? (WakeDialogImpl) dialogC3116e0Y0 : null;
        if (wakeDialogImpl == null || !wakeDialogImpl.isShowing()) {
            return;
        }
        WakeService.Companion.a0(WakeService.INSTANCE, this, false, 2, null);
    }

    public final void H(final Intent intent) {
        if (C5006a.INSTANCE.d(intent)) {
            C2670c c2670c = this.host;
            if (c2670c == null) {
                kotlin.jvm.internal.p.A("host");
                c2670c = null;
            }
            c2670c.d().post(new Runnable() { // from class: com.stepos.ailauncher.chat.lockscreen.q
                @Override // java.lang.Runnable
                public final void run() {
                    LockScreenChatActivity.I(this.f25508a, intent);
                }
            });
        }
    }

    public final void J() {
        this.handoffTransitionInProgress = false;
        this.unlockHandoffInProgress = false;
        finishAndRemoveTask();
        overridePendingTransition(0, 0);
    }

    public final void K() {
        finish();
        overridePendingTransition(0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L(java.lang.String r3, android.content.Intent r4, java.lang.Boolean r5, java.lang.String r6) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "event="
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = " instance="
            r0.append(r3)
            int r3 = java.lang.System.identityHashCode(r2)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r0.append(r3)
            java.lang.String r3 = " taskId="
            r0.append(r3)
            int r2 = r2.getTaskId()
            r0.append(r2)
            if (r5 == 0) goto L37
            boolean r2 = r5.booleanValue()
            java.lang.String r3 = " savedState="
            r0.append(r3)
            r0.append(r2)
        L37:
            java.lang.String r2 = " forceNew="
            r0.append(r2)
            r2 = 0
            if (r4 == 0) goto L49
            java.lang.String r3 = "extra_force_new_session"
            boolean r3 = r4.getBooleanExtra(r3, r2)
            r5 = 1
            if (r3 != r5) goto L49
            goto L4a
        L49:
            r5 = r2
        L4a:
            r0.append(r5)
            java.lang.String r3 = " action="
            r0.append(r3)
            r3 = 0
            if (r4 == 0) goto L5a
            java.lang.String r5 = r4.getAction()
            goto L5b
        L5a:
            r5 = r3
        L5b:
            r0.append(r5)
            java.lang.String r5 = " flags=0x"
            r0.append(r5)
            if (r4 == 0) goto L6a
            int r4 = r4.getFlags()
            goto L6b
        L6a:
            r4 = r2
        L6b:
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            r0.append(r4)
            java.lang.String r4 = " session="
            r0.append(r4)
            r0.append(r6)
            java.lang.String r4 = r0.toString()
            java.lang.String r4 = r4.toString()
            r5 = 4
            java.lang.String r6 = "LockScreenChatActivity"
            h8.C4148a.k(r6, r4, r2, r5, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.lockscreen.LockScreenChatActivity.L(java.lang.String, android.content.Intent, java.lang.Boolean, java.lang.String):void");
    }

    public final void N() {
        this.handoffTransitionInProgress = true;
        this.unlockHandoffInProgress = true;
    }

    public final void O() {
        this.suppressFinishOnKeyguardGone = true;
        C2670c c2670c = this.host;
        if (c2670c != null) {
            if (c2670c == null) {
                kotlin.jvm.internal.p.A("host");
                c2670c = null;
            }
            c2670c.d().setLockScreenMode(false);
        }
        C4148a.k(TAG, "onActionUnlockSucceeded: stay on page, lockScreenMode=false", false, 4, null);
    }

    public final void S() {
        final LockScreenChatAction lockScreenChatActionE = x.INSTANCE.e();
        if (lockScreenChatActionE == null) {
            return;
        }
        C2670c c2670c = null;
        if (this.host == null) {
            C4148a.u(TAG, "replayPendingLockScreenAction: host not initialized, action=" + lockScreenChatActionE, false, 4, null);
            return;
        }
        C4148a.k(TAG, "replayPendingLockScreenAction: action=" + lockScreenChatActionE, false, 4, null);
        C2670c c2670c2 = this.host;
        if (c2670c2 == null) {
            kotlin.jvm.internal.p.A("host");
        } else {
            c2670c = c2670c2;
        }
        c2670c.d().post(new Runnable() { // from class: com.stepos.ailauncher.chat.lockscreen.t
            @Override // java.lang.Runnable
            public final void run() {
                LockScreenChatActivity.T(this.f25512a, lockScreenChatActionE);
            }
        });
    }

    public final void U(InterfaceC5074l<? super UnlockResult, Y8.t> onResult) {
        kotlin.jvm.internal.p.i(onResult, "onResult");
        if (this.unlockHandoffInProgress) {
            return;
        }
        this.unlockHandoffInProgress = true;
        this.pendingUnlockResultCallback = onResult;
        Object systemService = getSystemService("keyguard");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        if (keyguardManager.isDeviceLocked() || keyguardManager.isKeyguardLocked()) {
            this.mainHandler.postDelayed(this.unlockTimeoutRunnable, 60000L);
            C4148a.k(TAG, "requestDismissKeyguard", false, 4, null);
            keyguardManager.requestDismissKeyguard(this, new b());
        } else {
            this.unlockHandoffInProgress = false;
            this.pendingUnlockResultCallback = null;
            onResult.invoke(UnlockResult.SUCCESS);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(1);
        setTheme(R$style.ChatMainActivityTheme);
        super.onCreate(savedInstanceState);
        instanceRef = new WeakReference<>(this);
        Intent intent = getIntent();
        boolean z10 = intent != null && intent.getBooleanExtra("extra_force_new_session", false);
        L("onCreate", getIntent(), Boolean.valueOf(savedInstanceState != null), z10 ? "create_silent" : "reuse");
        y.INSTANCE.b();
        C2670c c2670c = null;
        AgentConfig.INSTANCE.a().w(null);
        C2670c c2670c2 = new C2670c(this, new C2670c.Config(true, "lock_screen_chat_activity_float_card", Y.j(FloatCardScene.Any, FloatCardScene.Chat, FloatCardScene.ChatMainActivity), new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.lockscreen.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return LockScreenChatActivity.P(this.f25510a);
            }
        }));
        this.host = c2670c2;
        c2670c2.f();
        C2670c c2670c3 = this.host;
        if (c2670c3 == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c3 = null;
        }
        c2670c3.m(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.lockscreen.s
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return LockScreenChatActivity.Q(this.f25511a);
            }
        });
        if (z10) {
            C2670c c2670c4 = this.host;
            if (c2670c4 == null) {
                kotlin.jvm.internal.p.A("host");
            } else {
                c2670c = c2670c4;
            }
            c2670c.n(false);
        }
        R();
        G();
        H(getIntent());
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        W();
        C2670c c2670c = this.host;
        if (c2670c != null) {
            if (c2670c == null) {
                kotlin.jvm.internal.p.A("host");
                c2670c = null;
            }
            c2670c.g(isChangingConfigurations());
        }
        WeakReference<LockScreenChatActivity> weakReference = instanceRef;
        if ((weakReference != null ? weakReference.get() : null) == this) {
            instanceRef = null;
        }
        x.INSTANCE.d();
        super.onDestroy();
    }

    @Override // b.q, android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        M(this, "onNewIntent", intent, null, "reuse_lifecycle", 4, null);
        H(intent);
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        C2670c c2670c = this.host;
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        c2670c.h();
        super.onPause();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        C2670c c2670c = null;
        if (!this.unlockHandoffInProgress && !this.handoffTransitionInProgress && !this.suppressFinishOnKeyguardGone && !com.stepos.ailauncher.common.utils.E.INSTANCE.k() && !C.INSTANCE.c(this)) {
            C4148a.d(TAG, "onResume keyguard gone without handoff -> finish", false, 4, null);
            K();
            return;
        }
        C2670c c2670c2 = this.host;
        if (c2670c2 == null) {
            kotlin.jvm.internal.p.A("host");
        } else {
            c2670c = c2670c2;
        }
        c2670c.i();
        G();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStop() {
        C2670c c2670c = this.host;
        if (c2670c == null) {
            kotlin.jvm.internal.p.A("host");
            c2670c = null;
        }
        c2670c.j();
        super.onStop();
    }
}
