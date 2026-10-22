package com.stepos.ailauncher.mcpservice.risk;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\bJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "c", "(Landroid/content/Context;)Z", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_COMMAND, "e", "", "label", "LY8/t;", "f", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final String TAG = "KeyguardHelper";

    public final boolean a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Object systemService = context.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        return keyguardManager != null && keyguardManager.isDeviceLocked();
    }

    public final boolean b(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Object systemService = context.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        return keyguardManager != null && keyguardManager.isDeviceSecure();
    }

    public final boolean c(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Object systemService = context.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        return keyguardManager != null && keyguardManager.isKeyguardLocked();
    }

    public final boolean d(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Object systemService = context.getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        return powerManager != null && powerManager.isInteractive();
    }

    public final boolean e(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return d(context) && !g(context);
    }

    public final void f(Context context, String label) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(label, "label");
        boolean zB = b(context);
        boolean zC = c(context);
        boolean zA = a(context);
        boolean zD = d(context);
        boolean z10 = zB && zC && !zA;
        C4148a.k(TAG, label + " | deviceSecure=" + zB + ", keyguardLocked=" + zC + ", deviceLocked=" + zA + ", requiresUnlock=" + g(context) + ", screenOn=" + zD + ", unlockedAndScreenOn=" + e(context) + ", trustAgentSuspected=" + z10, false, 4, null);
    }

    public final boolean g(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return a(context);
    }
}
