package com.bytedance.android.livehostapi.business.castscreen.interfaces;

import android.view.View;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ICastDanmakuManager;", "", MapMonitorConst.EVENT_DESTROY, "", "getRenderEngineView", "Landroid/view/View;", "startDanmaku", "stopDanmaku", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ICastDanmakuManager {
    void destroy();

    View getRenderEngineView();

    void startDanmaku();

    void stopDanmaku();
}
