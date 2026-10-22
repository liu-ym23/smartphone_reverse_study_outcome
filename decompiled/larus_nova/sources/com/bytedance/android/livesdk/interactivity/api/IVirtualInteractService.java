package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.VirtualInteractService")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H&J\u0010\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IVirtualInteractService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/ies/web/jsbridge2/f;", "getCreateActorMethod", "getInteractionCommandMethod", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVirtualInteractService extends IService {
    com.bytedance.ies.web.jsbridge2.f<?, ?> getCreateActorMethod();

    com.bytedance.ies.web.jsbridge2.f<?, ?> getInteractionCommandMethod();
}
