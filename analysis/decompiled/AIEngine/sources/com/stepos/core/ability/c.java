package com.stepos.core.ability;

import android.util.Pair;
import com.stepos.core.common.telemetry.DataVolume;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.deepbinder.service.cache.ServiceCache;
import java.util.Map;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7217a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7218b;

    public /* synthetic */ c(int i10, int i11) {
        this.f7217a = i11;
        this.f7218b = i10;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        boolean z;
        switch (this.f7217a) {
            case 0:
                return AbilityBinderImpl.handleInfer$lambda$22$lambda$21$lambda$20$lambda$19(this.f7218b, (DataVolume) obj);
            case 1:
                return PowerPerfTracker.onInferStageFromNative$lambda$9(this.f7218b, (DataVolume) obj);
            case 2:
                return PowerPerfTracker.onInferStageFromNative$lambda$11(this.f7218b, (DataVolume) obj);
            default:
                Map.Entry entry = (Map.Entry) obj;
                kotlin.jvm.internal.g.f(entry, "entry");
                Integer num = (Integer) ((Pair) entry.getKey()).first;
                if (num != null && num.intValue() == this.f7218b) {
                    ServiceCache.b((ServiceCache.b) entry.getValue());
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
        }
    }

    public /* synthetic */ c(int i10, ServiceCache serviceCache) {
        this.f7217a = 3;
        this.f7218b = i10;
    }
}
