package com.android.server.am;

import android.os.Bundle;
import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes.dex */
public interface IExtCoreSettingsObserver extends IExtBase {
    void beginObserveCoreSettings();

    void init();

    void populateSettings(Bundle r1);
}
