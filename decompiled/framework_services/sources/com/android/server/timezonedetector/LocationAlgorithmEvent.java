package com.android.server.timezonedetector;

import android.app.time.LocationTimeZoneAlgorithmStatus;
import android.os.ShellCommand;
import android.os.SystemClock;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public final class LocationAlgorithmEvent {
    private final LocationTimeZoneAlgorithmStatus mAlgorithmStatus;
    private ArrayList<String> mDebugInfo;
    private final GeolocationTimeZoneSuggestion mSuggestion;

    public LocationAlgorithmEvent(LocationTimeZoneAlgorithmStatus algorithmStatus, GeolocationTimeZoneSuggestion suggestion) {
        algorithmStatus.getClass();
        this.mAlgorithmStatus = algorithmStatus;
        this.mSuggestion = suggestion;
    }

    public LocationTimeZoneAlgorithmStatus getAlgorithmStatus() {
        return this.mAlgorithmStatus;
    }

    public GeolocationTimeZoneSuggestion getSuggestion() {
        return this.mSuggestion;
    }

    public List<String> getDebugInfo() {
        if (this.mDebugInfo != null) goto L6;
        return Collections.emptyList();
    L6:
        return Collections.unmodifiableList(this.mDebugInfo);
    }

    public void addDebugInfo(String... debugInfos) {
        if (this.mDebugInfo != null) goto L5;
        this.mDebugInfo = new ArrayList();
    L5:
        this.mDebugInfo.addAll(Arrays.asList(debugInfos));
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
        LocationAlgorithmEvent that = (LocationAlgorithmEvent) o;
        if (this.mAlgorithmStatus.equals(that.mAlgorithmStatus) == false) goto L16;
        if (Objects.equals(this.mSuggestion, that.mSuggestion) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mAlgorithmStatus, this.mSuggestion});
    }

    public String toString() {
        return "LocationAlgorithmEvent{mAlgorithmStatus=" + this.mAlgorithmStatus + ", mSuggestion=" + this.mSuggestion + ", mDebugInfo=" + this.mDebugInfo + '}';
    }

    static LocationAlgorithmEvent parseCommandLineArg(ShellCommand cmd) {
        String suggestionString = null;
        LocationTimeZoneAlgorithmStatus algorithmStatus = null;
    L3:
        String opt = cmd.getNextArg();
        if (opt == null) goto L21;
        switch(opt.hashCode()) {
            case -841922652: goto L12;
            case 1507532178: goto L9;
            default: goto L14;
        };
    L14:
        byte r2 = -1;
    L15:
        switch(r2) {
            case 0: goto L19;
            case 1: goto L18;
            default: goto L17;
        };
    L17:
        throw new IllegalArgumentException("Unknown option: " + opt);
    L19:
        algorithmStatus = LocationTimeZoneAlgorithmStatus.parseCommandlineArg(cmd.getNextArgRequired());
        goto L3
    L18:
        suggestionString = cmd.getNextArgRequired();
        goto L3
    L9:
        if (opt.equals("--status") == false) goto L14;
        r2 = 0;
        goto L15
    L12:
        if (opt.equals("--suggestion") == false) goto L14;
        r2 = 1;
        goto L15
    L21:
        if (algorithmStatus == null) goto L31;
        GeolocationTimeZoneSuggestion suggestion = null;
        if (suggestionString == null) goto L28;
        List<String> zoneIds = parseZoneIds(suggestionString);
        long elapsedRealtimeMillis = SystemClock.elapsedRealtime();
        if (zoneIds != null) goto L27;
        suggestion = GeolocationTimeZoneSuggestion.createUncertainSuggestion(elapsedRealtimeMillis);
        goto L28
    L27:
        suggestion = GeolocationTimeZoneSuggestion.createCertainSuggestion(elapsedRealtimeMillis, zoneIds);
    L28:
        LocationAlgorithmEvent event = new LocationAlgorithmEvent(algorithmStatus, suggestion);
        event.addDebugInfo(new String[]{"Command line injection"});
        return event;
    L31:
        throw new IllegalArgumentException("Missing --status");
    }

    private static List<String> parseZoneIds(String zoneIdsString) {
        if ("UNCERTAIN".equals(zoneIdsString) == false) goto L7;
        return null;
    L7:
        if ("EMPTY".equals(zoneIdsString) == true) goto L9;
        ArrayList<String> zoneIds = new ArrayList();
        StringTokenizer tokenizer = new StringTokenizer(zoneIdsString, ",");
    L12:
        if (tokenizer.hasMoreTokens() == false) goto L14;
        zoneIds.add(tokenizer.nextToken());
        goto L12
    L14:
        return zoneIds;
    L9:
        return Collections.emptyList();
    }

    static void printCommandLineOpts(PrintWriter pw) {
        pw.println("Location algorithm event options:");
        pw.println("  --status {LocationTimeZoneAlgorithmStatus toString() format}");
        pw.println("  [--suggestion {UNCERTAIN|EMPTY|<Olson ID>+}]");
        pw.println();
        pw.println("See " + LocationAlgorithmEvent.class.getName() + " for more information");
    }
}
