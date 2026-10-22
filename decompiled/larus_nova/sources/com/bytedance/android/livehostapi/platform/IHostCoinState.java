package com.bytedance.android.livehostapi.platform;

import android.content.Context;
import com.bytedance.android.livehostapi.platform.depend.Callback;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\t\u001a\u00020\bH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/IHostCoinState;", "", "getCoinState", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "callback", "Lcom/bytedance/android/livehostapi/platform/depend/Callback;", "", "isEnableBindAccountAwardTask", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostCoinState {
    void getCoinState(Context r100, Callback<Boolean> r101);

    boolean isEnableBindAccountAwardTask();
}
