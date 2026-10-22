package com.stepos.ability.voicewakeup;

import android.content.Context;
import android.util.Log;
import kotlinx.coroutines.flow.d;
import p9.c;

/* loaded from: classes3.dex */
public abstract class a {
    public static c a(Context context, String str) {
        return d.f(d.c(new VoicePermissionStorage$observeGranted$1(context, str, null)));
    }

    public static void b(Context context, String str, boolean z10) {
        Log.i("VoicePermissionStorage", "setGranted userId=" + str + " granted=" + z10);
        context.getApplicationContext().getSharedPreferences("voice_wakeup_permission", 0).edit().putBoolean("consent_".concat(str), z10).putString("last_user_id", str).apply();
        context.getApplicationContext().getContentResolver().notifyChange(VoicePermissionProvider.c, null);
    }
}
