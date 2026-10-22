package com.bytedance.android.live.core.setting;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.LoginGuideConfig;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public class CoreSettingUtil {
    public static String getLoginImageForFollow() {
        LoginGuideConfig r100 = LiveInfraSettingKeys.LOGIN_GUIDE.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getImageUrlFromFollow();
    }

    public static String getLoginPromptForFollow() {
        LoginGuideConfig r100 = LiveInfraSettingKeys.LOGIN_GUIDE.getValue();
        if (r100 == null) goto L9;
        if (TextUtils.isEmpty(r100.getFromFollow()) == true) goto L9;
        return r100.getFromFollow();
    L9:
        return com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_core_login_prompt_default_follow);
    }

    private CoreSettingUtil() {
    }
}
