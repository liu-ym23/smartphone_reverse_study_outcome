package com.stepos.core.transport.bridge;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/core/transport/bridge/IResponseHandler;", "", "", "requestId", "Lcom/stepos/core/transport/bridge/TransportResponse;", UxipConstants.f30685x, "LY8/t;", "onResponse", "(Ljava/lang/String;Lcom/stepos/core/transport/bridge/TransportResponse;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IResponseHandler {
    void onResponse(String requestId, TransportResponse response);
}
