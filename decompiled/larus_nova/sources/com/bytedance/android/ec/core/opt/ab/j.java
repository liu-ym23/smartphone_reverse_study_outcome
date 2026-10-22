package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.local.api.ab.ECLiveSettingPanel;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {
    @ECLiveSettingPanel(desc = "电商基础优化二期", key = "live_ecom_base_optv2")
    public static k a() {
        k r100 = new k();
        Intrinsics.checkNotNullParameter("live_ecom_base_optv2", "key");
        Intrinsics.checkNotNullParameter(r100, "defaultValue");
        int r101 = ECSdk.f48106a;
        IAdapterService r102 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r102 == null) goto L8;
        k r103 = (k) r102.getLiveSettingsValue("live_ecom_base_optv2", r100);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return new k();
    L8:
        return r100;
    }

    static {
    }
}
