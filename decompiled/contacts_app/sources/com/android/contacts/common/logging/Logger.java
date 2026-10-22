package com.android.contacts.common.logging;

import android.app.Activity;
import android.text.TextUtils;
import com.android.contacts.commonbind.ObjectFactory;
import com.android.contacts.commonbind.analytics.AnalyticsUtil;
import com.google.common.net.HttpHeaders;

/* JADX INFO: loaded from: classes.dex */
public abstract class Logger {
    public static final String TAG = "Logger";

    public abstract void logScreenViewImpl(int r1, int r2);

    public abstract void logSearchEventImpl(SearchState r1);

    public Logger() {
    }

    private static Logger getInstance() {
        return ObjectFactory.getLogger();
    }

    public static void logScreenView(Activity r1, int r2) {
        logScreenView(r1, r2, 0);
    }

    public static void logScreenView(Activity r1, int r2, int r3) {
        Logger r0 = getInstance();
        if (r0 == null) goto L5;
        r0.logScreenViewImpl(r2, r3);
    L5:
        String r4 = ScreenEvent.ScreenType.getFriendlyName(r3);
        if (TextUtils.isEmpty(r4) == true) goto L8;
        r4 = HttpHeaders.FROM + r4;
    L8:
        String r5 = (String) null;
        AnalyticsUtil.sendScreenView(null, r1, r4);
    }

    public static void logSearchEvent(SearchState r1) {
        Logger r0 = getInstance();
        if (r0 == null) goto L6;
        r0.logSearchEventImpl(r1);
        return;
    }
}
