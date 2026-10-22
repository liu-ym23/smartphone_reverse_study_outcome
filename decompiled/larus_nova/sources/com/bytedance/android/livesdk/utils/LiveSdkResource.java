package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdkapi.service.ILiveResourceService;
import com.bytedance.android.livesdkapi.util.LiveResourceModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/utils/LiveSdkResource;", "Lcom/bytedance/android/livesdkapi/service/ILiveResourceService;", "Lcom/bytedance/android/livesdkapi/util/LiveResourceModel;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "", "getResourceId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSdkResource implements ILiveResourceService {
    public static final a Companion = null;
    private static final Map<LiveResourceModel, Integer> resourceMap = null;

    public static final class a {
        public a() {
        }
    }

    public LiveSdkResource() {
    }

    static {
        Companion = new a();
        resourceMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(LiveResourceModel.TTLIVE_NO_NETWORK, Integer.valueOf(R.drawable.ttlive_bg_network_error)), TuplesKt.to(LiveResourceModel.TTLIVE_FEED_EMPTY, Integer.valueOf(R.drawable.ttlive_empty_content_dark))});
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveResourceService
    public int getResourceId(LiveResourceModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Integer r101 = resourceMap.get(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.intValue();
    }
}
