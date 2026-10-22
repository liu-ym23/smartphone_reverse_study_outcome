package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.GroupLiveService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\fH&J\u0010\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\fX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IGroupLiveService;", "Lcom/bytedance/android/live/base/IService;", "anchorIdBeforeJump", "", "getAnchorIdBeforeJump", "()Ljava/lang/String;", "setAnchorIdBeforeJump", "(Ljava/lang/String;)V", "requestIdBeforeJump", "getRequestIdBeforeJump", "setRequestIdBeforeJump", "roomIdBeforeJump", "", "getRoomIdBeforeJump", "()J", "setRoomIdBeforeJump", "(J)V", "getCloudCollaborateExtraParams", "", "roomId", "getCollaborateWidgetClass", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGroupLiveService extends IService {
    String getAnchorIdBeforeJump();

    Map<String, String> getCloudCollaborateExtraParams(long r100);

    Class<? extends LiveRecyclableWidget> getCollaborateWidgetClass();

    String getRequestIdBeforeJump();

    long getRoomIdBeforeJump();

    void setAnchorIdBeforeJump(String r100);

    void setRequestIdBeforeJump(String r100);

    void setRoomIdBeforeJump(long r100);
}
