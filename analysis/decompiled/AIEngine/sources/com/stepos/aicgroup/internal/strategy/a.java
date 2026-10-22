package com.stepos.aicgroup.internal.strategy;

import com.stepos.aicgroup.internal.strategy.CGroupStrategyManager;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5747a;

    @Override // zb.l
    public final Object invoke(Object obj) {
        CGroupStrategyManager.StrategyWithPriority it = (CGroupStrategyManager.StrategyWithPriority) obj;
        CGroupStrategyManager.Companion companion = CGroupStrategyManager.Companion;
        g.f(it, "it");
        return Boolean.valueOf(g.b(it.getStrategy().getName(), this.f5747a));
    }
}
