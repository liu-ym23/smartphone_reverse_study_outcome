package com.stepos.deepbinder.core.api;

import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IRemoteService extends IService {
    void connect();

    void disconnect();

    boolean isRemote();

    Reply sendCall(Call call);
}
