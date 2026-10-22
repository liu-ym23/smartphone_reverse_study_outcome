package com.stepos.aiengine.preheat;

import com.stepos.core.common.loadguard.PreheatLoadBudget;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final /* synthetic */ class PreheatGateController$1 extends FunctionReferenceImpl implements zb.a<Double> {
    @Override // zb.a
    public final Double invoke() {
        return PreheatLoadBudget.readMemAvailableRatio();
    }
}
