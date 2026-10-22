package com.android.server.policy;

import android.os.Bundle;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IObricPhoneWindowManager extends IObricBase {
    default void adjustAssistBundle(Bundle args) {
    }

    default void handleWindowVisibleChanged(String packageName, boolean winVisible) {
    }
}
