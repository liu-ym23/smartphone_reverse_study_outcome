package com.bytedance.android.live.room;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.livesdk.module.HighlightAnnouncementService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003H&J\u0012\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/IHighlightAnnouncementService;", "Lcom/bytedance/android/live/base/IService;", "getAnchorAnnouncementHighlightWidget", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "getAudienceAnnouncementHighlightWidget", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHighlightAnnouncementService extends IService {
    Class<? extends LiveWidget> getAnchorAnnouncementHighlightWidget();

    Class<? extends LiveWidget> getAudienceAnnouncementHighlightWidget();
}
