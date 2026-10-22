package com.android.server.timedetector;

import android.app.time.UnixEpochTime;
import android.os.ShellCommand;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class NetworkTimeSuggestion {
    private ArrayList<String> mDebugInfo;
    private final int mUncertaintyMillis;
    private final UnixEpochTime mUnixEpochTime;

    public NetworkTimeSuggestion(UnixEpochTime unixEpochTime, int uncertaintyMillis) {
        unixEpochTime.getClass();
        this.mUnixEpochTime = unixEpochTime;
        if (uncertaintyMillis < 0) goto L7;
        this.mUncertaintyMillis = uncertaintyMillis;
        return;
    L7:
        throw new IllegalArgumentException("uncertaintyMillis < 0");
    }

    public UnixEpochTime getUnixEpochTime() {
        return this.mUnixEpochTime;
    }

    public int getUncertaintyMillis() {
        return this.mUncertaintyMillis;
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
        if ((o instanceof NetworkTimeSuggestion) == true) goto L8;
        return false;
    L8:
        NetworkTimeSuggestion that = (NetworkTimeSuggestion) o;
        if (this.mUnixEpochTime.equals(that.mUnixEpochTime) == false) goto L14;
        if (this.mUncertaintyMillis != that.mUncertaintyMillis) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mUnixEpochTime, Integer.valueOf(this.mUncertaintyMillis)});
    }

    public String toString() {
        return "NetworkTimeSuggestion{mUnixEpochTime=" + this.mUnixEpochTime + ", mUncertaintyMillis=" + this.mUncertaintyMillis + ", mDebugInfo=" + this.mDebugInfo + '}';
    }

    public static NetworkTimeSuggestion parseCommandLineArg(ShellCommand cmd) throws IllegalArgumentException {
        Long elapsedRealtimeMillis = null;
        Long unixEpochTimeMillis = null;
        Integer uncertaintyMillis = null;
    L3:
        String opt = cmd.getNextArg();
        if (opt == null) goto L28;
        switch(opt.hashCode()) {
            case 16142561: goto L18;
            case 48316014: goto L15;
            case 410278458: goto L12;
            case 1387445527: goto L9;
            default: goto L20;
        };
    L20:
        byte r3 = -1;
    L21:
        switch(r3) {
            case 0: goto L26;
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            default: goto L23;
        };
    L23:
        throw new IllegalArgumentException("Unknown option: " + opt);
    L25:
        unixEpochTimeMillis = Long.valueOf(Long.parseLong(cmd.getNextArgRequired()));
        goto L3
    L26:
        elapsedRealtimeMillis = Long.valueOf(Long.parseLong(cmd.getNextArgRequired()));
        goto L3
    L24:
        uncertaintyMillis = Integer.valueOf(Integer.parseInt(cmd.getNextArgRequired()));
        goto L3
    L9:
        if (opt.equals("--uncertainty_millis") == false) goto L20;
        r3 = 3;
        goto L21
    L12:
        if (opt.equals("--unix_epoch_time") == false) goto L20;
        r3 = 2;
        goto L21
    L15:
        if (opt.equals("--elapsed_realtime") == false) goto L20;
        r3 = 1;
        goto L21
    L18:
        if (opt.equals("--reference_time") == false) goto L20;
        r3 = 0;
        goto L21
    L28:
        if (elapsedRealtimeMillis == null) goto L38;
        if (unixEpochTimeMillis == null) goto L36;
        if (uncertaintyMillis == null) goto L34;
        UnixEpochTime timeSignal = new UnixEpochTime(elapsedRealtimeMillis.longValue(), unixEpochTimeMillis.longValue());
        NetworkTimeSuggestion networkTimeSuggestion = new NetworkTimeSuggestion(timeSignal, uncertaintyMillis.intValue());
        networkTimeSuggestion.addDebugInfo(new String[]{"Command line injection"});
        return networkTimeSuggestion;
    L34:
        throw new IllegalArgumentException("No uncertaintyMillis specified.");
    L36:
        throw new IllegalArgumentException("No unixEpochTimeMillis specified.");
    L38:
        throw new IllegalArgumentException("No elapsedRealtimeMillis specified.");
    }

    public static void printCommandLineOpts(PrintWriter pw) {
        pw.printf("%s suggestion options:\n", new Object[]{"Network"});
        pw.println("  --elapsed_realtime <elapsed realtime millis> - the elapsed realtime millis when unix epoch time was read");
        pw.println("  --unix_epoch_time <Unix epoch time millis>");
        pw.println("  --uncertainty_millis <Uncertainty millis> - a positive error bound (+/-) estimate for unix epoch time");
        pw.println();
        pw.println("See " + NetworkTimeSuggestion.class.getName() + " for more information");
    }
}
