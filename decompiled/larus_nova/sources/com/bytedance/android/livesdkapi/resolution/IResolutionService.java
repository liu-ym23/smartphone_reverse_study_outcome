package com.bytedance.android.livesdkapi.resolution;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.resolution.newresolution.ResolutionService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J&\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J&\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005H&J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005H&J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J,\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u001c\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/resolution/IResolutionService;", "Lcom/bytedance/android/live/base/IService;", "clearAutoModeFlag", "", "getMultiStreamDefaultQualitySdkKey", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getPreviewResolution", "Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$PickResult;", "getPreviewResolutionNew", "getPullStreamResolution", "roomId", "", "streamUrl", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "useForBuildRequest", "", "getPullStreamResolutionNew", "getWindowDefaultResolutionSdkKey", "windowScene", "getWindowDefaultResolutionSdkKeyNew", "initRoomResolutionSetting", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "onRoomEnter", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRoomExit", "reportResolutionChangeEvent", "changeType", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IResolutionService extends IService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void reportResolutionChangeEvent$default(IResolutionService r100, String r101, IRoom r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.reportResolutionChangeEvent(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportResolutionChangeEvent");
        }

        public static /* synthetic */ PlayerResolution.PickResult getPullStreamResolution$default(IResolutionService r100, long r101, IBaseStreamUrl r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = false;
        L7:
            return r100.getPullStreamResolution(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPullStreamResolution");
        }

        public static /* synthetic */ PlayerResolution.PickResult getPullStreamResolutionNew$default(IResolutionService r100, long r101, IBaseStreamUrl r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = false;
        L7:
            return r100.getPullStreamResolutionNew(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPullStreamResolutionNew");
        }
    }

    void clearAutoModeFlag();

    String getMultiStreamDefaultQualitySdkKey(IRoom r100);

    PlayerResolution.PickResult getPreviewResolution(IRoom r100);

    PlayerResolution.PickResult getPreviewResolutionNew(IRoom r100);

    PlayerResolution.PickResult getPullStreamResolution(long r100, IBaseStreamUrl r101, boolean r102);

    PlayerResolution.PickResult getPullStreamResolutionNew(long r100, IBaseStreamUrl r101, boolean r102);

    PlayerResolution.PickResult getWindowDefaultResolutionSdkKey(IRoom r100, String r101);

    PlayerResolution.PickResult getWindowDefaultResolutionSdkKeyNew(IRoom r100, String r101);

    void initRoomResolutionSetting(DataCenter r100);

    void onRoomEnter(Context r100, LifecycleOwner r101, long r102, DataCenter r103);

    void onRoomExit(long r100);

    void reportResolutionChangeEvent(String r100, IRoom r101);
}
