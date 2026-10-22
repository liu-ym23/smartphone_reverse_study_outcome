package com.stepos.familyguard.ui.usage;

import android.os.Bundle;
import androidx.fragment.app.ComponentCallbacksC0511f;

/* loaded from: classes.dex */
public class ProxyFragment extends ComponentCallbacksC0511f {

    /* renamed from: f0, reason: collision with root package name */
    private int f14924f0;

    /* renamed from: g0, reason: collision with root package name */
    private long f14925g0;

    public long U1() {
        return this.f14925g0;
    }

    public int V1() {
        return this.f14924f0;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        if (u() == null) {
            this.f14924f0 = 0;
            this.f14925g0 = -1L;
        } else {
            this.f14924f0 = u().getInt("proxy", 0);
            this.f14925g0 = u().getLong("operator_id", -1L);
        }
    }
}
