package com.bytedance.android.livesdk.arch.data;

import com.bytedance.android.live.base.model.message.l5;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f3;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends r {
    public d() {
    }

    @Override // com.bytedance.android.livesdk.arch.data.a
    public final c a(c r100) {
        s r101 = (s) r100;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        l5 r102 = r101.f103807h;
        if (r102 == null) goto L5;
        r101.f103804e = f3.a(r102);
    L5:
        return r101;
    }
}
