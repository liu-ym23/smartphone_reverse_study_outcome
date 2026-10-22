package com.bytedance.android.livehostapi.foundation.depend.pluginstrategy;

import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.PluginStrategy;
import com.bytedance.common.utility.StringUtils;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livehostapi/foundation/depend/pluginstrategy/MainCameraPluginStrategy;", "Lcom/bytedance/android/livehostapi/foundation/depend/PluginStrategy;", "type", "", "needPreload", "", "packageName", "(Ljava/lang/String;ZLjava/lang/String;)V", "getPackageName", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainCameraPluginStrategy extends PluginStrategy {
    @Override // com.bytedance.android.livehostapi.foundation.depend.PluginStrategy, com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public String getPackageName() {
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r100 == null) goto L5;
        String r101 = r100.getCameraPluginPackage();
        if (StringUtils.isEmpty(r101) == true) goto L9;
        return r101;
    L9:
        return super.getPackageName();
    L5:
        return super.getPackageName();
    }

    public MainCameraPluginStrategy(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "packageName");
        super(r100, r101, r102);
    }
}
