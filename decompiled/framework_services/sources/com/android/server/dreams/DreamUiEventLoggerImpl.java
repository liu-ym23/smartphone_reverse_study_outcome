package com.android.server.dreams;

import com.android.internal.logging.UiEventLogger;
import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes2.dex */
public class DreamUiEventLoggerImpl implements DreamUiEventLogger {
    private final String[] mLoggableDreamPrefixes;

    DreamUiEventLoggerImpl(String[] loggableDreamPrefixes) {
        this.mLoggableDreamPrefixes = loggableDreamPrefixes;
    }

    @Override // com.android.server.dreams.DreamUiEventLogger
    public void log(UiEventLogger.UiEventEnum event, String dreamComponentName) {
        int eventID = event.getId();
        if (eventID > 0) goto L6;
        return;
    L6:
        if (isFirstPartyDream(dreamComponentName) == false) goto L8;
        String r1 = dreamComponentName;
    L9:
        FrameworkStatsLog.write(FrameworkStatsLog.DREAM_UI_EVENT_REPORTED, 0, eventID, 0, r1);
        return;
    L8:
        r1 = "other";
        goto L9
    }

    private boolean isFirstPartyDream(String dreamComponentName) {
        int i = 0;
    L4:
        if (i >= this.mLoggableDreamPrefixes.length) goto L10;
        if (dreamComponentName.startsWith(this.mLoggableDreamPrefixes[i]) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }
}
