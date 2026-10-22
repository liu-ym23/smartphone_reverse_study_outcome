package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.player.LiveCellularService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u0016\u001a\u00020\nH&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveCellularService;", "Lcom/bytedance/android/live/base/IService;", "acquireUserNotify", "", "enterLiveDraw", "enterLiveRoom", "roomId", "", "exitLiveDraw", "hasCellularPermission", "", "initMultiPath", "isFreeFlow", "isPermissionLimite", "isUseCellular", Constants.OperatorKey.KEY_NETWORK_STATUS, "status", "", "obtainMultiPathStatus", "reportCellularLog", "", "reportLiveFirstFrame", "showUserCellularEnable", "switchToCellularNetwork", "switchToDefaultNetwork", "triggerSwitchingToCellular", "userAccessStatus", "userToastStatus", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCellularService extends IService {
    void acquireUserNotify();

    void enterLiveDraw();

    void enterLiveRoom(String r100);

    void exitLiveDraw();

    boolean hasCellularPermission();

    void initMultiPath();

    boolean isFreeFlow();

    boolean isPermissionLimite();

    boolean isUseCellular();

    void networkStatus(int r100);

    int obtainMultiPathStatus();

    void reportCellularLog(long r100);

    void reportLiveFirstFrame(String r100);

    boolean showUserCellularEnable();

    void switchToCellularNetwork();

    void switchToDefaultNetwork();

    void triggerSwitchingToCellular();

    void userAccessStatus(int r100);

    void userToastStatus(int r100);
}
