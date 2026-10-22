package com.android.server.audio;

import android.content.Context;
import android.hardware.tv.mediaquality.ParameterName;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceVolumeManager;
import android.media.AudioManager;
import android.media.VolumeInfo;
import android.os.ShellCommand;
import com.android.server.utils.PriorityDump;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
class AudioManagerShellCommand extends ShellCommand {
    private static final String TAG = "AudioManagerShellCommand";
    private final AudioService mService;

    AudioManagerShellCommand(AudioService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        getOutPrintWriter();
        switch(cmd.hashCode()) {
            case -1934803544: goto L63;
            case -1873164504: goto L60;
            case -1741904872: goto L57;
            case -1712382208: goto L54;
            case -1585209734: goto L51;
            case -1460727410: goto L48;
            case -1340000401: goto L45;
            case -1313475149: goto L42;
            case -1284832304: goto L39;
            case -1110422657: goto L36;
            case -460075795: goto L33;
            case 478371910: goto L30;
            case 865963338: goto L27;
            case 886789580: goto L24;
            case 937504014: goto L21;
            case 1476886742: goto L18;
            case 1578511132: goto L15;
            case 1781088997: goto L12;
            case 1837696227: goto L9;
            default: goto L65;
        };
    L65:
        byte r1 = -1;
    L66:
        switch(r1) {
            case 0: goto L105;
            case 1: goto L103;
            case 2: goto L101;
            case 3: goto L99;
            case 4: goto L97;
            case 5: goto L95;
            case 6: goto L93;
            case 7: goto L91;
            case 8: goto L89;
            case 9: goto L87;
            case 10: goto L85;
            case 11: goto L83;
            case 12: goto L81;
            case 13: goto L79;
            case 14: goto L77;
            case 15: goto L75;
            case 16: goto L73;
            case 17: goto L71;
            case 18: goto L69;
            default: goto L67;
        };
    L67:
        return 0;
    L69:
        return setEnableHardening();
    L71:
        return adjGroupVolume();
    L73:
        return setGroupVolume();
    L75:
        return adjVolume();
    L77:
        return adjUnmute();
    L79:
        return adjMute();
    L81:
        return setDeviceVolume();
    L83:
        return getStreamVolume();
    L85:
        return getMaxVolume();
    L87:
        return getMinVolume();
    L89:
        return setVolume();
    L91:
        return setRingerMode();
    L93:
        return resetSoundDoseTimeout();
    L95:
        return getSoundDoseValue();
    L97:
        return setSoundDoseValue();
    L99:
        return getEncodedSurroundMode();
    L101:
        return setEncodedSurroundMode();
    L103:
        return getIsSurroundFormatEnabled();
    L105:
        return setSurroundFormatEnabled();
    L9:
        if (cmd.equals("set-hardening") == false) goto L65;
        r1 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L66
    L12:
        if (cmd.equals("set-volume") == false) goto L65;
        r1 = 8;
        goto L66
    L15:
        if (cmd.equals("get-encoded-surround-mode") == false) goto L65;
        r1 = 3;
        goto L66
    L18:
        if (cmd.equals("get-sound-dose-value") == false) goto L65;
        r1 = 5;
        goto L66
    L21:
        if (cmd.equals("get-is-surround-format-enabled") == false) goto L65;
        r1 = 1;
        goto L66
    L24:
        if (cmd.equals("get-min-volume") == false) goto L65;
        r1 = 9;
        goto L66
    L27:
        if (cmd.equals("set-sound-dose-value") == false) goto L65;
        r1 = 4;
        goto L66
    L30:
        if (cmd.equals("set-device-volume") == false) goto L65;
        r1 = 12;
        goto L66
    L33:
        if (cmd.equals("reset-sound-dose-timeout") == false) goto L65;
        r1 = 6;
        goto L66
    L36:
        if (cmd.equals("adj-mute") == false) goto L65;
        r1 = 13;
        goto L66
    L39:
        if (cmd.equals("get-stream-volume") == false) goto L65;
        r1 = 11;
        goto L66
    L42:
        if (cmd.equals("set-group-volume") == false) goto L65;
        r1 = 16;
        goto L66
    L45:
        if (cmd.equals("set-surround-format-enabled") == false) goto L65;
        r1 = 0;
        goto L66
    L48:
        if (cmd.equals("adj-group-volume") == false) goto L65;
        r1 = ParameterName.DE_CONTOUR;
        goto L66
    L51:
        if (cmd.equals("get-max-volume") == false) goto L65;
        r1 = 10;
        goto L66
    L54:
        if (cmd.equals("adj-volume") == false) goto L65;
        r1 = 15;
        goto L66
    L57:
        if (cmd.equals("adj-unmute") == false) goto L65;
        r1 = 14;
        goto L66
    L60:
        if (cmd.equals("set-encoded-surround-mode") == false) goto L65;
        r1 = 2;
        goto L66
    L63:
        if (cmd.equals("set-ringer-mode") == false) goto L65;
        r1 = 7;
        goto L66
    L4:
        return handleDefaultCommands(cmd);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Audio manager commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println();
        pw.println("  set-surround-format-enabled SURROUND_FORMAT IS_ENABLED");
        pw.println("    Enables/disabled the SURROUND_FORMAT based on IS_ENABLED");
        pw.println("  get-is-surround-format-enabled SURROUND_FORMAT");
        pw.println("    Returns if the SURROUND_FORMAT is enabled");
        pw.println("  set-encoded-surround-mode SURROUND_SOUND_MODE");
        pw.println("    Sets the encoded surround sound mode to SURROUND_SOUND_MODE");
        pw.println("  get-encoded-surround-mode");
        pw.println("    Returns the encoded surround sound mode");
        pw.println("  set-sound-dose-value");
        pw.println("    Sets the current sound dose value");
        pw.println("  get-sound-dose-value");
        pw.println("    Returns the current sound dose value");
        pw.println("  reset-sound-dose-timeout");
        pw.println("    Resets the sound dose timeout used for momentary exposure");
        pw.println("  set-ringer-mode NORMAL|SILENT|VIBRATE");
        pw.println("    Sets the Ringer mode to one of NORMAL|SILENT|VIBRATE");
        pw.println("  set-volume STREAM_TYPE VOLUME_INDEX");
        pw.println("    Sets the volume for STREAM_TYPE to VOLUME_INDEX");
        pw.println("  get-min-volume STREAM_TYPE");
        pw.println("    Gets the min volume for STREAM_TYPE");
        pw.println("  get-max-volume STREAM_TYPE");
        pw.println("    Gets the max volume for STREAM_TYPE");
        pw.println("  get-stream-volume STREAM_TYPE");
        pw.println("    Gets the volume for STREAM_TYPE");
        pw.println("  set-device-volume STREAM_TYPE VOLUME_INDEX NATIVE_DEVICE_TYPE");
        pw.println("    Sets for NATIVE_DEVICE_TYPE the STREAM_TYPE volume to VOLUME_INDEX");
        pw.println("  adj-mute STREAM_TYPE");
        pw.println("    mutes the STREAM_TYPE");
        pw.println("  adj-unmute STREAM_TYPE");
        pw.println("    unmutes the STREAM_TYPE");
        pw.println("  adj-volume STREAM_TYPE <RAISE|LOWER|MUTE|UNMUTE>");
        pw.println("    Adjusts the STREAM_TYPE volume given the specified direction");
        pw.println("  set-group-volume GROUP_ID VOLUME_INDEX");
        pw.println("    Sets the volume for GROUP_ID to VOLUME_INDEX");
        pw.println("  adj-group-volume GROUP_ID <RAISE|LOWER|MUTE|UNMUTE>");
        pw.println("    Adjusts the group volume for GROUP_ID given the specified direction");
        pw.println("  set-enable-hardening <1|0>");
        pw.println("    Enables full audio hardening enforcement, disabling any exemptions");
    }

