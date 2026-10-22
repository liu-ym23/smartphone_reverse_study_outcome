package com.android.server.timezonedetector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class GeolocationTimeZoneSuggestion {
    private final long mEffectiveFromElapsedMillis;
    private final List<String> mZoneIds;

    private GeolocationTimeZoneSuggestion(long effectiveFromElapsedMillis, List<String> zoneIds) {
        this.mEffectiveFromElapsedMillis = effectiveFromElapsedMillis;
        if (zoneIds != null) goto L5;
        this.mZoneIds = null;
        return;
    L5:
        this.mZoneIds = Collections.unmodifiableList(new ArrayList(zoneIds));
    }

    public static GeolocationTimeZoneSuggestion createUncertainSuggestion(long effectiveFromElapsedMillis) {
        return new GeolocationTimeZoneSuggestion(effectiveFromElapsedMillis, null);
    }

    public static GeolocationTimeZoneSuggestion createCertainSuggestion(long effectiveFromElapsedMillis, List<String> zoneIds) {
        return new GeolocationTimeZoneSuggestion(effectiveFromElapsedMillis, zoneIds);
    }

    public long getEffectiveFromElapsedMillis() {
        return this.mEffectiveFromElapsedMillis;
    }

    public List<String> getZoneIds() {
        return this.mZoneIds;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L17;
        GeolocationTimeZoneSuggestion that = (GeolocationTimeZoneSuggestion) o;
        if (this.mEffectiveFromElapsedMillis != that.mEffectiveFromElapsedMillis) goto L16;
        if (Objects.equals(this.mZoneIds, that.mZoneIds) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.mEffectiveFromElapsedMillis), this.mZoneIds});
    }

    public String toString() {
        return "GeolocationTimeZoneSuggestion{mEffectiveFromElapsedMillis=" + this.mEffectiveFromElapsedMillis + ", mZoneIds=" + this.mZoneIds + '}';
    }
}
