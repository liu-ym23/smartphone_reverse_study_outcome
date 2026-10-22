package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface IPushStreamDataManager extends IService {
    Map<String, Double> getEffectInfo();

    String getEffectParams();

    Map<String, String> getPerfToolsNormalData();

    Map<String, Double> getPushStreamInfo();
}
