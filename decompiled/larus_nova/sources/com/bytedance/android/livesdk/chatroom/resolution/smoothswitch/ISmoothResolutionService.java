package com.bytedance.android.livesdk.chatroom.resolution.smoothswitch;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.resolution.smoothswitch.SmoothResolutionServiceImpl")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J9\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/resolution/smoothswitch/ISmoothResolutionService;", "Lcom/bytedance/android/live/base/IService;", "init", "", "smoothSwitchResolution", "", "resolution", "", "reason", "switchWaitTime", "switchStrategyName", "roomId", "", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/Long;)I", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISmoothResolutionService extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.resolution.smoothswitch.ISmoothResolutionService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ int smoothSwitchResolution$default(ISmoothResolutionService r100, String r101, int r102, int r103, String r110, Long r111, int r112, Object r113) {
            if (r113 != null) goto L9;
            if ((r112 & 16) == 0) goto L7;
            r111 = null;
        L7:
            return r100.smoothSwitchResolution(r101, r102, r103, r110, r111);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: smoothSwitchResolution");
        }
    }

    void init();

    int smoothSwitchResolution(String r100, int r101, int r102, String r103, Long r104);
}
