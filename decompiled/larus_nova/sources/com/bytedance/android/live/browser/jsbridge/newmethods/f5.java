package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.liveinteract.plantform.model.UserType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f63374a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f63375b = null;

    static {
        int[] r100 = new int[LiveMode.values().length];
        f63374a = r100;
        r100[LiveMode.VIDEO.ordinal()] = 1;
        r100[LiveMode.SCREEN_RECORD.ordinal()] = 2;
        r100[LiveMode.THIRD_PARTY.ordinal()] = 3;
        r100[LiveMode.AUDIO.ordinal()] = 4;
        r100[LiveMode.MEDIA.ordinal()] = 5;
        int[] r101 = new int[UserType.values().length];
        f63375b = r101;
        r101[UserType.ANCHOR.ordinal()] = 1;
        r101[UserType.AUDIENCE.ordinal()] = 2;
        r101[UserType.UNKNOWN.ordinal()] = 3;
        r101[UserType.GUEST.ordinal()] = 4;
    }
}
