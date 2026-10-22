package com.bytedance.android.shopping.slice;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.render.util.h;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.shopping.anchorv4.experiment.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class PdpSliceRegister {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f183215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile JSONObject f183216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Function0<JSONObject> f183217c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f183218d = null;

    static {
        f183217c = PdpSliceRegister$pdpSliceSettingProvider$1.INSTANCE;
        f183218d = LazyKt.lazy(PdpSliceRegister$preloadInfo$2.INSTANCE);
    }

    public static Function0 a() {
        int r100 = i.f166762a;
        JSONObject r101 = f183217c.invoke();
        if (r101 == null) goto L9;
        if (r101.optBoolean("disable_preload_pdp_template", false) != true) goto L9;
        return null;
    L9:
        return PdpSliceRegister$getPreloadInfoProvider$1.INSTANCE;
    }

    public static void c() {
        h.a(PdpSliceRegister$register$1.INSTANCE);
    }

    public static void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.f51232l, "pdp", "pdp_slice_template", wh.a.b(r100), a());
    }
}
