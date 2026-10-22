package com.bytedance.android.ec.slice;

import cl.d;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.ecom.slice.ext.template.gecko.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcGeckoConfig implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f48184a;

    @Override // com.bytedance.android.ecom.slice.ext.template.gecko.b
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "biz");
    }

    @Override // com.bytedance.android.ecom.slice.ext.template.gecko.b
    public final JSONObject a() {
        SliceInitService r100 = SliceInitService.INSTANCE;     // Catch: Throwable -> L22
        if (r100.getIS_LOCAL_TEST$ec_slice_adapter_impl_saasRelease() == false) goto L13;
        d r101 = k.a();     // Catch: Throwable -> L22
        if (r101 == null) goto L8;
        r101.b();     // Catch: Throwable -> L22
    L8:
        JSONObject r102 = r100.getSliceOptSwitch();     // Catch: Throwable -> L22
        if (r102 == null) goto L11;
        return r102;
    L11:
        return new JSONObject(SliceInitService.DEFAULT_SWITCH);
    L13:
        if (((Boolean) SlcCacheDisableExperiment.f48183a.getValue()).booleanValue() == false) goto L18;
        JSONObject r103 = r100.getSliceOptSwitch();     // Catch: Throwable -> L22
        if (r103 != null) goto L27;
        r103 = new JSONObject(SliceInitService.DEFAULT_SWITCH);     // Catch: Throwable -> L22
    L27:
        return r103.put("disable_global_template_cache", true);
    L18:
        JSONObject r104 = r100.getSliceOptSwitch();     // Catch: Throwable -> L22
        if (r104 == null) goto L21;
        return r104;
    L21:
        return new JSONObject(SliceInitService.DEFAULT_SWITCH);
    L22:
        th = move-exception;
        SliceInitService.INSTANCE.slcEnsureNotReachHere(th, "SlcGeckoConfig getGeckoSwitch error");
        return new JSONObject();
    }

    @Override // com.bytedance.android.ecom.slice.ext.template.gecko.b
    public final a c() {
        if (SliceInitService.INSTANCE.getIS_LOCAL_TEST$ec_slice_adapter_impl_saasRelease() == true) goto L7;
        return null;
    L7:
        return (a) this.f48184a.getValue();
    }

    public SlcGeckoConfig() {
        this.f48184a = LazyKt.lazy(SlcGeckoConfig$geckoDebug$2.INSTANCE);
    }
}
