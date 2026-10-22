package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.content.Context;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements vr1.h, com.bytedance.android.scope.o {
    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // vr1.h
    public final r a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new r(new WeakReference(((IPushStreamService) jc1.k.n(IPushStreamService.class)).getRecordLiveStream(r100)));
    }

    @Override // vr1.h
    public final tp2.a c(Context r100, vr1.z r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vsLiveStream");
        if ((r101 instanceof r) == true) goto L5;
        r101 = null;
    L5:
        r r102 = (r) r101;
        if (r102 == null) goto L10;
        WeakReference<com.bytedance.android.live.pushstream.d> r103 = r102.f118311a;
        if (r103 == null) goto L10;
        com.bytedance.android.live.pushstream.d r104 = r103.get();
    L11:
        r104.J();
        throw null;
    L10:
        r104 = null;
        goto L11
    }
}
