package com.bytedance.android.service.manager.redbadge;

import android.content.Context;
import java.util.List;
import org.json.JSONObject;
import yfc.b;

/* JADX INFO: loaded from: classes12.dex */
public class IRedBadgeExternalServiceImplOfMock implements IRedBadgeExternalService {
    public IRedBadgeExternalServiceImplOfMock() {
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean addRedBadgeNumber(Context r100, int r101) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean applyCount(Context r100, int r101) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeExternalService
    public int getBadgeNumberWhenAppLaunch(Context r100) {
        return 0;
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public int getCurRedBadgeNumber(Context r100) {
        return 0;
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeExternalService
    public JSONObject getRedBadgeRequestBody(Context r100, boolean r101) {
        return null;
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeExternalService
    public List<Long> getRedBadgeShowHistoryList(Context r100) {
        return null;
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeExternalService
    public String getRedBadgeShowHistoryStr(Context r100) {
        return "";
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean isSupportAddRedBadgeNumber(int r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean isSupportGetCurRedBadgeNumber() {
        return false;
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean isSupportReduceRedBadgeNumber(int r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean reduceRedBadgeNumber(Context r100, int r101) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeService
    public boolean removeCount(Context r100) {
        return false;
    }

    @Override // com.bytedance.android.service.manager.redbadge.IRedBadgeExternalService
    public void startOnWorkerProcess(b r100) {
    }
}
