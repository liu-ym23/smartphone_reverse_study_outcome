package com.stepos.core.cta;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CtaGateGuard {
    public static final CtaGateGuard INSTANCE = new CtaGateGuard();
    private static final String POLICY_ACTIVITY_CLASS = "com.stepos.aiengine.cta.PolicyActivity";

    private CtaGateGuard() {
    }

    public final Intent createPolicyIntent(Context ctx) {
        g.f(ctx, "ctx");
        Intent className = new Intent().setClassName(ctx.getPackageName(), POLICY_ACTIVITY_CLASS);
        g.e(className, "setClassName(...)");
        return className;
    }

    public final boolean isAuthorized() {
        return CTAPermissionManager.INSTANCE.hasCTAPermission();
    }
}
