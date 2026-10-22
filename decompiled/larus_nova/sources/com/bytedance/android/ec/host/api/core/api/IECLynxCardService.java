package com.bytedance.android.ec.host.api.core.api;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/host/api/core/api/IECLynxCardService;", "", "openLynxCardPage", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "url", "", "bundle", "Landroid/os/Bundle;", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECLynxCardService {
    void openLynxCardPage(Context r100, String r101, Bundle r102);
}
