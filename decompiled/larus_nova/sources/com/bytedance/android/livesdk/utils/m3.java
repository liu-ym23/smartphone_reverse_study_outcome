package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdk.config.iq0;
import com.bytedance.android.livesdk.config.vh;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes11.dex */
public final class m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159078a = 0;

    static {
    }

    public static boolean a(LiveMode r100) {
        if (vh.f121449a.getValue().booleanValue() == true) goto L5;
    L9:
        return false;
    L5:
        if (r100 != LiveMode.VIDEO) goto L7;
    L8:
        return true;
    L7:
        if (r100 != LiveMode.MEDIA) goto L9;
        goto L8
    }

    public static boolean b(LiveMode r100) {
        if (iq0.f120473a.getValue().a() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100 != LiveMode.SCREEN_RECORD) goto L7;
        return true;
    }
}
