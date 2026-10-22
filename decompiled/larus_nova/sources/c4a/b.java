package c4a;

import android.app.Activity;
import android.media.AudioManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {
    public static final String a(AudioManager r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.getMode();
        if (r101 != 0) goto L5;
        return "MODE_NORMAL";
    L5:
        if (r101 != 1) goto L7;
        return "MODE_RINGTONE";
    L7:
        if (r101 != 2) goto L9;
        return "MODE_IN_CALL";
    L9:
        if (r101 != 3) goto L11;
        return "MODE_IN_COMMUNICATION";
    L11:
        if (r101 != 4) goto L19;
        return "MODE_CALL_SCREENING";
    L19:
        return "UNKNOWN_MODE (" + r101 + ')';
    }

    public static final String b(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.getVolumeControlStream();
        if (r101 != 0) goto L5;
        return "STREAM_VOICE_CALL";
    L5:
        if (r101 != 1) goto L7;
        return "STREAM_SYSTEM";
    L7:
        if (r101 != 2) goto L9;
        return "STREAM_RING";
    L9:
        if (r101 != 3) goto L11;
        return "STREAM_MUSIC";
    L11:
        if (r101 != 4) goto L13;
        return "STREAM_ALARM";
    L13:
        if (r101 != 5) goto L15;
        return "STREAM_NOTIFICATION";
    L15:
        if (r101 != 8) goto L17;
        return "STREAM_DTMF";
    L17:
        if (r101 != 10) goto L28;
        return "STREAM_ACCESSIBILITY";
    L28:
        return "UNKNOWN_STREAM (" + r101 + ')';
    }
}
