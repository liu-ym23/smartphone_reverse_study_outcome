package com.bytedance.android.ec.host.impl;

import com.larus.applog.api.IApplog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class p implements yj.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f46213a = null;

    static {
        f46213a = new p();
    }

    public p() {
    }

    @Override // yj.k
    public final void logV3(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        IApplog.f287053a.reportEvent(r100, r101);
    }
}
