package com.stepos.ailauncher.chat;

import android.app.Activity;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/app/Activity;", "LY8/t;", "c", "(Landroid/app/Activity;)V", Const.INTENT_KEY_PKGNAME, "Landroid/content/Intent;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Intent;)Landroid/content/Intent;", "", "EXTERNAL_PICKER_LAUNCH_FLAGS", "I", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w {
    public static final int EXTERNAL_PICKER_LAUNCH_FLAGS = 8454144;

    public static final Intent a(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "<this>");
        intent.addFlags(EXTERNAL_PICKER_LAUNCH_FLAGS);
        return intent;
    }

    public static final void b(Activity activity) {
        Object objB;
        kotlin.jvm.internal.p.i(activity, "<this>");
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            activity.finishAndRemoveTask();
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u("RelayTaskFinish", "finishAndRemoveTask failed: " + thE.getMessage(), false, 4, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        if (!((Boolean) objB).booleanValue()) {
            activity.finish();
        }
        activity.overridePendingTransition(0, 0);
    }

    public static final void c(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "<this>");
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }
}
