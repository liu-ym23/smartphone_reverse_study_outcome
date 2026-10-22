package com.bytedance.android.btm.impl.provider;

import com.bytedance.android.bcm.impl.BcmServiceImpl;
import com.bytedance.android.bcm.impl.spi.BcmConfigForBtmImpl$getChainRecordCallback$1;
import com.bytedance.android.bcm.impl.spi.BcmConfigForBtmImpl$getEnterPageCallback$1;
import com.bytedance.android.bcm.impl.spi.BcmConfigForBtmImpl$getPageShowCallback$1;
import com.bytedance.android.bcm.impl.spi.a;
import com.bytedance.android.btm.impl.event.BtmEventParamFiller;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/btm/impl/provider/IBtmConfigFromBcm;", "", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public interface IBtmConfigFromBcm {
    BcmServiceImpl a();

    void b();

    CopyOnWriteArrayList<BtmEventParamFiller.a> c();

    void d();

    BcmConfigForBtmImpl$getChainRecordCallback$1 e();

    void f();

    a g();

    BcmConfigForBtmImpl$getEnterPageCallback$1 h();

    BcmConfigForBtmImpl$getPageShowCallback$1 i();
}
