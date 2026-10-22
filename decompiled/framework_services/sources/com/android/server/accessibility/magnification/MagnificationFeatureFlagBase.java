package com.android.server.accessibility.magnification;

import android.os.Binder;
import android.provider.DeviceConfig;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
abstract class MagnificationFeatureFlagBase {
    /* JADX INFO: renamed from: $r8$lambda$-Kf-nTTxGJWSQrXs1QThaOrkPek, reason: not valid java name */
    public static /* synthetic */ void m854$r8$lambda$KfnTTxGJWSQrXs1QThaOrkPek(Runnable r0) {
        lambda$clearCallingIdentifyAndTryCatch$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$HMEPfKgq-evSmpLkWWXih2P9xnY, reason: not valid java name */
    public static /* synthetic */ void m855$r8$lambda$HMEPfKgqevSmpLkWWXih2P9xnY(MagnificationFeatureFlagBase r0, AtomicBoolean r1) {
        r0.lambda$isFeatureFlagEnabled$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$HjoLv6m51NE5GZx1H-Rvwx2RpYI, reason: not valid java name */
    public static /* synthetic */ void m856$r8$lambda$HjoLv6m51NE5GZx1HRvwx2RpYI(MagnificationFeatureFlagBase r0, Runnable r1, DeviceConfig.Properties r2) {
        r0.lambda$addOnChangedListener$5(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$KXsRNBwfYHScpt3V4aI4KVvs4mk(MagnificationFeatureFlagBase r0, AtomicBoolean r1) {
        r0.lambda$isFeatureFlagEnabled$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$SunZ8DA06iWlbLRF5iW9b60qXOw() {
        lambda$addOnChangedListener$7();
    }

    public static /* synthetic */ void $r8$lambda$axYtYuWd7ezeyobLYU1aL4M31Ak(MagnificationFeatureFlagBase r0, Executor r1, DeviceConfig.OnPropertiesChangedListener r2) {
        r0.lambda$addOnChangedListener$6(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$cGjSvEbTaEmwYD5v5crtvv-LJek, reason: not valid java name */
    public static /* synthetic */ void m857$r8$lambda$cGjSvEbTaEmwYD5v5crtvvLJek(MagnificationFeatureFlagBase r0, AtomicBoolean r1) {
        r0.lambda$setFeatureFlagEnabled$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$uU7CT_E1cwLbLd_9IPzRi_aj5kU(MagnificationFeatureFlagBase r0, AtomicBoolean r1, boolean r2) {
        r0.lambda$setFeatureFlagEnabled$3(r1, r2);
    }

    abstract boolean getDefaultValue();

    abstract String getFeatureName();

    abstract String getNamespace();

    MagnificationFeatureFlagBase() {
    }

    private void clearCallingIdentifyAndTryCatch(final Runnable tryBlock, Runnable catchBlock) {
        Binder.withCleanCallingIdentity(new MagnificationFeatureFlagBase$$ExternalSyntheticLambda0(tryBlock));     // Catch: Throwable -> L4
        return;
    L5:
        catchBlock.run();
    }

    private static /* synthetic */ void lambda$clearCallingIdentifyAndTryCatch$0(Runnable tryBlock) throws Exception {
        tryBlock.run();
    }

    public boolean isFeatureFlagEnabled() {
        final AtomicBoolean isEnabled = new AtomicBoolean(getDefaultValue());
        clearCallingIdentifyAndTryCatch(new MagnificationFeatureFlagBase$$ExternalSyntheticLambda4(this, isEnabled), new MagnificationFeatureFlagBase$$ExternalSyntheticLambda5(this, isEnabled));
        return isEnabled.get();
    }

    private /* synthetic */ void lambda$isFeatureFlagEnabled$1(AtomicBoolean isEnabled) {
        isEnabled.set(DeviceConfig.getBoolean(getNamespace(), getFeatureName(), getDefaultValue()));
    }

    private /* synthetic */ void lambda$isFeatureFlagEnabled$2(AtomicBoolean isEnabled) {
        isEnabled.set(getDefaultValue());
    }

    public boolean setFeatureFlagEnabled(final boolean isEnabled) {
        final AtomicBoolean success = new AtomicBoolean(getDefaultValue());
        clearCallingIdentifyAndTryCatch(new MagnificationFeatureFlagBase$$ExternalSyntheticLambda6(this, success, isEnabled), new MagnificationFeatureFlagBase$$ExternalSyntheticLambda7(this, success));
        return success.get();
    }

    private /* synthetic */ void lambda$setFeatureFlagEnabled$3(AtomicBoolean success, boolean isEnabled) {
        success.set(DeviceConfig.setProperty(getNamespace(), getFeatureName(), Boolean.toString(isEnabled), false));
    }

    private /* synthetic */ void lambda$setFeatureFlagEnabled$4(AtomicBoolean success) {
        success.set(getDefaultValue());
    }

    public DeviceConfig.OnPropertiesChangedListener addOnChangedListener(final Executor executor, final Runnable listener) {
        final DeviceConfig.OnPropertiesChangedListener onChangedListener = new MagnificationFeatureFlagBase$$ExternalSyntheticLambda1(this, listener);
        clearCallingIdentifyAndTryCatch(new MagnificationFeatureFlagBase$$ExternalSyntheticLambda2(this, executor, onChangedListener), new MagnificationFeatureFlagBase$$ExternalSyntheticLambda3());
        return onChangedListener;
    }

    private /* synthetic */ void lambda$addOnChangedListener$5(Runnable listener, DeviceConfig.Properties properties) {
        if (properties.getKeyset().contains(getFeatureName()) == false) goto L6;
        listener.run();
        return;
    }

    private /* synthetic */ void lambda$addOnChangedListener$6(Executor executor, DeviceConfig.OnPropertiesChangedListener onChangedListener) {
        DeviceConfig.addOnPropertiesChangedListener(getNamespace(), executor, onChangedListener);
    }

    private static /* synthetic */ void lambda$addOnChangedListener$7() {
    }

    public void removeOnChangedListener(DeviceConfig.OnPropertiesChangedListener onChangedListener) {
        DeviceConfig.removeOnPropertiesChangedListener(onChangedListener);
    }
}
