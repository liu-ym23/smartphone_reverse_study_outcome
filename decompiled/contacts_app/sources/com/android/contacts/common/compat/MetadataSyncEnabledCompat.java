package com.android.contacts.common.compat;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes.dex */
public class MetadataSyncEnabledCompat {
    public MetadataSyncEnabledCompat() {
    }

    public static boolean isMetadataSyncEnabled(Context r2) {
        if (CompatUtils.isNCompatible() == true) goto L5;
        return false;
    L5:
        if (Settings.Global.getInt(r2.getContentResolver(), "contact_metadata_sync_enabled", 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
