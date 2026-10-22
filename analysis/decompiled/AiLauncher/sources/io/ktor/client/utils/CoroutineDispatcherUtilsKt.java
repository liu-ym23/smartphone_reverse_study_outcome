package io.ktor.client.utils;

import Ua.I;
import Ua.Y;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LUa/Y;", "", "threadCount", "", "dispatcherName", "LUa/I;", "clientDispatcher", "(LUa/Y;ILjava/lang/String;)LUa/I;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CoroutineDispatcherUtilsKt {
    @InternalAPI
    public static final I clientDispatcher(Y y10, int i10, String dispatcherName) {
        p.i(y10, "<this>");
        p.i(dispatcherName, "dispatcherName");
        return I.t1(Y.b(), i10, null, 2, null);
    }

    public static /* synthetic */ I clientDispatcher$default(Y y10, int i10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "ktor-client-dispatcher";
        }
        return clientDispatcher(y10, i10, str);
    }
}
