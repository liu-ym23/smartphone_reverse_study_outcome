package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.EnterAnimService")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IEnterAnimService;", "Lcom/bytedance/android/live/base/IService;", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getEnterAnimWidgetClass", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/view/View;", "getFansTrayView", "Lcom/bytedance/android/live/base/model/message/h3;", "message", "", "logCommonEnterShowEvent", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IEnterAnimService extends IService {
    Class<? extends LiveRecyclableWidget> getEnterAnimWidgetClass();

    View getFansTrayView(Context r100);

    void logCommonEnterShowEvent(h3 r100);
}
