package com.android.server.biometrics.log;

import android.content.Context;
import android.hardware.biometrics.AuthenticateOptions;
import android.hardware.biometrics.common.OperationContext;
import com.android.server.biometrics.sensors.AuthSessionCoordinator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public interface BiometricContext {
    AuthSessionCoordinator getAuthSessionCoordinator();

    BiometricContextSessionInfo getBiometricPromptSessionInfo();

    int getCurrentRotation();

    int getDisplayState();

    int getDockedState();

    int getFoldState();

    BiometricContextSessionInfo getKeyguardEntrySessionInfo();

    boolean isAod();

    boolean isAwake();

    boolean isDisplayOn();

    boolean isHardwareIgnoringTouches();

    void subscribe(OperationContextExt r1, Consumer<OperationContext> r2, Consumer<OperationContext> r3, AuthenticateOptions r4);

    void unsubscribe(OperationContextExt r1);

    OperationContextExt updateContext(OperationContextExt r1, boolean r2);

    static BiometricContext getInstance(Context context) {
        return BiometricContextProvider.defaultProvider(context);
    }
}
