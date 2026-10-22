package com.android.server.biometrics.sensors;

import android.hardware.biometrics.BiometricAuthenticator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface AuthenticationConsumer {
    void onAuthenticated(BiometricAuthenticator.Identifier r1, boolean r2, ArrayList<Byte> r3);
}
