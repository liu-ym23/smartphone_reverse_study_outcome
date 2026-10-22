package com.bytedance.android.livesdkapi.broadcast;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J8\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0005H&¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/broadcast/IBroadcastMiniAppService;", "Lcom/bytedance/android/live/base/IService;", "addMiniAppAnchorEvent", "", "anchorShareInfo", "", "anchorAction", "openMiniAppChoosePanel", "fm", "Landroidx/fragment/app/FragmentManager;", "isBroadcasting", "", "roomId", "", "bundle", "Landroid/os/Bundle;", "miniAppResultCallback", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "Lcom/bytedance/android/livesdkapi/broadcast/StampInfo;", "removeStampOnBroadcastFinishedOrCancel", "setStampReviewStatus", "coverReviewStatus", "", "startUploadSelectedMiniAppInfo", "updateMicroRecord", "schema", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBroadcastMiniAppService extends IService {
    void addMiniAppAnchorEvent(String r100, String r101);

    void openMiniAppChoosePanel(FragmentManager r100, boolean r101, long r102, Bundle r103, Observer<StampInfo> r104);

    void removeStampOnBroadcastFinishedOrCancel(long r100, boolean r101);

    void setStampReviewStatus(int r100);

    void startUploadSelectedMiniAppInfo(long r100);

    void updateMicroRecord(String r100);
}
