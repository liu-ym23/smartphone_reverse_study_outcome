package com.bytedance.android.ecom.bcm.track.impl.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/monitor/ParseRequestException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "contentType", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "bcm-track-impl_release"}, k = 1, mv = {1, 1, 16})
public final class ParseRequestException extends Exception {
    public ParseRequestException(String r100, String r101) {
        super("Cannot parse request from " + r101 + ", content-type=" + r100);
    }
}
