package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.content.Context;
import android.view.GestureDetector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends GestureDetector {
    public f(Context r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scrollGestureListener");
        super(r100, r101);
        new GestureDetector(r100, r101);
    }
}
