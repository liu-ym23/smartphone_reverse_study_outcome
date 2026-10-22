package com.stepos.core.ota.process;

import android.app.Service;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaForegroundController {
    public static final OtaForegroundController INSTANCE = new OtaForegroundController();

    private OtaForegroundController() {
    }

    public final void start(Service service) {
        g.f(service, "service");
    }

    public final void stop(Service service) {
        g.f(service, "service");
    }
}
