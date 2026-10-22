package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import com.bytedance.android.live.base.IService;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostTokenInjectionAuth extends IService {
    TokenInfo getTokenInfo();

    boolean isLogin();

    void onTokenInvalid(TokenInfo r100, TokenRefreshCallback r101, Activity r102, Map<String, String> r103);
}
