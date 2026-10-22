package com.ttnet.org.chromium.net.urlconnection;

import com.ss.android.ugc.quota.tag.BDNetworkTagLaunchType;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class TTRequestCanceledException extends IOException {
    public TTRequestCanceledException(String r10) {
        super(r10);
    }

    public int getCronetInternalErrorCode() {
        return BDNetworkTagLaunchType.UNSPECIFIED;
    }
}
