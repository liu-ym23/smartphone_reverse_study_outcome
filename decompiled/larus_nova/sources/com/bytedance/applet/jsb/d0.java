package com.bytedance.applet.jsb;

import android.media.AudioManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes14.dex */
public final class d0 {
    public static final boolean a(int r100) {
        Object r101 = AppHost.f326268a.getApplication().getSystemService("audio");
        if ((r101 instanceof AudioManager) == false) goto L5;
        AudioManager r102 = (AudioManager) r101;
    L7:
        if (r102 != null) goto L9;
        return false;
    L9:
        if (r100 > r102.getStreamMaxVolume(3)) goto L15;
        if (r100 < 0) goto L16;
        r102.setStreamVolume(3, r100, 1);
        FLogger.f375446a.i("AppletMusicMethod", "setSystemVolume " + r100);
        return true;
    L16:
        return false;
    L15:
        return false;
    L5:
        r102 = null;
        goto L7
    }
}
