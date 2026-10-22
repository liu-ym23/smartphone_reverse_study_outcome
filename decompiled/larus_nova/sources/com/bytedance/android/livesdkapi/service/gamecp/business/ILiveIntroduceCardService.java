package com.bytedance.android.livesdkapi.service.gamecp.business;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H&J \u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/gamecp/business/ILiveIntroduceCardService;", "Lcom/bytedance/android/live/base/IService;", "isCardVisible", "", "setAutoIntroGameId", "", "gameId", "", "setAutoIntroGameName", "gameName", "setGameDetailDismissed", "dismissed", "showInstallIntroCard", "roomId", "withinTimeSpan", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveIntroduceCardService extends IService {
    boolean isCardVisible();

    void setAutoIntroGameId(String r100);

    void setAutoIntroGameName(String r100);

    void setGameDetailDismissed(boolean r100);

    void showInstallIntroCard(String r100, String r101, boolean r102);
}
