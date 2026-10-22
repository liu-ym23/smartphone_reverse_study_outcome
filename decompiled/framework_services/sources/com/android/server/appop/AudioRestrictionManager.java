package com.android.server.appop;

import android.app.AppOpsManager;
import android.media.AudioAttributes;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.android.server.input.KeyboardMetricsCollector;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class AudioRestrictionManager {
    static final SparseArray<SparseBooleanArray> CAMERA_AUDIO_RESTRICTIONS = null;
    static final String TAG = "AudioRestriction";
    int mCameraAudioRestriction;
    final SparseArray<SparseArray<Restriction>> mZenModeAudioRestrictions;

    private static final class Restriction {
        private static final ArraySet<String> NO_EXCEPTIONS = null;
        ArraySet<String> exceptionPackages;
        int mode;

        /* synthetic */ Restriction(AudioRestrictionManagerIA r1) {
            this();
        }

        private Restriction() {
            this.exceptionPackages = NO_EXCEPTIONS;
        }

        static {
            NO_EXCEPTIONS = new ArraySet();
        }
    }

    public AudioRestrictionManager() {
        this.mZenModeAudioRestrictions = new SparseArray();
        this.mCameraAudioRestriction = 0;
    }

    static {
        SparseBooleanArray audioMutedUsages = new SparseBooleanArray();
        SparseBooleanArray vibrationMutedUsages = new SparseBooleanArray();
        int[] r2 = AudioAttributes.SDK_USAGES.toArray();
        int r3 = r2.length;
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L20;
        int usage = r2[r4];
        int suppressionBehavior = AudioAttributes.SUPPRESSIBLE_USAGES.get(usage);
        if (suppressionBehavior != 1) goto L8;
    L18:
        audioMutedUsages.append(usage, true);
        vibrationMutedUsages.append(usage, true);
    L19:
        r4 = r4 + 1;
        goto L4
    L8:
        if (suppressionBehavior == 2) goto L18;
        if (suppressionBehavior == 4) goto L18;
        if (suppressionBehavior == 5) goto L19;
        if (suppressionBehavior == 6) goto L19;
        if (suppressionBehavior == 3) goto L19;
        Slog.e(TAG, "Unknown audio suppression behavior" + suppressionBehavior);
        goto L19
    L20:
        CAMERA_AUDIO_RESTRICTIONS = new SparseArray();
        CAMERA_AUDIO_RESTRICTIONS.append(28, audioMutedUsages);
        CAMERA_AUDIO_RESTRICTIONS.append(3, vibrationMutedUsages);
    }

    public int checkAudioOperation(int code, int usage, int uid, String packageName) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mCameraAudioRestriction != 0) goto L6;
    L21:
        int mode = checkZenModeRestrictionLocked(code, usage, uid, packageName);     // Catch: Throwable -> L12
        if (mode == 0) goto L26;
        monitor-exit(this);     // Catch: Throwable -> L12
        return mode;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L12
        return 0;
    L6:
        if (code == 3) goto L14;
        if (code != 28) goto L21;
        if (this.mCameraAudioRestriction != 3) goto L21;
    L14:
        SparseBooleanArray mutedUsages = CAMERA_AUDIO_RESTRICTIONS.get(code);     // Catch: Throwable -> L12
        if (mutedUsages == null) goto L21;
        if (mutedUsages.get(usage) == false) goto L21;
        monitor-exit(this);     // Catch: Throwable -> L12
        return 1;
    }

    private int checkZenModeRestrictionLocked(int code, int usage, int uid, String packageName) {
        SparseArray<Restriction> usageRestrictions = this.mZenModeAudioRestrictions.get(code);
        if (usageRestrictions == null) goto L10;
        Restriction r = usageRestrictions.get(usage);
        if (r != null) goto L7;
        return 0;
    L7:
        if (r.exceptionPackages.contains(packageName) == false) goto L9;
        return 0;
    L9:
        return r.mode;
    L10:
        return 0;
    }

    public void setZenModeAudioRestriction(int code, int usage, int uid, int mode, String[] exceptionPackages) {
        monitor-enter(this);
        SparseArray<Restriction> usageRestrictions = this.mZenModeAudioRestrictions.get(code);     // Catch: Throwable -> L6
        if (usageRestrictions != null) goto L8;
        usageRestrictions = new SparseArray();     // Catch: Throwable -> L6
        this.mZenModeAudioRestrictions.put(code, usageRestrictions);     // Catch: Throwable -> L6
    L8:
        usageRestrictions.remove(usage);     // Catch: Throwable -> L6
        if (mode == 0) goto L19;
        Restriction r = new Restriction(null);     // Catch: Throwable -> L6
        r.mode = mode;     // Catch: Throwable -> L6
        if (exceptionPackages == null) goto L18;
        int N = exceptionPackages.length;     // Catch: Throwable -> L6
        r.exceptionPackages = new ArraySet(N);     // Catch: Throwable -> L6
        int i = 0;
    L13:
        if (i >= N) goto L18;
        String pkg = exceptionPackages[i];     // Catch: Throwable -> L6
        if (pkg == null) goto L17;
        r.exceptionPackages.add(pkg.trim());     // Catch: Throwable -> L6
    L17:
        i = i + 1;     // Catch: Throwable -> L6
    L18:
        usageRestrictions.put(usage, r);     // Catch: Throwable -> L6
    L19:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setCameraAudioRestriction(int mode) {
        monitor-enter(this);
        this.mCameraAudioRestriction = mode;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean hasActiveRestrictions() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mZenModeAudioRestrictions.size() > 0) goto L12;
        if (this.mCameraAudioRestriction != 0) goto L12;
        boolean r1 = false;
    L13:
        boolean hasActiveRestrictions = r1;
        monitor-exit(this);     // Catch: Throwable -> L10
        return hasActiveRestrictions;
    L12:
        r1 = true;
        goto L13
    }

    public boolean dump(PrintWriter pw) {
        boolean printedHeader = false;
        boolean needSep = hasActiveRestrictions();
        monitor-enter(this);
        int o = 0;
    L29:
    L12:
        th = move-exception;
        throw th;
    L6:
        if (o >= this.mZenModeAudioRestrictions.size()) goto L22;
        String op = AppOpsManager.opToName(this.mZenModeAudioRestrictions.keyAt(o));     // Catch: Throwable -> L12
        SparseArray<Restriction> restrictions = this.mZenModeAudioRestrictions.valueAt(o);     // Catch: Throwable -> L12
        int i = 0;
    L9:
        if (i >= restrictions.size()) goto L21;
        if (printedHeader == true) goto L14;
        pw.println("  Zen Mode Audio Restrictions:");     // Catch: Throwable -> L12
        printedHeader = true;
    L14:
        int usage = restrictions.keyAt(i);     // Catch: Throwable -> L12
        pw.print("    ");     // Catch: Throwable -> L12
        pw.print(op);     // Catch: Throwable -> L12
        pw.print(" usage=");     // Catch: Throwable -> L12
        pw.print(AudioAttributes.usageToString(usage));     // Catch: Throwable -> L12
        Restriction r = restrictions.valueAt(i);     // Catch: Throwable -> L12
        pw.print(": mode=");     // Catch: Throwable -> L12
        pw.println(AppOpsManager.modeToName(r.mode));     // Catch: Throwable -> L12
        if (r.exceptionPackages.isEmpty() == true) goto L20;
        pw.println("      Exceptions:");     // Catch: Throwable -> L12
        int j = 0;
    L18:
        if (j >= r.exceptionPackages.size()) goto L20;
        pw.print("        ");     // Catch: Throwable -> L12
        pw.println(r.exceptionPackages.valueAt(j));     // Catch: Throwable -> L12
        j = j + 1;     // Catch: Throwable -> L12
    L20:
        i = i + 1;     // Catch: Throwable -> L12
        goto L9
    L21:
        o = o + 1;     // Catch: Throwable -> L12
        goto L29
    L22:
        int o2 = this.mCameraAudioRestriction;     // Catch: Throwable -> L12
        if (o2 == 0) goto L25;
        pw.println("  Camera Audio Restriction Mode: " + cameraRestrictionModeToName(this.mCameraAudioRestriction));     // Catch: Throwable -> L12
    L25:
        monitor-exit(this);     // Catch: Throwable -> L12
        return needSep;
    }

    private static String cameraRestrictionModeToName(int mode) {
        switch(mode) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L3;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "MuteVibrationAndSound";
    L7:
        return "MuteVibration";
    L9:
        return KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG;
    }
}
