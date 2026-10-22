package com.android.server.timedetector;

import android.app.time.ExternalTimeSuggestion;
import android.app.time.TimeCapabilitiesAndConfig;
import android.app.time.TimeConfiguration;
import android.app.time.TimeState;
import android.app.time.UnixEpochTime;
import android.app.timedetector.ManualTimeSuggestion;
import android.app.timedetector.TelephonyTimeSuggestion;
import com.android.internal.util.Preconditions;
import com.android.server.location.LocationLogsRecorder;
import com.android.server.timezonedetector.Dumpable;
import com.android.server.timezonedetector.StateChangeListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
public interface TimeDetectorStrategy extends Dumpable {
    public static final int ORIGIN_EXTERNAL = 5;
    public static final int ORIGIN_GNSS = 4;
    public static final int ORIGIN_MANUAL = 2;
    public static final int ORIGIN_NETWORK = 3;
    public static final int ORIGIN_TELEPHONY = 1;

    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Origin {
    }

    void addChangeListener(StateChangeListener r1);

    void addNetworkTimeUpdateListener(StateChangeListener r1);

    void clearLatestNetworkSuggestion();

    boolean confirmTime(UnixEpochTime r1);

    TimeCapabilitiesAndConfig getCapabilitiesAndConfig(int r1, boolean r2);

    NetworkTimeSuggestion getLatestNetworkSuggestion();

    TimeState getTimeState();

    void setTimeState(TimeState r1);

    void suggestExternalTime(ExternalTimeSuggestion r1);

    void suggestGnssTime(GnssTimeSuggestion r1);

    boolean suggestManualTime(int r1, ManualTimeSuggestion r2, boolean r3);

    void suggestNetworkTime(NetworkTimeSuggestion r1);

    void suggestTelephonyTime(TelephonyTimeSuggestion r1);

    boolean updateConfiguration(int r1, TimeConfiguration r2, boolean r3);

    static String originToString(int origin) {
        switch(origin) {
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L4;
        };
    L5:
        return "external";
    L7:
        return LocationLogsRecorder.KEY_FILE_GNSS;
    L9:
        return "network";
    L11:
        return "manual";
    L13:
        return "telephony";
    L4:
        throw new IllegalArgumentException("origin=" + origin);
    }

    static int stringToOrigin(String originString) {
        byte r0 = 0;
        if (originString == null) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2);
        switch(originString.hashCode()) {
            case -1820761141: goto L22;
            case -1081415738: goto L19;
            case 3177863: goto L16;
            case 783201304: goto L13;
            case 1843485230: goto L10;
            default: goto L24;
        };
    L24:
        r0 = -1;
    L25:
        switch(r0) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L28;
            default: goto L27;
        };
    L28:
        return 5;
    L30:
        return 4;
    L31:
        return 1;
    L32:
        return 3;
    L33:
        return 2;
    L27:
        throw new IllegalArgumentException("originString=" + originString);
    L10:
        if (originString.equals("network") == false) goto L24;
        r0 = 1;
        goto L25
    L13:
        if (originString.equals("telephony") == false) goto L24;
        r0 = 2;
        goto L25
    L16:
        if (originString.equals(LocationLogsRecorder.KEY_FILE_GNSS) == false) goto L24;
        r0 = 3;
        goto L25
    L19:
        if (originString.equals("manual") == false) goto L24;
    L22:
        if (originString.equals("external") == false) goto L24;
        r0 = 4;
        goto L25
    L5:
        r2 = false;
        goto L6
    }
}
