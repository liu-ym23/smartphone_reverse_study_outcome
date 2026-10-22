package com.bytedance.android.livehostapi.business.depend.gamecp;

import com.tencent.open.SocialConstants;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u001e\u0010\u000b\u001a\u00020\u00032\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\rH&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPWhiteBoxTestService;", "", "enterScene", "", "scene", "", "executeToolbarCase", "exitScene", "onFail", SocialConstants.PARAM_APP_DESC, "content", "registerToolbarCase", "map", "", "unRegisterToolbarCase", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameCPWhiteBoxTestService {
    void enterScene(String r100);

    void executeToolbarCase();

    void exitScene(String r100);

    void onFail(String r100, String r101);

    void registerToolbarCase(Map<String, String> r100);

    void unRegisterToolbarCase();
}
