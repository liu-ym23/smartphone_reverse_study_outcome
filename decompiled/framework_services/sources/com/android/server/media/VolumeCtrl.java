package com.android.server.media;

import android.media.AudioSystem;
import android.media.IAudioService;
import android.os.ServiceManager;
import android.util.AndroidException;

/* JADX INFO: loaded from: classes2.dex */
public class VolumeCtrl {
    private static final String ADJUST_LOWER = "lower";
    private static final String ADJUST_RAISE = "raise";
    private static final String ADJUST_SAME = "same";
    private static final String LOG_E = "[E]";
    private static final String LOG_V = "[V]";
    private static final String TAG = "VolumeCtrl";
    public static final String USAGE = null;
    private static final int VOLUME_CONTROL_MODE_ADJUST = 2;
    private static final int VOLUME_CONTROL_MODE_SET = 1;

    public VolumeCtrl() {
    }

    static {
        USAGE = new String("the options are as follows: \n\t\t--stream STREAM selects the stream to control, see AudioManager.STREAM_*\n\t\t                controls AudioManager.STREAM_MUSIC if no stream is specified\n\t\t--set INDEX     sets the volume index value\n\t\t--adj DIRECTION adjusts the volume, use raise|same|lower for the direction\n\t\t--get           outputs the current volume\n\t\t--show          shows the UI during the volume change\n\texamples:\n\t\tadb shell media volume --show --stream 3 --set 11\n\t\tadb shell media volume --stream 0 --adj lower\n\t\tadb shell media volume --stream 3 --get\n");
    }

    public static void run(MediaShellCommand cmd) throws Exception {
        int stream = 3;
        int volIndex = 5;
        int mode = 0;
        int adjDir = 1;
        int r5 = 0;
        boolean doGet = false;
        String adjustment = null;
    L3:
        String option = cmd.getNextOption();
        if (option == null) goto L33;
        switch(option.hashCode()) {
            case 42995463: goto L21;
            case 43001270: goto L18;
            case 43012802: goto L15;
            case 1333399709: goto L12;
            case 1508023584: goto L9;
            default: goto L23;
        };
    L23:
        byte r10 = -1;
    L24:
        switch(r10) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            default: goto L26;
        };
    L26:
        throw new IllegalArgumentException("Unknown argument " + option);
    L28:
        volIndex = Integer.decode(cmd.getNextArgRequired()).intValue();
        mode = 1;
        cmd.log(LOG_V, "will set volume to index=" + volIndex);
        goto L3
    L29:
        stream = Integer.decode(cmd.getNextArgRequired()).intValue();
        cmd.log(LOG_V, "will control stream=" + stream + " (" + streamName(stream) + ")");
        goto L3
    L30:
        doGet = true;
        cmd.log(LOG_V, "will get volume");
        goto L3
    L31:
        r5 = 1;
        goto L3
    L27:
        mode = 2;
        adjustment = cmd.getNextArgRequired();
        cmd.log(LOG_V, "will adjust volume");
        goto L3
    L9:
        if (option.equals("--stream") == false) goto L23;
        r10 = 2;
        goto L24
    L12:
        if (option.equals("--show") == false) goto L23;
        r10 = 0;
        goto L24
    L15:
        if (option.equals("--set") == false) goto L23;
        r10 = 3;
        goto L24
    L18:
        if (option.equals("--get") == false) goto L23;
        r10 = 1;
        goto L24
    L21:
        if (option.equals("--adj") == false) goto L23;
        r10 = 4;
        goto L24
    L33:
        if (mode != 2) goto L56;
        if (adjustment != null) goto L38;
        cmd.showError("Error: no valid volume adjustment (null)");
        return;
    L38:
        switch(adjustment.hashCode()) {
            case 3522662: goto L47;
            case 103164673: goto L44;
            case 108275692: goto L41;
            default: goto L49;
        };
    L49:
        byte r16 = -1;
    L50:
        switch(r16) {
            case 0: goto L55;
            case 1: goto L54;
            case 2: goto L53;
            default: goto L51;
        };
    L51:
        cmd.showError("Error: no valid volume adjustment, was " + adjustment + ", expected " + ADJUST_LOWER + "|" + ADJUST_SAME + "|" + ADJUST_RAISE);
        return;
    L53:
        adjDir = -1;
        goto L56
    L54:
        adjDir = 0;
        goto L56
    L55:
        adjDir = 1;
        goto L56
    L41:
        if (adjustment.equals(ADJUST_RAISE) == false) goto L49;
        r16 = 0;
        goto L50
    L44:
        if (adjustment.equals(ADJUST_LOWER) == false) goto L49;
        r16 = 2;
        goto L50
    L47:
        if (adjustment.equals(ADJUST_SAME) == false) goto L49;
        r16 = 1;
    L56:
        cmd.log(LOG_V, "Connecting to AudioService");
        IAudioService audioService = IAudioService.Stub.asInterface(ServiceManager.checkService("audio"));
        if (audioService == null) goto L74;
        if (mode == 1) goto L60;
    L66:
        int flag = r5;
        String pack = cmd.getClass().getPackage().getName();
        if (mode != 1) goto L69;
        audioService.setStreamVolume(stream, volIndex, flag, pack);
    L71:
        if (doGet == false) goto L89;
        cmd.log(LOG_V, "volume is " + audioService.getStreamVolume(stream) + " in range [" + audioService.getStreamMinVolume(stream) + ".." + audioService.getStreamMaxVolume(stream) + "]");
        return;
    L89:
        return;
    L69:
        if (mode != 2) goto L71;
        audioService.adjustStreamVolume(stream, adjDir, flag, pack);
        goto L71
    L60:
        if (volIndex <= audioService.getStreamMaxVolume(stream)) goto L62;
    L64:
        cmd.showError(String.format("Error: invalid volume index %d for stream %d (should be in [%d..%d])", new Object[]{Integer.valueOf(volIndex), Integer.valueOf(stream), Integer.valueOf(audioService.getStreamMinVolume(stream)), Integer.valueOf(audioService.getStreamMaxVolume(stream))}));
        return;
    L62:
        if (volIndex >= audioService.getStreamMinVolume(stream)) goto L66;
    L74:
        cmd.log(LOG_E, "Error type 2");
        throw new AndroidException("Can't connect to audio service; is the system running?");
    }

    static String streamName(int stream) {
        return AudioSystem.STREAM_NAMES[stream];
    L5:
        return "invalid stream";
    }
}
