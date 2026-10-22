package com.bytedance.android.ec.search.host.impl;

import com.bytedance.android.btm.api.model.PageFinder;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchEventService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements ITradeSearchEventService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f48169a = null;

    static {
        f48169a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchEventService
    public final void logV3(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        com.bytedance.android.ec.sdk.helper.g.f48122a.logV3(r100, r101);
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchEventService
    public final void logV3(String r100, JSONObject r101, String r102, PageFinder r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "btm");
        Intrinsics.checkNotNullParameter(r103, "pageFinder");
        com.bytedance.android.ec.sdk.helper.g.f48122a.g(r100, r101, r102, r103);
    }
}
