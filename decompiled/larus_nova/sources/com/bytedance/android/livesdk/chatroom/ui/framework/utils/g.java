package com.bytedance.android.livesdk.chatroom.ui.framework.utils;

import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.config.kc0;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f113032a = 0;

    static {
    }

    public static int a(boolean r100) {
        boolean r101 = MultiLinkLoadWidgetUtils.f();
        kc0 r102 = kc0.f120590a;
        boolean r103 = r102.getValue().isLoadBeforeP0();
        boolean r104 = r102.getValue().isLoadAfterP0();
        if (r100 == false) goto L9;
        if (r101 == false) goto L9;
        if (r103 == false) goto L9;
        return 0;
    L9:
        if (r100 == false) goto L13;
        if (r101 == false) goto L13;
        if (r104 == false) goto L13;
        return 1;
    L13:
        if (r100 == true) goto L17;
        if (r101 == false) goto L17;
        if (r103 == false) goto L17;
        return 1;
    L17:
        if (r100 == true) goto L22;
        if (r101 == false) goto L24;
        if (r104 == false) goto L25;
        return 2;
    L25:
        return 3;
    L24:
        return 3;
    L22:
        return 3;
    }
}
