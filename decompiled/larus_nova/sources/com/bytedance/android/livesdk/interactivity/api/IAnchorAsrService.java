package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.AnchorAsrService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IAnchorAsrService;", "Lcom/bytedance/android/live/base/IService;", "getAnchorAsrHintWidget", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getAnchorAsrServiceWidget", "loadPlugin", "", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAnchorAsrService extends IService {
    Class<? extends Widget> getAnchorAsrHintWidget();

    Class<? extends Widget> getAnchorAsrServiceWidget();

    void loadPlugin();
}
