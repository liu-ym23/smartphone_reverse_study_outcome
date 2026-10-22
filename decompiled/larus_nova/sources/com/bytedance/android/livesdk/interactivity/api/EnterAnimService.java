package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.enteranim.EnterAnimWidget;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.EnterAnimAppLogger;
import com.bytedance.android.livesdk.interactivity.enteranim.view.FansTrayView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/EnterAnimService;", "Lcom/bytedance/android/livesdk/interactivity/api/IEnterAnimService;", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getEnterAnimWidgetClass", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/view/View;", "getFansTrayView", "Lcom/bytedance/android/live/base/model/message/h3;", "message", "", "logCommonEnterShowEvent", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class EnterAnimService implements IEnterAnimService {
    public EnterAnimService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IEnterAnimService
    public Class<? extends LiveRecyclableWidget> getEnterAnimWidgetClass() {
        zb2.a.a();
        return EnterAnimWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IEnterAnimService
    public View getFansTrayView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new FansTrayView(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IEnterAnimService
    public void logCommonEnterShowEvent(h3 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        EnterAnimAppLogger.f(r100);
    }
}
