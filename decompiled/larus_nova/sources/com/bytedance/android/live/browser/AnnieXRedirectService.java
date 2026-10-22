package com.bytedance.android.live.browser;

import android.app.Application;
import com.bytedance.android.live.schema.IAnnieXRedirectService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/browser/AnnieXRedirectService;", "Lcom/bytedance/android/live/schema/IAnnieXRedirectService;", "Landroid/app/Application;", PerfLog.PARAM_KEY_CONTEXT_ID, "Ln26/a;", "getRedirectProcessor", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnnieXRedirectService implements IAnnieXRedirectService {
    public AnnieXRedirectService() {
    }

    @Override // com.bytedance.android.live.schema.IAnnieXRedirectService
    public n26.a getRedirectProcessor(Application r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = s8.a.f540945a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }
}
