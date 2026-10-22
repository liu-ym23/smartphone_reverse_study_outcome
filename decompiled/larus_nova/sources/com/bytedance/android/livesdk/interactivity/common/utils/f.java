package com.bytedance.android.livesdk.interactivity.common.utils;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.z0;
import com.bytedance.android.livesdk.interactivity.api.seek.EpisodeInteractivityTracer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import ec2.u1;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes9.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final boolean a(DataCenter r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
        return true;
    L5:
        IRoomContextService r102 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r102 == null) goto L28;
        o r103 = IRoomContextService.a.a(r102, r100, 0, 2);
        if (r103 == null) goto L28;
        IVSPlayerService r104 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r104 == null) goto L28;
        IPlayerProgressService r105 = r104.provideVSProgressService(r100);
        if (r105 == null) goto L28;
        PlayerProgressServiceContext r106 = r105.provideContext(r100);
        if (r106 == null) goto L28;
        if (r103.isVSFirstShow() == true) goto L20;
    L26:
        r101 = false;
    L27:
        EpisodeInteractivityTracer.c("check canStartSeekMessageFetchInFirstShow: " + r101);
        goto L28
    L20:
        if (r106.getTotalTime().getValue().longValue() <= 0) goto L26;
        if (r106.getCurrentTime().getValue().longValue() <= 0) goto L26;
        if ((r106.getTotalTime().getValue().longValue() - r106.getCurrentTime().getValue().longValue()) <= (u1.f472062a.getValue().intValue() * 1000)) goto L26;
    L28:
        return r101;
    }

    @JvmStatic
    public static final long b(DataCenter r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        IRoomContextService r101 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r101 == null) goto L17;
        o r102 = IRoomContextService.a.a(r101, r100, 0, 2);
        if (r102 == null) goto L19;
        long r103 = System.currentTimeMillis();
        m<z0> r104 = r102.getSeiTimePair();
        if (r104 == null) goto L18;
        z0 r105 = r104.getValue();
        if (r105 != null) goto L16;
        return 0;
    L16:
        return r105.f119328a + (r103 - r105.f119329b);
    L18:
        return 0;
    L19:
        return 0;
    L17:
        return 0;
    }

    @JvmStatic
    public static final boolean c(DataCenter r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        IVSPlayerService r102 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r102 == null) goto L16;
        IPlayerProgressService r103 = r102.provideVSProgressService(r100);
        if (r103 == null) goto L16;
        PlayerProgressServiceContext r104 = r103.provideContext(r100);
        if (r104 == null) goto L16;
        Boolean r105 = r104.isPlaying();
        if (r105 == null) goto L15;
        r101 = r105.booleanValue();
    L15:
        EpisodeInteractivityTracer.c("check isPlaying: " + r101);
    L16:
        return r101;
    }
}
