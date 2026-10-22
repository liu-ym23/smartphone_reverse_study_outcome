package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.multicamera.MultiCameraServiceWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/MultiCameraService;", "Lcom/bytedance/android/livesdk/interactivity/api/IMultiCameraService;", "()V", "getMultiCameraServiceWidget", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MultiCameraService implements IMultiCameraService {
    public MultiCameraService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IMultiCameraService
    public Class<? extends LiveRecyclableWidget> getMultiCameraServiceWidget() {
        return MultiCameraServiceWidget.class;
    }
}
