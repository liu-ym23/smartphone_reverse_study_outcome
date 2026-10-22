package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class SSGridLayoutManager extends GridLayoutManager {
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final boolean isLayoutRTL() {
        IAiService r100 = (IAiService) jc1.k.f(IAiService.class);
        if (r100 == null) goto L6;
        r100.getOhrService();
    L6:
        return super.isLayoutRTL();
    }

    public static void p(String r100) {
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        r101.put("status_code", 1);     // Catch: JSONException -> L5
        r103.put("error_log", r100);     // Catch: JSONException -> L5
    L7:
        LiveTracingMonitor.f("ttlive_gift_panel_layout_crash_error", LiveTracingMonitor.EventModule.LIVE_GIFT, r101, r102, r103);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public SSGridLayoutManager(Context r100, int r101) {
        super(r100, r101);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        SafetyGuard.a(null, e, "SSGridLayoutManager onLayoutChildren error");
        if (e.getCause() != null) goto L8;
    L10:
        ALogger.e("SSGridLayoutManager", e);
        return;
    L8:
        if (e.getCause().getStackTrace() == null) goto L10;
        StackTraceElement[] r102 = e.getCause().getStackTrace();
        p(e.getCause().getMessage() + "  layout error! " + Arrays.toString(r102));
        ALogger.e("SSGridLayoutManager", e.getCause().getMessage() + "  layout error! " + Arrays.toString(r102));
    }

    public SSGridLayoutManager(Context r100, int r101, int r102) {
        super(r100, r101, r102, false);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollHorizontallyBy(r100, r101, r102);
    L4:
        e = move-exception;
        if (e.getCause() != null) goto L8;
    L10:
        ALogger.e("SSGridLayoutManager", e);
        return 0;
    L8:
        if (e.getCause().getStackTrace() == null) goto L10;
        StackTraceElement[] r103 = e.getCause().getStackTrace();
        p(e.getCause().getMessage() + "  layout error! " + Arrays.toString(r103));
        ALogger.e("SSGridLayoutManager", e.getCause().getMessage() + "  layout error! " + Arrays.toString(r103));
        return 0;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return super.scrollVerticallyBy(r100, r101, r102);
    L4:
        e = move-exception;
        if (e.getCause() != null) goto L8;
    L10:
        ALogger.e("SSGridLayoutManager", e);
        return 0;
    L8:
        if (e.getCause().getStackTrace() == null) goto L10;
        StackTraceElement[] r103 = e.getCause().getStackTrace();
        ALogger.e("SSGridLayoutManager", e.getCause().getMessage() + "  layout error! " + Arrays.toString(r103));
        p(e.getCause().getMessage() + "  layout error! " + Arrays.toString(r103));
        return 0;
    }

    public SSGridLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
