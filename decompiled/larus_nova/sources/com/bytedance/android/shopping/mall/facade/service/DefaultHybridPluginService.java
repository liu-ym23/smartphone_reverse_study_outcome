package com.bytedance.android.shopping.mall.facade.service;

import android.content.Context;
import com.bytedance.android.ec.hybrid.a;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yj.u;
import yj.x;

/* JADX INFO: loaded from: classes13.dex */
public final class DefaultHybridPluginService implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f176516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f176517b;

    static {
        f176516a = true;
    }

    @Override // yj.u
    public final boolean a() {
        if (f176516a == false) goto L5;
    L6:
        d("check", 0L, null);
    L7:
        f176516a = false;
        IHybridHostService r100 = a.h();
        if (r100 == null) goto L12;
        x r101 = r100.getECPluginService();
        if (r101 == null) goto L12;
        r101.a();
    L12:
        f176517b = true;
        return true;
    L5:
        if (f176517b == true) goto L7;
        goto L6
    }

    @Override // yj.u
    public final List<String> c() {
        return CollectionsKt.emptyList();
    }

    public static void d(String r100, Long r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("status", r100);
        r103.put("duration", r101);
        r103.put("errorMessage", r102);
        Unit r104 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3("mall_second_page_plugin", r103);
    }

    @Override // yj.u
    public final void b(Context r100, final Function2<? super String, ? super Boolean, Unit> r101, final Function2<? super String, ? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onSuccess");
        Intrinsics.checkNotNullParameter(r102, "onFail");
        final long r103 = System.currentTimeMillis();
        x r104 = null;
        d("start", 0L, null);
        IHybridHostService r105 = a.h();
        if (r105 == null) goto L5;
        r104 = r105.getECPluginService();
    L5:
        Intrinsics.checkNotNull(r104);
        r104.b(new DefaultHybridPluginService$installECPlugin$1(r103, r101), new DefaultHybridPluginService$installECPlugin$2(r103, r102));
    }
}
