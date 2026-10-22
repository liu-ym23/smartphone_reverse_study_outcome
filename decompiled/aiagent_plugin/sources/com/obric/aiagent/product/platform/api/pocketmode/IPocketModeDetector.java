package com.obric.aiagent.product.platform.api.pocketmode;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.a.a;
import d.x;

/* JADX INFO: compiled from: IPocketModeDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IPocketModeDetector {

    /* JADX INFO: compiled from: IPocketModeDetector.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onUserActionBlocked$default(IPocketModeDetector r2, boolean r3, boolean r4, a r5, int r6, Object r7) {
            IPocketModeDetector r8 = (IPocketModeDetector) ZeusTransformUtils.wrapperContextForParams(r2, IPocketModeDetector.class, "com.obric.aiagent.plugin");
            a<x> r9 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L13;
            if ((r6 & 1) == 0) goto L8;
            r3 = true;
        L8:
            if ((r6 & 2) == 0) goto L10;
            r4 = false;
        L10:
            r8.onUserActionBlocked(r3, r4, r9);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUserActionBlocked");
        }
    }

    Object awaitCheckPassed(d<? super Boolean> r1);

    void checkAsync();

    void hideProximityNearAlert();

    void init();

    boolean isCheckPassed();

    boolean isPocketModeEnabled();

    boolean isPocketModeManuallyDismissed();

    boolean isProximityNearAlertShowing();

    void onUserActionBlocked(boolean r1, boolean r2, a<x> r3);

    void showProximityNearAlert();
}
