package com.android.server.timedetector;

import android.app.time.UnixEpochTime;
import android.app.timedetector.TimeSuggestionHelper;
import android.os.ShellCommand;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class GnssTimeSuggestion {
    private final TimeSuggestionHelper mTimeSuggestionHelper;

    public GnssTimeSuggestion(UnixEpochTime unixEpochTime) {
        this.mTimeSuggestionHelper = new TimeSuggestionHelper(GnssTimeSuggestion.class, unixEpochTime);
    }

    private GnssTimeSuggestion(TimeSuggestionHelper helper) {
        helper.getClass();
        this.mTimeSuggestionHelper = helper;
    }

    public UnixEpochTime getUnixEpochTime() {
        return this.mTimeSuggestionHelper.getUnixEpochTime();
    }

    public List<String> getDebugInfo() {
        return this.mTimeSuggestionHelper.getDebugInfo();
    }

    public void addDebugInfo(String... debugInfos) {
        this.mTimeSuggestionHelper.addDebugInfo(debugInfos);
    }

    public boolean equals(Object o) {
        if (this != o) goto L5;
        return true;
    L5:
        if (o != null) goto L7;
        return false;
    L7:
        if (getClass() != o.getClass()) goto L13;
        GnssTimeSuggestion that = (GnssTimeSuggestion) o;
        return this.mTimeSuggestionHelper.handleEquals(that.mTimeSuggestionHelper);
    L13:
        return false;
    }

    public int hashCode() {
        return this.mTimeSuggestionHelper.hashCode();
    }

    public String toString() {
        return this.mTimeSuggestionHelper.handleToString();
    }

    public static GnssTimeSuggestion parseCommandLineArg(ShellCommand cmd) throws IllegalArgumentException {
        TimeSuggestionHelper suggestionHelper = TimeSuggestionHelper.handleParseCommandLineArg(GnssTimeSuggestion.class, cmd);
        return new GnssTimeSuggestion(suggestionHelper);
    }

    public static void printCommandLineOpts(PrintWriter pw) {
        TimeSuggestionHelper.handlePrintCommandLineOpts(pw, "GNSS", GnssTimeSuggestion.class);
    }
}
