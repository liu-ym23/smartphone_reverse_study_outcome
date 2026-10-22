package com.bytedance.android.livesdk.chatroom.vs.widget.landscape;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class MatchRoomGestureHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f117837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f117838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f117839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f117840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f117841e;

    public static final class a {
    }

    static {
    }

    public final IPlayerProgressService a() {
        return (IPlayerProgressService) this.f117839c.getValue();
    }

    public final long b() {
        IPlayerProgressService r100 = a();
        if (r100 == null) goto L11;
        PlayerProgressServiceContext r101 = r100.provideContext(this.f117840d);
        if (r101 == null) goto L11;
        m<Long> r102 = r101.getLimitStartTime();
        if (r102 == null) goto L11;
        Long r103 = r102.getValue();
        if (r103 == null) goto L11;
        return r103.longValue();
    L11:
        return 0;
    }

    public final long c() {
        IPlayerProgressService r100 = a();
        if (r100 == null) goto L7;
        Long r101 = r100.getTotalTimeInContext();
        if (r101 == null) goto L7;
        return r101.longValue();
    L7:
        return 0;
    }

    public MatchRoomGestureHelper(DataCenter r100, Context r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "contentView");
        this.f117840d = r100;
        this.f117841e = r102;
        new Handler(Looper.getMainLooper());
        this.f117839c = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(new MatchRoomGestureHelper$mProgressService$2(this));
    }
}
