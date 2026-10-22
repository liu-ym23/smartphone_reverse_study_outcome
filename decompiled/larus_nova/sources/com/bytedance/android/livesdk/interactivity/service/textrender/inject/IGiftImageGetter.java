package com.bytedance.android.livesdk.interactivity.service.textrender.inject;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.GiftImageGetter")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/textrender/inject/IGiftImageGetter;", "Lcom/bytedance/android/live/base/IService;", "", "giftId", "Lpy/k;", "getGiftImage", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGiftImageGetter extends IService {
    k getGiftImage(long r100);
}
