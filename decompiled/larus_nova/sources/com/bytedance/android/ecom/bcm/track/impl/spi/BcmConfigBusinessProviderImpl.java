package com.bytedance.android.ecom.bcm.track.impl.spi;

import com.bytedance.android.bcm.api.provider.IBcmConfigBusinessProvider;
import com.bytedance.android.ecom.bcm.track.api.provider.EcomDefaultConfigProvider;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kc.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/spi/BcmConfigBusinessProviderImpl;", "Lcom/bytedance/android/bcm/api/provider/IBcmConfigBusinessProvider;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class BcmConfigBusinessProviderImpl implements IBcmConfigBusinessProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BcmConfigBusinessProviderImpl f51153a = null;

    public static final class a {
    }

    public BcmConfigBusinessProviderImpl() {
    }

    static {
        f51153a = new BcmConfigBusinessProviderImpl();
    }

    @Override // com.bytedance.android.bcm.api.provider.IBcmConfigBusinessProvider
    public final Map<String, b> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        b r101 = new b();
        r101.f502363a = true;
        r100.put("ecom_entrance", r101);
        b r102 = new b();
        r102.f502363a = true;
        r100.put("ecom_sec", r102);
        return r100;
    }

    @Override // com.bytedance.android.bcm.api.provider.IBcmConfigBusinessProvider
    public final boolean isLazyOpt() {
        return EcomDefaultConfigProvider.a();
    }
}
