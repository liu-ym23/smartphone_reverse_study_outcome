package com.bytedance.android.gamecp.base.network.response;

import com.bytedance.android.gamecp.host_api.model.network.Extra;

/* JADX INFO: loaded from: classes44.dex */
public interface e {
    Extra a();

    RequestError getError();

    int getStatusCode();
}
