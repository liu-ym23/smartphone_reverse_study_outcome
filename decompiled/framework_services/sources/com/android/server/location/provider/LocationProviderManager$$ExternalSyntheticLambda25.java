package com.android.server.location.provider;

import java.util.function.Predicate;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class LocationProviderManager$$ExternalSyntheticLambda25 implements Predicate {
    public /* synthetic */ LocationProviderManager$$ExternalSyntheticLambda25() {
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r1) {
        return ((LocationProviderManager.Registration) r1).onProviderLocationRequestChanged();
    }
}
