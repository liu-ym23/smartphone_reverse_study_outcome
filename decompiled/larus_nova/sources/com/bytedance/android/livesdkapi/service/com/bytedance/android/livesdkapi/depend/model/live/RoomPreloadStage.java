package com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.core.log.ALogger;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0013J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/livesdkapi/depend/model/live/RoomPreloadStage;", "", "()V", "blockPreloadReason", "Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/livesdkapi/depend/model/live/PRELOAD_DISABLE_REASON;", "canUpdateState", "", "isBlockPreload", "isUseRecommendPredict", "lastEnterRoom2PreloadCost", "", "preload2StartRoomCost", "preloadBackendApiStage", "Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/livesdkapi/depend/model/live/API_STAGE;", "preloadRoomApiStage", "preloadStage", "Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/livesdkapi/depend/model/live/PRELOAD_STAGE;", "preloadStartTime", "backendApiStage", "", WiseOpenHianalyticsData.UNION_COSTTIME, "enable", "", "isEnable", "getBlockPreloadReason", "getIsBlockPreload", "roomApiStage", "updateLastEnterRoom2PreloadCost", "time", "updatePreloadBackendApiStage", "stage", "updatePreloadBlockReason", "blockReason", "updatePreloadRoomApiStage", "updatePreloadStage", "updateShield", "shield", "updateUseRecommendPredict", "isUse", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomPreloadStage {
    private PRELOAD_DISABLE_REASON blockPreloadReason;
    private boolean canUpdateState;
    private boolean isBlockPreload;
    private boolean isUseRecommendPredict;
    private long lastEnterRoom2PreloadCost;
    private long preload2StartRoomCost;
    private API_STAGE preloadBackendApiStage;
    private API_STAGE preloadRoomApiStage;
    private PRELOAD_STAGE preloadStage;
    private long preloadStartTime;

    public final int backendApiStage() {
        return this.preloadBackendApiStage.getValue();
    }

    public final int getBlockPreloadReason() {
        return this.blockPreloadReason.getValue();
    }

    public final int preloadStage() {
        return this.preloadStage.getValue();
    }

    public final int roomApiStage() {
        return this.preloadRoomApiStage.getValue();
    }

    public RoomPreloadStage() {
        this.preloadStage = PRELOAD_STAGE.NOT_INVOKE_PRELOAD;
        API_STAGE r100 = API_STAGE.NOT_SEND_REQUEST;
        this.preloadRoomApiStage = r100;
        this.preloadBackendApiStage = r100;
        this.blockPreloadReason = PRELOAD_DISABLE_REASON.DISABLE_REASON_NONE;
        this.canUpdateState = true;
    }

    public final long costTime() {
        return this.preload2StartRoomCost;
    }

    public final boolean getIsBlockPreload() {
        return this.isBlockPreload;
    }

    public final boolean isUseRecommendPredict() {
        return this.isUseRecommendPredict;
    }

    public final long lastEnterRoom2PreloadCost() {
        return this.lastEnterRoom2PreloadCost;
    }

    public final void enable(boolean r100) {
        ALogger.i("RoomPreloadStage", "setEnable: " + r100);
        this.canUpdateState = r100;
        if (r100 == false) goto L5;
        return;
    L5:
        if (this.preloadStartTime <= 0) goto L9;
        this.preload2StartRoomCost = System.currentTimeMillis() - this.preloadStartTime;
        return;
    }

    public final void updateLastEnterRoom2PreloadCost(long r100) {
        if (this.canUpdateState == true) goto L5;
        return;
    L5:
        ALogger.i("RoomPreloadStage", "updateLastEnterRoomTime: " + r100);
        this.lastEnterRoom2PreloadCost = r100;
    }

    public final void updatePreloadBackendApiStage(API_STAGE r100) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        if (this.canUpdateState == true) goto L5;
        return;
    L5:
        this.preloadBackendApiStage = r100;
    }

    public final void updatePreloadBlockReason(PRELOAD_DISABLE_REASON r100) {
        Intrinsics.checkNotNullParameter(r100, "blockReason");
        this.blockPreloadReason = r100;
    }

    public final void updatePreloadRoomApiStage(API_STAGE r100) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        if (this.canUpdateState == true) goto L5;
        return;
    L5:
        this.preloadRoomApiStage = r100;
    }

    public final void updatePreloadStage(PRELOAD_STAGE r100) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        if (this.canUpdateState == true) goto L6;
        return;
    L6:
        if (r100 != PRELOAD_STAGE.HAS_INVOKE_PRELOAD) goto L8;
        this.preloadStartTime = System.currentTimeMillis();
    L8:
        ALogger.i("RoomPreloadStage", "updatePreloadStage: " + r100.getValue());
        this.preloadStage = r100;
    }

    public final void updateShield(boolean r100) {
        this.isBlockPreload = r100;
    }

    public final void updateUseRecommendPredict(boolean r100) {
        this.isUseRecommendPredict = r100;
    }
}
