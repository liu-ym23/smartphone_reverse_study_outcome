package com.obric.agent.intents.music.netease;

import android.os.Bundle;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* JADX INFO: compiled from: CMApiManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final /* synthetic */ int a(Bundle r0) {
        return c(r0);
    }

    public static final /* synthetic */ Integer b(Bundle r0) {
        return d(r0);
    }

    private static final int c(Bundle r2) {
        if (r2 != null) goto L5;
        return 1;
    L5:
        int r3 = r2.getInt(MonitorConstants.CODE);
        if (r3 != 200) goto L8;
        return 0;
    L8:
        if (r3 != 505) goto L10;
    L15:
        return 202;
    L10:
        if (r3 == 509) goto L15;
        if (r3 != 601) goto L20;
        return 201;
    L20:
        return 1;
    }

    private static final Integer d(Bundle r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return Integer.valueOf(r1.getInt(MonitorConstants.CODE));
    }
}
