package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import com.bytedance.android.livesdkapi.auth.INewAuthReport;

/* JADX INFO: loaded from: classes7.dex */
public interface IOneKeyAuth {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.platform.IOneKeyAuth$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static INewAuthReport $default$getAuthReporter(IOneKeyAuth r100) {
            return null;
        }
    }

    void checkAuthFlowHasDialog(sy.a<Boolean> r100);

    void doDouyinAuth(Activity r100, TokenRefreshCallback r101, String r102);

    INewAuthReport getAuthReporter();

    void getCurrentAccountPhoneNumber(sy.a<String> r100);

    void isPhoneNumberUsedInDouyin(sy.a<Boolean> r100);
}
