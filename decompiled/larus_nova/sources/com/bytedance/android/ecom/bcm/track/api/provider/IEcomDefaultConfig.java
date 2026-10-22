package com.bytedance.android.ecom.bcm.track.api.provider;

import cr.b;
import kotlin.Metadata;
import zc.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/api/provider/IEcomDefaultConfig;", "", "", "isLazyOpt", "Lzc/h;", "getSettingDepend", "Lcr/b;", "getExperimentDepend", "bcm-track-api_release"}, k = 1, mv = {1, 4, 0})
public interface IEcomDefaultConfig {
    b getExperimentDepend();

    h getSettingDepend();

    boolean isLazyOpt();
}
