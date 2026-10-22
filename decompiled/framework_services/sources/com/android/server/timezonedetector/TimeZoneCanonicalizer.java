package com.android.server.timezonedetector;

import com.android.i18n.timezone.TimeZoneFinder;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
final class TimeZoneCanonicalizer implements Function<String, String> {
    TimeZoneCanonicalizer() {
    }

    @Override // java.util.function.Function
    public /* bridge */ /* synthetic */ String apply(String r1) {
        return apply2(r1);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public String apply2(String timeZoneId) {
        String canonicialZoneId = TimeZoneFinder.getInstance().getCountryZonesFinder().findCanonicalTimeZoneId(timeZoneId);
        if (canonicialZoneId != null) goto L6;
        return timeZoneId;
    L6:
        return canonicialZoneId;
    }
}
