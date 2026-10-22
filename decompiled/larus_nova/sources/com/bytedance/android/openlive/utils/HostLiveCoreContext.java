package com.bytedance.android.openlive.utils;

import android.content.Context;
import com.bytedance.android.livehostapi.business.IHostLiveCoreContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/openlive/utils/HostLiveCoreContext;", "Lcom/bytedance/android/livehostapi/business/IHostLiveCoreContext;", "appId", "", "licenseAssetsDir", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V", "getAppID", "getLicenseDir", "live-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public final class HostLiveCoreContext implements IHostLiveCoreContext {
    private final String appId;
    private final Context context;
    private final String licenseAssetsDir;

    @Override // com.bytedance.android.livehostapi.business.IHostLiveCoreContext
    public String getAppID() {
        return this.appId;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostLiveCoreContext
    public String getLicenseDir() {
        return this.licenseAssetsDir;
    }

    public HostLiveCoreContext(String r100, String r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "licenseAssetsDir");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.appId = r100;
        this.licenseAssetsDir = r101;
        this.context = r102;
        k.l(IHostLiveCoreContext.class, this);
    }
}
