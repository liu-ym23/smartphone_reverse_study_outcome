package com.stepos.core.ota.confirmui;

import android.content.Context;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EnhancedServiceGuide {
    public static final EnhancedServiceGuide INSTANCE = new EnhancedServiceGuide();
    private static volatile zb.l<? super Context, Integer> launcher;

    private EnhancedServiceGuide() {
    }

    public static final zb.l<Context, Integer> getLauncher() {
        return launcher;
    }

    public static final void setLauncher(zb.l<? super Context, Integer> lVar) {
        launcher = lVar;
    }

    public static /* synthetic */ void getLauncher$annotations() {
    }
}
