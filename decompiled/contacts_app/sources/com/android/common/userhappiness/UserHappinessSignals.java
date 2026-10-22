package com.android.common.userhappiness;

import android.content.Context;
import android.content.Intent;
import com.android.common.speech.LoggingEvents;

/* JADX INFO: loaded from: classes.dex */
public class UserHappinessSignals {
    private static boolean mHasVoiceLoggingInfo = false;

    static {
    }

    public UserHappinessSignals() {
    }

    public static void setHasVoiceLoggingInfo(boolean r0) {
        mHasVoiceLoggingInfo = r0;
    }

    public static void userAcceptedImeText(Context r4) {
        if (mHasVoiceLoggingInfo == false) goto L6;
        Intent r0 = new Intent(LoggingEvents.ACTION_LOG_EVENT);
        r0.putExtra(LoggingEvents.EXTRA_APP_NAME, LoggingEvents.VoiceIme.APP_NAME);
        r0.putExtra(LoggingEvents.EXTRA_EVENT, 21);
        r0.putExtra("", r4.getPackageName());
        r0.putExtra("timestamp", System.currentTimeMillis());
        r4.sendBroadcast(r0);
        setHasVoiceLoggingInfo(false);
        return;
    }
}
