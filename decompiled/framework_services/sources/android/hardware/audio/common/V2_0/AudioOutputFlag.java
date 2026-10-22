package android.hardware.audio.common.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AudioOutputFlag {
    public static final int COMPRESS_OFFLOAD = 16;
    public static final int DEEP_BUFFER = 8;
    public static final int DIRECT = 1;
    public static final int DIRECT_PCM = 8192;
    public static final int FAST = 4;
    public static final int HW_AV_SYNC = 64;
    public static final int IEC958_NONAUDIO = 1024;
    public static final int MMAP_NOIRQ = 16384;
    public static final int NONE = 0;
    public static final int NON_BLOCKING = 32;
    public static final int PRIMARY = 2;
    public static final int RAW = 256;
    public static final int SYNC = 512;
    public static final int TTS = 128;
    public static final int VOIP_RX = 32768;

    public AudioOutputFlag() {
    }

    public static final String toString(int o) {
        if (o != 0) goto L6;
        return "NONE";
    L6:
        if (o != 1) goto L10;
        return "DIRECT";
    L10:
        if (o != 2) goto L14;
        return "PRIMARY";
    L14:
        if (o != 4) goto L18;
        return "FAST";
    L18:
        if (o != 8) goto L22;
        return "DEEP_BUFFER";
    L22:
        if (o != 16) goto L26;
        return "COMPRESS_OFFLOAD";
    L26:
        if (o != 32) goto L30;
        return "NON_BLOCKING";
    L30:
        if (o != 64) goto L34;
        return "HW_AV_SYNC";
    L34:
        if (o != 128) goto L38;
        return "TTS";
    L38:
        if (o != 256) goto L42;
        return "RAW";
    L42:
        if (o != 512) goto L46;
        return "SYNC";
    L46:
        if (o != 1024) goto L50;
        return "IEC958_NONAUDIO";
    L50:
        if (o != 8192) goto L54;
        return "DIRECT_PCM";
    L54:
        if (o != 16384) goto L58;
        return "MMAP_NOIRQ";
    L58:
        if (o != 32768) goto L62;
        return "VOIP_RX";
    L62:
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("NONE");
        if ((o & 1) != 1) goto L6;
        list.add("DIRECT");
        flipped = 0 | 1;
    L6:
        if ((o & 2) != 2) goto L9;
        list.add("PRIMARY");
        flipped = flipped | 2;
    L9:
        if ((o & 4) != 4) goto L12;
        list.add("FAST");
        flipped = flipped | 4;
    L12:
        if ((o & 8) != 8) goto L15;
        list.add("DEEP_BUFFER");
        flipped = flipped | 8;
    L15:
        if ((o & 16) != 16) goto L18;
        list.add("COMPRESS_OFFLOAD");
        flipped = flipped | 16;
    L18:
        if ((o & 32) != 32) goto L21;
        list.add("NON_BLOCKING");
        flipped = flipped | 32;
    L21:
        if ((o & 64) != 64) goto L24;
        list.add("HW_AV_SYNC");
        flipped = flipped | 64;
    L24:
        if ((o & 128) != 128) goto L27;
        list.add("TTS");
        flipped = flipped | 128;
    L27:
        if ((o & 256) != 256) goto L30;
        list.add("RAW");
        flipped = flipped | 256;
    L30:
        if ((o & 512) != 512) goto L33;
        list.add("SYNC");
        flipped = flipped | 512;
    L33:
        if ((o & 1024) != 1024) goto L36;
        list.add("IEC958_NONAUDIO");
        flipped = flipped | 1024;
    L36:
        if ((o & 8192) != 8192) goto L39;
        list.add("DIRECT_PCM");
        flipped = flipped | 8192;
    L39:
        if ((o & 16384) != 16384) goto L42;
        list.add("MMAP_NOIRQ");
        flipped = flipped | 16384;
    L42:
        if ((o & 32768) != 32768) goto L44;
        list.add("VOIP_RX");
        flipped = flipped | 32768;
    L44:
        if (o == flipped) goto L47;
        list.add("0x" + Integer.toHexString((~flipped) & o));
    L47:
        return String.join(" | ", list);
    }
}
