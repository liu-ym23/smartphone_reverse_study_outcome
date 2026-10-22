package com.bytedance.android.ecom.bcm.track.impl.spi;

import com.bytedance.android.bcm.api.provider.IBcmExtraCheckerProvider;
import com.bytedance.android.ecom.bcm.track.api.provider.EcomDefaultConfigProvider;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/spi/BcmExtraCheckerProviderImpl;", "Lcom/bytedance/android/bcm/api/provider/IBcmExtraCheckerProvider;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class BcmExtraCheckerProviderImpl implements IBcmExtraCheckerProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BcmExtraCheckerProviderImpl f51154a = null;

    public static final class a {
    }

    public BcmExtraCheckerProviderImpl() {
    }

    static {
        f51154a = new BcmExtraCheckerProviderImpl();
    }

    @Override // com.bytedance.android.bcm.api.provider.IBcmExtraCheckerProvider
    public final com.bytedance.android.ecom.bcm.track.impl.spi.a a() {
        return new com.bytedance.android.ecom.bcm.track.impl.spi.a();
    }

    @Override // com.bytedance.android.bcm.api.provider.IBcmExtraCheckerProvider
    public final boolean isLazyOpt() {
        return EcomDefaultConfigProvider.a();
    }
}
