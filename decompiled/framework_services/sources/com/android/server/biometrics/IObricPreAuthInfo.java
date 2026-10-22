package com.android.server.biometrics;

import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes.dex */
public interface IObricPreAuthInfo extends IObricBase {
    default boolean forceAllowFace(int modality, String opPackageName, int requestedStrength) {
        return false;
    }
}
