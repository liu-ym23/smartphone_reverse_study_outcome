package com.stepos.deepbinder.service;

import android.app.Application;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.entity.ext.CallerData;
import f.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class DeepBinderService {
    public static final DeepBinderService INSTANCE = new DeepBinderService();

    private DeepBinderService() {
    }

    public final Application getContext() {
        return DeepBinderInternal.getContext();
    }

    public final CallerData getCurrentCallerData() {
        return y9.a.f14176c.a().f14179b.get();
    }
}
