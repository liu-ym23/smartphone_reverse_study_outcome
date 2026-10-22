package com.android.server.wm;

import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtDisplayWindowSettings extends IExtBase {
    int[] handleResolutionMigration(DisplayContent r1, int r2, int r3, int r4, DisplayWindowSettings.SettingsProvider.SettingsEntry r5, boolean r6);
}
