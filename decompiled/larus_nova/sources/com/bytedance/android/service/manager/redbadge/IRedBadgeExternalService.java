package com.bytedance.android.service.manager.redbadge;

import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ExternalService;
import java.util.List;
import org.json.JSONObject;
import yfc.b;

/* JADX INFO: loaded from: classes3.dex */
@ExternalService
public interface IRedBadgeExternalService extends IRedBadgeService {
    public static final int BADGE_NUMBER_UNKNOWN = -1;

    int getBadgeNumberWhenAppLaunch(Context r100);

    JSONObject getRedBadgeRequestBody(Context r100, boolean r101);

    List<Long> getRedBadgeShowHistoryList(Context r100);

    String getRedBadgeShowHistoryStr(Context r100);

    void startOnWorkerProcess(b r100);
}
