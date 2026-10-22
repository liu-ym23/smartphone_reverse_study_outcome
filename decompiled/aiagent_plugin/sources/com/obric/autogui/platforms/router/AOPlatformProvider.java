package com.obric.autogui.platforms.router;

import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformInterface;
import com.obric.autogui.common.api.platform.AOPlatformProviderInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AOPlatformProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOPlatformProvider implements AOPlatformProviderInterface {
    public static final a Companion = null;
    private static final String TAG = "AOPlatformProvider";
    private volatile AOPlatformInterface mPlatform;

    /* JADX INFO: compiled from: AOPlatformProvider.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public AOPlatformProvider() {
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformProviderInterface
    public synchronized AOPlatformInterface getPlatform() {
        monitor-enter(this);
        AOPlatformInterface r0 = this.mPlatform;     // Catch: Throwable -> L18
        if (r0 == null) goto L9;
        Loog.INSTANCE.i(TAG, "curPlatform is not null, return it.");     // Catch: Throwable -> L18
        monitor-exit(this);
        return r0;
    L9:
        if (ObricProductSdk.INSTANCE.featureService().isObricOs() == false) goto L12;
        Loog.INSTANCE.i(TAG, "productName is Obric, create ObricPlatformInterface.");     // Catch: Throwable -> L18
        AOPlatformInterface r1 = (AOPlatformInterface) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.obric.a(), AOPlatformInterface.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
    L15:
        this.mPlatform = r1;     // Catch: Throwable -> L18
        monitor-exit(this);
        return r1;
    L12:
        if (isMiuiOs() == false) goto L14;
        Loog.INSTANCE.i(TAG, "productName is Genesis-R.");     // Catch: Throwable -> L18
        r1 = (AOPlatformInterface) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.miui.a(), AOPlatformInterface.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        goto L15
    L14:
        Loog.INSTANCE.i(TAG, "productName isn't Obric or Genesis-R.");     // Catch: Throwable -> L18
        r1 = (AOPlatformInterface) ZeusTransformUtils.preCheckCast(new com.obric.autogui.platforms.genesis.a(), AOPlatformInterface.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private final boolean isMiuiOs() {
        return o.a(ObricProductSdk.INSTANCE.featureService().getObricProductName(), IFeatureServiceKt.PRODUCT_GENESIS_R);
    }
}