    private int setSurroundFormatEnabled() {
        String surroundFormatText = getNextArg();
        String isSurroundFormatEnabledText = getNextArg();
        if (surroundFormatText != null) goto L6;
        getErrPrintWriter().println("Error: no surroundFormat specified");
        return 1;
    L6:
        if (isSurroundFormatEnabledText != null) goto L19;
        getErrPrintWriter().println("Error: no enabled value for surroundFormat specified");
        return 1;
    L19:
        int surroundFormat = Integer.parseInt(surroundFormatText);     // Catch: NumberFormatException -> L16
        boolean isSurroundFormatEnabled = Boolean.parseBoolean(isSurroundFormatEnabledText);     // Catch: NumberFormatException -> L16
        if (surroundFormat >= 0) goto L14;
        getErrPrintWriter().println("Error: invalid value of surroundFormat");
        return 1;
    L14:
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        am.setSurroundFormatEnabled(surroundFormat, isSurroundFormatEnabled);
        return 0;
    L17:
        getErrPrintWriter().println("Error: wrong format specified for surroundFormat");
        return 1;
    }

    private int setRingerMode() {
        String ringerModeText = getNextArg();
        if (ringerModeText != null) goto L6;
        getErrPrintWriter().println("Error: no ringer mode specified");
        return 1;
    L6:
        int ringerMode = getRingerMode(ringerModeText);
        if (AudioManager.isValidRingerMode(ringerMode) == true) goto L10;
        getErrPrintWriter().println("Error: invalid value of ringerMode, should be one of NORMAL|SILENT|VIBRATE");
        return 1;
    L10:
        AudioManager am = (AudioManager) this.mService.mContext.getSystemService(AudioManager.class);
        am.setRingerModeInternal(ringerMode);
        return 0;
    }

