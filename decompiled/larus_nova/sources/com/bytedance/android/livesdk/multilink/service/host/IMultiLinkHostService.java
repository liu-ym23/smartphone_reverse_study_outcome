package com.bytedance.android.livesdk.multilink.service.host;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ServiceLookup("com.bytedance.android.livesdk.multilink.service.host.MultiLinkHostService")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H&¢\u0006\u0002\u0010\u0006J+\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\tJ1\u0010\n\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00030\rH&¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/multilink/service/host/IMultiLinkHostService;", "Lcom/bytedance/android/live/base/IService;", "getClientABValue", ExifInterface.GPS_DIRECTION_TRUE, "key", "Lcom/bytedance/android/live/base/abtest/ClientABTestKey;", "(Lcom/bytedance/android/live/base/abtest/ClientABTestKey;)Ljava/lang/Object;", "withExposure", "", "(Lcom/bytedance/android/live/base/abtest/ClientABTestKey;Z)Ljava/lang/Object;", "getClientABValueByJsonString", "", "clazz", "Ljava/lang/Class;", "(Lcom/bytedance/android/live/base/abtest/ClientABTestKey;Ljava/lang/Class;)Ljava/lang/Object;", "multilink-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ServiceDummyLookup("com.bytedance.android.livesdk.multilink.service.host.MultiLinkHostServiceDummy")
public interface IMultiLinkHostService extends IService {
    <T> T getClientABValue(ClientABTestKey<T> r100);

    <T> T getClientABValue(ClientABTestKey<T> r100, boolean r101);

    <T> T getClientABValueByJsonString(ClientABTestKey<String> r100, Class<T> r101);
}
