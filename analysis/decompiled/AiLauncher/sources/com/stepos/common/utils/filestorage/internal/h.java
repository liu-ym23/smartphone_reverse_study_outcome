package com.stepos.common.utils.filestorage.internal;

import La.H;
import La.K;
import P6.TosCallbackBody;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "httpCode", "", "rawBody", "LP6/j;", Const.INTENT_KEY_APIKEY, "(ILjava/lang/String;)LP6/j;", "utils_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    public static final TosCallbackBody a(int i10, String rawBody) throws FileStorageException.TosPutFailed {
        p.i(rawBody, "rawBody");
        if (200 > i10 || i10 >= 300) {
            throw new FileStorageException.TosPutFailed(i10, "TOS PUT HTTP " + i10 + ": " + K.R1(rawBody, 256), null, 4, null);
        }
        if (H.x0(rawBody)) {
            return new TosCallbackBody("OK", (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 16382, (i) null);
        }
        try {
            AbstractC5171a abstractC5171aC = c.c();
            abstractC5171aC.getSerializersModule();
            return (TosCallbackBody) abstractC5171aC.c(TosCallbackBody.INSTANCE.serializer(), rawBody);
        } catch (Throwable th) {
            throw new FileStorageException.TosPutFailed(i10, "TOS PUT response not parseable: " + K.R1(rawBody, 256), th);
        }
    }
}