    private int getRingerMode(String ringerModeText) {
        switch(ringerModeText.hashCode()) {
            case -1986416409: goto L12;
            case -1848997803: goto L9;
            case 1169293647: goto L6;
            default: goto L14;
        };
    L14:
        byte r0 = -1;
    L15:
        switch(r0) {
            case 0: goto L20;
            case 1: goto L25;
            case 2: goto L26;
            default: goto L24;
        };
    L26:
        return 0;
    L24:
        return -1;
    L25:
        return 1;
    L20:
        return 2;
    L6:
        if (ringerModeText.equals("VIBRATE") == false) goto L21;
        r0 = 1;
        goto L15
    L21:
        r0 = -1;
        goto L15
    L9:
        if (ringerModeText.equals("SILENT") == false) goto L22;
        r0 = 2;
        goto L15
    L22:
        r0 = -1;
        goto L15
    L12:
        if (ringerModeText.equals(PriorityDump.PRIORITY_ARG_NORMAL) == false) goto L23;
        r0 = 0;
        goto L15
    L23:
        r0 = -1;
        goto L15
    }

    private int getIsSurroundFormatEnabled() {
        String surroundFormatText = getNextArg();
        if (surroundFormatText != null) goto L16;
        getErrPrintWriter().println("Error: no surroundFormat specified");
        return 1;
    L16:
        int surroundFormat = Integer.parseInt(surroundFormatText);     // Catch: NumberFormatException -> L13
        if (surroundFormat >= 0) goto L11;
        getErrPrintWriter().println("Error: invalid value of surroundFormat");
        return 1;
    L11:
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        getOutPrintWriter().println("Value of enabled for " + surroundFormat + " is: " + am.isSurroundFormatEnabled(surroundFormat));
        return 0;
    L14:
        getErrPrintWriter().println("Error: wrong format specified for surroundFormat");
        return 1;
    }

    private int setEncodedSurroundMode() {
        String encodedSurroundModeText = getNextArg();
        if (encodedSurroundModeText != null) goto L16;
        getErrPrintWriter().println("Error: no encodedSurroundMode specified");
        return 1;
    L16:
        int encodedSurroundMode = Integer.parseInt(encodedSurroundModeText);     // Catch: NumberFormatException -> L13
        if (encodedSurroundMode >= 0) goto L11;
        getErrPrintWriter().println("Error: invalid value of encodedSurroundMode");
        return 1;
    L11:
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        am.setEncodedSurroundMode(encodedSurroundMode);
        return 0;
    L14:
        getErrPrintWriter().println("Error: wrong format specified for encoded surround mode");
        return 1;
    }

