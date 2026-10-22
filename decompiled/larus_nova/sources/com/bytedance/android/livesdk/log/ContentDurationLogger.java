package com.bytedance.android.livesdk.log;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ContentDurationLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f153270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f153271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f153272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f153273d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        RoomContext.a r100 = RoomContext.Companion;
        RoomContext r101 = RoomContext.a.c(r100, this.f153273d, 0, 2);
        if (r101 != null) goto L5;
    L25:
        ALogger.i("ContentDurationLogger", "Report content duration failed for non-vs room.");
        return;
    L5:
        if (r101.isVSRoom() != true) goto L25;
        if (this.f153272c == false) goto L12;
        ALogger.i("ContentDurationLogger", "Report content duration failed for duplicate reporting.");
        return;
    L12:
        if (this.f153270a > 0) goto L14;
    L23:
        ALogger.i("ContentDurationLogger", "Report content duration failed for invalid startTime: " + this.f153270a + " or contentId: " + this.f153271b + '.');
        return;
    L14:
        if (this.f153271b <= 0) goto L23;
        long r102 = System.currentTimeMillis();
        final long r103 = r102 - this.f153270a;
        ALogger.i("ContentDurationLogger", "Start reporting content duration for contentId " + this.f153271b + " with duration " + r103 + " ms");
        RoomContext r104 = RoomContext.a.c(r100, null, 0, 3);
        if (r104 == null) goto L21;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.l> r105 = r104.getLoggerHelper();
        if (r105 == null) goto L21;
        r105.c(new ContentDurationLogger$reportDuration$1(this, r103));
    L21:
        this.f153270a = r102;
        this.f153272c = true;
    }

    public ContentDurationLogger(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f153273d = r100;
    }

    public final void b(long r100) {
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, this.f153273d, 0, 2);
        if (r101 != null) goto L5;
    L14:
        ALogger.i("ContentDurationLogger", "Start recording content duration failed for non-vs room.");
        return;
    L5:
        if (r101.isVSRoom() != true) goto L14;
        ALogger.i("ContentDurationLogger", "Start recording content duration for contentId " + r100);
        if (r100 > 0) goto L10;
    L12:
        this.f153272c = false;
        this.f153270a = System.currentTimeMillis();
        return;
    L10:
        if (r100 == this.f153271b) goto L12;
        this.f153271b = r100;
        goto L12
    }
}
