package com.bytedance.android.ecom.live.adapter.impl;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements xi.a {
    public h() {
    }

    @Override // xi.a
    public final void c(long r100, long r101) {
        Intrinsics.checkNotNullParameter("ECFullTradeMonitor", "scene");
    }

    @Override // xi.a
    public final void d(String r100, List<String> r101, Long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "trackLabel");
    }

    @Override // xi.a
    public final void e(Exception r100) {
    }

    @Override // xi.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "abSDKVersion");
        fi.b r101 = gi.a.f481329a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appLog");
    L5:
        r101.a(r100);
    }

    @Override // xi.a
    public final String addCommonParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        fi.b r101 = gi.a.f481329a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("appLog");
    L6:
        return r101.addCommonParams(r100);
    }

    @Override // xi.a
    public final void logV3(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        fi.b r102 = gi.a.f481329a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appLog");
    L5:
        if (r102 == null) goto L8;
        r102.onEventV3(r100, r101);
        return;
    }

    @Override // xi.a
    public final void b(Context r110, String r111, String r112, String r113, long r114, JSONObject r115) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "eventName");
        Intrinsics.checkNotNullParameter(r112, "labelName");
        Intrinsics.checkNotNullParameter(r113, "value");
        Intrinsics.checkNotNullParameter(r115, "ext_json");
        fi.b r100 = gi.a.f481329a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appLog");
    L5:
        if (r100 == null) goto L8;
        r100.b(r110, r111, r112, r113, r114, r115);
        return;
    }
}
