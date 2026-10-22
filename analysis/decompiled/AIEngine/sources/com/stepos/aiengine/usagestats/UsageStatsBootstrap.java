package com.stepos.aiengine.usagestats;

import com.stepos.core.cta.CtaGate;
import com.stepos.core.cta.CtaGatedInitializer;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class UsageStatsBootstrap {

    /* renamed from: a, reason: collision with root package name */
    public static final UsageStatsBootstrap f5934a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f5935b;

    /* renamed from: c, reason: collision with root package name */
    public static final CtaGatedInitializer f5936c;

    static {
        UsageStatsBootstrap usageStatsBootstrap = new UsageStatsBootstrap();
        f5934a = usageStatsBootstrap;
        f5935b = new AtomicBoolean(false);
        f5936c = new CtaGatedInitializer("usage-stats", CtaGate.CTA_ONLY, new UsageStatsBootstrap$ctaInitializer$1(1, usageStatsBootstrap, UsageStatsBootstrap.class, "registerIfCtaGranted", "registerIfCtaGranted(Landroid/content/Context;)V", 0), null, null, 24, null);
    }
}
