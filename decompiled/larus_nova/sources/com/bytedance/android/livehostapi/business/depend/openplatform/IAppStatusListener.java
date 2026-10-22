package com.bytedance.android.livehostapi.business.depend.openplatform;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/IAppStatusListener;", "", "onAppExit", "", "onLaunchFail", "errMsg", "", "onLaunchSuccess", "miniAppInstance", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/MiniAppInstance;", "onScreenStateChange", "state", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAppStatusListener {
    void onAppExit();

    void onLaunchFail(String r100);

    void onLaunchSuccess(MiniAppInstance r100);

    void onScreenStateChange(int r100);
}
