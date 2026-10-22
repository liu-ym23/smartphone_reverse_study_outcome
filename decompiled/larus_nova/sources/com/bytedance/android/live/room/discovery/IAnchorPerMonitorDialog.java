package com.bytedance.android.live.room.discovery;

import android.content.Context;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/discovery/IAnchorPerMonitorDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class IAnchorPerMonitorDialog extends CommonBottomDialog {
    public abstract void M0(int r100, boolean r101);

    public abstract void N0(int r100);

    public void O0(int r100) {
    }

    public abstract void P0(int r100);

    public abstract void Q0();

    public IAnchorPerMonitorDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
