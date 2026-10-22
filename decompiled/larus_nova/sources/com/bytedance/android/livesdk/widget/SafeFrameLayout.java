package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdk.utils.z6;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class SafeFrameLayout extends FrameLayout {
    public SafeFrameLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public void restoreHierarchyState(SparseArray<Parcelable> r100) {
        super.restoreHierarchyState(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        JSONObject r101 = new JSONObject();
        BaseMonitor.add(r101, "error_msg", e.toString());
        JSONObject r102 = z6.b(this);
        BaseMonitor.add(r101, "dump", r102);
        if (r102.optJSONObject("repeat_id") == null) goto L8;
        int r103 = 1;
    L9:
        LiveSlardarMonitor.monitorStatus("ttlive_xg_restore_dump", r103, r101);
        return;
    L8:
        r103 = 0;
        goto L9
    }

    public SafeFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public SafeFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
