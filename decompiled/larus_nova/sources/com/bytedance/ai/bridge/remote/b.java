package com.bytedance.ai.bridge.remote;

import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f36081a = 0;

    static {
    }

    public static f3.a a(Throwable r100, f3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r101, "businessErrNo");
        if ((r100 instanceof RemoteApiException.Business) == false) goto L6;
        return r101;
    L6:
        if ((r100 instanceof RemoteApiException.InvalidResponse) == false) goto L9;
        return f3.a.f475272m;
    L9:
        if ((r100 instanceof RemoteApiException.Http) == false) goto L15;
        if (((RemoteApiException.Http) r100).getStatusCode() != 408) goto L69;
        return f3.a.f475282w;
    L69:
        return f3.a.f475284y;
    L15:
        if ((r100 instanceof RemoteApiException.Network) == false) goto L58;
        Throwable r102 = r100.getCause();
        if (r102 == null) goto L20;
        r100 = r102;
    L20:
        List r103 = SequencesKt.toList(SequencesKt.generateSequence(r100, new a()));
        boolean r104 = r103 instanceof Collection;
        boolean r105 = true;
        if (r104 == true) goto L23;
    L25:
        Iterator r106 = r103.iterator();
    L27:
        if (r106.hasNext() == false) goto L31;
        if ((((Throwable) r106.next()) instanceof SocketTimeoutException) == false) goto L27;
        boolean r107 = true;
    L32:
        if (r107 == false) goto L35;
        f3.a r108 = f3.a.f475282w;
    L70:
        return r108;
    L35:
        if (r104 == true) goto L37;
    L39:
        Iterator r109 = r103.iterator();
    L41:
        if (r109.hasNext() == false) goto L53;
        Throwable r110 = (Throwable) r109.next();
        if ((r110 instanceof NetworkNotAvailabeException) == false) goto L45;
    L50:
        boolean r111 = true;
    L51:
        if (r111 == false) goto L41;
    L54:
        if (r105 == false) goto L56;
        r108 = f3.a.f475283x;
        goto L70
    L56:
        r108 = f3.a.f475284y;
        goto L70
    L45:
        if ((r110 instanceof UnknownHostException) == true) goto L50;
        if ((r110 instanceof ConnectException) == true) goto L50;
        r111 = false;
    L53:
        r105 = false;
        goto L54
    L37:
        if (r103.isEmpty() == false) goto L39;
    L31:
        r107 = false;
        goto L32
    L23:
        if (r103.isEmpty() == false) goto L25;
    L58:
        return f3.a.f475265f;
    }
}
