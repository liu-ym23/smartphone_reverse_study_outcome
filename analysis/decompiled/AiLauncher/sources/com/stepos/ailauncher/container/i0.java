package com.stepos.ailauncher.container;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/container/i0;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)V", "", "TAG", "Ljava/lang/String;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class i0 {
    public static final i0 INSTANCE = new i0();
    private static final String TAG = "OverlayReconnector";

    public final void a(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        if (MainScrollOverlayComponent.INSTANCE.b()) {
            Log.i(TAG, "overlay reconnect skipped: component already serving");
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            context.getApplicationContext().sendBroadcast(new Intent("com.stepos.launcher.OVERLAY_UPGRADE_COMPLETE"));
            objB = Result.b(Integer.valueOf(Log.i(TAG, "overlay reconnect broadcast sent")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "send overlay reconnect broadcast failed: " + thE.getMessage());
        }
    }
}
