package com.android.server.wm;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes3.dex */
public interface ConfigurationContainerListener {
    default void onRequestedOverrideConfigurationChanged(Configuration overrideConfiguration) {
    }

    default void onMergedOverrideConfigurationChanged(Configuration mergedOverrideConfiguration) {
    }
}
