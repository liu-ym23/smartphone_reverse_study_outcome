package com.bytedance.android.livesdk.chatroom.newcontainer.business.player.session;

import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ls2.c;
import os2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class SessionPlayerBusiness extends d<c> {
    @Override // os2.a
    public final c d() {
        return null;
    }

    public SessionPlayerBusiness() {
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.util.ArrayList] */
    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> g(ls2.d r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = new ArrayList();
        if (r101 == null) goto L5;
        ts2.d.h(r101, new SessionPlayerBusiness$containerStateChanged$1(r103));
    L5:
        if (r101 == null) goto L8;
        ts2.d.d(r101, SessionPlayerBusiness$containerStateChanged$2.INSTANCE);
    L8:
        return (List) r103.element;
    }
}
