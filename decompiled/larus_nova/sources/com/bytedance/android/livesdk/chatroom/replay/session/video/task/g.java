package com.bytedance.android.livesdk.chatroom.replay.session.video.task;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.chatroom.vs_base.base.model.ReplayRoomState;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.session.video.h;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends com.bytedance.android.livesdk.chatroom.vs_base.base.api.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f109952b;

    public final void c() {
        Handler r100 = new Handler(Looper.getMainLooper());
        r.d().n();
        r100.removeMessages(28);
        this.f109952b.f118130d.f118066t.setValue(Boolean.TRUE);
    }

    public g(h r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f109952b = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.api.a
    public final void b(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        ReplayRoomState r101 = this.f109952b.f118128b;
        if (r101 != ReplayRoomState.PREPARING_WITH_PRE_SHOW) goto L6;
        c();
        this.f109952b.a(ReplayRoomState.PREPARING);
        return;
    L6:
        if (r101 != ReplayRoomState.VIDEO_STARTED) goto L11;
        c();
        this.f109952b.getClass();
        this.f109952b.getClass();
        this.f109952b.a(ReplayRoomState.PREPARED);
        return;
    }
}
