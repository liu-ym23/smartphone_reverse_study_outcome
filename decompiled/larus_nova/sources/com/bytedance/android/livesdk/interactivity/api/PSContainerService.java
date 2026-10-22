package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.interactivity.PublicScreenBottomPlaceHolder;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/PSContainerService;", "Lcom/bytedance/android/livesdk/interactivity/api/IPSContainerService;", "()V", "getPublicScreenBottomPlaceHolder", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PSContainerService implements IPSContainerService {
    public PSContainerService() {
        jc1.k.l(IPSContainerService.class, this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPSContainerService
    public Class<? extends Widget> getPublicScreenBottomPlaceHolder() {
        return PublicScreenBottomPlaceHolder.class;
    }
}
