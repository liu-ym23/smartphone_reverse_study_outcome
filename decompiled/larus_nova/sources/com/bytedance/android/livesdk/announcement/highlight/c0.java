package com.bytedance.android.livesdk.announcement.highlight;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f103470a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "closeType");
        NewBroadcastMonitor.a r101 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_AUDIENCE_CLOSE, null, null, 14);
        r101.c(r100);
        r101.a().report();
    }

    public static void c(int r100) {
        NewBroadcastMonitor.a r101 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_PUBLISH_STATUS, null, null, 14);
        r101.l(r100);
        r101.a().report();
    }

    public static void e(int r100) {
        NewBroadcastMonitor.a r101 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_UN_PUBLISH_STATUS, null, null, 14);
        r101.l(r100);
        r101.a().report();
    }

    public static void d(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        NewBroadcastMonitor.a r102 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_SHOW, null, null, 14);
        r102.c(String.valueOf(r100));
        r102.d(r101);
        r102.a().report();
    }

    public static void b(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, "conflictItems");
        NewBroadcastMonitor.a r103 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_ANNOUNCEMENT_HIGHLIGHT_HIDE, null, null, 14);
        r103.c(String.valueOf(r100));
        r103.d(r101);
        r103.i("conflict", r102);
        r103.a().report();
    }
}
