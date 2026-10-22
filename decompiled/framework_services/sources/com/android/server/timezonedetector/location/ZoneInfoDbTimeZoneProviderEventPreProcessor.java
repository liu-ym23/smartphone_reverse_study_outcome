package com.android.server.timezonedetector.location;

import android.service.timezone.TimeZoneProviderEvent;
import android.service.timezone.TimeZoneProviderStatus;
import com.android.i18n.timezone.ZoneInfoDb;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class ZoneInfoDbTimeZoneProviderEventPreProcessor implements TimeZoneProviderEventPreProcessor {
    public ZoneInfoDbTimeZoneProviderEventPreProcessor() {
    }

    @Override // com.android.server.timezonedetector.location.TimeZoneProviderEventPreProcessor
    public TimeZoneProviderEvent preProcess(TimeZoneProviderEvent event) {
        if (event.getSuggestion() != null) goto L5;
    L16:
        return event;
    L5:
        if (event.getSuggestion().getTimeZoneIds().isEmpty() == true) goto L16;
        if (hasInvalidZones(event) == false) goto L15;
        TimeZoneProviderStatus providerStatus = event.getTimeZoneProviderStatus();
        if (providerStatus == null) goto L12;
        TimeZoneProviderStatus.Builder providerStatusBuilder = new TimeZoneProviderStatus.Builder(providerStatus);
    L14:
        return TimeZoneProviderEvent.createUncertainEvent(event.getCreationElapsedMillis(), providerStatusBuilder.setTimeZoneResolutionOperationStatus(3).build());
    L12:
        providerStatusBuilder = new TimeZoneProviderStatus.Builder();
        goto L14
    L15:
        return event;
    }

    private static boolean hasInvalidZones(TimeZoneProviderEvent event) {
        Iterator r0 = event.getSuggestion().getTimeZoneIds().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String timeZone = (String) r0.next();
        if (ZoneInfoDb.getInstance().hasTimeZone(timeZone) == true) goto L4;
        LocationTimeZoneManagerService.infoLog("event=" + event + " has unsupported zone(" + timeZone + ")");
        return true;
    L10:
        return false;
    }
}
