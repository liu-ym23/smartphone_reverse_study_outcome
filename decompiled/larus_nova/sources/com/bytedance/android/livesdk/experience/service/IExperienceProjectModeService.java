package com.bytedance.android.livesdk.experience.service;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.lark.utils.statistics.PerfLog;
import ip2.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@ServiceLookup("com.bytedance.android.live.projectmode.ExperienceProjectModeService")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/experience/service/IExperienceProjectModeService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lip2/a;", "info", "", "openDSLDialog", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExperienceProjectModeService extends IService {
    void openDSLDialog(Context r100, a r101);
}
