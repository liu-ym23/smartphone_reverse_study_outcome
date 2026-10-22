package com.stepos.deepbinder.core.api;

import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stepos/deepbinder/core/api/IClientService;", "Lcom/stepos/deepbinder/core/api/IService;", "sendCallback", "Lcom/stepos/deepbinder/core/entity/Reply;", "callback", "Lcom/stepos/deepbinder/core/entity/Callback;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IClientService extends IService {
    Reply sendCallback(Callback callback);
}
