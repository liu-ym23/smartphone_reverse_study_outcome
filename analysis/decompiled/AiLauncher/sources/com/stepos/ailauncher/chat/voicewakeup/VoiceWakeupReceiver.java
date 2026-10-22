package com.stepos.ailauncher.chat.voicewakeup;

import C5.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.h;
import com.stepos.ailauncher.chat.wake.StartBroadcastReceiver;
import com.stepos.ailauncher.chat.wake.WakeService;
import h8.C4148a;
import k5.C4814a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.C5851b;
import x5.C5852c;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/voicewakeup/VoiceWakeupReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)V", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceWakeupReceiver extends BroadcastReceiver {
    public static final String ACTION_STATE_CHANGED = "com.stepos.ability.voicewakeup.ACTION_STATE_CHANGED";
    public static final String ACTION_TRAINING_COMPLETE = "com.stepos.ability.voicewakeup.ACTION_TRAINING_COMPLETE";
    public static final String ACTION_WAKEUP = "com.stepos.ability.voicewakeup.ACTION_WAKEUP";
    public static final String EXTRA_STATE = "state";
    private static final String TAG = "VoiceWakeupReceiver";
    private static final long WAKELOCK_MS = 5000;
    private static final String WAKELOCK_TAG = "AILauncher:voice_wakeup";
    private static long lastAcceptedWakeUptimeMs;

    public final void a(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -653020313) {
                if (action.equals(ACTION_TRAINING_COMPLETE)) {
                    C4148a.k(TAG, "onReceive: ACTION_TRAINING_COMPLETE", false, 4, null);
                    C5851b.INSTANCE.d();
                    return;
                }
                return;
            }
            if (iHashCode == -453181009) {
                if (action.equals(ACTION_STATE_CHANGED)) {
                    C4148a.u(TAG, "onReceive: ACTION_STATE_CHANGED state=" + intent.getIntExtra(EXTRA_STATE, 0), false, 4, null);
                    return;
                }
                return;
            }
            if (iHashCode == 355163766 && action.equals(ACTION_WAKEUP)) {
                C4148a.k(TAG, "onReceive: ACTION_WAKEUP", false, 4, null);
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (C5852c.a(jElapsedRealtime, lastAcceptedWakeUptimeMs)) {
                    C4148a.k(TAG, "ignore duplicate ACTION_WAKEUP gap=" + (jElapsedRealtime - lastAcceptedWakeUptimeMs) + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
                    return;
                }
                lastAcceptedWakeUptimeMs = jElapsedRealtime;
                WakeService.Companion companion = WakeService.INSTANCE;
                if (companion.N(context, "voice_wakeup")) {
                    b(context);
                    Intent intent2 = new Intent();
                    intent2.putExtra(C4814a.PARAM_SOURCE, "voice_wakeup");
                    companion.J1(context, intent2);
                }
            }
        }
    }

    public final void b(Context context) {
        Object systemService = context.getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager == null || powerManager.isInteractive()) {
            return;
        }
        powerManager.newWakeLock(268435462, WAKELOCK_TAG).acquire(5000L);
        h.i(h.INSTANCE, "voice_wakeup", "success", null, null, null, 28, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        p.i(context, "context");
        p.i(intent, "intent");
        C4148a.k(TAG, "onReceive: " + intent.getAction(), false, 4, null);
        if (b.a(context, this, "voice_wakeup") && intent.getIntExtra(StartBroadcastReceiver.OOBE_COMPLETE_KEY, 1) != 0) {
            a(context, intent);
        }
    }
}
