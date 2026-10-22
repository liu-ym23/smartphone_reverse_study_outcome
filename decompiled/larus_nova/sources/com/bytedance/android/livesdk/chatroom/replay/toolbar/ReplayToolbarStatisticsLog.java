package com.bytedance.android.livesdk.chatroom.replay.toolbar;

import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayToolbarStatisticsLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f109967a = 0;

    static {
    }

    @JvmStatic
    public static final void a(DataCenter r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r101 = ReplayDataContext.a.b(r100);
        if (r101 == null) goto L10;
        j<iq1.a> r102 = r101.getLoggerHelper();
        if (r102 == null) goto L11;
        final String r103 = "more_icon_show";
        r102.c(new ReplayToolbarStatisticsLog$logMoreShowOnce$1(r103));
        return;
    L11:
        return;
    }
}
