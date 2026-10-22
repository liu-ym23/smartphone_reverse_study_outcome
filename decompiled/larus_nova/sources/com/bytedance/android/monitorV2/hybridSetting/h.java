package com.bytedance.android.monitorV2.hybridSetting;

import android.content.Context;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public interface h {
    List<lz2.a> a();

    CheckFilter b();

    Map<String, Integer> c();

    BidInfo d();

    Set<String> e();

    HybridSettingInitConfig getInitConfig();

    void init(Context r100);
}
