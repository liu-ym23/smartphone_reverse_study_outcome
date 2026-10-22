package com.bytedance.android.livesdk.multilink.service.host;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u0016¢\u0006\u0002\u0010\u0007J+\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ1\u0010\u000b\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000eH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/multilink/service/host/MultiLinkHostServiceDummy;", "Lcom/bytedance/android/livesdk/multilink/service/host/IMultiLinkHostService;", "()V", "getClientABValue", ExifInterface.GPS_DIRECTION_TRUE, "key", "Lcom/bytedance/android/live/base/abtest/ClientABTestKey;", "(Lcom/bytedance/android/live/base/abtest/ClientABTestKey;)Ljava/lang/Object;", "withExposure", "", "(Lcom/bytedance/android/live/base/abtest/ClientABTestKey;Z)Ljava/lang/Object;", "getClientABValueByJsonString", "", "clazz", "Ljava/lang/Class;", "(Lcom/bytedance/android/live/base/abtest/ClientABTestKey;Ljava/lang/Class;)Ljava/lang/Object;", "multilink-host-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkHostServiceDummy implements IMultiLinkHostService {
    public MultiLinkHostServiceDummy() {
    }

    @Override // com.bytedance.android.livesdk.multilink.service.host.IMultiLinkHostService
    public <T> T getClientABValue(ClientABTestKey<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return null;
    }

    @Override // com.bytedance.android.livesdk.multilink.service.host.IMultiLinkHostService
    public <T> T getClientABValue(ClientABTestKey<T> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return null;
    }

    @Override // com.bytedance.android.livesdk.multilink.service.host.IMultiLinkHostService
    public <T> T getClientABValueByJsonString(ClientABTestKey<String> r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return null;
    }
}
