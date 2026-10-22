package com.obric.aiagent.product.platform.impl.pocketmode;

import com.obric.aiagent.platform.depend.ILogDepend;
import d.h.b.h;

/* JADX INFO: compiled from: GRPocketModeDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.obric.aiagent.product.platform.impl.pocketmode.a {
    private static final String TAG = "GRPocketModeDetector";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f18864b = null;

    /* JADX INFO: compiled from: GRPocketModeDetector.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f18864b = new a(null);
    }

    public b() {
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void showProximityNearAlert() {
        ILogDepend.Companion.d(TAG, "showProximityNearAlert() called, do nothing");
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isPocketModeEnabled() {
        ILogDepend.Companion.d(TAG, "isPocketModeEnabled() return false");
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isPocketModeManuallyDismissed() {
        ILogDepend.Companion.d(TAG, "isPocketModeManuallyDismissed() return false");
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isProximityNearAlertShowing() {
        ILogDepend.Companion.d(TAG, "isProximityNearAlertShowing() return false");
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void hideProximityNearAlert() {
        ILogDepend.Companion.d(TAG, "hideProximityNearAlert() called, do nothing");
    }
}
