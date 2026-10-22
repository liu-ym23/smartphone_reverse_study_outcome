package com.stepos.deepbinder.core.api;

import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/deepbinder/core/api/IRemoteService;", "Lcom/stepos/deepbinder/core/api/IService;", "LC7/r;", Constants.METHOD_CONNECT, "()V", "disconnect", "", "isRemote", "()Z", "Lcom/stepos/deepbinder/core/entity/Call;", "call", "Lcom/stepos/deepbinder/core/entity/Reply;", "sendCall", "(Lcom/stepos/deepbinder/core/entity/Call;)Lcom/stepos/deepbinder/core/entity/Reply;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IRemoteService extends IService {
    void connect();

    void disconnect();

    boolean isRemote();

    Reply sendCall(Call call);
}
