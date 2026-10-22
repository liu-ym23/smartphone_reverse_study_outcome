package com.stepos.core.cta;

import android.content.Context;
import com.stepos.core.common.settings.AiEngineSystemSettings;
import com.tencent.mmkv.MMKV;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CTAPermissionManager {
    private static final String KEY_CTA_FIRMWARE_MODE = "cta_firmware_mode";
    private static final String MMKV_ID = "aiengine_cta";
    private static final String PROP_CTA_FIRMWARE = "ro.vendor.stepos.cta_firmware";
    private static volatile Context appContext;
    private static volatile MMKV mmkv;
    public static final CTAPermissionManager INSTANCE = new CTAPermissionManager();
    private static final CopyOnWriteArraySet<SwitchChangeListener> switchListeners = new CopyOnWriteArraySet<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface SwitchChangeListener {
        void onChanged();
    }

    private CTAPermissionManager() {
    }

    private final void dispatchSwitchChange() {
        Iterator<T> it = switchListeners.iterator();
        while (it.hasNext()) {
            try {
                ((SwitchChangeListener) it.next()).onChanged();
                n nVar = n.f10413a;
            } catch (Throwable th) {
                kotlin.c.a(th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String readSystemProperty(java.lang.String r4) {
        /*
            r3 = this;
            r3 = 0
            java.lang.String r0 = "android.os.SystemProperties"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L22
            java.lang.String r1 = "get"
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            java.lang.Class[] r2 = new java.lang.Class[]{r2}     // Catch: java.lang.Throwable -> L22
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch: java.lang.Throwable -> L22
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch: java.lang.Throwable -> L22
            java.lang.Object r4 = r0.invoke(r3, r4)     // Catch: java.lang.Throwable -> L22
            boolean r0 = r4 instanceof java.lang.String     // Catch: java.lang.Throwable -> L22
            if (r0 == 0) goto L24
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L22
            goto L25
        L22:
            r4 = move-exception
            goto L30
        L24:
            r4 = r3
        L25:
            if (r4 == 0) goto L2e
            boolean r0 = gc.q.t0(r4)     // Catch: java.lang.Throwable -> L22
            if (r0 != 0) goto L2e
            goto L34
        L2e:
            r4 = r3
            goto L34
        L30:
            kotlin.Result$Failure r4 = kotlin.c.a(r4)
        L34:
            boolean r0 = r4 instanceof kotlin.Result.Failure
            if (r0 == 0) goto L39
            goto L3a
        L39:
            r3 = r4
        L3a:
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.cta.CTAPermissionManager.readSystemProperty(java.lang.String):java.lang.String");
    }

    public final void addSwitchListener(SwitchChangeListener listener) {
        g.f(listener, "listener");
        switchListeners.add(listener);
    }

    public final boolean hasCTAPermission() {
        Context context = appContext;
        if (context == null) {
            return true;
        }
        return AiEngineSystemSettings.isCtaAgreed$default(AiEngineSystemSettings.INSTANCE, context, false, 2, null);
    }

    public final void init(Context context) {
        g.f(context, "context");
        appContext = context.getApplicationContext();
        MMKV.m(context);
        mmkv = MMKV.o(MMKV_ID);
    }

    public final boolean isCtaFirmwareMode() {
        MMKV mmkv2 = mmkv;
        return (mmkv2 == null || !mmkv2.c(KEY_CTA_FIRMWARE_MODE)) ? g.b(readSystemProperty(PROP_CTA_FIRMWARE), "1") : mmkv2.d(KEY_CTA_FIRMWARE_MODE, false);
    }

    public final boolean isModelOtaAllowed() {
        return hasCTAPermission() && isModelServiceEnabled();
    }

    public final boolean isModelServiceEnabled() {
        Context context = appContext;
        if (context == null) {
            return true;
        }
        return AiEngineSystemSettings.isModelServiceEnabled$default(AiEngineSystemSettings.INSTANCE, context, false, 2, null);
    }

    public final boolean isWlanAutoUpgradeEnabled() {
        Context context = appContext;
        if (context == null) {
            return true;
        }
        return AiEngineSystemSettings.isWifiAutoUpdateEnabled$default(AiEngineSystemSettings.INSTANCE, context, false, 2, null);
    }

    public final void removeSwitchListener(SwitchChangeListener listener) {
        g.f(listener, "listener");
        switchListeners.remove(listener);
    }

    public final void revokeCta() {
        Context context = appContext;
        if (context == null) {
            return;
        }
        AiEngineSystemSettings aiEngineSystemSettings = AiEngineSystemSettings.INSTANCE;
        aiEngineSystemSettings.setCtaAgreed(context, false);
        aiEngineSystemSettings.setModelServiceEnabled(context, false);
        dispatchSwitchChange();
    }

    public final void setCTAPermission(boolean z) {
        Context context = appContext;
        if (context != null) {
            AiEngineSystemSettings.INSTANCE.setCtaAgreed(context, z);
        }
        dispatchSwitchChange();
    }

    public final void setCtaFirmwareModeOverride(boolean z) {
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            mmkv2.k(KEY_CTA_FIRMWARE_MODE, z);
        }
    }

    public final void setModelServiceEnabled(boolean z) {
        Context context = appContext;
        if (context != null) {
            AiEngineSystemSettings.INSTANCE.setModelServiceEnabled(context, z);
        }
        dispatchSwitchChange();
    }

    public final void setWlanAutoUpgrade(boolean z) {
        Context context = appContext;
        if (context != null) {
            AiEngineSystemSettings.INSTANCE.setWifiAutoUpdate(context, z);
        }
        dispatchSwitchChange();
    }
}
