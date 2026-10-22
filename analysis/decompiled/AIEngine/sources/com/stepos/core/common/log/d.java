package com.stepos.core.common.log;

import com.stepos.core.ota.confirmui.ModelConfirmFlow;
import com.stepos.core.ota.confirmui.h;
import java.util.function.BiFunction;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7379a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f7380b;

    public /* synthetic */ d(p pVar, int i10) {
        this.f7379a = i10;
        this.f7380b = pVar;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i10 = this.f7379a;
        p pVar = this.f7380b;
        switch (i10) {
            case 0:
                return PerfettoTrace.incrementCounter$lambda$1((c) pVar, obj, obj2);
            case 1:
                return PerfettoTrace.decrementCounter$lambda$4((c) pVar, obj, obj2);
            default:
                return ModelConfirmFlow.start$lambda$4((h) pVar, obj, obj2);
        }
    }
}
