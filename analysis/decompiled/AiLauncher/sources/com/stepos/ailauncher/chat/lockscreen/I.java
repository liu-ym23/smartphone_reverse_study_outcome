package com.stepos.ailauncher.chat.lockscreen;

import Z8.X;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.SheetHeightMode;
import h8.C4148a;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import o6.C5009a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ)\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001f\u0010 J)\u0010#\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00180!¢\u0006\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010&¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/I;", "", "<init>", "()V", "", "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenGuard;", "f", "()Ljava/util/Set;", "", "source", "Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "c", "(Ljava/lang/String;)Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "", "k", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroid/content/Context;", "context", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;)Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/app/Activity;", "activity", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/app/Activity;)V", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;", "action", "sessionId", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Lcom/stepos/ailauncher/chat/lockscreen/LockScreenChatAction;Ljava/lang/String;)Z", "Lkotlin/Function1;", "onResult", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/app/Activity;Lp9/l;)V", "TAG", "Ljava/lang/String;", "KEY_OPAQUE_SCRIM", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class I {
    public static final I INSTANCE = new I();
    private static final String KEY_OPAQUE_SCRIM = "lock_screen_sheet_opaque_scrim";
    private static final String TAG = "LockScreenSheetPolicy";

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/lockscreen/I$a", "Landroid/app/KeyguardManager$KeyguardDismissCallback;", "LY8/t;", "onDismissSucceeded", "()V", "onDismissCancelled", "onDismissError", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends KeyguardManager.KeyguardDismissCallback {
        final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $onResult;

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
            this.$onResult = interfaceC5074l;
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissCancelled() {
            C4148a.u(I.TAG, "requestUnlock: cancelled", false, 4, null);
            this.$onResult.invoke(Boolean.FALSE);
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissError() {
            C4148a.u(I.TAG, "requestUnlock: error", false, 4, null);
            this.$onResult.invoke(Boolean.FALSE);
        }

        @Override // android.app.KeyguardManager.KeyguardDismissCallback
        public void onDismissSucceeded() {
            C4148a.k(I.TAG, "requestUnlock: succeeded", false, 4, null);
            this.$onResult.invoke(Boolean.TRUE);
        }
    }

    public static /* synthetic */ boolean e(I i10, Context context, LockScreenChatAction lockScreenChatAction, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = null;
        }
        return i10.d(context, lockScreenChatAction, str);
    }

    public final void a(Activity activity) {
        Object objB;
        kotlin.jvm.internal.p.i(activity, "activity");
        try {
            Result.Companion companion = Result.INSTANCE;
            activity.setShowWhenLocked(true);
            activity.setTurnScreenOn(true);
            activity.setRecentsScreenshotEnabled(false);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "applyWindowFlags failed", thE, false, 8, null);
        }
        C4148a.k(TAG, "applyWindowFlags: showWhenLocked=true turnScreenOn=true", false, 4, null);
    }

    public final void b(Activity activity) {
        Object objB;
        kotlin.jvm.internal.p.i(activity, "activity");
        try {
            Result.Companion companion = Result.INSTANCE;
            activity.setShowWhenLocked(false);
            activity.setTurnScreenOn(false);
            activity.setRecentsScreenshotEnabled(true);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "clearWindowFlags failed", thE, false, 8, null);
        }
        C4148a.k(TAG, "clearWindowFlags", false, 4, null);
    }

    public final SheetHeightMode c(String source) {
        return (source == null || source.length() == 0) ? SheetHeightMode.FULL_9 : SheetHeightMode.MINIFY_EXPANDABLE;
    }

    public final boolean d(Context context, LockScreenChatAction action, String sessionId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(action, "action");
        return x.j(x.INSTANCE, context, action, sessionId, null, 8, null);
    }

    public final Set<LockScreenGuard> f() {
        return X.d(LockScreenGuard.SCREEN_OFF);
    }

    public final boolean g(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return C.INSTANCE.c(context);
    }

    public final boolean h() {
        return C5009a.g(C5009a.INSTANCE, KEY_OPAQUE_SCRIM, false, false, 4, null);
    }

    public final void i(Activity activity, InterfaceC5074l<? super Boolean, Y8.t> onResult) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        Object systemService = activity.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
            C4148a.k(TAG, "requestUnlock: already unlocked", false, 4, null);
            onResult.invoke(Boolean.TRUE);
        } else {
            C4148a.k(TAG, "requestUnlock: requestDismissKeyguard", false, 4, null);
            keyguardManager.requestDismissKeyguard(activity, new a(onResult));
        }
    }

    public final boolean j(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return C.INSTANCE.i(context);
    }

    public final boolean k() {
        return true;
    }
}
