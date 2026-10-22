package com.bytedance.android.digitalman.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;
import md.a;
import md.b;

/* JADX INFO: loaded from: classes43.dex */
@ServiceLookup("com.bytedance.android.digitalman.api.IDigitalManBaseService")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/digitalman/api/IDigitalManBaseService;", "Lcom/bytedance/android/live/base/IService;", "Lmd/b;", "initDigitalManRtcService", "Lmd/a;", "initDigitalManAudioNewService", "digitalman-base-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDigitalManBaseService extends IService {
    a initDigitalManAudioNewService();

    b initDigitalManRtcService();
}
