package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g7 extends ScaleGestureDetector {
    @Override // android.view.ScaleGestureDetector
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return super.onTouchEvent(r100);
    }

    public g7(Context r100, com.bytedance.android.live.pushstream.d r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        super(r100, new h7(r101, r102));
    }
}
