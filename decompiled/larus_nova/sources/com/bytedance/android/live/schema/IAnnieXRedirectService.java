package com.bytedance.android.live.schema;

import android.app.Application;
import com.bytedance.android.live.base.IService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import n26.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/schema/IAnnieXRedirectService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/app/Application;", PerfLog.PARAM_KEY_CONTEXT_ID, "Ln26/a;", "getRedirectProcessor", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAnnieXRedirectService extends IService {
    a getRedirectProcessor(Application r100);
}
