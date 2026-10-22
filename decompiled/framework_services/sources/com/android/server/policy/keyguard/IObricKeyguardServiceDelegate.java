package com.android.server.policy.keyguard;

import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IObricKeyguardServiceDelegate extends IObricBase {
    default void handleWindowVisibleChanged(String packageName, boolean winVisible) {
    }
}
