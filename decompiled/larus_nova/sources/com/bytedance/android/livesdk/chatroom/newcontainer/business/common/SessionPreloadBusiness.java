package com.bytedance.android.livesdk.chatroom.newcontainer.business.common;

import com.bytedance.android.livesdk.room.Task.base.a;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import ik1.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ls2.c;
import oi1.b;
import os2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class SessionPreloadBusiness extends d<g> {
    @Override // os2.a
    public final String b() {
        return "RoomSessionTaskConst_live_room_preload_setting_data";
    }

    @Override // os2.a
    public final boolean e() {
        return true;
    }

    @Override // os2.a
    public final c d() {
        return new g();
    }

    public SessionPreloadBusiness() {
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [R extends ls2.c, T extends ls2.c] */
    @Override // os2.d
    public final List<a<ls2.d, ?>> h(ls2.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r101 = new ArrayList();
        b r102 = new b();
        ?? r103 = this.f526494a;
        if (r103 == 0) goto L5;
        r102.f157565f = r103;
    L5:
        r101.add(r102);
        return r101;
    }

    @Override // os2.d
    public final List<a<ls2.d, ?>> g(ls2.d r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L5;
        ts2.d.d(r101, new SessionPreloadBusiness$containerStateChanged$1(this));
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
