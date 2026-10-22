package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.local.api.ab.ECLiveSettingPanel;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class v {
    @ECLiveSettingPanel(desc = "电商Jit compile抑制", key = "ecom_block_jit_compile")
    public static x a() {
        x r100 = new x();
        Intrinsics.checkNotNullParameter("ecom_block_jit_compile", "key");
        Intrinsics.checkNotNullParameter(r100, "defaultValue");
        int r101 = ECSdk.f48106a;
        IAdapterService r102 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r102 == null) goto L8;
        x r103 = (x) r102.getLiveSettingsValue("ecom_block_jit_compile", r100);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return new x();
    L8:
        return r100;
    }

    static {
    }
}
