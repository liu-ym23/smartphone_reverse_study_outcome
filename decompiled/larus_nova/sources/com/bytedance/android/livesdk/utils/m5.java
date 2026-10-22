package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes11.dex */
public final class m5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159080a = 0;

    static {
    }

    public static boolean a(LiveMode r100) {
        if (r100 != LiveMode.VIDEO) goto L5;
    L10:
        boolean r101 = true;
    L11:
        Boolean r102 = com.bytedance.android.livesdk.sharedpref.b.K0.getValue();
        if (r101 == true) goto L14;
    L16:
        return false;
    L14:
        if (r102.booleanValue() == false) goto L16;
        return true;
    L5:
        if (r100 == LiveMode.SCREEN_RECORD) goto L10;
        if (r100 == LiveMode.MEDIA) goto L10;
        r101 = false;
        goto L11
    }
}
