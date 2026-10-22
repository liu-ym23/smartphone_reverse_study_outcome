package com.bytedance.android.format.host.api;

import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.Metadata;
import pr.a;
import pr.d;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH&J&\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/format/host/api/IHostPerformanceMonitor;", "", "", "scene", "", "isFpsTracerStarted", "", "startFpsTracer", "Landroid/view/Window;", LiveEndPageData.TAG_WINDOW, "Lpr/d;", "fpsMonitorCallback", "Lpr/a;", "blockMonitorCallback", "stopFpsTracer", "removeFpsTracer", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostPerformanceMonitor {
    boolean isFpsTracerStarted(String r100);

    void removeFpsTracer(String r100);

    void startFpsTracer(String r100);

    void startFpsTracer(String r100, Window r101);

    void stopFpsTracer(String r100, d r101, a r102);
}
