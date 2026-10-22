package com.stepos.ailauncher.chat.lockscreen;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatMainActivity;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.sheet.SheetHeightMode;
import h8.C4148a;
import k5.C4814a;
import kotlin.Metadata;
import o5.C5006a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001b\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/C;", "", "<init>", "()V", "", "source", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "e", "(Landroid/content/Context;)Z", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)V", "Landroid/content/Intent;", "routingIntent", "isInternal", "Lcom/stepos/ailauncher/chat/lockscreen/ChatMainLockRoute;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;Landroid/content/Intent;Z)Lcom/stepos/ailauncher/chat/lockscreen/ChatMainLockRoute;", "skipKeyguardRoute", "forwardFrom", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;ZLandroid/content/Intent;)V", "Landroid/app/KeyguardManager;", "f", "(Landroid/content/Context;)Landroid/app/KeyguardManager;", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class C {
    public static final C INSTANCE = new C();
    private static final String TAG = "LockScreenChatPolicy";

    public static /* synthetic */ void h(C c10, Context context, boolean z10, Intent intent, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            intent = null;
        }
        c10.g(context, z10, intent);
    }

    public final void a(Context context, String source) {
        kotlin.jvm.internal.p.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        ChatTracker.INSTANCE.y("lockscreen_shortcut");
        kotlin.jvm.internal.p.f(applicationContext);
        if (!i(applicationContext)) {
            C4148a.k(TAG, "handleLockScreenEntry -> full chat directly", false, 4, null);
            com.stepos.ailauncher.chat.trace.h.c(com.stepos.ailauncher.chat.trace.h.INSTANCE, com.stepos.ailauncher.chat.trace.h.TYPE_LOCKSCREEN_ENTRY, "success", "keyboard_input", null, null, 24, null);
            h(this, applicationContext, false, null, 6, null);
        } else {
            C4148a.k(TAG, "handleLockScreenEntry -> lock screen sheet (nine-split), source=" + source, false, 4, null);
            com.stepos.ailauncher.chat.trace.h.c(com.stepos.ailauncher.chat.trace.h.INSTANCE, com.stepos.ailauncher.chat.trace.h.TYPE_LOCKSCREEN_ENTRY, "success", "lockscreen_overlay", null, null, 24, null);
            C2739j.r(applicationContext, null, null, SheetHeightMode.FULL_9, false, false, 54, null);
        }
    }

    public final boolean b(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        KeyguardManager keyguardManagerF = f(context);
        if (keyguardManagerF == null) {
            return false;
        }
        return keyguardManagerF.isDeviceLocked();
    }

    public final boolean c(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        KeyguardManager keyguardManagerF = f(context);
        if (keyguardManagerF == null) {
            return false;
        }
        return keyguardManagerF.isKeyguardLocked();
    }

    public final boolean d(String source) {
        return kotlin.jvm.internal.p.d(source, C4814a.LOCK_SCREEN_CLICK) || kotlin.jvm.internal.p.d(source, C4814a.LOCK_SCREEN_LONG_CLICK);
    }

    public final boolean e(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        KeyguardManager keyguardManagerF = f(context);
        if (keyguardManagerF == null) {
            return false;
        }
        return keyguardManagerF.isDeviceSecure();
    }

    public final KeyguardManager f(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService instanceof KeyguardManager) {
            return (KeyguardManager) systemService;
        }
        return null;
    }

    public final void g(Context context, boolean skipKeyguardRoute, Intent forwardFrom) {
        kotlin.jvm.internal.p.i(context, "context");
        Intent intent = new Intent(context, (Class<?>) ChatMainActivity.class);
        intent.addFlags(805306368);
        C5006a.INSTANCE.a(forwardFrom, intent);
        C2682o c2682o = C2682o.INSTANCE;
        c2682o.h(intent);
        if (skipKeyguardRoute) {
            intent.putExtra(ChatMainActivity.EXTRA_SKIP_KEYGUARD_ROUTE, true);
        }
        c2682o.f(intent);
        context.startActivity(intent);
    }

    public final boolean i(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return c(context) || b(context);
    }

    public final ChatMainLockRoute j(Context context, Intent routingIntent, boolean isInternal) {
        kotlin.jvm.internal.p.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.f(applicationContext);
        return D.a(c(applicationContext), b(applicationContext), isInternal, routingIntent != null && routingIntent.getBooleanExtra(ChatMainActivity.EXTRA_SKIP_KEYGUARD_ROUTE, false), routingIntent != null && routingIntent.getBooleanExtra(ChatMainActivity.EXTRA_FROM_LOCKSCREEN_WAKE, false));
    }
}
