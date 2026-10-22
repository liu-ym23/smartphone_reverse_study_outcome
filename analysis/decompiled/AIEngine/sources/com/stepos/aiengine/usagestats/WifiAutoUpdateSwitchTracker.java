package com.stepos.aiengine.usagestats;

import android.database.ContentObserver;
import com.stepos.core.cta.CtaGate;
import com.stepos.core.cta.CtaGatedInitializer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WifiAutoUpdateSwitchTracker {

    /* renamed from: a, reason: collision with root package name */
    public static final WifiAutoUpdateSwitchTracker f5937a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f5938b;

    /* renamed from: c, reason: collision with root package name */
    public static ContentObserver f5939c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f5940d;

    /* renamed from: e, reason: collision with root package name */
    public static final CtaGatedInitializer f5941e;

    static {
        WifiAutoUpdateSwitchTracker wifiAutoUpdateSwitchTracker = new WifiAutoUpdateSwitchTracker();
        f5937a = wifiAutoUpdateSwitchTracker;
        f5938b = new Object();
        f5941e = new CtaGatedInitializer("wifi-auto-update-switch-tracker", CtaGate.CTA_ONLY, new WifiAutoUpdateSwitchTracker$ctaInitializer$1(1, wifiAutoUpdateSwitchTracker, WifiAutoUpdateSwitchTracker.class, "start", "start(Landroid/content/Context;)V", 0), new WifiAutoUpdateSwitchTracker$ctaInitializer$2(1, wifiAutoUpdateSwitchTracker, WifiAutoUpdateSwitchTracker.class, "stop", "stop(Landroid/content/Context;)V", 0), null, 16, null);
    }
}