    private int getEncodedSurroundMode() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        getOutPrintWriter().println("Encoded surround mode: " + am.getEncodedSurroundMode());
        return 0;
    }

    private int setSoundDoseValue() {
        String soundDoseValueText = getNextArg();
        if (soundDoseValueText != null) goto L17;
        getErrPrintWriter().println("Error: no sound dose value specified");
        return 1;
    L17:
        float soundDoseValue = Float.parseFloat(soundDoseValueText);     // Catch: NumberFormatException -> L14
        if (soundDoseValue >= 0.0f) goto L12;
        getErrPrintWriter().println("Error: invalid value of sound dose");
        return 1;
    L12:
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        am.setCsd(soundDoseValue);
        return 0;
    L15:
        getErrPrintWriter().println("Error: wrong format specified for sound dose");
        return 1;
    }

    private int getSoundDoseValue() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        getOutPrintWriter().println("Sound dose value: " + am.getCsd());
        return 0;
    }

    private int resetSoundDoseTimeout() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        am.setCsd(-1.0f);
        getOutPrintWriter().println("Reset sound dose momentary exposure timeout");
        return 0;
    }

    private int setVolume() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        int stream = readIntArg();
        int index = readIntArg();
        getOutPrintWriter().println("calling AudioManager.setStreamVolume(" + stream + ", " + index + ", 0)");
        am.setStreamVolume(stream, index, 0);
        return 0;
    }

    private int getMinVolume() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        int stream = readIntArg();
        int result = am.getStreamMinVolume(stream);
        getOutPrintWriter().println("AudioManager.getStreamMinVolume(" + stream + ") -> " + result);
        return 0;
    }

    private int getMaxVolume() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        int stream = readIntArg();
        int result = am.getStreamMaxVolume(stream);
        getOutPrintWriter().println("AudioManager.getStreamMaxVolume(" + stream + ") -> " + result);
        return 0;
    }

    private int getStreamVolume() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        int stream = readIntArg();
        int result = am.getStreamVolume(stream);
        getOutPrintWriter().println("AudioManager.getStreamVolume(" + stream + ") -> " + result);
        return 0;
    }

    private int setDeviceVolume() {
        Context context = this.mService.mContext;
        AudioDeviceVolumeManager advm = (AudioDeviceVolumeManager) context.getSystemService("audio_device_volume");
        int stream = readIntArg();
        int index = readIntArg();
        int device = readIntArg();
        VolumeInfo volume = new VolumeInfo.Builder(stream).setVolumeIndex(index).build();
        AudioDeviceAttributes ada = new AudioDeviceAttributes(device, "foo");
        getOutPrintWriter().println("calling AudioDeviceVolumeManager.setDeviceVolume(" + volume + ", " + ada + ")");
        advm.setDeviceVolume(volume, ada);
        return 0;
    }

    private int adjMute() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        int stream = readIntArg();
        getOutPrintWriter().println("calling AudioManager.adjustStreamVolume(" + stream + ", AudioManager.ADJUST_MUTE, 0)");
        am.adjustStreamVolume(stream, -100, 0);
        return 0;
    }

    private int adjUnmute() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        int stream = readIntArg();
        getOutPrintWriter().println("calling AudioManager.adjustStreamVolume(" + stream + ", AudioManager.ADJUST_UNMUTE, 0)");
        am.adjustStreamVolume(stream, 100, 0);
        return 0;
    }

    private int adjVolume() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        int stream = readIntArg();
        int direction = readDirectionArg();
        getOutPrintWriter().println("calling AudioManager.adjustStreamVolume(" + stream + ", " + direction + ", 0)");
        am.adjustStreamVolume(stream, direction, 0);
        return 0;
    }

    private int setGroupVolume() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        int groupId = readIntArg();
        int index = readIntArg();
        getOutPrintWriter().println("calling AudioManager.setVolumeGroupVolumeIndex(" + groupId + ", " + index + ", 0)");
        am.setVolumeGroupVolumeIndex(groupId, index, 0);
        return 0;
    }

    private int adjGroupVolume() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        int groupId = readIntArg();
        int direction = readDirectionArg();
        getOutPrintWriter().println("calling AudioManager.adjustVolumeGroupVolume(" + groupId + ", " + direction + ", 0)");
        am.adjustVolumeGroupVolume(groupId, direction, 0);
        return 0;
    }

    private int setEnableHardening() {
        Context context = this.mService.mContext;
        AudioManager am = (AudioManager) context.getSystemService(AudioManager.class);
        if (readIntArg() == 0) goto L5;
        boolean shouldEnable = true;
    L6:
        getOutPrintWriter().println("calling AudioManager.setEnableHardening(" + shouldEnable + ")");
        am.setEnableHardening(shouldEnable);     // Catch: Exception -> L9
    L11:
        return 0;
    L9:
        e = move-exception;
        getOutPrintWriter().println("Exception: " + e);
        goto L11
    L5:
        shouldEnable = false;
        goto L6
    }

    private int readIntArg() throws IllegalArgumentException {
        String argText = getNextArg();
        if (argText != null) goto L11;
        getErrPrintWriter().println("Error: no argument provided");
        throw new IllegalArgumentException("No argument provided");
    L11:
        int argIntVal = Integer.parseInt(argText);     // Catch: NumberFormatException -> L6
        return argIntVal;
    L7:
        getErrPrintWriter().println("Error: wrong format for argument " + argText);
        throw new IllegalArgumentException("Wrong format for argument " + argText);
    }

    private int readDirectionArg() throws IllegalArgumentException {
        String argText = getNextArg();
        if (argText != null) goto L5;
        getErrPrintWriter().println("Error: no argument provided");
        throw new IllegalArgumentException("No argument provided");
    L5:
        switch(argText.hashCode()) {
            case -1787076558: goto L17;
            case 2378265: goto L14;
            case 72626913: goto L11;
            case 77737932: goto L8;
            default: goto L19;
        };
    L19:
        byte r1 = -1;
    L20:
        switch(r1) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L24;
            case 3: goto L23;
            default: goto L22;
        };
    L23:
        return 100;
    L24:
        return -100;
    L36:
        return 1;
    L22:
        throw new IllegalArgumentException("Wrong direction argument: " + argText);
    L35:
        return -1;
    L8:
        if (argText.equals("RAISE") == false) goto L30;
        r1 = 0;
        goto L20
    L30:
        r1 = -1;
        goto L20
    L11:
        if (argText.equals("LOWER") == false) goto L31;
        r1 = 1;
        goto L20
    L31:
        r1 = -1;
        goto L20
    L14:
        if (argText.equals("MUTE") == false) goto L32;
        r1 = 2;
        goto L20
    L32:
        r1 = -1;
        goto L20
    L17:
        if (argText.equals("UNMUTE") == false) goto L33;
        r1 = 3;
        goto L20
    L33:
        r1 = -1;
        goto L20
    }
}
