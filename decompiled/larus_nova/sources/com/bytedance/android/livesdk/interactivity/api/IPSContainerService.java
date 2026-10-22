package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.IPSContainerService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IPSContainerService;", "Lcom/bytedance/android/live/base/IService;", "getPublicScreenBottomPlaceHolder", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPSContainerService extends IService {
    Class<? extends Widget> getPublicScreenBottomPlaceHolder();
}
