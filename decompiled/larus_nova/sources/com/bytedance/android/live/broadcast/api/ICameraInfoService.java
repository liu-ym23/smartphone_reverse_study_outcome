package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ExposureCompensationInfo;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/ICameraInfoService;", "Lcom/bytedance/android/live/base/IService;", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ICameraInfoService extends IService {
    Pair<Float, Float> C4();

    boolean h();

    boolean m3();

    ExposureCompensationInfo p1();
}
