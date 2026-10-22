package com.bytedance.android.livesdk.chatroom.replay.util;

import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.JvmStatic;
import mq1.t;
import mq1.v;

/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f110277a = 0;

    static {
    }

    @JvmStatic
    public static final long a(DataCenter r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        t r101 = s.e();
        if (r101 != null) goto L8;
        return 0;
    L8:
        IReplayInnerProgressService r102 = r101.provideVSProgressService(r100);
        if (r102 == null) goto L14;
        Long r103 = r102.getCurrentTimeInContext();
        if (r103 != null) goto L13;
        return 0;
    L13:
        return r103.longValue();
    L14:
        return 0;
    }

    @JvmStatic
    public static final void b(DataCenter r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        t r101 = s.e();
        if (r101 != null) goto L7;
        return;
    L7:
        v r102 = r101.provideVSPlayerViewControlService(r100);
        if (r102 == null) goto L11;
        r102.setVisibilityStatus(false);
        return;
    }

    @JvmStatic
    public static final boolean c(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        t r101 = s.e();
        if (r101 == null) goto L17;
        v r102 = r101.provideVSPlayerViewControlService(r100);
        if (r102 == null) goto L18;
        VSPlayerViewControlContext r103 = r102.provideContext();
        if (r103 == null) goto L19;
        m<Boolean> r104 = r103.getPlayerViewVisible();
        if (r104 == null) goto L20;
        Boolean r105 = r104.getValue();
        if (r105 != null) goto L16;
        return false;
    L16:
        return r105.booleanValue();
    L20:
        return false;
    L19:
        return false;
    L18:
        return false;
    L17:
        return false;
    }

    @JvmStatic
    public static final void d(DataCenter r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ReplayDataContext.Companion.getClass();
        if (ReplayDataContext.a.b(r100) != null) goto L7;
        return;
    L7:
        t r101 = s.e();
        if (r101 != null) goto L10;
        return;
    L10:
        IReplayInnerProgressService r102 = r101.provideVSProgressService(r100);
        if (r102 == null) goto L14;
        r102.pause();
        return;
    }

    @JvmStatic
    public static final void e(DataCenter r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ReplayDataContext.Companion.getClass();
        if (ReplayDataContext.a.b(r100) != null) goto L7;
        return;
    L7:
        t r101 = s.e();
        if (r101 != null) goto L10;
        return;
    L10:
        IReplayInnerProgressService r102 = r101.provideVSProgressService(r100);
        if (r102 == null) goto L14;
        r102.resume();
        return;
    }
}
