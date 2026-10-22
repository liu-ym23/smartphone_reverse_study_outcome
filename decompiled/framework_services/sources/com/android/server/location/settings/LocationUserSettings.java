package com.android.server.location.settings;

import android.R;
import android.content.res.Resources;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class LocationUserSettings implements SettingsStore.VersionedSettings {
    private static final int VERSION = 1;
    private final boolean mAdasGnssLocationEnabled;

    private LocationUserSettings(boolean adasGnssLocationEnabled) {
        this.mAdasGnssLocationEnabled = adasGnssLocationEnabled;
    }

    @Override // com.android.server.location.settings.SettingsStore.VersionedSettings
    public int getVersion() {
        return 1;
    }

    public boolean isAdasGnssLocationEnabled() {
        return this.mAdasGnssLocationEnabled;
    }

    public LocationUserSettings withAdasGnssLocationEnabled(boolean adasEnabled) {
        if (adasEnabled != this.mAdasGnssLocationEnabled) goto L6;
        return this;
    L6:
        return new LocationUserSettings(adasEnabled);
    }

    void write(DataOutput out) throws IOException {
        out.writeBoolean(this.mAdasGnssLocationEnabled);
    }

    static LocationUserSettings read(Resources resources, int version, DataInput in) throws IOException {
        switch(version) {
            case 1: goto L4;
            default: goto L3;
        };
    L3:
        boolean adasGnssLocationEnabled = resources.getBoolean(R.bool.config_defaultBinderHeavyHitterWatcherEnabled);
    L6:
        return new LocationUserSettings(adasGnssLocationEnabled);
    L4:
        adasGnssLocationEnabled = in.readBoolean();
        goto L6
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof LocationUserSettings) == true) goto L8;
        return false;
    L8:
        LocationUserSettings that = (LocationUserSettings) o;
        if (this.mAdasGnssLocationEnabled != that.mAdasGnssLocationEnabled) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.mAdasGnssLocationEnabled)});
    }
}
