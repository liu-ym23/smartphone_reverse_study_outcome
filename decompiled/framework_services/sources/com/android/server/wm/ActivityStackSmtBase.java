package com.android.server.wm;

import android.os.PowerAdvisorInternal;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityStackSmtBase {
    public boolean isPrefetch;
    public final PowerAdvisorInternal mPowerAdvisorInternal;

    public ActivityStackSmtBase() {
        this.isPrefetch = false;
        this.mPowerAdvisorInternal = (PowerAdvisorInternal) LocalServices.getService(PowerAdvisorInternal.class);
    }
}
