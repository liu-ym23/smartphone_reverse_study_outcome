package com.bytedance.bdtracker;

import com.bytedance.applog.exposure.ViewExposureConfig;
import com.bytedance.applog.exposure.ViewExposureData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class q0 {
    public final ViewExposureData<ViewExposureConfig> a;
    public boolean b;
    public u0 c;
    public long d;

    public /* synthetic */ q0(ViewExposureData data, boolean z, u0 viewExposureTriggerType, long j, int i) {
        z = (i & 2) != 0 ? false : z;
        viewExposureTriggerType = (i & 4) != 0 ? u0.NOT_EXPOSURE : viewExposureTriggerType;
        j = (i & 8) != 0 ? 0L : j;
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(viewExposureTriggerType, "viewExposureTriggerType");
        this.a = data;
        this.b = z;
        this.c = viewExposureTriggerType;
        this.d = j;
    }

    public final void a(u0 u0Var) {
        Intrinsics.checkParameterIsNotNull(u0Var, "<set-?>");
        this.c = u0Var;
    }
}
